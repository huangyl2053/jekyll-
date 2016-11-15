/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020070;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.jigyobunshikyugakurenrakuhyo.JigyobunShikyugakuRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc020070.JigyobunShikyugakuKeisanProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc020070.GassanJigyobunShikyugakuKeisanKekkaIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanjigyobunkekkaichiran.GassanJigyobunKekkaIchiranSource;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算の支給額計算結果を取得する処理クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
public class GogakuGassanShikyugakuCalcResultProcess extends BatchProcessBase<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc020070."
            + "IJigyobunShikyugakuKeisanMapper.get高額合算の支給額計算結果");
    private static final RString TABLE_NAME = new RString("ShikyugakuCalcTemp");
    private static final RString 区分1 = new RString(1);
    private static final RString 一覧EUCエンティティID = new RString("DBC200204");
    private static final RString 該当データ無し = new RString("該当データ無し");
    private static final RString CSV_FILE_NAME = new RString("DBC900001_KokuhorenDataTorikomiKekkaIchiran.csv");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private List<RString> breakItemIds;

    /**
     * 送付対象データ取得です。
     */
    public static final RString PARAMETER_OUT_FLOWFLAG;

    static {
        PARAMETER_OUT_FLOWFLAG = new RString("dataFlag");
    }
    private OutputParameter<Boolean> dataFlag;

    private JigyobunShikyugakuKeisanProcessParameter parameter;
    private boolean hasData;

    private FileSpoolManager manager;
    private IOutputOrder 出力順;
    private RString 自市町村コード;
    private RString 自市町村名;

    private BatchReportWriter<GassanJigyobunKekkaIchiranSource> batchReportWriter;
    private ReportSourceWriter<GassanJigyobunKekkaIchiranSource> reportSourceWriter;

    private CsvWriter<GassanJigyobunShikyugakuKeisanKekkaIchiranEntity> csvWriter;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        breakItemIds = new ArrayList<>();
        hasData = false;
        dataFlag = new OutputParameter<>();
        出力順 = ReportUtil.get出力順ID(SubGyomuCode.DBC介護給付, parameter.get出力順ID(), ReportIdDBC.DBC200204.getReportId());
        if (null == 出力順) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        自市町村コード = AssociationFinderFactory.createInstance().getAssociation().get地方公共団体コード().code市町村RString();
        自市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, ShikyugakuCalcTempEntity.class);
    }

    @Override
    protected void process(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        hasData = true;
        ShikyugakuCalcTempEntity tempEntity = new ShikyugakuCalcTempEntity();
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setTaishoNendo(entity.getTaishoNendo());
        tempEntity.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setShikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        tempEntity.setKubun(区分1);
        tempEntity.setShikyugaku_hihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setShikyugaku_taishoNendo(entity.getTaishoNendo());
        tempEntity.setShikyugaku_shoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        tempEntity.setShikyugaku_shikyuShinseishoSeiriNo(entity.getShikyuShinseishoSeiriNo());
        tempEntity.setShikyugaku_rirekiNo(entity.getRirekiNo());
        tempEntity.setShikyugaku_hokenSeidoCode(entity.getHokenSeidoCode());
        tempEntity.setShikyugaku_jikoFutanSeiriNo(entity.getJikoFutanSeiriNo());
        tempEntity.setShikyugaku_taishoKeisanKaishiYMD(entity.getTaishoKeisanKaishiYMD());
        tempEntity.setShikyugaku_taishoKeisanShuryoYMD(entity.getTaishoKeisanShuryoYMD());
        tempEntity.setShikyugaku_setaiFutanSogaku(entity.getSetaiFutanSogaku());
        tempEntity.setShikyugaku_setaiGassanGaku(entity.getSetaiGassanGaku());
        tempEntity.setShikyugaku_over70_SetaiGassanGaku(entity.getOver70_SetaiGassanGaku());
        tempEntity.setShikyugaku_shotokuKubun(entity.getShotokuKubun());
        tempEntity.setShikyugaku_over70_ShotokuKubun(entity.getOver70_ShotokuKubun());
        tempEntity.setShikyugaku_santeiKijunGaku(entity.getSanteiKijunGaku());
        tempEntity.setShikyugaku_over70_SanteiKijyunGaku(entity.getOver70_SanteiKijyunGaku());
        tempEntity.setShikyugaku_setaiShikyuSogaku(entity.getSetaiShikyuSogaku());
        tempEntity.setShikyugaku_over70_SetaiShikyuSogaku(entity.getOver70_SetaiShikyuSogaku());
        tempEntity.setShikyugaku_honninShikyugaku(entity.getHonninShikyugaku());
        tempEntity.setShikyugaku_over70_honninShikyugaku(entity.getOver70_honninShikyugaku());
        tempEntity.setShikyugaku_teiShotoku_1_SaiKeisanUmu(entity.getTeiShotoku_1_SaiKeisanUmu());
        tempEntity.setShikyugaku_biko(entity.getBiko());
        tempEntity.setShikyugaku_kekkaRenrakusakiYubinNo(entity.getKekkaRenrakusakiYubinNo());
        tempEntity.setShikyugaku_kekkaRenrakusakiJusho(entity.getKekkaRenrakusakiJusho());
        tempEntity.setShikyugaku_kekkaRenrakusakiMeisho2(entity.getKekkaRenrakusakiMeisho2());
        tempEntity.setShikyugaku_kettaRenrakusakiMeisho1(entity.getKetteRenrakusakiMeisho1());
        tempEntity.setShikyugaku_tsuchiYMD(entity.getTsuchiYMD());
        tempEntity.setShikyugaku_renrakuhyoHakkoshaMei(entity.getRenrakuhyoHakkoshaMei());
        tempEntity.setShikyugaku_renrakuhyoHakkoshaYubinNo(entity.getRenrakuhyoHakkoshaYubinNo());
        tempEntity.setShikyugaku_renrakuhyoHakkoshaJusho(entity.getRenrakuhyoHakkoshaJusho());
        tempEntity.setShikyugaku_toiawasesakiYobinNo(entity.getToiawasesakiYobinNo());
        tempEntity.setShikyugaku_toiawasesakiJusho(entity.getToiawasesakiJusho());
        tempEntity.setShikyugaku_toiawasesakiMeisho1(entity.getToiawasesakiMeisho1());
        tempEntity.setShikyugaku_toiawasesakiMeisho2(entity.getToiawasesakiMeisho2());
        tempEntity.setShikyugaku_toiawasesakiTelNo(entity.getToiawasesakiTelNo());
        tempEntity.setShikyugaku_over70_FutangakuGokei(entity.getOver70_FutangakuGokei());
        tempEntity.setShikyugaku_over70_ShikyugakuGokei(entity.getOver70_ShikyugakuGokei());
        tempEntity.setShikyugaku_under70_FutangakuGokei(entity.getUnder70_FutangakuGokei());
        tempEntity.setShikyugaku_under70_ShikyugakuGokei(entity.getUnder70_ShikyugakuGokei());
        tempEntity.setShikyugaku_futangakuGokei(entity.getFutangakuGokei());
        tempEntity.setShikyugaku_shikyugakuGokei(entity.getShikyugakuGokei());
        tempEntity.setShikyugaku_dataKubun(entity.getDataKubun());
        tempEntity.setShikyugaku_uketoriYM(entity.getUketoriYM());
        tempEntity.setShikyugaku_sofuYM(entity.getSofuYM());
        tempEntity.setShikyugaku_saisoFG(entity.getSaisoFG());
        tempEntity.setShikyugaku_sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(entity.getSikyugakuKeisanKekkaRenrakuhyoSakuseiYMD());
        tempEntity.setState(EntityDataState.Added);
        tempDbWriter.insert(tempEntity);
    }

    @Override
    protected void afterExecute() {
        dataFlag.setValue(hasData);
        if (!hasData) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
            csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(manager.getEucOutputDirectry(), CSV_FILE_NAME)).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(true).
                    build();
            GassanJigyobunShikyugakuKeisanKekkaIchiranEntity csvEntity = new GassanJigyobunShikyugakuKeisanKekkaIchiranEntity();
            csvEntity.set氏名(該当データ無し);
            csvWriter.writeLine(csvEntity);
            csvWriter.close();
            manager.spool(CSV_FILE_NAME);

            JigyobunShikyugakuRenrakuhyo param = new JigyobunShikyugakuRenrakuhyo();
            param.set出力対象区分(parameter.get出力対象区分());
            param.set受取年月(parameter.get受取年月());
            param.set年度(parameter.get年度());
            param.set被保険者番号(parameter.get被保険者番号());
            param.set市町村名(自市町村名);
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200204.getReportId().value()).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            GassanJigyobunKekkaIchiranReport report = new GassanJigyobunKekkaIchiranReport(param, 出力順, 自市町村コード, breakItemIds);
            report.writeBy(reportSourceWriter);
            batchReportWriter.close();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranParamter;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.ShinseishoHakkoIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 申請書発行一覧表の発行処理です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class ShinseishoHakoIchiranhyoOutputProcess extends BatchProcessBase<ShinseiJohoChohyoTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get申請書発行一覧表");
    private static final RString CSV_FILE_NAME = new RString("KogakuServiceHiShinseishoHakkoIchiran");
    private static final RString CSV = new RString(".csv");
    private static final RString UNDER_LINE = new RString("_");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一覧EUCエンティティID = new RString("DBC200017");
    private static final RString ORDER_BY = new RString("order by");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    @BatchWriter
    private BatchReportWriter<KogakuShikyuShinseishoHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuShikyuShinseishoHakkoIchiranSource> reportSourceWriter;

    private RString csvFileName;
    private FileSpoolManager manager;
    private IOutputOrder 出力順;
    private List<RString> breakItemIds;
    private RDateTime システム日付;

    private int count;
    @BatchWriter
    private CsvWriter<ShinseishoHakkoIchiranhyoCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        count = 1;
        システム日付 = RDateTime.now();
        breakItemIds = new ArrayList<>();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();

        csvFileName = CSV_FILE_NAME.concat(UNDER_LINE).
                concat(導入団体クラス.get地方公共団体コード().value()).concat(UNDER_LINE).
                concat(parameter.getSakuseibi().toString()).concat(CSV);
        出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100011.getReportId(), parameter.getShutsuryokujunId());
        if (出力順 != null) {
            parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                    KogakuShikyuShinseishoHakkoIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
            for (ISetSortItem item : 出力順.get設定項目リスト()) {
                if (item.is改頁項目()) {
                    breakItemIds.add(item.get項目ID());
                }
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200017.getReportId().value()).
                addBreak(new KogakuShikyuShinseishoHakkoIchiranPageBreak(breakItemIds)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, 一覧EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        csvWriter = new CsvWriter.InstanceBuilder(Path.combinePath(manager.getEucOutputDirectry(), csvFileName)).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(ShinseiJohoChohyoTempRelateEntity entity) {
        KogakuJigyoShinseishoHakkoIchiranParamter param = new KogakuJigyoShinseishoHakkoIchiranParamter();
        param.set帳票出力対象データ(entity.get申請情報());
        param.set出力順(出力順);
        param.set連番(new RString(count));
        param.setシステム日付(システム日付);
        param.set市町村名(entity.get市町村名称());
        KogakuShikyuShinseishoHakkoIchiranReport report = new KogakuShikyuShinseishoHakkoIchiranReport(param);
        report.writeBy(reportSourceWriter);

        csvWriter.writeLine(new ShinseishoHakkoIchiranhyoCsvEntity(
                RDate.getNowDate().toDateString(),
                new RString(count),
                entity.get申請情報().getHihokenshaNoChohyo().value(),
                entity.get申請情報().getServiceTeikyoYMChohyo().toDateString(),
                get名称(entity.get申請情報().getMeishoChohyo()),
                get郵便番号(entity.get申請情報().getYubinNoChohyo()),
                get住所(entity.get申請情報().getJushoChohyo()),
                get行政区コード(entity.get申請情報().getGyoseikuCodeChohyo()),
                entity.get申請情報().getGyoseikuNameChohyo(),
                new RString(String.valueOf(entity.get申請情報().isKyuSochishaFlagChohyo())),
                get要介護状態区分(entity.get申請情報().getYokaigoJotaiKubunCodeChohyo()),
                getYMD(entity.get申請情報().getNinteiYukoKikanKaishiYMDChohyo()),
                getYMD(entity.get申請情報().getNinteiYukoKikanShuryoYMDChohyo()),
                get金額(entity.get申請情報().getHonninShiharaiGakuChohyo()),
                get金額(entity.get申請情報().getShikyuKingakuChohyo()),
                new RString(String.valueOf(entity.get申請情報().isHojinKeigenTaishoFlagChohyo())),
                new RString(String.valueOf(entity.get申請情報().isJidoShokanTaishoFlagChohyo())),
                entity.get申請情報().getShikakuSoshitsuJiyuCodeChohyo())
        );

        count = count + 1;
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        manager.spool(SubGyomuCode.DBC介護給付, csvFileName);
    }

    private RString get名称(AtenaMeisho meisho) {
        if (meisho == null) {
            return RString.EMPTY;
        }
        return meisho.value();
    }

    private RString get郵便番号(YubinNo yubinNo) {
        if (yubinNo == null) {
            return RString.EMPTY;
        }
        return yubinNo.getEditedYubinNo();
    }

    private RString get住所(AtenaJusho jusho) {
        if (jusho == null) {
            return RString.EMPTY;
        }
        return jusho.getColumnValue();
    }

    private RString get行政区コード(GyoseikuCode gyoseikuCode) {
        if (gyoseikuCode == null) {
            return RString.EMPTY;
        }
        return gyoseikuCode.getColumnValue();
    }

    private RString get要介護状態区分(Code yokaigoJotaiKubunCode) {
        if (yokaigoJotaiKubunCode == null) {
            return RString.EMPTY;
        }
        return yokaigoJotaiKubunCode.getKey();
    }

    private RString getYMD(FlexibleDate ymd) {
        if (ymd == null) {
            return RString.EMPTY;
        }
        return new RString(ymd.toString());
    }

    private RString get金額(Decimal kinGaku) {
        if (kinGaku == null) {
            return RString.EMPTY;
        }
        return new RString(kinGaku.toString());
    }

}

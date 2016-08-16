/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranParamter;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshinseishohakkoichiran.KogakuJigyoShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.JigyoShinseishoHakkoIchiranhyoCsvEntity;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyoshinseishohakkoichiransource.KogakuJigyoShinseishoHakkoIchiranSource;
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
public class JigyoShinseishoHakoIchiranhyoOutputProcess extends BatchProcessBase<ShinseiJohoChohyoTempEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.get申請書発行一覧表");
    private static final RString ORDER_BY = new RString("order by");
    private static final RString CSV_FILE_NAME = new RString("KogakuJigyoServiceHiShinseishoHakkoIchiran");
    private static final RString CSV = new RString(".csv");
    private static final RString UNDER_LINE = new RString("_");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 一覧EUCエンティティID = new RString("JigyoShinseishoHakkoIchiranhyoCsvEntity");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    private RString csvFileName;
    private List<RString> breakItemIds;
    private FileSpoolManager manager;
    private IOutputOrder 出力順;
    private RString 市町村名;
    private RDateTime システム日付;

    private int count;
    @BatchWriter
    private BatchReportWriter<KogakuJigyoShinseishoHakkoIchiranSource> batchReportWriter;
    private ReportSourceWriter<KogakuJigyoShinseishoHakkoIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<JigyoShinseishoHakkoIchiranhyoCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        count = 1;
        システム日付 = RDateTime.now();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        市町村名 = 導入団体クラス.get市町村名();

        csvFileName = CSV_FILE_NAME.concat(UNDER_LINE).
                concat(導入団体クラス.getLasdecCode_().value()).concat(UNDER_LINE).
                concat(RDate.getNowDate().toDateString()).concat(CSV);
        breakItemIds = new ArrayList<>();
        出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200091.getReportId(), parameter.getShutsuryokujunId());
        if (出力順 != null) {
            // TODO QA.1160 出力順の項目に、町域コードと氏名５０音カナはありません
            parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                    KogakuJigyoShinseishoHakkoIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
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
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200091.getReportId().value())
                .addBreak(new KogakuJigyoShinseishoHakkoIchiranPageBreak(breakItemIds)).create();
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
    protected void process(ShinseiJohoChohyoTempEntity entity) {
        KogakuJigyoShinseishoHakkoIchiranParamter param = new KogakuJigyoShinseishoHakkoIchiranParamter();
        param.set帳票出力対象データ(entity);
        param.set出力順(出力順);
        param.set連番(new RString(count));
        param.setシステム日付(システム日付);
        param.set市町村名(市町村名);
        KogakuJigyoShinseishoHakkoIchiranReport report = new KogakuJigyoShinseishoHakkoIchiranReport(param);
        report.writeBy(reportSourceWriter);

        csvWriter.writeLine(new JigyoShinseishoHakkoIchiranhyoCsvEntity(
                RDate.getNowDate().toDateString(),
                new RString(count),
                entity.getHihokenshaNoChohyo().value(),
                entity.getServiceTeikyoYMChohyo().toDateString(),
                get名称(entity.getMeishoChohyo()),
                get郵便番号(entity.getYubinNoChohyo()),
                get住所(entity.getJushoChohyo()),
                get行政区コード(entity.getGyoseikuCodeChohyo()),
                entity.getGyoseikuNameChohyo(),
                new RString(String.valueOf(entity.isKyuSochishaFlagChohyo())),
                get要介護状態区分(entity.getYokaigoJotaiKubunCode()),
                getYMD(entity.getNinteiYukoKikanKaishiYMDChohyo()),
                getYMD(entity.getNinteiYukoKikanShuryoYMDChohyo()),
                get金額(entity.getHonninShiharaiGakuChohyo()),
                get金額(entity.getShikyuKingakuChohyo()),
                new RString(String.valueOf(entity.isHojinKeigenTaishoFlagChohyo())),
                new RString(String.valueOf(entity.isJidoShokanTaishoFlagChohyo())),
                entity.getShikakuSoshitsuJiyuCodeChohyo())
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

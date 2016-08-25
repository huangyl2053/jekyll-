/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchoheijunka6tsuchishoikatsuhako.Dbb100012MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranForBatchReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.KariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiTsuchiShoKyotsuKomokuHenshu;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.ShutsuRyokuTaishoShutokuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KariSanteigakuHenkoTsuchishoHakkoIchiranData;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100013.KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 「帳票の発行」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TsuchishoHakoA4TypeProcess extends BatchProcessBase<KarisanteiGakuHenkoEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.select出力対象情報");
    private TsuchishoHakoProcessParameter parameter;
    private static final ReportId 帳票分類ID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    @BatchWriter
    private BatchReportWriter<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> batchReportWriterA4;
    private ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoA4TateReportSource> reportSourceWriterA4;
    @BatchWriter
    private BatchReportWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> batchReportWriterIchiran;
    private ReportSourceWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> reportSourceWriterIchiran;

    private EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書;
    private TsuchishoNo 通知書番号;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通情報;
    private Association association;
    private TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko service;
    private CompKaigoToiawasesakiSource kaigoToiawasesakiSource;
    private NinshoshaSource ninshoshaSource;
    private IOutputOrder outputOrder;

    int 連番 = 1;
    Decimal 通知書ページ数;
    Decimal 通知書一覧ページ数;
    private KariSanteigakuHenkoTsuchishoHakkoIchiranData csvData;
    private CsvWriter csvWriter;
    private boolean csv有無;
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private static final RString ファイル名 = new RString("TokuChoHeijunkaKariSanteigakuHenkoTsuchishoHakkoIchiranData.csv");
    private static final RString EUCファイル名 = new RString("TokuChoHeijunkaTsuchishoHakkoIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200004"));
    private FileSpoolManager manager;

    @Override
    protected void initialize() {
        通知書ページ数 = Decimal.ZERO;
        通知書一覧ページ数 = Decimal.ZERO;
        service = TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko.createInstance();
    }

    @Override
    protected IBatchReader createReader() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID_DBB100012, Long.parseLong(parameter.get出力順ID().toString()));

        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = Dbb100012MyBatisOrderByClauseCreator.
                    create(TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty.DBB100012ShutsuryokujunEnum.class, outputOrder);
        }
        return new BatchDbReader(MAPPERPATH, new ShutsuRyokuTaishoShutokuMyBatisParameter(出力順, parameter.get出力対象区分()));
    }

    @Override
    protected void createWriter() {
        batchReportWriterA4 = BatchReportFactory.
                createBatchReportWriter(ReportIdDBB.DBB100013.getReportId().getColumnValue(), SubGyomuCode.DBB介護賦課).create();
        reportSourceWriterA4 = new ReportSourceWriter(batchReportWriterA4);

        List pageBreakKeys = new ArrayList<>();
        service.set改頁Key(outputOrder, pageBreakKeys);

        if (!pageBreakKeys.isEmpty()) {
            batchReportWriterIchiran = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBB.DBB200004.getReportId().getColumnValue(), SubGyomuCode.DBB介護賦課)
                    .addBreak(new BreakerCatalog<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriterIchiran = BatchReportFactory.
                    createBatchReportWriter(ReportIdDBB.DBB200004.getReportId().getColumnValue(), SubGyomuCode.DBB介護賦課).create();
        }
        reportSourceWriterIchiran = new ReportSourceWriter(batchReportWriterIchiran);
    }

    @Override
    protected void beforeExecute() {
        帳票制御共通情報 = service.find帳票制御共通情報();
        association = AssociationFinderFactory.createInstance().getAssociation();
        kaigoToiawasesakiSource = KaigoToiawasesakiSourceBuilderCreator
                .create(SubGyomuCode.DBB介護賦課, 帳票分類ID_DBB100012).buildSource();

        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBB介護賦課, 帳票分類ID_DBB100012,
                parameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriterA4);

        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID_DBB100012, Long.parseLong(parameter.get出力順ID().toString()));

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        RString tempPathName = Path.combinePath(spoolWorkPath, ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(tempPathName).canAppend(false)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.UTF_8withBOM).setNewLine(NewLine.CRLF)
                .hasHeader(true).build();
    }

    @Override
    protected void process(KarisanteiGakuHenkoEntity entity) {
        通知書番号 = entity.get更正後計算後情報().getTsuchishoNo();
        if (通知書番号 == null || 通知書番号.isEmpty()) {
            return;
        }

        編集後仮算定通知書 = null;
        KariSanteiTsuchiShoKyotsu 仮算定額変更通知書情報 = service.仮算定額変更通知書情報の作成(parameter, entity, 帳票制御共通情報, association);
        KariSanteiTsuchiShoKyotsuKomokuHenshu henshuService = new KariSanteiTsuchiShoKyotsuKomokuHenshu();
        編集後仮算定通知書 = henshuService.create仮算定通知書共通情報(仮算定額変更通知書情報);
        if (編集後仮算定通知書 == null) {
            return;
        }
        service.set普徴と特徴(編集後仮算定通知書, entity);
        TokuChoHeijunkaKariSanteigakuHakkoIchiranForBatchReport ichiranReport = new TokuChoHeijunkaKariSanteigakuHakkoIchiranForBatchReport(
                編集後仮算定通知書, outputOrder, parameter.get帳票作成日時(), 連番);
        ichiranReport.writeBy(reportSourceWriterIchiran);
        csvData = service.csvData作成(編集後仮算定通知書, parameter, 連番, 通知書番号);
        csvWriter.writeLine(csvData);
        csv有無 = true;

        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        仮算定納入通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書);

        KarisanteiHenjunkaHenkoTsuchishoA4TateReport report = new KarisanteiHenjunkaHenkoTsuchishoA4TateReport(
                仮算定納入通知書情報, 通知書番号.getColumnValue(), ninshoshaSource, kaigoToiawasesakiSource);
        report.writeBy(reportSourceWriterA4);
        通知書ページ数 = 通知書ページ数.add(new Decimal(batchReportWriterA4.getPageCount()));
        連番++;
    }

    @Override
    protected void afterExecute() {
        通知書一覧ページ数.add(new Decimal(batchReportWriterIchiran.getPageCount()));

        service.代行プリント送付票の出力とバッチ条件の出力(csv有無, parameter, 帳票制御共通情報, association, outputOrder,
                通知書ページ数, 通知書一覧ページ数);

        csvWriter.close();
        if (csv有無) {
            manager.spool(EUCファイル名);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.tokuchoheijunka6tsuchishoikatsuhako;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchoheijunka6tsuchishoikatsuhako.Dbb100012MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReport;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6tsuchishoikatsuhako.ShutsuRyokuTaishoShutokuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheijunka6tsuchishoikatsuhako.TsuchishoHakoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KariSanteigakuHenkoTsuchishoHakkoIchiranData;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheijunka6tsuchishoikatsuhako.KarisanteiGakuHenkoEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb100012.KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbmn35003.dbb200004.TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.report.parts.kaigotoiawasesaki.CompKaigoToiawasesakiSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.service.report.parts.kaigotoiawasesaki.KaigoToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 「帳票の発行」処理です。
 *
 * @reamsid_L DBB-0820-030 xuyue
 */
public class TsuchishoHakoB5TypeProcess extends BatchProcessBase<KarisanteiGakuHenkoEntity> {

    @BatchWriter
    private BatchReportWriter<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> batchReportWriterB5;
    private ReportSourceWriter<KarisanteiHenjunkaHenkoTsuchishoB5YokoReportSource> reportSourceWriterB5;
    @BatchWriter
    private BatchReportWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> batchReportWriterIchiran;
    private ReportSourceWriter<TokuChoHeijunkaKariSanteigakuHakkoIchiranReportSource> reportSourceWriterIchiran;

    private TsuchishoHakoProcessParameter parameter;
    private static final ReportId 帳票分類ID_DBB100012 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "tokuchoheijunka6tsuchishoikatsuhako.ITokuchoHeijunka6gatsuTsuchishoIkatsuHakoMapper.select出力対象情報");

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
    List<EditedKariSanteiTsuchiShoKyotsu> reportDataList;
    List<KariSanteigakuHenkoTsuchishoHakkoIchiranData> csvDataList;

    @Override
    protected void initialize() {
        reportDataList = new ArrayList<>();
        csvDataList = new ArrayList<>();
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
        batchReportWriterB5 = BatchReportFactory.
                createBatchReportWriter(ReportIdDBB.DBB100012.getReportId().getColumnValue(), SubGyomuCode.DBB介護賦課).create();
        reportSourceWriterB5 = new ReportSourceWriter(batchReportWriterB5);

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
                parameter.get発行日(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriterB5);

        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID_DBB100012, Long.parseLong(parameter.get出力順ID().toString()));
    }

    @Override
    protected void process(KarisanteiGakuHenkoEntity entity) {
        通知書番号 = entity.get更正後計算後情報().getTsuchishoNo();
        if (通知書番号 == null || 通知書番号.isEmpty()) {
            return;
        }

        編集後仮算定通知書 = null;
        service.printTsuchisho(編集後仮算定通知書, entity, parameter, 帳票制御共通情報, association, reportDataList, csvDataList, 連番);
    }

    @Override
    protected void afterProcess() {

        KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報 = new KariSanteiNonyuTsuchiShoJoho();
        仮算定納入通知書情報.set編集後仮算定通知書共通情報(編集後仮算定通知書);

        KarisanteiHenjunkaHenkoTsuchishoB5YokoReport report = new KarisanteiHenjunkaHenkoTsuchishoB5YokoReport(
                仮算定納入通知書情報, 通知書番号.getColumnValue(), ninshoshaSource, kaigoToiawasesakiSource);
        report.writeBy(reportSourceWriterB5);
        通知書ページ数 = 通知書ページ数.add(new Decimal(batchReportWriterB5.getPageCount()));

        連番++;
    }

    @Override
    protected void afterExecute() {

        TokuChoHeijunkaKariSanteigakuHakkoIchiranReport report = new TokuChoHeijunkaKariSanteigakuHakkoIchiranReport(reportDataList,
                outputOrder, parameter.get帳票作成日時());
        report.writeBy(reportSourceWriterIchiran);
        通知書一覧ページ数.add(new Decimal(batchReportWriterIchiran.getPageCount()));

        service.csv出力と代行プリント送付票の出力とバッチ条件の出力(csvDataList, parameter, 帳票制御共通情報, association, outputOrder,
                通知書ページ数, 通知書一覧ページ数);
    }

}

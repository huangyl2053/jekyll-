package jp.co.ndensan.reams.db.dbu.service.report.bemmeisyo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoHeadItem;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoProperty;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoReport;
import jp.co.ndensan.reams.db.dbu.business.report.bemmeisyo.BemmeisyoReportJoho;
import jp.co.ndensan.reams.db.dbu.entity.report.bemmeisyo.BemmeisyoReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 弁明書Printerクラスです。
 */
public class BemmeisyoPrintService {

    /**
     * 弁明書を印刷します。
     *
     * @param reportJoho 弁明書作成_帳票パラメータクラス。
     * @return {@link BemmeisyoReport}
     */
    public SourceDataCollection print(BemmeisyoReportJoho reportJoho) {
        BemmeisyoProperty property = new BemmeisyoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<BemmeisyoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                BemmeisyoHeadItem headItem = new BemmeisyoHeadItem(
                        ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei,
                        // TODO 袁献輝　QA597、resファイルに認証者氏名がありません　2016/02/20。
                        //                        ninshoshaSourceBuilder.buildSource().ninshoshaShimei,
                        ninshoshaSourceBuilder.buildSource().denshiKoin,
                        ninshoshaSourceBuilder.buildSource().koinShoryaku,
                        ninshoshaSourceBuilder.buildSource().koinMojiretsu,
                        reportJoho.getHeadItem().getSofusakiYubinNo(),
                        reportJoho.getHeadItem().getSofusakiJusho(),
                        reportJoho.getHeadItem().getSofusakiName(),
                        reportJoho.getHeadItem().getMidashi(),
                        reportJoho.getHeadItem().getBemmeisyoSakuseiYMD(),
                        reportJoho.getHeadItem().getBemmeisyoName(),
                        reportJoho.getHeadItem().getBemmeiNaiyo(),
                        reportJoho.getHeadItem().getHihokenshaNo(),
                        reportJoho.getHeadItem().getHihokenshaName(),
                        reportJoho.getHeadItem().getBirthYMD(),
                        reportJoho.getHeadItem().getSeibetsu(),
                        reportJoho.getHeadItem().getHihokenshaYubinNo(),
                        reportJoho.getHeadItem().getHihokenshaJusho());
                for (BemmeisyoReport report : toReports(new BemmeisyoReportJoho(headItem))) {
                    ReportSourceWriter<BemmeisyoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportSourceWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<BemmeisyoReport> toReports(BemmeisyoReportJoho reportJoho) {
        List<BemmeisyoReport> list = new ArrayList<>();
        list.add(BemmeisyoReport.createFrom(
                reportJoho.getHeadItem()));
        return list;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}

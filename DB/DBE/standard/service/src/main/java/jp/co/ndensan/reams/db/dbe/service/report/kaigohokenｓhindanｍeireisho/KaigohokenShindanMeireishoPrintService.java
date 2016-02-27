/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.kaigohokenｓhindanｍeireisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReport;
import jp.co.ndensan.reams.db.dbe.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportJoho;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
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
 *
 * 介護保険診断命令書PrinterServiceクラスです。
 */
public class KaigohokenShindanMeireishoPrintService {

    /**
     * 介護保険診断命令書を印刷します。
     *
     * @param headItemlist 介護保険診断命令書作成_帳票パラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<KaigohokenShindanMeireishoHeaderItem> headItemlist) {
        KaigohokenShindanMeireishoProperty property = new KaigohokenShindanMeireishoProperty();

        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<KaigohokenShindanMeireishoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                for (KaigohokenShindanMeireishoHeaderItem headItem : headItemlist) {
                    headItem = new KaigohokenShindanMeireishoHeaderItem(
                            headItem.getShichosonMei(),
                            headItem.getShuchoMei(),
                            ninshoshaSourceBuilder.buildSource().koinShoryaku,
                            ninshoshaSourceBuilder.buildSource().denshiKoin,
                            ninshoshaSourceBuilder.buildSource().koinMojiretsu,
                            headItem.getBunshoNo(),
                            headItem.getHakkoYMD(),
                            headItem.getTsuchibun1(),
                            headItem.getTsuchibun2(),
                            headItem.getHihokenshaNo(),
                            headItem.getHihokenshaName(),
                            headItem.getIryokikanName(),
                            headItem.getTantoIshiName(),
                            headItem.getIryokikanJusho(),
                            headItem.getTelNo(),
                            headItem.getJushinKikan(),
                            headItem.getJushinArea(),
                            headItem.getTsuchibun3(),
                            headItem.getTsuchibun4(),
                            headItem.getTsuchibun5(),
                            headItem.getTsuchibun6(),
                            headItem.getTsuchibun7(),
                            headItem.getTsuchibun8(),
                            headItem.getTsuchibun9(),
                            headItem.getTsuchibun10(),
                            headItem.getTsuchibun11(),
                            headItem.getTsuchibun12(),
                            headItem.getTsuchibun13(),
                            headItem.getTsuchibun14(),
                            headItem.getTsuchibun15(),
                            headItem.getTsuchibun16(),
                            headItem.getTsuchibun17(),
                            headItem.getRemban()
                    );
                    for (KaigohokenShindanMeireishoReport report : toReports(new KaigohokenShindanMeireishoReportJoho(headItem))) {
                        ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                        report.writeBy(reportSourceWriter);
                    }
                }
            }
            return reportManager.publish();
        }
    }

    private static List<KaigohokenShindanMeireishoReport> toReports(KaigohokenShindanMeireishoReportJoho reportJoho) {
        List<KaigohokenShindanMeireishoReport> list = new ArrayList<>();
        list.add(KaigohokenShindanMeireishoReport.createFrom(reportJoho.getHeadItem()));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.kaigohokenshindanmeireisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoHeaderItem;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReport;
import jp.co.ndensan.reams.db.dbz.entity.report.kaigohokenshindanmeireisho.KaigohokenShindanMeireishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 介護保険診断命令書PrinterServiceクラスです。
 *
 * @reamsid_L DBE-0080-070 wangxiaodong
 */
public class KaigohokenShindanMeireishoPrintService {

    /**
     * 介護保険診断命令書を印刷します。
     *
     * @param headItemlist 介護保険診断命令書作成_帳票パラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(KaigohokenShindanMeireishoHeaderItem headItemlist) {
        KaigohokenShindanMeireishoProperty property = new KaigohokenShindanMeireishoProperty();
        return new Printer<KaigohokenShindanMeireishoReportSource>().spool(property, toReports(headItemlist));
//        try (ReportManager reportManager = new ReportManager()) {
//            try (ReportAssembler<KaigohokenShindanMeireishoReportSource> assembler = createAssembler(property, reportManager)) {
//                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
//                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
//                        RDate.getNowDate(), assembler.getImageFolderPath());
//                List<KaigohokenShindanMeireishoHeaderItem> itemList = new ArrayList<>();
//                for (KaigohokenShindanMeireishoHeaderItem headItem : headItemlist) {
//                    headItem = new KaigohokenShindanMeireishoHeaderItem(
//                            headItem.getShichosonMei(),
//                            headItem.getShuchoMei(),
//                            ninshoshaSourceBuilder.buildSource().koinShoryaku,
//                            ninshoshaSourceBuilder.buildSource().denshiKoin,
//                            ninshoshaSourceBuilder.buildSource().koinMojiretsu,
//                            headItem.getBunshoNo(),
//                            headItem.getHakkoYMD(),
//                            headItem.getTsuchibun1(),
//                            headItem.getTsuchibun2(),
//                            headItem.getHihokenshaNo(),
//                            headItem.getHihokenshaName(),
//                            headItem.getIryokikanName(),
//                            headItem.getTantoIshiName(),
//                            headItem.getIryokikanJusho(),
//                            headItem.getTelNo(),
//                            headItem.getJushinKikan(),
//                            headItem.getJushinArea(),
//                            headItem.getTsuchibun3(),
//                            headItem.getTsuchibun4(),
//                            headItem.getTsuchibun5(),
//                            headItem.getTsuchibun6(),
//                            headItem.getTsuchibun7(),
//                            headItem.getTsuchibun8(),
//                            headItem.getTsuchibun9(),
//                            headItem.getTsuchibun10(),
//                            headItem.getTsuchibun11(),
//                            headItem.getTsuchibun12(),
//                            headItem.getTsuchibun13(),
//                            headItem.getTsuchibun14(),
//                            headItem.getTsuchibun15(),
//                            headItem.getTsuchibun16(),
//                            headItem.getTsuchibun17(),
//                            headItem.getRemban()
//                    );
//                    itemList.add(headItem);
//                }
//                for (KaigohokenShindanMeireishoReport report : toReports(itemList)) {
//                    ReportSourceWriter<KaigohokenShindanMeireishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
//                    report.writeBy(reportSourceWriter);
//                }
//            }
//            return reportManager.publish();
//        }
    }

    private static List<KaigohokenShindanMeireishoReport> toReports(KaigohokenShindanMeireishoHeaderItem item) {
        List<KaigohokenShindanMeireishoReport> list = new ArrayList<>();
        List<KaigohokenShindanMeireishoHeaderItem> listItem = new ArrayList<>();
        listItem.add(item);
        list.add(KaigohokenShindanMeireishoReport.createFrom(listItem));
        return list;
    }

//    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
//            IReportProperty<T> property, ReportManager manager) {
//        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
//        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
//            builder.addBreak(breaker);
//        }
//        builder.isHojinNo(property.containsHojinNo());
//        builder.isKojinNo(property.containsKojinNo());
//        return builder.<T>create();
//    }
}

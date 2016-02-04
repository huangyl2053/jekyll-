/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shinsakaiiinwaritsuke;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiItem;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaiiinwaritsuke.ShinsaschedulekagamiReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaiiinwaritsuke.ShinsaschedulekagamiReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
 * 介護認定審査会スケジュール表かがみPrinterです。
 */
public class ShinsaschedulekagamiPrintService {

    /**
     * 介護認定審査会スケジュール表かがみを印刷します。
     *
     * @param itemList 介護認定審査会スケジュール表かがみ作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShinsaschedulekagamiItem> itemList) {
        ShinsaschedulekagamiProperty property = new ShinsaschedulekagamiProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShinsaschedulekagamiReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder builder = builderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                for (ShinsaschedulekagamiReport report : toReports(itemList, builder.buildSource())) {
                    ReportSourceWriter<ShinsaschedulekagamiReportSource> reportWriter = new ReportSourceWriter(assembler);
                    report.writeBy(reportWriter);
                }
            }
            return reportManager.publish();
        }
    }

    private static List<ShinsaschedulekagamiReport> toReports(
            List<ShinsaschedulekagamiItem> itemList, NinshoshaSource ninshoshaSource) {
        List<ShinsaschedulekagamiReport> list = new ArrayList<>();
        List<ShinsaschedulekagamiItem> newItemList = new ArrayList<>();
        for (ShinsaschedulekagamiItem item : itemList) {
            newItemList.add(setShinsaschedulekagamiItem(item, ninshoshaSource));
        }
        list.add(ShinsaschedulekagamiReport.createFrom(newItemList));
        return list;
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {

        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaks : property.breakers()) {
            builder.addBreak(breaks);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private static ShinsaschedulekagamiItem
            setShinsaschedulekagamiItem(ShinsaschedulekagamiItem item,
                    NinshoshaSource ninshoshaSource) {

        return new ShinsaschedulekagamiItem(
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.koinShoryaku,
                ninshoshaSource.denshiKoin,
                item.getTitle(),
                item.getTsuchibun1(),
                item.getShoriMikomiKaishiYMD(),
                item.getShoriMikomiShuryoYMD(),
                item.getTsuchibun2());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.shujiiikensho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoItem;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikensho.ShujiiIkenshoSakuseiIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikensho.ShujiiIkenshoSakuseiIraishoReportSource;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders.ReportSourceBuilders;
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
 * 主治医意見書作成依頼書PrinterServiceクラスです。
 *
 * @reamsid_L DBE-0050-020 sunhaidi
 */
public class ShujiiIkenshoSakuseiIraishoPrintService {

    /**
     * 主治医意見書作成依頼書を印刷します。
     *
     * @param itemlist 主治医意見書作成依頼書のITEMリストです。
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<ShujiiIkenshoSakuseiIraishoItem> itemlist) {
        ShujiiIkenshoSakuseiIraishoProperty property = new ShujiiIkenshoSakuseiIraishoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ShujiiIkenshoSakuseiIraishoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                int i = 1;
                for (ShujiiIkenshoSakuseiIraishoItem item : itemlist) {
                    item.setDenshiKoin(ninshoshaSourceBuilder.buildSource().denshiKoin);
                    item.setHakkoYMD1(ninshoshaSourceBuilder.buildSource().hakkoYMD);
                    item.setKoinMojiretsu(ninshoshaSourceBuilder.buildSource().koinMojiretsu);
                    item.setKoinShoryaku(ninshoshaSourceBuilder.buildSource().koinShoryaku);
                    item.setNinshoshaShimeiKakenai(ninshoshaSourceBuilder.buildSource().ninshoshaShimeiKakenai);
                    item.setNinshoshaShimeiKakeru(ninshoshaSourceBuilder.buildSource().ninshoshaShimeiKakeru);
                    item.setNinshoshaYakushokuMei(ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei);
                    item.setNinshoshaYakushokuMei1(ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei1);
                    item.setNinshoshaYakushokuMei2(ninshoshaSourceBuilder.buildSource().ninshoshaYakushokuMei2);
                    item.setTitle(ReportIdDBE.DBE230001.getReportName());
                    item.setRemban(new RString(String.valueOf(i++)));
                }
                ShujiiIkenshoSakuseiIraishoReport report = ShujiiIkenshoSakuseiIraishoReport.createFrom(itemlist);
                ReportSourceWriter<ShujiiIkenshoSakuseiIraishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
            return reportManager.publish();
        }
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

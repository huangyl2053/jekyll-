/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd550003;

import jp.co.ndensan.reams.db.dbd.business.report.dbd550003.YokaigodoHenkoTshuchishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd550003.YokaigodoHenkoTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteikekkatshuchishohakko.YokaigodoHenkoTsuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd550003.YokaigodoHenkoTshuchishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護度変更通知書
 *
 * @reamsid_L DBD-1430-050 b_zhengs
 */
public class YokaigodoHenkoTshuchishoService {

    /**
     * 帳票を出力
     *
     * @param entity YokaigodoHenkoTsuchishoEntity
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(YokaigodoHenkoTsuchishoEntity entity, ReportManager reportManager) {
        YokaigodoHenkoTshuchishoProperty property = new YokaigodoHenkoTshuchishoProperty();
        try (ReportAssembler<YokaigodoHenkoTshuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigodoHenkoTshuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            YokaigodoHenkoTshuchishoReport report = YokaigodoHenkoTshuchishoReport.createReport(entity);
            report.writeBy(reportSourceWriter);
        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

}

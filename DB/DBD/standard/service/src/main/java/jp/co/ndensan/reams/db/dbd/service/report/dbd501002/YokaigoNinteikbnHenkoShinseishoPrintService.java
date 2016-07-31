/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd501002;

import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.YokaigoNinteikbnHenkoShinseishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.YokaigoNinteikbnHenkoShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501002.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護認定区分変更申請書
 *
 * @reamsid_L DBD-1400-030 b_zhengs
 */
public class YokaigoNinteikbnHenkoShinseishoPrintService {

    /**
     * 帳票を出力
     *
     * @param entity ShinseiShoEntity
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(ShinseiShoEntity entity, ReportManager reportManager) {
        YokaigoNinteikbnHenkoShinseishoProperty property = new YokaigoNinteikbnHenkoShinseishoProperty();
        try (ReportAssembler<YokaigoNinteikbnHenkoShinseishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            YokaigoNinteikbnHenkoShinseishoReport report = YokaigoNinteikbnHenkoShinseishoReport.createReport(entity);
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

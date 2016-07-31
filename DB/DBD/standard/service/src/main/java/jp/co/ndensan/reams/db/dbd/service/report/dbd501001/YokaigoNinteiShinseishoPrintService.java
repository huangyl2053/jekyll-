/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd501001;

import jp.co.ndensan.reams.db.dbd.business.report.dbd501001.YokaigoNinteiShinseishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501001.YokaigoNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護認定申請書
 *
 * @reamsid_L DBD-1400-020 b_zhengs
 */
public class YokaigoNinteiShinseishoPrintService {

    /**
     * 帳票を出力
     *
     * @param entity ShinseiShoEntity
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(ShinseiShoEntity entity, ReportManager reportManager) {
        YokaigoNinteiShinseishoProperty property = new YokaigoNinteiShinseishoProperty();
        try (ReportAssembler<YokaigoNinteiShinseishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<YokaigoNinteiShinseishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            YokaigoNinteiShinseishoReport report = YokaigoNinteiShinseishoReport.createReport(entity);
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

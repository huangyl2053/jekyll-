/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.fukadaicho;

import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.EditedHonSanteiFukaDaichoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FukaDaichoProperty;
import jp.co.ndensan.reams.db.dbb.business.report.fukadaicho.FukaDaichoReport;
import jp.co.ndensan.reams.db.dbb.entity.report.fukadaicho.FukaDaichoSource;
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
 * 賦課台帳（本算定）帳票PrintService
 *
 * @reamsid_L DBB-9100-030 surun
 */
public class FukaDaichoPrintService {

    /**
     * printメソッド
     *
     * @param entity EditedHonSanteiFukaDaichoJoho
     * @param reportManager ReportManager
     */
    public void printSingle(EditedHonSanteiFukaDaichoJoho entity, ReportManager reportManager) {
        FukaDaichoProperty property = new FukaDaichoProperty();
        try (ReportAssembler<FukaDaichoSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<FukaDaichoSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new FukaDaichoReport(entity).writeBy(reportSourceWriter);
        }
    }

    /**
     * printメソッド
     *
     * @param entity EditedHonSanteiFukaDaichoJoho
     * @return SourceDataCollection
     */
    public SourceDataCollection print(EditedHonSanteiFukaDaichoJoho entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            printSingle(entity, reportManager);
            collection = reportManager.publish();
        }
        return collection;
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

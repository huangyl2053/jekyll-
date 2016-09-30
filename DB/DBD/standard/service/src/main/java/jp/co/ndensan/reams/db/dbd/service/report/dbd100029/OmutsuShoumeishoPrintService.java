/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100029;

import jp.co.ndensan.reams.db.dbd.business.report.dbd100029.OmutsuShoumeishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100029.OmutsuShoumeishoReport;
import jp.co.ndensan.reams.db.dbd.business.core.iryohikojokakuninsinsei.OmutsusiyoSyomeishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100029.OmutsuShoumeishoReportSource;
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
 * おむつ使用証明書帳票クラスです。
 *
 * @reamsid_L DBD-5780-030 donghj
 */
public class OmutsuShoumeishoPrintService {

    /**
     * printメソッド(単一帳票出力用)
     *
     * @param おむつ使用証明書Entity OmutsusiyoSyomeishoEntity
     * @return collection
     */
    public SourceDataCollection printSingle(OmutsusiyoSyomeishoEntity おむつ使用証明書Entity) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(reportManager, おむつ使用証明書Entity);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票を出力
     *
     * @param reportManager ReportManager
     * @param おむつ使用証明書Entity OmutsusiyoSyomeishoEntity
     */
    public void print(ReportManager reportManager, OmutsusiyoSyomeishoEntity おむつ使用証明書Entity) {
        OmutsuShoumeishoProperty property = new OmutsuShoumeishoProperty();
        try (ReportAssembler<OmutsuShoumeishoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<OmutsuShoumeishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            OmutsuShoumeishoReport report = new OmutsuShoumeishoReport(おむつ使用証明書Entity);
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

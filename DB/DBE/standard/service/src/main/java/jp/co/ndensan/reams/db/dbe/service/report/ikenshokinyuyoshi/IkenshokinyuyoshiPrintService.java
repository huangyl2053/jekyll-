/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi.IkenshokinyuyoshiProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi.IkenshokinyuyoshiReport;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 要介護認定主治医意見書記入用紙のPrinterです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiPrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public IkenshokinyuyoshiPrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 要介護認定主治医意見書記入用紙を印刷します。
     *
     * @param businessList 要介護認定主治医意見書記入用紙のBusinessList
     * @param id 帳票ID
     */
    public void print(List<IkenshokinyuyoshiBusiness> businessList, ReportId id) {
        List<IkenshokinyuyoshiReport> list = new ArrayList<>();
        IkenshokinyuyoshiProperty property = new IkenshokinyuyoshiProperty(id);
        try (ReportAssembler<IkenshokinyuyoshiReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<IkenshokinyuyoshiReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            list.add(toReports(businessList, id));
            for (IkenshokinyuyoshiReport report : list) {
                report.writeBy(reportSourceWriter);
            }
        }
        //return new Printer<IkenshokinyuyoshiReportSource>().spool(property, toReports(businessList, id));
    }

    private static IkenshokinyuyoshiReport toReports(List<IkenshokinyuyoshiBusiness> businessList, ReportId id) {
        return new IkenshokinyuyoshiReport(businessList, id);
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

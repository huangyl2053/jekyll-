/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshokinyuyoshioruka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01Property;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01Report;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02Property;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02Report;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshokinyuyoshioruka.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi01ReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshokinyuyoshioruka.Ikenshokinyuyoshi02ReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 主治医意見書（オルカ）のPrinterです。
 *
 * @reamsid_L DBE-1600-020 lishengli
 */
public class Ikenshokinyuyoshi01PrintService {

    private final ReportManager reportManager;

    /**
     * コンストラクタです。
     *
     * @param reportManager ReportManager
     */
    public Ikenshokinyuyoshi01PrintService(ReportManager reportManager) {
        this.reportManager = reportManager;
    }

    /**
     * 主治医意見書（オルカ）を出力します。
     *
     * @param business IkenshokinyuyoshiBusiness
     */
    public void print主治医意見書01(IkenshokinyuyoshiBusiness business) {
        List<Ikenshokinyuyoshi01Report> ryoumenReportList = new ArrayList<>();
        ryoumenReportList.add(new Ikenshokinyuyoshi01Report(business));
        Ikenshokinyuyoshi01Property ryoumenproperty = new Ikenshokinyuyoshi01Property();
        try (ReportAssembler<Ikenshokinyuyoshi01ReportSource> assembler = createAssembler(ryoumenproperty, reportManager)) {
            for (Ikenshokinyuyoshi01Report report : ryoumenReportList) {
                ReportSourceWriter<Ikenshokinyuyoshi01ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    /**
     * 主治医意見書（オルカ）を出力します。
     *
     * @param business IkenshokinyuyoshiBusiness
     */
    public void print主治医意見書02(IkenshokinyuyoshiBusiness business) {
        List<Ikenshokinyuyoshi02Report> ryoumenReportList = new ArrayList<>();
        ryoumenReportList.add(new Ikenshokinyuyoshi02Report(business));
        Ikenshokinyuyoshi02Property ryoumenproperty = new Ikenshokinyuyoshi02Property();
        try (ReportAssembler<Ikenshokinyuyoshi02ReportSource> assembler = createAssembler(ryoumenproperty, reportManager)) {
            for (Ikenshokinyuyoshi02Report report : ryoumenReportList) {
                ReportSourceWriter<Ikenshokinyuyoshi02ReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
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

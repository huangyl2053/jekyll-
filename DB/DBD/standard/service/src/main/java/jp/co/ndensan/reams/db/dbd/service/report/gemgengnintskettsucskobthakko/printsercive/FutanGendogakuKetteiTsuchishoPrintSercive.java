/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.printsercive;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.futangendogakuketteitsuchisho.FutanGendogakuKetteiTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.futangendogakuketteitsuchisho.FutanGendogakuKetteiTsuchishoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.gemgengnintskettsucskobthakko.futangendogakuketteitsuchisho.FutanGendogakuKetteiTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.futangendogakuketteitsuchisho.FutanGendogakuKetteiTsuchishoReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 負担限度額決定通知書のReportSource
 *
 * @reamsid_L DBD-3540-050 wangchao
 */
public class FutanGendogakuKetteiTsuchishoPrintSercive {

    /**
     * 帳票を出力
     *
     * @param targets パラメータ
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<FutanGendogakuKetteiTsuchishoItem> targets, ReportManager reportManager) {
        FutanGendogakuKetteiTsuchishoProerty property = new FutanGendogakuKetteiTsuchishoProerty();
        try (ReportAssembler<FutanGendogakuKetteiTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            for (FutanGendogakuKetteiTsuchishoReport report : toReports(targets)) {
                ReportSourceWriter<FutanGendogakuKetteiTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private static List<FutanGendogakuKetteiTsuchishoReport> toReports(List<FutanGendogakuKetteiTsuchishoItem> targets) {
        List<FutanGendogakuKetteiTsuchishoReport> list = new ArrayList();
        for (FutanGendogakuKetteiTsuchishoItem item : targets) {
            item.set編集後宛先(JushoHenshu.create編集後宛先(item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()));
            list.add(FutanGendogakuKetteiTsuchishoReport.createReport(item));
        }
        return list;
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

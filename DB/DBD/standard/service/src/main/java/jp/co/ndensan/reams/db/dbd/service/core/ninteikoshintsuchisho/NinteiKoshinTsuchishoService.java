/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.ninteikoshintsuchisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.NinteiKoshinTsuchishoItem;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.NinteiKoshinTsuchishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.NinteiKoshinTsuchishoReport;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100008.NinteiKoshinTsuchishoReportSource;
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
 * 負担限度額認定更新のお知らせ通知書。
 *
 * @reamsid_L DBD-3570-040 liangbc
 */
public class NinteiKoshinTsuchishoService {

    /**
     * 帳票を出力
     *
     * @param targets パラメータ
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<NinteiKoshinTsuchishoItem> targets, ReportManager reportManager) {
        NinteiKoshinTsuchishoProperty property = new NinteiKoshinTsuchishoProperty();
        try (ReportAssembler<NinteiKoshinTsuchishoReportSource> assembler = createAssembler(property, reportManager)) {
            for (NinteiKoshinTsuchishoReport report : toReports(targets)) {
                ReportSourceWriter<NinteiKoshinTsuchishoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
                report.writeBy(reportSourceWriter);
            }
        }
    }

    private static List<NinteiKoshinTsuchishoReport> toReports(List<NinteiKoshinTsuchishoItem> targets) {
        List<NinteiKoshinTsuchishoReport> list = new ArrayList();
        for (NinteiKoshinTsuchishoItem item : targets) {
            item.set編集後宛先(JushoHenshu.create編集後宛先(item.getIAtesaki(), item.get地方公共団体(), item.get帳票制御共通()));
            list.add(new NinteiKoshinTsuchishoReport(item));
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

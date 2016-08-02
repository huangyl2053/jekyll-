/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd200018;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shakaifukushihojinkeigenhakkoichiran.ShakaiFukushiHojinKeigenHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200018.ShakaiFukushiHojinKeigenHakkoIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 社会福祉法人軽減確認証・決定通知書発行一覧表
 *
 * @reamsid_L DBD-3981-070 b_liuyang2
 */
public class ShakaiFukushiHojinKeigenHakkoIchiranService {

    /**
     * 帳票を出力
     *
     * @param 帳票情報リスト List<ShakaiFukushiHojinKeigenHakkoIchiranEntity>
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<ShakaiFukushiHojinKeigenHakkoIchiranEntity> 帳票情報リスト, Association association,
            IOutputOrder iOutputOrder, ReportManager reportManager) {
        ShakaiFukushiHojinKeigenHakkoIchiranProerty property = new ShakaiFukushiHojinKeigenHakkoIchiranProerty();
        try (ReportAssembler<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<ShakaiFukushiHojinKeigenHakkoIchiranReportSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            ShakaiFukushiHojinKeigenHakkoIchiranReport report = ShakaiFukushiHojinKeigenHakkoIchiranReport.createReport(
                    帳票情報リスト, association, iOutputOrder);
            report.writeBy(reportSourceWriter);

        }
    }

    private <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd200019;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200019.FutangakuNinteiHakkoIchiranProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200019.FutangakuNinteiHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangakuninteihakkoichiran.FutangakuNinteiHakkoIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200019.FutangakuNinteiHakkoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
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
 * 負担額認定証・決定通知書発行一覧表
 *
 * @reamsid_L DBD-3981-060 b_liuyang2
 */
public class FutangakuNinteiHakkoIchiranPrintService {

    /**
     * 帳票を出力
     *
     * @param 帳票情報リスト List<FutangGendoGakuNinteiEntity>
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人情報 IKojin
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<FutangakuNinteiHakkoIchiranEntity> 帳票情報リスト, Association association,
            IOutputOrder iOutputOrder, IKojin 個人情報, ReportManager reportManager) {
        FutangakuNinteiHakkoIchiranProerty property = new FutangakuNinteiHakkoIchiranProerty();
        try (ReportAssembler<FutangakuNinteiHakkoIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<FutangakuNinteiHakkoIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            FutangakuNinteiHakkoIchiranReport report = FutangakuNinteiHakkoIchiranReport.createReport(帳票情報リスト,
                    association, iOutputOrder, 個人情報);
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

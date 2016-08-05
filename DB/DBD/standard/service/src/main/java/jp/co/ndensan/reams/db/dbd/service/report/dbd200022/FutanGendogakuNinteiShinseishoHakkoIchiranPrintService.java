/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd200022;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogakuninteishinseishohakkoichiran.FutanGendogakuNinteiShinseishoHakkoIchiran;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReportSource;
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
 * 負担限度額認定申請書発行一覧表
 *
 * @reamsid_L DBD-3530-090 b_liuyang2
 */
public class FutanGendogakuNinteiShinseishoHakkoIchiranPrintService {

    /**
     * 帳票を出力
     *
     * @param 帳票情報リスト List<FutanGendogakuNinteiShinseishoHakkoIchiran>
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 個人 IKojin
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<FutanGendogakuNinteiShinseishoHakkoIchiran> 帳票情報リスト, Association association,
            IOutputOrder iOutputOrder, IKojin 個人, ReportManager reportManager) {
        FutanGendogakuNinteiShinseishoHakkoIchiranProerty property = new FutanGendogakuNinteiShinseishoHakkoIchiranProerty();
        try (ReportAssembler<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<FutanGendogakuNinteiShinseishoHakkoIchiranReportSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            FutanGendogakuNinteiShinseishoHakkoIchiranReport report = FutanGendogakuNinteiShinseishoHakkoIchiranReport.
                    createReport(帳票情報リスト, association, iOutputOrder, 個人);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd100026;

import jp.co.ndensan.reams.db.dbd.business.report.dbd100026.JukyushaDaichoProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100026.JukyushaDaichoReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tyohyoshuturyokuyojukyushadaicho.TyohyoShutuRyokuYoJukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100026.JukyushaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 受給者台帳
 *
 * @reamsid_L DBD-1760-040 b_liuyang2
 */
public class JukyushaDaichoPrintService {

    /**
     * 帳票を出力
     *
     * @param 帳票出力用受給者台帳 JukyushaDaichoEntity
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(TyohyoShutuRyokuYoJukyushaDaichoEntity 帳票出力用受給者台帳, ReportManager reportManager) {
        JukyushaDaichoProerty property = new JukyushaDaichoProerty();
        try (ReportAssembler<JukyushaDaichoReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<JukyushaDaichoReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            JukyushaDaichoReport report = JukyushaDaichoReport.createReport(帳票出力用受給者台帳);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd200012;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranProerty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.KyuhuJissekiHihokensha;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.tokubetsuchiikikasankeigenjissekikanri.TokubetsuChiikiKasanKeigenJissekiKanri;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200012.TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 特別地域加算軽減実績管理リスト
 *
 * @reamsid_L DBD-3880-060 b_liuyang2
 */
public class TokubetsuChiikiKasanKeigenJissekiKanriIchiranPrintService {

    /**
     * 帳票を出力
     *
     * @param 帳票情報リスト List<TokubetsuChiikiKasanKeigenJissekiKanri>
     * @param 作成日時 YMDHMS
     * @param 個人情報 IKojin
     * @param association Association
     * @param iOutputOrder IOutputOrder
     * @param 宛名 KyuhuJissekiHihokensha
     * @param reportManager 帳票発行処理の制御機能
     */
    public void print(List<TokubetsuChiikiKasanKeigenJissekiKanri> 帳票情報リスト, YMDHMS 作成日時, Association association,
            IOutputOrder iOutputOrder, IKojin 個人情報, KyuhuJissekiHihokensha 宛名, ReportManager reportManager) {
        TokubetsuChiikiKasanKeigenJissekiKanriIchiranProerty property = new TokubetsuChiikiKasanKeigenJissekiKanriIchiranProerty();
        try (ReportAssembler<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChiikiKasanKeigenJissekiKanriIchiranReportSource> reportSourceWriter = new ReportSourceWriter(assembler);
            TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport report = TokubetsuChiikiKasanKeigenJissekiKanriIchiranReport.
                    createReport(帳票情報リスト, association, iOutputOrder, 宛名);
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

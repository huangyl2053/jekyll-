/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
 * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 PrintServiceクラスです。
 *
 * @reamsid_L DBB-0860-060 lijian
 */
public class TokubetsuChoshuHeijunkaKeisanIchiranPrintService {

    /**
     * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 (単一帳票出力用)
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijunkaRokuBatchTaishoshaIchiran>
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijunkaRokuBatchTaishogaiIchiran>
     * @param 調定日時 YMDHMS
     * @param 調定年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト,
            YMDHMS 調定日時,
            FlexibleYear 調定年度,
            Association association,
            IOutputOrder outputOrder) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(特徴平準化結果対象者一覧表リスト, 特徴平準化結果対象外一覧表リスト, 調定日時, 調定年度, association, outputOrder, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 (複数帳票出力用)。
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijunkaRokuBatchTaishoshaIchiran>
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijunkaRokuBatchTaishogaiIchiran>
     * @param 調定日時 YMDHMS
     * @param 調定年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     * @param reportManager ReportManager
     */
    public void print(
            List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト,
            YMDHMS 調定日時,
            FlexibleYear 調定年度,
            Association association,
            IOutputOrder outputOrder,
            ReportManager reportManager) {
        TokubetsuChoshuHeijunkaKeisanIchiranProperty property = new TokubetsuChoshuHeijunkaKeisanIchiranProperty();

        try (ReportAssembler<TokubetsuChoshuHeijunkaKeisanIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuHeijunkaKeisanIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            new TokubetsuChoshuHeijunkaKeisanIchiranReport(
                    特徴平準化結果対象者一覧表リスト,
                    特徴平準化結果対象外一覧表リスト,
                    調定日時,
                    調定年度,
                    association,
                    outputOrder).writeBy(reportSourceWriter);
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

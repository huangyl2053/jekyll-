/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran;

import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanaugustkekkaichiran.TokubetsuChoshuHeijunkaKeisanIchiranSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
     * @param 特徴平準化結果対象者一覧表 TokuchoHeijunkaRokuBatchTaishoshaIchiran
     * @param 特徴平準化結果対象外一覧表 TokuchoHeijunkaRokuBatchTaishogaiIchiran
     * @param 調定日時 YMDHMS
     * @param 調定年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     * @param title RString
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表,
            TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表,
            YMDHMS 調定日時,
            FlexibleYear 調定年度,
            Association association,
            IOutputOrder outputOrder,
            RString title) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(特徴平準化結果対象者一覧表, 特徴平準化結果対象外一覧表, 調定日時, 調定年度, association, outputOrder, title, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 帳票設計_DBBPR35002_特別徴収平準化計算（特別徴収8月分）結果一覧表 (複数帳票出力用)。
     *
     * @param 特徴平準化結果対象者一覧表 TokuchoHeijunkaRokuBatchTaishoshaIchiran
     * @param 特徴平準化結果対象外一覧表 TokuchoHeijunkaRokuBatchTaishogaiIchiran
     * @param 調定日時 YMDHMS
     * @param 調定年度 FlexibleYear
     * @param association Association
     * @param outputOrder IOutputOrder
     * @param title RString
     * @param reportManager ReportManager
     */
    public void print(
            TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者一覧表,
            TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象外一覧表,
            YMDHMS 調定日時,
            FlexibleYear 調定年度,
            Association association,
            IOutputOrder outputOrder,
            RString title,
            ReportManager reportManager) {
        TokubetsuChoshuHeijunkaKeisanIchiranProperty property = new TokubetsuChoshuHeijunkaKeisanIchiranProperty();

        try (ReportAssembler<TokubetsuChoshuHeijunkaKeisanIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuHeijunkaKeisanIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            ChohyoSeigyoKyotsu 帳票制御共通 = new ChohyoSeigyoKyotsuManager()
                    .get帳票制御共通(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200005.getReportId());
            new TokubetsuChoshuHeijunkaKeisanIchiranReport(
                    特徴平準化結果対象者一覧表,
                    特徴平準化結果対象外一覧表,
                    帳票制御共通,
                    調定日時,
                    調定年度,
                    association,
                    outputOrder,
                    title).writeBy(reportSourceWriter);
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

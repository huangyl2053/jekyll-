/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiIchiran;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
public class TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranPrintService {

    private static final ReportId 帳票分類ID = new ReportId("DBB200003_TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiran");

    /**
     * 特徴平準化結果対象者一覧表
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijunkaRokuBatchTaishoshaIchiran>
     * @param 出力順ID long
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaishosha(List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            long 出力順ID, YMDHMS 調定日時, FlexibleYear 賦課年度) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            AccessLogUUID taishoshaAccessLog = null;
            print(特徴平準化結果対象者一覧表リスト, new ArrayList<TokuchoHeijunkaRokuBatchTaishogaiIchiran>(),
                    出力順ID, 調定日時, 賦課年度, reportManager, taishoshaAccessLog, null);
            collection = reportManager.publish(taishoshaAccessLog);
        }
        return collection;

    }

    /**
     * 特徴平準化結果対象者一覧表
     *
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijunkaRokuBatchTaishogaiIchiran>
     * @param 出力順ID long
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @return SourceDataCollection
     */
    public SourceDataCollection printTaishogai(List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト,
            long 出力順ID, YMDHMS 調定日時, FlexibleYear 賦課年度) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            AccessLogUUID taishogaiAccessLog = null;
            print(new ArrayList<TokuchoHeijunkaRokuBatchTaishoshaIchiran>(), 特徴平準化結果対象外一覧表リスト,
                    出力順ID, 調定日時, 賦課年度, reportManager, null, taishogaiAccessLog);
            collection = reportManager.publish(taishogaiAccessLog);
        }
        return collection;

    }

    /**
     * printメソッド
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijunkaRokuBatchTaishoshaIchiran>
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijunkaRokuBatchTaishogaiIchiran>
     * @param 出力順ID Long
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @param reportManager ReportManager
     * @param taishoshaAccessLog AccessLogUUID
     * @param taishogaiAccessLog AccessLogUUID
     */
    public void print(List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト, Long 出力順ID, YMDHMS 調定日時,
            FlexibleYear 賦課年度, ReportManager reportManager, AccessLogUUID taishoshaAccessLog, AccessLogUUID taishogaiAccessLog) {
        TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty property = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty();
        List<RString> 並び順List = get出力順(出力順ID);
        try (ReportAssembler<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport report = TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport.createForm(
                    特徴平準化結果対象者一覧表リスト, 特徴平準化結果対象外一覧表リスト, 並び順List, 調定日時, 賦課年度,
                    association, taishoshaAccessLog, taishogaiAccessLog);
            report.writeBy(reportSourceWriter);
        }
    }

    /**
     * printメソッド
     *
     * @param 特徴平準化結果対象者一覧表リスト List<TokuchoHeijunkaRokuBatchTaishoshaIchiran>
     * @param 特徴平準化結果対象外一覧表リスト List<TokuchoHeijunkaRokuBatchTaishogaiIchiran>
     * @param 出力順ID Long
     * @param 調定日時 YMDHMS
     * @param 賦課年度 FlexibleYear
     * @return SourceDataCollection
     */
    public SourceDataCollection print(List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト, Long 出力順ID, YMDHMS 調定日時,
            FlexibleYear 賦課年度) {
        TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty property = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty();
        List<RString> 並び順List = get出力順(出力順ID);
        AccessLogUUID taishoshaAccessLog = null;
        AccessLogUUID taishogaiAccessLog = null;
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        return new Printer<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource>().spool(property,
                new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport(特徴平準化結果対象者一覧表リスト,
                        特徴平準化結果対象外一覧表リスト, 並び順List, 調定日時, 賦課年度, association, taishoshaAccessLog,
                        taishogaiAccessLog));
    }

    private List<RString> get出力順(Long 出力順ID) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, 出力順ID);
        List<RString> 並び順List = new ArrayList<>();
        if (並び順 != null) {
            for (ISetSortItem item : 並び順.get設定項目リスト()) {
                並び順List.add(item.get項目名());
            }
        }
        return 並び順List;
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

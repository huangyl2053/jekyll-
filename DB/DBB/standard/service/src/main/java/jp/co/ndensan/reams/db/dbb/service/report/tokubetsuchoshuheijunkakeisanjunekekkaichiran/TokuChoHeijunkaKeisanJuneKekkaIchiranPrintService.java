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
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishogaiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijyunkaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuheijunkakeisanjunekekkaichiran.TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 特別徴収平準化計算（特別徴収6月分）結果一覧表帳票クラスです。
 *
 * @reamsid_L DBB-0810-030 yebangqiang
 */
public class TokuChoHeijunkaKeisanJuneKekkaIchiranPrintService {

    private static final ReportId 帳票分類ID = new ReportId("DBB200003_TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiran");
    private final RString コード_ログコード = new RString("0003");
    private static final RString 定数_被保険者番号 = new RString("被保険者番号");

    /**
     * 特徴平準化結果対象者一覧表を生成するメソッドです。
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
            List<PersonalData> taishoshaPersonalDataList = new ArrayList<>();
            for (TokuchoHeijunkaRokuBatchTaishoshaIchiran 特徴平準化結果対象者 : 特徴平準化結果対象者一覧表リスト) {
                TokuchoHeijyunkaTaishoshaEntity item = 特徴平準化結果対象者.get特徴平準化結果対象者();
                taishoshaPersonalDataList.add(toPersonalDataTaishosha(item));
            }
            AccessLogUUID taishoshaAccessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, taishoshaPersonalDataList);
            print(特徴平準化結果対象者一覧表リスト, new ArrayList<TokuchoHeijunkaRokuBatchTaishogaiIchiran>(),
                    出力順ID, 調定日時, 賦課年度, reportManager);
            collection = reportManager.publish(taishoshaAccessLog);
        }
        return collection;

    }

    /**
     * 特徴平準化結果対象外一覧表を生成するメソッドです。
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
            List<PersonalData> taishogaiPersonalDataList = new ArrayList<>();
            for (TokuchoHeijunkaRokuBatchTaishogaiIchiran 特徴平準化結果対象者 : 特徴平準化結果対象外一覧表リスト) {
                TokuchoHeijyunkaTaishogaiEntity item = 特徴平準化結果対象者.get特徴平準化結果対象外();
                taishogaiPersonalDataList.add(toPersonalDataTaishogai(item));
            }
            AccessLogUUID taishogaiAccessLog = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, taishogaiPersonalDataList);
            print(new ArrayList<TokuchoHeijunkaRokuBatchTaishoshaIchiran>(), 特徴平準化結果対象外一覧表リスト,
                    出力順ID, 調定日時, 賦課年度, reportManager);
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
     */
    public void print(List<TokuchoHeijunkaRokuBatchTaishoshaIchiran> 特徴平準化結果対象者一覧表リスト,
            List<TokuchoHeijunkaRokuBatchTaishogaiIchiran> 特徴平準化結果対象外一覧表リスト, Long 出力順ID, YMDHMS 調定日時,
            FlexibleYear 賦課年度, ReportManager reportManager) {
        IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                .get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, 出力順ID);
        TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty property = new TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranProperty(並び順);
        try (ReportAssembler<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport report = TokubetsuChoshuHeijunkaKeisanJuneKekkaIchiranReport.createForm(
                    特徴平準化結果対象者一覧表リスト, 特徴平準化結果対象外一覧表リスト, 調定日時, 賦課年度,
                    association, 並び順);
            report.writeBy(reportSourceWriter);
        }
    }

    private PersonalData toPersonalDataTaishosha(TokuchoHeijyunkaTaishoshaEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(コード_ログコード), 定数_被保険者番号,
                entity.get被保険者番号().value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private PersonalData toPersonalDataTaishogai(TokuchoHeijyunkaTaishogaiEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(コード_ログコード), 定数_被保険者番号,
                entity.get被保険者番号().value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
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

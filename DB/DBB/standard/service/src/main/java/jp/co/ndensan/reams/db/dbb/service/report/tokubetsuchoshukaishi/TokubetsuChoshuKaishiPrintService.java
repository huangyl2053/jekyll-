/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.TokubetsuChoshuKaishi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）発行一覧表
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiPrintService {

    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM5 = 5;
    private static final ReportId 特別徴収開始通知書本算定_帳票分類ID = new ReportId("DBB100032_TokubetsuChoshuKaishiTsuchishoDaihyo");

    /**
     * 特別徴収開始通知書（本算定）発行一覧表(単一帳票出力用)
     *
     * @param 編集後本算定通知書共通情報 List< EditedHonSanteiTsuchiShoKyotsu>
     * @param 賦課年度 FlexibleYear
     * @param 出力順ID RString
     * @param 帳票作成日時 RDateTime
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報, FlexibleYear 賦課年度,
            RString 出力順ID, RDateTime 帳票作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(編集後本算定通知書共通情報, 賦課年度, 出力順ID, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 特別徴収開始通知書（本算定）発行一覧表の printメソッド(複数帳票出力用)
     *
     * @param 編集後本算定通知書共通情報 List< EditedHonSanteiTsuchiShoKyotsu>
     * @param 賦課年度 FlexibleYear
     * @param 出力順ID RString
     * @param 帳票作成日時 RDateTime
     * @param reportManager ReportManager
     */
    public void print(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報, FlexibleYear 賦課年度, RString 出力順ID,
            RDateTime 帳票作成日時, ReportManager reportManager) {
        IOutputOrder 並び順 = null;
        if (!RString.isNullOrEmpty(出力順ID)) {
            並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書本算定_帳票分類ID, Long.parseLong(出力順ID.toString()));
        }
        TokubetsuChoshuKaishiProperty property = new TokubetsuChoshuKaishiProperty(並び順);
        try (ReportAssembler<TokubetsuChoshuKaishiSource> assembler = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association association = finder.getAssociation();
            RString 市町村コード = association.get地方公共団体コード().value();
            RString 市町村名 = association.get市町村名();

            if (並び順 == null || 並び順.get設定項目リスト() == null || 並び順.get設定項目リスト().isEmpty()) {
                executeReport(編集後本算定通知書共通情報, 賦課年度, 帳票作成日時, 市町村コード, 市町村名, new ArrayList(),
                        new ArrayList(), reportSourceWriter);
                return;
            }
            List<RString> 出力項目リスト = new ArrayList();
            List<RString> 改頁項目リスト = new ArrayList();
            for (int i = NUM0; i < NUM5; i++) {
                if (i < 並び順.get設定項目リスト().size()) {
                    出力項目リスト.add(並び順.get設定項目リスト().get(i).get項目名());
                    if (並び順.get設定項目リスト().get(i).is改頁項目()) {
                        改頁項目リスト.add(並び順.get設定項目リスト().get(i).get項目名());
                    }
                } else {
                    break;
                }
            }
            executeReport(編集後本算定通知書共通情報, 賦課年度, 帳票作成日時, 市町村コード, 市町村名, 出力項目リスト,
                    改頁項目リスト, reportSourceWriter);
        }
    }

    private void executeReport(List<EditedHonSanteiTsuchiShoKyotsu> 編集後本算定通知書共通情報,
            FlexibleYear 賦課年度, RDateTime 帳票作成日時, RString 市町村コード, RString 市町村名,
            List<RString> 出力項目リスト, List<RString> 改頁項目リスト, ReportSourceWriter<TokubetsuChoshuKaishiSource> reportSourceWriter) {
        int i = NUM1;
        for (EditedHonSanteiTsuchiShoKyotsu editedhonsanteitsuchishokyotsu : 編集後本算定通知書共通情報) {
            TokubetsuChoshuKaishiReport report = new TokubetsuChoshuKaishiReport(
                    editedhonsanteitsuchishokyotsu, 賦課年度, 帳票作成日時, 市町村コード, 市町村名, 出力項目リスト, 改頁項目リスト, i);
            report.writeBy(reportSourceWriter);
            i = i + NUM1;
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

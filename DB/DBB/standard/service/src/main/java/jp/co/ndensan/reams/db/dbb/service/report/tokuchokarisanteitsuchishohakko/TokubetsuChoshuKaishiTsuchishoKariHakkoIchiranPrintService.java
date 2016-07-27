/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokuchokarisanteitsuchishohakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.KaishiTsuchishoKariHakkoIchiranProperty;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
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
 * 特別徴収開始通知書（仮算定）発行一覧表PrintServiceクラスです。
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranPrintService {

    private static final ReportId 特別徴収開始通知書仮算定_帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM5 = 5;

    /**
     * 特別徴収開始通知書（仮算定）発行一覧表(単一帳票出力用)
     *
     * @param 編集後仮算定通知書情報List List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 出力順ID RString
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書情報List,
            RString 出力順ID, FlexibleYear 調定年度, YMDHMS 帳票作成日時) {
        SourceDataCollection collection;
        try (ReportManager reportManager = new ReportManager()) {
            print(編集後仮算定通知書情報List, 出力順ID, 調定年度, 帳票作成日時, reportManager);
            collection = reportManager.publish();
        }
        return collection;
    }

    /**
     * 特別徴収開始通知書（仮算定）発行一覧表の printメソッド(複数帳票出力用)。
     *
     * @param 編集後仮算定通知書情報List List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 出力順ID RString
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void print(
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書情報List,
            RString 出力順ID,
            FlexibleYear 調定年度,
            YMDHMS 帳票作成日時,
            ReportManager reportManager) {
        KaishiTsuchishoKariHakkoIchiranProperty property = new KaishiTsuchishoKariHakkoIchiranProperty();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            IOutputOrder 並び順 = null;
            if (!RString.isNullOrEmpty(出力順ID)) {
                並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                        .get出力順(SubGyomuCode.DBB介護賦課, 特別徴収開始通知書仮算定_帳票分類ID, Long.parseLong(出力順ID.toString()));
            }
            if (並び順 == null || 並び順.get設定項目リスト() == null || 並び順.get設定項目リスト().isEmpty()) {
                executereport(編集後仮算定通知書情報List, 調定年度, 帳票作成日時, association, new ArrayList(),
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
            executereport(編集後仮算定通知書情報List, 調定年度, 帳票作成日時, association, 出力項目リスト,
                    改頁項目リスト, reportSourceWriter);

        }
    }

    private void executereport(List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書情報List,
            FlexibleYear 調定年度,
            YMDHMS 帳票作成日時,
            Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> reportSourceWriter) {
        int i = NUM1;
        for (EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書情報 : 編集後仮算定通知書情報List) {
            TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport report = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport(
                    編集後仮算定通知書情報, 調定年度, 帳票作成日時, association, 出力項目リスト, 改頁項目リスト, i);
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

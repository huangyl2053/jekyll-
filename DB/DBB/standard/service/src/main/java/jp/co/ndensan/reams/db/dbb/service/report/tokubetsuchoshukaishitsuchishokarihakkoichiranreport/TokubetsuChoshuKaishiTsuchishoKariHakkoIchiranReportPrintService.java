/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchishokarihakkoichiranreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
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
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReportPrintService {

    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM5 = 5;

    /**
     * 特別徴収開始通知書（仮算定）発行一覧表(単一帳票出力用)
     *
     * @param 編集後仮算定通知書共通情報entityList List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 出力順ID long
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @return SourceDataCollection
     */
    public SourceDataCollection printSingle(List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            long 出力順ID, FlexibleYear 調定年度, YMDHMS 帳票作成日時) {
        try (ReportManager reportManager = new ReportManager()) {
            print(編集後仮算定通知書共通情報entityList, 出力順ID, 調定年度, 帳票作成日時, reportManager);
            return reportManager.publish();
        }
    }

    /**
     * 特別徴収開始通知書（仮算定）発行一覧表の printメソッド(複数帳票出力用)。
     *
     * @param 編集後仮算定通知書共通情報entityList List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 出力順ID long
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void print(
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            long 出力順ID,
            FlexibleYear 調定年度,
            YMDHMS 帳票作成日時,
            ReportManager reportManager) {
        Property property = new Property();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            IOutputOrder 並び順 = ChohyoShutsuryokujunFinderFactory.createInstance()
                    .get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200001.getReportId(), 出力順ID);
            if (並び順 == null || 並び順.get設定項目リスト() == null || 並び順.get設定項目リスト().isEmpty()) {
                executereport(編集後仮算定通知書共通情報entityList, 調定年度, 帳票作成日時, association, new ArrayList(),
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
            executereport(編集後仮算定通知書共通情報entityList, 調定年度, 帳票作成日時, association, 出力項目リスト,
                    改頁項目リスト, reportSourceWriter);

        }
    }

    private void executereport(List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            FlexibleYear 調定年度,
            YMDHMS 帳票作成日時,
            Association association,
            List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト,
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> reportSourceWriter) {
        Collections.sort(編集後仮算定通知書共通情報entityList, new Comparator<EditedKariSanteiTsuchiShoKyotsu>() {
            @Override
            public int compare(EditedKariSanteiTsuchiShoKyotsu o1, EditedKariSanteiTsuchiShoKyotsu o2) {
                int flag = o1.get通知書番号().compareTo(o2.get通知書番号());
                if (0 == flag) {
                    flag = o1.get更正後().get更正後特徴期別金額01().compareTo(o2.get更正後().get更正後特徴期別金額01());
                    if (0 == flag) {
                        flag = o1.get更正後().get更正後特徴期別金額02().compareTo(o1.get更正後().get更正後特徴期別金額02());
                    }
                }
                return flag;
            }
        });
        int i = NUM1;
        for (EditedKariSanteiTsuchiShoKyotsu editedKariSanteiTsuchiShoKyotsu : 編集後仮算定通知書共通情報entityList) {
            TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport report = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchirReport(
                    editedKariSanteiTsuchiShoKyotsu, 調定年度, 帳票作成日時, association, 出力項目リスト, 改頁項目リスト, i);
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

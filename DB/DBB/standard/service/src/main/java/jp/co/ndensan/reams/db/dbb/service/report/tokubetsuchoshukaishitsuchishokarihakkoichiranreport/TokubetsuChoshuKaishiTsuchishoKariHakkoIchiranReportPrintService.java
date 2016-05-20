/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.report.tokubetsuchoshukaishitsuchishokarihakkoichiranreport;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.Property;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表PrintServiceクラスです。
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReportPrintService {

    /**
     * printメソッドします。
     *
     * @param 編集後仮算定通知書共通情報entityList List<EditedKariSanteiTsuchiShoKyotsu>
     * @param 改頁1 RString
     * @param 改頁2 RString
     * @param 改頁3 RString
     * @param 改頁4 RString
     * @param 改頁5 RString
     * @param 出力順1 RString
     * @param 出力順2 RString
     * @param 出力順3 RString
     * @param 出力順4 RString
     * @param 出力順5 RString
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param reportManager ReportManager
     */
    public void print(
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            RString 改頁1,
            RString 改頁2,
            RString 改頁3,
            RString 改頁4,
            RString 改頁5,
            RString 出力順1,
            RString 出力順2,
            RString 出力順3,
            RString 出力順4,
            RString 出力順5,
            FlexibleYear 調定年度,
            YMDHMS 帳票作成日時,
            ReportManager reportManager) {
        Property property = new Property();
        try (ReportAssembler<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> assembler
                = createAssembler(property, reportManager)) {
            ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> reportSourceWriter
                    = new ReportSourceWriter(assembler);
            Association association = AssociationFinderFactory.createInstance().getAssociation();
            TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport.createForm(編集後仮算定通知書共通情報entityList,
                    改頁1, 改頁2, 改頁3, 改頁4, 改頁5, 出力順1, 出力順2, 出力順3,
                    出力順4, 出力順5, 調定年度, 帳票作成日時, association).writeBy(reportSourceWriter);
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

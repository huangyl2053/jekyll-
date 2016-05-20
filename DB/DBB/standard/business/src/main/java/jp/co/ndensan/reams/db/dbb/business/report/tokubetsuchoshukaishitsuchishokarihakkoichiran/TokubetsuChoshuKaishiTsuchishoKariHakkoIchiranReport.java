/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Report
 *
 * @reamsid_L DBB-0790-060 surun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport extends
        Report<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> {

    private final List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList;
    private final RString 改頁1;
    private final RString 改頁2;
    private final RString 改頁3;
    private final RString 改頁4;
    private final RString 改頁5;
    private final RString 出力順1;
    private final RString 出力順2;
    private final RString 出力順3;
    private final RString 出力順4;
    private final RString 出力順5;
    private final FlexibleYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final Association association;

    /**
     * コンストラクタです
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
     * @param association Association
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport(
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            RString 改頁1, RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5,
            RString 出力順1, RString 出力順2, RString 出力順3, RString 出力順4, RString 出力順5,
            FlexibleYear 調定年度, YMDHMS 帳票作成日時, Association association) {
        this.編集後仮算定通知書共通情報entityList = 編集後仮算定通知書共通情報entityList;
        this.改頁1 = 改頁1;
        this.改頁2 = 改頁2;
        this.改頁3 = 改頁3;
        this.改頁4 = 改頁4;
        this.改頁5 = 改頁5;
        this.出力順1 = 出力順1;
        this.出力順2 = 出力順2;
        this.出力順3 = 出力順3;
        this.出力順4 = 出力順4;
        this.出力順5 = 出力順5;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.association = association;
    }

    /**
     * createFormメソッド
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
     * @param association Association
     * @return TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport
     */
    public static TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport createForm(
            @NonNull List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報entityList,
            @NonNull RString 改頁1,
            @NonNull RString 改頁2,
            @NonNull RString 改頁3,
            @NonNull RString 改頁4,
            @NonNull RString 改頁5,
            @NonNull RString 出力順1,
            @NonNull RString 出力順2,
            @NonNull RString 出力順3,
            @NonNull RString 出力順4,
            @NonNull RString 出力順5,
            @NonNull FlexibleYear 調定年度,
            @NonNull YMDHMS 帳票作成日時,
            @NonNull Association association) {
        return new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranReport(編集後仮算定通知書共通情報entityList, 改頁1, 改頁2,
                改頁3, 改頁4, 改頁5, 出力順1, 出力順2, 出力順3, 出力順4, 出力順5, 調定年度, 帳票作成日時, association);
    }

    @Override
    public void writeBy(ReportSourceWriter<TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource> writer) {
        Integer 連番 = 0;
        for (EditedKariSanteiTsuchiShoKyotsu target : 編集後仮算定通知書共通情報entityList) {
            連番 = 連番 + 1;
            ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor editor
                    = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(target, 改頁1, 改頁2, 改頁3, 改頁4, 改頁5,
                            出力順1, 出力順2, 出力順3, 出力順4, 出力順5, 調定年度, 帳票作成日時, 連番, association);
            ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder builder
                    = new TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranBuilder(editor);
            writer.writeLine(builder);
        }
    }
}

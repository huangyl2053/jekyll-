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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特別徴収開始通知書（仮算定）発行一覧表Editor
 *
 * @reamsid_L DBB-0790-060 surun
 */
public class TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor implements ITokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor {

    private static final RString SAKUSEI = new RString("作成");
    private static final RString タイトル = new RString("特別徴収開始通知書（仮徴収）発行一覧表");
    private static final RString 徴収額タイトル = new RString("仮徴収額");
    private static final RString 仮徴収月4月 = new RString("4月");
    private static final RString 仮徴収月6月 = new RString("6月");
    private static final RString 仮徴収月8月 = new RString("8月");
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity;
    private final FlexibleYear 調定年度;
    private final YMDHMS 帳票作成日時;
    private final int 連番;
    private final Association association;
    private final List<RString> 改頁項目リスト;
    private final List<RString> 出力項目リスト;

    /**
     * コンストラクタです
     *
     * @param 編集後仮算定通知書共通情報entity EditedKariSanteiTsuchiShoKyotsu
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param 連番 int
     * @param association Association
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity,
            FlexibleYear 調定年度, YMDHMS 帳票作成日時,
            int 連番, Association association, List<RString> 出力項目リスト, List<RString> 改頁項目リスト) {
        this.編集後仮算定通知書共通情報entity = 編集後仮算定通知書共通情報entity;
        this.調定年度 = 調定年度;
        this.帳票作成日時 = 帳票作成日時;
        this.連番 = 連番;
        this.association = association;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource edit(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (帳票作成日時 != null && !帳票作成日時.isEmpty()) {
            RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成日.concat(RString.HALF_SPACE).concat(帳票作成時).concat(RString.HALF_SPACE).concat(SAKUSEI);
        }
        source.title = タイトル;
        if (調定年度 != null && !調定年度.isEmpty()) {
            source.nendo = 調定年度.wareki().eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).fillType(FillType.BLANK).toDateString();
        }
        if (association != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
            source.hokenshaName = association.get市町村名();
        }
        set出力改頁(source);
        source.titleChoshugaku = 徴収額タイトル;
        source.listUpper_1 = new RString(連番);
        if (編集後仮算定通知書共通情報entity != null) {
            set編集後宛先(source, 編集後仮算定通知書共通情報entity);
            set編集後個人(source, 編集後仮算定通知書共通情報entity);
            set更正後(source, 編集後仮算定通知書共通情報entity);
            source.listLower_1 = 編集後仮算定通知書共通情報entity.get通知書番号().value();
            source.listLower_6 = 仮徴収月4月;
            source.listLower_8 = 仮徴収月6月;
            source.listLower_10 = 仮徴収月8月;
        }
        return source;
    }

    private void set出力改頁(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (NUM0 < 出力項目リスト.size()) {
            source.shutsuryokujun1 = 出力項目リスト.get(NUM0);
            if (NUM0 < 改頁項目リスト.size()) {
                source.kaipage1 = 改頁項目リスト.get(NUM0);
            }
        }
        if (NUM1 < 出力項目リスト.size()) {
            source.shutsuryokujun2 = 出力項目リスト.get(NUM1);
            if (NUM1 < 改頁項目リスト.size()) {
                source.kaipage2 = 改頁項目リスト.get(NUM1);
            }
        }
        if (NUM2 < 出力項目リスト.size()) {
            source.shutsuryokujun3 = 出力項目リスト.get(NUM2);
            if (NUM2 < 改頁項目リスト.size()) {
                source.kaipage3 = 改頁項目リスト.get(NUM2);
            }
        }
        if (NUM3 < 出力項目リスト.size()) {
            source.shutsuryokujun4 = 出力項目リスト.get(NUM3);
            if (NUM3 < 改頁項目リスト.size()) {
                source.kaipage4 = 改頁項目リスト.get(NUM3);
            }
        }
        if (NUM4 < 出力項目リスト.size()) {
            source.shutsuryokujun5 = 出力項目リスト.get(NUM4);
            if (NUM4 < 改頁項目リスト.size()) {
                source.kaipage5 = 改頁項目リスト.get(NUM4);
            }
        }
    }

    private void set編集後宛先(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity) {
        if (編集後仮算定通知書共通情報entity.get編集後宛先() != null) {
            source.listUpper_2 = 編集後仮算定通知書共通情報entity.get編集後宛先().get郵便番号();
            source.listUpper_3 = 編集後仮算定通知書共通情報entity.get編集後宛先().get町域();
            source.listUpper_4 = 編集後仮算定通知書共通情報entity.get編集後宛先().get宛先行政区();
        }
    }

    private void set編集後個人(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity) {
        if (編集後仮算定通知書共通情報entity.get編集後個人() != null) {
            source.listUpper_5 = 編集後仮算定通知書共通情報entity.get編集後個人().get生年月日();
            source.listUpper_6 = 編集後仮算定通知書共通情報entity.get編集後個人().get性別();
            if (編集後仮算定通知書共通情報entity.get編集後個人().get世帯主名() != null) {
                source.listUpper_7 = 編集後仮算定通知書共通情報entity.get編集後個人().get世帯主名().value();
            }
            if (編集後仮算定通知書共通情報entity.get編集後個人().get世帯コード() != null) {
                source.listLower_2 = 編集後仮算定通知書共通情報entity.get編集後個人().get世帯コード().value();
            }
            if (編集後仮算定通知書共通情報entity.get編集後個人().get名称() != null) {
                source.listLower_3 = new RString(編集後仮算定通知書共通情報entity.get編集後個人().get名称().getName().toString());
            }
        }
    }

    private void set更正後(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source,
            EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity) {
        if (編集後仮算定通知書共通情報entity.get更正後() != null) {
            source.listLower_4 = 編集後仮算定通知書共通情報entity.get更正後().get更正後特別徴収義務者();
            source.listLower_5 = 編集後仮算定通知書共通情報entity.get更正後().get更正後特別徴収対象年金();
            if (編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額01() != null) {
                source.listLower_7 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                        get更正後特徴期別金額01(), 0);
            }
            if (編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額02() != null) {
                source.listLower_9 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                        get更正後特徴期別金額02(), 0);
            }
            if (編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額03() != null) {
                source.listLower_11 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                        get更正後特徴期別金額03(), 0);
            }
        }
    }

}

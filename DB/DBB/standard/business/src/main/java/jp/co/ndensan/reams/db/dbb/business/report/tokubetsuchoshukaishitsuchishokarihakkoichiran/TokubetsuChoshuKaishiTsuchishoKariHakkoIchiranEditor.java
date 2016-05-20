/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

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
    private static final RString NENDO = new RString("年度");
    private static final RString 徴収額タイトル = new RString("仮徴収額");
    private static final RString 仮徴収月4月 = new RString("4月");
    private static final RString 仮徴収月6月 = new RString("6月");
    private static final RString 仮徴収月8月 = new RString("8月");

    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity;
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
    private final Integer 連番;
    private final Association association;

    /**
     * コンストラクタです
     *
     * @param 編集後仮算定通知書共通情報entity EditedKariSanteiTsuchiShoKyotsu
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
     * @param 連番 Integer
     * @param association Association
     */
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranEditor(EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報entity,
            RString 改頁1, RString 改頁2, RString 改頁3, RString 改頁4, RString 改頁5, RString 出力順1, RString 出力順2, RString 出力順3,
            RString 出力順4, RString 出力順5, FlexibleYear 調定年度, YMDHMS 帳票作成日時, Integer 連番, Association association) {
        this.編集後仮算定通知書共通情報entity = 編集後仮算定通知書共通情報entity;
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
        this.連番 = 連番;
        this.association = association;
    }

    @Override
    public TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource edit(TokubetsuChoshuKaishiTsuchishoKariHakkoIchiranSource source) {
        if (帳票作成日時 != null && !帳票作成日時.isEmpty()) {
            RString 帳票作成日 = 帳票作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
            RString 帳票作成時 = 帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            source.printTimeStamp = 帳票作成日.concat(" " + 帳票作成時 + " " + SAKUSEI);
        } else {
            source.printTimeStamp = RString.EMPTY;
        }
        source.title = タイトル;
        if (調定年度 != null && !調定年度.isEmpty()) {
            source.nendo = 調定年度.wareki().eraType(EraType.KANJI).toDateString();
        } else {
            source.nendo = RString.EMPTY;
        }
        if (association != null) {
            source.hokenshaNo = association.get地方公共団体コード().value();
            source.hokenshaName = association.get市町村名();
        } else {
            source.hokenshaNo = RString.EMPTY;
            source.hokenshaName = RString.EMPTY;
        }
        source.shutsuryokujun1 = 出力順1;
        source.shutsuryokujun2 = 出力順2;
        source.shutsuryokujun3 = 出力順3;
        source.shutsuryokujun4 = 出力順4;
        source.shutsuryokujun5 = 出力順5;
        source.kaipage1 = 改頁1;
        source.kaipage2 = 改頁2;
        source.kaipage3 = 改頁3;
        source.kaipage4 = 改頁4;
        source.kaipage5 = 改頁5;
        source.titleChoshugaku = 徴収額タイトル;
        source.listUpper_1 = new RString(連番.toString());
        if (編集後仮算定通知書共通情報entity != null) {
            source.listUpper_2 = 編集後仮算定通知書共通情報entity.get編集後宛先().get郵便番号();
            source.listUpper_3 = 編集後仮算定通知書共通情報entity.get編集後宛先().get編集後住所();
            source.listUpper_4 = 編集後仮算定通知書共通情報entity.get編集後宛先().get宛先行政区();
            source.listUpper_5 = 編集後仮算定通知書共通情報entity.get編集後個人().get生年月日();
            source.listUpper_6 = 編集後仮算定通知書共通情報entity.get編集後個人().get性別();
            source.listUpper_7 = 編集後仮算定通知書共通情報entity.get編集後個人().get世帯主名().value();
            source.listLower_1 = 編集後仮算定通知書共通情報entity.get通知書番号().value();
            source.listLower_2 = 編集後仮算定通知書共通情報entity.get編集後個人().get世帯コード().value();
            source.listLower_3 = 編集後仮算定通知書共通情報entity.get編集後個人().get名称().getName().value();
            source.listLower_4 = 編集後仮算定通知書共通情報entity.get更正後().get更正後特別徴収義務者();
            source.listLower_5 = 編集後仮算定通知書共通情報entity.get更正後().get更正後特別徴収対象年金();
            source.listLower_6 = 仮徴収月4月;
            source.listLower_7 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額01(), 0);
            source.listLower_8 = 仮徴収月6月;
            source.listLower_9 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額02(), 0);
            source.listLower_10 = 仮徴収月8月;
            source.listLower_11 = DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報entity.get更正後().
                    get更正後特徴期別金額03(), 0);

        } else {
            source.listUpper_2 = RString.EMPTY;
            source.listUpper_3 = RString.EMPTY;
            source.listUpper_4 = RString.EMPTY;
            source.listUpper_5 = RString.EMPTY;
            source.listUpper_6 = RString.EMPTY;
            source.listUpper_7 = RString.EMPTY;
            source.listLower_1 = RString.EMPTY;
            source.listLower_2 = RString.EMPTY;
            source.listLower_3 = RString.EMPTY;
            source.listLower_4 = RString.EMPTY;
            source.listLower_5 = RString.EMPTY;
            source.listLower_6 = 仮徴収月4月;
            source.listLower_7 = RString.EMPTY;
            source.listLower_8 = 仮徴収月6月;
            source.listLower_9 = RString.EMPTY;
            source.listLower_10 = 仮徴収月8月;
            source.listLower_11 = RString.EMPTY;
        }
        return source;
    }
}

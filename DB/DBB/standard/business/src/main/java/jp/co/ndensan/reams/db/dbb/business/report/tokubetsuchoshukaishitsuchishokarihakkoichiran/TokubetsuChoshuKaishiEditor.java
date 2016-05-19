/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票設計_DBBRP43002_4_特別徴収開始通知書（本算定）TokubetsuChoshuKaishiEditor
 *
 * @reamsid_L DBB-0780-100 yangchenbing
 */
public class TokubetsuChoshuKaishiEditor implements ITokubetsuChoshuKaishiEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 賦課年度;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final RDateTime 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final int num;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final RString 特別徴収開始通知書 = new RString("特別徴収開始通知書（本算定）発行一覧表");
    private static final RString 定値_10月 = new RString("10月");
    private static final RString 定値_12月 = new RString("12月");
    private static final RString 定値_2月 = new RString("2月");
    private static final RString 定値_作成 = new RString("作成");
    private static final RString 本徴収額 = new RString("本徴収額");

    /**
     * インスタンスを生成します。
     *
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param 賦課年度 RString
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト 改頁項目リスト
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param num int
     */
    protected TokubetsuChoshuKaishiEditor(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            RString 賦課年度, List<RString> 出力項目リスト, List<RString> 改頁項目リスト,
            RDateTime 帳票作成日時, RString 市町村コード, RString 市町村名, int num) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.賦課年度 = 賦課年度;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.帳票作成日時 = 帳票作成日時;
        this.市町村コード = 市町村コード;
        this.市町村名 = 市町村名;
        this.num = num;
    }

    @Override
    public TokubetsuChoshuKaishiSource edit(TokubetsuChoshuKaishiSource source) {
        makeNonyuTsuchIchiranItemList(source);
        return source;
    }

    /**
     * makeNonyuTsuchIchiranItemList
     *
     * @param source TokubetsuChoshuKaishiSource
     */
    private void makeNonyuTsuchIchiranItemList(TokubetsuChoshuKaishiSource source) {
        RDate date = 帳票作成日時.getDate();
        RTime time = 帳票作成日時.getTime();
        RString timeFormat = time.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(RString.HALF_SPACE).concat(timeFormat).
                concat(RString.HALF_SPACE).concat(定値_作成);
        source.title = 特別徴収開始通知書;
        source.hokenshaNo = 市町村コード;
        source.hokenshaName = 市町村名;
        listlowers(source);
        source.listLower_6 = 定値_10月;
        if (編集後本算定通知書共通情報 != null && 編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.
                get更正後().get普徴期別金額リスト() != null && !編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト().isEmpty()) {
            for (CharacteristicsPhase entity : 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト()) {
                if (entity != null && entity.get期() != null && Integer.valueOf(entity.get期().toString()) == NUM4) {
                    source.listLower_7 = new RString(entity.get金額().toString());
                } else if (entity != null && entity.get期() != null && Integer.valueOf(entity.get期().toString()) == NUM5) {
                    source.listLower_9 = new RString(entity.get金額().toString());
                } else if (entity != null && entity.get期() != null && Integer.valueOf(entity.get期().toString()) == NUM6) {
                    source.listLower_11 = new RString(entity.get金額().toString());
                }
            }
        }
        source.listLower_8 = 定値_12月;
        source.listLower_10 = 定値_2月;
        source.nendo = 賦課年度;
        set出力改頁(source);
    }

    private void listlowers(TokubetsuChoshuKaishiSource source) {
        source.titleChoshugaku = 本徴収額;
        if (num >= NUM0) {
            source.listUpper_1 = new RString(num);
        }
        if (編集後本算定通知書共通情報 != null) {
            if (編集後本算定通知書共通情報.get編集後宛先() != null) {
                source.listUpper_2 = 編集後本算定通知書共通情報.get編集後宛先().get郵便番号();
            }
            if (編集後本算定通知書共通情報.get編集後宛先() != null) {
                source.listUpper_3 = 編集後本算定通知書共通情報.get編集後宛先().get町域();
            }
            if (編集後本算定通知書共通情報.get編集後宛先() != null) {
                source.listUpper_4 = 編集後本算定通知書共通情報.get編集後宛先().get宛先行政区();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null) {
                source.listUpper_5 = 編集後本算定通知書共通情報.get編集後個人().get生年月日();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null) {
                source.listUpper_6 = 編集後本算定通知書共通情報.get編集後個人().get性別();
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get世帯主名() != null) {
                source.listUpper_7 = new RString(編集後本算定通知書共通情報.get編集後個人().get世帯主名().toString());
            }
            if (編集後本算定通知書共通情報.get通知書番号() != null) {
                source.listLower_1 = new RString(編集後本算定通知書共通情報.get通知書番号().toString());
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
                source.listLower_2 = new RString(編集後本算定通知書共通情報.get編集後個人().get世帯コード().toString());
            }
            if (編集後本算定通知書共通情報.get編集後個人() != null && 編集後本算定通知書共通情報.get編集後個人().get名称() != null) {
                source.listLower_3 = new RString(編集後本算定通知書共通情報.get編集後個人().get名称().toString());
            }
            if (編集後本算定通知書共通情報.get更正後() != null) {
                source.listLower_4 = 編集後本算定通知書共通情報.get更正後().get特別徴収義務者();
            }
            if (編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.get更正後().get特別徴収対象年金コード() != null) {
                source.listLower_5 = new RString(編集後本算定通知書共通情報.get更正後().get特別徴収対象年金コード().toString());
            }
        }
    }

    private void set出力改頁(TokubetsuChoshuKaishiSource source) {
        if (出力項目リスト.size() > NUM0) {
            source.shutsuryokujun1 = 出力項目リスト.get(NUM0);
            source.kaipage1 = 改頁項目リスト.get(NUM0);
        }
        if (出力項目リスト.size() > NUM1) {
            source.shutsuryokujun2 = 出力項目リスト.get(NUM1);
            source.kaipage2 = 改頁項目リスト.get(NUM1);
        }
        if (出力項目リスト.size() > NUM2) {
            source.shutsuryokujun3 = 出力項目リスト.get(NUM2);
            source.kaipage3 = 改頁項目リスト.get(NUM2);
        }
        if (出力項目リスト.size() > NUM3) {
            source.shutsuryokujun4 = 出力項目リスト.get(NUM3);
            source.kaipage4 = 改頁項目リスト.get(NUM3);
        }
        if (出力項目リスト.size() > NUM4) {
            source.shutsuryokujun5 = 出力項目リスト.get(NUM4);
            source.kaipage5 = 改頁項目リスト.get(NUM4);
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshukaishitsuchishokarihakkoichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.nonyutsuchichiran.NonyuTsuchIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshukaishitsuchishokarihakkoichiran.TokubetsuChoshuKaishiSource;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
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
    private final NonyuTsuchIchiranBatchParameter バッチパラメータ;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final RString 帳票作成日時;
    private final RString 市町村コード;
    private final RString 市町村名;
    private final int num;
    private static final int NUM0 = 0;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int SIZE = 18;
    private final RString 特別徴収開始通知書 = new RString("特別徴収開始通知書（本算定）発行一覧表");
    private final RString 定値_10月 = new RString("10月");
    private final RString 定値_12月 = new RString("12月");
    private final RString 定値_18 = new RString("18");
    private final RString 定値_2月 = new RString("2月");
    private final RString 定値_作成 = new RString("作成");
    private final RString 本徴収額 = new RString("本徴収額");

    /**
     * インスタンスを生成します。
     *
     * @param 編集後本算定通知書共通情報 List<EditedHonSanteiTsuchiShoKyotsu>
     * @param バッチパラメータ NonyuTsuchIchiranBatchParameter
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト 改頁項目リスト
     * @param 帳票作成日時 RString
     * @param 市町村コード RString
     * @param 市町村名 RString
     * @param num int
     */
    protected TokubetsuChoshuKaishiEditor(EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報,
            NonyuTsuchIchiranBatchParameter バッチパラメータ, List<RString> 出力項目リスト, List<RString> 改頁項目リスト,
            RString 帳票作成日時, RString 市町村コード, RString 市町村名, int num) {
        this.編集後本算定通知書共通情報 = 編集後本算定通知書共通情報;
        this.バッチパラメータ = バッチパラメータ;
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
        RDate date = new RDate(帳票作成日時.toString());
        RTime time = RDate.getNowTime();
        RString timeFormat = time.toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
        source.printTimeStamp = new RString(date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().toString()
                + RString.HALF_SPACE + timeFormat + RString.HALF_SPACE + 定値_作成);
        source.title = 特別徴収開始通知書;
        source.hokenshaNo = 市町村コード;
        source.hokenshaName = 市町村名;
        listlowers(source);
        source.listLower_6 = 定値_10月;
        for (CharacteristicsPhase entity : 編集後本算定通知書共通情報.get更正後().get特徴期別金額リスト()) {
            if (Integer.valueOf(entity.get期().toString()) == NUM4) {
                source.listLower_7 = new RString(entity.get金額().toString());
            }
            if (Integer.valueOf(entity.get期().toString()) == NUM5) {
                source.listLower_9 = new RString(entity.get金額().toString());
            }
            if (Integer.valueOf(entity.get期().toString()) == NUM6) {
                source.listLower_11 = new RString(entity.get金額().toString());
            }
        }
        source.listLower_8 = 定値_12月;
        source.listLower_10 = 定値_2月;
        if (バッチパラメータ != null) {
            source.nendo = バッチパラメータ.get賦課年度();
        }
        for (int i = NUM0; i < 出力項目リスト.size(); i++) {
            source.shutsuryokujun3 = 出力項目リスト.get(i);
            source.kaipage1 = 改頁項目リスト.get(i);
        }
    }

    /**
     * listlowers
     *
     * @param source TokubetsuChoshuKaishiSource
     */
    private void listlowers(TokubetsuChoshuKaishiSource source) {
        source.titleChoshugaku = 本徴収額;
        if ((num + 1) % SIZE != 0) {
            source.listUpper_1 = new RString(Integer.valueOf((num + 1) % SIZE).toString());
        } else {
            source.listUpper_1 = 定値_18;
        }
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
        if (編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.get更正後().get特別徴収義務者() != null) {
            source.listLower_4 = 編集後本算定通知書共通情報.get更正後().get特別徴収義務者();
        }
        if (編集後本算定通知書共通情報.get更正後() != null && 編集後本算定通知書共通情報.get更正後().get特別徴収対象年金コード() != null) {
            source.listLower_5 = new RString(編集後本算定通知書共通情報.get更正後().get特別徴収対象年金コード().toString());
        }
    }
}

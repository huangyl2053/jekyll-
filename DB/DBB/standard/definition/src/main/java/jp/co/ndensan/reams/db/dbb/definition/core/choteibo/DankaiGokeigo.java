/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.core.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 段階合計後用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class DankaiGokeigo {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final Integer dogetsuFlag;
    private final Decimal zengetsusueKensuCount;
    private final Decimal zengetsusueChoteigakuCount;
    private final Decimal dogetsusueKensuCount;
    private final Decimal dogetsusueChoteigakuCount;
    private final Decimal tokuchosyaKensuCount;
    private final Decimal fuchosyaKensuCount;
    private final Decimal naiheisyaKensuCount;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     * @param 前月末の全部件数の合計 前月末の全部件数の合計
     * @param 前月末の全部調定額の合計 前月末の全部調定額の合計
     * @param 当月末の全部件数の合計 当月末の全部件数の合計
     * @param 当月末の全部調定額の合計 当月末の全部調定額の合計
     * @param 特徴者数の合計 特徴者数の合計
     * @param 普徴者数の合計 普徴者数の合計
     * @param 内併徴者数の合計 内併徴者数の合計
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private DankaiGokeigo(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Integer 当月フラグ,
            Decimal 前月末の全部件数の合計,
            Decimal 前月末の全部調定額の合計,
            Decimal 当月末の全部件数の合計,
            Decimal 当月末の全部調定額の合計,
            Decimal 特徴者数の合計,
            Decimal 普徴者数の合計,
            Decimal 内併徴者数の合計) {

        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.choshuHouhou = 徴収方法;
        this.dogetsuFlag = 当月フラグ;
        this.zengetsusueKensuCount = 前月末の全部件数の合計;
        this.zengetsusueChoteigakuCount = 前月末の全部調定額の合計;
        this.dogetsusueKensuCount = 当月末の全部件数の合計;
        this.dogetsusueChoteigakuCount = 当月末の全部調定額の合計;
        this.tokuchosyaKensuCount = 特徴者数の合計;
        this.fuchosyaKensuCount = 普徴者数の合計;
        this.naiheisyaKensuCount = 内併徴者数の合計;
    }

    /**
     * 段階合計後用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     * @param 前月末の全部件数の合計 前月末の全部件数の合計
     * @param 前月末の全部調定額の合計 前月末の全部調定額の合計
     * @param 当月末の全部件数の合計 当月末の全部件数の合計
     * @param 当月末の全部調定額の合計 当月末の全部調定額の合計
     * @param 特徴者数の合計 特徴者数の合計
     * @param 普徴者数の合計 普徴者数の合計
     * @param 内併徴者数の合計 内併徴者数の合計
     * @return 段階合計後用パラメータ
     */
    public static DankaiGokeigo createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Integer 当月フラグ,
            Decimal 前月末の全部件数の合計,
            Decimal 前月末の全部調定額の合計,
            Decimal 当月末の全部件数の合計,
            Decimal 当月末の全部調定額の合計,
            Decimal 特徴者数の合計,
            Decimal 普徴者数の合計,
            Decimal 内併徴者数の合計
    ) {
        return new DankaiGokeigo(調定年度, 賦課年度, 徴収方法, 当月フラグ, 前月末の全部件数の合計,
                前月末の全部調定額の合計, 当月末の全部件数の合計, 当月末の全部調定額の合計, 特徴者数の合計,
                普徴者数の合計, 内併徴者数の合計);
    }

}

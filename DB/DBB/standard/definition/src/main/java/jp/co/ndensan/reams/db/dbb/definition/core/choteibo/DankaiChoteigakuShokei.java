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
 * 段階調定額小計用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class DankaiChoteigakuShokei {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final RString dankai;
    private final Integer dogetsuFlag;
    private final Decimal zengetsusueChoteigakuCount;
    private final Decimal dogetsusueChoteigakuCount;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 段階 段階
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     * @param 該当する段階の前月末の調定額の小計 該当する段階の前月末の調定額の小計
     * @param 該当する段階の当月末の調定額の小計 該当する段階の当月末の調定額の小計
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private DankaiChoteigakuShokei(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 段階,
            RString 徴収方法,
            Integer 当月フラグ,
            Decimal 該当する段階の前月末の調定額の小計,
            Decimal 該当する段階の当月末の調定額の小計) {

        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.dankai = 段階;
        this.choshuHouhou = 徴収方法;
        this.dogetsuFlag = 当月フラグ;
        this.zengetsusueChoteigakuCount = 該当する段階の前月末の調定額の小計;
        this.dogetsusueChoteigakuCount = 該当する段階の当月末の調定額の小計;
    }

    /**
     * 段階調定額小計用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 段階 段階
     * @param 徴収方法 徴収方法
     * @param 当月フラグ 当月フラグ
     * @param 該当する段階の前月末の調定額の小計 該当する段階の前月末の調定額の小計
     * @param 該当する段階の当月末の調定額の小計 該当する段階の当月末の調定額の小計
     * @return 段階調定額小計用パラメータ
     */
    public static DankaiChoteigakuShokei createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 段階,
            RString 徴収方法,
            Integer 当月フラグ,
            Decimal 該当する段階の前月末の調定額の小計,
            Decimal 該当する段階の当月末の調定額の小計
    ) {
        return new DankaiChoteigakuShokei(調定年度, 賦課年度, 段階, 徴収方法,
                当月フラグ, 該当する段階の前月末の調定額の小計, 該当する段階の当月末の調定額の小計);
    }

}

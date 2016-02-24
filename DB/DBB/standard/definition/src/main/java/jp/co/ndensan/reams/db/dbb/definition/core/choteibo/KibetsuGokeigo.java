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
 * 期別合計後用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KibetsuGokeigo {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final Decimal tobetsuChoteiGakuCount;
    private final Decimal futsuChoteiGakuCount;
    private final Decimal tobetsuTofutsuChoteiGakuCount;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 特別徴収の調定額の合計 特別徴収の調定額の合計
     * @param 普通徴収の調定額の合計 普通徴収の調定額の合計
     * @param 特徴と普徴の合計 特徴と普徴の合計
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KibetsuGokeigo(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Decimal 特別徴収の調定額の合計,
            Decimal 普通徴収の調定額の合計,
            Decimal 特徴と普徴の合計) {

        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.choshuHouhou = 徴収方法;
        this.tobetsuChoteiGakuCount = 特別徴収の調定額の合計;
        this.futsuChoteiGakuCount = 普通徴収の調定額の合計;
        this.tobetsuTofutsuChoteiGakuCount = 特徴と普徴の合計;
    }

    /**
     * 期別合計後用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 特別徴収の調定額の合計 特別徴収の調定額の合計
     * @param 普通徴収の調定額の合計 普通徴収の調定額の合計
     * @param 特徴と普徴の合計 特徴と普徴の合計
     * @return 期別合計後用パラメータ
     */
    public static KibetsuGokeigo createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Decimal 特別徴収の調定額の合計,
            Decimal 普通徴収の調定額の合計,
            Decimal 特徴と普徴の合計
    ) {
        return new KibetsuGokeigo(調定年度, 賦課年度, 徴収方法, 特別徴収の調定額の合計, 普通徴収の調定額の合計,
                特徴と普徴の合計);
    }

}

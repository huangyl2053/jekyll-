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
 * 期別小計用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public final class KibetsuShokei {

    private final FlexibleYear choteiNendo;
    private final FlexibleYear fukaNendo;
    private final RString choshuHouhou;
    private final Decimal dai1kiChoteiGakuCount;
    private final Decimal dai2kiChoteiGakuCount;
    private final Decimal dai3kiChoteiGakuCount;
    private final Decimal dai4kiChoteiGakuCount;
    private final Decimal dai5kiChoteiGakuCount;
    private final Decimal dai6kiChoteiGakuCount;
    private final Decimal dai7kiChoteiGakuCount;
    private final Decimal dai8kiChoteiGakuCount;
    private final Decimal dai9kiChoteiGakuCount;
    private final Decimal dai10kiChoteiGakuCount;
    private final Decimal dai11kiChoteiGakuCount;
    private final Decimal dai12kiChoteiGakuCount;
    private final Decimal dai13kiChoteiGakuCount;
    private final Decimal dai14kiChoteiGakuCount;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 第1期の調定額の小計 第1期の調定額の小計
     * @param 第2期の調定額の小計 第2期の調定額の小計
     * @param 第3期の調定額の小計 第3期の調定額の小計
     * @param 第4期の調定額の小計 第4期の調定額の小計
     * @param 第5期の調定額の小計 第5期の調定額の小計
     * @param 第6期の調定額の小計 第6期の調定額の小計
     * @param 第7期の調定額の小計 第7期の調定額の小計
     * @param 第8期の調定額の小計 第8期の調定額の小計
     * @param 第9期の調定額の小計 第9期の調定額の小計
     * @param 第10期の調定額の小計 第10期の調定額の小計
     * @param 第11期の調定額の小計 第11期の調定額の小計
     * @param 第12期の調定額の小計 第12期の調定額の小計
     * @param 第13期の調定額の小計 第13期の調定額の小計
     * @param 第14期の調定額の小計 第14期の調定額の小計
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KibetsuShokei(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Decimal 第1期の調定額の小計,
            Decimal 第2期の調定額の小計,
            Decimal 第3期の調定額の小計,
            Decimal 第4期の調定額の小計,
            Decimal 第5期の調定額の小計,
            Decimal 第6期の調定額の小計,
            Decimal 第7期の調定額の小計,
            Decimal 第8期の調定額の小計,
            Decimal 第9期の調定額の小計,
            Decimal 第10期の調定額の小計,
            Decimal 第11期の調定額の小計,
            Decimal 第12期の調定額の小計,
            Decimal 第13期の調定額の小計,
            Decimal 第14期の調定額の小計) {

        this.choteiNendo = 調定年度;
        this.fukaNendo = 賦課年度;
        this.choshuHouhou = 徴収方法;
        this.dai1kiChoteiGakuCount = 第1期の調定額の小計;
        this.dai2kiChoteiGakuCount = 第2期の調定額の小計;
        this.dai3kiChoteiGakuCount = 第3期の調定額の小計;
        this.dai4kiChoteiGakuCount = 第4期の調定額の小計;
        this.dai5kiChoteiGakuCount = 第5期の調定額の小計;
        this.dai6kiChoteiGakuCount = 第6期の調定額の小計;
        this.dai7kiChoteiGakuCount = 第7期の調定額の小計;
        this.dai8kiChoteiGakuCount = 第8期の調定額の小計;
        this.dai9kiChoteiGakuCount = 第9期の調定額の小計;
        this.dai10kiChoteiGakuCount = 第10期の調定額の小計;
        this.dai11kiChoteiGakuCount = 第11期の調定額の小計;
        this.dai12kiChoteiGakuCount = 第12期の調定額の小計;
        this.dai13kiChoteiGakuCount = 第13期の調定額の小計;
        this.dai14kiChoteiGakuCount = 第14期の調定額の小計;
    }

    /**
     * 期別小計用パラメータを生成します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 徴収方法 徴収方法
     * @param 第1期の調定額の小計 第1期の調定額の小計
     * @param 第2期の調定額の小計 第2期の調定額の小計
     * @param 第3期の調定額の小計 第3期の調定額の小計
     * @param 第4期の調定額の小計 第4期の調定額の小計
     * @param 第5期の調定額の小計 第5期の調定額の小計
     * @param 第6期の調定額の小計 第6期の調定額の小計
     * @param 第7期の調定額の小計 第7期の調定額の小計
     * @param 第8期の調定額の小計 第8期の調定額の小計
     * @param 第9期の調定額の小計 第9期の調定額の小計
     * @param 第10期の調定額の小計 第10期の調定額の小計
     * @param 第11期の調定額の小計 第11期の調定額の小計
     * @param 第12期の調定額の小計 第12期の調定額の小計
     * @param 第13期の調定額の小計 第13期の調定額の小計
     * @param 第14期の調定額の小計 第14期の調定額の小計
     * @return 期別小計用パラメータ
     */
    public static KibetsuShokei createParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 徴収方法,
            Decimal 第1期の調定額の小計,
            Decimal 第2期の調定額の小計,
            Decimal 第3期の調定額の小計,
            Decimal 第4期の調定額の小計,
            Decimal 第5期の調定額の小計,
            Decimal 第6期の調定額の小計,
            Decimal 第7期の調定額の小計,
            Decimal 第8期の調定額の小計,
            Decimal 第9期の調定額の小計,
            Decimal 第10期の調定額の小計,
            Decimal 第11期の調定額の小計,
            Decimal 第12期の調定額の小計,
            Decimal 第13期の調定額の小計,
            Decimal 第14期の調定額の小計
    ) {
        return new KibetsuShokei(調定年度, 賦課年度, 徴収方法, 第1期の調定額の小計, 第2期の調定額の小計,
                第3期の調定額の小計, 第4期の調定額の小計, 第5期の調定額の小計, 第6期の調定額の小計,
                第7期の調定額の小計, 第8期の調定額の小計, 第9期の調定額の小計, 第10期の調定額の小計,
                第11期の調定額の小計, 第12期の調定額の小計, 第13期の調定額の小計, 第14期の調定額の小計);
    }

}

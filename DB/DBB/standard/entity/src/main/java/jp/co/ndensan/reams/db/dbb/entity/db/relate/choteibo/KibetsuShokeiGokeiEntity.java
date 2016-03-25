/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期別小計の合計情報Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuShokeiGokeiEntity {

    private static final int 第1期 = 1;
    private static final int 第2期 = 2;
    private static final int 第3期 = 3;
    private static final int 第4期 = 4;
    private static final int 第5期 = 5;
    private static final int 第6期 = 6;
    private static final int 第7期 = 7;
    private static final int 第8期 = 8;
    private static final int 第9期 = 9;
    private static final int 第10期 = 10;
    private static final int 第11期 = 11;
    private static final int 第12期 = 12;
    private static final int 第13期 = 13;
    private static final int 第14期 = 14;
    /**
     * 調定年度
     */
    private FlexibleYear choteiNendo;
    /**
     * 賦課年度
     */
    private FlexibleYear fukaNendo;
    /**
     * 徴収方法
     */
    private RString choshuHouhou;
    /**
     * 第1期の調定額の合計
     */
    private Decimal dai1kiChoteigakuGokei;
    /**
     * 第2期の調定額の合計
     */
    private Decimal dai2kiChoteigakuGokei;
    /**
     * 第3期の調定額の合計
     */
    private Decimal dai3kiChoteigakuGokei;
    /**
     * 第4期の調定額の合計
     */
    private Decimal dai4kiChoteigakuGokei;
    /**
     * 第5期の調定額の合計
     */
    private Decimal dai5kiChoteigakuGokei;
    /**
     * 第6期の調定額の合計
     */
    private Decimal dai6kiChoteigakuGokei;
    /**
     * 第7期の調定額の合計
     */
    private Decimal dai7kiChoteigakuGokei;
    /**
     * 第8期の調定額の合計
     */
    private Decimal dai8kiChoteigakuGokei;
    /**
     * 第9期の調定額の合計
     */
    private Decimal dai9kiChoteigakuGokei;
    /**
     * 第10期の調定額の合計
     */
    private Decimal dai10kiChoteigakuGokei;
    /**
     * 第11期の調定額の合計
     */
    private Decimal dai11kiChoteigakuGokei;
    /**
     * 第12期の調定額の合計
     */
    private Decimal dai12kiChoteigakuGokei;
    /**
     * 第13期の調定額の合計
     */
    private Decimal dai13kiChoteigakuGokei;
    /**
     * 第14期の調定額の合計
     */
    private Decimal dai14kiChoteigakuGokei;

    /**
     * 第○期の調定額の合計を取得する。
     *
     * @param 期別 期別
     * @return Decimal Decimal
     */
    public Decimal get調定額の合計By期別(int 期別) {
        switch (期別) {
            case 第1期:
                return dai1kiChoteigakuGokei;
            case 第2期:
                return dai2kiChoteigakuGokei;
            case 第3期:
                return dai3kiChoteigakuGokei;
            case 第4期:
                return dai4kiChoteigakuGokei;
            case 第5期:
                return dai5kiChoteigakuGokei;
            case 第6期:
                return dai6kiChoteigakuGokei;
            case 第7期:
                return dai7kiChoteigakuGokei;
            case 第8期:
                return dai8kiChoteigakuGokei;
            case 第9期:
                return dai9kiChoteigakuGokei;
            case 第10期:
                return dai10kiChoteigakuGokei;
            case 第11期:
                return dai11kiChoteigakuGokei;
            case 第12期:
                return dai12kiChoteigakuGokei;
            case 第13期:
                return dai13kiChoteigakuGokei;
            case 第14期:
                return dai14kiChoteigakuGokei;
            default:
                return null;
        }
    }
}

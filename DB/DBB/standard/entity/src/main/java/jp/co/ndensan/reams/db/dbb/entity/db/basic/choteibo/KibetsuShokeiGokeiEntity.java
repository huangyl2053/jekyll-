/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期別小計の合計情報Entityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuShokeiGokeiEntity {

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
     * @param 期別
     * @return Decimal
     */
    public Decimal get調定額の合計By期別(int 期別) {
        switch (期別) {
            case 1:
                return dai1kiChoteigakuGokei;
            case 2:
                return dai2kiChoteigakuGokei;
            case 3:
                return dai3kiChoteigakuGokei;
            case 4:
                return dai4kiChoteigakuGokei;
            case 5:
                return dai5kiChoteigakuGokei;
            case 6:
                return dai6kiChoteigakuGokei;
            case 7:
                return dai7kiChoteigakuGokei;
            case 8:
                return dai8kiChoteigakuGokei;
            case 9:
                return dai9kiChoteigakuGokei;
            case 10:
                return dai10kiChoteigakuGokei;
            case 11:
                return dai11kiChoteigakuGokei;
            case 12:
                return dai12kiChoteigakuGokei;
            case 13:
                return dai13kiChoteigakuGokei;
            case 14:
                return dai14kiChoteigakuGokei;
            default:
                return null;
        }
    }
}

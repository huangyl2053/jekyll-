/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 期別小計一時テーブルEntityです。
 */
@lombok.Getter
@lombok.Setter
public class KibetsuShokeiEntity implements IDbAccessable {

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
     * 第1期の調定額の小計
     */
    private Decimal dai1kiChoteigakuCount;
    /**
     * 第2期の調定額の小計
     */
    private Decimal dai2kiChoteigakuCount;
    /**
     * 第3期の調定額の小計
     */
    private Decimal dai3kiChoteigakuCount;
    /**
     * 第4期の調定額の小計
     */
    private Decimal dai4kiChoteigakuCount;
    /**
     * 第5期の調定額の小計
     */
    private Decimal dai5kiChoteigakuCount;
    /**
     * 第6期の調定額の小計
     */
    private Decimal dai6kiChoteigakuCount;
    /**
     * 第7期の調定額の小計
     */
    private Decimal dai7kiChoteigakuCount;
    /**
     * 第8期の調定額の小計
     */
    private Decimal dai8kiChoteigakuCount;
    /**
     * 第9期の調定額の小計
     */
    private Decimal dai9kiChoteigakuCount;
    /**
     * 第10期の調定額の小計
     */
    private Decimal dai10kiChoteigakuCount;
    /**
     * 第11期の調定額の小計
     */
    private Decimal dai11kiChoteigakuCount;
    /**
     * 第12期の調定額の小計
     */
    private Decimal dai12kiChoteigakuCount;
    /**
     * 第13期の調定額の小計
     */
    private Decimal dai13kiChoteigakuCount;
    /**
     * 第14期の調定額の小計
     */
    private Decimal dai14kiChoteigakuCount;

    /**
     * 第○期の調定額の小計を取得する。
     *
     * @param 期別 期別
     * @return Decimal Decimal
     */
    public Decimal get調定額の小計By期別(int 期別) {
        switch (期別) {
            case 第1期:
                return dai1kiChoteigakuCount;
            case 第2期:
                return dai2kiChoteigakuCount;
            case 第3期:
                return dai3kiChoteigakuCount;
            case 第4期:
                return dai4kiChoteigakuCount;
            case 第5期:
                return dai5kiChoteigakuCount;
            case 第6期:
                return dai6kiChoteigakuCount;
            case 第7期:
                return dai7kiChoteigakuCount;
            case 第8期:
                return dai8kiChoteigakuCount;
            case 第9期:
                return dai9kiChoteigakuCount;
            case 第10期:
                return dai10kiChoteigakuCount;
            case 第11期:
                return dai11kiChoteigakuCount;
            case 第12期:
                return dai12kiChoteigakuCount;
            case 第13期:
                return dai13kiChoteigakuCount;
            case 第14期:
                return dai14kiChoteigakuCount;
            default:
                return null;
        }
    }

}

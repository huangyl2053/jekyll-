/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.basic.choteibo;

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
     * @param 期別
     * @return Decimal
     */
    public Decimal get調定額の小計By期別(int 期別) {
        switch (期別) {
            case 1:
                return dai1kiChoteigakuCount;
            case 2:
                return dai2kiChoteigakuCount;
            case 3:
                return dai3kiChoteigakuCount;
            case 4:
                return dai4kiChoteigakuCount;
            case 5:
                return dai5kiChoteigakuCount;
            case 6:
                return dai6kiChoteigakuCount;
            case 7:
                return dai7kiChoteigakuCount;
            case 8:
                return dai8kiChoteigakuCount;
            case 9:
                return dai9kiChoteigakuCount;
            case 10:
                return dai10kiChoteigakuCount;
            case 11:
                return dai11kiChoteigakuCount;
            case 12:
                return dai12kiChoteigakuCount;
            case 13:
                return dai13kiChoteigakuCount;
            case 14:
                return dai14kiChoteigakuCount;
            default:
                return null;
        }
    }

}

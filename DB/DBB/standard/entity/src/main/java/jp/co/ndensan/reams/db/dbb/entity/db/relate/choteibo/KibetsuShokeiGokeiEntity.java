/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.choteibo;

import jp.co.ndensan.reams.db.dbz.definition.core.util.ConversionUtil;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 期別小計の合計情報Entityクラスです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
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
    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private Decimal dai1kiChoteigakuGokei;
    private Decimal dai2kiChoteigakuGokei;
    private Decimal dai3kiChoteigakuGokei;
    private Decimal dai4kiChoteigakuGokei;
    private Decimal dai5kiChoteigakuGokei;
    private Decimal dai6kiChoteigakuGokei;
    private Decimal dai7kiChoteigakuGokei;
    private Decimal dai8kiChoteigakuGokei;
    private Decimal dai9kiChoteigakuGokei;
    private Decimal dai10kiChoteigakuGokei;
    private Decimal dai11kiChoteigakuGokei;
    private Decimal dai12kiChoteigakuGokei;
    private Decimal dai13kiChoteigakuGokei;
    private Decimal dai14kiChoteigakuGokei;

    /**
     * 第○期の調定額の合計を取得する。
     *
     * @param 期別 期別
     * @return Decimal 期の調定額の合計
     */
    public Decimal get調定額の合計By期別(RString 期別) {
        switch (ConversionUtil.toIntOrDefualt(期別, -1)) {
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

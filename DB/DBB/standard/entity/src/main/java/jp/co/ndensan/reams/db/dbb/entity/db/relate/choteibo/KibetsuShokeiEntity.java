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
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 期別小計一時テーブルEntityです。
 *
 * @reamsid_L DBB-0770-030 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
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
    private FlexibleYear choteiNendo;
    private FlexibleYear fukaNendo;
    private RString choshuHouhou;
    private Decimal dai1kiChoteigakuCount;
    private Decimal dai2kiChoteigakuCount;
    private Decimal dai3kiChoteigakuCount;
    private Decimal dai4kiChoteigakuCount;
    private Decimal dai5kiChoteigakuCount;
    private Decimal dai6kiChoteigakuCount;
    private Decimal dai7kiChoteigakuCount;
    private Decimal dai8kiChoteigakuCount;
    private Decimal dai9kiChoteigakuCount;
    private Decimal dai10kiChoteigakuCount;
    private Decimal dai11kiChoteigakuCount;
    private Decimal dai12kiChoteigakuCount;
    private Decimal dai13kiChoteigakuCount;
    private Decimal dai14kiChoteigakuCount;

    /**
     * 第○期の調定額の小計を取得する。
     *
     * @param 期別 期別
     * @return Decimal 期の調定額の小計
     */
    public Decimal get調定額の小計By期別(RString 期別) {
        switch (ConversionUtil.toIntOrDefualt(期別, -1)) {
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

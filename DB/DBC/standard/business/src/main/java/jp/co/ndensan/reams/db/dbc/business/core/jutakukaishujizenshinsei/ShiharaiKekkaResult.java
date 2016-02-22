/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishujizenshinsei;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支払結果情報のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiKekkaResult {

    public Decimal 費用額合計;
    public Decimal 保険対象費用額;
    public Decimal 保険給付額;
    public Decimal 利用者負担額;
    public RString 住宅改修住宅住所;

    public ShiharaiKekkaResult() {
        this.費用額合計 = null;
        this.保険対象費用額 = null;
        this.保険給付額 = null;
        this.利用者負担額 = null;
        this.住宅改修住宅住所 = null;
    }
}

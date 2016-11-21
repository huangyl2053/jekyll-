/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 最新住宅改修の住宅住所Entityクラスです。
 *
 * @reamsid_L DBC-0990-080 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShiharaiKekaEntity implements Cloneable, Serializable {

    private Decimal 費用額合計;
    private Decimal 保険対象費用額;
    private Decimal 保険給付額;
    private Decimal 利用者負担額;
    private RString 住宅改修住宅住所;
    private FlexibleYearMonth 開始サービス提供年月;
}

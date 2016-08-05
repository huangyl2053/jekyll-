/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujikosakusei;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 短期入所情報用Entityクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TankiNyushoEntity {

    private Decimal 前回迄利用日数;
    private Decimal 今回計画利用日数;
    private RString 暫定区分;
    private RString 更新区分;
    private FlexibleYearMonth 送付年月;
}

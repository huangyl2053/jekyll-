/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.taino;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付額減額明細entityクラスです。
 *
 * @reamsid_L DBD-3620-060 liangbc
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufugakuGengakuMeisai implements Serializable {

    private final FlexibleYear 調定年度;
    private final Decimal 時効到来未納額;
    private final Decimal 調定額;
    private final Decimal 収入額;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 時効到来未納額 時効到来未納額
     * @param 調定額 調定額
     * @param 収入額 収入額
     */
    public KyufugakuGengakuMeisai(FlexibleYear 調定年度, Decimal 時効到来未納額, Decimal 調定額, Decimal 収入額) {
        this.調定年度 = 調定年度;
        this.時効到来未納額 = 時効到来未納額;
        this.調定額 = 調定額;
        this.収入額 = 収入額;
    }
}

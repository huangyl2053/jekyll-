/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 合計計算処理結果のオブジェクトクラスです。
 *
 * @reamsid_L DBC-1930-060 cuilin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiKeisan {

    private Decimal 費用総額;
    private Decimal 保険給付額;
    private Decimal 保険対象利用者負担額;
    private Decimal 全額利用者負担額;
}

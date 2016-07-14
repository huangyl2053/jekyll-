/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigosakuseimeisaitouroku;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBC0120031_サービス利用票情報
 *
 * @reamsid_L DBC-1930-060 xupeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GokeiKeisan {

    private Decimal 利用者負担額;
    private Decimal 種類限度超過単位;
    private Decimal 種類限度内単位;
    private Decimal 単位数単価;
    private Decimal 区分限度超過単位;
    private Decimal 区分限度内単位;
    private Decimal 給付率;
    private Decimal サービス単位;
    private Decimal 費用総額;
    private Decimal 保険給付額;
    private Decimal 保険対象利用者負担額;
    private Decimal 全額利用者負担額;
}

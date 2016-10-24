/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.dbc020080;

import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額支給額加算額計算の情報クラスです。
 *
 * @reamsid_L DBC-2060-050 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class KogakuShikyugakuJoho {

    private Decimal 高額支給額加算額;
    private boolean wKm_blnIchiranKBN1;
    private boolean wKm_blnIchiranKBN2;

    /**
     * KogakuShikyugakuJohoのコンストラクタです。
     */
    public KogakuShikyugakuJoho() {
        高額支給額加算額 = Decimal.ZERO;
        wKm_blnIchiranKBN1 = false;
        wKm_blnIchiranKBN2 = false;
    }

}

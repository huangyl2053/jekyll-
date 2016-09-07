/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス提供証明書のオブジェクトクラスです。
 *
 * @reamsid_L DBC-1010-180 panhe
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShukeiResult implements Serializable {

    private final ShokanShukei shukei;
    private final RString serviceShuruiRyakusho;

    /**
     * コンストラクタです。
     *
     * @param shukei ShokanShukei
     * @param serviceShuruiRyakusho RString
     */
    public ShokanShukeiResult(ShokanShukei shukei, RString serviceShuruiRyakusho) {
        this.shukei = shukei;
        this.serviceShuruiRyakusho = serviceShuruiRyakusho;
    }
}

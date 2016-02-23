/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShakaiFukushiHojinKeigengaku;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求社会福祉法人軽減額のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShakaiFukushiHojinKeigengakuResult implements Serializable {

    private final ShokanShakaiFukushiHojinKeigengaku shokanShakaiFukushiHojinKeigengaku;
    private final RString serviceShuruiRyakusho;

    /**
     * コンストラクタです。
     *
     * @param shokanShakaiFukushiHojinKeigengaku ShokanShakaiFukushiHojinKeigengaku
     * @param serviceShuruiRyakusho RString
     */
    public ShokanShakaiFukushiHojinKeigengakuResult(
            ShokanShakaiFukushiHojinKeigengaku shokanShakaiFukushiHojinKeigengaku,
            RString serviceShuruiRyakusho) {
        this.shokanShakaiFukushiHojinKeigengaku = shokanShakaiFukushiHojinKeigengaku;
        this.serviceShuruiRyakusho = serviceShuruiRyakusho;
    }
}

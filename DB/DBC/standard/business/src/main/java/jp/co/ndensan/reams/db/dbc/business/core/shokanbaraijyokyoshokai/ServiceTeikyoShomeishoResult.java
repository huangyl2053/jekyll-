/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraijyokyoshokai.ServiceTeikyoShomeisho;

/**
 * サービス提供証明書のオブジェクトクラスです。
 *
 * @reamsid_L DBC-1010-180 panhe
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ServiceTeikyoShomeishoResult implements Serializable {

    private ServiceTeikyoShomeisho serviceTeikyoShomeisho;

    /**
     * サービス提供証明書のオブジェクトを生成します
     *
     * @param serviceTeikyoShomeisho ServiceTeikyoShomeisho
     */
    public ServiceTeikyoShomeishoResult(ServiceTeikyoShomeisho serviceTeikyoShomeisho) {
        this.serviceTeikyoShomeisho = serviceTeikyoShomeisho;
    }
}

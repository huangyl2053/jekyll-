/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200004;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス提供証明書のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanServicePlan200004Result {

    private final ShokanServicePlan200004 entity;
    private final RString serviceName;

    /**
     * コンストラクタです。
     *
     * @param entity ShokanServicePlan200004
     * @param serviceName RString
     */
    public ShokanServicePlan200004Result(ShokanServicePlan200004 entity, RString serviceName) {
        this.entity = entity;
        this.serviceName = serviceName;
    }
}

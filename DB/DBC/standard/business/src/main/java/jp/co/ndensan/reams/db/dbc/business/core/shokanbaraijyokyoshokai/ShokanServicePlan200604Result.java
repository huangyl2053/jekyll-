/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanServicePlan200604;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * サービス提供証明書のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanServicePlan200604Result implements Serializable {

    private final ShokanServicePlan200604 entity;
    private final RString serviceName;

    /**
     * コンストラクタです。
     *
     * @param entity ShokanServicePlan200604
     * @param serviceName RString
     */
    public ShokanServicePlan200604Result(ShokanServicePlan200604 entity, RString serviceName) {
        this.entity = entity;
        this.serviceName = serviceName;
    }
}

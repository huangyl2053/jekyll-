/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 宛名PSM
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikibetsuTaishoEntity {

    private UaFt200FindShikibetsuTaishoEntity 宛名PSM;

    /**
     * コンストラクタです。
     *
     * @param 宛名PSM UaFt200FindShikibetsuTaishoEntity
     */
    public ShikibetsuTaishoEntity(UaFt200FindShikibetsuTaishoEntity 宛名PSM) {
        this.宛名PSM = 宛名PSM;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.shichosonkado;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.shichoson.ShichosonJohoEntity;

/**
 * 市町村情報entity ShichosonKado
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonJohoResult {

    private final ShichosonJohoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity ShichosonJohoResult
     */
    public ShichosonJohoResult(ShichosonJohoEntity entity) {
        this.entity = entity;
    }
}

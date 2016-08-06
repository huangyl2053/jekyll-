/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbt4030011;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;

/**
 * 認定書情報を取得するクラス
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public class NinteishoJohoBusiness {

    private final NinteishoJohoEntity entity;

    /**
     * 認定書情報を返します。
     *
     * @param entity NinteishoJohoEntity
     */
    public NinteishoJohoBusiness(NinteishoJohoEntity entity) {
        this.entity = entity;
    }

    /**
     * 認定書情報Entityを返します。
     *
     * @return NinteishoJohoEntity
     */
    public NinteishoJohoEntity getEntity() {
        return entity;
    }

}

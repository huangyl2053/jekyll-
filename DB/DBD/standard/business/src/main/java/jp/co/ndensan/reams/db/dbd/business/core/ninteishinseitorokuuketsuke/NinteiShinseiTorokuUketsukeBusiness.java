/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.ninteishinseitorokuuketsuke;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5120001.NinteiShinseiTorokuUketsukeEntity;

/**
 * 要介護認定申請受付を取得するクラス。
 *
 * @reamsid_L DBD-1300-010 huangh
 */
public class NinteiShinseiTorokuUketsukeBusiness {

    private final NinteiShinseiTorokuUketsukeEntity entity;

    /**
     * 要介護認定申請受付情報を返します。
     *
     * @param entity NinteiShinseiTorokuUketsukeEntity
     */
    public NinteiShinseiTorokuUketsukeBusiness(NinteiShinseiTorokuUketsukeEntity entity) {
        this.entity = entity;
    }

    /**
     * 要介護認定申請受付を返します。
     *
     * @return NinteiShinseiTorokuUketsukeEntity
     */
    public NinteiShinseiTorokuUketsukeEntity getEntity() {
        return entity;
    }
}

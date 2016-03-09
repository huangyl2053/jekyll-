/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifuka.BatchTokuchoEntity;

/**
 *
 * @author chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class BatchTokuchoKariSanteiResult {

    private BatchTokuchoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public BatchTokuchoKariSanteiResult(BatchTokuchoEntity entity) {
        this.entity = entity;
    }
}

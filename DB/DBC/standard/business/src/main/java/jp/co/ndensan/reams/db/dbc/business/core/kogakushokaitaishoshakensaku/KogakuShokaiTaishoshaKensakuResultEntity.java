/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakushokaitaishoshakensaku.KogakuShokaiTaishoshaKensakuEntity;

/**
 * 高額介護サービス費一覧EntityResult
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiTaishoshaKensakuResultEntity {

    private KogakuShokaiTaishoshaKensakuEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public KogakuShokaiTaishoshaKensakuResultEntity(KogakuShokaiTaishoshaKensakuEntity entity) {
        this.entity = entity;
    }
}

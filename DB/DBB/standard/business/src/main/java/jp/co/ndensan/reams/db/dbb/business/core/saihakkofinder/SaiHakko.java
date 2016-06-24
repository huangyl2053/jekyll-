/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.saihakkofinder;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.saihakkofinder.SaiHakkoEntity;

/**
 * 再発行対象のクラス
 *
 * @reamsid_L DBB-1720-030 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaiHakko {

    private final SaiHakkoEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity SaiHakkoEntity
     */
    public SaiHakko(SaiHakkoEntity entity) {
        this.entity = entity;
    }
}

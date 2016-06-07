/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohoichiranhyo;

import jp.co.ndensan.reams.db.dbb.entity.db.shotokujohoichiranhyo.TaishoShuryoYmdEntity;

/**
 * 対象終了日時
 *
 * @reamsid_L DBB-1650-030 lijunjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TaishoShuryoYmd {

    private final TaishoShuryoYmdEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity TaishoShuryoYmdEntity
     */
    public TaishoShuryoYmd(TaishoShuryoYmdEntity entity) {
        this.entity = entity;
    }
}

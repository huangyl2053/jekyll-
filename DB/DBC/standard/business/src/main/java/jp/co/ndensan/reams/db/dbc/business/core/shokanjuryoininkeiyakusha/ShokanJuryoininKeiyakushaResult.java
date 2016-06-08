/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanjuryoininkeiyakusha;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanjuryoininkeiyakusha.ShokanJuryoininKeiyakushaEntity;

/**
 * 契約者一覧のクラスです。
 *
 * @reamsid_L DBC-2130-030 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanJuryoininKeiyakushaResult implements Serializable {

    private ShokanJuryoininKeiyakushaEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public ShokanJuryoininKeiyakushaResult(ShokanJuryoininKeiyakushaEntity entity) {
        this.entity = entity;
    }
}

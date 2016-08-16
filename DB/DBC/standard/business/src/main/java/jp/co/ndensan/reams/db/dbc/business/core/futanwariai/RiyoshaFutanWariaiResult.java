/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.futanwariai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;

/**
 * 利用者負担割合明細情報クラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RiyoshaFutanWariaiResult implements Serializable {

    private DbT3113RiyoshaFutanWariaiEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public RiyoshaFutanWariaiResult(DbT3113RiyoshaFutanWariaiEntity entity) {
        this.entity = entity;
    }
}

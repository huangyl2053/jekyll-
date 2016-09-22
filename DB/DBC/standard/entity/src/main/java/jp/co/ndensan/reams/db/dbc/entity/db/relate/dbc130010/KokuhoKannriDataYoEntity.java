/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130010;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 国保管理データ作成用データ取得Entity。
 *
 * @reamsid_L DBC-3020-030 dengwei
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokuhoKannriDataYoEntity {

    private Integer データ件数;
    private TorikomiKokuhoJyohoEntity 取込国保情報Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象Entity;
}

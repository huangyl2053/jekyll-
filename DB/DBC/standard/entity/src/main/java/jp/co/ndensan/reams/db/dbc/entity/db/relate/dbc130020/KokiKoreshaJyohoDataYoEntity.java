/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc130020;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 編集用のデータ取得Entity。
 *
 * @reamsid_L DBC-3020-040 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KokiKoreshaJyohoDataYoEntity {

    private Integer データ件数;
    private TorikomiKokiKoreshaJyohoEntity 取込後期高齢者情報Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名識別対象Entity;
}

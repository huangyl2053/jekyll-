/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 被保険者・宛名情報取得パラメータです。
 *
 * @reamsid_L DBC-2460-013 jiangwenkai
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiOutGetHihokenshaAtenaEntity {

    private DbWT1001HihokenshaTempEntity dbWT1001Entity;
    private DbV1001HihokenshaDaichoEntity dbV1001Entity;
    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;

}

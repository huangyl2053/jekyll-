/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 被保険者台帳・宛名情報のEntityクラスです。
 *
 * @reamsid_L DBC-1000-020 zuotao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaAtenaJohoEntity {

    private DbWT1513RiyoJokyoTokeihyoEntity dbWT1513Entity;
    private DbV1001HihokenshaDaichoEntity dbV1001Entity;
    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 被保険者のエンティティクラスです。
 *
 * @reamsid_L DBA-0510-010 duanzhanli
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoRelateEntity {

    private DbT1001HihokenshaDaichoEntity dbT100Entity;
    private UaFt200FindShikibetsuTaishoEntity uaFt200Entity;
    private ShisetsuNyutaishoEntity 入所施設Entity;
}

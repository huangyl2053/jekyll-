/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 出力対象データのエンティティクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoJohoEntity {

    private KogakuGassanTempEntity 高額合算一時;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳;
}

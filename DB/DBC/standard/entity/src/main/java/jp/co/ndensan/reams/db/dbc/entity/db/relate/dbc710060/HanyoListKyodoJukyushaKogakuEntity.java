/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710060;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 汎用リスト 共同処理用受給者情報（高額）のエンティティクラスです。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyodoJukyushaKogakuEntity {

    private DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity 受給者異動高額;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}

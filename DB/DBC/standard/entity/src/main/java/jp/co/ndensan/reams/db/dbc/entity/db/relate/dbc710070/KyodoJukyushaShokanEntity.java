/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710070;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 汎用リスト_共同処理用受給者情報（償還）のエンティティクラスです。
 *
 * @reamsid_L DBC-3099-020 zhouchuanlin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyodoJukyushaShokanEntity {

    private DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity 共同処理用受給者異動償還送付;
    private DbT1001HihokenshaDaichoEntity 被保険者台帳管理;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 汎用リスト(過誤申立情報)のエンティティクラスです。
 *
 * @reamsid_L DBC-3095-020 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKagoMoshitateEntity {

    private DbT3059KagoMoshitateEntity 過誤申立;
    private DbT1001HihokenshaDaichoEntity 最新被保台帳;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private JukyushaDaichoRealEntity 受給者台帳;
    private KagoMoshitateJukyoshaRealEntity 過誤申立事業者;
    private NijiYoboJigyoTaishoRealEntity 二次予防事業対象情報;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710080;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.KagoMoshitateJukyoshaRealEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.NijiYoboJigyoTaishoRealEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 汎用リスト(給付管理票)のエンティティクラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKyufuKanriHyoEntity {

    private DbT3015KyufuKanrihyo200604Entity 給付管理票;
    private DbT1001HihokenshaDaichoEntity 最新被保台帳;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private JukyushaDaichoKyufuKanriHyoEntity 受給者台帳;
    private DbT7130KaigoServiceShuruiEntity サービス種類;
    private KagoMoshitateJukyoshaRealEntity 計画事業者;
    private KagoMoshitateJukyoshaRealEntity サービス事業者;
    private KagoMoshitateJukyoshaRealEntity 居宅支援事業者;
    private NijiYoboJigyoTaishoRealEntity 二次予防事業対象情報;
}

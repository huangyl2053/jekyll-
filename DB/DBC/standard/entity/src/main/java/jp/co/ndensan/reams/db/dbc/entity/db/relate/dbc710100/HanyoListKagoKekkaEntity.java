/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710100;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.NijiYoboJigyoTaishoRealEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;

/**
 * 汎用リスト出力(過誤結果情報)のエンティティクラスです。
 *
 * @reamsid_L DBC-3094-020 qinzhen
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKagoKekkaEntity {

    private DbT3061KagoKetteiMeisaiEntity 過誤決定明細;
    private DbT1001HihokenshaDaichoEntity 最新被保台帳;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private KekkaJukyushaDaichoRealEntity 受給者台帳;
    private KagoKetteiJukyoshaRealEntity 過誤決定事業者;
    private NijiYoboJigyoTaishoRealEntity 二次予防事業対象情報;
    private DbT7130KaigoServiceShuruiEntity 介護サービス種類;
}

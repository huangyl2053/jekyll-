/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkogakugassanshikyugakukettei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;

/**
 * 汎用リスト出力(高額合算支給額決定情報)Entityクラスです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanShikyugakuKetteiEntity implements Serializable {

    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private DbT1001HihokenshaDaichoEntity 最新被保台帳;
    private UaFt250FindAtesakiEntity 宛先;
    private DbT4001JukyushaDaichoEntity 受給者台帳;
    private DbT3074KogakuGassanShikyuFushikyuKetteiEntity 高額合算支給不支給決定;
    private KozaRelateEntity 口座情報;
}

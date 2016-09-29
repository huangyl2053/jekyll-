/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 更新用一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShikyugakuUpdateTempRelateEntity implements IDbAccessable {

    private ShikyugakuUpdateTempEntity 更新用一時;
    private DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity 事業高額合算支給不支給決定;
    private DbT3074KogakuGassanShikyuFushikyuKetteiEntity 高額合算支給不支給決定;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private KozaRelateEntity 口座;
}

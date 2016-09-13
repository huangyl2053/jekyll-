/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;

/**
 * 出力対象データのエンティティクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JikoFutangakushomeishoEntity {

    private KogakuGassanTempEntity 高額合算一時;
    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細;
    private UaFt250FindAtesakiEntity 宛先;
}

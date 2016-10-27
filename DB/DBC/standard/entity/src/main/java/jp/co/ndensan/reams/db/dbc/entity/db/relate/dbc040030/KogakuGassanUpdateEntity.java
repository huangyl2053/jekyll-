/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;

/**
 * 高額合算自己負担額情報entityクラスです。
 *
 * @reamsid_L DBC-2320-060 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanUpdateEntity {

    private KogakugassanJikofutangakuInfoHoseiTempEntity 中間DBEntity;
    private DbT3071KogakuGassanJikoFutanGakuMeisaiEntity 高額合算自己負担額明細;
    private DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040040;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;

/**
 * 出力対象データのエンティティクラスです。
 *
 * @reamsid_L DBC-2380-030 pengxingyi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanJohoEntity {

    private DbT3068KogakuGassanShinseishoEntity 高額合算申請書;
    private DbT3070KogakuGassanJikoFutanGakuEntity 高額合算自己負担額;
}

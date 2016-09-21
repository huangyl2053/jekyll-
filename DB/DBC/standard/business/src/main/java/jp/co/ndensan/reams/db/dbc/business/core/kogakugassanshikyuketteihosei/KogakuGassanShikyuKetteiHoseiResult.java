/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakugassanshikyuketteihosei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;

/**
 * ビジネス設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-030 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuKetteiHoseiResult implements Serializable {

    private KogakuGassanShikyuFushikyuKettei 高額合算決定entity;
    private JigyoKogakuGassanShikyuFushikyuKettei 事業高額合算決定entity;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 送付対象データ取得エンティティ。
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiGetSoufuDataEntity {

    private DbT3056KogakuShikyuShinseiEntity 支給申請;
    private DbT3057KogakuShikyuHanteiKekkaEntity 支給判定結果;

}

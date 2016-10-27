/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細一時テーブルSQL検索結果クラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GdaekomiDetaiResultEntity {

    private DbT3057KogakuShikyuHanteiKekkaEntity 高額介護サービス費支給判定結果Entity;
    private DbT3056KogakuShikyuShinseiEntity 高額介護サービス費支給申請Entity;
    private DbT3058KogakuShikyuShinsaKetteiEntity 高額介護サービス費支給審査決定Entity;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3056KogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;

/**
 * 管理データ一時Entityを取得のエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class TyukannKogakuRelateEntity {

    private TempKyufujissekiTyukannEntity 給付実績中間高額Entity;
    private DbT3057KogakuShikyuHanteiKekkaEntity 高額判定結果全件Entity;
    private DbT3055KogakuKyufuTaishoshaGokeiEntity 高額合計全件Entity;
    private DbT3056KogakuShikyuShinseiEntity 高額申請全件Entity;
    private DbT3058KogakuShikyuShinsaKetteiEntity 高額審査決定全件Entity;

}

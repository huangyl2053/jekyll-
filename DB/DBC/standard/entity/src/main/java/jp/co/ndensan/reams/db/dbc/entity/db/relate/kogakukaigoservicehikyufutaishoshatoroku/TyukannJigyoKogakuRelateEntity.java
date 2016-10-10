/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3110JigyoKogakuShikyuShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;

/**
 * 管理データ一時Entityを取得のエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class TyukannJigyoKogakuRelateEntity {

    private TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額Entity;
    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity 事業高額判定結果全件Entity;
    private DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity 事業高額合計全件Entity;
    private DbT3110JigyoKogakuShikyuShinseiEntity 事業高額申請全件Entity;
    private DbT3112KogakuShikyuShinsaKetteiEntity 事業審査決定全件Entity;

}

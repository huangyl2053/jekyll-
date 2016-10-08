/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannEntity;

/**
 * 管理データ一時Entityを取得のエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings ("PMD.UnusedPrivateField")
public class TyukannKekkaZenRelateEntity {

    private TempKyufujissekiTyukannEntity 給付実績中間高額Entity;
    private DbT3111JigyoKogakuShikyuHanteiKekkaEntity 高額判定結果全件Entity;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;

/**
 * 給付実績中間事業高額一時の更新２用エンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_2Entity {

    private DbT3057KogakuShikyuHanteiKekkaEntity 高額介護サービス費支給判定結果;
    private DbT3058KogakuShikyuShinsaKetteiEntity 高額介護サービス費支給審査決定;
    private TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時５;
}

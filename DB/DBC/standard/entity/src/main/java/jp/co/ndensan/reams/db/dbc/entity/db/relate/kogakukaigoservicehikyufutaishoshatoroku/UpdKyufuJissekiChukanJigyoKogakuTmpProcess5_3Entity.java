/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufutaishoshatoroku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;

/**
 * 給付実績中間事業高額一時の更新３用エンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdKyufuJissekiChukanJigyoKogakuTmpProcess5_3Entity {

    private DbT3055KogakuKyufuTaishoshaGokeiEntity 高額介護サービス費給付対象者合計;
    private TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時５;
}

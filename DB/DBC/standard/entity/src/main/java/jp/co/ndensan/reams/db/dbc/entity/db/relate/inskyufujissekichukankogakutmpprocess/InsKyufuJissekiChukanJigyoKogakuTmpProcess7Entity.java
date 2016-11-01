/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.inskyufujissekichukankogakutmpprocess;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3033KyufujissekiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempKyufujissekiTyukannJigyoEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBCMN41002_高額介護サービス費給付対象者登録Processのクラスです。
 *
 * @reamsid_L DBC-2010-040 wangxingpeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class InsKyufuJissekiChukanJigyoKogakuTmpProcess7Entity {

    private TempKyufujissekiTyukannJigyoEntity 給付実績中間事業高額一時Entity;
    private DbT3033KyufujissekiShukeiEntity 給付実績集計一時Entity;
    private DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity 給付実績社会福祉法人軽減額一時Entity;
}

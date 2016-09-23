/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;

/**
 * 給付実績社会福祉法人軽減額データEntityクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiShakaiFukushiHojinKeigengakuRelateEntity {

    private DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity 給付実績社会福祉法人軽減額データ;
    private KyufujissekiServiceShuruiRyakushoRelateEntity serviceShuruiRyakusho;
}

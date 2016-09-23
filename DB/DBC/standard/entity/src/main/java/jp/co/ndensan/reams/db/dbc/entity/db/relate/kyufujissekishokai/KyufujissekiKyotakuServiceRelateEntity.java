/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3025KyufujissekiKyotakuServiceEntity;

/**
 * 給付実績居宅サービス計画費データEntityクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiKyotakuServiceRelateEntity {

    private DbT3025KyufujissekiKyotakuServiceEntity 給付実績居宅サービス計画費データ;
    private KyufujissekiServiceShuruiRyakushoRelateEntity serviceShuruiRyakusho;
}

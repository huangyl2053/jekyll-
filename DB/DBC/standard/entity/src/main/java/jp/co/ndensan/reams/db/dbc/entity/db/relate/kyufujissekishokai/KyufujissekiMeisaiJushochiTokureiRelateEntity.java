/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3106KyufujissekiMeisaiJushochiTokureiEntity;

/**
 * 給付実績明細・住所地特例データEntityクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiMeisaiJushochiTokureiRelateEntity {

    private DbT3106KyufujissekiMeisaiJushochiTokureiEntity 給付実績明細住所地特例データ;
    private KyufujissekiServiceShuruiRyakushoRelateEntity serviceShuruiRyakusho;
}

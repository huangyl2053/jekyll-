/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity;

/**
 * 給付実績特定入所者介護サービス費用データEntityクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufujissekiTokuteiNyushosyaKaigoServiceHiyoRelateEntity {

    private DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoEntity 給付実績特定入所者介護サービス費用データ;
    private KyufujissekiServiceShuruiRyakushoRelateEntity serviceShuruiRyakusho;
}

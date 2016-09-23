/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufujissekishokai;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiKihonKyotakuServiceRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai.KyufuJissekiKihonShukeiRelateEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 給付実績情報照会検索データのbusinessクラスです。
 *
 * @reamsid_L DBC-2970-170 dingyi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiSearchDataBusiness implements Serializable {

    private static final long serialVersionUID = -2632968912981424943L;
    private List<KyufuJissekiKihonShukeiRelateEntity> 給付実績基本集計データ;
    private List<KyufuJissekiKihonKyotakuServiceRelateEntity> 給付実績基本居宅サービス計画費データ;
    private List<DbT3028KyufujissekiKogakuKaigoServicehiEntity> 給付実績高額介護サービス費データ;
}

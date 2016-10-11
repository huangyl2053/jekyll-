/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT0001HihokenshaIchijiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * 返却データです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiInHenkyakuD8DataEntity {

    private DbWT111JKyufuJissekiD8Entity 給付実績D8;
    private DbWT0001HihokenshaIchijiEntity 被保険者一時;
    private DbT3028KyufujissekiKogakuKaigoServicehiEntity 給付実績高額介護サービス費;
}

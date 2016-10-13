/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3017KyufujissekiKihonEntity;
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
public class KyufuJissekiInHenkyakuH1DataEntity {

    private DbWT111AKyufuJissekiH1Entity 給付実績H1;
    private DbWT0001HihokenshaTempEntity 被保険者一時;
    private DbT3017KyufujissekiKihonEntity 給付実績基本;
}

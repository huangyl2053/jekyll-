/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin;

import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;

/**
 * 高額合算給付実績一時TBLと被保険者一時TBLのEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiInEntity {

    private DbWT0001HihokenshaTempEntity 被保険者一時;
    private DbWT38P1KogakuGassanKyufuJissekiTempEntity 高額合算給付実績一時;

}

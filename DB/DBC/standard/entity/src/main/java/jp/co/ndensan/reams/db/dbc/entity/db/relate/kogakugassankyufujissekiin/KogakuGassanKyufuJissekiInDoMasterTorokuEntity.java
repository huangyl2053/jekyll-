/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiin;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;

/**
 * 高額合算給付実績取込テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2700-010 wangxingpeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiInDoMasterTorokuEntity {

    private DbWT38P1KogakuGassanKyufuJissekiTempEntity 高額合算給付実績一時;
    private DbT3075KogakuGassanKyufuJissekiEntity 高額合算給付実績;

}

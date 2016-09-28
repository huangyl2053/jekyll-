/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchi;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;

/**
 * ビジネス設計_DBCMN63003_高額合算支給決定通知書（単）のEntity。
 *
 * @reamsid_L DBC-2310-030 chenyadong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanEntity {

    private DbT3074KogakuGassanShikyuFushikyuKetteiEntity 高額合算支給不支給決定;
    private DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity 高額合算支給額計算結果;

}

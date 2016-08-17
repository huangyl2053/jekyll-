/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakugassanshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Saku
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyoKogakuGassanEntity {

    private DbT3172JigyoKogakuGassanShikyuGakuKeisanKekkaEntity 事業高額合算支給額計算結果;
    private DbT3174JigyoKogakuGassanShikyuFushikyuKetteiEntity 事業高額合算支給不支給決定;
}

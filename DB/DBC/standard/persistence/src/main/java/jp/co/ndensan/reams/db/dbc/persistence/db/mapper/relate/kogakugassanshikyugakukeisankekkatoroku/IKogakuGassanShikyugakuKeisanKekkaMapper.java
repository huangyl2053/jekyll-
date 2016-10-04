/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakugassanshikyugakukeisankekkatoroku;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110070.KogakuGassanShikyuGakuKeisanKekkaRelateEntity;

/**
 * 高額合算支給額計算結果登録のmapperです。
 *
 * @reamsid_L DBC-2030-030 huzongcheng
 */
public interface IKogakuGassanShikyugakuKeisanKekkaMapper {

    /**
     * 履歴チェックオン時高額合算支給額計算結果データを取得する。
     *
     * @param parameter Map
     * @return List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity>
     */
    List<KogakuGassanShikyuGakuKeisanKekkaRelateEntity> select支給額計算結果履歴チェックオン(Map<String, Object> parameter);

    /**
     * 履歴チェックオフ時高額合算支給額計算結果データを取得する。
     *
     * @param parameter Map
     * @return List<KogakuGassanShikyuGakuKeisanKekkaRelateEntity>
     */
    List<KogakuGassanShikyuGakuKeisanKekkaRelateEntity> select支給額計算結果履歴チェックオフ(Map<String, Object> parameter);

    /**
     * 高額合算支給額計算明細結果データを取得する。
     *
     * @param parameter Map
     * @return List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity>
     */
    List<DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiEntity> select支給額計算明細結果(Map<String, Object> parameter);
}

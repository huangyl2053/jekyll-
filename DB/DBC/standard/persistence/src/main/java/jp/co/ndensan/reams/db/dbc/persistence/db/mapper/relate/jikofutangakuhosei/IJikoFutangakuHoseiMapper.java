/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jikofutangakuhosei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3170JigyoKogakuGassanJikoFutanGakuEntity;

/**
 * 受領委任契約事業者登録・追加・修正・照会
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public interface IJikoFutangakuHoseiMapper {

    /**
     * 履歴を抽出する：チェックオフの場合。
     *
     * @param parameter parameter
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    List<DbT3170JigyoKogakuGassanJikoFutanGakuEntity> get履歴チェックオフ(Map<String, Object> parameter);

    /**
     * 履歴を抽出する：チェックオフの場合。
     *
     * @param parameter parameter
     * @return List<DbT3070KogakuGassanJikoFutanGakuEntity>
     */
    List<DbT3070KogakuGassanJikoFutanGakuEntity> get履歴オフ(Map<String, Object> parameter);

}

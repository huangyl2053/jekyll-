/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.juryoininkeiyakujigyosha;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.juryoininkeiyakujigyosha.JuryoininKeiyakuJigyoshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;

/**
 * 受領委任契約事業者登録・追加・修正・照会
 */
public interface IJuryoininKeiyakuJigyoshaMapper {

    /**
     * 契約事業者一覧取得
     *
     * @param parameter JuryoininKeiyakuJigyoshaParameter
     * @return DbT3077JuryoininKeiyakuJigyoshaEntity
     */
    List<DbT3077JuryoininKeiyakuJigyoshaEntity> get契約事業者一覧(JuryoininKeiyakuJigyoshaParameter parameter);

    /**
     * 契約事業者取得処理
     *
     * @param parameter parameter
     * @return JuryoininKeiyakuJigyosha
     */
    DbT3077JuryoininKeiyakuJigyoshaEntity get契約事業者(Map<String, Object> parameter);

}

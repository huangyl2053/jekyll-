/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kogakujuryoininkeiyakujigyosha;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakujuryoininkeiyakujigyosha.KogakuJuryoininKeiyakuJigyoshaEntity;

/**
 *
 * @author Administrator
 */
public interface IKogakuJuryoininKeiyakuJigyoshaMapper {

    /**
     * 高額受領委任契約事業者の情報を取得します。
     *
     * @param param KogakuJuryoininKeiyakuJigyoshaParameter
     * @return KogakuJuryoininKeiyakuJigyoshaEntityのリスト
     */
    List<KogakuJuryoininKeiyakuJigyoshaEntity> select高額受領委任契約事業者情報(KogakuJuryoininKeiyakuJigyoshaParameter param);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sabisunaiyoutouruku;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.sabisunaiyoutouruku.SabisuNaiyouTourukuMyBatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sabisunaiyoutouruku.SabisuNaiyouTourukuEntity;

/**
 * サービス内容登録のエンティティです。 ISabisuNaiyouTourukuMapper
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
public interface ISabisuNaiyouTourukuMapper {

    /**
     * サービス内容登録を取得
     *
     * @param parameter SabisuNaiyouTourukuMyBatisParameter
     *
     * @return SabisuNaiyouTourukuEntity
     *
     */
    List<SabisuNaiyouTourukuEntity> getサービス内容(SabisuNaiyouTourukuMyBatisParameter parameter);

}

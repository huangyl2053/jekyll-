/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jukyushaidorenrakuhyoout;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.HihoNoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jukyushaidorenrakuhyoout.IdouTempEntity;

/**
 * 受給者異動連絡票作成のMapperです。KyotakuEntity
 *
 * @reamsid_L DBC-2720-070 chenhui
 */
public interface IJukyushaIdoRenrakuhyoOutMapper {

    /**
     * 被保番データを取ります。
     *
     * @return List<HihoNoTempEntity>
     */
    List<HihoNoTempEntity> select被保番();

    /**
     * 支払方法変更（支払方法)データを取ります。
     *
     * @return List<IdouTempEntity>
     */
    List<IdouTempEntity> select支払方法変更_支払方法();

    /**
     * 支払方法変更（支払方法)データを取ります。
     *
     * @return List<IdouTempEntity>
     */
    List<IdouTempEntity> select給付額減額();

    /**
     * 支払方法変更（支払方法)データを取ります。
     *
     * @return List<IdouTempEntity>
     */
    List<IdouTempEntity> selectTestData();

}

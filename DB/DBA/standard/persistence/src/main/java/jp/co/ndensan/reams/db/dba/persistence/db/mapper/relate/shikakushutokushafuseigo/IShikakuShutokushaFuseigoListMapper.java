/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.shikakushutokushafuseigo;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.shikakushutokushafuseigo.ShikakuShutokushaFuseigoMybatisParameter;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakuShutokushaFuseigoEntity;

/**
 * 資格取得者不整合リストMapperクラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
public interface IShikakuShutokushaFuseigoListMapper {

    /**
     * 資格不整合リストを取得処理です。
     *
     * @param mybatisParameter ShikakuShutokushaFuseigoMybatisParameter
     * @return List<ShikakuShutokushaFuseigoEntity>
     */
    List<ShikakuShutokushaFuseigoEntity> get資格重複者(ShikakuShutokushaFuseigoMybatisParameter mybatisParameter);

    /**
     * 資格不整合リストを取得処理です。
     *
     * @param mybatisParameter ShikakuShutokushaFuseigoMybatisParameter
     * @return List<ShikakuShutokushaFuseigoEntity>
     */
    List<ShikakuShutokushaFuseigoEntity> get重複者以外(ShikakuShutokushaFuseigoMybatisParameter mybatisParameter);
}

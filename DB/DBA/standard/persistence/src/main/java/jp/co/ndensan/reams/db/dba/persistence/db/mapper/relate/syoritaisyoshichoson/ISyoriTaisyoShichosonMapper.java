/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.syoritaisyoshichoson;

import java.util.List;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminkirokuidojohotorokukoiki.JuminkirokuIdojohoTorokuKoikiMybatisParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 住民異動連携情報登録【広域保険者用】クラスです。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
public interface ISyoriTaisyoShichosonMapper {

    /**
     * 住民異動連携情報登録【広域保険者用】を条件指定検索で複数件取得します。
     *
     * @param mappreParameter KaigojuminHyotrukuMapperParameter
     * @return DbT7022ShoriDateKanriEntity
     */
    List<DbT7022ShoriDateKanriEntity> get宛名連動介護保険更新(JuminkirokuIdojohoTorokuKoikiMybatisParameter mappreParameter);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.shikakufuseigo;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shikakufuseigo.ShikakuFuseigoMybatisParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shikakufuseigo.ShikakuFuseigoEntity;

/**
 * 資格不整合のマッパーインタフェースです。
 *
 * @reamsid_L DBB-0630-020 chengsanyuan
 */
public interface IShikakuFuseigoMapper {

    /**
     * 資格不整合一覧情報を取得する。
     *
     * @param param param
     * @return List<SikakuEntity>
     */
    List<ShikakuFuseigoEntity> get被保険者資格不整合一覧(ShikakuFuseigoMybatisParameter param);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbu.definition.mybatis.param.kaigojuminhyo.KaigoJuminhyoMapperParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigojuminhyo.KaigoJuminhyoRelateEntity;

/**
 * 介護住民票個別事項連携情報のマッパーインタフェースです。
 */
public interface IKaigoJuminhyoMapper {

    /**
     * 介護住民票個別事項連携情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 介護住民票個別事項連携情報を特定するためのMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<KaigoJuminhyoRelateEntity> getKaigoJuminhyoEntity(KaigoJuminhyoMapperParameter mapperParameter);

}

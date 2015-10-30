/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.gappeijoho;

import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.gappeijoho.GappeiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.gappeijoho.GappeiJohoRelateEntity;

/**
 * 合併情報のマッパーインタフェースです。
 */
public interface IGappeiJohoMapper {

    /**
     * 合併情報情報をキー検索で１件取得します。
     *
     * @param 合併情報検索条件 合併情報検索条件
     * @return GappeiJohoRelateEntity
     */
    GappeiJohoRelateEntity getGappeiJohoRelateEntity(GappeiJohoMapperParameter 合併情報検索条件);

}

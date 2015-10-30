/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.GogitaiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gogitaijoho.gogitaijoho.GogitaiJohoRelateEntity;

/**
 * 合議体情報のマッパーインタフェースです。
 */
public interface IGogitaiJohoMapper {

    /**
     * 合議体情報情報をキー検索で１件取得します。
     *
     * @param 合議体情報検索条件 合議体情報検索条件
     * @return GogitaiJohoRelateEntity
     */
    GogitaiJohoRelateEntity getGogitaiJohoRelateEntity(GogitaiJohoMapperParameter 合議体情報検索条件);

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.gogitaijoho.gogitaijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.gogitaijoho.gogitaijoho.GogitaiJohoMapperParameter;
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
    GogitaiJohoRelateEntity select合議体情報ByKey(GogitaiJohoMapperParameter 合議体情報検索条件);

    /**
     * 主キー1に合致する合議体情報のリストを取得します。
     *
     * @param 合議体情報検索条件 合議体情報検索条件
     * @return GogitaiJohoRelateEntityの{@code list}
     */
    List<GogitaiJohoRelateEntity> select合議体情報リストBy主キー1(GogitaiJohoMapperParameter 合議体情報検索条件);

    /**
     * 合議体情報作成に合致する合議体情報のリストを取得します。
     *
     * @param 合議体情報検索条件 合議体情報検索条件
     * @return GogitaiJohoRelateEntityの{@code list}
     */
    List<GogitaiJohoRelateEntity> selectGogitaiJohoSakusei(GogitaiJohoMapperParameter 合議体情報検索条件);
}

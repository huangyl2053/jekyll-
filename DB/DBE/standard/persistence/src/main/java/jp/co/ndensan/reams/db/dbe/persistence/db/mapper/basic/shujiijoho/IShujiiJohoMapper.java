/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.basic.shujiijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiijoho.ShujiiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho.ShujiiJohoRelateEntity;

/**
 *
 * @author nXXXX ○○○○
 */
public interface IShujiiJohoMapper {

    /**
     * ShujiiJohoRelateEntityを取得します。
     *
     * @param 主治医情報検索条件
     * @return ShujiiJohoRelateEntity 検索結果の{@link ShujiiJohoRelateEntity}
     */
    List<ShujiiJohoRelateEntity> getShujiiJohoEntity(ShujiiJohoMapperParameter 主治医情報検索条件);

    /**
     * 主治医コードが使用されている件数を取得します。
     *
     * @param parameter
     * @return int
     */
    Integer getNinteiShinseiJohoCount(ShujiiJohoMapperParameter parameter);

    /**
     * 主治医コードが使用されている件数を取得します。
     *
     * @param parameter
     * @return int
     */
    Integer getShujiiIkenshoIraiJohoCount(ShujiiJohoMapperParameter parameter);
}

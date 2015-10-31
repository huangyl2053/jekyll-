/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteikekkajoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteikekkajoho.NinteiKekkaJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteishinseijoho.ninteishinseijoho.NinteiShinseiJohoRelateEntity;

/**
 * 要介護認定結果情報のマッパーインタフェースです。
 */
public interface INinteiKekkaJohoMapper {

    /**
     * 要介護認定結果情報情報をキー検索で１件取得します。
     *
     * @param 要介護認定結果情報検索条件 要介護認定結果情報検索条件
     * @return NinteiKekkaJohoEntity
     */
    NinteiShinseiJohoRelateEntity getNinteiKekkaJohoEntity(NinteiKekkaJohoMapperParameter 要介護認定結果情報検索条件);

}

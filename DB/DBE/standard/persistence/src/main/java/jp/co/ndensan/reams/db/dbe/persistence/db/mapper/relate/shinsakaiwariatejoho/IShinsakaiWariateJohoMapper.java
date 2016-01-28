/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiwariatejoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariatejoho.ShinsakaiWariateJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJohoRelateEntity;

/**
 * 介護認定審査会割当情報のマッパーインタフェースです。
 */
public interface IShinsakaiWariateJohoMapper {

    /**
     * 介護認定審査会割当情報情報をキー検索で１件取得します。
     *
     * @param 介護認定審査会割当情報検索条件 介護認定審査会割当情報検索条件
     * @return ShinsakaiWariateJohoRelateEntity
     */
    ShinsakaiWariateJohoRelateEntity select介護認定審査会割当情報ByKey(ShinsakaiWariateJohoMapperParameter 介護認定審査会割当情報検索条件);
}

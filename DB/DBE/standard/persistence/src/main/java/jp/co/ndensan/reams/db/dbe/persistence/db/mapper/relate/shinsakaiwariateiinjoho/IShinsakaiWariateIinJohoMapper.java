/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiwariateiinjoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJohoRelateEntity;

/**
 * 介護認定審査会割当委員情報のマッパーインタフェースです。
 */
public interface IShinsakaiWariateIinJohoMapper {

    /**
     * 介護認定審査会割当委員情報情報をキー検索で１件取得します。
     *
     * @param 介護認定審査会割当委員情報検索条件 介護認定審査会割当委員情報検索条件
     * @return ShinsakaiWariateIinJohoRelateEntity
     */
    ShinsakaiWariateIinJohoRelateEntity select介護認定審査会割当委員情報ByKey(ShinsakaiWariateIinJohoMapperParameter 介護認定審査会割当委員情報検索条件);

}

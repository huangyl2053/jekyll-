/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaiiinjoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho.ShinsakaiIinJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinjoho.shinsakaiiinjoho.ShinsakaiIinJohoEntity;

/**
 * 介護認定審査会委員情報のマッパーインタフェースです。
 */
public interface IShinsakaiIinJohoMapper {

    /**
     * 介護認定審査会委員情報情報をキー検索で１件取得します。
     *
     * @param 介護認定審査会委員情報検索条件 介護認定審査会委員情報検索条件
     * @return ShinsakaiIinJohoEntity
     */
    ShinsakaiIinJohoEntity getShinsakaiIinJohoEntity(ShinsakaiIinJohoMapperParameter 介護認定審査会委員情報検索条件);

}

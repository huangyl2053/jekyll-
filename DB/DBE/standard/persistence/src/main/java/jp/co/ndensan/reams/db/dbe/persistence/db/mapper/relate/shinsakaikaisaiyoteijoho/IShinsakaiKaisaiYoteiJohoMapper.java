/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaikaisaiyoteijoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakai.shinsakaikaisaiyoteijoho.ShinsakaiKaisaiYoteiJohoRelateEntity;

/**
 * 介護認定審査会開催予定情報のマッパーインタフェースです。
 */
public interface IShinsakaiKaisaiYoteiJohoMapper {

    /**
     * 介護認定審査会開催予定情報情報をキー検索で１件取得します。
     *
     * @param 介護認定審査会開催予定情報検索条件 介護認定審査会開催予定情報検索条件
     * @return ShinsakaiKaisaiYoteiJohoEntity
     */
    ShinsakaiKaisaiYoteiJohoRelateEntity getShinsakaiKaisaiYoteiJohoEntity(ShinsakaiKaisaiYoteiJohoMapperParameter 介護認定審査会開催予定情報検索条件);

}

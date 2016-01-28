/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.ninteishinseijoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.ninteishinseijoho.NinteiShinseiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.ninteishinseijoho.NinteiShinseiJohoEntity;

/**
 * 要介護認定申請情報のマッパーインタフェースです。
 */
public interface INinteiShinseiJohoMapper {

    /**
     * 要介護認定申請情報情報をキー検索で１件取得します。
     *
     * @param 要介護認定申請情報検索条件 要介護認定申請情報検索条件
     * @return NinteiShinseiJohoEntity
     */
    NinteiShinseiJohoEntity select要介護認定申請情報ByKey(NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件);

    /**
     * 主キー1に合致する要介護認定申請情報のリストを取得します。
     *
     * @param 要介護認定申請情報検索条件 要介護認定申請情報検索条件
     * @return NinteiShinseiJohoEntityの{@code list}
     */
    List<NinteiShinseiJohoEntity> select要介護認定申請情報リストBy主キー1(NinteiShinseiJohoMapperParameter 要介護認定申請情報検索条件);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.shujiiIkenshoJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoEntity;

/**
 * 要介護認定主治医意見書情報のマッパーインタフェースです。
 */
public interface IShujiiIkenshoJohoMapper {

    /**
     * 要介護認定主治医意見書情報情報をキー検索で１件取得します。
     *
     * @param 要介護認定主治医意見書情報検索条件 要介護認定主治医意見書情報検索条件
     * @return ShujiiIkenshoJohoEntity
     */
    ShujiiIkenshoJohoEntity select要介護認定主治医意見書情報ByKey(ShujiiIkenshoJohoMapperParameter 要介護認定主治医意見書情報検索条件);

    /**
     * 主キー1に合致する要介護認定主治医意見書情報のリストを取得します。
     *
     * @param 要介護認定主治医意見書情報検索条件 要介護認定主治医意見書情報検索条件
     * @return ShujiiIkenshoJohoEntityの{@code list}
     */
    List<ShujiiIkenshoJohoEntity> select要介護認定主治医意見書情報リストBy主キー1(ShujiiIkenshoJohoMapperParameter 要介護認定主治医意見書情報検索条件);
}

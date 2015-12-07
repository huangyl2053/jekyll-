/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikensho.shujiiIkenshoIraiJoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ikensho.shujiiIkenshoIraiJoho.ShujiiIkenshoIraiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoIraiJoho.ShujiiIkenshoIraiJohoEntity;

/**
 * 主治医意見書作成依頼情報のマッパーインタフェースです。
 */
public interface IShujiiIkenshoIraiJohoMapper {

    /**
     * 主治医意見書作成依頼情報情報をキー検索で１件取得します。
     *
     * @param 主治医意見書作成依頼情報検索条件 主治医意見書作成依頼情報検索条件
     * @return ShujiiIkenshoIraiJohoEntity
     */
    ShujiiIkenshoIraiJohoEntity select主治医意見書作成依頼情報ByKey(ShujiiIkenshoIraiJohoMapperParameter 主治医意見書作成依頼情報検索条件);

    /**
     * 主キー1に合致する主治医意見書作成依頼情報のリストを取得します。
     *
     * @param 主治医意見書作成依頼情報検索条件 主治医意見書作成依頼情報検索条件
     * @return ShujiiIkenshoIraiJohoEntityの{@code list}
     */
    List<ShujiiIkenshoIraiJohoEntity> select主治医意見書作成依頼情報リストBy主キー1(ShujiiIkenshoIraiJohoMapperParameter 主治医意見書作成依頼情報検索条件);
}

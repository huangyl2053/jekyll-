/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.syujii.shujiiiryokikanjoho;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoRelateEntity;

/**
 * 主治医医療機関情報のマッパーインタフェースです。
 */
public interface IShujiiIryoKikanJohoMapper {

    /**
     * 主治医医療機関情報情報をキー検索で１件取得します。
     *
     * @param 主治医医療機関情報検索条件 主治医医療機関情報検索条件
     * @return ShujiiIryoKikanJohoRelateEntity
     */
    ShujiiIryoKikanJohoRelateEntity select主治医医療機関情報ByKey(ShujiiIryoKikanJohoMapperParameter 主治医医療機関情報検索条件);

}

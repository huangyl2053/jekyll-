/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shujiiiryokikanshujii;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shujiiiryokikanshujii.ShujiiIryoKikanShujiiParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.syujii.shujiiiryokikanjoho.ShujiiIryoKikanJohoRelateEntity;

/**
 * 構成市町村マスタのマッパーインタフェースです。
 */
public interface IShujiiIryoKikanShujiiMapper {

    /**
     * 構成市町村マスタ情報をキー検索で１件取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntity
     */
    ShujiiIryoKikanJohoRelateEntity getShujiiIryoKikanShujiiRelateEntity(ShujiiIryoKikanShujiiParameter 構成市町村マスタ検索条件);
}

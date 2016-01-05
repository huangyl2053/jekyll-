/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbx.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;

/**
 * 構成市町村マスタのマッパーインタフェースです。
 */
public interface IKoseiShichosonMasterMapper {

    /**
     * 構成市町村マスタ情報をキー検索で１件取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntity
     */
    KoseiShichosonMasterRelateEntity getKoseiShichosonEntity(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件);
}

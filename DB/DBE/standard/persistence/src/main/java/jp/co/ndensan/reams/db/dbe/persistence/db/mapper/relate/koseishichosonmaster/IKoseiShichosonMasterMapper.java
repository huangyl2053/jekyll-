/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;

/**
 * 構成市町村マスタのマッパーインタフェースです。
 */
public interface IKoseiShichosonMasterMapper {

    /**
     * 構成市町村マスタをキー検索で１件取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterRelateEntity
     */
    KoseiShichosonMasterRelateEntity getKoseiShichosonMasterRelateEntity(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件);

}

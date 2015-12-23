/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.tyousai.koseishichosonmaster;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatis.param.tyousai.koseishichosonmaster.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.tyousai.koseishichosonmaster.KoseiShichosonMasterRelateEntity;

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
    KoseiShichosonMasterRelateEntity select構成市町村マスタByKey(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件);

    /**
     * 主キー1に合致する構成市町村マスタのリストを取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntityの{@code list}
     */
    List<KoseiShichosonMasterRelateEntity> select構成市町村マスタリストBy主キー1(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件);

    /**
     * 認定調査委託先マスタ検索のリストを取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntityの{@code list}
     */
//    List<KoseiShichosonMasterRelateEntity> ninteichosaItakusakiSearch(NinteichosaItakusakiKensakuParameter 構成市町村マスタ検索条件);
}

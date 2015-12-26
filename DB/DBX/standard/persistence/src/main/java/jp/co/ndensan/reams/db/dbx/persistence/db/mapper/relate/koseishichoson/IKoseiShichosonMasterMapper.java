/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.koseishichoson;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.koseishichoson.KoseiShichosonMasterMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.koseishichosonmaster.KoseiShichosonMasterRelateEntity;

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

    /**
     * 構成市町村マスタ情報をキー検索で１件取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntity
     */
    KoseiShichosonMasterRelateEntity select構成市町村マスタByKey(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する構成市町村マスタのリストを取得します。
     *
     * @param 構成市町村マスタ検索条件 構成市町村マスタ検索条件
     * @return KoseiShichosonMasterEntityの{@code list}
     */
    List<KoseiShichosonMasterRelateEntity> select構成市町村マスタリストBy主キー1(KoseiShichosonMasterMapperParameter 構成市町村マスタ検索条件);
}

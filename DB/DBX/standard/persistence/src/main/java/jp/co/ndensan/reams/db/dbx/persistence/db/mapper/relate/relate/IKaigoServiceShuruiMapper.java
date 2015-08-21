/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.relate.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.relate.KaigoServiceShuruiEntity;

/**
 * 介護サービス種類のマッパーインタフェースです。
 */
public interface IKaigoServiceShuruiMapper {

    /**
     * 介護サービス種類情報をキー検索で１件取得します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShuruiEntity
     */
    KaigoServiceShuruiEntity select介護サービス種類ByKey(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する介護サービス種類のリストを取得します。
     *
     * @param 介護サービス種類検索条件 介護サービス種類検索条件
     * @return KaigoServiceShuruiEntityの{@code list}
     */
    List<KaigoServiceShuruiEntity> select介護サービス種類リストBy主キー1(KaigoServiceShuruiMapperParameter 介護サービス種類検索条件);
}

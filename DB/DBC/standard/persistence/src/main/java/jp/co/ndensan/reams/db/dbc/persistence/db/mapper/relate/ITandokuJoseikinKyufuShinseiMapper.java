/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.TandokuJoseikinKyufuShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.TandokuJoseikinKyufuShinseiEntity;

/**
 * 市町村単独助成金給付申請のマッパーインタフェースです。
 */
public interface ITandokuJoseikinKyufuShinseiMapper {

    /**
     * 市町村単独助成金給付申請情報をキー検索で１件取得します。
     *
     * @param 市町村単独助成金給付申請検索条件 市町村単独助成金給付申請検索条件
     * @return TandokuJoseikinKyufuShinseiEntity
     */
    TandokuJoseikinKyufuShinseiEntity select市町村単独助成金給付申請ByKey(TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する市町村単独助成金給付申請のリストを取得します。
     *
     * @param 市町村単独助成金給付申請検索条件 市町村単独助成金給付申請検索条件
     * @return TandokuJoseikinKyufuShinseiEntityの{@code list}
     */
    List<TandokuJoseikinKyufuShinseiEntity> select市町村単独助成金給付申請リストBy主キー1(TandokuJoseikinKyufuShinseiMapperParameter 市町村単独助成金給付申請検索条件);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.relate.BemmeiNaiyoMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.BemmeiNaiyoEntity;

/**
 * 弁明内容のマッパーインタフェースです。
 */
public interface IBemmeiNaiyoMapper {

    /**
     * 弁明内容情報をキー検索で１件取得します。
     *
     * @param 弁明内容検索条件 弁明内容検索条件
     * @return BemmeiNaiyoEntity
     */
    BemmeiNaiyoEntity select弁明内容ByKey(BemmeiNaiyoMapperParameter 弁明内容検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する弁明内容のリストを取得します。
     *
     * @param 弁明内容検索条件 弁明内容検索条件
     * @return BemmeiNaiyoEntityの{@code list}
     */
    List<BemmeiNaiyoEntity> select弁明内容リストBy主キー1(BemmeiNaiyoMapperParameter 弁明内容検索条件);
}

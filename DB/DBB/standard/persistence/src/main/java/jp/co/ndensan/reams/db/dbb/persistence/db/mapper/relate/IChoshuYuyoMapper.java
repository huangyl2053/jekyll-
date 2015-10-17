/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.relate.ChoshuYuyoMapperParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.relate.ChoshuYuyoEntity;

/**
 * 介護賦課徴収猶予のマッパーインタフェースです。
 */
public interface IChoshuYuyoMapper {

    /**
     * 介護賦課徴収猶予情報をキー検索で１件取得します。
     *
     * @param 介護賦課徴収猶予検索条件 介護賦課徴収猶予検索条件
     * @return ChoshuYuyoEntity
     */
    ChoshuYuyoEntity select介護賦課徴収猶予ByKey(ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する介護賦課徴収猶予のリストを取得します。
     *
     * @param 介護賦課徴収猶予検索条件 介護賦課徴収猶予検索条件
     * @return ChoshuYuyoEntityの{@code list}
     */
    List<ChoshuYuyoEntity> select介護賦課徴収猶予リストBy主キー1(ChoshuYuyoMapperParameter 介護賦課徴収猶予検索条件);
}

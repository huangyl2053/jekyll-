/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.NijiYoboKihonCheckListMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.NijiYoboKihonCheckListEntity;

/**
 * 二次予防基本チェックリストのマッパーインタフェースです。
 */
public interface INijiYoboKihonCheckListMapper {

    /**
     * 二次予防基本チェックリスト情報をキー検索で１件取得します。
     *
     * @param 二次予防基本チェックリスト検索条件 二次予防基本チェックリスト検索条件
     * @return NijiYoboKihonCheckListEntity
     */
    NijiYoboKihonCheckListEntity select二次予防基本チェックリストByKey(NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する二次予防基本チェックリストのリストを取得します。
     *
     * @param 二次予防基本チェックリスト検索条件 二次予防基本チェックリスト検索条件
     * @return NijiYoboKihonCheckListEntityの{@code list}
     */
    List<NijiYoboKihonCheckListEntity> select二次予防基本チェックリストリストBy主キー1(NijiYoboKihonCheckListMapperParameter 二次予防基本チェックリスト検索条件);
}

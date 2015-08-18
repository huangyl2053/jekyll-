/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatis.param.relate.RiyoshaFutanWariaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.relate.RiyoshaFutanWariaiEntity;

/**
 * 利用者負担割合のマッパーインタフェースです。
 */
public interface IRiyoshaFutanWariaiMapper {

    /**
     * 利用者負担割合情報をキー検索で１件取得します。
     *
     * @param 利用者負担割合検索条件 利用者負担割合検索条件
     * @return RiyoshaFutanWariaiEntity
     */
    RiyoshaFutanWariaiEntity select利用者負担割合ByKey(RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する利用者負担割合のリストを取得します。
     *
     * @param 利用者負担割合検索条件 利用者負担割合検索条件
     * @return RiyoshaFutanWariaiEntityの{@code list}
     */
    List<RiyoshaFutanWariaiEntity> select利用者負担割合リストBy主キー1(RiyoshaFutanWariaiMapperParameter 利用者負担割合検索条件);
}

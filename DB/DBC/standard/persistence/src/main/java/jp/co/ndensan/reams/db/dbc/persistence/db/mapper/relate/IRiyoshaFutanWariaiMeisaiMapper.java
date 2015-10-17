/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.RiyoshaFutanWariaiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.RiyoshaFutanWariaiMeisaiEntity;

/**
 * 利用者負担割合明細のマッパーインタフェースです。
 */
public interface IRiyoshaFutanWariaiMeisaiMapper {

    /**
     * 利用者負担割合明細情報をキー検索で１件取得します。
     *
     * @param 利用者負担割合明細検索条件 利用者負担割合明細検索条件
     * @return RiyoshaFutanWariaiMeisaiEntity
     */
    RiyoshaFutanWariaiMeisaiEntity select利用者負担割合明細ByKey(RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する利用者負担割合明細のリストを取得します。
     *
     * @param 利用者負担割合明細検索条件 利用者負担割合明細検索条件
     * @return RiyoshaFutanWariaiMeisaiEntityの{@code list}
     */
    List<RiyoshaFutanWariaiMeisaiEntity> select利用者負担割合明細リストBy主キー1(RiyoshaFutanWariaiMeisaiMapperParameter 利用者負担割合明細検索条件);
}

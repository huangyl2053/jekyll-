/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.relate.NijiYoboJigyoTaishoshaMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.NijiYoboJigyoTaishoshaEntity;

/**
 * 二次予防事業対象者のマッパーインタフェースです。
 */
public interface INijiYoboJigyoTaishoshaMapper {

    /**
     * 二次予防事業対象者情報をキー検索で１件取得します。
     *
     * @param 二次予防事業対象者検索条件 二次予防事業対象者検索条件
     * @return NijiYoboJigyoTaishoshaEntity
     */
    NijiYoboJigyoTaishoshaEntity select二次予防事業対象者ByKey(NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する二次予防事業対象者のリストを取得します。
     *
     * @param 二次予防事業対象者検索条件 二次予防事業対象者検索条件
     * @return NijiYoboJigyoTaishoshaEntityの{@code list}
     */
    List<NijiYoboJigyoTaishoshaEntity> select二次予防事業対象者リストBy主キー1(NijiYoboJigyoTaishoshaMapperParameter 二次予防事業対象者検索条件);
}

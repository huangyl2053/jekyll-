/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.mybatis.param.relate.KaigoJigyoshaMapperParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.relate.relate.KaigoJigyoshaEntity;

/**
 * 介護事業者のマッパーインタフェースです。
 */
public interface IKaigoJigyoshaMapper {

    /**
     * 介護事業者情報をキー検索で１件取得します。
     *
     * @param 介護事業者検索条件 介護事業者検索条件
     * @return KaigoJigyoshaEntity
     */
    KaigoJigyoshaEntity select介護事業者ByKey(KaigoJigyoshaMapperParameter 介護事業者検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する介護事業者のリストを取得します。
     *
     * @param 介護事業者検索条件 介護事業者検索条件
     * @return KaigoJigyoshaEntityの{@code list}
     */
    List<KaigoJigyoshaEntity> select介護事業者リストBy主キー1(KaigoJigyoshaMapperParameter 介護事業者検索条件);
}

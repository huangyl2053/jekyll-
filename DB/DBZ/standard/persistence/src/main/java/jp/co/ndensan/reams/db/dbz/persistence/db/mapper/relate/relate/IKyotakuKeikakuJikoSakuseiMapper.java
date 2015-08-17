/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate.KyotakuKeikakuJikoSakuseiMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.relate.KyotakuKeikakuJikoSakuseiEntity;

/**
 * 居宅給付計画自己作成のマッパーインタフェースです。
 */
public interface IKyotakuKeikakuJikoSakuseiMapper {

    /**
     * 居宅給付計画自己作成情報をキー検索で１件取得します。
     *
     * @param 居宅給付計画自己作成検索条件 居宅給付計画自己作成検索条件
     * @return KyotakuKeikakuJikoSakuseiEntity
     */
    KyotakuKeikakuJikoSakuseiEntity select居宅給付計画自己作成ByKey(KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する居宅給付計画自己作成のリストを取得します。
     *
     * @param 居宅給付計画自己作成検索条件 居宅給付計画自己作成検索条件
     * @return KyotakuKeikakuJikoSakuseiEntityの{@code list}
     */
    List<KyotakuKeikakuJikoSakuseiEntity> select居宅給付計画自己作成リストBy主キー1(KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件);
}

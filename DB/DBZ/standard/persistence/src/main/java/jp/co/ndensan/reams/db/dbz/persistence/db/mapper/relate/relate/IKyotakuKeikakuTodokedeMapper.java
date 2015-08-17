/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatis.param.relate.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.relate.KyotakuKeikakuTodokedeEntity;

/**
 * 居宅給付計画届出のマッパーインタフェースです。
 */
public interface IKyotakuKeikakuTodokedeMapper {

    /**
     * 居宅給付計画届出情報をキー検索で１件取得します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokedeEntity
     */
    KyotakuKeikakuTodokedeEntity select居宅給付計画届出ByKey(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件);

    // TODO リスト一覧取得に使用する検索項目はテーブル構造に合わせて修正が必要になります。
    // TODO 個別に引き渡す必要があるパラメータがある場合、追加してください。
    /**
     * 主キー1に合致する居宅給付計画届出のリストを取得します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokedeEntityの{@code list}
     */
    List<KyotakuKeikakuTodokedeEntity> select居宅給付計画届出リストBy主キー1(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件);
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakutodokede;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakuserviceriyohyomain.KaigoJigyoshaResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeEntity;

/**
 * 居宅給付計画届出のマッパーインタフェースです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public interface IKyotakuKeikakuTodokedeMapper {

    /**
     * 居宅給付計画届出情報をキー検索で１件取得します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokedeEntity
     */
    KyotakuKeikakuTodokedeEntity select居宅給付計画届出ByKey(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件);

    /**
     * 居宅給付計画届出履歴一覧取得します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return List<KyotakuKeikakuTodokedeEntity>
     */
    List<KyotakuKeikakuTodokedeEntity> select居宅給付計画届出履歴一覧(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件);

    /**
     * 居宅給付計画届出履歴取得します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KyotakuKeikakuTodokedeEntity
     */
    KyotakuKeikakuTodokedeEntity select居宅給付計画届出履歴(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件);

    /**
     * 事業者の情報取得します。
     *
     * @param 居宅給付計画届出検索条件 居宅給付計画届出検索条件
     * @return KaigoJigyoshaResult
     */
    KaigoJigyoshaResult select事業者の情報(KyotakuKeikakuTodokedeMapperParameter 居宅給付計画届出検索条件);
}

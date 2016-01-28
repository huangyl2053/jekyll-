/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakutodokede;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakutodokede.KyotakuKeikakuTodokedeEntity;

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
}

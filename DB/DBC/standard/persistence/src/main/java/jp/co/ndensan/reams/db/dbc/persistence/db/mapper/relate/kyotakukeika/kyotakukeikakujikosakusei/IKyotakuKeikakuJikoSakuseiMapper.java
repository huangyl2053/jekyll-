/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakujikosakusei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakusei.KyotakuKeikakuJikoSakuseiEntity;

/**
 * 居宅給付計画自己作成のマッパーインタフェースです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public interface IKyotakuKeikakuJikoSakuseiMapper {

    /**
     * 居宅給付計画自己作成情報をキー検索で１件取得します。
     *
     * @param 居宅給付計画自己作成検索条件 居宅給付計画自己作成検索条件
     * @return KyotakuKeikakuJikoSakuseiEntity
     */
    KyotakuKeikakuJikoSakuseiEntity select居宅給付計画自己作成ByKey(KyotakuKeikakuJikoSakuseiMapperParameter 居宅給付計画自己作成検索条件);
}

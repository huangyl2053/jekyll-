/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiEntity;

/**
 * 居宅給付計画自己作成明細のマッパーインタフェースです。
 */
public interface IKyotakuKeikakuJikosakuseiMeisaiMapper {

    /**
     * 居宅給付計画自己作成明細情報をキー検索で１件取得します。
     *
     * @param 居宅給付計画自己作成明細検索条件 居宅給付計画自己作成明細検索条件
     * @return KyotakuKeikakuJikosakuseiMeisaiEntity
     */
    KyotakuKeikakuJikosakuseiMeisaiEntity select居宅給付計画自己作成明細ByKey(KyotakuKeikakuJikosakuseiMeisaiMapperParameter 居宅給付計画自己作成明細検索条件);
}

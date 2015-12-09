/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kyotakukeika.yobokeikakujikosakuseimeisai;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.yobokeikakujikosakuseimeisai.YoboKeikakuJikoSakuseiMeisaiEntity;

/**
 * 予防給付計画自己作成明細のマッパーインタフェースです。
 */
public interface IYoboKeikakuJikoSakuseiMeisaiMapper {

    /**
     * 予防給付計画自己作成明細情報をキー検索で１件取得します。
     *
     * @param 予防給付計画自己作成明細検索条件 予防給付計画自己作成明細検索条件
     * @return YoboKeikakuJikoSakuseiMeisaiEntity
     */
    YoboKeikakuJikoSakuseiMeisaiEntity select予防給付計画自己作成明細ByKey(YoboKeikakuJikoSakuseiMeisaiMapperParameter 予防給付計画自己作成明細検索条件);
}

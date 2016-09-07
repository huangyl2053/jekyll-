/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujizenshinsei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishujizenshinsei.JutakuKaishuHiParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.KyufuritsuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.NewJutakuKaishuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.ShiharaiKekaEntity;

/**
 * 住宅改修事前申請マッパーインタフェースです。
 *
 * @reamsid_L DBC-0990-080 xicongwang
 */
public interface IJutakuKaishuJizenShinseiMapper {

    /**
     * 最新住宅改修住所取得します。
     *
     * @param parameter parameter
     * @return List<NewJutakuKaishuHiEntity>
     */
    List<NewJutakuKaishuHiEntity> get最新住宅改修住所(Map<String, Object> parameter);

    /**
     * 開始サービス提供年月ある
     *
     * @param parameter parameter
     * @return List<DbT3034ShokanShinseiEntity>
     */
    List<DbT3034ShokanShinseiEntity> get開始サービス提供年月ある(JutakuKaishuHiParameter parameter);

    /**
     * 開始サービス提供年月なし
     *
     * @param parameter parameter
     * @return List<DbT3034ShokanShinseiEntity>
     */
    List<DbT3034ShokanShinseiEntity> get開始サービス提供年月なし(JutakuKaishuHiParameter parameter);

    /**
     * WK給付率
     *
     * @param parameter parameter
     * @return List<KyufuritsuEntity>
     */
    List<KyufuritsuEntity> getWK給付率(JutakuKaishuHiParameter parameter);

    /**
     * 住宅改修費支払結果
     *
     * @param parameter parameter
     * @return ShiharaiKekaEntity
     */
    ShiharaiKekaEntity get住宅改修費支払結果(JutakuKaishuHiParameter parameter);
}

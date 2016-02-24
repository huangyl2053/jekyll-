/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.jutakukaishujizenshinsei;

import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.jutakukaishujizenshinsei.JutakuKaishuHiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.NewJutakuKaishuHiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishujizenshinsei.ShiharaiKekaEntity;

/**
 * 住宅改修事前申請マッパーインタフェースです。
 */
public interface IJutakuKaishuJizenShinseiMapper {

    List<NewJutakuKaishuHiEntity> get最新住宅改修住所(Map<String, Object> parameter);

    List<DbT3034ShokanShinseiEntity> get開始サービス提供年月ある(JutakuKaishuHiParameter parameter);

    List<DbT3034ShokanShinseiEntity> get開始サービス提供年月なし(JutakuKaishuHiParameter parameter);

    List<DbT3113RiyoshaFutanWariaiEntity> getWK給付率(JutakuKaishuHiParameter parameter);

    ShiharaiKekaEntity get住宅改修費支払結果(JutakuKaishuHiParameter parameter);
}

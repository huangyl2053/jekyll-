/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.jutakukaishujizenshinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.shokanshinseijutakukaishu.ShokanShinseiJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;

/**
 *
 * @author sunhui
 */
public interface IJutakuKaishuJizenShinseiMapper {

    List<ShokanShinseiJutakuKaishuEntity> get最新住宅改修の住宅住所(IJutakuKaishuJizenShinseiMapperParameter
                parameter);           
        List<DbT3034ShokanShinseiEntity>  get支払結果計算の開始サービス提供年月限度額リセットがある(
                IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT3034ShokanShinseiEntity>  get支払結果計算の開始サービス提供年月限度額リセットなし(
                IJutakuKaishuJizenShinseiMapperParameter parameter);      
       List<DbT3113RiyoshaFutanWariaiEntity> getWK給付率(IJutakuKaishuJizenShinseiMapperParameter parameter);
       List<DbT4014RiyoshaFutangakuGengakuEntity> get減額給付率(IJutakuKaishuJizenShinseiMapperParameter parameter);
           List<DbT3034ShokanShinseiEntity>  get住宅改修費支払結果(IJutakuKaishuJizenShinseiMapperParameter parameter);
}

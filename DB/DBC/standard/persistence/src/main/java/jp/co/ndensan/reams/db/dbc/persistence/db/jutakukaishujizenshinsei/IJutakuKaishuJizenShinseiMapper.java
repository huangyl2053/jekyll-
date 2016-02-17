/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.persistence.db.jutakukaishujizenshinsei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinsei.IJutakuKaishuJizenShinseiMapperParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.shiharaikekka.ShiharaiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.shokanshinseijutakukaishu.ShokanShinseiJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.yokaigoninteijyoho.YokaigoNinteiJyohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * @author sunhui
 */
public interface IJutakuKaishuJizenShinseiMapper {
       List<YokaigoNinteiJyohoEntity> getYokaigoNinteiJyoho(IJutakuKaishuJizenShinseiMapperParameter parameter);
       List<Decimal> get上乗せ償還払い給付種類支給限度額(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<Decimal> get償還払い給付種類支給限度額(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<ShokanShinseiJutakuKaishuEntity> get最新住宅改修の住宅住所(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT3035ShokanJutakuKaishuJizenShinseiEntity>  get償還払支給住宅改修事前申請情報(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<String> get様式番号(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<ShiharaiKekkaEntity>  get今回住宅改修の住宅住所(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT3034ShokanShinseiEntity>  get支払結果計算の開始サービス提供年月限度額リセットがある(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT3034ShokanShinseiEntity>  get支払結果計算の開始サービス提供年月限度額リセットなし(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT3034ShokanShinseiEntity>  get住宅改修費支払結果(IJutakuKaishuJizenShinseiMapperParameter parameter);       
        List<DbT3113RiyoshaFutanWariaiEntity>  getWK給付率(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT4014RiyoshaFutangakuGengakuEntity> get減額給付率(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT4021ShiharaiHohoHenkoEntity> get支払方法変更給付率(IJutakuKaishuJizenShinseiMapperParameter parameter);
        List<DbT1001HihokenshaDaichoEntity> get被保険者台帳情報(IJutakuKaishuJizenShinseiMapperParameter parameter);
}

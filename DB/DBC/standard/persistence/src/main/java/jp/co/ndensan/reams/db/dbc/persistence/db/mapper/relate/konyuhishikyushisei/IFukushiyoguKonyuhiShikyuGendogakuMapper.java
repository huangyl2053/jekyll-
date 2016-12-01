/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.konyuhishikyushisei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ServiceShuruiCodeParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShibaraiKekkaParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.fukushiyogukonyuhishikyushisei.ShokanShikyuShinseiParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.FukushiyouguKonyuhiShikyuShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.ShichosonEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.SokanbaraiShiharaiKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.fukushiyogukonyuhishikyushisei.YokaigoJotaiTokyuSochishaKubunCode;

/**
 * 福祉用具購入費支給申請Mapperです。
 *
 * @reamsid_L DBC-1020-040 zhangrui
 */
public interface IFukushiyoguKonyuhiShikyuGendogakuMapper {

    /**
     * 被保険者より、福祉用具購入費支給申請一覧のデータを取得する。
     *
     * @param parameter {@link ShokanShikyuShinseiParameter}
     * @return List<FukushiyouguKonyuhiShikyuShinsei>
     */
    List<FukushiyouguKonyuhiShikyuShinsei> select支給申請一覧(ShokanShikyuShinseiParameter parameter);

    /**
     * サービス種類取得
     *
     * @param parameter {@link ServiceShuruiCodeParameter}
     * @return Code
     */
    YokaigoJotaiTokyuSochishaKubunCode select要介護認定状態区分コード(ServiceShuruiCodeParameter parameter);

    /**
     * 措置元市町村データ取得
     *
     * @param parameter {@link ServiceShuruiCodeParameter}
     * @return List<ShichosonEntity>
     */
    List<ShichosonEntity> select措置元市町村データ(ServiceShuruiCodeParameter parameter);

    /**
     * 今までの支払結果情報取得
     *
     * @param parameter {@link ShibaraiKekkaParameter}
     * @return SokanbaraiShiharaiKekka
     */
    SokanbaraiShiharaiKekka select支払結果情報(ShibaraiKekkaParameter parameter);
}

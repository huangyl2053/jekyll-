/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanjutakukaishu;

import jp.co.ndensan.reams.db.dbc.entity.db.shokanshinseijutakukaishu.ShokanShinseiJutakuKaishuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修費事前申請
 */
public class ShokanShinseiJutakuKaishu {

    FlexibleYearMonth サービス提供年月;
    RString 住宅改修住宅住所;

    /**
     * コンストラクタです。
     *
     * @param entity entity
     */
    public ShokanShinseiJutakuKaishu(ShokanShinseiJutakuKaishuEntity entity) {
        this.サービス提供年月 = entity.getServiceTeikyoYM();
        this.住宅改修住宅住所 = entity.getJutakuKaishuJutakuAddress();
    }
}

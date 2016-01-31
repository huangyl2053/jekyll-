/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShikibetsuBangoSelector;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.ShikibetsuBangoSelectorDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.shikibetsubangoselector.ShikibetsuBangoSelectorDivHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author 潘鶴
 */
public class ShikibetsuBangoSelector {

    public ResponseData<ShikibetsuBangoSelectorDiv> onLoad(ShikibetsuBangoSelectorDiv requestDiv) {

        getHandler(requestDiv).initialize(new RString("2165"), new FlexibleYearMonth("201501"), new RString("22"));
        return ResponseData.of(requestDiv).respond();
    }

    public ResponseData<ShikibetsuBangoSelectorDiv> onClick_btnSearch(ShikibetsuBangoSelectorDiv requestDiv) {
        getHandler(requestDiv).getShikibetsuBangoJoho();
        return ResponseData.of(requestDiv).respond();
    }

    private ShikibetsuBangoSelectorDivHandler getHandler(ShikibetsuBangoSelectorDiv requestDiv) {
        return new ShikibetsuBangoSelectorDivHandler(requestDiv);
    }

}

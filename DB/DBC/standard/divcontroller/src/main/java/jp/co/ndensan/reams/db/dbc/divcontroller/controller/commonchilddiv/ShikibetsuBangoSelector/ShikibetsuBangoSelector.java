/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.commonchilddiv.ShikibetsuBangoSelector;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.ShikibetsuBangoSelectorDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector.dgDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.shikibetsubangoselector.ShikibetsuBangoSelectorDivHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 識別番号選択のクラス
 *
 * @author 潘鶴
 */
public class ShikibetsuBangoSelector {

    public ResponseData<ShikibetsuBangoSelectorDiv> onLoad(ShikibetsuBangoSelectorDiv requestDiv) {
        RString hiddenYoshikiNo = DataPassingConverter.deserialize(requestDiv.getHiddenYoshikiNo(), RString.class);
        RString hiddenServiceTeikyoYM = DataPassingConverter.deserialize(requestDiv.getHiddenServiceTeikyoYM(), RString.class);
        RString hiddenShikibetsuCode = DataPassingConverter.deserialize(requestDiv.getHiddenShikibetsuCode(), RString.class);
        getHandler(requestDiv).initialize(hiddenYoshikiNo, hiddenServiceTeikyoYM, hiddenShikibetsuCode);
        return ResponseData.of(requestDiv).respond();
    }

    public ResponseData<ShikibetsuBangoSelectorDiv> onClick_btnSearch(ShikibetsuBangoSelectorDiv requestDiv) {
        getHandler(requestDiv).getShikibetsuBangoJoho(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    public ResponseData<ShikibetsuBangoSelectorDiv> onClick_btnSelect(ShikibetsuBangoSelectorDiv requestDiv) {
        dgDetail_Row selectRow = requestDiv.getDgDetail().getClickedItem();
        requestDiv.setHiddenSelectCode(DataPassingConverter.serialize(selectRow.getTxtShikibetsuCode()));
        requestDiv.setHiddenSelectKoumoku(DataPassingConverter.serialize(selectRow.getTxtShikibetsuKomoku()));
        return ResponseData.of(requestDiv).respond();
    }

    private ShikibetsuBangoSelectorDivHandler getHandler(ShikibetsuBangoSelectorDiv requestDiv) {
        return new ShikibetsuBangoSelectorDivHandler(requestDiv);
    }
}

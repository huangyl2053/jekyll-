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
 */
public class ShikibetsuBangoSelector {

    /**
     * 初期化
     *
     * @param requestDiv ShikibetsuBangoSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ShikibetsuBangoSelectorDiv> onLoad(ShikibetsuBangoSelectorDiv requestDiv) {
        RString hiddenYoshikiNo = DataPassingConverter
                .deserialize(requestDiv.getHiddenYoshikiNo(), RString.class);
        RString hiddenServiceTeikyoYM = DataPassingConverter
                .deserialize(requestDiv.getHiddenServiceTeikyoYM(), RString.class);
        RString hiddenShikibetsuCode = DataPassingConverter
                .deserialize(requestDiv.getHiddenShikibetsuCode(), RString.class);
        getHandler(requestDiv).initialize(hiddenYoshikiNo, hiddenServiceTeikyoYM, hiddenShikibetsuCode);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「検索」ボタン
     *
     * @param requestDiv ShikibetsuBangoSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ShikibetsuBangoSelectorDiv> onClick_btnSearch(ShikibetsuBangoSelectorDiv requestDiv) {
        getHandler(requestDiv).getShikibetsuBangoJoho(requestDiv);
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 「選択」ボタン
     *
     * @param requestDiv ShikibetsuBangoSelectorDiv
     * @return ResponseData
     */
    public ResponseData<ShikibetsuBangoSelectorDiv> onClick_btnSelect(ShikibetsuBangoSelectorDiv requestDiv) {
        dgDetail_Row selectRow = requestDiv.getDgDetail().getClickedItem();
        requestDiv.setHiddenSelectCode(DataPassingConverter.serialize(
                selectRow.getTxtShikibetsuCode().substring(selectRow.getTxtShikibetsuCode().length() - 2,
                        selectRow.getTxtShikibetsuCode().length())));
        requestDiv.setHiddenSelectKoumoku(DataPassingConverter.serialize(selectRow.getTxtShikibetsuKomoku()));
        return ResponseData.of(requestDiv).respond();
    }

    /**
     * 識別番号選択のHandlerクラスを取得
     *
     * @param requestDiv ShikibetsuBangoSelectorDiv
     * @return ShikibetsuBangoSelectorDivHandler
     */
    private ShikibetsuBangoSelectorDivHandler getHandler(ShikibetsuBangoSelectorDiv requestDiv) {
        return new ShikibetsuBangoSelectorDivHandler(requestDiv);
    }
}

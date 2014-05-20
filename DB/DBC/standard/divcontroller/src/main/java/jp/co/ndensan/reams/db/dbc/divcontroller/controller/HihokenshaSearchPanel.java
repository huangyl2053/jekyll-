/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.HihokenshaSearchPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 福祉用具購入費支給申請 被保険者検索条件パネルです。
 *
 * @author n8223
 */
public class HihokenshaSearchPanel {

    /**
     * 福祉用具購入費支給申請 被保険者検索条件情報の初期値をセットします。
     *
     * @param panel HihokenshaSearchPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<HihokenshaSearchPanelDiv> onLoad(HihokenshaSearchPanelDiv panel) {
        ResponseData<HihokenshaSearchPanelDiv> response = new ResponseData<>();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShimei().setValue(new RString("電算 太郎"));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchDateOfBirth().setValue(new RString("19330325"));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShichosonCode().setValue(new RString("1111111111"));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchShikibetsuCode().setValue(new RString("1111111112"));
        panel.getReamsCommonSearchInfoPanel().getTxtSearchSetaiCode().setValue(new RString("1111111113"));

        panel.getDBCommonSearchInfoPanel().getTxtSearchHihokenshaNo().setValue(new RString("1111111114"));

        response.data = panel;
        return response;
    }

}

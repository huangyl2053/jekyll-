/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.parentdiv.DBE0110002;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002.HakkoJokenSinnseiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE0110002.HakkoJokenSinnseiHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請に関する帳票発行画面クラスです
 *
 * @reamsid_L DBE-1390-050 xuyongchao
 */
public class HakkoJokenSinnsei {

    private static final RString SELECT_KEY0 = new RString("key0");
    private static final RString SELECT_KEY1 = new RString("key1");

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onLoad(HakkoJokenSinnseiDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 作成帳票チェックボックス処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_chkSakuseiChohyo(HakkoJokenSinnseiDiv div) {
        if (div.getChkSakuseiChohyo().getSelectedKeys().contains(SELECT_KEY0) || div.getChkSakuseiChohyo().getSelectedKeys().contains(SELECT_KEY1)) {
            div.getRadHakoJyoken().setDisabled(false);
            div.getTxtShoriYMD().setDisabled(false);
            div.getTxtShinseibi().setDisabled(false);
            onClick_radHakoJyoken(div);
        } else {
            div.getRadHakoJyoken().setDisabled(true);
            div.getTxtShoriYMD().clearFromValue();
            div.getTxtShoriYMD().clearToValue();
            div.getTxtShoriYMD().setDisabled(true);
            div.getTxtShinseibi().clearFromValue();
            div.getTxtShinseibi().clearToValue();
            div.getTxtShinseibi().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 作成条件ラジオボタン処理です。
     *
     * @param div 画面情報
     * @return ResponseData<HakkoJokenSinnseiDiv>
     */
    public ResponseData<HakkoJokenSinnseiDiv> onClick_radHakoJyoken(HakkoJokenSinnseiDiv div) {
        if (div.getRadHakoJyoken().getSelectedKey().contains(SELECT_KEY0)) {
            div.getTxtShoriYMD().setDisabled(false);
            div.getTxtShinseibi().clearFromValue();
            div.getTxtShinseibi().clearToValue();
            div.getTxtShinseibi().setDisabled(true);
        } else {
            div.getTxtShinseibi().setDisabled(false);
            div.getTxtShoriYMD().clearFromValue();
            div.getTxtShoriYMD().clearToValue();
            div.getTxtShoriYMD().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    private HakkoJokenSinnseiHandler getHandler(HakkoJokenSinnseiDiv div) {
        return new HakkoJokenSinnseiHandler(div);
    }
}

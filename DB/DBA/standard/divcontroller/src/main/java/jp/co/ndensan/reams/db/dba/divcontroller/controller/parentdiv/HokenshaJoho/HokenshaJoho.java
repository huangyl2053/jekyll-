/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho.HokenshaJohoHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者入力補助のDivControllerです
 *
 */
public class HokenshaJoho {

    /**
     * 保険者コードを入れる。<br/>
     * 保険者名を自動表示します。
     *
     * @param div {@link HokenshaJohoDiv 保険者入力補助Div}
     * @return 保険者入力補助Divを持つResponseData
     */
    public ResponseData<HokenshaJohoDiv> lostfocus_txtHokenshaNo(HokenshaJohoDiv div) {
        if (div.getTxtHokenshaNo().getValue().isEmpty()) {
            div.getTxtHokenshaMeisho().setValue(RString.EMPTY);
            return ResponseData.of(div).respond();
        }
        getHandler(div).onBlur_txtHokenshaNo(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、保険者入力ダイアログ画面が表示します。
     *
     * @param div　HokenshaJohoDiv
     * @return HokenshaJohoDiv div
     */
    public ResponseData<HokenshaJohoDiv> onBeforeOpenDialog_btnSearch(HokenshaJohoDiv div) {
        div.setTxtHokenshaNo(div.getTxtHokenshaNo());
        div.setTxtHokenshaMeisho(div.getTxtHokenshaMeisho());
        return ResponseData.of(div).respond();
    }

    /**
     * 「検索」ボタンをクリック場合、保険者入力ダイアログ画面が表示します。
     *
     * @param div　HokenshaJohoDiv
     * @return HokenshaJohoDiv div
     */
    public ResponseData<HokenshaJohoDiv> onOkClose_btnSearch(HokenshaJohoDiv div) {

        return ResponseData.of(div).respond();
    }

    private HokenshaJohoHandler getHandler(HokenshaJohoDiv div) {
        return new HokenshaJohoHandler(div);
    }
}

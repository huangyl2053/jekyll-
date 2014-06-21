/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001.ShinseishaKensakuDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 個人状況照会検索Divを制御します。
 *
 * @author N9606 漢那 憲作
 */
public class ShinseishaKensaku {

    /**
     * 申請者検索画面-検索条件クリアボタン押下時の処理を表します。
     *
     * @param panel ShinseishaKensakuDiv
     * @return ResponseData
     */
    public ResponseData<ShinseishaKensakuDiv> onClick_BtnKensakuKeyClear(ShinseishaKensakuDiv panel) {
        ResponseData<ShinseishaKensakuDiv> response = new ResponseData<>();

        panel.getDdlKeyHokensha().setSelectedItem(new RString("1"));
        panel.getTxtKeyHihoNo().clearValue();
        panel.getTxtKeyShinseibi().clearValue();
        panel.getDdlKeyShinseiKbn().setSelectedItem(new RString("1"));
        panel.getDdlKeyHihokenshaKbn().setSelectedItem(new RString("1"));
        panel.getTxtKeyShimei().clearValue();
        panel.getDdlKeyPadding().setSelectedItem(new RString("1"));
        panel.getTxtKeyUmareYmd().clearValue();
        panel.getDdlKeySeibetsu().setSelectedItem(new RString("1"));
        panel.getTxtKeyYubinNo().clearValue();
        panel.getTxtKeyJusho().clearValue();
        panel.getTxtKeyTel().clearValue();

        response.data = panel;
        return response;

    }

}

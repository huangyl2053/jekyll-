/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.BunshoBangoInput;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.BunshoBangoInput.BunshoBangoInputHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 文書番号入力Divの画面イベントを記述するクラスです。
 */
public class BunshoBangoInput {

    /**
     * 「文書番号取得」ボタンクリック時に呼び出される処理です。
     *
     * @param div BunshoBangoInputDiv
     * @return ResponseData<BunshoBangoInputDiv>
     */
    public ResponseData<BunshoBangoInputDiv> onClick_BtnGetBunshoNo(BunshoBangoInputDiv div) {
        RString 文書番号 = getHandler(div).get自動採番文書番号();
        div.getTxtBunshoNo().setValue(文書番号);
        return ResponseData.of(div).respond();
    }

    @JsonIgnore
    private BunshoBangoInputHandler getHandler(BunshoBangoInputDiv div) {
        return new BunshoBangoInputHandler(div);
    }

}

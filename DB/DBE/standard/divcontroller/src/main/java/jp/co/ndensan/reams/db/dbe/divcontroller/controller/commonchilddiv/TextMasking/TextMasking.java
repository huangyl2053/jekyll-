/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.controller.commonchilddiv.TextMasking;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking.TextMaskingDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TextMasking.TextMasking.TextMaskingHandler;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 共有子Div 「TextMasking」のイベントを定義したDivControllerです。
 *
 * @reamsid_L DBE-3000-250 jinjue
 */
public class TextMasking {

    /**
     * 画面初期化に特記事項の情報を表示します。
     *
     * @param div TextMaskingDiv
     * @return ResponseData<TextMaskingDiv>
     */
    public ResponseData<TextMaskingDiv> onLoad(TextMaskingDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 画面で編集するマスキング後の情報を保存します。
     *
     * @param div TextMaskingDiv
     * @return ResponseData<TextMaskingDiv>
     */
    public ResponseData<TextMaskingDiv> onClick_btnHozon(TextMaskingDiv div) {
        getHandler(div).onClick_btnHozon();
        return ResponseData.of(div).respond();
    }

    /**
     * 親画面から渡すパラメータをそのまま戻す、本画面を閉じます。
     *
     * @param div TextMaskingDiv
     * @return ResponseData<TextMaskingDiv>
     */
    public ResponseData<TextMaskingDiv> onClick_btnModoru(TextMaskingDiv div) {
        return ResponseData.of(div).respond();
    }

    private TextMaskingHandler getHandler(TextMaskingDiv div) {
        return new TextMaskingHandler(div);
    }
}

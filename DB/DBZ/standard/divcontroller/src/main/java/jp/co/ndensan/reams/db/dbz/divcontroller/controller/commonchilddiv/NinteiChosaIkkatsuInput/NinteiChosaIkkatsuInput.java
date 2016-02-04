/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiChosaIkkatsuInput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputHandler;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;

/**
 *
 * 共有子Div 「NinteiChosaIkkatsuInput」のイベントを定義したDivControllerです。
 */
public class NinteiChosaIkkatsuInput {

    /**
     * コンストラクタです。
     *
     */
    public NinteiChosaIkkatsuInput() {

    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onLoad(NinteiChosaIkkatsuInputDiv div) {
        getHandler(div).initialize();
        return ResponseData.of(div).respond();
    }

    /**
     * 「保存」ボタンを処理する。
     *
     * @param div
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> onClick_btnKaKuNin(NinteiChosaIkkatsuInputDiv div) {
        if (div.getChkDay().getSelectedItems().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.選択されていない.getMessage().replace("曜日"));
        }
        if (div.getChkUpdate().getSelectedItems().isEmpty()) {
            getHandler(div).hozon(false);
        } else {
            getHandler(div).hozon(true);
        }
        return ResponseData.of(div).respond();
    }

    private NinteiChosaIkkatsuInputHandler getHandler(NinteiChosaIkkatsuInputDiv div) {
        return new NinteiChosaIkkatsuInputHandler(div);
    }
}

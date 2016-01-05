/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.parentdiv.NinteiChosaIkkatsuInput;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.db.dbz.service.core.ninteiChosaIkkatsu.NinteiChosaIkkatsuInputManager;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * 共有子Div 「NinteiChosaIkkatsuInput」のイベントを定義したDivControllerです。
 */
public class NinteiChosaIkkatsuInput {

    private final NinteiChosaIkkatsuInputManager service;

    private final FlexibleDate 設定年月 = new FlexibleDate("20151203");

    /**
     * コンストラクタです。
     *
     */
    public NinteiChosaIkkatsuInput() {
        service = NinteiChosaIkkatsuInputManager.createInstance();
    }

    /**
     * 共通子DIVを初期化します。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> OnLoad(NinteiChosaIkkatsuInputDiv div) {

        return null;

    }

    /**
     * 「戻る」ボタンを処理する。
     *
     * @param div NinteiChosaIkkatsuInputDiv
     * @return ResponseData<NinteiChosaIkkatsuInputDiv>
     */
    public ResponseData<NinteiChosaIkkatsuInputDiv> OnLick_btnModoru(NinteiChosaIkkatsuInputDiv div) {
        ResponseData<NinteiChosaIkkatsuInputDiv> response = new ResponseData<>();
        response.data = div;
        return response;
    }
}

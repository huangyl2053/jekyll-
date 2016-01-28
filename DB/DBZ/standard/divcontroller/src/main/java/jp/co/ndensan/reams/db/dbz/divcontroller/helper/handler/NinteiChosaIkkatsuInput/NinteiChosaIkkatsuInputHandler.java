/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper.handler.NinteiChosaIkkatsuInput;

import jp.co.ndensan.reams.db.dbz.business.core.ninteichosaikkatsuinput.NinteiChosaIkkatsuInputModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInput.NinteiChosaIkkatsuInputDiv;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 *
 * 共有子Div 「NinteiChosaIkkatsuInput」のhandlerクラスです。
 */
public class NinteiChosaIkkatsuInputHandler {

    private NinteiChosaIkkatsuInputDiv div;

    public NinteiChosaIkkatsuInputHandler(NinteiChosaIkkatsuInputDiv div) {
        this.div = div;
    }

    public void OnLoad() {
        NinteiChosaIkkatsuInputModel NinteiChosaIkkatsuInput = DataPassingConverter.deserialize(div.getDecorationClass(), NinteiChosaIkkatsuInputModel.class);
        if (NinteiChosaIkkatsuInput.get時間枠1().isEmpty()) {

        }
    }
}

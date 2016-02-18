/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0410012;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410012.KokuhorenJohoTorikomiBatchKidoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenJohoTorikomiValidator {

    private final KokuhorenJohoTorikomiBatchKidoDiv div;

    public KokuhorenJohoTorikomiValidator(KokuhorenJohoTorikomiBatchKidoDiv div) {
        this.div = div;
    }

    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KokuhorenJohoTorikomiSpec.同月過誤もしくは通常分給付実績情報にチェックがある)
                .thenAdd(KokuhorenJohoValidationMessage.処理対象情報が未選択).messages());
        messages.add(ValidateChain.validateStart(div).ifNot(KokuhorenJohoTorikomiSpec.出力順が有効である場合に出力順が設定されている)
                .thenAdd(KokuhorenJohoValidationMessage.出力順序未指定).messages());

        return messages;
    }

}

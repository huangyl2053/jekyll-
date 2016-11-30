/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0410032;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410032.TsuchishoJoho37JDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 国保連情報受取データ取込_[37J]高額合算自己負担額確認情報のValidatorです。
 *
 * @reamsid_L DBC-0980-090 tangkai
 */
public class TsuchishoJoho37JValidator implements IValidatable {

    private final TsuchishoJoho37JDiv div;

    /**
     * コンストラクタ
     *
     * @param div TsuchishoJoho37JDiv
     */
    public TsuchishoJoho37JValidator(TsuchishoJoho37JDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(TsuchishoJoho37JSpec.出力順入力チェック)
                .thenAdd(TsuchishoJoho37JValidationMessages.出力順入力チェック)
                .messages());
        return messages;
    }
}

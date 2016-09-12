/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5320001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5320001.NinteiTsuchishoHakkoDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 要介護認定通知書発行画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
public class NinteiTsuchishoHakkoValidator implements IValidatable {

    private final NinteiTsuchishoHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiTsuchishoHakkoDiv
     */
    public NinteiTsuchishoHakkoValidator(NinteiTsuchishoHakkoDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NinteiTsuchishoHakkoSpec.個別印刷0件チェック)
                .thenAdd(NinteiTsuchishoHakkoValidationMessage.個別印刷0件チェック)
                .messages());
        return messages;
    }

    /**
     * 選択対象チェックします。
     *
     * @return 選択対象チェック結果
     */
    public IValidationMessages validate選択対象() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NinteiTsuchishoHakkoSpec.個別印刷選択0件チェック)
                .thenAdd(NinteiTsuchishoHakkoValidationMessage.個別印刷選択0件チェック)
                .ifNot(NinteiTsuchishoHakkoSpec.個別印刷選択複数件チェック)
                .thenAdd(NinteiTsuchishoHakkoValidationMessage.個別印刷選択複数件チェック)
                .messages());
        return messages;
    }

}

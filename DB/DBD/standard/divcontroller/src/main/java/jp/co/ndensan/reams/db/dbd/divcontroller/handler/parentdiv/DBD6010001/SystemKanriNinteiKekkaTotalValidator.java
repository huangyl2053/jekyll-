/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD6010001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010001.SystemKanriNinteiKekkaTotalDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * @author tz_sunl
 */
public class SystemKanriNinteiKekkaTotalValidator implements IValidatable {

    private final SystemKanriNinteiKekkaTotalDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShokkenTorikeshiIchibuSoshituDiv
     */
    public SystemKanriNinteiKekkaTotalValidator(SystemKanriNinteiKekkaTotalDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(SystemKanriNinteiKekkaTotalSpec.付加情報_データ更新チェック)
                .thenAdd(SystemKanriNinteiKekkaTotalValidationMessage.更新対象のデータがない)
                .messages());
        return messages;
    }

}

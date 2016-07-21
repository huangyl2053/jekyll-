/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD4940001;

import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4940001.NinteiShinseiTorokuTorikeshiShosaiDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * 要介護認定取消画面の入力チェッククラスです。
 *
 * @reamsid_L DBD-2090-010 lit
 */
public class NinteiShinseiTorokuTorikeshiShosaiValidator implements IValidatable {

    private final NinteiShinseiTorokuTorikeshiShosaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteiShinseiTorokuTorikeshiShosaiDiv
     */
    public NinteiShinseiTorokuTorikeshiShosaiValidator(NinteiShinseiTorokuTorikeshiShosaiDiv div) {
        this.div = div;
    }

    @Override
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NinteiShinseiTorokuTorikeshiShosaiSpec.異動事由が未選択チェック)
                .thenAdd(NinteiShinseiTorokuTorikeshiShosaiValidationMessage.異動事由が未選択チェック)
                .ifNot(NinteiShinseiTorokuTorikeshiShosaiSpec.理由が未入力チェック)
                .thenAdd(NinteiShinseiTorokuTorikeshiShosaiValidationMessage.理由が未入力チェック)
                .ifNot(NinteiShinseiTorokuTorikeshiShosaiSpec.更新チェック)
                .thenAdd(NinteiShinseiTorokuTorikeshiShosaiValidationMessage.更新チェック)
                .messages());
        return messages;
    }

}

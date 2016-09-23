/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD9010003;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD9010003.IkenshoKakuninshoDivSpec;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 主治医意見書確認書画面のバリデーションハンドラークラスです。
 * 
 * @reamsid_L DBD-5790-010 x_zhaowen
 */
public class IkenshoKakuninshoValidationHandler {
    
    private final IkenshoKakuninshoDiv div;

    /**
     * コンストラクタです。
     * 
     * @param div IkenshoKakuninshoDiv
     */
    public IkenshoKakuninshoValidationHandler(IkenshoKakuninshoDiv div) {
        this.div = div;
    }
    
    
    /**
     * 発行確認チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs 発行確認チェック(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(IkenshoKakuninshoDivSpec.発行確認チェック)
                .thenAdd(IkenshoKakuninshoValidationHandler.HakkoKakuninMessages.発行確認チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                IkenshoKakuninshoValidationHandler.HakkoKakuninMessages.発行確認チェック, div.getPanelShosaiEria()).build().check(messages));
        return pairs;
    }
    
    private static enum HakkoKakuninMessages implements IValidationMessage {
        発行確認チェック(DbdErrorMessages.確認書_証明書発行不可.getMessage(), "主治医意見書確認書");
        
        private final Message message;

        private HakkoKakuninMessages(Message message, String... replacements) {
            this.message = message.replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

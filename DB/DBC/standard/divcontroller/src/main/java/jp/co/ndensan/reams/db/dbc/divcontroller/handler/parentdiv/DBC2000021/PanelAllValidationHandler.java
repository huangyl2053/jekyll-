/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000021;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000021.DBC2000021PanelAllDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 利用者負担割合即時更正_新規のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-5010-010 lihang
 */
public class PanelAllValidationHandler {

    private final DBC2000021PanelAllDiv div;

    /**
     * コンストラクタです。
     *
     * @param div PanelAllDiv
     */
    public PanelAllValidationHandler(DBC2000021PanelAllDiv div) {
        this.div = div;
    }

    /**
     * 入力ェックを行います。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
//        RiyoshaFutanWariaiHantei.
        IValidationMessages messages = validatea();
        return new ValidationDictionaryBuilder()
                //                .add(PanelAllValidationMessage.基準日が未入力, div.getTxtKijunbi())
                .add(PanelAllValidationMessage.基準日は指定年度内の日付を指定してください, div.getTxtKijunbi())
                .build().check(messages);

    }

    /**
     * 入力チェックを行います。 範囲チェックを行います。
     *
     * @return バリデーション突合結果
     */
    public IValidationMessages validatea() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                //                .ifNot(PanelAllSpec.基準日が未入力の場合)
                //                .thenAdd(PanelAllValidationMessage.基準日が未入力)
                .ifNot(PanelAllSpec.基準日は指定年度内の日付を指定してくださいの場合)
                .thenAdd(PanelAllValidationMessage.基準日は指定年度内の日付を指定してください)
                .messages());
        return messages;
    }

    private static enum PanelAllValidationMessage implements IValidationMessage {

//        基準日が未入力(UrErrorMessages.未入力),
        基準日は指定年度内の日付を指定してください(UrErrorMessages.未指定);

        private final Message message;

        PanelAllValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        /**
         * メッセージ取得を行います。
         *
         * @return メッセージ
         */
        @Override
        public Message getMessage() {
            return message;
        }
    }

}

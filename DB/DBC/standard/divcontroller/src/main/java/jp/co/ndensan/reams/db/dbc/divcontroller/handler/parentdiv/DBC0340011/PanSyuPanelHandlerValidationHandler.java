/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0340011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0340011.PanSyuPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額サービス費受領委任契約承認（不承認）確認書作成のクラスです。
 *
 * @reamsid_L DBC-1970-010 wangxingpeng
 */
public class PanSyuPanelHandlerValidationHandler {

    private PanSyuPanelDiv div;
    private static final RString 契約申請日の範囲 = new RString("契約申請日の範囲");
    private static final RString 契約決定日の範囲 = new RString("契約決定日の範囲");

    /**
     * コンストラクタです。
     *
     * @param div PanSyuPanelDiv
     */
    public PanSyuPanelHandlerValidationHandler(PanSyuPanelDiv div) {
        this.div = div;
    }

    /**
     * validateチェック
     *
     * @return validPairs ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validate() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).
                ifNot(PanSyuPanelHandlerSpec.契約申請日の範囲チェック).
                thenAdd(IdocheckMessages.契約申請日の範囲チェック).
                ifNot(PanSyuPanelHandlerSpec.契約決定日の範囲チェック).
                thenAdd(IdocheckMessages.契約決定日の範囲チェック).
                messages());
        validPairs.add(createDictionary().check(messages));
        return validPairs;
    }

    private ValidationDictionary createDictionary() {

        return new ValidationDictionaryBuilder()
                .add(IdocheckMessages.契約申請日の範囲チェック, div.getPanJyoken().getTxtKeyakuSinseibi())
                .add(IdocheckMessages.契約決定日の範囲チェック, div.getPanJyoken().getTxtKeiyakuKeteibi())
                .build();
    }

    private enum IdocheckMessages implements IValidationMessage {

        契約申請日の範囲チェック(UrErrorMessages.不正, 契約申請日の範囲.toString()),
        契約決定日の範囲チェック(UrErrorMessages.不正, 契約決定日の範囲.toString());
        private final Message message;

        private IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

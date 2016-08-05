/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000014;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000014.FutanWariaiShoHakkoPanelDiv;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 画面設計_DBCMNK3001_負担割合証発行（一括）のValidationHandlerクラスです。
 *
 * @reamsid_L DBC-4990-010 pengxingyi
 */
public class FutanWariaiShoHakkoValidationHandler {

    private final FutanWariaiShoHakkoPanelDiv div;

    private FutanWariaiShoHakkoValidationHandler(FutanWariaiShoHakkoPanelDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div FutanWariaiShoHakkoPanelDiv
     * @return FutanWariaiShoHakkoValidationHandler
     */
    public static FutanWariaiShoHakkoValidationHandler of(FutanWariaiShoHakkoPanelDiv div) {
        return new FutanWariaiShoHakkoValidationHandler(div);
    }

    /**
     * 「実行する」ボタンと「条件を保存」ボタンをクリック時のバリデーションチェックします。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validateBatchStart() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);

    }

    private static class ControlValidator {

        private final FutanWariaiShoHakkoPanelDiv div;

        /**
         * Validator制御です。
         *
         * @param div FutanWariaiShoHakkoPanelDiv
         */
        public ControlValidator(FutanWariaiShoHakkoPanelDiv div) {
            this.div = div;
        }

        /**
         * 「実行する」ボタンクリック時のバリデーションチェックします。
         *
         * @param parameter 検索条件
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(FutanWariaiShoHakkoSpec.抽出期間不正)
                    .thenAdd(FutanWariaiShoHakkoValidationMessage.抽出期間不正)
                    .messages());
            return messages;
        }

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder().
                add(FutanWariaiShoHakkoValidationMessage.抽出期間不正,
                        div.getPanelKikan().getTxtKonkaiKaishiDate(), div.getPanelKikan().getTxtKonkaiKaishiTime(),
                        div.getPanelKikan().getTxtZenkaiShuryoDate(), div.getPanelKikan().getTxtZenkaiShuryoTime())
                .build();
    }

    private static enum FutanWariaiShoHakkoValidationMessage implements IValidationMessage {

        抽出期間不正(DbcErrorMessages.抽出期間不正),
        入力必須(UrErrorMessages.必須項目);

        private final Message message;

        private FutanWariaiShoHakkoValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

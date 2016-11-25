/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB6110001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB6110001.KaigoHihokenshaInfoPanelDiv;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 連帯納付義務者登録ValidationHandlerです。
 *
 * @reamsid_L DBB-1640-010 jiangzongyue
 */
public class KaigoHihokenshaInfoValidationHandler {

    private final KaigoHihokenshaInfoPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div KaigoHihokenshaInfoValidationHandler
     */
    public KaigoHihokenshaInfoValidationHandler(KaigoHihokenshaInfoPanelDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KaigoHihokenshaInfoValidationMessage.連帯納付義務者が選択されていない)
                .add(KaigoHihokenshaInfoValidationMessage.初期状態からの変更有無)
                .add(KaigoHihokenshaInfoValidationMessage.開始日未入力)
                .add(KaigoHihokenshaInfoValidationMessage.開始日と終了日の前後順)
                .add(KaigoHihokenshaInfoValidationMessage.同一日における複数連帯納付義務者登録)
                .add(KaigoHihokenshaInfoValidationMessage.前履歴より前の期間指定)
                .build();
    }

    private static class ControlValidator {

        private final KaigoHihokenshaInfoPanelDiv div;

        /**
         * ControlValidatorのコンストラクタです。
         *
         * @param div JukyushaIdoRenrakuhyoTorokuPanelDiv
         */
        public ControlValidator(KaigoHihokenshaInfoPanelDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェックです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KaigoHihokenshaInfoSpec.連帯納付義務者が選択されていない)
                    .thenAdd(KaigoHihokenshaInfoValidationMessage.連帯納付義務者が選択されていない)
                    .ifNot(KaigoHihokenshaInfoSpec.初期状態からの変更有無)
                    .thenAdd(KaigoHihokenshaInfoValidationMessage.初期状態からの変更有無)
                    .ifNot(KaigoHihokenshaInfoSpec.開始日未入力)
                    .thenAdd(KaigoHihokenshaInfoValidationMessage.開始日未入力)
                    .ifNot(KaigoHihokenshaInfoSpec.開始日と終了日の前後順)
                    .thenAdd(KaigoHihokenshaInfoValidationMessage.開始日と終了日の前後順)
                    .ifNot(KaigoHihokenshaInfoSpec.同一日における複数連帯納付義務者登録)
                    .thenAdd(KaigoHihokenshaInfoValidationMessage.同一日における複数連帯納付義務者登録)
                    .ifNot(KaigoHihokenshaInfoSpec.前履歴より前の期間指定)
                    .thenAdd(KaigoHihokenshaInfoValidationMessage.前履歴より前の期間指定)
                    .messages());
            return messages;
        }

    }

    private static enum KaigoHihokenshaInfoValidationMessage implements IValidationMessage {

        連帯納付義務者が選択されていない(UrErrorMessages.選択されていない, "連帯納付義務者"),
        初期状態からの変更有無(UrErrorMessages.更新不可_汎用, "編集されていない"),
        開始日未入力(UrErrorMessages.必須, "開始日"),
        開始日と終了日の前後順(UrErrorMessages.終了日が開始日以前),
        同一日における複数連帯納付義務者登録(ErrorMessages.同一日における複数連帯納付義務者登録),
        前履歴より前の期間指定(ErrorMessages.前履歴より前の期間指定);

        private final Message message;

        KaigoHihokenshaInfoValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }

    private static enum ErrorMessages implements IMessageGettable {

        同一日における複数連帯納付義務者登録(1, "既に登録されている連帯納付義務者と期間を重複しての登録はできません。"),
        前履歴より前の期間指定(2, "既に登録されている連帯納付義務者の期間より以前の期間は登録できません");
        private final Message message;

        /**
         * コンストラクタです。
         *
         * @param no 番号
         * @param message メッセージ
         */
        private ErrorMessages(int no, String message) {
            this.message = new ErrorMessage(toCode("DBBE", no), message);
        }

        @Override
        public Message getMessage() {
            return this.message;
        }
    }

}

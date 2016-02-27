/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb0210001;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210001.ChoteiboSakuseiDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
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
 * 調定簿作成のバリデーションハンドラークラスです。
 */
public class ChoteiboSakuseiValidationHandler {

    private final ChoteiboSakuseiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 調定簿作成Div
     */
    public ChoteiboSakuseiValidationHandler(ChoteiboSakuseiDiv div) {
        this.div = div;
    }

    /**
     * 実行と条件保存ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ChoteiboSakuseiValidationMessages.処理年度未入力, div.getDdlShoriNendo())
                .add(ChoteiboSakuseiValidationMessages.抽出調定日時の開始年月日未入力, div.getTxtChushutsuStYMD())
                .add(ChoteiboSakuseiValidationMessages.抽出調定日時の開始時分秒未入力, div.getTxtChushutsuStTime())
                .add(ChoteiboSakuseiValidationMessages.抽出調定日時の終了年月日未入力, div.getTxtChushutsuEdYMD())
                .add(ChoteiboSakuseiValidationMessages.抽出調定日時の終了時分秒未入力, div.getTxtChushutsuEdTime())
                .build();
    }

    private static class ControlValidator {

        private final ChoteiboSakuseiDiv div;

        public ControlValidator(ChoteiboSakuseiDiv div) {
            this.div = div;
        }

        /**
         * 「 実行と条件保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(ChoteiboSakuseiSpec.処理年度入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.処理年度未入力)
                    .ifNot(ChoteiboSakuseiSpec.抽出調定日時の開始年月日入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.抽出調定日時の開始年月日未入力)
                    .ifNot(ChoteiboSakuseiSpec.抽出調定日時の開始時分秒入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.抽出調定日時の開始時分秒未入力)
                    .ifNot(ChoteiboSakuseiSpec.抽出調定日時の終了年月日入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.抽出調定日時の終了年月日未入力)
                    .ifNot(ChoteiboSakuseiSpec.抽出調定日時の終了時分秒入力)
                    .thenAdd(ChoteiboSakuseiValidationMessages.抽出調定日時の終了時分秒未入力)
                    .messages());
            return messages;
        }
    }

    private static enum ChoteiboSakuseiValidationMessages implements IValidationMessage {

        処理年度未入力(UrErrorMessages.必須, "処理年度"),
        抽出調定日時の開始年月日未入力(UrErrorMessages.必須, "抽出調定日時の開始年月日"),
        抽出調定日時の開始時分秒未入力(UrErrorMessages.必須, "抽出調定日時の開始時分秒（以上）"),
        抽出調定日時の終了年月日未入力(UrErrorMessages.必須, "抽出調定日時の終了年月日"),
        抽出調定日時の終了時分秒未入力(UrErrorMessages.必須, "抽出調定日時の終了時分秒（未満）");
        private final Message message;

        ChoteiboSakuseiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB1120001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001.ShotokuJohoChushutsuKoikiBatchParameterDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.FileData;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 所得情報抽出・連携（広域用）のHandlerクラスです。
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoChushutsuKoikiBatchParameterValidationHandler {

    private final ShotokuJohoChushutsuKoikiBatchParameterDiv div;
    private static final RString DEC05F001 = new RString("DEC05F001");
    private static final RString DEE01F001 = new RString("DEE01F001");

    /**
     * コンストラクタです。
     *
     * @param div ShotokuJohoChushutsuKoikiBatchParameterDiv
     */
    public ShotokuJohoChushutsuKoikiBatchParameterValidationHandler(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェック。
     *
     * @param files FileData[]
     * @return バリデーション突合結果
     */
    @SuppressWarnings("checkstyle:illegaltoken")
    public ValidationMessageControlPairs 必須チェックValidate(FileData[] files) {
        IValidationMessages messages = new ControlValidator(div).validate(files);
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(ShotokuJohoChushutsuKoikiBatchParameterHandlerValidationMessages.共有ファイル化したCSVファイルのチェック)
                .build();
    }

    private static class ControlValidator {

        private final ShotokuJohoChushutsuKoikiBatchParameterDiv div;

        public ControlValidator(ShotokuJohoChushutsuKoikiBatchParameterDiv div) {
            this.div = div;
        }

        /**
         * 「 実行ボタンクリック時のバリデーションチェック。
         *
         * @param files FileData[]
         * @return バリデーション突合結果
         */
        @SuppressWarnings("checkstyle:illegaltoken")
        public IValidationMessages validate(FileData[] files) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            if (files[0] == null || !files[0].getFileName().startsWith(DEC05F001) || !files[0].getFileName().startsWith(DEE01F001)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(ShotokuJohoChushutsuKoikiBatchParameterSpec.共有ファイル化したCSVファイルのチェック)
                        .thenAdd(ShotokuJohoChushutsuKoikiBatchParameterHandlerValidationMessages.共有ファイル化したCSVファイルのチェック)
                        .messages());

            }
            return messages;
        }
    }

    private static enum ShotokuJohoChushutsuKoikiBatchParameterHandlerValidationMessages implements IValidationMessage {

        // QA DbborDbz：アップロードファイルが不正
        共有ファイル化したCSVファイルのチェック(DbbErrorMessages.valueOf(null));

        private final Message message;

        ShotokuJohoChushutsuKoikiBatchParameterHandlerValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

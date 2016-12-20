/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2060001;

import jp.co.ndensan.reams.db.dbe.definition.message.DbeErrorMessages;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2060001.NinteichosaKekkaNyushuDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 完了処理・認定調査結果入手のValidationHandlerクラスです。
 *
 * @reamsid_L DBE-0310-010 dingyi
 */
public class NinteichosaKekkaNyushuValidationHandler {

    private final NinteichosaKekkaNyushuDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 完了処理・認定調査結果入手Div
     */
    public NinteichosaKekkaNyushuValidationHandler(NinteichosaKekkaNyushuDiv div) {
        this.div = div;
    }

    /**
     * 「一覧を出力する」ボタンを押下したときのバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnChosakekkaOutput() {
        IValidationMessages messages = new ControlValidator(div).validate1();
        return createDictionary().check(messages);
    }

    /**
     * 「調査結果を登録する」ボタンを押下したときのバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnKekkaTouroku() {
        IValidationMessages messages = new ControlValidator(div).validate2();
        return createDictionary().check(messages);
    }

    /**
     * 「調査票入手を完了する」ボタンをしたときのバリデーションチェックです。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnChousaResultKanryo() {
        IValidationMessages messages = new ControlValidator(div).validate3();
        return createDictionary().check(messages);
    }

    /**
     * 「モバイルデータを取込む」ボタンを押下したときのバリデーションチェック1です。
     *
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnCyosakekkaInput1() {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        validationMessages.add(new ValidationMessageControlPair(NinteichosaKekkaNyushuValidationMessage.ファイルが存在しない));
        return validationMessages;
    }

    /**
     * 「モバイルデータを取込む」ボタンを押下したときのバリデーションチェック2です。
     *
     * @param 取込み対象データの件数 取込み対象データの件数
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 入力チェック_btnCyosakekkaInput2(int 取込み対象データの件数) {
        ValidationMessageControlPairs validationMessages = new ValidationMessageControlPairs();
        if (取込み対象データの件数 == 0) {
            validationMessages.add(new ValidationMessageControlPair(NinteichosaKekkaNyushuValidationMessage.存在しない));
        }
        return validationMessages;
    }

    private static class ControlValidator {

        private final NinteichosaKekkaNyushuDiv div;

        public ControlValidator(NinteichosaKekkaNyushuDiv div) {
            this.div = div;
        }

        public IValidationMessages validate1() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの存在チェック)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.データが存在しない)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの行選択チェック1)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.対象行を選択)
                    .messages());
            return messages;
        }

        public IValidationMessages validate2() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの存在チェック)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.データが存在しない)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの行選択チェック1)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.対象行を選択)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの行選択チェック2)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.複数選択不可)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧選択行の登録処理事前チェック)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.理由付き登録不可)
                    .messages());
            return messages;
        }

        public IValidationMessages validate3() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの存在チェック)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.データが存在しない)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧データの行選択チェック1)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.対象行を選択)
                    .ifNot(NinteichosaKekkaNyushuSpec.認定調査票入手一覧選択行の完了処理事前チェック)
                    .thenAdd(NinteichosaKekkaNyushuValidationMessage.理由付き完了不可)
                    .messages());
            return messages;
        }

    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NinteichosaKekkaNyushuValidationMessage.データが存在しない, div.getNinteichosakekkainput().getDgNinteiTaskList())
                .add(NinteichosaKekkaNyushuValidationMessage.対象行を選択, div.getNinteichosakekkainput().getDgNinteiTaskList())
                .add(NinteichosaKekkaNyushuValidationMessage.複数選択不可, div.getNinteichosakekkainput().getDgNinteiTaskList())
                .add(NinteichosaKekkaNyushuValidationMessage.理由付き登録不可, div.getNinteichosakekkainput().getDgNinteiTaskList())
                .add(NinteichosaKekkaNyushuValidationMessage.理由付き完了不可, div.getNinteichosakekkainput().getDgNinteiTaskList())
                .build();
    }

    private static enum NinteichosaKekkaNyushuValidationMessage implements IValidationMessage {

        データが存在しない(UrErrorMessages.データが存在しない),
        対象行を選択(UrErrorMessages.対象行を選択),
        複数選択不可(DbeErrorMessages.複数選択不可, "認定調査票入手一覧"),
        理由付き登録不可(DbzErrorMessages.理由付き登録不可, "調査票入力済"),
        理由付き完了不可(DbzErrorMessages.理由付き完了不可, "調査票未入力"),
        存在しない(UrErrorMessages.存在しない, "モバイル取込対象データ"),
        ファイルが存在しない(UrErrorMessages.対象ファイルが存在しない, "調査取込用データ（モバイル）");

        private final Message message;

        private NinteichosaKekkaNyushuValidationMessage(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

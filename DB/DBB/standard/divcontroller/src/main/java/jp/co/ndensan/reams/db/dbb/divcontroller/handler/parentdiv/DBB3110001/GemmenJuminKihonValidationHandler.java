/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB3110001;

import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenjoho.GemmenJoho;
import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001.GemmenJuminKihonDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 介護保険料減免画面のバリデーションハンドラークラス。
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenJuminKihonValidationHandler {

    private final GemmenJuminKihonDiv div;
    private static final RString 出力対象チェックMESSAGE = new RString("作成帳票を");
    private static final RString 減免額MESSAGE = new RString("減免額");
    private static final RString 決定日MESSAGE = new RString("決定日");
    private static final RString 計算処理MESSAGE = new RString("計算処理");
    private static final RString 減免前MESSAGE = new RString("減免前の合計額を超えています。");

    /**
     * コンストラクタです。
     *
     * @param div 介護保険料減免画面Div
     */
    public GemmenJuminKihonValidationHandler(GemmenJuminKihonDiv div) {
        this.div = div;
    }

    /**
     * 「発行する」ボタンをクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 未指定のValidate() {
        IValidationMessages messages = new ControlValidator(div).validate未指定();
        return createDictionary未指定().check(messages);
    }

    private ValidationDictionary createDictionary未指定() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.未指定チェック,
                        div.getGemmenPrintinfo().getPrintInfo())
                .build();
    }

    /**
     * 「発行する」ボタンをクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 賦課情報の存在チェック() {
        IValidationMessages messages = new ControlValidator(div).validate賦課情報の存在();
        return createDictionary賦課情報の存在チェック().check(messages);
    }

    private ValidationDictionary createDictionary賦課情報の存在チェック() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.賦課情報の存在チェック,
                        div.getGemmenFukaRirekiAll())
                .build();
    }

    /**
     * 「保存する」ボタン押下場合 減免額 ≠ （普通徴収減免前　合計　－　普通徴収減免後　合計）+ （特別徴収減免前　合計　－　特別徴収減免後
     * 合計）の場合、エラーとする。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 減免額の整合性チェック() {
        IValidationMessages messages = new ControlValidator(div).validate減免額の整合性();
        return createDictionary減免額の整合性チェック().check(messages);
    }

    private ValidationDictionary createDictionary減免額の整合性チェック() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.減免額の整合性チェック,
                        div.getGemmenMain().getKiwarigaku().getKiwarigakuPanel1())
                .build();
    }

    /**
     * 「保存する」ボタン押下場合 減免額が入力されているとき、決定日が未入力の場合、エラーとする。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 決定日の必須入力チェック() {
        IValidationMessages messages = new ControlValidator(div).validate決定日の必須入力();
        return createDictionary決定日の必須入力チェック().check(messages);
    }

    private ValidationDictionary createDictionary決定日の必須入力チェック() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.決定日の必須入力チェック,
                        div.getGemmenMain().getKeteiinfo().getTxtKetteiYMD())
                .build();
    }

    /**
     * 「保存する」ボタン押下場合 決定日が入力されている and 決定区分=承認する のとき、減免額が未入力の場合、エラーとする。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 減免額の必須入力チェック() {
        IValidationMessages messages = new ControlValidator(div).validate減免額の必須入力();
        return createDictionary減免額の必須入力チェック().check(messages);
    }

    private ValidationDictionary createDictionary減免額の必須入力チェック() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.減免額の必須入力チェック,
                        div.getGemmenMain().getKiwarigaku().getTxtGemmengaku())
                .build();
    }

    /**
     * 「保存する」ボタン押下場合 減免額が入力されている and 「計算する」ボタンが押下されていない場合、エラーとする。
     *
     * @param 最新減免の情報 GemmenJoho
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 計算処理の未実行チェック(GemmenJoho 最新減免の情報) {
        IValidationMessages messages = new ControlValidator(div).validate計算処理の未実行(最新減免の情報);
        return createDictionary計算処理の未実行チェック().check(messages);
    }

    private ValidationDictionary createDictionary計算処理の未実行チェック() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.計算処理の未実行チェック,
                        div.getGemmenMain().getKiwarigaku().getBtnCalculate())
                .build();
    }

    /**
     * 「計算する」ボタン押下場合 画面.減免額 ＞　減免前情報_介護賦課.減免前介護保険料額（年額）の場合、エラーとする。
     *
     * @param 最新減免の情報 GemmenJoho
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 減免額の整合性チェック２(GemmenJoho 最新減免の情報) {
        IValidationMessages messages = new ControlValidator(div).validate減免額の整合性２(最新減免の情報);
        return createDictionary減免額の整合性チェック２().check(messages);
    }

    private ValidationDictionary createDictionary減免額の整合性チェック２() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.減免額の整合性チェック２,
                        div.getGemmenMain().getKiwarigaku().getTxtGemmengaku())
                .build();
    }

    /**
     * 「保存する」ボタン押下場合 状況が「決定済」 の時、決定日が未入力の場合、エラーとする。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 決定日の必須入力チェック２() {
        IValidationMessages messages = new ControlValidator(div).validate決定日の必須入力２();
        return createDictionary決定日の必須入力チェック２().check(messages);
    }

    private ValidationDictionary createDictionary決定日の必須入力チェック２() {
        return new ValidationDictionaryBuilder()
                .add(GemmenJuminKihonValidationHandler.GemmenJuminKihonValidationMessages.決定日の必須入力チェック２,
                        div.getGemmenMain().getKeteiinfo().getTxtKetteiYMD())
                .build();
    }

    private static class ControlValidator {

        private final GemmenJuminKihonDiv div;

        public ControlValidator(GemmenJuminKihonDiv div) {
            this.div = div;
        }

        /**
         * 「 実行ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate未指定() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.未指定)
                    .thenAdd(GemmenJuminKihonValidationMessages.未指定チェック)
                    .messages());
            return messages;
        }

        /**
         * 画面初期化場合、減免の情報_介護賦課が１件も存在しない時、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate賦課情報の存在() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.賦課情報の存在チェック)
                    .thenAdd(GemmenJuminKihonValidationMessages.賦課情報の存在チェック)
                    .messages());
            return messages;
        }

        /**
         * 「保存する」ボタン押下場合 減免額 ≠..の場合。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate減免額の整合性() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.減免額の整合性チェック)
                    .thenAdd(GemmenJuminKihonValidationMessages.減免額の整合性チェック)
                    .messages());
            return messages;
        }

        /**
         * 「保存する」ボタン押下場合 減免額が入力されているとき、決定日が未入力の場合、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate決定日の必須入力() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.決定日の必須入力チェック)
                    .thenAdd(GemmenJuminKihonValidationMessages.決定日の必須入力チェック)
                    .messages());
            return messages;
        }

        /**
         * 「保存する」ボタン押下場合 決定日が入力されている and 決定区分=承認する のとき、減免額が未入力の場合、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate減免額の必須入力() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.減免額の必須入力チェック)
                    .thenAdd(GemmenJuminKihonValidationMessages.減免額の必須入力チェック)
                    .messages());
            return messages;
        }

        /**
         * 「保存する」ボタン押下場合 減免額が入力されている and 「計算する」ボタンが押下されていない場合、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate計算処理の未実行(GemmenJoho 最新減免の情報) {
            Decimal 減免額 = div.getGemmenMain().getKiwarigaku().getTxtGemmengaku().getValue();
            boolean flag = 減免額 != null && !減免額.equals(最新減免の情報.get減免額());
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(flag ? GemmenJuminKihonSpec.賦課情報の存在チェック : GemmenJuminKihonSpec.計算処理の未実行チェック)
                    .thenAdd(GemmenJuminKihonValidationMessages.計算処理の未実行チェック)
                    .messages());
            return messages;
        }

        /**
         * 「計算する」ボタン押下場合 画面.減免額 ＞　減免前情報_介護賦課.減免前介護保険料額（年額）の場合、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate減免額の整合性２(GemmenJoho 最新減免の情報) {
            Decimal 減免額 = div.getGemmenMain().getKiwarigaku().getTxtGemmengaku().getValue();
            Decimal 減免前介護保険料額_年額 = 最新減免の情報.get減免前介護保険料_年額();
            boolean flag = (減免額 != null && 減免前介護保険料額_年額 == null)
                    || (減免額 != null && 減免前介護保険料額_年額 != null && 減免額.compareTo(減免前介護保険料額_年額) > 0);
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(flag ? GemmenJuminKihonSpec.賦課情報の存在チェック : GemmenJuminKihonSpec.計算処理の未実行チェック)
                    .thenAdd(GemmenJuminKihonValidationMessages.計算処理の未実行チェック)
                    .messages());
            return messages;
        }

        /**
         * 「保存する」ボタン押下場合 状況が「決定済」 の時、決定日が未入力の場合、エラーとする。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate決定日の必須入力２() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(GemmenJuminKihonSpec.決定日の必須入力チェック２)
                    .thenAdd(GemmenJuminKihonValidationMessages.決定日の必須入力チェック２)
                    .messages());
            return messages;
        }

    }

    private static enum GemmenJuminKihonValidationMessages implements IValidationMessage {

        未指定チェック(UrErrorMessages.未指定, 出力対象チェックMESSAGE.toString()),
        賦課情報の存在チェック(DbbErrorMessages.賦課情報なし),
        減免額の整合性チェック(DbbErrorMessages.減免額_合計不一致),
        決定日の必須入力チェック(DbzErrorMessages.複数必須項目相関チェックエラー, 減免額MESSAGE.toString(), 決定日MESSAGE.toString()),
        減免額の必須入力チェック(UrErrorMessages.必須項目_追加メッセージあり, 減免額MESSAGE.toString()),
        計算処理の未実行チェック(DbzErrorMessages.未実行, 計算処理MESSAGE.toString()),
        減免額の整合性チェック２(UrErrorMessages.入力値が不正_追加メッセージあり, 減免前MESSAGE.toString()),
        決定日の必須入力チェック２(UrErrorMessages.必須項目_追加メッセージあり, 決定日MESSAGE.toString());
        private final Message message;

        GemmenJuminKihonValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

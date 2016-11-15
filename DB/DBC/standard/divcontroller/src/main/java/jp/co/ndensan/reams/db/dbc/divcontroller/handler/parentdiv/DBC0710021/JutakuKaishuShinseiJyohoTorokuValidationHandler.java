/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 住宅改修費支給申請_申請情報登録のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiJyohoTorokuValidationHandler {

    private final JutakuKaishuShinseiJyohoTorokuDiv div;
    private final RString 画面モード;
    private final RString 住宅改修内容チェックエラーメッセージ;
    private final boolean is給付率;
    private static final RString 画面モード_取消 = new RString("取消モード");
    private static final RString 画面モード_削除 = new RString("削除モード");
    private static final RString メッセージ_1 = new RString("住宅改修データがありません。");
    private static final RString メッセージ_2 = new RString("着工日が同一年月を設定してください。");
    private static final RString メッセージ_3 = new RString("対象住宅住所が同じ住所を設定してください。");

    /**
     * コンストラクタです。
     *
     * @param 画面モード 画面モード
     * @param div 住宅改修費支給申請_申請情報登録div
     * @param 住宅改修内容チェックエラーメッセージ errMsg
     * @param is給付率 給付率
     */
    public JutakuKaishuShinseiJyohoTorokuValidationHandler(RString 画面モード,
            JutakuKaishuShinseiJyohoTorokuDiv div, RString 住宅改修内容チェックエラーメッセージ,
            boolean is給付率) {
        this.div = div;
        this.画面モード = 画面モード;
        this.住宅改修内容チェックエラーメッセージ = 住宅改修内容チェックエラーメッセージ;
        this.is給付率 = is給付率;
    }

    /**
     * コンストラクタです。
     *
     * @param div 住宅改修費支給申請_申請情報登録div
     */
    public JutakuKaishuShinseiJyohoTorokuValidationHandler(JutakuKaishuShinseiJyohoTorokuDiv div) {
        this.div = div;
        this.画面モード = null;
        this.住宅改修内容チェックエラーメッセージ = null;
        this.is給付率 = false;
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div, 画面モード, 住宅改修内容チェックエラーメッセージ, is給付率)
                .validate();
        return createDictionary().check(messages);
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate住宅改修内容() {
        IValidationMessages messages = new ControlValidator(div, 画面モード, 住宅改修内容チェックエラーメッセージ, is給付率)
                .validate住宅改修内容();
        return create住宅改修内容Dictionary().check(messages);
    }

    /**
     * 受給認定が無効チェック入力チェックを行います。
     *
     * @param pairs バリデーションコントロール
     * @param div JutakuKaishuShinseiJyohoTorokuDiv
     * @return バリデーション結果
     */
    public ValidationMessageControlPairs validate受給認定が無効チェック(ValidationMessageControlPairs pairs, JutakuKaishuShinseiJyohoTorokuDiv div) {

        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(JutakuKaishuShinseiJyohoTorokuSpec.受給認定が無効チェック)
                .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.受給認定が無効チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                JutakuKaishuShinseiJyohoTorokuValidationMessages.受給認定が無効チェック,
                div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD()).build().check(messages));
        return pairs;

    }

    /**
     * 領収日変更のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate領収日変更チェック() {
        IValidationMessages messages = new ControlValidator(div, 画面モード, 住宅改修内容チェックエラーメッセージ, is給付率)
                .validate領収日変更チェック();
        return create領収日変更チェックDictionary().check(messages);
    }

    /**
     * 申請日変更のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate申請日変更チェック() {
        IValidationMessages messages = new ControlValidator(div, 画面モード, 住宅改修内容チェックエラーメッセージ, is給付率)
                .validate申請日変更チェック();
        return create申請日変更チェックDictionary().check(messages);
    }

    private ValidationDictionary create住宅改修内容Dictionary() {
        ValidationDictionaryBuilder builder = new ValidationDictionaryBuilder()
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が未入力, div.getTxtTeikyoYM());
        if (is給付率) {
            builder = builder.add(JutakuKaishuShinseiJyohoTorokuValidationMessages.給付率が未入力,
                    div.getCommHeadPanel().getTxtKyufuritsu());
        }
        if (住宅改修内容チェックエラーメッセージ != null && !住宅改修内容チェックエラーメッセージ.isEmpty()) {
            if (メッセージ_1.equals(住宅改修内容チェックエラーメッセージ)) {
                builder = builder.add(JutakuKaishuShinseiJyohoTorokuValidationMessages.メッセージ_1);
            } else if (メッセージ_2.equals(住宅改修内容チェックエラーメッセージ)) {
                builder = builder.add(JutakuKaishuShinseiJyohoTorokuValidationMessages.メッセージ_2);
            } else if (メッセージ_3.equals(住宅改修内容チェックエラーメッセージ)) {
                builder = builder.add(JutakuKaishuShinseiJyohoTorokuValidationMessages.メッセージ_3);
            }
        }
        builder = builder.add(JutakuKaishuShinseiJyohoTorokuValidationMessages.サービス年月と不一致);
        builder = builder.add(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が申請日の年月と一致しない);
        return builder.build();
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が未入力, div.getTxtTeikyoYM())
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.住宅所有者が未入力,
                        div.getJutakuKaishuShinseiContents().getTxtJutakuOwner())
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.領収日が未入力,
                        div.getJutakuKaishuShinseiContents().getTxtRyoshuYMD())
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.申請日が未入力,
                        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getTxtShinseiYMD())
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.証明書が未入力,
                        div.getCommHeadPanel().getDdlSyomeisyo())
                .build();
    }

    private ValidationDictionary create領収日変更チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.サービス年月と不一致)
                .build();
    }

    private ValidationDictionary create申請日変更チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が申請日の年月と一致しない)
                .build();
    }

    private static class ControlValidator {

        private final JutakuKaishuShinseiJyohoTorokuDiv div;
        private final RString 画面モード;
        private final RString 住宅改修内容チェックエラーメッセージ;
        private final boolean is給付率;

        public ControlValidator(JutakuKaishuShinseiJyohoTorokuDiv div, RString 画面モード,
                RString 住宅改修内容チェックエラーメッセージ, boolean is給付率) {
            this.div = div;
            this.画面モード = 画面モード;
            this.住宅改修内容チェックエラーメッセージ = 住宅改修内容チェックエラーメッセージ;
            this.is給付率 = is給付率;
        }

        /**
         * 保存ボタンクリック時のバリデーションチェック
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            if (!画面モード_取消.equals(画面モード) && !画面モード_削除.equals(画面モード)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.提供着工年月が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が未入力)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.住宅所有者が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.住宅所有者が未入力)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.領収日が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.領収日が未入力)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.申請日が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.申請日が未入力)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.証明書が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.証明書が未入力)
                        .messages());
            }
            return messages;
        }

        /**
         * 保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate住宅改修内容() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.提供着工年月が入力)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が未入力)
                    .messages());
            if (is給付率) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.給付率が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.給付率が未入力)
                        .messages());
            }
            if (住宅改修内容チェックエラーメッセージ != null && !住宅改修内容チェックエラーメッセージ.isEmpty()) {
                if (メッセージ_1.equals(住宅改修内容チェックエラーメッセージ)) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.住宅改修内容一覧が妥当)
                            .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.メッセージ_1)
                            .messages());
                } else if (メッセージ_2.equals(住宅改修内容チェックエラーメッセージ)) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.住宅改修内容一覧が妥当)
                            .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.メッセージ_2)
                            .messages());
                } else if (メッセージ_3.equals(住宅改修内容チェックエラーメッセージ)) {
                    messages.add(ValidateChain.validateStart(div)
                            .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.住宅改修内容一覧が妥当)
                            .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.メッセージ_3)
                            .messages());
                }
            }
            if (!画面モード_取消.equals(画面モード) && !画面モード_削除.equals(画面モード)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.領収日変更)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.サービス年月と不一致)
                        .messages());
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.提供着工年月が申請日の年月と一致しない)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が申請日の年月と一致しない)
                        .messages());
            }
            return messages;
        }

        /**
         * 領収日変更のバリデーションチェック
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate領収日変更チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.領収日変更)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.サービス年月と不一致)
                    .messages());
            return messages;
        }

        /**
         * 申請日変更のバリデーションチェック
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate申請日変更チェック() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.提供着工年月が申請日の年月と一致しない)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が申請日の年月と一致しない)
                    .messages());
            return messages;
        }
    }

    private static enum JutakuKaishuShinseiJyohoTorokuValidationMessages implements IValidationMessage {

        提供着工年月が未入力(UrErrorMessages.必須, "サービス年月"),
        給付率が未入力(UrErrorMessages.必須, "給付率"),
        住宅所有者が未入力(UrErrorMessages.必須, "住宅所有者"),
        申請日が未入力(UrErrorMessages.必須, "申請日"),
        領収日が未入力(UrErrorMessages.必須, "領収日"),
        証明書が未入力(UrErrorMessages.必須, "証明書"),
        提供着工年月が申請日の年月と一致しない(DbcErrorMessages.年月と不一致, "申請日", "サービス年月"),
        サービス年月と不一致(DbcErrorMessages.サービス年月と不一致, "領収日"),
        メッセージ_1(DbcErrorMessages.住宅改修データなし),
        メッセージ_2(DbcErrorMessages.着工日不一致),
        受給認定が無効チェック(DbzErrorMessages.実行不可, "受給認定有効期間外", "入力"),
        メッセージ_3(DbcErrorMessages.対象住宅住所不一致);
        private final Message message;

        JutakuKaishuShinseiJyohoTorokuValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

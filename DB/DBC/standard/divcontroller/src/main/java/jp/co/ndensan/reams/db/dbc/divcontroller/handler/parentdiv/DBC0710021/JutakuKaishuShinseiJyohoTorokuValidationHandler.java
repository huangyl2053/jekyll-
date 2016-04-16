/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0710021;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710021.JutakuKaishuShinseiJyohoTorokuDiv;
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
 * 住宅改修費支給申請_申請情報登録のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-0992-120 yebangqiang
 */
public class JutakuKaishuShinseiJyohoTorokuValidationHandler {

    private final JutakuKaishuShinseiJyohoTorokuDiv div;
    private static RString 画面モード;
    private static final RString 画面モード_取消 = new RString("取消モード");

    /**
     * コンストラクタです。
     *
     * @param 画面モード 画面モード
     * @param div 住宅改修費支給申請_申請情報登録div
     */
    public JutakuKaishuShinseiJyohoTorokuValidationHandler(RString 画面モード,
            JutakuKaishuShinseiJyohoTorokuDiv div) {
        this.div = div;
        JutakuKaishuShinseiJyohoTorokuValidationHandler.画面モード = 画面モード;
    }

    /**
     * コンストラクタです。
     *
     * @param div 住宅改修費支給申請_申請情報登録div
     */
    public JutakuKaishuShinseiJyohoTorokuValidationHandler(JutakuKaishuShinseiJyohoTorokuDiv div) {
        this.div = div;
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    /**
     * 保存ボタンクリック時のバリデーションチェックです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate住宅改修内容() {
        IValidationMessages messages = new ControlValidator(div).validate住宅改修内容();
        return create住宅改修内容Dictionary().check(messages);
    }

    private ValidationDictionary create住宅改修内容Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が未入力, div.getTxtTeikyoYM())
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が申請日の年月と一致しない)
                .build();
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
                .add(JutakuKaishuShinseiJyohoTorokuValidationMessages.申請取消事由が未入力,
                        div.getJutakuKaishuShinseiContents().getShinseishaInfo().getDdlShinseiTorikesuJiyu())
                .build();
    }

    private static class ControlValidator {

        private final JutakuKaishuShinseiJyohoTorokuDiv div;

        public ControlValidator(JutakuKaishuShinseiJyohoTorokuDiv div) {
            this.div = div;
        }

        /**
         * 保存ボタンクリック時のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.提供着工年月が入力)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が未入力)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.住宅所有者が入力)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.住宅所有者が未入力)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.領収日が入力)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.領収日が未入力)
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.申請日が入力)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.申請日が未入力)
                    .messages());
            if (画面モード_取消.equals(画面モード)) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.申請取消事由が入力)
                        .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.申請取消事由が未入力)
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
                    .ifNot(JutakuKaishuShinseiJyohoTorokuSpec.提供着工年月が申請日の年月と一致しない)
                    .thenAdd(JutakuKaishuShinseiJyohoTorokuValidationMessages.提供着工年月が申請日の年月と一致しない)
                    .messages());
            return messages;
        }
    }

    private static enum JutakuKaishuShinseiJyohoTorokuValidationMessages implements IValidationMessage {

        提供着工年月が未入力(UrErrorMessages.必須, "提供（着工）年月"),
        住宅所有者が未入力(UrErrorMessages.必須, "住宅所有者"),
        申請日が未入力(UrErrorMessages.必須, "申請日"),
        申請取消事由が未入力(UrErrorMessages.必須, "申請取消事由"),
        領収日が未入力(UrErrorMessages.必須, "領収日"),
        提供着工年月が申請日の年月と一致しない(DbcErrorMessages.サービス年月と不一致);
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

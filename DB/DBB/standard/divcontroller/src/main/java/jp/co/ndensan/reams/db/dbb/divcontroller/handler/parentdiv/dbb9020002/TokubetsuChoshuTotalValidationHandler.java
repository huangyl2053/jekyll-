/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.dbb9020002;

import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020002.TokubetsuChoshuTotalDiv;
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
 * システム管理情報（特別徴収）のバリデーションハンドラークラスです。
 */
public class TokubetsuChoshuTotalValidationHandler {

    private final TokubetsuChoshuTotalDiv div;
    private static final RString 平準化６_８月分エラーメッセージ
            = new RString("平準化（６・８月分）の「計算方法」と、「減額時平準化」「増額時平準化」の整合性エラー");
    private static final RString 平準化８月分計算エラーメッセージ
            = new RString("平準化（８月分）の「計算方法」と、「減額時平準化」「増額時平準化」の整合性エラー");

    /**
     * コンストラクタです。
     *
     * @param div システム管理情報（特別徴収）Div
     */
    public TokubetsuChoshuTotalValidationHandler(TokubetsuChoshuTotalDiv div) {
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
                .add(TokubetsuChoshuTotalValidationMessages.平準化６_８月分計算, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho()
                        .getRadGengakuHeijunKa(), div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                        .getHasuHeijunkaJoho().getHeijunka6GatsuKeisanHoho().getRadZogakuHeijunKa())
                .add(TokubetsuChoshuTotalValidationMessages.平準化８月分計算, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho()
                        .getRad8GatsuGengakuHeijunKa(), div.getTokubetsuChoshu().getTabTokucho().getTplKibetsuHasuJoho()
                        .getHasuHeijunkaJoho().getHeijunka8GatsuKeisanHoho().getRad8GatsuZogakuHeijunKa())
                .build();
    }

    private static class ControlValidator {

        private final TokubetsuChoshuTotalDiv div;

        public ControlValidator(TokubetsuChoshuTotalDiv div) {
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
                    .ifNot(TokubetsuChoshuTotalSpec.平準化６_８月分計算)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.平準化６_８月分計算)
                    .ifNot(TokubetsuChoshuTotalSpec.平準化８月分計算)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.平準化８月分計算)
                    .messages());
            return messages;
        }
    }

    private static enum TokubetsuChoshuTotalValidationMessages implements IValidationMessage {

        平準化６_８月分計算(UrErrorMessages.入力値が不正_追加メッセージあり, 平準化６_８月分エラーメッセージ.toString()),
        平準化８月分計算(UrErrorMessages.入力値が不正_追加メッセージあり, 平準化８月分計算エラーメッセージ.toString());
        private final Message message;

        TokubetsuChoshuTotalValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB9020002;

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
 *
 * @reamsid_L DBB-1770-040 cuilin
 */
public class TokubetsuChoshuTotalValidationHandler {

    private final TokubetsuChoshuTotalDiv div;
    private static final RString 平準化６_８月分エラーメッセージ
            = new RString("平準化（６・８月分）の「計算方法」と、「減額時平準化」「増額時平準化」の整合性エラー");
    private static final RString 平準化８月分計算エラーメッセージ
            = new RString("平準化（８月分）の「計算方法」と、「減額時平準化」「増額時平準化」の整合性エラー");
    private static final RString 選択数エラーメッセージ1 = new RString("選択をONにできる数");
    private static final RString 選択数エラーメッセージ2 = new RString("6以下");
    private static final RString 納期限エラーメッセージ1 = new RString("特別徴収期別情報の01月の納期限");
    private static final RString 納期限エラーメッセージ2 = new RString("特別徴収期別情報の02月の納期限");
    private static final RString 納期限エラーメッセージ3 = new RString("特別徴収期別情報の03月の納期限");
    private static final RString 納期限エラーメッセージ4 = new RString("特別徴収期別情報の04月の納期限");
    private static final RString 納期限エラーメッセージ5 = new RString("特別徴収期別情報の05月の納期限");
    private static final RString 納期限エラーメッセージ6 = new RString("特別徴収期別情報の06月の納期限");
    private static final RString 納期限エラーメッセージ7 = new RString("特別徴収期別情報の07月の納期限");
    private static final RString 納期限エラーメッセージ8 = new RString("特別徴収期別情報の08月の納期限");
    private static final RString 納期限エラーメッセージ9 = new RString("特別徴収期別情報の09月の納期限");
    private static final RString 納期限エラーメッセージ10 = new RString("特別徴収期別情報の10月の納期限");
    private static final RString 納期限エラーメッセージ11 = new RString("特別徴収期別情報の11月の納期限");
    private static final RString 納期限エラーメッセージ12 = new RString("特別徴収期別情報の12月の納期限");

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
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_04月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_05月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_06月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_07月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_08月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_09月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_10月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_11月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_12月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_01月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_02月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_03月, div.getTokubetsuChoshu()
                        .getTabTokucho().getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
                .add(TokubetsuChoshuTotalValidationMessages.選択数のチェック, div.getTokubetsuChoshu().getTabTokucho()
                        .getTplKibetsuHasuJoho().getKibetsuJohoHasu().getDgKibetsuJoho())
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
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_04月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_04月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_05月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_05月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_06月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_06月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_07月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_07月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_08月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_08月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_09月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_09月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_10月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_10月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_11月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_11月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_12月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_12月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_01月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_01月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_02月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_02月)
                    .ifNot(TokubetsuChoshuTotalSpec.納期限_03月)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.納期限の必須チェック_03月)
                    .ifNot(TokubetsuChoshuTotalSpec.選択数)
                    .thenAdd(TokubetsuChoshuTotalValidationMessages.選択数のチェック)
                    .messages());
            return messages;
        }
    }

    private static enum TokubetsuChoshuTotalValidationMessages implements IValidationMessage {

        平準化６_８月分計算(UrErrorMessages.入力値が不正_追加メッセージあり, 平準化６_８月分エラーメッセージ.toString()),
        平準化８月分計算(UrErrorMessages.入力値が不正_追加メッセージあり, 平準化８月分計算エラーメッセージ.toString()),
        納期限の必須チェック_01月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ1.toString()),
        納期限の必須チェック_02月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ2.toString()),
        納期限の必須チェック_03月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ3.toString()),
        納期限の必須チェック_04月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ4.toString()),
        納期限の必須チェック_05月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ5.toString()),
        納期限の必須チェック_06月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ6.toString()),
        納期限の必須チェック_07月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ7.toString()),
        納期限の必須チェック_08月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ8.toString()),
        納期限の必須チェック_09月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ9.toString()),
        納期限の必須チェック_10月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ10.toString()),
        納期限の必須チェック_11月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ11.toString()),
        納期限の必須チェック_12月(UrErrorMessages.入力値が不正_追加メッセージあり, 納期限エラーメッセージ12.toString()),
        選択数のチェック(UrErrorMessages.項目に対する制約, 選択数エラーメッセージ1.toString(), 選択数エラーメッセージ2.toString());
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

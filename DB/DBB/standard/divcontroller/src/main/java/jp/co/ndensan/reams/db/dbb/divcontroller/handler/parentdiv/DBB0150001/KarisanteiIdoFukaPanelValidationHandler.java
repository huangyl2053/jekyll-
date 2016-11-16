/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0150001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001.KarisanteiIdoFukaPanelDiv;
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
 * 画面設計_DBBGM36001_仮算定異動賦課のバリデーションハンドラークラス。
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaPanelValidationHandler {

    private final KarisanteiIdoFukaPanelDiv div;
    private static final RString 仮算定額変更通知書 = new RString("仮算定額変更通知書の発行日");
    private static final RString 納入通知書 = new RString("納入通知書の発行日");
    private static final RString 対象者 = new RString("納入通知書の対象者");
    private static final RString 特徴開始通知書 = new RString("特徴開始通知書（仮算定）の発行日");

    /**
     * コンストラクタです。
     *
     * @param div 仮算定異動賦課Div
     */
    public KarisanteiIdoFukaPanelValidationHandler(KarisanteiIdoFukaPanelDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェック。
     *
     * @param 仮算定額変更通知書 boolean
     * @param 保険料納入通知書_仮算定 boolean
     * @param 特徴開始通知書_仮算定 boolean
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 必須チェックValidate(boolean 仮算定額変更通知書,
            boolean 保険料納入通知書_仮算定,
            boolean 特徴開始通知書_仮算定) {
        IValidationMessages messages = new ControlValidator(div).validate(仮算定額変更通知書,
                保険料納入通知書_仮算定,
                特徴開始通知書_仮算定);
        return createDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KarisanteiIdoFukaHandlerValidationMessages.仮算定額変更通知書の発行日入力チェック,
                        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtKariHenkoTsuchiHakkoYMD())
                .add(KarisanteiIdoFukaHandlerValidationMessages.納入通知書の発行日入力チェック,
                        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuHakkoYMD())
                .add(KarisanteiIdoFukaHandlerValidationMessages.納入通知書の対象者の選択チェック,
                        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getChkNotsuTaishosha())
                .add(KarisanteiIdoFukaHandlerValidationMessages.特徴開始通知書仮算定の発行日入力チェック,
                        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD())
                .add(KarisanteiIdoFukaHandlerValidationMessages.処理対象と出力期の一致チェック,
                        div.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getDdlNotsuShuturyokuki())
                .build();
    }

    private static class ControlValidator {

        private final KarisanteiIdoFukaPanelDiv div;

        public ControlValidator(KarisanteiIdoFukaPanelDiv div) {
            this.div = div;
        }

        /**
         * 「 実行ボタンクリック時のバリデーションチェック。
         *
         * @param 仮算定額変更通知書 boolean
         * @param 保険料納入通知書_仮算定 boolean
         * @param 特徴開始通知書_仮算定 boolean
         * @return バリデーション突合結果
         */
        public IValidationMessages validate(boolean 仮算定額変更通知書,
                boolean 保険料納入通知書_仮算定,
                boolean 特徴開始通知書_仮算定) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            if (仮算定額変更通知書) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(KarisanteiIdoFukaPanelSpec.仮算定額変更通知書の発行日)
                        .thenAdd(KarisanteiIdoFukaHandlerValidationMessages.仮算定額変更通知書の発行日入力チェック)
                        .messages());
            }
            if (保険料納入通知書_仮算定) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(KarisanteiIdoFukaPanelSpec.納入通知書_発行日)
                        .thenAdd(KarisanteiIdoFukaHandlerValidationMessages.納入通知書の発行日入力チェック)
                        .ifNot(KarisanteiIdoFukaPanelSpec.納入通知書_対象者)
                        .thenAdd(KarisanteiIdoFukaHandlerValidationMessages.納入通知書の対象者の選択チェック)
                        .ifNot(KarisanteiIdoFukaPanelSpec.処理対象と出力期の一致)
                        .thenAdd(KarisanteiIdoFukaHandlerValidationMessages.処理対象と出力期の一致チェック)
                        .messages());
            }
            if (特徴開始通知書_仮算定) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(KarisanteiIdoFukaPanelSpec.特徴開始通知書_発行日)
                        .thenAdd(KarisanteiIdoFukaHandlerValidationMessages.特徴開始通知書仮算定の発行日入力チェック)
                        .messages());
            }
            return messages;
        }
    }

    private static enum KarisanteiIdoFukaHandlerValidationMessages implements IValidationMessage {

        仮算定額変更通知書の発行日入力チェック(UrErrorMessages.必須, 仮算定額変更通知書.toString()),
        納入通知書の発行日入力チェック(UrErrorMessages.必須, 納入通知書.toString()),
        納入通知書の対象者の選択チェック(UrErrorMessages.必須, 対象者.toString()),
        特徴開始通知書仮算定の発行日入力チェック(UrErrorMessages.必須, 特徴開始通知書.toString()),
        処理対象と出力期の一致チェック(DbbErrorMessages.賦課処理対象月と通知書出力月の不整合);

        private final Message message;

        KarisanteiIdoFukaHandlerValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

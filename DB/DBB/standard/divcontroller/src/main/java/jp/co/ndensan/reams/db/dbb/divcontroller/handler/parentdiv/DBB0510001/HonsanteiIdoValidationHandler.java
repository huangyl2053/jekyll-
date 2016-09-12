/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0510001;

import jp.co.ndensan.reams.db.dbb.definition.message.DbbErrorMessages;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001.HonsanteiIdoDiv;
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
 * 画面設計_DBBGM44001_本算定異動（現年度）のバリデーションハンドラークラス。
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonsanteiIdoValidationHandler {

    private final HonsanteiIdoDiv div;
    private static final RString 特徴開始通知書の発行日 = new RString("特徴開始通知書の発行日");
    private static final RString 通知書チェックボックス = new RString("通知書チェックボックス");
    private static final RString 決定通知書の発行日 = new RString("決定通知書の発行日");
    private static final RString 変更通知書の発行日 = new RString("変更通知書の発行日");
    private static final RString 変更通知書の対象者 = new RString("変更通知書の対象者");
    private static final RString 納入通知書の発行日 = new RString("納入通知書の発行日");
    private static final RString 納入通知書の対象者 = new RString("納入通知書の対象者");
    private static final RString 処理対象 = new RString("処理対象");

    /**
     * コンストラクタです。
     *
     * @param div 本算定異動_現年度Div
     */
    public HonsanteiIdoValidationHandler(HonsanteiIdoDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 処理対象と出力期のValidate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return createDictionary().check(messages);
    }

    /**
     * 実行ボタンクリック時必須チェックのバリデーションチェック。
     *
     * @param 特徴開始通知書Flag boolean
     * @param 決定変更通知書Flag boolean
     * @param 納入通知書Flag boolean
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 必須チェックのValidate(boolean 特徴開始通知書Flag,
            boolean 決定変更通知書Flag,
            boolean 納入通知書Flag) {
        IValidationMessages messages = new ControlValidator(div).必須チェックのValidate(特徴開始通知書Flag,
                決定変更通知書Flag,
                納入通知書Flag);
        return create必須チェックDictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(HonsanteiIdoValidationMessages.処理対象と出力期の一致チェック,
                        div.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getDdlNotsuShuturyokuki())
                .build();
    }

    private ValidationDictionary create必須チェックDictionary() {
        return new ValidationDictionaryBuilder()
                .add(HonsanteiIdoValidationMessages.処理対象チェック,
                        div.getHonsanteiIdoShoriNaiyo().getDdlShoritsuki())
                .add(HonsanteiIdoValidationMessages.特徴開始通知書の発行日チェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getTxtTokuchoKaishiTsuchishoHakkoYMD())
                .add(HonsanteiIdoValidationMessages.通知書チェックボックスチェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getChkKetteiTsuchi(),
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchi())
                .add(HonsanteiIdoValidationMessages.決定通知書の発行日チェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD())
                .add(HonsanteiIdoValidationMessages.変更通知書の対象者チェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha())
                .add(HonsanteiIdoValidationMessages.変更通知書の発行日チェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD())
                .add(HonsanteiIdoValidationMessages.納入通知書の対象者チェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getChkNotsuTaishoSha())
                .add(HonsanteiIdoValidationMessages.納入通知書の発行日チェック,
                        div.getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD())
                .build();
    }

    private static class ControlValidator {

        private final HonsanteiIdoDiv div;

        public ControlValidator(HonsanteiIdoDiv div) {
            this.div = div;
        }

        /**
         * 「 実行ボタンクリック時のバリデーションチェック。
         *
         * @param 特徴開始通知書Flag boolean
         * @param 決定変更通知書Flag boolean
         * @param 納入通知書Flag boolean
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(HonsanteiIdoSpec.処理対象と出力期の一致)
                    .thenAdd(HonsanteiIdoValidationMessages.処理対象と出力期の一致チェック)
                    .messages());
            return messages;
        }

        /**
         * 「 実行ボタンクリック時必須チェックのバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 必須チェックのValidate(boolean 特徴開始通知書Flag,
                boolean 決定変更通知書Flag,
                boolean 納入通知書Flag) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(HonsanteiIdoSpec.処理対象)
                    .thenAdd(HonsanteiIdoValidationMessages.処理対象チェック)
                    .messages());
            if (特徴開始通知書Flag) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(HonsanteiIdoSpec.特徴開始通知書の発行日)
                        .thenAdd(HonsanteiIdoValidationMessages.特徴開始通知書の発行日チェック)
                        .messages());
            }
            if (決定変更通知書Flag) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(HonsanteiIdoSpec.通知書チェックボックス)
                        .thenAdd(HonsanteiIdoValidationMessages.通知書チェックボックスチェック)
                        .ifNot(HonsanteiIdoSpec.決定通知書の発行日)
                        .thenAdd(HonsanteiIdoValidationMessages.決定通知書の発行日チェック)
                        .ifNot(HonsanteiIdoSpec.変更通知書の対象者)
                        .thenAdd(HonsanteiIdoValidationMessages.変更通知書の対象者チェック)
                        .ifNot(HonsanteiIdoSpec.変更通知書の発行日)
                        .thenAdd(HonsanteiIdoValidationMessages.変更通知書の発行日チェック)
                        .messages());
            }
            if (納入通知書Flag) {
                messages.add(ValidateChain.validateStart(div)
                        .ifNot(HonsanteiIdoSpec.納入通知書の対象者)
                        .thenAdd(HonsanteiIdoValidationMessages.納入通知書の対象者チェック)
                        .ifNot(HonsanteiIdoSpec.納入通知書の発行日)
                        .thenAdd(HonsanteiIdoValidationMessages.納入通知書の発行日チェック)
                        .messages());
            }
            return messages;
        }
    }

    private static enum HonsanteiIdoValidationMessages implements IValidationMessage {

        処理対象と出力期の一致チェック(DbbErrorMessages.賦課処理対象月と通知書出力月の不整合),
        特徴開始通知書の発行日チェック(UrErrorMessages.必須, 特徴開始通知書の発行日.toString()),
        通知書チェックボックスチェック(UrErrorMessages.必須, 通知書チェックボックス.toString()),
        決定通知書の発行日チェック(UrErrorMessages.必須, 決定通知書の発行日.toString()),
        変更通知書の対象者チェック(UrErrorMessages.必須, 変更通知書の対象者.toString()),
        変更通知書の発行日チェック(UrErrorMessages.必須, 変更通知書の発行日.toString()),
        納入通知書の対象者チェック(UrErrorMessages.必須, 納入通知書の対象者.toString()),
        納入通知書の発行日チェック(UrErrorMessages.必須, 納入通知書の発行日.toString()),
        処理対象チェック(UrErrorMessages.必須, 処理対象.toString());

        private final Message message;

        HonsanteiIdoValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

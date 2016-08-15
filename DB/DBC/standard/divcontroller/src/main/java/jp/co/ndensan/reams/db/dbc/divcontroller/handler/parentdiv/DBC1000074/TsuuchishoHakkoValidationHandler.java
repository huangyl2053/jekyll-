/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1000074;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000074.TsuuchishoHakkoDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 基準収入額決定通知書発行画面のバリデーションハンドラークラスです。
 *
 * @reamsid_L DBC-4610-010 qinzhen
 */
public class TsuuchishoHakkoValidationHandler {

    private final TsuuchishoHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div TsuuchishoHakkoDiv
     */
    public TsuuchishoHakkoValidationHandler(TsuuchishoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 実行ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 申請年月日チェックValidate() {
        RDate 申請年月日_開始日 = div.getTxtShinseiYMD().getFromValue();
        RDate 申請年月日_終了日 = div.getTxtShinseiYMD().getToValue();
        IValidationMessages messages = new ControlValidator(div).申請年月日チェックValidate(申請年月日_終了日, 申請年月日_開始日);
        return 申請年月日Dictionary(申請年月日_終了日, 申請年月日_開始日).check(messages);
    }

    /**
     * 実行ボタンクリック時のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 決定年月日チェックValidate() {
        RDate 決定年月日_開始日 = div.getTxtKetteiYMD().getFromValue();
        RDate 決定年月日_終了日 = div.getTxtKetteiYMD().getToValue();
        IValidationMessages messages = new ControlValidator(div).決定年月日チェックValidate(決定年月日_終了日, 決定年月日_開始日);
        return 決定年月日Dictionary(決定年月日_終了日, 決定年月日_開始日).check(messages);
    }

    private ValidationDictionary 申請年月日Dictionary(RDate 申請年月日_終了日, RDate 申請年月日_開始日) {
        return new ValidationDictionaryBuilder()
                .add(new TsuuchishoHakkoMessages(
                                UrErrorMessages.期間が不正_追加メッセージあり１,
                                申請年月日_終了日.wareki().toDateString().toString(),
                                申請年月日_開始日.wareki().toDateString().toString()),
                        div.getShinseiKetteiYMD().getTxtShinseiYMD()).build();
    }

    private ValidationDictionary 決定年月日Dictionary(RDate 決定年月日_終了日, RDate 決定年月日_開始日) {
        return new ValidationDictionaryBuilder()
                .add(new TsuuchishoHakkoMessages(
                                UrErrorMessages.期間が不正_追加メッセージあり１,
                                決定年月日_終了日.wareki().toDateString().toString(),
                                決定年月日_開始日.wareki().toDateString().toString()),
                        div.getShinseiKetteiYMD().getTxtKetteiYMD()).build();
    }

    private static class ControlValidator {

        private final TsuuchishoHakkoDiv div;

        public ControlValidator(TsuuchishoHakkoDiv div) {
            this.div = div;
        }

        public IValidationMessages 申請年月日チェックValidate(RDate 申請年月日_終了日, RDate 申請年月日_開始日) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TsuuchishoHakkoSpec.申請年月日)
                    .thenAdd(new TsuuchishoHakkoMessages(
                                    UrErrorMessages.期間が不正_追加メッセージあり１,
                                    申請年月日_終了日.wareki().toDateString().toString(),
                                    申請年月日_開始日.wareki().toDateString().toString()))
                    .messages());
            return messages;
        }

        public IValidationMessages 決定年月日チェックValidate(RDate 決定年月日_終了日, RDate 決定年月日_開始日) {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(TsuuchishoHakkoSpec.決定年月日)
                    .thenAdd(new TsuuchishoHakkoMessages(
                                    UrErrorMessages.期間が不正_追加メッセージあり１,
                                    決定年月日_終了日.wareki().toDateString().toString(),
                                    決定年月日_開始日.wareki().toDateString().toString()))
                    .messages());
            return messages;
        }
    }

    private static class TsuuchishoHakkoMessages implements IValidationMessage {

        private final Message message;

        TsuuchishoHakkoMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

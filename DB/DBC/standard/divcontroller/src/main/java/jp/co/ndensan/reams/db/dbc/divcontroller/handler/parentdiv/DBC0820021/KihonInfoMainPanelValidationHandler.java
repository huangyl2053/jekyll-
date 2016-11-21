/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0820021;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcWarningMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820021.KihonInfoMainPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrWarningMessages;
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
 * 償還払支給申請_サービス提供証明書_基本情報のバリデーションハンドラークラス。
 *
 * @reamsid_L DBC-1030-020 wangkanglei
 */
public class KihonInfoMainPanelValidationHandler {

    private final KihonInfoMainPanelDiv div;
    private static final RString 入所年月日 = new RString("入所年月日");
    private static final RString 基本情報_STR = new RString("基本情報");
    private static final RString 入所院実日数_STR = new RString("入所（院）実日数");
    private static final RString 入所院前の状況_STR = new RString("入所（院）前の状況");

    /**
     * コンストラクタです。
     *
     * @param div 仮算定異動賦課Div
     */
    public KihonInfoMainPanelValidationHandler(KihonInfoMainPanelDiv div) {
        this.div = div;
    }

    /**
     * 入所年月日のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 必須チェックValidate() {
        IValidationMessages messages = new ControlValidator(div).必須チェックValidate();
        return createDictionary().check(messages);
    }

    /**
     * 入所（院）実日数のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 入所院実日数の必須チェックValidate() {
        IValidationMessages messages = new ControlValidator(div).入所院実日数の必須チェックValidate();
        return 入所院実日数Dictionary().check(messages);
    }

    /**
     * 入所（院）前の状況のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 入所院前の状況の必須チェックValidate() {
        IValidationMessages messages = new ControlValidator(div).入所院前の状況の必須チェックValidate();
        return 入所院前の状況Dictionary().check(messages);
    }

    /**
     * 入所と退所間の日数チェック
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor入所と退所間の日数チェック(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KihonInfoMainPanelSpec.入所と退所間の日数チェック)
                .thenAdd(KihonInfoMainPanelValidationMessages.入所と退所間の日数チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                KihonInfoMainPanelValidationMessages.入所と退所間の日数チェック,
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD(),
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtTaishoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 入所日と退所日の期間日数チェック
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor入所日と退所日の期間日数チェック(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(KihonInfoMainPanelSpec.入所日と退所日の期間日数チェック)
                .thenAdd(KihonInfoMainPanelValidationMessages.入所日と退所日の期間日数チェック).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(
                KihonInfoMainPanelValidationMessages.入所日と退所日の期間日数チェック,
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu(),
                div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtGaigakuNissu()).build().check(messages));
        return pairs;
    }

    /**
     * 明細番号のバリデーションチェック。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages messages = new ControlValidator(div).validate();
        return 明細番号Dictionary().check(messages);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KihonInfoMainPanelValidationMessages.入所年月日必須チェック,
                        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoYMD()).build();
    }

    private ValidationDictionary 入所院実日数Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KihonInfoMainPanelValidationMessages.入所院実日数必須チェック,
                        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getTxtNyushoJitsuNissu()).build();
    }

    private ValidationDictionary 入所院前の状況Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KihonInfoMainPanelValidationMessages.入所院前の状況必須チェック,
                        div.getPanelKihon().getPanelShisetuNyutaisyoInfo().getDdlNyushoMaeState()).build();
    }

    private ValidationDictionary 明細番号Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KihonInfoMainPanelValidationMessages.明細番号チェック,
                        div.getPanelTwo().getTxtMeisaiBango()).build();
    }

    private static class ControlValidator {

        private final KihonInfoMainPanelDiv div;

        public ControlValidator(KihonInfoMainPanelDiv div) {
            this.div = div;
        }

        /**
         * 入所年月日のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 必須チェックValidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KihonInfoMainPanelSpec.入所年月日)
                    .thenAdd(KihonInfoMainPanelValidationMessages.入所年月日必須チェック)
                    .messages());
            return messages;
        }

        /**
         * 入所（院）実日数のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 入所院実日数の必須チェックValidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KihonInfoMainPanelSpec.入所院実日数)
                    .thenAdd(KihonInfoMainPanelValidationMessages.入所院実日数必須チェック)
                    .messages());
            return messages;
        }

        /**
         * 入所（院）前の状況のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 入所院前の状況の必須チェックValidate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KihonInfoMainPanelSpec.入所院前の状況)
                    .thenAdd(KihonInfoMainPanelValidationMessages.入所院前の状況必須チェック)
                    .messages());
            return messages;
        }

        /**
         * 明細番号のバリデーションチェック。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KihonInfoMainPanelSpec.明細番号)
                    .thenAdd(KihonInfoMainPanelValidationMessages.明細番号チェック)
                    .messages());
            return messages;
        }
    }

    private static enum KihonInfoMainPanelValidationMessages implements IValidationMessage {

        入所年月日必須チェック(UrErrorMessages.必須項目_追加メッセージあり, 入所年月日.toString()),
        入所院実日数必須チェック(UrErrorMessages.必須項目_追加メッセージあり, 入所院実日数_STR.toString()),
        入所院前の状況必須チェック(UrErrorMessages.必須項目_追加メッセージあり, 入所院前の状況_STR.toString()),
        明細番号チェック(UrErrorMessages.対象データなし_追加メッセージあり, 基本情報_STR.toString()),
        入所と退所間の日数チェック(DbcWarningMessages.日数３０日超過, "入所年月日", "退所年月日"),
        入所日と退所日の期間日数チェック(UrWarningMessages.相違, "入所(院)実日数＋外泊日数", "入所(院)日・退所(院)日の間に収まる日数");

        private final Message message;

        KihonInfoMainPanelValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

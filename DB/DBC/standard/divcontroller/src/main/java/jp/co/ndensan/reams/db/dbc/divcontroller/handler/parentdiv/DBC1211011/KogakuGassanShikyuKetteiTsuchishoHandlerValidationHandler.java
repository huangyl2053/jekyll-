/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1211011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1211011.KogakuGassanShikyuKetteiTsuchishoDiv;
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
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 画面設計_DBCMN63004_高額合算支給決定通知書（一括）のクラスです。
 *
 * @reamsid_L DBC-2300-010 wangxingpeng
 */
public class KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler {

    private final KogakuGassanShikyuKetteiTsuchishoDiv div;
    private static final RString 受取年月チェック = new RString("受取年月");
    private static final RString 申請終了年月日チェック = new RString("申請終了年月日");
    private static final RString 申請開始年月日チェック = new RString("申請開始年月日");
    private static final RString 作成終了年月日チェック = new RString("作成終了年月日");
    private static final RString 作成開始年月日チェック = new RString("作成開始年月日");
    private static final RString 決定予定日_STR = new RString("決定年月日（更新用)");

    /**
     * コンストラクタです。
     *
     * @param div KogakuGassanShikyuKetteiDiv
     */
    public KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler(KogakuGassanShikyuKetteiTsuchishoDiv div) {
        this.div = div;
    }

    /**
     * createInstance
     *
     * @return KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler
     */
    public static KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler createInstance() {
        return InstanceProvider.create(KogakuGassanShikyuKetteiTsuchishoHandlerValidationHandler.class);
    }

    /**
     * 受取年月validateのメソッドです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 受取年月validate() {
        IValidationMessages messages = new ControlValidator(div).受取年月validate();
        return 受取年月Dictionary().check(messages);
    }

    /**
     * 申請年月validateのメソッドです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 申請年月validate() {
        IValidationMessages messages = new ControlValidator(div).申請年月validate();
        return 申請年月Dictionary().check(messages);
    }

    /**
     * 作成年月validateのメソッドです。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 作成年月validate() {
        IValidationMessages messages = new ControlValidator(div).作成年月validate();
        return 作成年月Dictionary().check(messages);
    }

    /**
     * 決定予定日validate。
     *
     * @return バリデーション突合結果
     */
    public ValidationMessageControlPairs 決定予定日validate() {
        IValidationMessages messages = new ControlValidator(div).決定予定日validate();
        return 決定予定日Dictionary().check(messages);
    }

    private ValidationDictionary 受取年月Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuKetteiValidationMessages.受取年月,
                        div.getTxtUketoriYM()).build();
    }

    private ValidationDictionary 申請年月Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuKetteiValidationMessages.申請終了年月日,
                        div.getTxtShinseiYMD())
                .add(KogakuGassanShikyuKetteiValidationMessages.申請開始年月日_申請終了年月日,
                        div.getTxtShinseiYMD()).build();
    }

    private ValidationDictionary 作成年月Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuKetteiValidationMessages.作成終了年月日,
                        div.getTxtKetteiYMD())
                .add(KogakuGassanShikyuKetteiValidationMessages.作成開始年月日_作成終了年月日,
                        div.getTxtKetteiYMD()).build();
    }

    private ValidationDictionary 決定予定日Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuGassanShikyuKetteiValidationMessages.決定予定日,
                        div.getTxtKetteiymd()).build();
    }

    private static class ControlValidator {

        private final KogakuGassanShikyuKetteiTsuchishoDiv div;

        /**
         * コンストラクタです。
         *
         * @param div KogakuGassanShikyuKetteiTsuchishoDiv
         */
        public ControlValidator(KogakuGassanShikyuKetteiTsuchishoDiv div) {
            this.div = div;
        }

        /**
         * 受取年月validateのメソッドです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 受取年月validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiTsuchishoHandlerSpec.受取年月チェック)
                    .thenAdd(KogakuGassanShikyuKetteiValidationMessages.受取年月)
                    .messages());
            return messages;
        }

        /**
         * 申請年月validateのメソッドです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 申請年月validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiTsuchishoHandlerSpec.申請終了年月日チェック)
                    .thenAdd(KogakuGassanShikyuKetteiValidationMessages.申請終了年月日)
                    .ifNot(KogakuGassanShikyuKetteiTsuchishoHandlerSpec.申請開始年月日_申請終了年月日チェック)
                    .thenAdd(KogakuGassanShikyuKetteiValidationMessages.申請開始年月日_申請終了年月日)
                    .messages());
            return messages;
        }

        /**
         * 作成年月validateのメソッドです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 作成年月validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiTsuchishoHandlerSpec.作成終了年月日チェック)
                    .thenAdd(KogakuGassanShikyuKetteiValidationMessages.作成終了年月日)
                    .ifNot(KogakuGassanShikyuKetteiTsuchishoHandlerSpec.作成開始年月日_作成終了年月日チェック)
                    .thenAdd(KogakuGassanShikyuKetteiValidationMessages.作成開始年月日_作成終了年月日)
                    .messages());
            return messages;
        }

        /**
         * 決定予定日validateのメソッドです。
         *
         * @return バリデーション突合結果
         */
        public IValidationMessages 決定予定日validate() {
            IValidationMessages messages = ValidationMessagesFactory.createInstance();
            messages.add(ValidateChain.validateStart(div)
                    .ifNot(KogakuGassanShikyuKetteiTsuchishoHandlerSpec.決定予定日)
                    .thenAdd(KogakuGassanShikyuKetteiValidationMessages.決定予定日)
                    .messages());
            return messages;
        }
    }

    private static enum KogakuGassanShikyuKetteiValidationMessages implements IValidationMessage {

        受取年月(UrErrorMessages.必須項目_追加メッセージあり, 受取年月チェック.toString()),
        申請終了年月日(UrErrorMessages.必須項目_追加メッセージあり, 申請終了年月日チェック.toString()),
        申請開始年月日_申請終了年月日(UrErrorMessages.期間が不正_追加メッセージあり１, 申請開始年月日チェック.toString(), 申請終了年月日チェック.toString()),
        作成終了年月日(UrErrorMessages.必須項目_追加メッセージあり, 作成終了年月日チェック.toString()),
        作成開始年月日_作成終了年月日(UrErrorMessages.期間が不正_追加メッセージあり１, 作成開始年月日チェック.toString(), 作成終了年月日チェック.toString()),
        決定予定日(UrErrorMessages.必須項目_追加メッセージあり, 決定予定日_STR.toString());

        private final Message message;

        KogakuGassanShikyuKetteiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

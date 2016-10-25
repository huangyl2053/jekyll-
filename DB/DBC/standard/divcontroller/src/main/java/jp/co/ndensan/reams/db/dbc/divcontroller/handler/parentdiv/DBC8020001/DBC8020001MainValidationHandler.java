/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8020001;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001.DBC8020001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8020001.DBC8020001MainDivSpec;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 事業合算・事業分振込明細書作成（一括）のValidationHandlerです。
 *
 * @reamsid_L DBC-4870-010 zhouchuanlin
 */
public class DBC8020001MainValidationHandler {

    private final DBC8020001MainDiv div;

    /**
     * コンストラクターです。
     *
     * @param div DBC8010001MainValidationHandler
     */
    public DBC8020001MainValidationHandler(DBC8020001MainDiv div) {
        this.div = div;
    }

    /**
     * 振込指定日休日チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor振込指定日休日(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbcErrorMessages.振込指定日休日);
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.振込指定日休日チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 振込指定日過去日チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor振込指定日過去日(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.期間が不正_過去日付不可,
                div.getTxtFurikomiShiteiYMD().getValue().toString(), RDate.getNowDate().toString());
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.振込指定日過去日チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 正・振込指定日休日チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor正振込指定日休日(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbcErrorMessages.振込指定日休日);
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.正振込指定日休日チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtCorrectFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 正・振込指定日過去日チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor正振込指定日過去日(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.期間が不正_過去日付不可,
                div.getTxtCorrectFurikomiShiteiYMD().getValue().toString(), RDate.getNowDate().toString());
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.正振込指定日過去日チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtCorrectFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 今回対象日・開始日未入力チェック。
     *
     * @return boolean
     */
    public boolean validateFor今回対象日開始日未入力() {
        return null == div.getTxtKonkaiTaishoYmdRange().getFromValue()
                || RString.EMPTY.equals(div.getTxtKonkaiTaishoYmdRange().getFromValue().toDateString());
    }

    /**
     * 決定者受取年月・開始年月未入力チェック。
     *
     * @return boolean
     */
    public boolean validateFor決定者受取年月開始年月未入力() {
        return null == div.getTxtKetteishaUketoriYmRange().getFromValue()
                || RString.EMPTY.equals(div.getTxtKetteishaUketoriYmRange().getFromValue().toDateString());
    }

    /**
     * 再処理対象データ存在チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor再処理対象データ存在(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbcErrorMessages.口座振込データ登録なし_再処理不可);
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.再処理対象データ存在チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 修正対象データ存在チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor修正対象データ存在(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(DbcErrorMessages.口座振込データ登録なし_修正不可);
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8020001MainDivSpec.修正対象データ存在チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtWrongFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    private static final class NoInputMessages implements IValidationMessage {

        private final Message message;

        private NoInputMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

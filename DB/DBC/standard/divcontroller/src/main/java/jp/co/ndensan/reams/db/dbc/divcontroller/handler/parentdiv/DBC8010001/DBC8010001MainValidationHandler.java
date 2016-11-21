/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8010001;

import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001.DBC8010001MainDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001.DBC8010001MainDivSpec;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
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
 * 振込明細・振込みデータ作成のValidationHandlerです。
 *
 * @reamsid_L DBC-2180-010 x_liuwei
 */
public class DBC8010001MainValidationHandler {

    private static final RString 振込指定日 = new RString("振込指定日");
    private static final RString 本日 = new RString("本日");
    private static final RString 修正後の振込指定日 = new RString("修正後の振込指定日");

    private DBC8010001MainDiv div;

    /**
     * コンストラクターです。
     *
     * @param div DBC8010001MainValidationHandler
     */
    public DBC8010001MainValidationHandler(DBC8010001MainDiv div) {
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
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.振込指定日休日チェック)
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
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.期間が不正_過去日付不可, 振込指定日.toString(), 本日.toString());
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.振込指定日過去日チェック)
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
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.正振込指定日休日チェック)
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
        NoInputMessages checkMessage = new NoInputMessages(DbzErrorMessages.期間が不正_過去日付不可, 修正後の振込指定日.toString(), 本日.toString());
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.正振込指定日過去日チェック)
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
        return null == div.getTxtKonkaiTaishoYmdRange().getFromValue() || RString.EMPTY.equals(div.getTxtKonkaiTaishoYmdRange().getFromValue().toDateString());
    }

    /**
     * 決定者受取年月・開始年月未入力チェック。
     *
     * @return boolean
     */
    public boolean validateFor決定者受取年月開始年月未入力() {
        return null == div.getTxtKetteishaUketoriYmRange().getFromValue() || RString.EMPTY.equals(div.getTxtKetteishaUketoriYmRange().getFromValue().toDateString());
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
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.再処理対象データ存在チェック)
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
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.修正対象データ存在チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage,
                div.getTxtWrongFurikomiShiteiYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 出力順チェック。
     *
     * @param pairs ValidationMessageControlPairs
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs validateFor出力順(ValidationMessageControlPairs pairs) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        NoInputMessages checkMessage = new NoInputMessages(UrErrorMessages.出力順序を指定);
        messages.add(ValidateChain.validateStart(div).ifNot(DBC8010001MainDivSpec.出力順チェック)
                .thenAdd(checkMessage).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(checkMessage, (ChohyoShutsuryokujunDiv) div.getCcdChohyoShutsuryokujun()).build().check(messages));
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

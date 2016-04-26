/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1010001;

import jp.co.ndensan.reams.db.dbd.definition.message.DbdErrorMessages;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1010001.FutangendogakuShinseiDivSpec;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessageControlDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 *
 * @author liangbc
 */
public class NinteiShinseiValidationHandler {

    /**
     * 受給共通_被保データなしチェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 受給共通_被保データなしチェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.受給共通_被保データなし)
                .thenAdd(NinteiShinseiValidationMessages.受給共通_被保データなし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().
                add(NinteiShinseiValidationMessages.受給共通_被保データなし).build().check(messages));
        return pairs;
    }

    /**
     * 受給共通_受給者登録なしチェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 受給共通_受給者登録なしチェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.受給共通_受給者登録なし)
                .thenAdd(NinteiShinseiValidationMessages.受給共通_受給者_事業対象者登録なし).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().
                add(NinteiShinseiValidationMessages.受給共通_受給者_事業対象者登録なし).build().check(messages));
        return pairs;
    }

    /**
     * 負担限度額認定_適用開始日が法施行以前チェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 負担限度額認定_適用開始日が法施行以前チェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.負担限度額認定_適用開始日が法施行以前)
                .thenAdd(NinteiShinseiValidationMessages.減免減額_適用日が法施行前).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().add(NinteiShinseiValidationMessages.減免減額_適用日が法施行前, div.getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 負担限度額認定_適用終了日が年度外チェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 負担限度額認定_適用終了日が年度外チェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.負担限度額認定_適用終了日が年度外)
                .thenAdd(NinteiShinseiValidationMessages.減免減額_有効期限が年度外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().
                add(NinteiShinseiValidationMessages.減免減額_有効期限が年度外, div.getTxtTekiyoYMD()).build().check(messages));
        return pairs;
    }

    /**
     * 負担限度額認定_適用終了日が開始日以前チェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 負担限度額認定_適用終了日が開始日以前チェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.負担限度額認定_適用終了日が開始日以前)
                .thenAdd(NinteiShinseiValidationMessages.減免減額_有効期限が年度外).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().
                add(NinteiShinseiValidationMessages.減免減額_有効期限が年度外, div.getTxtTekiyoYMD(), div.getTxtYukoKigenYMD()).
                build().check(messages));
        return pairs;
    }

    /**
     * 減免減額_適用期間重複チェックです。
     *
     * @param pairs ValidationMessageControlPairs
     * @param div TaishouWaritsukeDiv
     * @return ValidationMessageControlPairs
     */
    public ValidationMessageControlPairs 減免減額_適用期間重複チェック(ValidationMessageControlPairs pairs, FutangendogakuShinseiDiv div) {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div).ifNot(FutangendogakuShinseiDivSpec.減免減額_適用期間重複)
                .thenAdd(NinteiShinseiValidationMessages.減免減額_適用期間重複).messages());
        pairs.add(new ValidationMessageControlDictionaryBuilder().
                add(NinteiShinseiValidationMessages.減免減額_適用期間重複, div.getDgShinseiList()).build().check(messages));
        return pairs;
    }

    private static enum NinteiShinseiValidationMessages implements IValidationMessage {

        受給共通_受給者_事業対象者登録なし(DbdErrorMessages.受給共通_受給者_事業対象者登録なし),
        減免減額_適用日が法施行前(DbdErrorMessages.減免減額_適用日が法施行前),
        減免減額_有効期限が年度外(DbdErrorMessages.減免減額_有効期限が年度外),
        減免減額_有効期限が適用日以前(DbdErrorMessages.減免減額_有効期限が適用日以前),
        減免減額_適用期間重複(DbdErrorMessages.減免減額_適用期間重複),
        受給共通_被保データなし(DbdInformationMessages.受給共通_被保データなし);

        private final Message message;

        private NinteiShinseiValidationMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}

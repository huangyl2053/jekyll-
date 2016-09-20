/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DvKogakuServiceJuryoIninDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 高額サービス費等受領委任払情報管理のValidatorです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvKogakuServiceJuryoIninValidator {

    private final DvKogakuServiceJuryoIninDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KaigoSienSenmonkaTorokuDiv Div}
     */
    public DvKogakuServiceJuryoIninValidator(DvKogakuServiceJuryoIninDiv div) {
        this.div = div;
    }

    /**
     * 修正追加必須チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate修正追加() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvKogakuServiceJuryoIninSpec.承認しない理由必須)
                .thenAdd(DvKogakuServiceJuryoIninValidationMessages.承認しない理由必須)
                .ifNot(DvKogakuServiceJuryoIninSpec.利用者負担上限額必須)
                .thenAdd(DvKogakuServiceJuryoIninValidationMessages.利用者負担上限額必須)
                .ifNot(DvKogakuServiceJuryoIninSpec.承認終了日の入力値が不正)
                .thenAdd(DvKogakuServiceJuryoIninValidationMessages.承認終了日の入力値が不正)
                .messages());
        return messages;
    }

    /**
     * 発行必須チェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate発行() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(DvKogakuServiceJuryoIninSpec.文書番号必須)
                .thenAdd(DvKogakuServiceJuryoIninValidationMessages.文書番号必須)
                .messages());
        return messages;
    }

}

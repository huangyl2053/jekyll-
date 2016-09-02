/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 *
 * @author Administrator
 */
public class NijiyoboJohoTaishoshaTorokuPanelValidator {

    private final NijiyoboJohoTaishoshaTorokuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KaigoSienSenmonkaTorokuDiv Div}
     */
    public NijiyoboJohoTaishoshaTorokuPanelValidator(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 負担額情報入力の明細月のチェックです。
     *
     * @return エラーメッセージ
     */
    public IValidationMessages validate() {
        IValidationMessages messages = ValidationMessagesFactory.createInstance();
        messages.add(ValidateChain.validateStart(div)
                .ifNot(NijiyoboJohoTaishoshaTorokuPanelSpec.適用期間重複)
                .thenAdd(NijiyoboJohoTaishoshaTorokuPanelValidationMassages.適用期間重複)
                .ifNot(NijiyoboJohoTaishoshaTorokuPanelSpec.開始日と終了日の前後順)
                .thenAdd(NijiyoboJohoTaishoshaTorokuPanelValidationMassages.開始日と終了日の前後順)
                .messages());
        return messages;
    }
}

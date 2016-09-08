/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC1740011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1740011.NijiyoboJohoTaishoshaTorokuPanelDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 総合事業（経過措置）対象者登録 のValidationHandlerです。
 *
 * @reamsid_L DBC-2400-010 yuqingzhang
 */
public class NijiyoboJohoTaishoshaTorokuPanelValidationHandler {

    private final NijiyoboJohoTaishoshaTorokuPanelDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link NijiyoboJohoTaishoshaTorokuPanelDiv}
     */
    public NijiyoboJohoTaishoshaTorokuPanelValidationHandler(NijiyoboJohoTaishoshaTorokuPanelDiv div) {
        this.div = div;
    }

    /**
     * 総合事業（経過措置）対象者登録チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate() {
        IValidationMessages message = new NijiyoboJohoTaishoshaTorokuPanelValidator(div).validate();
        return createDictionary().check(message);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(NijiyoboJohoTaishoshaTorokuPanelValidationMassages.適用期間重複,
                        div.getSoukoinfo().getTxtymfromto())
                .add(NijiyoboJohoTaishoshaTorokuPanelValidationMassages.開始日と終了日の前後順,
                        div.getSoukoinfo().getTxtymfromto())
                .build();
    }
}

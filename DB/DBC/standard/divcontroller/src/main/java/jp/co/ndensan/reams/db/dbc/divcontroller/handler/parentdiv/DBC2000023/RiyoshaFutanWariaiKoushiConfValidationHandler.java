/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000023;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000023.RiyoshaFutanWariaiKoushiConfDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「発行する」ボタンを押下時の入力チェックValidationHandlerです。
 *
 * @reamsid_L DBC-5010-012 lijian
 */
public class RiyoshaFutanWariaiKoushiConfValidationHandler {

    private final RiyoshaFutanWariaiKoushiConfDiv div;

    /**
     * コンストラクタです。
     *
     * @param div DBC4530011Panel1Div
     */
    public RiyoshaFutanWariaiKoushiConfValidationHandler(RiyoshaFutanWariaiKoushiConfDiv div) {
        this.div = div;
    }

    /**
     * 発行日入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate発行日() {
        IValidationMessages message = new RiyoshaFutanWariaiKoushiConfValidator(div).validate発行日入力();
        return create発行日入力Dictionary().check(message);
    }

    private ValidationDictionary create発行日入力Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(RiyoshaFutanWariaiKoushiConfValidationMessage.発行日チェック, div.getPanelHakko().getTxtHakkobi()).build();
    }

    /**
     * 交付日入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate交付日() {
        IValidationMessages message = new RiyoshaFutanWariaiKoushiConfValidator(div).validate交付日未入力();
        return create交付日入力Dictionary().check(message);
    }

    private ValidationDictionary create交付日入力Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(RiyoshaFutanWariaiKoushiConfValidationMessage.交付日チェック, div.getPanelHakko().getTxtKofubi()).build();
    }

    /**
     * 交付事由入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate交付事由未選択() {
        IValidationMessages message = new RiyoshaFutanWariaiKoushiConfValidator(div).validate交付事由入力();
        return create交付事由入力Dictionary().check(message);
    }

    private ValidationDictionary create交付事由入力Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(RiyoshaFutanWariaiKoushiConfValidationMessage.交付事由チェック, div.getPanelHakko().getDdlKofuJiyu()).build();
    }
}

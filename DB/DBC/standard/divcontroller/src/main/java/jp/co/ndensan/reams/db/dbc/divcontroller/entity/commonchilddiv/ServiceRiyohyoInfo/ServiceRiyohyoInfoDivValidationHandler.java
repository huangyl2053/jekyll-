/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;

import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * サービス利用票情報のValidationHandlerです。
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfoDivValidationHandler {

    private final ServiceRiyohyoInfoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link ServiceRiyohyoInfoDiv}
     */
    public ServiceRiyohyoInfoDivValidationHandler(ServiceRiyohyoInfoDiv div) {
        this.div = div;
    }

    /**
     * 明細計算チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate明細計算() {
        IValidationMessages message = new ServiceRiyohyoInfoDivValidator(div).validate明細計算();
        return create明細計算Dictionary().check(message);
    }

    private ValidationDictionary create明細計算Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(ServiceRiyohyoInfoDivValidationMessage.サービスコード必須項目)
                .add(ServiceRiyohyoInfoDivValidationMessage.単位必須項目, div.getServiceRiyohyoBeppyoMeisai().getTxtTani())
                .add(ServiceRiyohyoInfoDivValidationMessage.回数必須項目, div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu())
                .add(ServiceRiyohyoInfoDivValidationMessage.サービス単位必須項目,
                        div.getServiceRiyohyoBeppyoMeisai().getTxtServiceTani()).build();
    }

    /**
     * 割引適用後率のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate割引適用後率() {
        IValidationMessages message = new ServiceRiyohyoInfoDivValidator(div).validate割引適用後率();
        return create割引適用後率Dictionary().check(message);
    }

    private ValidationDictionary create割引適用後率Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(ServiceRiyohyoInfoDivValidationMessage.割引適用後率入力値が不正,
                        div.getServiceRiyohyoBeppyoMeisai().getTxtWaribikigoRitsu()).build();
    }

    /**
     * 回数のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate回数() {
        IValidationMessages message = new ServiceRiyohyoInfoDivValidator(div).validate回数();
        return create回数Dictionary().check(message);
    }

    private ValidationDictionary create回数Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(ServiceRiyohyoInfoDivValidationMessage.回数入力値が不正,
                        div.getServiceRiyohyoBeppyoMeisai().getTxtKaisu()).build();
    }

    /**
     * 単位数単価のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate単位数単価() {
        IValidationMessages message = new ServiceRiyohyoInfoDivValidator(div).validate単位数単価();
        return create単位数単価Dictionary().check(message);
    }

    private ValidationDictionary create単位数単価Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(ServiceRiyohyoInfoDivValidationMessage.単位数単価入力値が不正,
                        div.getServiceRiyohyoBeppyoGokei().getTxtTanisuTanka()).build();
    }

    /**
     * 給付率のチェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate給付率() {
        IValidationMessages message = new ServiceRiyohyoInfoDivValidator(div).validate給付率();
        return create給付率Dictionary().check(message);
    }

    private ValidationDictionary create給付率Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(ServiceRiyohyoInfoDivValidationMessage.給付率入力値が不正,
                        div.getServiceRiyohyoBeppyoGokei().getTxtKyufuritsu()).build();
    }
}

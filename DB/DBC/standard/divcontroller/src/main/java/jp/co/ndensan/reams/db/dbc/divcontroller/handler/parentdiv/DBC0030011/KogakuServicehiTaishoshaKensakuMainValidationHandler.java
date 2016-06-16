/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0030011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011.KogakuServicehiTaishoshaKensakuMainDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 「該当者を検索する」ボタンを押下時の入力チェックValidationHandlerです。
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiTaishoshaKensakuMainValidationHandler {

    private final KogakuServicehiTaishoshaKensakuMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KogakuServicehiTaishoshaKensakuMainDiv}
     */
    public KogakuServicehiTaishoshaKensakuMainValidationHandler(KogakuServicehiTaishoshaKensakuMainDiv div) {
        this.div = div;
    }

    /**
     * 被保険者を指定入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate被保険者を指定入力() {
        IValidationMessages message = new KogakuServicehiTaishoshaKensakuMainValidator(div).validate被保険者を指定入力();
        return create被保険者を指定入力Dictionary().check(message);
    }

    private ValidationDictionary create被保険者を指定入力Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuServicehiTaishoshaKensakuMainMessage.被保険者を指定入力チェック,
                        div.getKogakuServicehiSearch().getHihokenshaKensakuJoken()).build();
    }

    /**
     * 年月を指定入力チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate年月を指定入力() {
        IValidationMessages message = new KogakuServicehiTaishoshaKensakuMainValidator(div).validate年月を指定入力();
        return create年月を指定入力Dictionary().check(message);
    }

    private ValidationDictionary create年月を指定入力Dictionary() {
        return new ValidationDictionaryBuilder()
                .add(KogakuServicehiTaishoshaKensakuMainMessage.年月を指定入力チェック,
                        div.getKogakuServicehiSearch().getNengetsuKensakuJoken()).build();
    }

}

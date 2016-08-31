/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4200011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011.KubunShikyuGendogakuMainDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 区分支給限度額登録のValidationHandlerです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class KubunShikyuGendogakuMainValidationHandler {

    private final KubunShikyuGendogakuMainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link KubunShikyuGendogakuMainDiv}
     */
    public KubunShikyuGendogakuMainValidationHandler(KubunShikyuGendogakuMainDiv div) {
        this.div = div;
    }

    /**
     * 適用開始年月チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate保存する() {
        IValidationMessages message = new KubunShikyuGendogakuMainValidator(div).validate保存する();
        return create保存するDictionary().check(message);
    }

    private ValidationDictionary create保存するDictionary() {
        return new ValidationDictionaryBuilder()
                .add(KubunShikyuGendogakuMainValidationMessage.適用期間_標準額と不一致,
                        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange())
                .add(KubunShikyuGendogakuMainValidationMessage.適用年月_重複_開始年月不正,
                        div.getKubunShikyuGendogakuShosai().getTxtTekiyoKikanRange())
                .build();
    }
}

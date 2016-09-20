/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0330011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011.DvKogakuServiceJuryoIninDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 高額サービス費等受領委任払情報管理のValidationHandlerです。
 *
 * @reamsid_L DBC-1980-010 yuqingzhang
 */
public class DvKogakuServiceJuryoIninValidationHandler {

    private final DvKogakuServiceJuryoIninDiv div;

    /**
     * コンストラクタです。
     *
     * @param div {@link DvKogakuServiceJuryoIninDiv}
     */
    public DvKogakuServiceJuryoIninValidationHandler(DvKogakuServiceJuryoIninDiv div) {
        this.div = div;
    }

    /**
     * 発行チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate発行() {
        IValidationMessages message = new DvKogakuServiceJuryoIninValidator(div).validate発行();
        return createDictionary発行().check(message);
    }

    private ValidationDictionary createDictionary発行() {
        return new ValidationDictionaryBuilder()
                .add(DvKogakuServiceJuryoIninValidationMessages.文書番号必須,
                        (Panel) div.getDvKakuninsho().getCcdBunshoBango())
                .build();
    }

    /**
     * 修正追加チェックです。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validate修正追加() {
        IValidationMessages message = new DvKogakuServiceJuryoIninValidator(div).validate修正追加();
        return createDictionary修正追加().check(message);
    }

    private ValidationDictionary createDictionary修正追加() {
        return new ValidationDictionaryBuilder()
                .add(DvKogakuServiceJuryoIninValidationMessages.承認しない理由必須,
                        div.getDvHaraiKetteiShusei().getTxtShoninShinaiRiyu())
                .add(DvKogakuServiceJuryoIninValidationMessages.利用者負担上限額必須,
                        div.getDvHaraiKetteiShusei().getDdlRiyoshafutanJogenGaku())
                .add(DvKogakuServiceJuryoIninValidationMessages.承認終了日の入力値が不正,
                        div.getDvHaraiKetteiShusei().getBtnShoninDate())
                .build();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0410032;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410032.TsuchishoJoho37JDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionary;
import jp.co.ndensan.reams.ua.uax.divcontroller.controller.testdriver.TestJukiAtenaValidation.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 国保連情報受取データ取込_[37J]高額合算自己負担額確認情報のValidationHandlerです。
 *
 * @reamsid_L DBC-0980-090 tangkai
 */
public class TsuchishoJoho37JValidationHandler {

    private final TsuchishoJoho37JDiv div;

    /**
     * コンストラクタ
     *
     * @param div TsuchishoJoho37JDiv
     */
    public TsuchishoJoho37JValidationHandler(TsuchishoJoho37JDiv div) {
        this.div = div;
    }

    /**
     * 出力順のチェックを行う。
     *
     * @return チェック結果
     */
    public ValidationMessageControlPairs validateCheck出力順() {
        ValidationMessageControlPairs validateResult = new ValidationMessageControlPairs();
        TsuchishoJoho37JValidator validator = new TsuchishoJoho37JValidator(div);
        validateResult.add(createNoSearchdataDictionary().check(validator.validate()));
        return validateResult;
    }

    /**
     * 出力順対象を取得する。
     *
     * @return 検証対象
     */
    private ValidationDictionary createNoSearchdataDictionary() {
        return new ValidationDictionaryBuilder()
                .add(TsuchishoJoho37JValidationMessages.出力順入力チェック, div.getCcdKokurenJohoTorikomi().get出力順Div())
                .build();
    }

}

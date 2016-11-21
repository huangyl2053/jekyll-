/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001;

import jp.co.ndensan.reams.ca.cac.divcontroller.handler.parentdiv.cace102000.HanyoListkougakugasSannKeiSuukekkaValidationMessage;
import jp.co.ndensan.reams.ca.cac.divcontroller.handler.parentdiv.cace102000.HanyoListkougakugasSannKeiSuukekkaValidator;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)ValidationHandlerです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public class HanyoListkougakugasSannKeiSuukekkaValidationHandler {

    private final HanyoListkougakugasSannKeiSuukekkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 管内名義変更Div
     */
    public HanyoListkougakugasSannKeiSuukekkaValidationHandler(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateCheck() {
        IValidationMessages message = new HanyoListkougakugasSannKeiSuukekkaValidator(div).validate();
        return createDictionary().check(message);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(HanyoListkougakugasSannKeiSuukekkaValidationMessage.出力順未指定チェック)
                .build();
    }
}

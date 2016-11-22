/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC7160001;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7160001.HanyoListkougakugasSannKeiSuukekkaDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)ControlValidatorです。
 *
 * @reamsid_L DBC-3100-010 zhengshenlei
 */
public class HanyoListkougakugasSannKeiSuukekkaValidator implements IValidatable {

    private final HanyoListkougakugasSannKeiSuukekkaDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 口座振替集計表div
     */
    public HanyoListkougakugasSannKeiSuukekkaValidator(HanyoListkougakugasSannKeiSuukekkaDiv div) {
        this.div = div;
    }

    /**
     * 科目未入力チェック。
     *
     * @return IValidationMessages
     */
    @Override
    public IValidationMessages validate() {
        IValidationMessages message = ValidationMessagesFactory.createInstance();
        message.add(ValidateChain.validateStart(div)
                .ifNot(HanyoListkougakugasSannKeiSuukekkaSpec.出力順未指定チェック)
                .thenAdd(HanyoListkougakugasSannKeiSuukekkaValidationMessage.出力順未指定チェック)
                .messages());
        return message;
    }

}

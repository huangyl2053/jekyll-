/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.DBC3510011MainDiv;
import jp.co.ndensan.reams.uz.uza.core.validation.IValidatable;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidateChain;
import jp.co.ndensan.reams.uz.uza.core.validation.ValidationMessagesFactory;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;

/**
 * 保険者情報送付のバリデーションです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public class DBC3510011MainValidator implements IValidatable {

    private final DBC3510011MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 口座振替集計表div
     */
    public DBC3510011MainValidator(DBC3510011MainDiv div) {
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
                .ifNot(DBC3510011MainSpec.ダウンロード対象選択チェック)
                .thenAdd(DBC3510011MainValidationMessage.ダウンロード対象選択チェック)
                .messages());
        return message;
    }

}

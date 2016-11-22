/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC3510011;

import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC3510011.DBC3510011MainDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionary;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.ValidationDictionaryBuilder;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessages;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * 保険者情報送付のバリデーションです。
 *
 * @reamsid_L DBC-3480-010 dongyabin
 */
public class DBC3510011MainValidationHandler {

    private final DBC3510011MainDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 管内名義変更Div
     */
    public DBC3510011MainValidationHandler(DBC3510011MainDiv div) {
        this.div = div;
    }

    /**
     * 入力チェック。
     *
     * @return {@link ValidationMessageControlPairs}
     */
    public ValidationMessageControlPairs validateCheck() {
        IValidationMessages message = new DBC3510011MainValidator(div).validate();
        return createDictionary().check(message);
    }

    private ValidationDictionary createDictionary() {
        return new ValidationDictionaryBuilder()
                .add(DBC3510011MainValidationMessage.ダウンロード対象選択チェック, div.getDgSofuDataIchiran())
                .build();
    }
}

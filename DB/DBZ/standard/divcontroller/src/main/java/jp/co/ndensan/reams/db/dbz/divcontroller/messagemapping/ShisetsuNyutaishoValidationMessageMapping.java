/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.messagemapping;

import jp.co.ndensan.reams.db.dbz.model.validation.ShisetsuNyutaishoValidationMessage;
import jp.co.ndensan.reams.ur.urz.divcontroller.validations.IValidationMessageMapping;
import jp.co.ndensan.reams.ur.urz.model.validations.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設入退所履歴のバリデーションメッセージとfieldNameの紐付けを定義する列挙体です。
 *
 * @author N8223　朴義一
 */
public enum ShisetsuNyutaishoValidationMessageMapping implements IValidationMessageMapping {

    /**
     *
     */
    入所日が未入力(ShisetsuNyutaishoValidationMessage.入所日が未入力, "txtNyushoDate"),
    /**
     *
     */
    終了日設定なし(ShisetsuNyutaishoValidationMessage.終了日設定なし, "taishoDate"),
    /**
     *
     */
    入所施設が未入力(ShisetsuNyutaishoValidationMessage.入所施設が未入力, "txtShisetsuCode"),
    /**
     *
     */
    入所年月日より前(ShisetsuNyutaishoValidationMessage.入所年月日より前, "txtTaishoDate"),
    /**
     *
     */
    退所日と次の履歴データの入所日の期間が重複(ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複, "txtTaishoDate"),
    /**
     *
     */
    入所日と前の履歴データの退所日の期間が重複(ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複, "txtNyushoDate"),
    /**
     *
     */
    入所日と期間が重複する履歴がある(ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある, "txtNyushoDate"),
    /**
     *
     */
    退所日と期間が重複する履歴がある(ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある, "txtTaishoDate");

    private final IValidationMessage message;
    private final String fieldName;

    private ShisetsuNyutaishoValidationMessageMapping(IValidationMessage message, String fieldName) {
        this.message = message;
        this.fieldName = fieldName;
    }

    @Override
    public IValidationMessage getValidationMessage() {
        return message;
    }

    @Override
    public Message getMessage() {
        return message.getMessage();
    }

    @Override
    public String getFieldName() {
        return fieldName;
    }

}

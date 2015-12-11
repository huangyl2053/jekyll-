/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.messagemapping;

import jp.co.ndensan.reams.db.dbz.business.validation.ShisetsuNyutaishoValidationMessage;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * 施設入退所履歴のバリデーションメッセージとfieldNameの紐付けを定義する列挙体です。
 *
 * @author N8223　朴義一
 */
//TODO n3317 塚田萌　ビルドを通すための暫定対応。見直してください。
public enum ShisetsuNyutaishoValidationMessageMapping {

    /**
     *
     */
    入所日が未入力(ShisetsuNyutaishoValidationMessage.入所日が未入力, new RString("txtNyushoDate")),
    /**
     *
     */
    終了日設定なし(ShisetsuNyutaishoValidationMessage.終了日設定なし, new RString("taishoDate")),
    /**
     *
     */
    入所施設コードが未入力(ShisetsuNyutaishoValidationMessage.入所施設コードが未入力, new RString("txtShisetsuCode")),
    /**
     *
     */
    入所施設名称が未入力(ShisetsuNyutaishoValidationMessage.入所施設名称が未入力, new RString("txtShisetsuCode")),
    /**
     *
     */
    入所年月日より前(ShisetsuNyutaishoValidationMessage.入所年月日より前, new RString("txtTaishoDate")),
    /**
     *
     */
    退所日と次の履歴データの入所日の期間が重複(ShisetsuNyutaishoValidationMessage.退所日と次の履歴データの入所日の期間が重複, new RString("txtTaishoDate")),
    /**
     *
     */
    入所日と前の履歴データの退所日の期間が重複(ShisetsuNyutaishoValidationMessage.入所日と前の履歴データの退所日の期間が重複, new RString("txtNyushoDate")),
    /**
     *
     */
    入所日と期間が重複する履歴がある(ShisetsuNyutaishoValidationMessage.入所日と期間が重複する履歴がある, new RString("txtNyushoDate")),
    /**
     *
     */
    退所日と期間が重複する履歴がある(ShisetsuNyutaishoValidationMessage.退所日と期間が重複する履歴がある, new RString("txtTaishoDate"));

    private final IValidationMessage message;
    private final RString fieldName;

    private ShisetsuNyutaishoValidationMessageMapping(IValidationMessage message, RString fieldName) {
        this.message = message;
        this.fieldName = fieldName;
    }
    /**
     * バリデーションメッセージを取得します
     *
     * @return IValidationMessage
     */
    public IValidationMessage getValidationMessage() {
        return (IValidationMessage) message;
    }

    /**
     * メッセージを取得します
     *
     * @return Message
     */
    public Message getMessage() {
        return message.getMessage();
    }

    /**
     * フィールド名称を取得します
     *
     * @return fieldName
     */
    public RString getFieldName() {
        return fieldName;
    }
}

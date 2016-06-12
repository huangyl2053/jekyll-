/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.message;

import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBUのエラーメッセージ定義列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum DbuErrorMessages implements IMessageGettable {

    開始日不正(1, "?以降の日付を設定してください。"),
    最大取得件数範囲外(2, "最大取得件数は1～999の範囲で設定してください。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbuErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBUE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}

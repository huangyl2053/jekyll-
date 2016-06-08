/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * DBBの警告メッセージ定義列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum DbbWarningMessages implements IMessageGettable {

    特徴期割額端数不整合(1, "特別徴収?は、?円未満が0ではありません。必要に応じて見直してください。"),
    普徴期割額端数不整合(2, "普通徴収?は、?円未満が0ではありません。必要に応じて見直してください。"),
    期別修正による特徴停止(3, "特徴期別額が０円に修正されたため、特別徴収停止となります。更新してよろしいですか？"),
    別情報での特徴対象者同定(4, "すでに別の基礎年金番号、年金コードで特別徴収となっています。ここで設定した内容で特別徴収にしてよろしいですか？"),
    他の候補者を対象外更新(5, "他の特別徴収同定候補者を対象外で更新します。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("DBBW", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

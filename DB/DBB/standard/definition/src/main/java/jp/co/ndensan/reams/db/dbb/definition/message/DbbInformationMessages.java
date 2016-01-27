/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBBのインフォメーションメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbbInformationMessages implements IMessageGettable {

    比較対象データなし(1, "比較対象のデータがありません。"),
    期間内異動なし(2, "期間内に異動はありませんでした。"),
    確定対象賦課なし(3, "確定処理の対象となる賦課がありません。確定処理は不要です。"),
    更正前と状態変更なし(4, "更正前の状態と変わりません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbbInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("DBBI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

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
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum DbbInformationMessages implements IMessageGettable {

    比較対象データなし(1, "比較対象のデータがありません。"),
    期間内異動なし(2, "期間内に異動はありませんでした。"),
    確定対象賦課なし(3, "確定処理の対象となる賦課がありません。確定処理は不要です。"),
    更正前と状態変更なし(4, "更正前の状態と変わりません。"),
    同定処理完了(5, "特別徴収対象の同定処理は正常に行われました。"),
    同定対象外確認済処理完了(6, "同定対象外確認済処理は正常に行われました。"),
    打分け方法保存指示(7, "設定を保存する場合は、保存名称を入力し「設定を保存する」ボタンを押下してください。");

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

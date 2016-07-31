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
    保険者番号重複(3, "同一の保険者番号が既に登録されています。"),
    保険者番号都道府県エラー(4, "選択された都道府県と異なります。"),
    月報全て未処理(5, "集計範囲内で、月報未処理の月があります。?"),
    出力対象未選択(6, "出力対象の指定を確認してください。"),
    報告年月未確定(7, "報告年月を確定してください。");

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

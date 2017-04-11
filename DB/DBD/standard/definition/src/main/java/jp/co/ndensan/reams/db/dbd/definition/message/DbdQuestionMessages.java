/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * DBDの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum DbdQuestionMessages implements IMessageGettable {

    負担限度額一括認定_テスト結果承認確認(1, "表示中のテスト結果を認定結果として登録します。よろしいですか？"),
    負担限度額一括認定_修正反映確認(2, "修正した内容を認定結果として登録します。よろしいですか？"),
    受給者台帳異動チェックリスト_以前出力確認(3, "?より前のデータをすべて発行してもよろしいでしょうか？", ButtonSelectPattern.OKCancel),
    受給者台帳異動チェックリスト_以後出力確認(4, "?より後のデータをすべて発行してもよろしいでしょうか？", ButtonSelectPattern.OKCancel),
    受給者台帳異動チェックリスト_全件出力確認(5, "全件発行処理してもよろしいでしょうか？", ButtonSelectPattern.OKCancel),
    編集破棄確認(6, "編集されています。<br>未更新の情報は反映されませんが、よろしいですか？"),
    新規登録確認(7, "被保険者に関連付け済みの情報のため、「検索」から指定してください。"
            + "<br>他市町村からの照会結果など、同一年金について新規登録の必要がある場合登録してください。新規登録しますか？"),
    被保険者関連解除確認(8, "非課税年金対象者情報の、表示中の被保険者との関連づけを解除します。よろしいですか？"),
    非課税年金再処理確認(9, "\"再処理前\"に変更される処理月があります。再処理前に設定後、再処理を実行すると、"
            + "取込済みの年月の非課税年金対象者情報は全て初期化されます。再処理前に設定してよろしいですか？"),
    再発行確認(10, "?は発行済です。この帳票を発行してもよろしいですか？"),
    処理実行の確認(50, "処理を実行してもよろしいですか？", ButtonSelectPattern.OKCancel),
    編集クリア確認(11, "編集されています。クリアしてよろしいですか？"),
    負担割合証単票発行確認(12, "負担割合証を単票発行しますか？<br>"
            + "単票発行した場合、発行日、交付日は画面で指定した日付で更新され、「単票発行で発行済」の状態となります。"),
    利用者負担割合テストモード確認(13, "テストモードで処理するため利用者負担割合の登録は行われません。よろしいですか？"),
    年次負担割合再処理(14, "年次負担割合判定を実行すると、?年度の利用者負担割合情報は全件削除した上で再判定、再登録します。"
            + "<br>異動者について判定する場合、異動分負担割合判定処理を実行してください。<br>年次負担割合判定を実行しますか？");
    private final RString message;
    private final int no;
    private final ButtonSelectPattern buttonSelectPattern;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdQuestionMessages(int no, String message) {
        this.no = no;
        this.message = new RString(message);
        this.buttonSelectPattern = ButtonSelectPattern.YesNo;
    }

    private DbdQuestionMessages(int no, String message, ButtonSelectPattern buttonSelectPattern) {
        this.no = no;
        this.message = new RString(message);
        this.buttonSelectPattern = buttonSelectPattern;
    }

    @Override
    public Message getMessage() {
        return new QuestionMessage(toCode("DBDQ", no), message.toString(), buttonSelectPattern);
    }

    /**
     * 選択可能ボタンを指定してメッセージを返します。
     *
     * @param pattern ボタンセレクトパターン
     * @return メッセージ
     */
    public Message getMessage(ButtonSelectPattern pattern) {
        return new QuestionMessage(toCode("Q", no).toString(), message.toString(), pattern);
    }
}

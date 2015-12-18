/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.message;

import static jp.co.ndensan.reams.uz.uza.batch.parameter.message._BatchMessageUtil.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBZのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbzErrorMessages implements IMessageGettable, IValidationMessage {

    理由付き確定不可(1, "?のため確定できません。"),
    編集後更新指示(2, "編集されています。更新処理を行ってください。"),
    理由付き完了不可(3, "?のため完了できません。"),
    理由付き登録不可(4, "?のため登録できません。"),
    複数必須項目相関チェックエラー(5, "?が入力されている場合、?が入力されている必要があります。"),
    期間が不正_未来日付不可(6, "?は?より未来の日付を設定できません。"),
    検索結果件数不正(7, "検索結果の件数が不正です。"),
    期間が不正_過去日付不可(8, "?は?より過去の日付を設定できません。"),
    バッチパラメータ取得エラー(9, "バッチパラメータを取得できません。"),
    連携パターン取得エラー(10, "連携パターンを取得できません。"),
    資格不整合_転入(11, "対象者は「転入」により資格を取得しています。そのため、資格取得日は登録異動日と一致しなければなりません。"),
    資格不整合_年齢到達(12, "対象者は「年齢到達」により資格をしています。そのため、資格取得日は1号年齢到達日と一致しなければなりません。"),
    資格不整合_職権削除(13, "対象者は「職権消除」されています。そのため、資格喪失日は消除異動日と一致しなければなりません。"),
    資格不整合_転出_転出予定日(14, "対象者は「転出」しています。そのため、資格喪失日は転出予定日と一致しなければなりません。"),
    資格不整合_転出_転出確定日(15, "対象者は「転出」しています。そのため、資格喪失日は転出確定日と一致しなければなりません。"),
    資格不整合_死亡(16, "対象者は「死亡」しています。そのため、資格喪失日は消除異動日と一致しなければなりません。"),
    資格不整合_1号年齢到達(17, "対象者は「1号到達」しています。そのため、資格変更日は1号年齢到達日と一致しなければなりません。"),
    指定数誤り(18, "?の数が不正です。?してください。"),
    実行不可(19, "?ため?できません。"),
    確定不可(20, "最新の取得日として登録できません。:(?)\"");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBZE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

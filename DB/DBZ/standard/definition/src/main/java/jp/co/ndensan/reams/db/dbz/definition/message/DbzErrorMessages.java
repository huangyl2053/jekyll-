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

    必須項目を入力(1, "必須項目を入力してください。"),
    必須項目を入力_追加メッセージあり(2, "必須項目を入力してください。:?"),
    入力値が不正(3, "入力値が不正です。"),
    入力値が不正_追加メッセージあり(4, "入力値が不正です。:?"),
    不正(5, "?が不正です。"),
    既に存在(6, "?が既に存在します。"),
    終了日が開始日以前(7, "終了日が開始日以前の日付です。"),
    終了日設定なし(8, "終了日が設定されていません。"),
    期間が不正(9, "期間が不正です。"),
    期間が重複(10, "期間が重複しています。"),
    期間が不正_追加メッセージあり１(11, "期間が不正です。終了日（?）－開始日（?）"),
    期間が不正_追加メッセージあり２(12, "期間が不正です。?－?"),
    大小関係が不正(13, "大小関係が不正です。(?)"),
    コードマスタなし(14, "コードマスタがありません。"),
    使用不可文字(15, "使用できない文字が含まれています。"),
    全角文字で入力(16, "全角文字で入力してください。"),
    半角文字で入力(17, "半角文字で入力してください。"),
    対象者が存在しない(18, "指定された条件に該当する対象者が存在しません。"),
    データが存在しない(19, "指定された条件に該当するデータが存在しません。"),
    検索キーの誤り(20, "検索キーの指定に誤りがあります。"),
    対象データなし(21, "対象のデータがありません。"),
    対象データなし_追加メッセージあり(22, "対象のデータがありません。:?"),
    対象者を選択(23, "対象者を選択してください。"),
    対象行を選択(24, "対象の行を選択してください。"),
    選択されていない(25, "?が選択されていません。"),
    選択行が不正(26, "選択行は不正です。"),
    他のユーザーが使用中(27, "他のユーザーが使用中です。"),
    バッチ実行中で更新不可(28, "更新系バッチ処理中のため、更新処理を実行できません。"),
    更新処理を中止(29, "他の端末で対象のデータが変更されているため、更新処理を中止します。"),
    編集なしで更新不可(30, "編集されていないため、更新できません。"),
    保存データなし(31, "保存するデータがありません。"),
    異常終了(32, "異常終了しました。"),
    更新に失敗(33, "?更新に失敗しました。"),
    対象ファイルが存在しない(34, "対象のファイルは存在していません。：?"),
    指定ファイルが存在しない(35, "指定されたファイルは存在しません。：?"),
    ファイル名取得エラー(36, "テキストファイル・ファイル名取得エラー"),
    ファイルOPENエラー(37, "テキストファイルＯＰＥＮエラー(?)"),
    ファイルREADエラー(38, "テキストファイルＲＥＡＤエラー(?)"),
    ファイルCLOSEエラー(39, "テキストファイルＣＬＯＳＥエラー(?)"),
    ファイルFETCHエラー(40, "テキストファイルＦＥＴＣＨエラー(?)"),
    ファイルWRITEエラー(41, "テキストファイルＷＲＩＴＥエラー(?)"),
    出力順序を指定(42, "出力順序を指定してください。"),
    出力項目を指定(43, "出力項目を指定してください。"),
    確定不可(44, "最新の取得日として登録できません。:(?)    "),
    指定数誤り(45, "?の数が不正です。?してください。"),
    実行不可(46, "?ため?できません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("E", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

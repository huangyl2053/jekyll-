/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * DBCの警告メッセージ定義列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum DbcWarningMessages implements IMessageGettable {

    申請書提出期限未入力(1, "申請書提出期限が設定されていません。処理を実行してよろしいですか？"),
    自動償還確認(2, "自動償還分は　決定年月日?で決定登録されます。よろしいですか？"),
    住宅改修限度額確認(3, "登録された住宅改修明細の合計改修費は住宅改修限度額を超えています。金額を修正しますか？"),
    日数３０日超過(4, "?～?間の日数が30日を超える。"),
    自己負担被保険者期間外(5, "被保険者期間外の月に自己負担額が設定されていますが、更新してよろしいですか？"),
    対象年対象計算期間終了不整合(6, "対象年度の翌年と対象計算期間（終了）の年度が同年ではありません。よろしいですか？"),
    自己負担未確定(7, "自己負担額情報が確定されていません。更新してもよろしいですか？"),
    高額合算補正関連１(8, "選択されたデータは直近情報ではありません。修正を行いますか？"),
    高額合算補正関連２(9, "選択されたデータは直近情報ではなく、送付対象とはなりません。修正を行いますか？"),
    高額合算補正関連３(10, "選択されたデータは既に送付済みです。修正を行いますか？"),
    高額合算補正前コピー(11, "補正後のデータは補正前のデータに上書きされます。よろしいですか？"),
    高額合算申請書情報の再計算前(12, "再計算前ですが、この印刷を行いますか？"),
    発行済み負担額証明書(13, "この帳票は発行済みです。この印刷を行いますか？"),
    福祉用具限度額確認(14, "登録された福祉用具購入費明細の合計購入費は福祉用具購入費の限度額を超えています。金額を修正しますか？"),
    限度余裕確認(15, "種類限度基準超過にサービス単位が割り振られていますが、限度額に余裕があります。この設定でよろしいですか？"),
    給付率修正確認(16, "当該被保険者の利用者負担割合は「?」割（給付率 & viewState.給付率 & %）です。<br>このまま設定された給付率で確定してよろしいですか？"),
    高額合算支給決定通知書発行済(17, "すでに発行済みですが、この印刷をおこないますか？"),
    異動連絡票_新規登録確認(18, "過去に「新規」で登録したデータが存在します。異動区分はよろしいですか？"),
    高額合算支給決定通知書全件処理確認(19, "終了日以前の記録データ全てを発行してもよろしいですか？"),
    受取年月指定かつ再処理時_登録済みデータ削除確認(20, "再処理を行うと現在登録されている決定情報はすべて削除されますが、よろしいですか？"),
    二号滞納状況確認(21, "＜介護保険料の滞納状況＞<br>"
            + "該当被保険者は第２号被保険者であるため、介護保険料の滞納状況を確認することができません。<br>"
            + "発行してよろしいですか？"),
    高額合算支給額計算結果削除確認_支給決定情報あり(22, "この申請に対する支給（不支給）決定情報が存在しますが、計算結果を削除してよろしいですか？"),
    高額合算支給額計算結果登録(23, "同じ自己負担額証明書整理番号が内訳一覧に存在しますが、、確定してよろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbcWarningMessages(int no, String message) {
        this.message = new WarningMessage(toCode("DBCW", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

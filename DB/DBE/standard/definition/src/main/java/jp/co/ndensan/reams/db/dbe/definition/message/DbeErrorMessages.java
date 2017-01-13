/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBEのエラーメッセージ定義列挙型です。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public enum DbeErrorMessages implements IMessageGettable {

    合議体長副合議体長は一人づつ(1, "合議体長および副合議体長は一人づつしか選択できません"),
    割当審査員は少なくとも5人(2, "割当審査員は少なくとも5人を選択してください"),
    終了日が開始日以前(3, "終了日が開始日より前です。"),
    重複の合議体が入力(4, "重複の合議体が入力されています。"),
    開催予定情報が未登録の為予定中止不可(5, "開催予定情報が登録されていませんので予定中止はできません。"),
    予定中止不可(6, "選択された審査会予定の状況が「中止または完了」のために予定中止はできません。"),
    週コピー不可(7, "週コピー開始日以降に開催予定がありますので週コピーできません。"),
    審査会委員割付不可(8, "開催予定情報が登録されていませんので審査会委員割付ができません。"),
    既に開催結果が作成済で審査会委員割付不可(9, "既に開催結果が作成されていますので審査会委員割付はできません。"),
    合議体委員数が最大値を超過(10, "合議体委員数が最大値を超えています。"),
    予約状況は仮予約または確定(11, "申請者予約があるので予約状況は仮予約または確定にしてください。"),
    申請者未指定なので予約状況は未定申請者を指定(12, "申請者未指定なので予約状況は未定にしてください。または申請者を指定してください。"),
    簡易割付不可(13, "割付人数が予定人数以上ですので簡易割付できません。"),
    介護認定審査会は複数選択不可(14, "介護認定審査会は複数選択できません。"),
    審査会委員構成一覧は少なくとも5人(15, "審査会委員構成一覧は少なくとも5人を選択してください。"),
    欠席の設定不可(16, "議長のため”欠席”の設定ができません。"),
    連番最大値を超過(17, "連番最大値を超過しています。"),
    特記事項番号が追加不可(18, "既存未入力特記事項があるので特記事項番号が追加できません。"),
    新規未入力特記事項が有で新ページが追加不可(19, "新規未入力特記事項があるので新ページが追加できません。"),
    割付可能人数は0です_割付不可(20, "割付可能人数は0です。割付できません。"),
    複数選択不可(21, "?は複数選択できません。"),
    選択必須(22, "?を選択してください。"),
    審査会開催最大数を超過(23, "審査会開催最大数を超過しています。"),
    審査会の合議体長は必ず１人(24, "審査会の合議体長は必ず１人です。"),
    超過(25, "?が?を超過しています。"),
    結果データが多いので検索条件を強化(26, "結果データが多いので検索条件を強化してください。"),
    他の情報で使用している為削除不可(27, "他の情報で使用している為削除できません。"),
    スケジュール照会のため保存不可(28, "スケジュール照会のため保存できません。"),
    印刷不可(29, "?が同意していない為印刷できません。"),
    審査会開催済み(30, "既に審査会が開催済みです。"),
    一次判定実行不可(31, "一次判定が実行できません。"),
    帳票印刷不可(32, "?のため印刷できません。"),
    _1_5次判定実行不可(33, "1.5次判定が実行できません。"),
    同一項番で同一枝番は不可(34, "同一項番で同一枝番が登録できません、その他枝番を指定してください。"),
    項番が存在しない(35, "指定されたし特記事項番号は存在しません。"),
    特記数超過(36, "1特記事項番号に対して最大9個の特記。"),
    割付済申請者未指定(37, "割付済申請者が未指定です。"),
    認定調査依頼未割付(38, "認定調査依頼未割付の申請者が選択されています。"),
    一次判定失敗(39, "一次判定処理に失敗しました。"),
    一次判定未処理(40, "一次判定処理を実行していません。"),
    一次判定実行不可_申請日(41, "一次判定が実行できません。選択した項目の申請日を確認してください。"),
    委託先未設定(42, "認定調査委託先が未設定の申請者が選択されています。"),
    委託先もしくは保険者が同一ではない(43, "?が同一の申請者を選択してください。"),
    審査会割付不可(45, "既に割付済ですので、割付不可です。"),
    特記事項追加削除不可(46, "特記事項を?する場合、同一の特記事項番号の中で、\r\n枝番が?のものから?してください。"),
    申請日不正_照会不可(47, "Reamsへの切替日を基準に照会可能期間が設定されています。申請日に?以前は指定できません。"),
    審査委員コードエラー(49, "指定された審査委員が登録されていません。"),
    提出期限が発行日以前(50, "提出期限には発行日の翌日以降の日付を指定してください。"),
    介護認定審査会開催場所削除不可(51, "開催場所?は他の情報で使用している為削除できません。"),
    割付済審査会中止不可(52, "割付済の審査会は中止できません。"),
    割付済審査会中止不可(53, "割付済の審査会は中止できません。"),
    二次判定が既に行われている要介護認定申請情報です(54, "二次判定が既に行われている要介護認定申請情報です。"),
    申請取下時は取下日理由を入力してください(55, "申請取下時は、取下日・理由を入力してください。"),
    申請サービス削除と取下理由は同時に入力できません(56, "申請サービス削除と取下理由は、同時に入力できません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbeErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBEE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}

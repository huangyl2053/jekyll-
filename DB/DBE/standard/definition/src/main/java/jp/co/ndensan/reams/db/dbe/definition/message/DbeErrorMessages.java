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
 * @author N9606 漢那 憲作
 */
public enum DbeErrorMessages implements IMessageGettable {

    合議体長副合議体長は一人づつ(1, "合議体長、副合議体長は一人づつしか選択できません"),
    割当審査員は少なくとも5人(2, "割当審査員は少なくとも5人を選択してください"),
    終了日が開始日以前(3, "終了日が開始日以前です。"),
    重複の合議体が入力(4, "重複の合議体が入力されています：?"),
    開催予定情報が未登録予定中止不可(5, "開催予定情報が登録されていませんので、予定中止はできません。"),
    審査会予定の状況が中止完了予定中止不可(6, "選択された審査会予定の状況が「中止・完了」のため、予定中止はできません。"),
    週コピー不可(7, "週コピー開始日以降に開催予定がありますので、週コピーできません。"),
    審査会委員割付不可(8, "開催予定情報が登録されていませんので、審査会委員割付ができません。"),
    既に開催結果が作成審査会委員割付不可(9, "既に開催結果が作成されていますので、審査会委員割付はできません。"),
    合議体委員数が最大値を超過(10, "合議体委員数が最大値を超えています。"),
    予約状況は仮予約または確定(11, "申請者予約があるので、予約状況は仮予約または確定にしてください。"),
    申請者未指定なので予約状況は未定申請者を指定(12, "申請者未指定なので、予約状況は未定にしてください。または、申請者を指定してください。"),
    簡易割付不可(13, "割付人数が予定人数以上ですので、簡易割付できません。"),
    介護認定審査会は複数選択不可(14, "介護認定審査会は複数選択できません。"),
    審査会委員構成一覧は少なくとも5人(15, "審査会委員構成一覧は少なくとも5人を選択してください。"),
    議長のため欠席の設定不可(16, "議長のため、”欠席”の設定ができません。"),
    連番最大値を超過(17, "連番最大値を超過しています。"),
    特記事項番号が追加不可(18, "既存未入力特記事項があるので、特記事項番号が追加できません。"),
    新規未入力特記事項が有新ページが追加不可(19, "新規未入力特記事項があるので、新ページが追加できません。"),
    割付可能人数は0です割付不可(20, "割付可能人数は0です、割付できません。"),
    は複数選択不可(21, "?は複数選択できません。"),
    を選択してください(22, "?を選択してください。"),
    審査会開催最大数を超過(23, "審査会開催最大数を超過しています。"),
    審査会の合議体長は必ず１人(24, "審査会の合議体長は必ず１人です。"),
    がを超過(25, "？が？を超過しています。"),
    結果データが多いので検索条件を強化(26, "結果データが多いので、検索条件を強化してください。"),
    他の情報で使用している為削除不可(27, "他の情報で使用している為、削除できません。"),
    スケジュール照会のため保存不可(28, "スケジュール照会のため、保存できません。"),
    が同意していない為印刷不可(29, "？が同意していない為、印刷できません。");

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

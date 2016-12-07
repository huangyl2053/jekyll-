/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * DBEの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public enum DbeQuestionMessages implements IMessageGettable {

    認定調査完了申請者ですが割付解除(1, "認定調査完了申請者ですが割付解除を行いますか？"),
    クリア確認(2, "?をクリアします。よろしいですか。？"),
    調査員は予約不可なので該当申請が解除(3, "調査員は予約不可なので該当申請が解除されます。よろしいですか。？"),
    調査員は予約不可です(4, "調査員は予約不可です。よろしいですか。？"),
    申請者予約状況は仮予約です(5, "申請者予約状況は仮予約です。よろしいですか？"),
    申請者予約状況は確定です(6, "申請者予約状況は確定です。よろしいですか。？"),
    予約未定かつ申請者が未指定です(7, "予約未定かつ申請者が未指定です。よろしいですか。？"),
    すでに予約済みです_上書保存(8, "すでに予約済みです。上書保存してよろしいですか。？"),
    二次判定結果が決定していませんが印刷(9, "二次判定結果が決定していませんが印刷しますか？"),
    予約を上書保存(10, "予約を上書保存してよろしいですか。？"),
    処理日より過去のスケジュールを変更(12, "処理日より過去のスケジュールを変更します。よろしいですか？"),
    対象データが多いので処理時間が掛ります(13, "対象データが多いので処理時間が掛りますがよろしいですか？"),
    マージン確認(14, "指定プリンタで以前に設定したマージン、もしくは他端末で設定してある一般的なマージンを画面にセットします。よろしいですか？"),
    選択した一次判定データ完了確認(15, "選択した一次判定を完了します。よろしいですか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbeQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBEQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

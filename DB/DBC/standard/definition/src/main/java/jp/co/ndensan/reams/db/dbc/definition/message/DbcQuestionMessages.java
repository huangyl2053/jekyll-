/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;

/**
 * DBCの質問メッセージ定義列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum DbcQuestionMessages implements IMessageGettable {

    要介護状態区分変更_限度額リセット対象(1, "要介護状態区分3段階変更による限度額リセット対象です。"
            + "「要介護状態区分3段階変更による」をチェックしてよろしいですか？"),
    要介護状態区分変更_限度額リセット対象外(2, "要介護状態区分3段階変更による限度額リセット対象外です。｢要介護状態区分3段階変更による｣をチェックしないでよろしいですか？"),
    改修住所変更_限度額リセット対象(3, "改修住所変更による限度額リセット対象です。｢住宅住所変更による｣をチェックしてよろしいですか？"),
    改修住所変更_限度額リセット対象外(4, "改修住所変更による限度額リセット対象外です。｢住宅住所変更による｣をチェックしないでよろしいですか？"),
    限度額変更確認(5, "住宅改修情報が変更されています。限度額の確認はよろしいですか？"),
    領収日不一致_提供年月変更確認(6, "領収日が提供（着工）年月と一致しません。提供（着工）年月を?に変更します。よろしいですか？"),
    旧措置者_保存確認(7, "該当保険者が旧措置者です。申請内容を保存してよろしいですか？"),
    高額合算支給申請検索_処理不可(8, "指定されたデータは\"未計算\"または\"取下げ\"状態にあるため、<br>更新処理ができません。指定したデータを照会モードで参照しますか？"),
    高額合算支給申請検索_訂正(9, "送信済みのデータです。<br>処理を継続しますか？");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbcQuestionMessages(int no, String message) {
        this.message = new QuestionMessage(toCode("DBCQ", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

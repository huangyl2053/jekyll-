/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message;

import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBCのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbcErrorMessages implements IMessageGettable {

    対象年月被保険者データなし(1, "対象年月時点で被保険者ではありません。"),
    設定不能状態への変更(2, "設定不能な処理状況に変更されたため登録できません。"),
    高額判定_処理状態処理前数不正(3, "処理状態が処理前または再処理前である処理年月が２件以上存在します。"),
    処理状態処理前未設定(4, "処理状態が処理前または再処理前である処理年月が存在しません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbcErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("E", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}

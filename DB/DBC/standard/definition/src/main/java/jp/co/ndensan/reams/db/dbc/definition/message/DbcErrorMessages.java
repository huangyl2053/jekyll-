/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBCのエラーメッセージ定義列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum DbcErrorMessages implements IMessageGettable {

    対象年月被保険者データなし(1, "対象年月時点で被保険者ではありません。"),
    設定不能状態への変更(2, "設定不能な処理状況に変更されたため登録できません。"),
    高額判定_処理状態処理前数不正(3, "処理状態が処理前または再処理前である処理年月が２件以上存在します。"),
    処理状態処理前未設定(4, "処理状態が処理前または再処理前である処理年月が存在しません。"),
    給付実績複数件取得(5, "対象の給付実績情報が複数件取得されました。"),
    未審査有りで保存不可(6, "未審査のデータがあるのため保存できません。"),
    サービス年月と不一致(7, "?にはサービス年月と同月を指定してください。"),
    住宅改修データなし(8, "住宅改修データがありません。"),
    着工日不一致(9, "着工日には同一の年月を設定してください。"),
    対象住宅住所不一致(10, "対象住宅住所には同じ住所を設定してください。"),
    被保険者の高額介護サービス支給申請情報が無い(12, "指定した被保険者の、高額介護サービス支給申請情報がありません。"),
    要介護状態_事前申請不可(13, "要介護状態になっていないため、事前申請できません。"),
    高額合算支給申請検索_処理不可(14, "?は?より未来の日付を設定できません。"),
    年月と不一致(15, "?は?と同月を指定してください。"),
    計画単位数不一致(17, "限度額対象単位および限度額対象外単位数が計画単位数と一致しません。"),
    サービス種類が登録済(18, "サービス種類が登録されています。"),
    受給者登録なし(37, "受給者として登録されていないため、この処理はできません。"),
    実行不可(19, "?ため?できません。");

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

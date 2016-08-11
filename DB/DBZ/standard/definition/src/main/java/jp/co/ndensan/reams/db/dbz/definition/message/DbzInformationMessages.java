/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBZのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum DbzInformationMessages implements IMessageGettable {

    不整合解消済み(1, "不整合はすでに解消されています。"),
    不整合内容相違(2, "以前と不整合の内容が異なります。以前：? 現在：?"),
    内容変更なしで保存不可(3, "内容が変更されていないため、保存はできません。"),
    最大表示件数超過(4, "最大表示件数を超過しました。表示されていないデータがあります。"),
    保存処理完了(5, "?の保存処理が完了しました。"),
    資格取得済み(6, "対象者は資格取得中のため処理できません。"),
    適用除外者登録済み(7, "対象者は適用除外者のため処理できません。"),
    他特例者登録済み(8, "対象者は他市町村住所地特例者のため処理できません。"),
    資格喪失済み(9, "対象者は資格喪失済みのため処理できません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbzInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("DBZI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

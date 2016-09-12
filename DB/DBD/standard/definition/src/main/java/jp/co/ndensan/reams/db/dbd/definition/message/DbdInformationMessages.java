/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBDのインフォメーションメッセージ定義列挙型です。
 *
 * @reamsid_L DBD-9999-023 liangbc
 */
public enum DbdInformationMessages implements IMessageGettable {

    減免減額_承認処理済みのため削除不可(1, "すでに承認処理が行われているため、削除できません。"),
    配偶者_取得失敗(2, "配偶者の情報が取得できませんでした。"),
    配偶者_所得_取得失敗(3, "配偶者の所得情報が取得できませんでした。"),
    減免減額_申請情報なし(4, "申請情報が見つかりませんでした。"),
    受給共通_被保データなし(5, "被保険者としての資格データが存在しません。"),
    受給照会_履歴なし(6, "受給者の履歴情報が見つかりませんでした。"),
    非課税年金情報なし(7, "非課税年金情報が見つかりませんでした。"),
    減免減額_発行可能通知書_認定証なし(8, "発行できる通知書・認定証はありません。"),
    調定年度が2016以前(9, "平成28年度以降の事務処理です。平成28年度に年度切替された後に実施してください。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("DBDI", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

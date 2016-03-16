/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.message;

import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.InformationMessage;
import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;

/**
 * DBDのインフォメーションメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbdInformationMessages implements IMessageGettable {

    減免減額_承認処理済みのため削除不可(1, "すでに承認処理が行われているため、削除できません。"),
    配偶者_取得失敗(2, "配偶者の情報が取得できませんでした。"),
    配偶者_所得_取得失敗(3, "配偶者の所得情報が取得できませんでした。"),
    減免減額_申請情報なし(4, "申請情報が見つかりませんでした。"),
    受給共通_被保データなし(5, "被保険者としての資格データが存在しません。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbdInformationMessages(int no, String message) {
        this.message = new InformationMessage(toCode("I", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }
}

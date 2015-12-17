/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.message;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.message.ErrorMessage;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;

/**
 * DBAのエラーメッセージ定義列挙型です。
 *
 * @author N9606 漢那 憲作
 */
public enum DbaErrorMessages implements IMessageGettable {

    最新資格情報追加不可(1, "最新の資格情報として追加することはできません。"),
    最新住所地特例情報追加不可(2, "最新の住所地特例情報として追加することはできません。"),
    最新資格変更情報追加不可(3, "最新の資格変更情報として追加することはできません。"),
    住所地特例適用対象者でない(4, "住所地特例の適用対象者ではありません"),
    住所地特例として適用済(5, "住所地特例として適用されています。"),
    住所地特例として未適用(6, "住所地特例として適用されていません。"),
    被保険者履歴に期間重複(7, "被保険者履歴に期間の重複があります。"),
    他の期間情報との期間重複(8, "他の期間情報と期間の重複があります。");

    private final Message message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private DbaErrorMessages(int no, String message) {
        this.message = new ErrorMessage(toCode("DBAE", no), message);
    }

    @Override
    public Message getMessage() {
        return message;
    }

}

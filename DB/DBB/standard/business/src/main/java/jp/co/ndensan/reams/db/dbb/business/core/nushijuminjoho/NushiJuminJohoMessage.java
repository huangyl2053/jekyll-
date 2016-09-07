/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.nushijuminjoho;

import static jp.co.ndensan.reams.db.dbz.definition.message.MessageCreateHelper.toCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.ButtonSelectPattern;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.message.WarningMessage;

/**
 * 所得照会票作成のMessageのクラスです。
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public enum NushiJuminJohoMessage implements IMessageGettable {

    /**
     * 確認
     */
    確認(1, "?よろしいですか？"),
    /**
     * 登録確認
     */
    登録確認(2, "所得データが既に登録されています。所得照会票を発行すると所得データが所得調査中に変更されますがよろしいですか？識別コード＝?");

    private final RString code;
    private final RString message;

    /**
     * コンストラクタです。
     *
     * @param no 番号
     * @param message メッセージ
     */
    private NushiJuminJohoMessage(int no, String message) {
        code = new RString(toCode("DBZW", no));
        this.message = new RString(message);
    }

    /**
     * 質問メッセージを取得します。
     *
     * @return メッセージ
     * @deprecated 毎回インスタンスを生成して返すように変更したのでメソッド名はcreateMessageの方が適切です。createMessageを使用願います。
     */
    @Override
    public Message getMessage() {
        return createMessage();
    }

    /**
     * 質問メッセージを取得します。
     *
     * @return メッセージ
     */
    public Message createMessage() {
        return new WarningMessage(code.toString(), message.toString());
    }

    /**
     * 質問メッセージを取得します。
     *
     * @param btnPattern ButtonSelectPattern
     * @param replaces replaces
     * @return メッセージ
     */
    public Message createMessage(ButtonSelectPattern btnPattern, String... replaces) {
        Message sup = new WarningMessage(code.toString(), message.toString()).replace(replaces);
        return new WarningMessage(sup.getCode(), sup.evaluate(), btnPattern);
    }

    /**
     * 質問メッセージのコードを取得します
     *
     * @return 質問メッセージのコード
     */
    public RString getCode() {
        return this.code;
    }
}

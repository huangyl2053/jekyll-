package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 予約状況を表す列挙型です。
 *
 * @author LDNS
 */
public enum YoyakuJokyo {

    /**
     * コード:0 名称:未定 略称:定義なし
     */
    未定("0", "未定"),
    /**
     * コード:1 名称:仮予約 略称:定義なし
     */
    仮予約("1", "仮予約"),
    /**
     * コード:2 名称:確定 略称:定義なし
     */
    確定("2", "確定");

    private final RString code;
    private final RString fullName;

    private YoyakuJokyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 予約状況のコードを返します。
     *
     * @return 予約状況のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 予約状況の名称を返します。
     *
     * @return 予約状況の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 予約状況のコードと一致する内容を探します。
     *
     * @param code 予約状況のコード
     * @return {@code code} に対応する予約状況
     */
    public static YoyakuJokyo toValue(RString code) {

        for (YoyakuJokyo yoyakuJokyo : YoyakuJokyo.values()) {
            if (yoyakuJokyo.code.equals(code)) {
                return yoyakuJokyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("予約状況"));
    }
}

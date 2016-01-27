package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 自動割当除外者区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum JidoWariateJyogaishaKubun {

    /**
     * コード:1 名称:対象 略称:定義なし
     */
    対象("1", "対象"),
    /**
     * コード:2 名称:除外 略称:定義なし
     */
    除外("2", "除外");

    private final RString code;
    private final RString fullName;

    private JidoWariateJyogaishaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 自動割当除外者区分のコードを返します。
     *
     * @return 自動割当除外者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 自動割当除外者区分の名称を返します。
     *
     * @return 自動割当除外者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 自動割当除外者区分のコードと一致する内容を探します。
     *
     * @param code 自動割当除外者区分のコード
     * @return {@code code} に対応する自動割当除外者区分
     */
    public static JidoWariateJyogaishaKubun toValue(RString code) {

        for (JidoWariateJyogaishaKubun jidoWariateJyogaishaKubun : JidoWariateJyogaishaKubun.values()) {
            if (jidoWariateJyogaishaKubun.code.equals(code)) {
                return jidoWariateJyogaishaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("自動割当除外者区分"));
    }
}

package jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置者区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KyuSochishaKubun {

    /**
     * コード:0 名称:空白 略称:定義なし
     */
    空白("0", "空白"),
    /**
     * コード:1 名称:旧措置 略称:定義なし
     */
    旧措置("1", "旧措置"),
    /**
     * コード:2 名称:負担段階 略称:定義なし
     */
    負担段階("2", "負担段階");

    private final RString code;
    private final RString fullName;

    private KyuSochishaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置者区分のコードを返します。
     *
     * @return 旧措置者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 旧措置者区分の名称を返します。
     *
     * @return 旧措置者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置者区分のコードと一致する内容を探します。
     *
     * @param code 旧措置者区分のコード
     * @return {@code code} に対応する旧措置者区分
     */
    public static KyuSochishaKubun toValue(RString code) {

        for (KyuSochishaKubun kyuSochishaKubun : KyuSochishaKubun.values()) {
            if (kyuSochishaKubun.code.equals(code)) {
                return kyuSochishaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置者区分"));
    }
}

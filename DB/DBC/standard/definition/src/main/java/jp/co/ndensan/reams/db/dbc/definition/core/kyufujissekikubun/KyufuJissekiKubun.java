package jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KyufuJissekiKubun {

    /**
     * コード:1 名称:現物 略称:定義なし
     */
    現物("1", "現物"),
    /**
     * コード:2 名称:償還 略称:定義なし
     */
    償還("2", "償還");

    private final RString code;
    private final RString fullName;

    private KyufuJissekiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付実績区分のコードを返します。
     *
     * @return 給付実績区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付実績区分の名称を返します。
     *
     * @return 給付実績区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付実績区分のコードと一致する内容を探します。
     *
     * @param code 給付実績区分のコード
     * @return {@code code} に対応する給付実績区分
     */
    public static KyufuJissekiKubun toValue(RString code) {

        for (KyufuJissekiKubun kyufuJissekiKubun : KyufuJissekiKubun.values()) {
            if (kyufuJissekiKubun.code.equals(code)) {
                return kyufuJissekiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付実績区分"));
    }
}

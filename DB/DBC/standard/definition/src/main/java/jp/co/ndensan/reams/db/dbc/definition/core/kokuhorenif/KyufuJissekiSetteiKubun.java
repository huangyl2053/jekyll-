package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績設定区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KyufuJissekiSetteiKubun {

    /**
     * コード:0 名称:設定不可 略称:定義なし
     */
    設定不可("0", "設定不可"),
    /**
     * コード:1 名称:設定可（必須） 略称:定義なし
     */
    必須("1", "設定可（必須）"),
    /**
     * コード:2 名称:設定可（任意） 略称:定義なし
     */
    任意("2", "設定可（任意）");

    private final RString code;
    private final RString fullName;

    private KyufuJissekiSetteiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 給付実績設定区分のコードを返します。
     *
     * @return 給付実績設定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 給付実績設定区分の名称を返します。
     *
     * @return 給付実績設定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 給付実績設定区分のコードと一致する内容を探します。
     *
     * @param code 給付実績設定区分のコード
     * @return {@code code} に対応する給付実績設定区分
     */
    public static KyufuJissekiSetteiKubun toValue(RString code) {
        for (KyufuJissekiSetteiKubun kyufuJissekiSetteiKubun : KyufuJissekiSetteiKubun.values()) {
            if (kyufuJissekiSetteiKubun.code.equals(code)) {
                return kyufuJissekiSetteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("給付実績設定区分"));
    }
}

package jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給不支給区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShikyuFushikyuKubun {

    /**
     * コード:0 名称:不支給 略称:定義なし
     */
    不支給("0", "不支給"),
    /**
     * コード:1 名称:支給 略称:定義なし
     */
    支給("1", "支給");

    private final RString code;
    private final RString fullName;

    private ShikyuFushikyuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支給不支給区分のコードを返します。
     *
     * @return 支給不支給区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支給不支給区分の名称を返します。
     *
     * @return 支給不支給区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支給不支給区分のコードと一致する内容を探します。
     *
     * @param code 支給不支給区分のコード
     * @return {@code code} に対応する支給不支給区分
     */
    public static ShikyuFushikyuKubun toValue(RString code) {

        for (ShikyuFushikyuKubun shikyuFushikyuKubun : ShikyuFushikyuKubun.values()) {
            if (shikyuFushikyuKubun.code.equals(code)) {
                return shikyuFushikyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支給不支給区分"));
    }
}

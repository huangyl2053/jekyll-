package jp.co.ndensan.reams.db.dbc.definition.core.riyoshafutandankai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担段階を表す列挙型です。
 *
 * @author LDNS
 */
public enum RiyoshaFutanDankai {

    /**
     * コード:0 名称:第1段階 略称:定義なし
     */
    第1段階("0", "第1段階"),
    /**
     * コード:1 名称:第2段階 略称:定義なし
     */
    第2段階("1", "第2段階"),
    /**
     * コード:2 名称:第3段階 略称:定義なし
     */
    第3段階("2", "第3段階"),
    /**
     * コード:3 名称:課税層第3段階 略称:定義なし
     */
    課税層第3段階("3", "課税層第3段階");

    private final RString code;
    private final RString fullName;

    private RiyoshaFutanDankai(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用者負担段階のコードを返します。
     *
     * @return 利用者負担段階のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用者負担段階の名称を返します。
     *
     * @return 利用者負担段階の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用者負担段階のコードと一致する内容を探します。
     *
     * @param code 利用者負担段階のコード
     * @return {@code code} に対応する利用者負担段階
     */
    public static RiyoshaFutanDankai toValue(RString code) {

        for (RiyoshaFutanDankai riyoshaFutanDankai : RiyoshaFutanDankai.values()) {
            if (riyoshaFutanDankai.code.equals(code)) {
                return riyoshaFutanDankai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用者負担段階"));
    }
}

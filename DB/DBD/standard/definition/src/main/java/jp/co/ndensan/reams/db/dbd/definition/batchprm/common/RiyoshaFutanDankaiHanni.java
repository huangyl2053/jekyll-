package jp.co.ndensan.reams.db.dbd.definition.batchprm.common;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担段階範囲を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum RiyoshaFutanDankaiHanni {

    /**
     * コード:0 名称:利用者負担1から3段階 略称:定義なし
     */
    利用者負担1から3段階("0", "利用者負担1から3段階"),
    /**
     * コード:1 名称:利用者負担1段階 略称:定義なし
     */
    利用者負担1段階("1", "利用者負担1段階"),
    /**
     * コード:2 名称:利用者負担2段階 略称:定義なし
     */
    利用者負担2段階("2", "利用者負担2段階"),
    /**
     * コード:3 名称:利用者負担3段階 略称:定義なし
     */
    利用者負担3段階("3", "利用者負担3段階"),
    /**
     * コード:4 名称:利用者負担4段階_高齢者複数世帯 略称:定義なし
     */
    利用者負担4段階_高齢者複数世帯("4", "利用者負担4段階（高齢者複数世帯） ");

    private final RString code;
    private final RString fullName;

    private RiyoshaFutanDankaiHanni(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 利用者負担段階範囲のコードを返します。
     *
     * @return 利用者負担段階範囲のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用者負担段階範囲の名称を返します。
     *
     * @return 利用者負担段階範囲の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用者負担段階範囲のコードと一致する内容を探します。
     *
     * @param code 利用者負担段階範囲のコード
     * @return {@code code} に対応する利用者負担段階範囲
     */
    public static RiyoshaFutanDankaiHanni toValue(RString code) {
        for (RiyoshaFutanDankaiHanni riyoshaFutanDankaiHanni : RiyoshaFutanDankaiHanni.values()) {
            if (riyoshaFutanDankaiHanni.code.equals(code)) {
                return riyoshaFutanDankaiHanni;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用者負担段階範囲"));
    }

    /**
     * 利用者負担段階範囲の名称と一致する内容を探します。
     *
     * @param name 利用者負担段階範囲の名称
     * @return {@code name} に対応する利用者負担段階範囲
     */
    public static RiyoshaFutanDankaiHanni nameToValue(RString name) {
        for (RiyoshaFutanDankaiHanni riyoshaFutanDankaiHanni : RiyoshaFutanDankaiHanni.values()) {
            if (riyoshaFutanDankaiHanni.fullName.equals(name)) {
                return riyoshaFutanDankaiHanni;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("利用者負担段階範囲"));
    }
}

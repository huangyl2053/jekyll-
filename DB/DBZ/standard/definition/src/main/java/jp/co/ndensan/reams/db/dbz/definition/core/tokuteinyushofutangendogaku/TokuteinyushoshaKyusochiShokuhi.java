package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_旧措置食費を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaKyusochiShokuhi {

    /**
     * コード:1 名称:300
     */
    特定入所者負担限度額_旧措置食費１("1", "300"),
    /**
     * コード:2 名称:390
     */
    特定入所者負担限度額_旧措置食費２("2", "390"),
    /**
     * コード:3 名称:650
     */
    特定入所者負担限度額_旧措置食費３("3", "650");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaKyusochiShokuhi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);

    }

    /**
     * 特定入所者負担限度額_旧措置食費のコードを返します。
     *
     * @return 特定入所者負担限度額_旧措置食費のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_旧措置食費の名称を返します。
     *
     * @return 特定入所者負担限度額_旧措置食費の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_旧措置食費のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_旧措置食費のコード
     * @return {@code code} に対応する特定入所者負担限度額_旧措置食費
     */
    public static TokuteinyushoshaKyusochiShokuhi toValue(RString code) {
        for (TokuteinyushoshaKyusochiShokuhi value : TokuteinyushoshaKyusochiShokuhi.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_旧措置食費"));
    }
}

package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_旧措置多床室を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaKyusochiTashoshitsu {

    /**
     * コード:1 名称:0
     */
    特定入所者負担限度額_旧措置多床室１("1", "0"),
    /**
     * コード:2 名称:320
     */
    特定入所者負担限度額_旧措置多床室２("2", "320"),
    /**
     * コード:3 名称:320
     */
    特定入所者負担限度額_旧措置多床室３("3", "320");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaKyusochiTashoshitsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特定入所者負担限度額_旧措置多床室のコードを返します。
     *
     * @return 特定入所者負担限度額_旧措置多床室のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_旧措置多床室の名称を返します。
     *
     * @return 特定入所者負担限度額_旧措置多床室の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_旧措置多床室のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_旧措置多床室のコード
     * @return {@code code} に対応する特定入所者負担限度額_旧措置多床室
     */
    public static TokuteinyushoshaKyusochiTashoshitsu toValue(RString code) {
        for (TokuteinyushoshaKyusochiTashoshitsu value : TokuteinyushoshaKyusochiTashoshitsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_旧措置多床室"));
    }
}

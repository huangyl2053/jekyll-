package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_旧措置ユニット型準個室を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaKyusochiUnitTypeJunKoshitsu {

    /**
     * コード:1 名称:490
     */
    特定入所者負担限度額_旧措置ユニット型準個室１("1", "490"),
    /**
     * コード:2 名称:490
     */
    特定入所者負担限度額_旧措置ユニット型準個室２("2", "490"),
    /**
     * コード:3 名称:1310
     */
    特定入所者負担限度額_旧措置ユニット型準個室３("3", "1310");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaKyusochiUnitTypeJunKoshitsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);

    }

    /**
     * 特定入所者負担限度額_旧措置ユニット型準個室のコードを返します。
     *
     * @return 特定入所者負担限度額_旧措置ユニット型準個室のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_旧措置ユニット型準個室の名称を返します。
     *
     * @return 特定入所者負担限度額_旧措置ユニット型準個室の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_旧措置ユニット型準個室のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_旧措置ユニット型準個室のコード
     * @return {@code code} に対応する特定入所者負担限度額_旧措置ユニット型準個室
     */
    public static TokuteinyushoshaKyusochiUnitTypeJunKoshitsu toValue(RString code) {
        for (TokuteinyushoshaKyusochiUnitTypeJunKoshitsu value : TokuteinyushoshaKyusochiUnitTypeJunKoshitsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_旧措置ユニット型準個室"));
    }
}

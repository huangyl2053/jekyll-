package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_旧措置ユニット型個室を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaKyusochiUnitTypeKoshitsu {

    /**
     * コード:1 名称:820
     */
    特定入所者負担限度額_旧措置ユニット型個室１("1", "820"),
    /**
     * コード:2 名称:820
     */
    特定入所者負担限度額_旧措置ユニット型個室２("2", "820"),
    /**
     * コード:3 名称:1640
     */
    特定入所者負担限度額_旧措置ユニット型個室３("3", "1640");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaKyusochiUnitTypeKoshitsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特定入所者負担限度額_旧措置ユニット型個室のコードを返します。
     *
     * @return 特定入所者負担限度額_旧措置ユニット型個室のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_旧措置ユニット型個室の名称を返します。
     *
     * @return 特定入所者負担限度額_旧措置ユニット型個室の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_旧措置ユニット型個室のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_旧措置ユニット型個室のコード
     * @return {@code code} に対応する特定入所者負担限度額_旧措置ユニット型個室
     */
    public static TokuteinyushoshaKyusochiUnitTypeKoshitsu toValue(RString code) {
        for (TokuteinyushoshaKyusochiUnitTypeKoshitsu value : TokuteinyushoshaKyusochiUnitTypeKoshitsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_旧措置ユニット型個室"));
    }
}

package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_旧措軽減ユニット型準個室を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaKyusoKeigenUnitTypeJunKoshitsu {

    /**
     * コード:10 名称:0
     */
    特定入所者負担限度額_旧措軽減ユニット型準個室１("10", "0"),
    /**
     * コード:21 名称:490
     */
    特定入所者負担限度額_旧措軽減ユニット型準個室２の１("21", "490"),
    /**
     * コード:22 名称:0
     */
    特定入所者負担限度額_旧措軽減ユニット型準個室２の２("22", "0"),
    /**
     * コード:30 名称:0
     */
    特定入所者負担限度額_旧措軽減ユニット型準個室３("30", "0");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaKyusoKeigenUnitTypeJunKoshitsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);

    }

    /**
     * 特定入所者負担限度額_旧措軽減ユニット型準個室のコードを返します。
     *
     * @return 特定入所者負担限度額_旧措軽減ユニット型準個室のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_旧措軽減ユニット型準個室の名称を返します。
     *
     * @return 特定入所者負担限度額_旧措軽減ユニット型準個室の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_旧措軽減ユニット型準個室のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_旧措軽減ユニット型準個室のコード
     * @return {@code code} に対応する特定入所者負担限度額_旧措軽減ユニット型準個室
     */
    public static TokuteinyushoshaKyusoKeigenUnitTypeJunKoshitsu toValue(RString code) {
        for (TokuteinyushoshaKyusoKeigenUnitTypeJunKoshitsu value : TokuteinyushoshaKyusoKeigenUnitTypeJunKoshitsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_旧措軽減ユニット型準個室"));
    }
}

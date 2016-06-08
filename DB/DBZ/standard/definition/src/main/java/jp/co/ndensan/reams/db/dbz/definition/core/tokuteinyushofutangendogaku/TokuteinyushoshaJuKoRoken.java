package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_従個老健を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaJuKoRoken {

    /**
     * コード:1 名称:490
     */
    特定入所者負担限度額_従個老健１("1", "490"),
    /**
     * コード:2 名称:490
     */
    特定入所者負担限度額_従個老健２("2", "490"),
    /**
     * コード:3 名称:1310
     */
    特定入所者負担限度額_従個老健３("3", "1310");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaJuKoRoken(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);

    }

    /**
     * 特定入所者負担限度額_従個老健のコードを返します。
     *
     * @return 特定入所者負担限度額_従個老健のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_従個老健の名称を返します。
     *
     * @return 特定入所者負担限度額_従個老健の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_従個老健のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_従個老健のコード
     * @return {@code code} に対応する特定入所者負担限度額_従個老健
     */
    public static TokuteinyushoshaJuKoRoken toValue(RString code) {
        for (TokuteinyushoshaJuKoRoken tokuteinyushoshaJuKoRoken : TokuteinyushoshaJuKoRoken.values()) {
            if (tokuteinyushoshaJuKoRoken.code.equals(code)) {
                return tokuteinyushoshaJuKoRoken;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_従個老健"));
    }
}

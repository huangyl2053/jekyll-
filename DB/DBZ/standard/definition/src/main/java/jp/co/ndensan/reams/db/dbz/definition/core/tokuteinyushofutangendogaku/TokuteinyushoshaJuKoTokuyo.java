package jp.co.ndensan.reams.db.dbz.definition.core.tokuteinyushofutangendogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者負担限度額_従個特養を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 wangchao
 */
public enum TokuteinyushoshaJuKoTokuyo {

    /**
     * コード:1 名称:320
     */
    特定入所者負担限度額_従個特養１("1", "320"),
    /**
     * コード:2 名称:420
     */
    特定入所者負担限度額_従個特養２("2", "420"),
    /**
     * コード:3 名称:820
     */
    特定入所者負担限度額_従個特養３("3", "820");

    private final RString code;
    private final RString fullName;

    private TokuteinyushoshaJuKoTokuyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);

    }

    /**
     * 特定入所者負担限度額_従個特養のコードを返します。
     *
     * @return 特定入所者負担限度額_従個特養のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特定入所者負担限度額_従個特養の名称を返します。
     *
     * @return 特定入所者負担限度額_従個特養の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特定入所者負担限度額_従個特養のコードと一致する内容を探します。
     *
     * @param code 特定入所者負担限度額_従個特養のコード
     * @return {@code code} に対応する特定入所者負担限度額_従個特養
     */
    public static TokuteinyushoshaJuKoTokuyo toValue(RString code) {
        for (TokuteinyushoshaJuKoTokuyo tokuteinyushoshaJuKoTokuyo : TokuteinyushoshaJuKoTokuyo.values()) {
            if (tokuteinyushoshaJuKoTokuyo.code.equals(code)) {
                return tokuteinyushoshaJuKoTokuyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特定入所者負担限度額_従個特養"));
    }
}

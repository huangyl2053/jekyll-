package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定計算異動方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum ZanteiKeisanIdoHoho {

    /**
     * コード:1 名称:_4月喪失のみ0円にする 略称:定義なし
     */
    _4月喪失のみ0円にする("1", "_4月喪失のみ0円にする"),
    /**
     * コード:2 名称:喪失月以降0円にする 略称:定義なし
     */
    喪失月以降0円にする("2", "喪失月以降0円にする");

    private final RString code;
    private final RString fullName;

    private ZanteiKeisanIdoHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 仮算定計算異動方法のコードを返します。
     *
     * @return 仮算定計算異動方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 仮算定計算異動方法の名称を返します。
     *
     * @return 仮算定計算異動方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 仮算定計算異動方法のコードと一致する内容を探します。
     *
     * @param code 仮算定計算異動方法のコード
     * @return {@code code} に対応する仮算定計算異動方法
     */
    public static ZanteiKeisanIdoHoho toValue(RString code) {
        for (ZanteiKeisanIdoHoho zanteiKeisanIdoHoho : ZanteiKeisanIdoHoho.values()) {
            if (zanteiKeisanIdoHoho.code.equals(code)) {
                return zanteiKeisanIdoHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("仮算定計算異動方法"));
    }
}

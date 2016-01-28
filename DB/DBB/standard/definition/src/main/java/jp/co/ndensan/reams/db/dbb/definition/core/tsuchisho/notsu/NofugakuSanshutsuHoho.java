package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額算出方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum NofugakuSanshutsuHoho {

    /**
     * コード:1 名称:収入額をもとに算出 略称:定義なし
     */
    収入額をもとに算出("1", "収入額をもとに算出"),
    /**
     * コード:2 名称:調定額をもとに算出 略称:定義なし
     */
    調定額をもとに算出("2", "調定額をもとに算出");

    private final RString code;
    private final RString fullName;

    private NofugakuSanshutsuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 納付額算出方法のコードを返します。
     *
     * @return 納付額算出方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納付額算出方法の名称を返します。
     *
     * @return 納付額算出方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納付額算出方法のコードと一致する内容を探します。
     *
     * @param code 納付額算出方法のコード
     * @return {@code code} に対応する納付額算出方法
     */
    public static NofugakuSanshutsuHoho toValue(RString code) {
        for (NofugakuSanshutsuHoho nofugakuSanshutsuHoho : NofugakuSanshutsuHoho.values()) {
            if (nofugakuSanshutsuHoho.code.equals(code)) {
                return nofugakuSanshutsuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納付額算出方法"));
    }
}

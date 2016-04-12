package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-7-02Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku02A_23 {

    /**
     * コード:023 名称:医療機関（療養以外） 略称:定義なし
     */
    医療機関_療養以外("023", "医療機関（療養以外）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_23(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-7-02Aのコードを返します。
     *
     * @return 施設利用-7-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-7-02Aの名称を返します。
     *
     * @return 施設利用-7-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-7-02Aのコードと一致する内容を探します。
     *
     * @param code 施設利用-7-02Aのコード
     * @return {@code code} に対応する施設利用-7-02A
     */
    public static GaikyochosaKomoku02A_23 toValue(RString code) {
        for (GaikyochosaKomoku02A_23 gaikyochosaKomoku02A_23 : GaikyochosaKomoku02A_23.values()) {
            if (gaikyochosaKomoku02A_23.code.equals(code)) {
                return gaikyochosaKomoku02A_23;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-7-02A"));
    }
}

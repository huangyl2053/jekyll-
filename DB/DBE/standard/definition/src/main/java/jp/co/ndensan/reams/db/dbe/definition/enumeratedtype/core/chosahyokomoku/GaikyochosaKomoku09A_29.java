package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-6-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_29 {

    /**
     * コード:029 名称:医療機関（医療保険適用療養病床） 略称:定義なし
     */
    医療機関_医療保険適用療養病床("029", "医療機関（医療保険適用療養病床）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_29(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-6-09Aのコードを返します。
     * 
     * @return 施設利用-6-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-6-09Aの名称を返します。
     * 
     * @return 施設利用-6-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-6-09Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-6-09Aのコード
     * @return {@code code} に対応する施設利用-6-09A
     */
    public static GaikyochosaKomoku09A_29 toValue(RString code) {
        for (GaikyochosaKomoku09A_29 gaikyochosaKomoku09A_29 : GaikyochosaKomoku09A_29.values()) {
            if (gaikyochosaKomoku09A_29.code.equals(code)) {
                return gaikyochosaKomoku09A_29;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-6-09A"));
    }
}

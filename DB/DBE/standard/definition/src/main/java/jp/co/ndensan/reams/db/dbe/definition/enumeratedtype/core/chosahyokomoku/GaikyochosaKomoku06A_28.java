package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-6-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_28 {

    /**
     * コード:028 名称:医療機関（医療保険適用療養病床） 略称:定義なし
     */
    医療機関_医療保険適用療養病床("028", "医療機関（医療保険適用療養病床）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_28(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-6-06Aのコードを返します。
     * 
     * @return 施設利用-6-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-6-06Aの名称を返します。
     * 
     * @return 施設利用-6-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-6-06Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-6-06Aのコード
     * @return {@code code} に対応する施設利用-6-06A
     */
    public static GaikyochosaKomoku06A_28 toValue(RString code) {
        for (GaikyochosaKomoku06A_28 gaikyochosaKomoku06A_28 : GaikyochosaKomoku06A_28.values()) {
            if (gaikyochosaKomoku06A_28.code.equals(code)) {
                return gaikyochosaKomoku06A_28;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-6-06A"));
    }
}

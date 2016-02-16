package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-21-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_21 {

    /**
     * コード:021 名称:市町村特別給付 略称:定義なし
     */
    市町村特別給付("021", "市町村特別給付");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_21(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-21-06Aのコードを返します。
     * 
     * @return 在宅利用-21-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-21-06Aの名称を返します。
     * 
     * @return 在宅利用-21-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-21-06Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-21-06Aのコード
     * @return {@code code} に対応する在宅利用-21-06A
     */
    public static GaikyochosaKomoku06A_21 toValue(RString code) {
        for (GaikyochosaKomoku06A_21 gaikyochosaKomoku06A_21 : GaikyochosaKomoku06A_21.values()) {
            if (gaikyochosaKomoku06A_21.code.equals(code)) {
                return gaikyochosaKomoku06A_21;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-21-06A"));
    }
}

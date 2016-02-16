package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-18-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_18 {

    /**
     * コード:018 名称:地域密着型特定施設入居者生活介護 略称:定義なし
     */
    地域密着型特定施設入居者生活介護("018", "地域密着型特定施設入居者生活介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_18(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-18-06Aのコードを返します。
     * 
     * @return 在宅利用-18-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-18-06Aの名称を返します。
     * 
     * @return 在宅利用-18-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-18-06Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-18-06Aのコード
     * @return {@code code} に対応する在宅利用-18-06A
     */
    public static GaikyochosaKomoku06A_18 toValue(RString code) {
        for (GaikyochosaKomoku06A_18 gaikyochosaKomoku06A_18 : GaikyochosaKomoku06A_18.values()) {
            if (gaikyochosaKomoku06A_18.code.equals(code)) {
                return gaikyochosaKomoku06A_18;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-18-06A"));
    }
}

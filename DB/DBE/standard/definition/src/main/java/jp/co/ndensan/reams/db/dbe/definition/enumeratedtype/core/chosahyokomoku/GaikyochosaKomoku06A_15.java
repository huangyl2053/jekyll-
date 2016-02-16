package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-15-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_15 {

    /**
     * コード:015 名称:（介護予防）認知症対応型通所介護 略称:定義なし
     */
    _介護予防_認知症対応型通所介護("015", "（介護予防）認知症対応型通所介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_15(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-15-06Aのコードを返します。
     * 
     * @return 在宅利用-15-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-15-06Aの名称を返します。
     * 
     * @return 在宅利用-15-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-15-06Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-15-06Aのコード
     * @return {@code code} に対応する在宅利用-15-06A
     */
    public static GaikyochosaKomoku06A_15 toValue(RString code) {
        for (GaikyochosaKomoku06A_15 gaikyochosaKomoku06A_15 : GaikyochosaKomoku06A_15.values()) {
            if (gaikyochosaKomoku06A_15.code.equals(code)) {
                return gaikyochosaKomoku06A_15;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-15-06A"));
    }
}

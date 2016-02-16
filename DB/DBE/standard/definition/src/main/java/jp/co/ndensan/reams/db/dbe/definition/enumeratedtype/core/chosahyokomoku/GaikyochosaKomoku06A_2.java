package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-2-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_2 {

    /**
     * コード:002 名称:（介護予防）訪問入浴介護 略称:定義なし
     */
    _介護予防_訪問入浴介護("002", "（介護予防）訪問入浴介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_2(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-2-06Aのコードを返します。
     * 
     * @return 在宅利用-2-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-2-06Aの名称を返します。
     * 
     * @return 在宅利用-2-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-2-06Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-2-06Aのコード
     * @return {@code code} に対応する在宅利用-2-06A
     */
    public static GaikyochosaKomoku06A_2 toValue(RString code) {
        for (GaikyochosaKomoku06A_2 gaikyochosaKomoku06A_2 : GaikyochosaKomoku06A_2.values()) {
            if (gaikyochosaKomoku06A_2.code.equals(code)) {
                return gaikyochosaKomoku06A_2;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-2-06A"));
    }
}

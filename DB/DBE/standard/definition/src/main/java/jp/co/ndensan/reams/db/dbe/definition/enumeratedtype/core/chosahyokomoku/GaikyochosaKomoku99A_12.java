package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-12-99Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku99A_12 {

    /**
     * コード:012 名称:特定施設入所者生活介護 略称:定義なし
     */
    特定施設入所者生活介護("012", "特定施設入所者生活介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_12(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-12-99Aのコードを返します。
     * 
     * @return 在宅利用-12-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-12-99Aの名称を返します。
     * 
     * @return 在宅利用-12-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-12-99Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-12-99Aのコード
     * @return {@code code} に対応する在宅利用-12-99A
     */
    public static GaikyochosaKomoku99A_12 toValue(RString code) {
        for (GaikyochosaKomoku99A_12 gaikyochosaKomoku99A_12 : GaikyochosaKomoku99A_12.values()) {
            if (gaikyochosaKomoku99A_12.code.equals(code)) {
                return gaikyochosaKomoku99A_12;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-12-99A"));
    }
}

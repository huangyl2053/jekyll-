package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-11-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_11 {

    /**
     * コード:011 名称:（介護予防）福祉用具貸与 略称:定義なし
     */
    _介護予防_福祉用具貸与("011", "（介護予防）福祉用具貸与");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_11(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-11-09Aのコードを返します。
     * 
     * @return 在宅利用-11-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-11-09Aの名称を返します。
     * 
     * @return 在宅利用-11-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-11-09Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-11-09Aのコード
     * @return {@code code} に対応する在宅利用-11-09A
     */
    public static GaikyochosaKomoku09A_11 toValue(RString code) {
        for (GaikyochosaKomoku09A_11 gaikyochosaKomoku09A_11 : GaikyochosaKomoku09A_11.values()) {
            if (gaikyochosaKomoku09A_11.code.equals(code)) {
                return gaikyochosaKomoku09A_11;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-11-09A"));
    }
}

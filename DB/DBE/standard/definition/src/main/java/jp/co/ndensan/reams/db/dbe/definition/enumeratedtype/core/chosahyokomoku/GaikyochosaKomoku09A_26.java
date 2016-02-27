package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-3-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_26 {

    /**
     * コード:026 名称:介護療養型医療施設 略称:定義なし
     */
    介護療養型医療施設("026", "介護療養型医療施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_26(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-3-09Aのコードを返します。
     * 
     * @return 施設利用-3-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-3-09Aの名称を返します。
     * 
     * @return 施設利用-3-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-3-09Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-3-09Aのコード
     * @return {@code code} に対応する施設利用-3-09A
     */
    public static GaikyochosaKomoku09A_26 toValue(RString code) {
        for (GaikyochosaKomoku09A_26 gaikyochosaKomoku09A_26 : GaikyochosaKomoku09A_26.values()) {
            if (gaikyochosaKomoku09A_26.code.equals(code)) {
                return gaikyochosaKomoku09A_26;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-3-09A"));
    }
}

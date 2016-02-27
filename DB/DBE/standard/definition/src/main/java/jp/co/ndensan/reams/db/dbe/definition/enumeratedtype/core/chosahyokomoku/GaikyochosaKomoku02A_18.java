package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-2-02Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku02A_18 {

    /**
     * コード:018 名称:介護老人保健施設 略称:定義なし
     */
    介護老人保健施設("018", "介護老人保健施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_18(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-2-02Aのコードを返します。
     * 
     * @return 施設利用-2-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-2-02Aの名称を返します。
     * 
     * @return 施設利用-2-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-2-02Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-2-02Aのコード
     * @return {@code code} に対応する施設利用-2-02A
     */
    public static GaikyochosaKomoku02A_18 toValue(RString code) {
        for (GaikyochosaKomoku02A_18 gaikyochosaKomoku02A_18 : GaikyochosaKomoku02A_18.values()) {
            if (gaikyochosaKomoku02A_18.code.equals(code)) {
                return gaikyochosaKomoku02A_18;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-2-02A"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-3-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_25 {

    /**
     * コード:025 名称:介護療養型医療施設 略称:定義なし
     */
    介護療養型医療施設("025", "介護療養型医療施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_25(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-3-06Aのコードを返します。
     * 
     * @return 施設利用-3-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-3-06Aの名称を返します。
     * 
     * @return 施設利用-3-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-3-06Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-3-06Aのコード
     * @return {@code code} に対応する施設利用-3-06A
     */
    public static GaikyochosaKomoku06A_25 toValue(RString code) {
        for (GaikyochosaKomoku06A_25 gaikyochosaKomoku06A_25 : GaikyochosaKomoku06A_25.values()) {
            if (gaikyochosaKomoku06A_25.code.equals(code)) {
                return gaikyochosaKomoku06A_25;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-3-06A"));
    }
}

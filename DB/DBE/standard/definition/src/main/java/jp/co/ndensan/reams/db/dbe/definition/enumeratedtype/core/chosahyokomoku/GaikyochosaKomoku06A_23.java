package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-1-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_23 {

    /**
     * コード:023 名称:介護老人福祉施設 略称:定義なし
     */
    介護老人福祉施設("023", "介護老人福祉施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_23(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-1-06Aのコードを返します。
     * 
     * @return 施設利用-1-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-1-06Aの名称を返します。
     * 
     * @return 施設利用-1-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-1-06Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-1-06Aのコード
     * @return {@code code} に対応する施設利用-1-06A
     */
    public static GaikyochosaKomoku06A_23 toValue(RString code) {
        for (GaikyochosaKomoku06A_23 gaikyochosaKomoku06A_23 : GaikyochosaKomoku06A_23.values()) {
            if (gaikyochosaKomoku06A_23.code.equals(code)) {
                return gaikyochosaKomoku06A_23;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-1-06A"));
    }
}

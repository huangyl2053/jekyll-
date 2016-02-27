package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-3-99Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku99A_19 {

    /**
     * コード:019 名称:介護療養型医療施設 略称:定義なし
     */
    介護療養型医療施設("019", "介護療養型医療施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_19(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-3-99Aのコードを返します。
     * 
     * @return 施設利用-3-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-3-99Aの名称を返します。
     * 
     * @return 施設利用-3-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-3-99Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-3-99Aのコード
     * @return {@code code} に対応する施設利用-3-99A
     */
    public static GaikyochosaKomoku99A_19 toValue(RString code) {
        for (GaikyochosaKomoku99A_19 gaikyochosaKomoku99A_19 : GaikyochosaKomoku99A_19.values()) {
            if (gaikyochosaKomoku99A_19.code.equals(code)) {
                return gaikyochosaKomoku99A_19;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-3-99A"));
    }
}

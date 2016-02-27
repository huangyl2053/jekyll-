package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-0-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_32 {

    /**
     * コード:099 名称:居宅 略称:定義なし
     */
    居宅("099", "居宅");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_32(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-0-09Aのコードを返します。
     * 
     * @return 施設利用-0-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-0-09Aの名称を返します。
     * 
     * @return 施設利用-0-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-0-09Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-0-09Aのコード
     * @return {@code code} に対応する施設利用-0-09A
     */
    public static GaikyochosaKomoku09A_32 toValue(RString code) {
        for (GaikyochosaKomoku09A_32 gaikyochosaKomoku09A_32 : GaikyochosaKomoku09A_32.values()) {
            if (gaikyochosaKomoku09A_32.code.equals(code)) {
                return gaikyochosaKomoku09A_32;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-1-99A"));
    }
}

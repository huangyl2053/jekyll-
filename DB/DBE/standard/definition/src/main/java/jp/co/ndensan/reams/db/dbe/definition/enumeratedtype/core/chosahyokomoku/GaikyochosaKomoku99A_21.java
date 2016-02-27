package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-0-99Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku99A_21 {

    /**
     * コード:099 名称:居宅 略称:定義なし
     */
    居宅("099", "居宅");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_21(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-0-99Aのコードを返します。
     * 
     * @return 施設利用-0-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-0-99Aの名称を返します。
     * 
     * @return 施設利用-0-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-0-99Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-0-99Aのコード
     * @return {@code code} に対応する施設利用-0-99A
     */
    public static GaikyochosaKomoku99A_21 toValue(RString code) {
        for (GaikyochosaKomoku99A_21 gaikyochosaKomoku99A_21 : GaikyochosaKomoku99A_21.values()) {
            if (gaikyochosaKomoku99A_21.code.equals(code)) {
                return gaikyochosaKomoku99A_21;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-0-99A"));
    }
}

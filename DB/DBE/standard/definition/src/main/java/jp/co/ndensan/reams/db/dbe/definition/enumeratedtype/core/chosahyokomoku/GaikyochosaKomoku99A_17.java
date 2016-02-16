package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-1-99Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku99A_17 {

    /**
     * コード:017 名称:介護老人福祉施設 略称:定義なし
     */
    介護老人福祉施設("017", "介護老人福祉施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_17(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-1-99Aのコードを返します。
     * 
     * @return 施設利用-1-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-1-99Aの名称を返します。
     * 
     * @return 施設利用-1-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-1-99Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-1-99Aのコード
     * @return {@code code} に対応する施設利用-1-99A
     */
    public static GaikyochosaKomoku99A_17 toValue(RString code) {
        for (GaikyochosaKomoku99A_17 gaikyochosaKomoku99A_17 : GaikyochosaKomoku99A_17.values()) {
            if (gaikyochosaKomoku99A_17.code.equals(code)) {
                return gaikyochosaKomoku99A_17;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-1-99A"));
    }
}

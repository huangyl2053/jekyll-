package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-11-99Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku99A_11 {

    /**
     * コード:011 名称:認知症対応型共同生活介護 略称:定義なし
     */
    認知症対応型共同生活介護("011", "認知症対応型共同生活介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_11(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-11-99Aのコードを返します。
     * 
     * @return 在宅利用-11-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-11-99Aの名称を返します。
     * 
     * @return 在宅利用-11-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-11-99Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-11-99Aのコード
     * @return {@code code} に対応する在宅利用-11-99A
     */
    public static GaikyochosaKomoku99A_11 toValue(RString code) {
        for (GaikyochosaKomoku99A_11 gaikyochosaKomoku99A_11 : GaikyochosaKomoku99A_11.values()) {
            if (gaikyochosaKomoku99A_11.code.equals(code)) {
                return gaikyochosaKomoku99A_11;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-11-99A"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-17-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_17 {

    /**
     * コード:017 名称:（介護予防）認知症対応型共同生活介護 略称:定義なし
     */
    _介護予防_認知症対応型共同生活介護("017", "（介護予防）認知症対応型共同生活介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_17(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-17-09Aのコードを返します。
     * 
     * @return 在宅利用-17-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-17-09Aの名称を返します。
     * 
     * @return 在宅利用-17-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-17-09Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-17-09Aのコード
     * @return {@code code} に対応する在宅利用-17-09A
     */
    public static GaikyochosaKomoku09A_17 toValue(RString code) {
        for (GaikyochosaKomoku09A_17 gaikyochosaKomoku09A_17 : GaikyochosaKomoku09A_17.values()) {
            if (gaikyochosaKomoku09A_17.code.equals(code)) {
                return gaikyochosaKomoku09A_17;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-17-09A"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-19-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_19 {

    /**
     * コード:019 名称:地域密着型介護老人福祉施設入所者生活介護 略称:定義なし
     */
    地域密着型介護老人福祉施設入所者生活介護("019", "地域密着型介護老人福祉施設入所者生活介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_19(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-19-09Aのコードを返します。
     * 
     * @return 在宅利用-19-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-19-09Aの名称を返します。
     * 
     * @return 在宅利用-19-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-19-09Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-19-09Aのコード
     * @return {@code code} に対応する在宅利用-19-09A
     */
    public static GaikyochosaKomoku09A_19 toValue(RString code) {
        for (GaikyochosaKomoku09A_19 gaikyochosaKomoku09A_19 : GaikyochosaKomoku09A_19.values()) {
            if (gaikyochosaKomoku09A_19.code.equals(code)) {
                return gaikyochosaKomoku09A_19;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-19-09A"));
    }
}

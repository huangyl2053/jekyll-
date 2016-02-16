package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-4-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_27 {

    /**
     * コード:027 名称:認知症対応型共同生活介護適用施設（ｸﾞﾙｰﾌﾟﾎｰﾑ） 略称:定義なし
     */
    認知症対応型共同生活介護適用施設_ｸﾞﾙｰﾌﾟﾎｰﾑ("027", "認知症対応型共同生活介護適用施設（ｸﾞﾙｰﾌﾟﾎｰﾑ）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_27(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-4-09Aのコードを返します。
     * 
     * @return 施設利用-4-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-4-09Aの名称を返します。
     * 
     * @return 施設利用-4-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-4-09Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-4-09Aのコード
     * @return {@code code} に対応する施設利用-4-09A
     */
    public static GaikyochosaKomoku09A_27 toValue(RString code) {
        for (GaikyochosaKomoku09A_27 gaikyochosaKomoku09A_27 : GaikyochosaKomoku09A_27.values()) {
            if (gaikyochosaKomoku09A_27.code.equals(code)) {
                return gaikyochosaKomoku09A_27;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-4-09A"));
    }
}

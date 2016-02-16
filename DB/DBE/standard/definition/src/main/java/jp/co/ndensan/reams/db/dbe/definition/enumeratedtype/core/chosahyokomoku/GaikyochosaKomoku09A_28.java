package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-5-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_28 {

    /**
     * コード:028 名称:特定施設入居者生活介護適用施設（ｹｱﾊｳｽ等） 略称:定義なし
     */
    特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等("028", "特定施設入居者生活介護適用施設（ｹｱﾊｳｽ等）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_28(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-5-09Aのコードを返します。
     * 
     * @return 施設利用-5-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-5-09Aの名称を返します。
     * 
     * @return 施設利用-5-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-5-09Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-5-09Aのコード
     * @return {@code code} に対応する施設利用-5-09A
     */
    public static GaikyochosaKomoku09A_28 toValue(RString code) {
        for (GaikyochosaKomoku09A_28 gaikyochosaKomoku09A_28 : GaikyochosaKomoku09A_28.values()) {
            if (gaikyochosaKomoku09A_28.code.equals(code)) {
                return gaikyochosaKomoku09A_28;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-5-09A"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-5-09Bを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09B_28 {

    /**
     * コード:028 名称:特定施設入居者生活介護適用施設（ｹｱﾊｳｽ等） 略称:定義なし
     */
    特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等("028", "特定施設入居者生活介護適用施設（ｹｱﾊｳｽ等）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B_28(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-5-09Bのコードを返します。
     * 
     * @return 施設利用-5-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-5-09Bの名称を返します。
     * 
     * @return 施設利用-5-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-5-09Bのコードと一致する内容を探します。
     * 
     * @param code 施設利用-5-09Bのコード
     * @return {@code code} に対応する施設利用-5-09B
     */
    public static GaikyochosaKomoku09B_28 toValue(RString code) {
        for (GaikyochosaKomoku09B_28 gaikyochosaKomoku09B_28 : GaikyochosaKomoku09B_28.values()) {
            if (gaikyochosaKomoku09B_28.code.equals(code)) {
                return gaikyochosaKomoku09B_28;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-5-09B"));
    }
}

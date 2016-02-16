package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-8-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_31 {

    /**
     * コード:031 名称:その他の施設 略称:定義なし
     */
    その他の施設("031", "その他の施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_31(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-8-09Aのコードを返します。
     * 
     * @return 施設利用-8-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-8-09Aの名称を返します。
     * 
     * @return 施設利用-8-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-8-09Aのコードと一致する内容を探します。
     * 
     * @param code 施設利用-8-09Aのコード
     * @return {@code code} に対応する施設利用-8-09A
     */
    public static GaikyochosaKomoku09A_31 toValue(RString code) {
        for (GaikyochosaKomoku09A_31 gaikyochosaKomoku09A_31 : GaikyochosaKomoku09A_31.values()) {
            if (gaikyochosaKomoku09A_31.code.equals(code)) {
                return gaikyochosaKomoku09A_31;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-8-09A"));
    }
}

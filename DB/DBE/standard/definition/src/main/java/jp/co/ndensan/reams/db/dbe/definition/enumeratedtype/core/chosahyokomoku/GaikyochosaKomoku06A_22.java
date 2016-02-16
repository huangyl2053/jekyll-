package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-22-06Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku06A_22 {

    /**
     * コード:022 名称:介護保険給付外の在宅サービス 略称:定義なし
     */
    介護保険給付外の在宅サービス("022", "介護保険給付外の在宅サービス");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_22(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-22-06Aのコードを返します。
     * 
     * @return 在宅利用-22-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-22-06Aの名称を返します。
     * 
     * @return 在宅利用-22-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-22-06Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-22-06Aのコード
     * @return {@code code} に対応する在宅利用-22-06A
     */
    public static GaikyochosaKomoku06A_22 toValue(RString code) {
        for (GaikyochosaKomoku06A_22 gaikyochosaKomoku06A_22 : GaikyochosaKomoku06A_22.values()) {
            if (gaikyochosaKomoku06A_22.code.equals(code)) {
                return gaikyochosaKomoku06A_22;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-22-06A"));
    }
}

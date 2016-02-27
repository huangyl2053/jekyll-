package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-23-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_23 {

    /**
     * コード:023 名称:介護保険給付外の在宅サービス 略称:定義なし
     */
    介護保険給付外の在宅サービス("023", "介護保険給付外の在宅サービス");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_23(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-23-09Aのコードを返します。
     * 
     * @return 在宅利用-23-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-23-09Aの名称を返します。
     * 
     * @return 在宅利用-23-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-23-09Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-23-09Aのコード
     * @return {@code code} に対応する在宅利用-23-09A
     */
    public static GaikyochosaKomoku09A_23 toValue(RString code) {
        for (GaikyochosaKomoku09A_23 gaikyochosaKomoku09A_23 : GaikyochosaKomoku09A_23.values()) {
            if (gaikyochosaKomoku09A_23.code.equals(code)) {
                return gaikyochosaKomoku09A_23;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-23-09A"));
    }
}

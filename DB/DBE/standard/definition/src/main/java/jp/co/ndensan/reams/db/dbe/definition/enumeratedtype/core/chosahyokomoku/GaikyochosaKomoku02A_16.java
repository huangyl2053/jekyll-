package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-16-02Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku02A_16 {

    /**
     * コード:016 名称:介護保険給付外の在宅サービス 略称:定義なし
     */
    介護保険給付外の在宅サービス("016", "介護保険給付外の在宅サービス");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_16(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-16-02Aのコードを返します。
     * 
     * @return 在宅利用-16-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-16-02Aの名称を返します。
     * 
     * @return 在宅利用-16-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-16-02Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-16-02Aのコード
     * @return {@code code} に対応する在宅利用-16-02A
     */
    public static GaikyochosaKomoku02A_16 toValue(RString code) {
        for (GaikyochosaKomoku02A_16 gaikyochosaKomoku02A_16 : GaikyochosaKomoku02A_16.values()) {
            if (gaikyochosaKomoku02A_16.code.equals(code)) {
                return gaikyochosaKomoku02A_16;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-16-02A"));
    }
}

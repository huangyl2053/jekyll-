package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-5-02Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku02A_5 {

    /**
     * コード:005 名称:居宅療養管理指導 略称:定義なし
     */
    居宅療養管理指導("005", "居宅療養管理指導");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_5(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-5-02Aのコードを返します。
     * 
     * @return 在宅利用-5-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-5-02Aの名称を返します。
     * 
     * @return 在宅利用-5-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-5-02Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-5-02Aのコード
     * @return {@code code} に対応する在宅利用-5-02A
     */
    public static GaikyochosaKomoku02A_5 toValue(RString code) {
        for (GaikyochosaKomoku02A_5 gaikyochosaKomoku02A_5 : GaikyochosaKomoku02A_5.values()) {
            if (gaikyochosaKomoku02A_5.code.equals(code)) {
                return gaikyochosaKomoku02A_5;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-5-02A"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-14-02Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku02A_14 {

    /**
     * コード:014 名称:住宅改修 略称:定義なし
     */
    住宅改修("014", "住宅改修");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_14(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-14-02Aのコードを返します。
     * 
     * @return 在宅利用-14-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-14-02Aの名称を返します。
     * 
     * @return 在宅利用-14-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-14-02Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-14-02Aのコード
     * @return {@code code} に対応する在宅利用-14-02A
     */
    public static GaikyochosaKomoku02A_14 toValue(RString code) {
        for (GaikyochosaKomoku02A_14 gaikyochosaKomoku02A_14 : GaikyochosaKomoku02A_14.values()) {
            if (gaikyochosaKomoku02A_14.code.equals(code)) {
                return gaikyochosaKomoku02A_14;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-14-02A"));
    }
}

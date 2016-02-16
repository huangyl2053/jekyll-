package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-2-02Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku02A_2 {

    /**
     * コード:002 名称:訪問入浴介護 略称:定義なし
     */
    訪問入浴介護("002", "訪問入浴介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_2(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-2-02Aのコードを返します。
     * 
     * @return 在宅利用-2-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-2-02Aの名称を返します。
     * 
     * @return 在宅利用-2-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-2-02Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-2-02Aのコード
     * @return {@code code} に対応する在宅利用-2-02A
     */
    public static GaikyochosaKomoku02A_2 toValue(RString code) {
        for (GaikyochosaKomoku02A_2 gaikyochosaKomoku02A_2 : GaikyochosaKomoku02A_2.values()) {
            if (gaikyochosaKomoku02A_2.code.equals(code)) {
                return gaikyochosaKomoku02A_2;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-2-02A"));
    }
}

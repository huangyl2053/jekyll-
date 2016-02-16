package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-9-09Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09A_9 {

    /**
     * コード:009 名称:（介護予防）短期入所療養介護（老健・診療所） 略称:定義なし
     */
    _介護予防_短期入所療養介護_老健_診療所("009", "（介護予防）短期入所療養介護（老健・診療所）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_9(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-9-09Aのコードを返します。
     * 
     * @return 在宅利用-9-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-9-09Aの名称を返します。
     * 
     * @return 在宅利用-9-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-9-09Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-9-09Aのコード
     * @return {@code code} に対応する在宅利用-9-09A
     */
    public static GaikyochosaKomoku09A_9 toValue(RString code) {
        for (GaikyochosaKomoku09A_9 gaikyochosaKomoku09A_9 : GaikyochosaKomoku09A_9.values()) {
            if (gaikyochosaKomoku09A_9.code.equals(code)) {
                return gaikyochosaKomoku09A_9;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-9-09A"));
    }
}

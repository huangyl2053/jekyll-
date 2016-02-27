package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-9-99Aを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku99A_9 {

    /**
     * コード:009 名称:短期入所生活介護（特養） 略称:定義なし
     */
    短期入所生活介護_特養("009", "短期入所生活介護（特養）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_9(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-9-99Aのコードを返します。
     * 
     * @return 在宅利用-9-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-9-99Aの名称を返します。
     * 
     * @return 在宅利用-9-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-9-99Aのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-9-99Aのコード
     * @return {@code code} に対応する在宅利用-9-99A
     */
    public static GaikyochosaKomoku99A_9 toValue(RString code) {
        for (GaikyochosaKomoku99A_9 gaikyochosaKomoku99A_9 : GaikyochosaKomoku99A_9.values()) {
            if (gaikyochosaKomoku99A_9.code.equals(code)) {
                return gaikyochosaKomoku99A_9;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-9-99A"));
    }
}

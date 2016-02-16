package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-14-09Bを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09B_14 {

    /**
     * コード:014 名称:夜間対応型訪問介護 略称:定義なし
     */
    夜間対応型訪問介護("014", "夜間対応型訪問介護");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B_14(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-14-09Bのコードを返します。
     * 
     * @return 在宅利用-14-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-14-09Bの名称を返します。
     * 
     * @return 在宅利用-14-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-14-09Bのコードと一致する内容を探します。
     * 
     * @param code 在宅利用-14-09Bのコード
     * @return {@code code} に対応する在宅利用-14-09B
     */
    public static GaikyochosaKomoku09B_14 toValue(RString code) {
        for (GaikyochosaKomoku09B_14 gaikyochosaKomoku09B_14 : GaikyochosaKomoku09B_14.values()) {
            if (gaikyochosaKomoku09B_14.code.equals(code)) {
                return gaikyochosaKomoku09B_14;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-14-09B"));
    }
}

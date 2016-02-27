package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-8-09Bを表す列挙型です。
 * 
 * @author LDNS 
 */
public enum GaikyochosaKomoku09B_31 {

    /**
     * コード:031 名称:その他の施設 略称:定義なし
     */
    その他の施設("031", "その他の施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B_31(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-8-09Bのコードを返します。
     * 
     * @return 施設利用-8-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-8-09Bの名称を返します。
     * 
     * @return 施設利用-8-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-8-09Bのコードと一致する内容を探します。
     * 
     * @param code 施設利用-8-09Bのコード
     * @return {@code code} に対応する施設利用-8-09B
     */
    public static GaikyochosaKomoku09B_31 toValue(RString code) {
        for (GaikyochosaKomoku09B_31 gaikyochosaKomoku09B_31 : GaikyochosaKomoku09B_31.values()) {
            if (gaikyochosaKomoku09B_31.code.equals(code)) {
                return gaikyochosaKomoku09B_31;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-8-09B"));
    }
}

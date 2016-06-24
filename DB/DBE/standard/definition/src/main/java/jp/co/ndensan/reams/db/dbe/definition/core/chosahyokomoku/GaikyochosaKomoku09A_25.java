package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-2-09Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09A_25 {

    /**
     * コード:025 名称:介護老人保健施設 略称:定義なし
     */
    介護老人保健施設("025", "介護老人保健施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09A_25(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-2-09Aのコードを返します。
     *
     * @return 施設利用-2-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-2-09Aの名称を返します。
     *
     * @return 施設利用-2-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-2-09Aのコードと一致する内容を探します。
     *
     * @param code 施設利用-2-09Aのコード
     * @return {@code code} に対応する施設利用-2-09A
     */
    public static GaikyochosaKomoku09A_25 toValue(RString code) {
        for (GaikyochosaKomoku09A_25 gaikyochosaKomoku09A_25 : GaikyochosaKomoku09A_25.values()) {
            if (gaikyochosaKomoku09A_25.code.equals(code)) {
                return gaikyochosaKomoku09A_25;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-2-09A"));
    }
}

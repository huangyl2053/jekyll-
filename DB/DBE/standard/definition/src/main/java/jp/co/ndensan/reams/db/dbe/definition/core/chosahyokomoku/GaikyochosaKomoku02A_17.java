package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-1-02Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku02A_17 {

    /**
     * コード:017 名称:介護老人福祉施設 略称:定義なし
     */
    介護老人福祉施設("017", "介護老人福祉施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_17(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-1-02Aのコードを返します。
     *
     * @return 施設利用-1-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-1-02Aの名称を返します。
     *
     * @return 施設利用-1-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-1-02Aのコードと一致する内容を探します。
     *
     * @param code 施設利用-1-02Aのコード
     * @return {@code code} に対応する施設利用-1-02A
     */
    public static GaikyochosaKomoku02A_17 toValue(RString code) {
        for (GaikyochosaKomoku02A_17 gaikyochosaKomoku02A_17 : GaikyochosaKomoku02A_17.values()) {
            if (gaikyochosaKomoku02A_17.code.equals(code)) {
                return gaikyochosaKomoku02A_17;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-1-02A"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-5-06Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku06A_27 {

    /**
     * コード:027 名称:特定施設入居者生活介護適用施設（ｹｱﾊｳｽ等） 略称:定義なし
     */
    特定施設入居者生活介護適用施設_ｹｱﾊｳｽ等("027", "特定施設入居者生活介護適用施設（ｹｱﾊｳｽ等）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku06A_27(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-5-06Aのコードを返します。
     *
     * @return 施設利用-5-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-5-06Aの名称を返します。
     *
     * @return 施設利用-5-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-5-06Aのコードと一致する内容を探します。
     *
     * @param code 施設利用-5-06Aのコード
     * @return {@code code} に対応する施設利用-5-06A
     */
    public static GaikyochosaKomoku06A_27 toValue(RString code) {
        for (GaikyochosaKomoku06A_27 gaikyochosaKomoku06A_27 : GaikyochosaKomoku06A_27.values()) {
            if (gaikyochosaKomoku06A_27.code.equals(code)) {
                return gaikyochosaKomoku06A_27;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-5-06A"));
    }
}

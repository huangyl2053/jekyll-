package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-22-09Bを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09B_22 {

    /**
     * コード:022 名称:市町村特別給付 略称:定義なし
     */
    市町村特別給付("022", "市町村特別給付");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B_22(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-22-09Bのコードを返します。
     *
     * @return 在宅利用-22-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-22-09Bの名称を返します。
     *
     * @return 在宅利用-22-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-22-09Bのコードと一致する内容を探します。
     *
     * @param code 在宅利用-22-09Bのコード
     * @return {@code code} に対応する在宅利用-22-09B
     */
    public static GaikyochosaKomoku09B_22 toValue(RString code) {
        for (GaikyochosaKomoku09B_22 gaikyochosaKomoku09B_22 : GaikyochosaKomoku09B_22.values()) {
            if (gaikyochosaKomoku09B_22.code.equals(code)) {
                return gaikyochosaKomoku09B_22;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-22-09B"));
    }
}

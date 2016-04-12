package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-7-09B-2015を表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09B2015_30 {

    /**
     * コード:030 名称:医療機関（療養病床以外） 略称:定義なし
     */
    医療機関_療養病床以外("030", "医療機関（療養病床以外）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B2015_30(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-7-09B-2015のコードを返します。
     *
     * @return 施設利用-7-09B-2015のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-7-09B-2015の名称を返します。
     *
     * @return 施設利用-7-09B-2015の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-7-09B-2015のコードと一致する内容を探します。
     *
     * @param code 施設利用-7-09B-2015のコード
     * @return {@code code} に対応する施設利用-7-09B-2015
     */
    public static GaikyochosaKomoku09B2015_30 toValue(RString code) {
        for (GaikyochosaKomoku09B2015_30 gaikyochosaKomoku09B2015_30 : GaikyochosaKomoku09B2015_30.values()) {
            if (gaikyochosaKomoku09B2015_30.code.equals(code)) {
                return gaikyochosaKomoku09B2015_30;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-7-09B-2015"));
    }
}

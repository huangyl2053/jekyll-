package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設利用-1-09B-2015を表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09B2015_24 {

    /**
     * コード:024 名称:介護老人福祉施設 略称:定義なし
     */
    介護老人福祉施設("024", "介護老人福祉施設");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B2015_24(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 施設利用-1-09B-2015のコードを返します。
     *
     * @return 施設利用-1-09B-2015のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 施設利用-1-09B-2015の名称を返します。
     *
     * @return 施設利用-1-09B-2015の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 施設利用-1-09B-2015のコードと一致する内容を探します。
     *
     * @param code 施設利用-1-09B-2015のコード
     * @return {@code code} に対応する施設利用-1-09B-2015
     */
    public static GaikyochosaKomoku09B2015_24 toValue(RString code) {
        for (GaikyochosaKomoku09B2015_24 gaikyochosaKomoku09B2015_24 : GaikyochosaKomoku09B2015_24.values()) {
            if (gaikyochosaKomoku09B2015_24.code.equals(code)) {
                return gaikyochosaKomoku09B2015_24;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("施設利用-1-09B-2015"));
    }
}

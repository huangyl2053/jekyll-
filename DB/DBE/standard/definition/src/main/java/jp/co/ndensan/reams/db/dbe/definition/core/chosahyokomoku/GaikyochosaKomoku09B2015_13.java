package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-13-09B-2015を表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09B2015_13 {

    /**
     * コード:013 名称:特定（介護予防）福祉用具販売 略称:定義なし
     */
    特定_介護予防_福祉用具販売("013", "特定（介護予防）福祉用具販売");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku09B2015_13(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-13-09B-2015のコードを返します。
     *
     * @return 在宅利用-13-09B-2015のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-13-09B-2015の名称を返します。
     *
     * @return 在宅利用-13-09B-2015の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-13-09B-2015のコードと一致する内容を探します。
     *
     * @param code 在宅利用-13-09B-2015のコード
     * @return {@code code} に対応する在宅利用-13-09B-2015
     */
    public static GaikyochosaKomoku09B2015_13 toValue(RString code) {
        for (GaikyochosaKomoku09B2015_13 gaikyochosaKomoku09B2015_13 : GaikyochosaKomoku09B2015_13.values()) {
            if (gaikyochosaKomoku09B2015_13.code.equals(code)) {
                return gaikyochosaKomoku09B2015_13;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-13-09B-2015"));
    }
}

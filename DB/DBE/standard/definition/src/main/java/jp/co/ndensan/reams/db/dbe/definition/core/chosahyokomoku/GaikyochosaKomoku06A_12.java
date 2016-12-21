package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-12-06Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku06A_12 {

    /**
     * コード:012 名称:特定（介護予防）福祉用具販売 略称:定義なし 選択項目名称1:品目/
     */
    特定_介護予防_福祉用具販売("012", "特定（介護予防）福祉用具販売", "品目");

    private final RString code;
    private final RString fullName;
    private final RString tani;

    private GaikyochosaKomoku06A_12(String code, String fullname, String tani) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.tani = new RString(tani);
    }

    /**
     * 在宅利用-12-06Aのコードを返します。
     *
     * @return 在宅利用-12-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-12-06Aの名称を返します。
     *
     * @return 在宅利用-12-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-12-06Aの単位を返します。
     *
     * @return 在宅利用-12-06Aの単位
     */
    public RString get単位() {
        return tani;
    }

    /**
     * 在宅利用-12-06Aのコードと一致する内容を探します。
     *
     * @param code 在宅利用-12-06Aのコード
     * @return {@code code} に対応する在宅利用-12-06A
     */
    public static GaikyochosaKomoku06A_12 toValue(RString code) {
        for (GaikyochosaKomoku06A_12 gaikyochosaKomoku06A_12 : GaikyochosaKomoku06A_12.values()) {
            if (gaikyochosaKomoku06A_12.code.equals(code)) {
                return gaikyochosaKomoku06A_12;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-12-06A"));
    }
}

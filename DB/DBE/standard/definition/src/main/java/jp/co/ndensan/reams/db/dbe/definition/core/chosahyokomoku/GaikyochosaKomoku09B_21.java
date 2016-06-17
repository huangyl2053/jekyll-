package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-21-09Bを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09B_21 {

    /**
     * コード:021 名称:複合型サービス 略称:定義なし 選択項目名称1:回/月
     */
    複合型サービス("021", "複合型サービス", "回/月");

    private final RString code;
    private final RString fullName;
    private final RString tani;

    private GaikyochosaKomoku09B_21(String code, String fullname, String tani) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.tani = new RString(tani);
    }

    /**
     * 在宅利用-21-09Bのコードを返します。
     *
     * @return 在宅利用-21-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-21-09Bの名称を返します。
     *
     * @return 在宅利用-21-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-21-09Bの単位を返します。
     *
     * @return 在宅利用-21-09Bの単位
     */
    public RString get単位() {
        return tani;
    }

    /**
     * 在宅利用-21-09Bのコードと一致する内容を探します。
     *
     * @param code 在宅利用-21-09Bのコード
     * @return {@code code} に対応する在宅利用-21-09B
     */
    public static GaikyochosaKomoku09B_21 toValue(RString code) {
        for (GaikyochosaKomoku09B_21 gaikyochosaKomoku09B_21 : GaikyochosaKomoku09B_21.values()) {
            if (gaikyochosaKomoku09B_21.code.equals(code)) {
                return gaikyochosaKomoku09B_21;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-21-09B"));
    }
}

package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-17-09Bを表す列挙型です。
 *
 * @author LDNS
 */
public enum GaikyochosaKomoku09B_17 {

    /**
     * コード:017 名称:（介護予防）認知症対応型共同生活介護 略称:定義なし 選択項目名称1:日/月
     */
    _介護予防_認知症対応型共同生活介護("017", "（介護予防）認知症対応型共同生活介護", "日/月");

    private final RString code;
    private final RString fullName;
    private final RString tani;

    private GaikyochosaKomoku09B_17(String code, String fullname, String tani) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.tani = new RString(tani);
    }

    /**
     * 在宅利用-17-09Bのコードを返します。
     *
     * @return 在宅利用-17-09Bのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-17-09Bの名称を返します。
     *
     * @return 在宅利用-17-09Bの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-17-09Bの単位を返します。
     *
     * @return 在宅利用-17-09Bの単位
     */
    public RString get単位() {
        return tani;
    }

    /**
     * 在宅利用-17-09Bのコードと一致する内容を探します。
     *
     * @param code 在宅利用-17-09Bのコード
     * @return {@code code} に対応する在宅利用-17-09B
     */
    public static GaikyochosaKomoku09B_17 toValue(RString code) {
        for (GaikyochosaKomoku09B_17 gaikyochosaKomoku09B_17 : GaikyochosaKomoku09B_17.values()) {
            if (gaikyochosaKomoku09B_17.code.equals(code)) {
                return gaikyochosaKomoku09B_17;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-17-09B"));
    }
}

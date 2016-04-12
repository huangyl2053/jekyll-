package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-4-09Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku09A_4 {

    /**
     * コード:004 名称:（介護予防）訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ 略称:定義なし 選択項目名称1:回/月
     */
    _介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ("004", "（介護予防）訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ", "回/月");

    private final RString code;
    private final RString fullName;
    private final RString tani;

    private GaikyochosaKomoku09A_4(String code, String fullname, String tani) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.tani = new RString(tani);
    }

    /**
     * 在宅利用-4-09Aのコードを返します。
     *
     * @return 在宅利用-4-09Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-4-09Aの名称を返します。
     *
     * @return 在宅利用-4-09Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-4-09Aの単位を返します。
     *
     * @return 在宅利用-4-09Aの単位
     */
    public RString get単位() {
        return tani;
    }

    /**
     * 在宅利用-4-09Aのコードと一致する内容を探します。
     *
     * @param code 在宅利用-4-09Aのコード
     * @return {@code code} に対応する在宅利用-4-09A
     */
    public static GaikyochosaKomoku09A_4 toValue(RString code) {
        for (GaikyochosaKomoku09A_4 gaikyochosaKomoku09A_4 : GaikyochosaKomoku09A_4.values()) {
            if (gaikyochosaKomoku09A_4.code.equals(code)) {
                return gaikyochosaKomoku09A_4;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-4-09A"));
    }
}

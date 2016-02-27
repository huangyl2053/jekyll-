package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-4-06Aを表す列挙型です。
 *
 * @author LDNS
 */
public enum GaikyochosaKomoku06A_4 {

    /**
     * コード:004 名称:（介護予防）訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ 略称:定義なし 選択項目名称1:回/月
     */
    _介護予防_訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ("004", "（介護予防）訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝ", "回/月");

    private final RString code;
    private final RString fullName;
    private final RString tani;

    private GaikyochosaKomoku06A_4(String code, String fullname, String tani) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.tani = new RString(tani);
    }

    /**
     * 在宅利用-4-06Aのコードを返します。
     *
     * @return 在宅利用-4-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-4-06Aの名称を返します。
     *
     * @return 在宅利用-4-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-4-06Aの単位を返します。
     *
     * @return 在宅利用-4-06Aの単位
     */
    public RString get単位() {
        return tani;
    }

    /**
     * 在宅利用-4-06Aのコードと一致する内容を探します。
     *
     * @param code 在宅利用-4-06Aのコード
     * @return {@code code} に対応する在宅利用-4-06A
     */
    public static GaikyochosaKomoku06A_4 toValue(RString code) {
        for (GaikyochosaKomoku06A_4 gaikyochosaKomoku06A_4 : GaikyochosaKomoku06A_4.values()) {
            if (gaikyochosaKomoku06A_4.code.equals(code)) {
                return gaikyochosaKomoku06A_4;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-4-06A"));
    }
}

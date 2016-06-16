package jp.co.ndensan.reams.db.dbe.definition.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-1-06Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku06A_1 {

    /**
     * コード:001 名称:（介護予防）訪問介護（ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ） 略称:定義なし 選択項目名称1:回/月
     */
    _介護予防_訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ("001", "（介護予防）訪問介護（ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ）", "回/月");

    private final RString code;
    private final RString fullName;
    private final RString tani;

    private GaikyochosaKomoku06A_1(String code, String fullname, String tani) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.tani = new RString(tani);
    }

    /**
     * 在宅利用-1-06Aのコードを返します。
     *
     * @return 在宅利用-1-06Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-1-06Aの名称を返します。
     *
     * @return 在宅利用-1-06Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-1-06Aの単位を返します。
     *
     * @return 在宅利用-1-06Aの単位
     */
    public RString get単位() {
        return tani;
    }

    /**
     * 在宅利用-1-06Aのコードと一致する内容を探します。
     *
     * @param code 在宅利用-1-06Aのコード
     * @return {@code code} に対応する在宅利用-1-06A
     */
    public static GaikyochosaKomoku06A_1 toValue(RString code) {
        for (GaikyochosaKomoku06A_1 gaikyochosaKomoku06A_1 : GaikyochosaKomoku06A_1.values()) {
            if (gaikyochosaKomoku06A_1.code.equals(code)) {
                return gaikyochosaKomoku06A_1;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-1-06A"));
    }
}

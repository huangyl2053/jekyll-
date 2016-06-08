package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-6-99Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku99A_6 {

    /**
     * コード:006 名称:通所介護（ﾃﾞｲｻｰﾋﾞｽ） 略称:定義なし
     */
    通所介護_ﾃﾞｲｻｰﾋﾞｽ("006", "通所介護（ﾃﾞｲｻｰﾋﾞｽ）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku99A_6(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-6-99Aのコードを返します。
     *
     * @return 在宅利用-6-99Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-6-99Aの名称を返します。
     *
     * @return 在宅利用-6-99Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-6-99Aのコードと一致する内容を探します。
     *
     * @param code 在宅利用-6-99Aのコード
     * @return {@code code} に対応する在宅利用-6-99A
     */
    public static GaikyochosaKomoku99A_6 toValue(RString code) {
        for (GaikyochosaKomoku99A_6 gaikyochosaKomoku99A_6 : GaikyochosaKomoku99A_6.values()) {
            if (gaikyochosaKomoku99A_6.code.equals(code)) {
                return gaikyochosaKomoku99A_6;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-6-99A"));
    }
}

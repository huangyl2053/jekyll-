package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyokomoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 在宅利用-1-02Aを表す列挙型です。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
public enum GaikyochosaKomoku02A_1 {

    /**
     * コード:001 名称:訪問介護（ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ） 略称:定義なし
     */
    訪問介護_ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ("001", "訪問介護（ﾎｰﾑﾍﾙﾌﾟｻｰﾋﾞｽ）");

    private final RString code;
    private final RString fullName;

    private GaikyochosaKomoku02A_1(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 在宅利用-1-02Aのコードを返します。
     *
     * @return 在宅利用-1-02Aのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 在宅利用-1-02Aの名称を返します。
     *
     * @return 在宅利用-1-02Aの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 在宅利用-1-02Aのコードと一致する内容を探します。
     *
     * @param code 在宅利用-1-02Aのコード
     * @return {@code code} に対応する在宅利用-1-02A
     */
    public static GaikyochosaKomoku02A_1 toValue(RString code) {
        for (GaikyochosaKomoku02A_1 gaikyochosaKomoku02A_1 : GaikyochosaKomoku02A_1.values()) {
            if (gaikyochosaKomoku02A_1.code.equals(code)) {
                return gaikyochosaKomoku02A_1;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("在宅利用-1-02A"));
    }
}

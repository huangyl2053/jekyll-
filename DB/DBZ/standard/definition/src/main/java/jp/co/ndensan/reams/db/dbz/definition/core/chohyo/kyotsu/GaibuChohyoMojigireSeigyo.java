package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 外部帳票文字切れ制御を表す列挙型です。
 *
 * @author LDNS
 */
public enum GaibuChohyoMojigireSeigyo {

    /**
     * コード:0 名称:印字しない 略称:定義なし
     */
    印字しない("0", "印字しない"),
    /**
     * コード:1 名称:印字可能範囲まで印字する 略称:定義なし
     */
    印字可能範囲まで印字する("1", "印字可能範囲まで印字する");

    private final RString code;
    private final RString fullName;

    private GaibuChohyoMojigireSeigyo(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 外部帳票文字切れ制御のコードを返します。
     *
     * @return 外部帳票文字切れ制御のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 外部帳票文字切れ制御の名称を返します。
     *
     * @return 外部帳票文字切れ制御の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 外部帳票文字切れ制御のコードと一致する内容を探します。
     *
     * @param code 外部帳票文字切れ制御のコード
     * @return {@code code} に対応する外部帳票文字切れ制御
     */
    public static GaibuChohyoMojigireSeigyo toValue(RString code) {

        for (GaibuChohyoMojigireSeigyo gaibuChohyoMojigireSeigyo : GaibuChohyoMojigireSeigyo.values()) {
            if (gaibuChohyoMojigireSeigyo.code.equals(code)) {
                return gaibuChohyoMojigireSeigyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("外部帳票文字切れ制御"));
    }
}

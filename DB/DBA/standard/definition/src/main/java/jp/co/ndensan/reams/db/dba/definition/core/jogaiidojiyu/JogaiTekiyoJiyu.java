package jp.co.ndensan.reams.db.dba.definition.core.jogaiidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 除外適用事由を表す列挙型です。
 *
 */
public enum JogaiTekiyoJiyu {

    /**
     * コード:01 名称:除外者適用 略称:定義なし
     */
    除外者適用("01", "除外者適用"),
    /**
     * コード:08 名称:職権適用 略称:定義なし
     */
    職権適用("08", "職権適用"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private JogaiTekiyoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 除外適用事由のコードを返します。
     *
     * @return 除外適用事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 除外適用事由の名称を返します。
     *
     * @return 除外適用事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 除外適用事由のコードと一致する内容を探します。
     *
     * @param code 除外適用事由のコード
     * @return {@code code} に対応する除外適用事由
     */
    public static JogaiTekiyoJiyu toValue(RString code) {
        for (JogaiTekiyoJiyu jogaiTekiyoJiyu : JogaiTekiyoJiyu.values()) {
            if (jogaiTekiyoJiyu.code.equals(code)) {
                return jogaiTekiyoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("除外適用事由"));
    }
}

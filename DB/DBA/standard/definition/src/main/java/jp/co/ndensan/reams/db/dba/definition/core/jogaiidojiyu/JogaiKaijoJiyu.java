package jp.co.ndensan.reams.db.dba.definition.core.jogaiidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 除外解除事由を表す列挙型です。
 *
 */
public enum JogaiKaijoJiyu {

    /**
     * コード:51 名称:除外者解除 略称:定義なし
     */
    除外者解除("51", "除外者解除"),
    /**
     * コード:52 名称:除外者転出 略称:定義なし
     */
    除外者転出("52", "除外者転出"),
    /**
     * コード:53 名称:除外者死亡 略称:定義なし
     */
    除外者死亡("53", "除外者死亡"),
    /**
     * コード:58 名称:職権解除 略称:定義なし
     */
    職権解除("58", "職権解除"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private JogaiKaijoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 除外解除事由のコードを返します。
     *
     * @return 除外解除事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 除外解除事由の名称を返します。
     *
     * @return 除外解除事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 除外解除事由のコードと一致する内容を探します。
     *
     * @param code 除外解除事由のコード
     * @return {@code code} に対応する除外解除事由
     */
    public static JogaiKaijoJiyu toValue(RString code) {
        for (JogaiKaijoJiyu jogaiKaijoJiyu : JogaiKaijoJiyu.values()) {
            if (jogaiKaijoJiyu.code.equals(code)) {
                return jogaiKaijoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("除外解除事由"));
    }
}

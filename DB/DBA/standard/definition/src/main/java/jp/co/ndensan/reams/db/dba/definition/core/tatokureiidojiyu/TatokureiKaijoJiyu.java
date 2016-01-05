package jp.co.ndensan.reams.db.dba.definition.core.tatokureiidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他特例解除事由を表す列挙型です。
 *
 */
public enum TatokureiKaijoJiyu {

    /**
     * コード:51 名称:他特例解除 略称:定義なし
     */
    他特例解除("51", "他特例解除"),
    /**
     * コード:52 名称:他特例転出 略称:定義なし
     */
    他特例転出("52", "他特例転出"),
    /**
     * コード:53 名称:他特例死亡 略称:定義なし
     */
    他特例死亡("53", "他特例死亡"),
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

    private TatokureiKaijoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 他特例解除事由のコードを返します。
     *
     * @return 他特例解除事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 他特例解除事由の名称を返します。
     *
     * @return 他特例解除事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 他特例解除事由のコードと一致する内容を探します。
     *
     * @param code 他特例解除事由のコード
     * @return {@code code} に対応する他特例解除事由
     */
    public static TatokureiKaijoJiyu toValue(RString code) {
        for (TatokureiKaijoJiyu tatokureiKaijoJiyu : TatokureiKaijoJiyu.values()) {
            if (tatokureiKaijoJiyu.code.equals(code)) {
                return tatokureiKaijoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("他特例解除事由"));
    }
}

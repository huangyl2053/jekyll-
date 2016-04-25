package jp.co.ndensan.reams.db.dbz.definition.core.jogaiidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 除外解除事由を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum JogaiKaijoJiyu {

    /**
     * コード:51 名称:除外者解除 略称:適用除外解除者【除外解除】
     */
    除外者解除("51", "除外者解除", "適用除外解除者【除外解除】"),
    /**
     * コード:52 名称:除外者転出 略称:適用除外者転出【除外解除】
     */
    除外者転出("52", "除外者転出", "適用除外者転出【除外解除】"),
    /**
     * コード:53 名称:除外者死亡 略称:適用除外者死亡【除外解除】
     */
    除外者死亡("53", "除外者死亡", "適用除外者死亡【除外解除】"),
    /**
     * コード:58 名称:職権解除 略称:適用除外者を職権削除【除外解除】
     */
    職権解除("58", "職権解除", "適用除外者を職権削除【除外解除】"),
    /**
     * コード:99 名称:その他 略称:その他の理由により解除【特殊解除】
     */
    その他("99", "その他", "その他の理由により解除【特殊解除】");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private JogaiKaijoJiyu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
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
     * 除外解除事由の略称を返します。
     *
     * @return 除外解除事由の略称
     */
    public RString get略称() {
        return shortName;
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

package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格住特解除事由を表す列挙型です。
 *
 */
public enum ShikakuJutokuKaijoJiyu {

    /**
     * コード:71 名称:自特例転入 略称:定義なし
     */
    自特例転入("71", "自特例転入"),
    /**
     * コード:72 名称:自特例解除 略称:定義なし
     */
    自特例解除("72", "自特例解除");

    private final RString code;
    private final RString fullName;

    private ShikakuJutokuKaijoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格住特解除事由のコードを返します。
     *
     * @return 資格住特解除事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格住特解除事由の名称を返します。
     *
     * @return 資格住特解除事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格住特解除事由のコードと一致する内容を探します。
     *
     * @param code 資格住特解除事由のコード
     * @return {@code code} に対応する資格住特解除事由
     */
    public static ShikakuJutokuKaijoJiyu toValue(RString code) {
        for (ShikakuJutokuKaijoJiyu shikakuJutokuKaijoJiyu : ShikakuJutokuKaijoJiyu.values()) {
            if (shikakuJutokuKaijoJiyu.code.equals(code)) {
                return shikakuJutokuKaijoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格住特解除事由"));
    }
}

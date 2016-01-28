package jp.co.ndensan.reams.db.dba.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格住特適用事由を表す列挙型です。
 */
public enum ShikakuJutokuTekiyoJiyu {

    /**
     * コード:05 名称:自特例適用 略称:定義なし
     */
    自特例適用("05", "自特例適用");

    private final RString code;
    private final RString fullName;

    private ShikakuJutokuTekiyoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格住特適用事由のコードを返します。
     *
     * @return 資格住特適用事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格住特適用事由の名称を返します。
     *
     * @return 資格住特適用事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格住特適用事由のコードと一致する内容を探します。
     *
     * @param code 資格住特適用事由のコード
     * @return {@code code} に対応する資格住特適用事由
     */
    public static ShikakuJutokuTekiyoJiyu toValue(RString code) {
        for (ShikakuJutokuTekiyoJiyu shikakuJutokuTekiyoJiyu : ShikakuJutokuTekiyoJiyu.values()) {
            if (shikakuJutokuTekiyoJiyu.code.equals(code)) {
                return shikakuJutokuTekiyoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格住特適用事由"));
    }
}

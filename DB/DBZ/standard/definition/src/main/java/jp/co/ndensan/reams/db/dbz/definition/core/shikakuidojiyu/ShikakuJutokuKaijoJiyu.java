package jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格住特解除事由を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShikakuJutokuKaijoJiyu {

    /**
     * コード:71 名称:自特例転入 備考:自住所特例者の転入
     */
    自特例転入("71", "自特例転入", "自住所特例者の転入"),
    /**
     * コード:72 名称:自特例解除 備考:自住所特例者が施設退所外居住
     */
    自特例解除("72", "自特例解除", "自住所特例者が施設退所外居住");

    private final RString code;
    private final RString fullName;
    private final RString bikouName;

    private ShikakuJutokuKaijoJiyu(String code, String fullname, String bikouName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.bikouName = new RString(bikouName);
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
     * 資格住特解除事由の備考を返します。
     *
     * @return 資格住特解除事由の備考
     */
    public RString get備考() {
        return bikouName;
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

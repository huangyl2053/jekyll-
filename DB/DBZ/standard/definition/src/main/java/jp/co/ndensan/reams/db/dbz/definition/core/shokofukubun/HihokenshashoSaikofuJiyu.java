package jp.co.ndensan.reams.db.dbz.definition.core.shokofukubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証を再交付した事由を表す列挙型です。
 *
 * @author LDNS
 */
public enum HihokenshashoSaikofuJiyu {

    /**
     * コード:00 名称:なし 略称:定義なし
     */
    なし("00", "なし"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private HihokenshashoSaikofuJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者証を再交付した事由のコードを返します。
     *
     * @return 被保険者証を再交付した事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者証を再交付した事由の名称を返します。
     *
     * @return 被保険者証を再交付した事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者証を再交付した事由のコードと一致する内容を探します。
     *
     * @param code 被保険者証を再交付した事由のコード
     * @return {@code code} に対応する被保険者証を再交付した事由
     */
    public static HihokenshashoSaikofuJiyu toValue(RString code) {

        for (HihokenshashoSaikofuJiyu hihokenshashoSaikofuJiyu : HihokenshashoSaikofuJiyu.values()) {
            if (hihokenshashoSaikofuJiyu.code.equals(code)) {
                return hihokenshashoSaikofuJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者証を再交付した事由"));
    }
}

package jp.co.ndensan.reams.db.dbz.definition.core.shokofukubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証再交付の有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum HihokenshashoSaikofuKubun {

    /**
     * コード:1 名称:あり 略称:定義なし
     */
    あり("1", "あり"),
    /**
     * コード:2 名称:なし 略称:定義なし
     */
    なし("2", "なし");

    private final RString code;
    private final RString fullName;

    private HihokenshashoSaikofuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者証再交付の有無のコードを返します。
     *
     * @return 被保険者証再交付の有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者証再交付の有無の名称を返します。
     *
     * @return 被保険者証再交付の有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者証再交付の有無のコードと一致する内容を探します。
     *
     * @param code 被保険者証再交付の有無のコード
     * @return {@code code} に対応する被保険者証再交付の有無
     */
    public static HihokenshashoSaikofuKubun toValue(RString code) {

        for (HihokenshashoSaikofuKubun hihokenshashoSaikofuKubun : HihokenshashoSaikofuKubun.values()) {
            if (hihokenshashoSaikofuKubun.code.equals(code)) {
                return hihokenshashoSaikofuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者証再交付の有無"));
    }
}

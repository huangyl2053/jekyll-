package jp.co.ndensan.reams.db.dbd.definition.core.common;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者種類を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HihokenshaShurui {

    /**
     * コード:1 名称:受給者 略称:定義なし
     */
    受給者("1", "受給者"),
    /**
     * コード:2 名称:総合事業対象者 略称:定義なし
     */
    総合事業対象者("2", "総合事業対象者"),
    /**
     * コード:0 名称:非該当 略称:定義なし
     */
    非該当("0", "非該当");

    private final RString code;
    private final RString fullName;

    private HihokenshaShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 被保険者種類のコードを返します。
     *
     * @return 被保険者種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者種類の名称を返します。
     *
     * @return 被保険者種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者種類のコードと一致する内容を探します。
     *
     * @param code 被保険者種類のコード
     * @return {@code code} に対応する被保険者種類
     */
    public static HihokenshaShurui toValue(RString code) {
        for (HihokenshaShurui hihokenshaShurui : HihokenshaShurui.values()) {
            if (hihokenshaShurui.code.equals(code)) {
                return hihokenshaShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者種類"));
    }
}

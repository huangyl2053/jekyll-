package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * みなし更新認定を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-022 sunhaidi
 */
public enum MinashiKoshinNintei {

    /**
     * コード:0 名称:通常認定 略称:定義なし
     */
    通常認定("0", "通常認定"),
    /**
     * コード:1 名称:みなし更新認定 略称:定義なし
     */
    みなし更新認定("1", "みなし更新認定");

    private final RString code;
    private final RString fullName;

    private MinashiKoshinNintei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * みなし更新認定のコードを返します。
     *
     * @return みなし更新認定のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * みなし更新認定の名称を返します。
     *
     * @return みなし更新認定の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * みなし更新認定のコードと一致する内容を探します。
     *
     * @param code みなし更新認定のコード
     * @return {@code code} に対応するみなし更新認定
     */
    public static MinashiKoshinNintei toValue(RString code) {
        for (MinashiKoshinNintei minashiKoshinNintei : MinashiKoshinNintei.values()) {
            if (minashiKoshinNintei.code.equals(code)) {
                return minashiKoshinNintei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}

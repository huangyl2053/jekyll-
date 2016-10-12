package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 算定の基礎を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum SanteiKiso {

    /**
     * コード:0 名称:空白 略称:定義なし
     */
    空白("0", "空白"),
    /**
     * コード:1 名称:保険料率 略称:定義なし
     */
    保険料率("1", "保険料率"),
    /**
     * コード:2 名称:年額保険料 略称:定義なし
     */
    年額保険料("2", "年額保険料"),
    /**
     * コード:3 名称:最終期保険料額 略称:定義なし
     */
    最終期保険料額("3", "最終期保険料額"),
    /**
     * コード:4 名称:保険料率（今年度） 略称:定義なし
     */
    保険料率_今年度("4", "保険料率（今年度）");

    private final RString code;
    private final RString fullName;

    private SanteiKiso(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 算定の基礎のコードを返します。
     *
     * @return 算定の基礎のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 算定の基礎の名称を返します。
     *
     * @return 算定の基礎の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 算定の基礎のコードと一致する内容を探します。
     *
     * @param code 算定の基礎のコード
     * @return {@code code} に対応する算定の基礎
     */
    public static SanteiKiso toValue(RString code) {
        for (SanteiKiso santeiKiso : SanteiKiso.values()) {
            if (santeiKiso.code.equals(code)) {
                return santeiKiso;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("算定の基礎"));
    }
}

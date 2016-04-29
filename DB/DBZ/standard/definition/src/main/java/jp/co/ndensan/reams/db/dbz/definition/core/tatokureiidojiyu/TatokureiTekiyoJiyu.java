package jp.co.ndensan.reams.db.dbz.definition.core.tatokureiidojiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 他特例適用事由を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum TatokureiTekiyoJiyu {

    /**
     * コード:01 名称:他特例適用 略称:他住所特例として適用【特例適用】
     */
    他特例適用("01", "他特例適用", "他住所特例として適用【特例適用】"),
    /**
     * コード:08 名称:職権適用 略称:他住所特例者として職権記載【特例適用】
     */
    職権適用("08", "職権適用", "他住所特例者として職権記載【特例適用】"),
    /**
     * コード:99 名称:その他 略称:その他の理由により適用【特殊適用】
     */
    その他("99", "その他", "その他の理由により適用【特殊適用】");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TatokureiTekiyoJiyu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 他特例適用事由のコードを返します。
     *
     * @return 他特例適用事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 他特例適用事由の略称を返します。
     *
     * @return 他特例適用事由の略称
     */
    public RString get略称() {
        return fullName;
    }

    /**
     * 他特例適用事由の名称を返します。
     *
     * @return 他特例適用事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 他特例適用事由のコードと一致する内容を探します。
     *
     * @param code 他特例適用事由のコード
     * @return {@code code} に対応する他特例適用事由
     */
    public static TatokureiTekiyoJiyu toValue(RString code) {
        for (TatokureiTekiyoJiyu tatokureiTekiyoJiyu : TatokureiTekiyoJiyu.values()) {
            if (tatokureiTekiyoJiyu.code.equals(code)) {
                return tatokureiTekiyoJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("他特例適用事由"));
    }
}

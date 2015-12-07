package jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務分類を表す列挙型です。
 *
 */
public enum GyomuBunrui {

    /**
     * コード:無し 名称:介護事務 略称:定義なし
     */
    介護事務("無し", "介護事務"),
    /**
     * コード:無し 名称:介護事務 略称:定義なし
     */
    介護認定("無し", "介護認定");

    private final RString code;
    private final RString fullName;

    private GyomuBunrui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 業務分類のコードを返します。
     *
     * @return 業務分類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 業務分類の名称を返します。
     *
     * @return 業務分類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 業務分類のコードと一致する内容を探します。
     *
     * @param code 業務分類のコード
     * @return {@code code} に対応する業務分類
     */
    public static GyomuBunrui toValue(RString code) {
        for (GyomuBunrui gyomuBunrui : GyomuBunrui.values()) {
            if (gyomuBunrui.code.equals(code)) {
                return gyomuBunrui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("業務分類"));
    }
}

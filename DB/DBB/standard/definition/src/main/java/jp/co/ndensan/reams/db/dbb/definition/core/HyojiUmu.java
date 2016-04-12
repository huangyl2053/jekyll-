package jp.co.ndensan.reams.db.dbb.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 表示有無を表す列挙型です。
 *
 * @reamsid_L DBA-9999-023 liangbc
 */
public enum HyojiUmu {

    /**
     * コード:0 名称:表示しない 略称:定義なし
     */
    表示しない("0", "表示しない"),
    /**
     * コード:1 名称:表示する 略称:定義なし
     */
    表示する("1", "表示する");

    private final RString code;
    private final RString fullName;

    private HyojiUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 表示有無のコードを返します。
     *
     * @return 表示有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 表示有無の名称を返します。
     *
     * @return 表示有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 表示有無のコードと一致する内容を探します。
     *
     * @param code 表示有無のコード
     * @return {@code code} に対応する表示有無
     */
    public static HyojiUmu toValue(RString code) {
        for (HyojiUmu hyojiUmu : HyojiUmu.values()) {
            if (hyojiUmu.code.equals(code)) {
                return hyojiUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("表示有無"));
    }
}

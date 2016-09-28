package jp.co.ndensan.reams.db.dbd.definition.core.jukyunintei.yokaigointerface;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護ＩＦ_ＩＦ種類を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum YokaigoInterfaceShurui {

    /**
     * コード:1 名称:厚労省 略称:定義なし
     */
    厚労省("1", "厚労省"),
    /**
     * コード:2 名称:電算 略称:定義なし
     */
    電算("2", "電算"),
    /**
     * コード:5 名称:富士通１ 略称:定義なし
     */
    富士通１("5", "富士通１"),
    /**
     * コード:6 名称:ＢＳＮ 略称:定義なし
     */
    ＢＳＮ("6", "ＢＳＮ"),
    /**
     * コード:7 名称:富士通２ 略称:定義なし
     */
    富士通２("7", "富士通２"),
    /**
     * コード:8 名称:ＦＮＳ 略称:定義なし
     */
    ＦＮＳ("8", "ＦＮＳ"),
    /**
     * コード:9 名称:ＮＥＣ 略称:定義なし
     */
    ＮＥＣ("9", "ＮＥＣ");

    private final RString code;
    private final RString fullName;

    private YokaigoInterfaceShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護ＩＦ_ＩＦ種類のコードを返します。
     *
     * @return 要介護ＩＦ_ＩＦ種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護ＩＦ_ＩＦ種類の名称を返します。
     *
     * @return 要介護ＩＦ_ＩＦ種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護ＩＦ_ＩＦ種類のコードと一致する内容を探します。
     *
     * @param code 要介護ＩＦ_ＩＦ種類のコード
     * @return {@code code} に対応する要介護ＩＦ_ＩＦ種類
     */
    public static YokaigoInterfaceShurui toValue(RString code) {
        for (YokaigoInterfaceShurui yokaigoInterfaceShurui : YokaigoInterfaceShurui.values()) {
            if (yokaigoInterfaceShurui.code.equals(code)) {
                return yokaigoInterfaceShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護ＩＦ_ＩＦ種類"));
    }
}

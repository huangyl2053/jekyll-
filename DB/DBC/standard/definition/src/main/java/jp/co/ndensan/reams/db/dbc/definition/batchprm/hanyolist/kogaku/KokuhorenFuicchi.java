package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 国保連不一致を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KokuhorenFuicchi {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:支給額不一致 略称:定義なし
     */
    支給額不一致("1", "支給額不一致"),
    /**
     * コード:2 名称:決定額不一致 略称:定義なし
     */
    決定額不一致("2", "決定額不一致");

    private final RString code;
    private final RString fullName;

    private KokuhorenFuicchi(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 国保連不一致のコードを返します。
     *
     * @return 国保連不一致のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 国保連不一致の名称を返します。
     *
     * @return 国保連不一致の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 国保連不一致のコードと一致する内容を探します。
     *
     * @param code 国保連不一致のコード
     * @return {@code code} に対応する国保連不一致
     */
    public static KokuhorenFuicchi toValue(RString code) {
        for (KokuhorenFuicchi kokuhorenFuicchi : KokuhorenFuicchi.values()) {
            if (kokuhorenFuicchi.code.equals(code)) {
                return kokuhorenFuicchi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("国保連不一致"));
    }
}

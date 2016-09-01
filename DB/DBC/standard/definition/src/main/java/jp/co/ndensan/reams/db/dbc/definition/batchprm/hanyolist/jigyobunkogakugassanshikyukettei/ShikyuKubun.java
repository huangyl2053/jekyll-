package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ShikyuKubun {

    /**
     * コード:0 名称:すべて 略称:無
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:支給 略称:無
     */
    支給("1", "支給"),
    /**
     * コード:2 名称:不支給 略称:無
     */
    不支給("2", "不支給");

    private final RString code;
    private final RString fullName;

    private ShikyuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支給区分のコードを返します。
     *
     * @return 支給区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支給区分の名称を返します。
     *
     * @return 支給区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支給区分のコードと一致する内容を探します。
     *
     * @param code 支給区分のコード
     * @return {@code code} に対応する支給区分
     */
    public static ShikyuKubun toValue(RString code) {
        for (ShikyuKubun shikyuKubun : ShikyuKubun.values()) {
            if (shikyuKubun.code.equals(code)) {
                return shikyuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支給区分"));
    }
}

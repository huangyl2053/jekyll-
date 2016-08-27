package jp.co.ndensan.reams.db.dbc.definition.core.futanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合区分を表す列挙型です。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public enum FutanwariaiKubun {

    /**
     * コード:1 名称:１割 略称:無
     */
    _１割("1", "１割"),
    /**
     * コード:2 名称:２割 略称:無
     */
    _２割("2", "２割");

    private final RString code;
    private final RString fullName;

    private FutanwariaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 負担割合区分のコードを返します。
     *
     * @return 負担割合区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 負担割合区分の名称を返します。
     *
     * @return 負担割合区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 負担割合区分のコードと一致する内容を探します。
     *
     * @param code 高額介護サービス費支給区分のコード
     * @return {@code code} に対応する負担割合区分
     */
    public static FutanwariaiKubun toValue(RString code) {
        for (FutanwariaiKubun futanWariai : FutanwariaiKubun.values()) {
            if (futanWariai.code.equals(code)) {
                return futanWariai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合区分"));
    }
}

package jp.co.ndensan.reams.db.dbz.definition.core.futanwariai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担割合区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 xuyue
 */
public enum FutanwariaiKubun {

    /**
     * コード:10 名称:１割 略称:定義なし
     */
    _１割("10", "１割"),
    /**
     * コード:20 名称:２割 略称:定義なし
     */
    _２割("20", "２割");

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
     * @param code 負担割合区分のコード
     * @return {@code code} に対応する負担割合区分
     */
    public static FutanwariaiKubun toValue(RString code) {
        for (FutanwariaiKubun futanwariaiKubun : FutanwariaiKubun.values()) {
            if (futanwariaiKubun.code.equals(code)) {
                return futanwariaiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("負担割合区分"));
    }
}

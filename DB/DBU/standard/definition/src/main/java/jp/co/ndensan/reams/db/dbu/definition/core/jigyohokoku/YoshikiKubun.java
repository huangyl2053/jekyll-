package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 様式区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum YoshikiKubun {

    /**
     * コード:1 名称:新様式 略称:定義なし
     */
    新様式("1", "新様式"),
    /**
     * コード:2 名称:旧様式 略称:定義なし
     */
    旧様式("2", "旧様式");

    private final RString code;
    private final RString fullName;

    private YoshikiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 様式区分のコードを返します。
     *
     * @return 様式区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 様式区分の名称を返します。
     *
     * @return 様式区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 様式区分のコードと一致する内容を探します。
     *
     * @param code 様式区分のコード
     * @return {@code code} に対応する様式区分
     */
    public static YoshikiKubun toValue(RString code) {
        for (YoshikiKubun yoshikiKubun : YoshikiKubun.values()) {
            if (yoshikiKubun.code.equals(code)) {
                return yoshikiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("様式区分"));
    }
}

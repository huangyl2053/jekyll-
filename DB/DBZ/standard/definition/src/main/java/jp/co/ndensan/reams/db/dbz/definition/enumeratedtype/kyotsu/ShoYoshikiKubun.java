package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 証様式区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShoYoshikiKubun {

    /**
     * コード:02 名称:新様式２ 略称:定義なし
     */
    新様式２("02", "新様式２"),
    /**
     * コード:01 名称:新様式 略称:定義なし
     */
    新様式("01", "新様式"),
    /**
     * コード:00 名称:旧様式 略称:定義なし
     */
    旧様式("00", "旧様式");

    private final RString code;
    private final RString fullName;

    private ShoYoshikiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 証様式区分のコードを返します。
     *
     * @return 証様式区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 証様式区分の名称を返します。
     *
     * @return 証様式区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 証様式区分のコードと一致する内容を探します。
     *
     * @param code 証様式区分のコード
     * @return {@code code} に対応する証様式区分
     */
    public static ShoYoshikiKubun toValue(RString code) {

        for (ShoYoshikiKubun shoYoshikiKubun : ShoYoshikiKubun.values()) {
            if (shoYoshikiKubun.code.equals(code)) {
                return shoYoshikiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("証様式区分"));
    }
}

package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 月を表す列挙型です。
 *
 * @author LDNS
 */
public enum Tsuki {

    /**
     * コード:04 名称:_4月 略称:定義なし
     */
    _4月("04", "_4月"),
    /**
     * コード:05 名称:_5月 略称:定義なし
     */
    _5月("05", "_5月"),
    /**
     * コード:06 名称:_6月 略称:定義なし
     */
    _6月("06", "_6月"),
    /**
     * コード:07 名称:_7月 略称:定義なし
     */
    _7月("07", "_7月"),
    /**
     * コード:08 名称:_8月 略称:定義なし
     */
    _8月("08", "_8月"),
    /**
     * コード:09 名称:_9月 略称:定義なし
     */
    _9月("09", "_9月"),
    /**
     * コード:10 名称:_10月 略称:定義なし
     */
    _10月("10", "_10月"),
    /**
     * コード:11 名称:_11月 略称:定義なし
     */
    _11月("11", "_11月"),
    /**
     * コード:12 名称:_12月 略称:定義なし
     */
    _12月("12", "_12月"),
    /**
     * コード:01 名称:_1月 略称:定義なし
     */
    _1月("01", "_1月"),
    /**
     * コード:02 名称:_2月 略称:定義なし
     */
    _2月("02", "_2月"),
    /**
     * コード:03 名称:_3月 略称:定義なし
     */
    _3月("03", "_3月"),
    /**
     * コード:14 名称:翌年度4月 略称:定義なし
     */
    翌年度4月("14", "翌年度4月"),
    /**
     * コード:15 名称:翌年度5月 略称:定義なし
     */
    翌年度5月("15", "翌年度5月");

    private final RString code;
    private final RString fullName;

    private Tsuki(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 月のコードを返します。
     *
     * @return 月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 月の名称を返します。
     *
     * @return 月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 月のコードと一致する内容を探します。
     *
     * @param code 月のコード
     * @return {@code code} に対応する月
     */
    public static Tsuki toValue(RString code) {
        for (Tsuki tsuki : Tsuki.values()) {
            if (tsuki.code.equals(code)) {
                return tsuki;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("月"));
    }
}

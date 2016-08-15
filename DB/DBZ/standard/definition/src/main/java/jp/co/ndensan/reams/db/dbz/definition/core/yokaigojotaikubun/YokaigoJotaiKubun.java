package jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分コード02を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum YokaigoJotaiKubun {

    /**
     * コード:01 名称:非該当 略称:非該
     */
    非該当("01", "非該当", "非該"),
    /**
     * コード:06 名称:事業対象外 略称:事外
     */
    事業対象外("06", "事業対象外", "事外"),
    /**
     * コード:09 名称:みなし非該当 略称:み非
     */
    みなし非該当("09", "みなし非該当", "み非"),
    /**
     * コード:11 名称:要支援_経過的要介護 略称:経介
     */
    要支援_経過的要介護("11", "要支援_経過的要介護", "経介"),
    /**
     * コード:11 名称:要支援 略称:支援
     */
    要支援1("12", "要支援1", "支1"),
    /**
     * コード:11 名称:要支援 略称:支援
     */
    要支援2("13", "要支援2", "支2"),
    /**
     * コード:19 名称:みなし要支援 略称:み支
     */
    みなし要支援("19", "みなし要支援", "み支"),
    /**
     * コード:21 名称:要介護1 略称:介1
     */
    要介護1("21", "要介護1", "介1"),
    /**
     * コード:22 名称:要介護2 略称:介2
     */
    要介護2("22", "要介護2", "介2"),
    /**
     * コード:23 名称:要介護3 略称:介3
     */
    要介護3("23", "要介護3", "介3"),
    /**
     * コード:24 名称:要介護4 略称:介4
     */
    要介護4("24", "要介護4", "介4"),
    /**
     * コード:25 名称:要介護5 略称:介5
     */
    要介護5("25", "要介護5", "介5"),
    /**
     * コード:31 名称:再調査 略称:再調
     */
    再調査("31", "再調査", "再調"),
    /**
     * コード:32 名称:照会 略称:照会
     */
    照会("32", "照会", "照会"),
    /**
     * コード:88 名称:取消 略称:定義なし
     */
    取消("88", "取消", "取消"),
    /**
     * コード:98 名称:保留 略称:保留
     */
    保留("98", "保留", "保留"),
    /**
     * コード:99 名称:なし 略称:定義なし
     */
    なし("99", "なし", "なし");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private YokaigoJotaiKubun(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 要介護状態区分コード02のコードを返します。
     *
     * @return 要介護状態区分コード02のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護状態区分コード02の略称を返します。
     *
     * @return 要介護状態区分コード02の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 要介護状態区分コード02の名称を返します。
     *
     * @return 要介護状態区分コード02の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護状態区分コード02のコードと一致する内容を探します。
     *
     * @param code 要介護状態区分コード02のコード
     * @return {@code code} に対応する要介護状態区分コード02
     */
    public static YokaigoJotaiKubun toValue(RString code) {

        for (YokaigoJotaiKubun yokaigoJotaiKubun02 : YokaigoJotaiKubun.values()) {
            if (yokaigoJotaiKubun02.code.equals(code)) {
                return yokaigoJotaiKubun02;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分コード02"));
    }
}

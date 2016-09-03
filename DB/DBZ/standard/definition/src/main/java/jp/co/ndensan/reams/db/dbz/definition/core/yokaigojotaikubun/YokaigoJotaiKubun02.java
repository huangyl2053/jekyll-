package jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分コード02を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum YokaigoJotaiKubun02 {

    /**
     * コード:01 名称:非該 略称:定義なし
     */
    非該当("01", "非該"),
    /**
     * コード:11 名称:支援 略称:定義なし
     */
    要支援("11", "支援"),
    /**
     * コード:21 名称:介1 略称:定義なし
     */
    要介護1("21", "介1"),
    /**
     * コード:22 名称:介2 略称:定義なし
     */
    要介護2("22", "介2"),
    /**
     * コード:23 名称:介3 略称:定義なし
     */
    要介護3("23", "介3"),
    /**
     * コード:24 名称:介4 略称:定義なし
     */
    要介護4("24", "介4"),
    /**
     * コード:25 名称:介5 略称:定義なし
     */
    要介護5("25", "介5"),
    /**
     * コード:31 名称:再調 略称:定義なし
     */
    再調査("31", "再調"),
    /**
     * コード:88 名称:取消 略称:定義なし
     */
    取消("88", "取消"),
    /**
     * コード:99 名称:なし 略称:定義なし
     */
    なし("99", "なし");

    private final RString code;
    private final RString fullName;

    private YokaigoJotaiKubun02(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
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
    public static YokaigoJotaiKubun02 toValue(RString code) {

        for (YokaigoJotaiKubun02 yokaigoJotaiKubun02 : YokaigoJotaiKubun02.values()) {
            if (yokaigoJotaiKubun02.code.equals(code)) {
                return yokaigoJotaiKubun02;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分コード02"));
    }
}

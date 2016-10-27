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
     * コード:01 名称:非該当 略称:非該
     */
    非該当("01", "非該当", "非該"),
    /**
     * コード:11 名称:要支援 略称:支援
     */
    要支援("11", "要支援", "支援"),
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
     * コード:88 名称:取消 略称:定義なし
     */
    取消("88", "取消", "取消"),
    /**
     * コード:99 名称:なし 略称:定義なし
     */
    なし("99", "なし", "なし");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private YokaigoJotaiKubun02(String code, String fullname, String shortName) {
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
    public static YokaigoJotaiKubun02 toValue(RString code) {

        for (YokaigoJotaiKubun02 yokaigoJotaiKubun02 : YokaigoJotaiKubun02.values()) {
            if (yokaigoJotaiKubun02.code.equals(code)) {
                return yokaigoJotaiKubun02;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護状態区分コード02"));
    }
}


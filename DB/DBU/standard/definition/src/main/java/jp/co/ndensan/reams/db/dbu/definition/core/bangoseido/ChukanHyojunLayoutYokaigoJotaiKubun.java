package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 中間標準レイアウト仕様要介護状態区分を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum ChukanHyojunLayoutYokaigoJotaiKubun {

    /**
     * コード:00 名称:自立 略称:定義なし
     */
    自立("00", "自立"),
    /**
     * コード:11 名称:経過的要介護 略称:定義なし
     */
    経過的要介護("11", "経過的要介護"),
    /**
     * コード:12 名称:要支援1 略称:定義なし
     */
    要支援1("12", "要支援1"),
    /**
     * コード:13 名称:要支援2 略称:定義なし
     */
    要支援2("13", "要支援2"),
    /**
     * コード:21 名称:要介護1 略称:定義なし
     */
    要介護1("21", "要介護1"),
    /**
     * コード:22 名称:要介護2 略称:定義なし
     */
    要介護2("22", "要介護2"),
    /**
     * コード:23 名称:要介護3 略称:定義なし
     */
    要介護3("23", "要介護3"),
    /**
     * コード:24 名称:要介護4 略称:定義なし
     */
    要介護4("24", "要介護4"),
    /**
     * コード:25 名称:要介護5 略称:定義なし
     */
    要介護5("25", "要介護5"),
    /**
     * コード:31 名称:再調査 略称:定義なし
     */
    再調査("31", "再調査"),
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

    private ChukanHyojunLayoutYokaigoJotaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 中間標準レイアウト仕様要介護状態区分のコードを返します。
     *
     * @return 中間標準レイアウト仕様要介護状態区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 中間標準レイアウト仕様要介護状態区分の名称を返します。
     *
     * @return 中間標準レイアウト仕様要介護状態区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 中間標準レイアウト仕様要介護状態区分のコードと一致する内容を探します。
     *
     * @param code 中間標準レイアウト仕様要介護状態区分のコード
     * @return {@code code} に対応する中間標準レイアウト仕様要介護状態区分
     */
    public static ChukanHyojunLayoutYokaigoJotaiKubun toValue(RString code) {
        for (ChukanHyojunLayoutYokaigoJotaiKubun value : ChukanHyojunLayoutYokaigoJotaiKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}

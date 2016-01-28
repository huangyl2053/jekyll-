package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一次判定結果コード09を表す列挙型です。
 *
 * @author LDNS
 */
public enum IchijiHanteiKekkaCode09 {

    /**
     * コード:01 名称:非該当 略称:定義なし
     */
    非該当("01", "非該当"),
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
    要介護5("25", "要介護5");

    private final RString code;
    private final RString fullName;

    private IchijiHanteiKekkaCode09(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 要介護認定一次判定結果コード09のコードを返します。
     *
     * @return 要介護認定一次判定結果コード09のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 要介護認定一次判定結果コード09の名称を返します。
     *
     * @return 要介護認定一次判定結果コード09の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護認定一次判定結果コード09のコードと一致する内容を探します。
     *
     * @param code 要介護認定一次判定結果コード09のコード
     * @return {@code code} に対応する要介護認定一次判定結果コード09
     */
    public static IchijiHanteiKekkaCode09 toValue(RString code) {

        for (IchijiHanteiKekkaCode09 ichijiHanteiKekkaCode09 : IchijiHanteiKekkaCode09.values()) {
            if (ichijiHanteiKekkaCode09.code.equals(code)) {
                return ichijiHanteiKekkaCode09;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護認定一次判定結果コード09"));
    }
}

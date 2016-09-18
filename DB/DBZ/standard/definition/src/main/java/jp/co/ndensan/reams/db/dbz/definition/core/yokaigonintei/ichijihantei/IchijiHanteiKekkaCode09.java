/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一次判定結果コード09を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public enum IchijiHanteiKekkaCode09 implements IIchijiHanteiKekkaCode {

    /**
     * コード:01 名称:非該 略称:定義なし
     */
    非該当("01", "非該当", "非該"),
    /**
     * コード:12 名称:支1 略称:定義なし
     */
    要支援1("12", "要支援1", "支1"),
    /**
     * コード:13 名称:支2 略称:定義なし
     */
    要支援2("13", "要支援2", "支2"),
    /**
     * コード:21 名称:介1 略称:定義なし
     */
    要介護1("21", "要介護1", "介1"),
    /**
     * コード:22 名称:介2 略称:定義なし
     */
    要介護2("22", "要介護2", "介2"),
    /**
     * コード:23 名称:要介護3 略称:定義なし
     */
    要介護3("23", "要介護3", "介3"),
    /**
     * コード:24 名称:要介護4 略称:定義なし
     */
    要介護4("24", "要介護4", "介4"),
    /**
     * コード:25 名称:介5 略称:定義なし
     */
    要介護5("25", "要介護5", "介5");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private IchijiHanteiKekkaCode09(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 要介護認定一次判定結果コード09のコードを返します。
     *
     * @return 要介護認定一次判定結果コード09のコード
     */
    @Override
    public RString getコード() {
        return code;
    }

    /**
     * 要介護認定一次判定結果コード09の名称を返します。
     *
     * @return 要介護認定一次判定結果コード09の名称
     */
    @Override
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護認定一次判定結果コード09の略称を返します。
     *
     * @return 要介護認定一次判定結果コード09の略称
     */
    @Override
    public RString get略称() {
        return shortName;
    }

    /**
     * 要介護認定一次判定結果コード09のコードと一致する内容を探します。
     *
     * @param code 要介護認定一次判定結果コード09のコード
     * @return {@code code} に対応する要介護認定一次判定結果コード09
     */
    public static IchijiHanteiKekkaCode09 toValue(RString code) {
        IchijiHanteiKekkaCode09 value = toValueOrNull(code);
        if (value == null) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護認定一次判定結果コード09"));
        }
        return value;
    }

    static IchijiHanteiKekkaCode09 toValueOrNull(RString code) {
        for (IchijiHanteiKekkaCode09 ichijiHanteiKekkaCode09 : IchijiHanteiKekkaCode09.values()) {
            if (ichijiHanteiKekkaCode09.code.equals(code)) {
                return ichijiHanteiKekkaCode09;
            }
        }
        return null;
    }
}

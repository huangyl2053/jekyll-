/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一次判定結果コード06を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public enum IchijiHanteiKekkaCode06 implements IIchijiHanteiKekkaCode {

    /**
     * コード:01 名称:非該 略称:無
     */
    非該当("01", "非該"),
    /**
     * コード:11 名称:経介 略称:無
     */
    経過的要介護("11", "経介"),
    /**
     * コード:12 名称:支1 略称:無
     */
    要支援1("12", "支1"),
    /**
     * コード:13 名称:支2 略称:無
     */
    要支援2("13", "支2"),
    /**
     * コード:21 名称:介1 略称:無
     */
    要介護1("21", "介1"),
    /**
     * コード:22 名称:介2 略称:無
     */
    要介護2("22", "介2"),
    /**
     * コード:23 名称:介3 略称:無
     */
    要介護3("23", "介3"),
    /**
     * コード:24 名称:介4 略称:無
     */
    要介護4("24", "介4"),
    /**
     * コード:25 名称:介5 略称:無
     */
    要介護5("25", "介5");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private IchijiHanteiKekkaCode06(String code, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(name());
        this.shortName = new RString(shortName);
    }

    /**
     * 要介護認定一次判定結果コード06のコードを返します。
     *
     * @return 要介護認定一次判定結果コード06のコード
     */
    @Override
    public RString getコード() {
        return code;
    }

    /**
     * 要介護認定一次判定結果コード06の名称を返します。
     *
     * @return 要介護認定一次判定結果コード06の名称
     */
    @Override
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護認定一次判定結果コード06の略称を返します。
     *
     * @return 要介護認定一次判定結果コード06の略称
     */
    @Override
    public RString get略称() {
        return shortName;
    }

    /**
     * 要介護認定一次判定結果コード06のコードと一致する内容を探します。
     *
     * @param code 要介護認定一次判定結果コード06のコード
     * @return {@code code} に対応する要介護認定一次判定結果コード06
     */
    public static IchijiHanteiKekkaCode06 toValue(RString code) {
        IchijiHanteiKekkaCode06 value = toValueOrNull(code);
        if (value == null) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護認定一次判定結果コード02"));
        }
        return value;
    }

    static IchijiHanteiKekkaCode06 toValueOrNull(RString code) {
        for (IchijiHanteiKekkaCode06 ichijiHanteiKekkaCode06 : IchijiHanteiKekkaCode06.values()) {
            if (ichijiHanteiKekkaCode06.code.equals(code)) {
                return ichijiHanteiKekkaCode06;
            }
        }
        return null;
    }
}

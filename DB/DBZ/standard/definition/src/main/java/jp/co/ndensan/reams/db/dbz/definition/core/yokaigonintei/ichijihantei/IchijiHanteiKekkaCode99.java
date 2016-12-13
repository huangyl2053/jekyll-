/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定一次判定結果コード99を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public enum IchijiHanteiKekkaCode99 implements IIchijiHanteiKekkaCode {

    /**
     * コード:01 名称:非該 略称:無
     */
    非該当("01", "非該当", "非該"),
    /**
     * コード:09 名称:み非 略称:無
     */
    みなし非該当("09", "みなし非該当", "み非"),
    /**
     * コード:11 名称:経介 略称:無
     */
    経過的要介護("11", "経過的要介護", "経介"),
    /**
     * コード:19 名称:み支 略称:無
     */
    みなし要支援("19", "みなし要支援", "み支"),
    /**
     * コード:21 名称:介1 略称:無
     */
    要介護1("21", "要介護１", "介1"),
    /**
     * コード:22 名称:介2 略称:無
     */
    要介護2("22", "要介護２", "介2"),
    /**
     * コード:23 名称:介3 略称:無
     */
    要介護3("23", "要介護３", "介3"),
    /**
     * コード:24 名称:介4 略称:無
     */
    要介護4("24", "要介護４", "介4"),
    /**
     * コード:25 名称:介5 略称:無
     */
    要介護5("25", "要介護５", "介5");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private IchijiHanteiKekkaCode99(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 要介護認定一次判定結果コード99のコードを返します。
     *
     * @return 要介護認定一次判定結果コード99のコード
     */
    @Override
    public RString getコード() {
        return code;
    }

    /**
     * 要介護認定一次判定結果コード99の名称を返します。
     *
     * @return 要介護認定一次判定結果コード99の名称
     */
    @Override
    public RString get名称() {
        return fullName;
    }

    /**
     * 要介護認定一次判定結果コード99の略称を返します。
     *
     * @return 要介護認定一次判定結果コード99の略称
     */
    @Override
    public RString get略称() {
        return shortName;
    }

    /**
     * 要介護認定一次判定結果コード99のコードと一致する内容を探します。
     *
     * @param code 要介護認定一次判定結果コード99のコード
     * @return {@code code} に対応する要介護認定一次判定結果コード99
     */
    public static IchijiHanteiKekkaCode99 toValue(RString code) {
        IchijiHanteiKekkaCode99 value = toValueOrNull(code);
        if (value == null) {
            throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("要介護認定一次判定結果コード99"));
        }
        return value;
    }

    /**
     * 要介護認定一次判定結果コード99のコードと一致する内容を探します。
     *
     * @param code 要介護認定一次判定結果コード99のコード
     * @return {@code code} に対応する要介護認定一次判定結果コード99
     */
    public static IchijiHanteiKekkaCode99 toValueOrNull(RString code) {
        for (IchijiHanteiKekkaCode99 ichijiHanteiKekkaCode99 : IchijiHanteiKekkaCode99.values()) {
            if (ichijiHanteiKekkaCode99.code.equals(code)) {
                return ichijiHanteiKekkaCode99;
            }
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core;

import static jp.co.ndensan.reams.db.dbx.definition.core.GaitoHigaitoKubun.values;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 該当非該当区分の列挙型クラスです。
 *
 * @author N3317 塚田 萌
 */
public enum GaitoHigaitoKubun implements IRStringConvertable {

    /**
     * 非該当 <br />
     * コード : 0。
     */
    非該当("0"),
    /**
     * 該当 <br />
     * コード : 1。
     */
    該当("1");
    private final RString code;

    private GaitoHigaitoKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString getCode() {
        return this.code;
    }

    /**
     * 指定のコードに対応するGaitoHigaitoKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するGaitoHigaitoKubun
     * @throws IllegalArgumentException 指定のコードに対応するGaitoHigaitoKubunがないとき
     */
    public static GaitoHigaitoKubun toValue(RString code) throws IllegalArgumentException {
        for (GaitoHigaitoKubun target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する該当非該当区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

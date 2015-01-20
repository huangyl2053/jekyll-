/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 課税区分の列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum KazeiKubun implements IRStringConvertable {

    /**
     * 課税 <br />
     * コード : 1
     */
    課税("1"),
    /**
     * 非課税 <br />
     * コード : 2
     */
    非課税("2"),
    /**
     * 未申告 <br />
     * コード : 3
     */
    未申告("3"),
    /**
     * 所得調査中 <br />
     * コード : 4
     */
    所得調査中("4"),
    /**
     * 課税取消 <br />
     * コード : 5
     */
    課税取消("5");
    private final RString code;

    private KazeiKubun(String code) {
        this.code = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return コード
     */
    public RString code() {
        return this.code;
    }

    /**
     * 指定のコードに対応するKazeiKubunを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するKazeiKubun
     * @throws IllegalArgumentException 指定のコードに対応するKazeiKubunがないとき
     */
    public static KazeiKubun toValue(RString code) throws IllegalArgumentException {
        for (KazeiKubun target : values()) {
            if (target.code().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する課税区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.core.shotoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.strings.IRStringConvertable;

/**
 * 激変緩和措置区分の列挙型です。
 */
public enum GekihenkanwaSochi implements IRStringConvertable {

    /**
     * 対象外 <br />
     * コード : 0
     */
    対象外("0"),
    /**
     * 対象 <br />
     * コード : 1
     */
    対象("1");
    private final RString code;

    private GekihenkanwaSochi(String code) {
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
     * 指定のコードに対応するGekihenkanwaSochiを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するGekihenkanwaSochi
     * @throws IllegalArgumentException 指定のコードに対応するGekihenkanwaSochiがないとき
     */
    public static GekihenkanwaSochi toValue(RString code) throws IllegalArgumentException {
        for (GekihenkanwaSochi target : values()) {
            if (target.code().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する激変緩和措置区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

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
 * 徴収方法の列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum ChoshuHoho implements IRStringConvertable {

    /**
     * 特別徴収_厚生労働省 <br />
     * コード : 1
     */
    特別徴収_厚生労働省("1"),
    /**
     * 特別徴収_地共済 <br />
     * コード : 2
     */
    特別徴収_地共済("2"),
    /**
     * 普通徴収 <br />
     * コード : 3
     */
    普通徴収("3");
    private final RString code;

    private ChoshuHoho(String code) {
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
     * 指定のコードに対応するChoshuHohoを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するChoshuHoho
     * @throws IllegalArgumentException 指定のコードに対応するChoshuHohoがないとき
     */
    public static ChoshuHoho toValue(RString code) throws IllegalArgumentException {
        for (ChoshuHoho target : values()) {
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

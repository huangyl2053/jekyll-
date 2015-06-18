/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請届出代行区分の列挙型です。
 *
 * @author n8223　朴義一
 */
public enum ShinseiTodokedeDaikoKubunCode implements IRStringConvertable {

    /**
     * 本人 <br/>
     * 本人 : 1
     */
    本人("1"),
    /**
     * 家族 <br/>
     * 家族 : 2
     */
    家族("2"),
    /**
     * 委任 <br/>
     * 委任 : 3
     */
    委任("3"),
    /**
     * 代行 <br/>
     * 代行 : 4
     */
    代行("4"),
    /**
     * その他 <br/>
     * その他 : 9
     */
    その他("9");
    private final RString code;

    private ShinseiTodokedeDaikoKubunCode(String code) {
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
     * 指定のコードに対応するShinseiTodokedeDaikoKubunCodeを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するShinseiTodokedeDaikoKubunCode
     * @throws IllegalArgumentException
     * 指定のコードに対応するShinseiTodokedeDaikoKubunCodeがないとき
     */
    public static ShinseiTodokedeDaikoKubunCode toValue(RString code) throws IllegalArgumentException {
        for (ShinseiTodokedeDaikoKubunCode target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する申請届出代行区分").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

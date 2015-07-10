/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.fuka;

import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課照会の表示モードの列挙型です。
 *
 * @author N3317 塚田 萌
 */
public enum FukaShokaiDisplayMode implements IRStringConvertable {

    /**
     * 初回 <br />
     * コード : 0
     */
    初回("first"),
    /**
     * 2回目以降 <br />
     * コード : 1
     */
    二回目以降("second");
    private final RString code;

    private FukaShokaiDisplayMode(String code) {
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
     * 指定のコードに対応するFukaShokaiDisplayModeを返します。
     *
     * @param code コード
     * @return 指定のコードに対応するFukaShokaiDisplayMode
     * @throws IllegalArgumentException 指定のコードに対応するFukaShokaiDisplayModeがないとき
     */
    public static FukaShokaiDisplayMode toValue(RString code) throws IllegalArgumentException {
        for (FukaShokaiDisplayMode target : values()) {
            if (target.getCode().equals(code)) {
                return target;
            }
        }
        throw new IllegalArgumentException(UrErrorMessages.存在しない
                .getMessage().replace("コードに対応する賦課照会表示モード").evaluate());
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }
}

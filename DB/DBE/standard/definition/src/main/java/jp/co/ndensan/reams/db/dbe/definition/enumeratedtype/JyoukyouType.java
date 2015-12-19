/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.ICodeValueEnumeratedType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 状況を定義する列挙型です。
 */
public enum JyoukyouType implements ICodeValueEnumeratedType {

    /**
     * 有効のみを表す列挙体です。
     */
    有効のみ("1"),
    /**
     * 無効のみを表す列挙体です。
     */
    無効のみ("2"),
    /**
     * 全てを表す列挙体です。
     */
    全て("3");

    private final RString code;

    private JyoukyouType(String code) {
        this.code = new RString(code);
    }

    @Override
    public RString code() {
        return code;
    }

    @Override
    public RString toRString() {
        return new RString(this.toString());
    }

    /**
     * 該当する列挙型がない場合はnullを返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static JyoukyouType toValue(RString code) {
        for (JyoukyouType target : JyoukyouType.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("除外対象の列挙型(" + code.toString() + ")").toString());
    }

}

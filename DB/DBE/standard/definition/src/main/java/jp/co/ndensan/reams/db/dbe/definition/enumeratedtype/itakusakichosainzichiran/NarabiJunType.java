/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.itakusakichosainzichiran;

import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.ICodeValueEnumeratedType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 並び順を定義する列挙型です。
 */
public enum NarabiJunType implements ICodeValueEnumeratedType {

    /**
     * 委託先コード+調査員コードを表す列挙体です。
     */
    委託先コード_調査員コード("1"),
    /**
     * 委託先コード+調査員氏名を表す列挙体です。
     */
    委託先コード_調査員氏名("2"),
    /**
     * 委託先コード+調査員カナ氏名を表す列挙体です。
     */
    委託先コード_調査員カナ氏名("3"),
    /**
     * 委託先名称+調査員コードを表す列挙体です。
     */
    委託先名称_調査員コード("4"),
    /**
     * 委託先名称+調査員氏名を表す列挙体です。
     */
    委託先名称_調査員氏名("5"),
    /**
     * 委託先名称+調査員カナ氏名を表す列挙体です。
     */
    委託先名称_調査員カナ氏名("6");

    private final RString code;

    private NarabiJunType(String code) {
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
     * 引数のコードに対応する列挙型を返します。
     * <p/>
     * 該当する列挙型がない場合はnullを返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static NarabiJunType toValue(RString code) {
        for (NarabiJunType target : NarabiJunType.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("除外対象の列挙型(" + code.toString() + ")").toString());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.itakusakichosainzichiran;

import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.ICodeValueEnumeratedType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 改頁を定義する列挙型です。
 *
 * @reamsid_L DBE-0290-010 dongyabin
 */
public enum NextPageType implements ICodeValueEnumeratedType {

    /**
     * 有効のみを表す列挙体です。
     */
    委託先コード("1"),
    /**
     * 無効のみを表す列挙体です。
     */
    なし("2");

    private final RString code;

    private NextPageType(String code) {
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
    public static NextPageType toValue(RString code) {
        for (NextPageType target : NextPageType.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("除外対象の列挙型(" + code.toString() + ")").toString());
    }

}

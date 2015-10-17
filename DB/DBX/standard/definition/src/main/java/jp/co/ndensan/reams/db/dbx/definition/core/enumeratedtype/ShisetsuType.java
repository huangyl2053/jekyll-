/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.ICodeValueEnumeratedType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;

/**
 * 施設種類を表す列挙型です。
 *
 * @author N3317 塚田 萌
 * @jpName 施設種類
 * @bizDomain 介護
 * @category 施設種類
 * @subCategory
 * @mainClass
 * @reference
 */
public enum ShisetsuType implements ICodeValueEnumeratedType {

    /**
     * 施設種類が「介護保険施設」であることを表します。 <br />
     * コード：11
     */
    介護保険施設("11"),
    /**
     * 施設種類が「住所地特例対象施設」であることを表します。 <br />
     * コード：12
     */
    住所地特例対象施設("12"),
    /**
     * 施設種類が「適用除外施設」であることを表します。 <br />
     * コード：21
     */
    適用除外施設("21"),
    /**
     * 未定義：（△）を表す列挙体です。
     * <p/>
     * コードには空白（nullでない）が定義されます。
     */
    未定義("");
    private final RString code;

    private ShisetsuType(String code) {
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
     * 引数が{@code null}の場合は{@code ShisetsuType.未定義}を返します。<br />
     * 該当する列挙型がない場合は{@code IllegalArgumentException}を返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static ShisetsuType toValue(RString code) {
        if (code == null) {
            return 未定義;
        }
        for (ShisetsuType target : ShisetsuType.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("施設種類に値(" + code.toString() + ")").evaluate());
    }
}

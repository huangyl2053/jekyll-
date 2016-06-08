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
 * 台帳種別を表す列挙型です。
 *
 * @author N3317 塚田 萌
 * @jpName 台帳種別
 * @bizDomain 介護
 * @category 台帳種別
 * @subCategory
 * @mainClass
 * @reference
 */
public enum DaichoType implements ICodeValueEnumeratedType {

    /**
     * 台帳種別が「被保険者」であることを表します。 <br />
     * コード：1
     */
    被保険者("1"),
    /**
     * 台帳種別が「他市町村住所地特例者」であることを表します。 <br />
     * コード：2
     */
    他市町村住所地特例者("2"),
    /**
     * 台帳種別が「適用除外者」であることを表します。 <br />
     * コード：3
     */
    適用除外者("3"),
    /**
     * 未定義：（△）を表す列挙体です。
     * <p/>
     * コードには空白（nullでない）が定義されます。
     */
    未定義("");
    private final RString code;

    private DaichoType(String code) {
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
     * 引数が{@code null}の場合は{@code DaichoType.未定義}を返します。<br />
     * 該当する列挙型がない場合は{@code IllegalArgumentException}を返します。
     *
     * @param code 検索対象のコード
     * @return コードに該当する列挙型
     */
    public static DaichoType toValue(RString code) {
        if (code == null) {
            return 未定義;
        }
        for (DaichoType target : DaichoType.values()) {
            if (target.code().compareTo(code) == 0) {
                return target;
            }
        }
        throw new IllegalArgumentException(
                UrErrorMessages.存在しない.getMessage().replace("台帳種別に値(" + code.toString() + ")").evaluate());
    }
}

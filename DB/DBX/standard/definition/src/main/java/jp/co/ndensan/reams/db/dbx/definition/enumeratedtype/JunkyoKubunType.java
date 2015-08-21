/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.enumeratedtype;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.ICodeValueEnumeratedType;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 準拠区分を表す列挙型です。
 *
 * @author N8187 久保田 英男
 * @jpName 準拠区分
 * @bizDomain 介護
 * @category 介護事業者指定サービス
 * @subCategory
 * @mainClass
 * @reference
 */
public enum JunkyoKubunType implements ICodeValueEnumeratedType {

    /**
     * 準拠区分が「準拠しない」であることを表します。 <br />
     * コード：0
     */
    準拠しない("0"),
    /**
     * 準拠区分が「準拠する」であることを表します。 <br />
     * コード：1
     */
    準拠する("1");

    private final RString theCode;

    private JunkyoKubunType(String code) {
        this.theCode = new RString(code);
    }

    /**
     * コードを返します。
     *
     * @return 準拠区分コード
     */
    public RString code() {
        return theCode;
    }

    /**
     * {@link #name() name()}を{@link RString}へ変換して返します。
     *
     * @return {@link #name() name()}を{@link RString}へ変換した物
     */
    public RString toRString() {
        return new RString(name());
    }

    /**
     * 引数のコードに対応する{@link JunkyoKubunType}を返します。
     *
     * @param code コード
     * @return コードに対応する{@link JunkyoKubunType}
     * @throws IllegalArgumentException コードに対応する{@link JunkyoKubunType}が無い時
     */
    public static JunkyoKubunType toValue(RString code) throws IllegalArgumentException {
        for (JunkyoKubunType data : values()) {
            if (data.code().equals(code)) {
                return data;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage(JunkyoKubunType.class.getSimpleName()));
    }
}

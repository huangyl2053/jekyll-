/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ICodeWrapValueObject;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 一次判定警告コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class IchijiHanteiKeikokuCode implements ICodeWrapValueObject, Comparable<IchijiHanteiKeikokuCode> {

    private final Code code;

    /**
     * 一次判定警告コードを表す文字列を受け取り、インスタンスを生成します。
     *
     * @param code 一次判定警告コード
     */
    public IchijiHanteiKeikokuCode(Code code) {
        this.code = code;
    }

    @Override
    public Code asCode() {
        return this.code;
    }

    @Override
    public RString value() {
        return this.code.value();
    }

    @Override
    public int compareTo(IchijiHanteiKeikokuCode 比較対象) {
        return this.value().compareTo(比較対象.value());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((IchijiHanteiKeikokuCode) 比較対象).value().equals(this.value());
    }
}

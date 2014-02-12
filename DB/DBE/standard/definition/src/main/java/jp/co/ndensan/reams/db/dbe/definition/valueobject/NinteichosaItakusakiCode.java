/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static java.util.Objects.requireNonNull;

/**
 * 認定調査委託先コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaItakusakiCode implements IDbColumnMappable, IValueObject {

    private final RString 認定調査委託先コード;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NinteichosaItakusakiCode(RString 認定調査委託先コード) throws NullPointerException {
        this.認定調査委託先コード = requireNonNull(認定調査委託先コード);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.認定調査委託先コード);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((NinteichosaItakusakiCode) 比較対象).getColumnValue().equals(認定調査委託先コード);
    }

    @Override
    public RString getColumnValue() {
        return 認定調査委託先コード;
    }

    @Override
    public RString value() {
        return 認定調査委託先コード;
    }
}

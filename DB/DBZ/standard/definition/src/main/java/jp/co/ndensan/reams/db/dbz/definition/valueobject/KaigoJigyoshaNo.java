/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

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
public class KaigoJigyoshaNo implements IDbColumnMappable, IValueObject {

    private final RString 介護事業者番号;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 介護事業者番号 認定調査委託先コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public KaigoJigyoshaNo(RString 介護事業者番号) throws NullPointerException {
        this.介護事業者番号 = requireNonNull(介護事業者番号);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.介護事業者番号);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((KaigoJigyoshaNo) 比較対象).getColumnValue().equals(介護事業者番号);
    }

    @Override
    public RString getColumnValue() {
        return 介護事業者番号;
    }

    @Override
    public RString value() {
        return 介護事業者番号;
    }
}

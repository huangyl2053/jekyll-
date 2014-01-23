/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 被保険者番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class HihokenshaNo implements IDbColumnMappable {

    private final RString 被保険者番号;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     */
    public HihokenshaNo(RString 被保険者番号) {
        this.被保険者番号 = requireNonNull(被保険者番号);
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString getValue() {
        return 被保険者番号;
    }

    @Override
    public String toString() {
        return 被保険者番号.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.getValue());
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || (getClass() != 比較対象.getClass())) {
            return false;
        }
        return ((HihokenshaNo) 比較対象).getValue().equals(被保険者番号);
    }

    @Override
    public RString getColumnValue() {
        return 被保険者番号;
    }
}

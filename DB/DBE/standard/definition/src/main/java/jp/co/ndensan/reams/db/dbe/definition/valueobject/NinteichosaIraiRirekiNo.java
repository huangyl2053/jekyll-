/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import static java.util.Objects.requireNonNull;

/**
 * 認定調査依頼履歴番号を表すValueObjectです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiRirekiNo implements IValueObject<RString>, IDbColumnMappable {

    private final RString 認定調査依頼履歴番号;

    /**
     * 引数から値を受け取るコンストラクタです。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @throws NullPointerException 引数にNullが渡されたとき
     */
    public NinteichosaIraiRirekiNo(RString 認定調査依頼履歴番号) throws NullPointerException {
        this.認定調査依頼履歴番号 = requireNonNull(認定調査依頼履歴番号);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.認定調査依頼履歴番号.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((NinteichosaIraiRirekiNo) 比較対象).value().equals(this.value());
    }

    @Override
    public RString getColumnValue() {
        return 認定調査依頼履歴番号;
    }

    @Override
    public RString value() {
        return 認定調査依頼履歴番号;
    }
}

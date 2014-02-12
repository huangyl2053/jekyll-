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
 * 認定調査依頼履歴番号を表すクラスです
 *
 * @author n8178 城間篤人
 */
public class NinteichosaIraiRirekiNo implements IDbColumnMappable, IValueObject {

    private final RString 認定調査依頼履歴番号;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public NinteichosaIraiRirekiNo(RString 認定調査依頼履歴番号) throws NullPointerException {
        this.認定調査依頼履歴番号 = requireNonNull(認定調査依頼履歴番号);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.認定調査依頼履歴番号);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ((NinteichosaIraiRirekiNo) obj).getColumnValue().equals(認定調査依頼履歴番号);
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

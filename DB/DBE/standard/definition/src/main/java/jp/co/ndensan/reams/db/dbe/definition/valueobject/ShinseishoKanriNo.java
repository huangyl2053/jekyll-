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
 * 申請書管理番号を表すドメインです。
 *
 * @author n8178 城間篤人
 */
public class ShinseishoKanriNo implements IDbColumnMappable, IValueObject {

    private final RString 申請書管理番号;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ShinseishoKanriNo(RString 申請書管理番号) throws NullPointerException {
        this.申請書管理番号 = requireNonNull(申請書管理番号);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.申請書管理番号);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ShinseishoKanriNo) 比較対象).getColumnValue().equals(申請書管理番号);
    }

    @Override
    public RString getColumnValue() {
        return 申請書管理番号;
    }

    @Override
    public RString value() {
        return 申請書管理番号;
    }
}

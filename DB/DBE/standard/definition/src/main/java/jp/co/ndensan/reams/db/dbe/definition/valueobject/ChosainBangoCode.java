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
 * 調査員番号コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ChosainBangoCode implements IDbColumnMappable, IValueObject {

    private final RString 調査員番号コード;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 調査員番号コード 調査員番号コード
     * @throws NullPointerException 引数にnullが渡されたとき
     */
    public ChosainBangoCode(RString 調査員番号コード) throws NullPointerException {
        this.調査員番号コード = requireNonNull(調査員番号コード);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(調査員番号コード);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((ChosainBangoCode) 比較対象).getColumnValue().equals(調査員番号コード);
    }

    @Override
    public RString getColumnValue() {
        return 調査員番号コード;
    }

    @Override
    public RString value() {
        return 調査員番号コード;
    }
}

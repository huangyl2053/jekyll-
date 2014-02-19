/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 介護認定で使用する、申請書管理番号を表すクラスです。
 *
 * @author N8187 久保田 英男, n8178 城間篤人
 */
public class ShinseishoKanriNo implements IDbColumnMappable, IValueObject<RString> {

    private RString 申請書管理番号;

    /**
     * コンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public ShinseishoKanriNo(RString 申請書管理番号) {
        this.申請書管理番号 = requireNonNull(申請書管理番号);
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    @Override
    public RString getColumnValue() {
        return 申請書管理番号;
    }

    @Override
    public RString value() {
        return 申請書管理番号;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.value());
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || (getClass() != 比較対象.getClass())) {
            return false;
        }
        return ((ShinseishoKanriNo) 比較対象).value().equals(申請書管理番号);
    }
}

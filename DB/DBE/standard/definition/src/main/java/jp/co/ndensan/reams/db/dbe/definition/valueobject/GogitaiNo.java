/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 合議体番号を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaiNo implements IValueObject<Integer>, IDbColumnMappable {

    private final int 合議体番号;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 合議体番号 合議体番号
     */
    public GogitaiNo(int 合議体番号) {
        this.合議体番号 = 合議体番号;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.合議体番号);
        return hash;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null || getClass() != 比較対象.getClass()) {
            return false;
        }
        return ((GogitaiNo) 比較対象).value().equals(合議体番号);
    }

    @Override
    public Integer value() {
        return 合議体番号;
    }

    @Override
    public Integer getColumnValue() {
        return 合議体番号;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.valueobject;

import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.IValueObject;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * レコード種別コード
 *
 * @author n8223
 */
public class RecodeShubetsuCode implements   IDbColumnMappable , IValueObject ,Comparable<RecodeShubetsuCode> {
  
    private final RString recodeShubetsuCode;

    /**
     * コンストラクタです
     *
     * @param レコード種別コード レコード種別コード
     */
    public RecodeShubetsuCode(RString recodeShubetsuCode) throws NullPointerException {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    @Override
    public RString value() {
        return recodeShubetsuCode;
    }

    @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof RecodeShubetsuCode)) {
            return false;
        }
        return ((RecodeShubetsuCode) 比較対象).value().equals(recodeShubetsuCode);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.recodeShubetsuCode);
        return hash;
    }

    /**
     * レコード種別コードを取得します
     *
     * @return レコード種別コード
     */
    @Override
    public RString getColumnValue() {
        return recodeShubetsuCode;
    }

    @Override
    public int compareTo(RecodeShubetsuCode 比較対象) {
        return value().compareTo(比較対象.value());
    }

}

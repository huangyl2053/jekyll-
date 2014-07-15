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
 * 給付実績区分コード
 * 
 * @author n8223
 */
public class KyufuJissekiKubunCode implements   IDbColumnMappable , IValueObject ,Comparable<KyufuJissekiKubunCode>{

    private final RString kyufuJissekiKubunCode;
    
    /**
     * コンストラクタです
     *
     * @param 給付実績区分コード 給付実績区分コード
     */
    public KyufuJissekiKubunCode(RString kyufuJissekiKubunCode)throws NullPointerException {
        this.kyufuJissekiKubunCode = kyufuJissekiKubunCode;
    }
    
    @Override
    public RString value() {
        return kyufuJissekiKubunCode;
    }
    
     @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KokanShikibetsuNo)) {
            return false;
        }
        return ((KyufuJissekiKubunCode) 比較対象).value().equals(kyufuJissekiKubunCode);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.kyufuJissekiKubunCode);
        return hash;
    }
    
     /**
     * 給付実績区分コードを取得します
     *
     * @return 給付実績区分コード
     */
    @Override
    public RString getColumnValue() {
        return kyufuJissekiKubunCode;
    }
        
    @Override
    public int compareTo(KyufuJissekiKubunCode 比較対象) {
        return value().compareTo(比較対象.value());
    }

}

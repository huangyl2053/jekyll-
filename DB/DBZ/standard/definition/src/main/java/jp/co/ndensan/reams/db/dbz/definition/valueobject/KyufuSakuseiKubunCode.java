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
 * 給付実績情報作成区分コード
 * 
 * @author n8223
 */
public class KyufuSakuseiKubunCode implements IDbColumnMappable , IValueObject ,Comparable<KyufuSakuseiKubunCode>{

    private final RString kyufuSakuseiKubunCode;
    
    /**
     * コンストラクタです
     *
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     */
    public KyufuSakuseiKubunCode(RString kyufuSakuseiKubunCode)throws NullPointerException {
        this.kyufuSakuseiKubunCode = kyufuSakuseiKubunCode;
    }
    
    @Override
    public RString value() {
        return kyufuSakuseiKubunCode;
    }
    
     @Override
    public boolean equals(Object 比較対象) {
        if (比較対象 == null) {
            return false;
        }
        if (!(比較対象 instanceof KyufuSakuseiKubunCode)) {
            return false;
        }
        return ((KyufuSakuseiKubunCode) 比較対象).value().equals(kyufuSakuseiKubunCode);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.kyufuSakuseiKubunCode);
        return hash;
    }
    
     /**
     * 給付実績情報作成区分コードを取得します
     *
     * @return 給付実績区分コード
     */
    @Override
    public RString getColumnValue() {
        return kyufuSakuseiKubunCode;
    }
        
    @Override
    public int compareTo(KyufuSakuseiKubunCode 比較対象) {
        return value().compareTo(比較対象.value());
    }

}

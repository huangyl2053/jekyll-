/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hokensha;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author 863
 */
public class ServiceTypeModel implements Serializable {

    private RString 保険者名;
    private RString 保険者コード;

    /**
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return 保険者名;
    }

    /**
     * 保険者コードを返します。
     *
     * @return 保険者コード
     */
    public RString get保険者コード() {
        return 保険者コード;
    }

    /**
     * 保険者名を設定します。
     *
     * @param 保険者名
     */
    public void set保険者名(RString 保険者名) {
        this.保険者名 = 保険者名;
    }

    /**
     * 保険者コードを設定します。
     *
     * @param 保険者コード
     */
    public void set保険者コード(RString 保険者コード) {
        this.保険者コード = 保険者コード;
    }
}

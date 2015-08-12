/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder.Value;
import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 介護保険者の識別子です。
 */
@Value
public class KaigoHokenshaIdentifier implements Serializable {

    private final LasdecCode 広域保険者市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 広域保険者市町村コード 広域保険者市町村コード
     */
    public KaigoHokenshaIdentifier(LasdecCode 広域保険者市町村コード) {
        this.広域保険者市町村コード = 広域保険者市町村コード;
    }
}

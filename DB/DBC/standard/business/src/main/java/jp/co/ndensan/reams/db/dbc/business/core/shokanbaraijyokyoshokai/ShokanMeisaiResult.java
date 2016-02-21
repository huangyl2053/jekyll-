/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求明細一覧取得の返却結果
 */
@lombok.Getter
@lombok.Setter
public class ShokanMeisaiResult implements Serializable {

    private ShokanMeisai entity;
    private RString serviceName;

    public ShokanMeisaiResult(ShokanMeisai entity, RString serviceName) {
        this.entity = entity;
        this.serviceName = serviceName;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisai;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求明細一覧取得の返却結果
 */
@lombok.Getter
@lombok.Setter
public class ShokanMeisaiResult {

    private ShokanMeisai entity;
    private RString serviceName;

    public ShokanMeisaiResult(ShokanMeisai entity, RString serviceName) {
        this.entity = entity;
        this.serviceName = serviceName;
    }
}

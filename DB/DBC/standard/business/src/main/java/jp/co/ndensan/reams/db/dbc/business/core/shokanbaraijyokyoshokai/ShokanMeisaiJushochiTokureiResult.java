/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanbaraijyokyoshokai;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanMeisaiJushochiTokurei;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払請求明細住特一覧取得の返却結果
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanMeisaiJushochiTokureiResult implements Serializable {

    private ShokanMeisaiJushochiTokurei entity;
    private RString serviceName;
    private RString hokenshaName;

    /**
     * 償還払請求明細住特一覧取得の返却結果を生成します
     *
     * @param entity ShokanMeisaiJushochiTokurei
     * @param serviceName RString
     * @param hokenshaName RString
     */
    public ShokanMeisaiJushochiTokureiResult(ShokanMeisaiJushochiTokurei entity,
            RString serviceName,
            RString hokenshaName) {
        this.entity = entity;
        this.serviceName = serviceName;
        this.hokenshaName = hokenshaName;
    }
}

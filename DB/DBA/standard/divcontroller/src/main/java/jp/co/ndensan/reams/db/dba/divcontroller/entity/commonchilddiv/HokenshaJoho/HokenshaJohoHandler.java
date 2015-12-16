/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.HokenshaJoho;

import jp.co.ndensan.reams.db.dba.business.core.hokensha.Hokensha;

/**
 *
 * {@link HokenshaJohoDiv}のHandlerクラスです。
 */
public class HokenshaJohoHandler {

    private final HokenshaJohoDiv div;

    public HokenshaJohoHandler(HokenshaJohoDiv div) {
        this.div = div;
    }

    public void onBlur_txtHokenshaNo(Hokensha hokensha) {
        if (hokensha != null) {
            div.getTxtHokenshaMeisho().setValue(hokensha.get保険者名());
        }
    }
}

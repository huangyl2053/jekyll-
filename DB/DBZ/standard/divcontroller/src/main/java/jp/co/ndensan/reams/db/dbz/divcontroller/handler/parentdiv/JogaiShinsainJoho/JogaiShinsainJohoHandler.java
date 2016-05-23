/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.JogaiShinsainJoho;

import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.JogaiShinsainJohoDiv;

/**
 * 除外審査員情報の画面処理Handlerクラスです。
 *
 * @reamsid_L DBE-1300-040 dongyabin
 */
public class JogaiShinsainJohoHandler {

    private final JogaiShinsainJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public JogaiShinsainJohoHandler(JogaiShinsainJohoDiv div) {
        this.div = div;
    }

    /**
     * 画面項目にセットされている値をクリアします。
     */
    public void 画面項目にセットされている値をクリア() {
        div.getTxtShinsakaiIinCode().clearValue();
        div.getTxtShinsakaiIinName().clearValue();
    }

}

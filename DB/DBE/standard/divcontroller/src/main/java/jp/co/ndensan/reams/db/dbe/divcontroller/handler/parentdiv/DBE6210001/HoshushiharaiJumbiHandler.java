/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6210001;

import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6210001.HoshushiharaiJumbiDiv;

/**
 * 画面設計_DBE6210001_報酬支払い準備Handlerクラスです
 *
 * @reamsid_L DBE-1980-010 xuyongchao
 */
public class HoshushiharaiJumbiHandler {

    private final HoshushiharaiJumbiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public HoshushiharaiJumbiHandler(HoshushiharaiJumbiDiv div) {
        this.div = div;
    }

    /**
     * 発行するボタン処理です
     */
    public void onClick_btnHakkou() {
        div.getTxtJissekiDateRange().getFromValue();
        div.getTxtJissekiDateRange().getToValue();
        div.getTxtFurikomiShiteiDay().getValue();
        div.getChkChosa().getSelectedKeys();
        div.getChkShujii().getSelectedKeys();
        div.getChkShinsakai().getSelectedKeys();
    }
}

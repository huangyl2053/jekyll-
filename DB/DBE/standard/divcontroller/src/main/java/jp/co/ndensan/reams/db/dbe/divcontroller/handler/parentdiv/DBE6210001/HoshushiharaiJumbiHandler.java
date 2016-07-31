/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6210001;

import jp.co.ndensan.reams.db.dbe.definition.batchprm.hoshushiharaijunbi.HoshuShiharaiJunbiBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6210001.HoshushiharaiJumbiDiv;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

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
     *
     * @return HoshuShiharaiJunbiBatchParameter
     */
    public HoshuShiharaiJunbiBatchParameter onClick_btnHakkou() {
        HoshuShiharaiJunbiBatchParameter batchParameter = new HoshuShiharaiJunbiBatchParameter();
        FlexibleDate fbFrom = new FlexibleDate(div.getTxtJissekiDateRange().getFromValue().toDateString());
        FlexibleDate fbTo = new FlexibleDate(div.getTxtJissekiDateRange().getToValue().toDateString());
        batchParameter.setJissekidaterangefrom(fbFrom);
        batchParameter.setJissekidaterangeto(fbTo);
        batchParameter.setFurikomishiteiday(div.getTxtFurikomiShiteiDay().getValue());
        batchParameter.setChkchosa(div.getChkChosa().getSelectedKeys());
        batchParameter.setChkshinsakai(div.getChkShinsakai().getSelectedKeys());
        batchParameter.setChkshujii(div.getChkShujii().getSelectedKeys());
        return batchParameter;
    }
}

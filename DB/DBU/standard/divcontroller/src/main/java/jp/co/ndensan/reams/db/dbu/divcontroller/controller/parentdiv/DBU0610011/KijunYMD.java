/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0610011;

import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.FukaSummary;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.JukyuSummary;
import jp.co.ndensan.reams.db.dbu.business.core.tokeijoho.ShikakuSummary;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0610011.KijunYMDDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0610011.KijunYMDHandler;
import jp.co.ndensan.reams.db.dbu.service.core.tokeijoho.TokeiJohoResearcher;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 統計情報照会を制御します。
 *
 * @reamsid_L DBU-4120-010 sunhaidi
 */
public class KijunYMD {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<KijunYMDDiv>
     */
    public ResponseData<KijunYMDDiv> onLoad(KijunYMDDiv div) {
        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
        getHandler(div).onLoad(市町村情報);
        return ResponseData.of(div).respond();
    }

    /**
     * 集計ボタンを押下します。
     *
     * @param div 画面情報
     * @return ResponseData<KijunYMDDiv>
     */
    public ResponseData<KijunYMDDiv> onClick_btnShukei(KijunYMDDiv div) {
        TokeiJohoResearcher tokeiJohoResearcher = new TokeiJohoResearcher();
        FlexibleDate 基準日 = new FlexibleDate(div.getTxtKijunYMD().getValue().toDateString());
        LasdecCode 市町村コード = null;
        if (!div.getCcdCitySelect().isDisplayNone()) {
            市町村コード = div.getCcdCitySelect().getSelectedItem().get市町村コード();
        }
        ShikakuSummary shikakuSummary = tokeiJohoResearcher.getShikakuSummary(基準日, 市町村コード);
        FukaSummary fukaSummary = tokeiJohoResearcher.getFukaSummary(基準日, 市町村コード);
        JukyuSummary jukyuSummary = tokeiJohoResearcher.getJukyuSummary(基準日, 市町村コード);
        getHandler(div).setData(shikakuSummary, fukaSummary, jukyuSummary);
        return ResponseData.of(div).respond();
    }

    private KijunYMDHandler getHandler(KijunYMDDiv div) {
        return new KijunYMDHandler(div);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.controller.parentdiv.DBU0610011;

/**
 * 統計情報照会を制御します。
 *
 * @reamsid_L DBU-4120-010 sunhaidi
 */
public class ToukeiJyohoSyokai {

    /**
     * 画面初期化処理です。
     *
     * @param div 画面情報
     * @return ResponseData<ToukeiJyohoSyokaiDiv>
     */
//    public ResponseData<ToukeiJyohoSyokaiDiv> onLoad(ToukeiJyohoSyokaiDiv div) {
//        ShichosonSecurityJoho 市町村情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);
//        getHandler(div).onLoad(市町村情報);
//        return ResponseData.of(div).respond();
//    }
//
//    /**
//     * 集計ボタンを押下します。
//     *
//     * @param div 画面情報
//     * @return ResponseData<ToukeiJyohoSyokaiDiv>
//     */
//    public ResponseData<ToukeiJyohoSyokaiDiv> onClick_btnShukei(ToukeiJyohoSyokaiDiv div) {
//
//        FlexibleDate 基準日 = new FlexibleDate(div.getTxtKijunYMD().getValue().toDateString());
//        LasdecCode 市町村コード = null;
//        if (!div.getCcdCitySelect().isDisplayNone()) {
//            市町村コード = div.getCcdCitySelect().getSelectedItem().get市町村コード();
//        }
//        TokeiJohoResearcher tokeiJohoResearcher = TokeiJohoResearcher.createInstance();
//        ShikakuSummary shikakuSummary = tokeiJohoResearcher.getShikakuSummary(基準日, 市町村コード);
//        FukaSummary fukaSummary = tokeiJohoResearcher.getFukaSummary(基準日, 市町村コード);
//        JukyuSummary jukyuSummary = tokeiJohoResearcher.getJukyuSummary(基準日, 市町村コード);
//        getHandler(div).setData(shikakuSummary, fukaSummary, jukyuSummary);
//        return ResponseData.of(div).respond();
//    }
//
//    private ToukeiJyohoSyokaiHandler getHandler(ToukeiJyohoSyokaiDiv div) {
//        return new ToukeiJyohoSyokaiHandler(div);
//    }
}

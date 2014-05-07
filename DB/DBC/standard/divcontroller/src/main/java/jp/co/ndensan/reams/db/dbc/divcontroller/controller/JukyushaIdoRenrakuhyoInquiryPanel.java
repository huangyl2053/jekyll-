///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.divcontroller.controller;
//
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoGemmenGengakuDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoInquiryPanelDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKihonJohoDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyotakuServicePlanDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoKyufuSeigenDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoNijiyoboJigyoDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoRojinHokenDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoSearchPanelDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JukyushaIdoRenrakuhyoYokaigoninteiDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJukyushaIdoRenrakuhyoSearchResult_Row;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//
///**
// * 受給者異動連絡票情報照会の照会パネルです。
// *
// * @author N3317 塚田 萌
// */
//public class JukyushaIdoRenrakuhyoInquiryPanel {
//
//    /**
//     * 照会パネル読み込み時は、検索条件に基づいた連絡票情報を表示します。
//     *
//     * @param inquiryPanel 照会パネル
//     * @param searchPanel 検索パネル
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoInquiryPanelDiv> onLoad(
//            JukyushaIdoRenrakuhyoInquiryPanelDiv inquiryPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//
//        set連絡票(inquiryPanel,
//                searchPanel.getJukyushaIdoRenrakuhyoSearchResultIchiran().getDgJukyushaIdoRenrakuhyoSearchResult().getClickedItem());
//
//        ResponseData<JukyushaIdoRenrakuhyoInquiryPanelDiv> response = new ResponseData<>();
//        response.data = inquiryPanel;
//
//        return response;
//    }
//
//    /**
//     * 再検索ボタンが押された時は特別な処理はせず、検索パネルに戻る。
//     *
//     * @param inquiryPanel 照会パネル
//     * @param searchPanel 検索パネル
//     * @return ResponseData
//     */
//    public ResponseData<JukyushaIdoRenrakuhyoInquiryPanel> onClick_btnReSearch(
//            JukyushaIdoRenrakuhyoInquiryPanel inquiryPanel, JukyushaIdoRenrakuhyoSearchPanelDiv searchPanel) {
//        ResponseData<JukyushaIdoRenrakuhyoInquiryPanel> response = new ResponseData<>();
//        response.data = inquiryPanel;
//        return response;
//    }
//
//    private void set連絡票(JukyushaIdoRenrakuhyoInquiryPanelDiv inquiryPanel, dgJukyushaIdoRenrakuhyoSearchResult_Row selectedRow) {
//        set基本情報(inquiryPanel.getJukyushaIdoRenrakuhyoKihonJoho(), selectedRow);
//        set要介護認定(inquiryPanel.getJukyushaIdoRenrakuhyoSub1().getJukyushaIdoRenrakuhyoYokaigonintei());
//        set支給限度基準額(inquiryPanel.getJukyushaIdoRenrakuhyoSub1().getJukyushaIdoRenrakuhyoShikyugendoKijungaku());
//        set居宅サービス計画(inquiryPanel.getJukyushaIdoRenrakuhyoSub1().getJukyushaIdoRenrakuhyoKyotakuServicePlan());
//        set給付制限(inquiryPanel.getJukyushaIdoRenrakuhyoSub2().getJukyushaIdoRenrakuhyoKyufuSeigen());
//        set後期高齢国保(inquiryPanel.getJukyushaIdoRenrakuhyoSub1().getJukyushaIdoRenrakuhyoKokiKoreiKokuho());
//        set老人保健(inquiryPanel.getJukyushaIdoRenrakuhyoSub1().getJukyushaIdoRenrakuhyoRojinHoken());
//        set減免減額(inquiryPanel.getJukyushaIdoRenrakuhyoSub2().getJukyushaIdoRenrakuhyoGemmenGengaku());
//        set二次予防事業(inquiryPanel.getJukyushaIdoRenrakuhyoSub1().getJukyushaIdoRenrakuhyoNijiyoboJigyo());
//
//    }
//
//    private void set基本情報(JukyushaIdoRenrakuhyoKihonJohoDiv kihonJohoDiv, dgJukyushaIdoRenrakuhyoSearchResult_Row selectedRow) {
//
//        kihonJohoDiv.getTxtRenrakuhyoHihoNo().setValue(selectedRow.getTxtResultHihoNo().getValue());
//        kihonJohoDiv.getTxtRenrakuhyoHihoName().setValue(selectedRow.getTxtResultHihoName().getValue());
//        kihonJohoDiv.getTxtRenrakuhyoSendYM().setValue(selectedRow.getTxtResultSendYM().getValue());
//        kihonJohoDiv.getTxtRenrakuhyoIdoDate().setValue(selectedRow.getTxtResultIdoDate().getValue());
//
//        kihonJohoDiv.getTxtShikakuShutokuDate().setValue(new FlexibleDate("20111111"));
//        kihonJohoDiv.getTxtHihoBirthday().setValue(new FlexibleDate("20111111"));
//        kihonJohoDiv.getTxtShokisaiHokenshaNo().setValue(new RString("123456"));
//    }
//
//    private void set要介護認定(JukyushaIdoRenrakuhyoYokaigoninteiDiv 要介護認定Div) {
//        要介護認定Div.getTxtShinseiDate().setValue(new FlexibleDate("20111111"));
//        要介護認定Div.getTxtNinteiDateRange().setFromValue(new RDate("20111111"));
//        要介護認定Div.getTxtNinteiDateRange().setToValue(new RDate("20111111"));
//
//    }
//
//    private void set支給限度基準額(JukyushaIdoRenrakuhyoShikyugendoKijungakuDiv 支給限度基準額Div) {
//        支給限度基準額Div.getTxtKyuHomonTsushoShikyuGendoKijungaku().setValue(new Decimal("1000"));
//        支給限度基準額Div.getTxtKyuHomonTsushoKanriTekiyoDateRange().setFromValue(new RDate("20111111"));
//        支給限度基準額Div.getTxtKyuHomonTsushoKanriTekiyoDateRange().setToValue(new RDate("20111111"));
//
//        支給限度基準額Div.getTxtKyuTankiNyushoShikyuGendoKijungaku().setValue(new Decimal("1000"));
//        支給限度基準額Div.getTxtKyuTankiNyushoKanriTekiyoDateRange().setFromValue(new RDate("20111111"));
//        支給限度基準額Div.getTxtKyuTankiNyushoKanriTekiyoDateRange().setToValue(new RDate("20111111"));
//
//    }
//
//    private void set居宅サービス計画(JukyushaIdoRenrakuhyoKyotakuServicePlanDiv 居宅サービス計画Div) {
//        居宅サービス計画Div.getTxtShienJigyoshaNo().setValue(new RString("1234567890"));
//        居宅サービス計画Div.getTxtShienJigyoshaName().setValue(new RString("たちばな"));
//        居宅サービス計画Div.getTxtKyotakuServicePlanTekiyoDateRange().setFromValue(new RDate("20111111"));
//        居宅サービス計画Div.getTxtKyotakuServicePlanTekiyoDateRange().setToValue(new RDate("20111111"));
//
//    }
//
//    private void set給付制限(JukyushaIdoRenrakuhyoKyufuSeigenDiv 給付制限Div) {
//        //給付制限なし
//    }
//
//    private void set後期高齢国保(JukyushaIdoRenrakuhyoKokiKoreiKokuhoDiv 後期高齢国保Div) {
//        後期高齢国保Div.getJukyushaIdoRenrakuhyoKokiKorei().getTxtKokiKoreiHokenshaNo().setValue(new RString("12345678"));
//        後期高齢国保Div.getJukyushaIdoRenrakuhyoKokiKorei().getTxtKokiKoreiHihokenshaNo().setValue(new RString("12345678"));
//
//        後期高齢国保Div.getJukyushaIdoRenrakuhyoKokuho().getTxtKokuhoHokenshaNo().setValue(new RString("12345678"));
//        後期高齢国保Div.getJukyushaIdoRenrakuhyoKokuho().getTxtKokuhoHihokenshashoNo().setValue(new RString("12345678901234567890"));
//        後期高齢国保Div.getJukyushaIdoRenrakuhyoKokuho().getTxtKokuhoKojinNo().setValue(new RString("1234567890"));
//
//    }
//
//    private void set老人保健(JukyushaIdoRenrakuhyoRojinHokenDiv 老人保健Div) {
//        //老健なし
//    }
//
//    private void set減免減額(JukyushaIdoRenrakuhyoGemmenGengakuDiv 減免減額Div) {
//        //申請なし
//
//    }
//
//    private void set二次予防事業(JukyushaIdoRenrakuhyoNijiyoboJigyoDiv 二次予防事業) {
//        //なし
//    }
//}

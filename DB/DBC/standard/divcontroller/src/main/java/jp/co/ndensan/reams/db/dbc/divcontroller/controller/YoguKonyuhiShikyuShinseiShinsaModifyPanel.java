///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package jp.co.ndensan.reams.db.dbc.divcontroller.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSeikyuDetail_Row;
//import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
//import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
//
///**
// * 福祉用具購入費支給審査 (支給審査内容の初期値をセットします)パネルです。
// *
// * @author n8223
// */
//public class YoguKonyuhiShikyuShinseiShinsaModifyPanel {
//
//    /*
//     *　福祉用具購入費支給審査　未審査支給申請一覧に修正ボタン押下後、請求明細の情報に展開する。
//     */
//    public ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> onClick_btnModifyShinsei(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
//        ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> response = new ResponseData<>();
//
//        //TODO 請求明細の情報を設定する。
//        setSeikyuDetailData(panel);
//        //TODO 支給申請内容の情報を設定する。
//        setShikyuShinseiSeikyuDetailInput(panel);
//        //TODO 前回までの情報を設定する。
//        setSummaryMae(panel);
//        //TODO 今回の支払状況の情報を設定する。
//        setSummaryNowData(panel);
//
//        response.data = panel;
//        return response;
//    }
//
//    /*
//     * 請求明細の情報をセットします。
//     */
//    private void setSeikyuDetailData(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
//
//        List<dgSeikyuDetail_Row> arraydata = updateRowSeikyuDetailTestData();
//        DataGrid<dgSeikyuDetail_Row> grid = panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getDgSeikyuDetail();
//        grid.setDataSource(arraydata);
//    }
//
//    /*
//     請求明細のテストデータです。
//     */
//    private List<dgSeikyuDetail_Row> updateRowSeikyuDetailTestData() {
//        List<dgSeikyuDetail_Row> arrayData = new ArrayList<>();
//
//        dgSeikyuDetail_Row item;
//        item = updateRowSeikyuDetailData(
//                //               "修正",
//                "",
//                "20140615",
//                "01:腰掛便座",
//                "介護ケア用品　腰掛便座",
//                "50000",
//                "審査済み");
//        arrayData.add(item);
//        return arrayData;
//
//    }
//
//    /*
//     引数を元にデータグリッド内に挿入する請求明細のデータを作成します。
//     */
//    private dgSeikyuDetail_Row updateRowSeikyuDetailData(
//            String 状態,
//            String 購入日,
//            String 種目,
//            String 商品名,
//            String 購入金額,
//            String 審査方法) {
//
//        dgSeikyuDetail_Row rowSeikyuDetaiData = new dgSeikyuDetail_Row(
//                new Button(), new Button(), new TextBox(), new TextBoxDate(), new TextBox(), new TextBox(), new TextBoxNum(), new TextBox());
//
//        rowSeikyuDetaiData.getTxtRowState().setValue(new RString(状態));
//        rowSeikyuDetaiData.getTxtBuyYMD().setValue(new RDate(購入日));
//        rowSeikyuDetaiData.getTxtShumoku().setValue(new RString(種目));
//        rowSeikyuDetaiData.getTxtShohinName().setValue(new RString(商品名));
//        rowSeikyuDetaiData.getTxtBuyAmount().setValue(new Decimal(購入金額));
//        rowSeikyuDetaiData.getTxtShinsaMethod().setValue(new RString(審査方法));
//
//        return rowSeikyuDetaiData;
//    }
//
//    /*
//     * 支給申請内容の値を設定します。
//     */
//    private void setShikyuShinseiSeikyuDetailInput(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
//
//        // 修正状況場合、「明細を追加する」ボタン名を明細を修正するに変更する。
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getBtnAddSeikyuDetail().setText(new RString("明細を修正する"));
//
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄  請求明細
////        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtShohinName().setValue(new RString("介護ケア用品　腰掛便座"));
////        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtSeizoJigyosha().setValue(new RString("電算○ｘ介護ケア"));
////        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHanbaiJigyosha().setValue(new RString("電算福祉センター"));
////        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyAmount().setValue(new Decimal(50000));
////        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHinmokuCode().setValue(new RString("1000000001"));
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄 申請者情報
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtShinseiYMD().setValue(new RDate("20140701"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtUketsukeYMD().setValue(new RDate("20140701"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtShinseishaName().setValue(new RString("電算 太郎"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtYubinNo().setValue(new YubinNo("123-4567"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtAddress().setValue(new RString("長野県長野市鶴賀七瀬中町276-6"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtTelNo().setValue(new RString("12345678901"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha().getTxtJigyoshaNo().setValue(new RString("1234567890"));
//    }
//
//    /*
//     前回までの支払結果の値を設定します。
//     */
//    private void setSummaryMae(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
//
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtHiyoTotalMae().setValue(Decimal.ZERO);
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoMae().setValue(Decimal.ZERO);
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountMae().setValue(Decimal.ZERO);
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(Decimal.ZERO);
//
//    }
//
//    /*
//     今回の支払状況の値を設定します。
//     */
//    private void setSummaryNowData(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtHiyoTotalNow().setValue(new Decimal(50000));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoNow().setValue(new Decimal(45000));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountNow().setValue(new Decimal(5000));
//        //計算　合計-10万　> 0  合計
//        //計算　合計-10万　<= 0 0
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getSeikyuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(Decimal.ZERO);
//
//    }
//
//    /*
//     * 福祉用具購入費支給審査 請求明細の修正ボタンを押下後、 詳細内容が表示する。
//     */
//    public ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> onClick_dgMeisai_modify(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
//        ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> response = new ResponseData<>();
//
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄  請求明細
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyYMD().setValue(new RDate("20140615"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getDdlShumoku().setSelectedItem(new RString("code01"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtShohinName().setValue(new RString("介護ケア用品　腰掛便座"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtSeizoJigyosha().setValue(new RString("電算○ｘ介護ケア"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHanbaiJigyosha().setValue(new RString("電算福祉センター"));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyAmount().setValue(new Decimal(50000));
//        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHinmokuCode().setValue(new RString("1000000001"));
//
//        response.data = panel;
//        return response;
//    }
//
//}

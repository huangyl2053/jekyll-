/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 福祉用具購入費支給申請 (請求明細の情報を表示する)パネルです。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiSeikyuDetail {
    
     /*
     *　福祉用具購入費支給審査　請求明細に追加・修正ボタン押下後、請求明細の情報を表示する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiSeikyuDetailDiv> onClick_btnAddSeikyuDetail(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiSeikyuDetailDiv> response = new ResponseData<>();

        //TO DO 明細設定
        setSeikyuDetailData(panel);
        //TO DO 前回までの支払結果の値を設定
        setSummaryMae(panel);
        //TO DO 今回の支払状況の値を設定
        setSummaryNowData(panel);
        
      //修正ボタン押下場合に、明細を修正モードで、クリア処理  
      if(panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getBtnAddSeikyuDetail().getText().toString().equals("明細を修正する"))  {
        
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyYMD().clearValue();
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getDdlShumoku().setSelectedItem(new RString("code00"));
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtShohinName().clearValue();
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtSeizoJigyosha().clearValue();
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHanbaiJigyosha().clearValue();
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyAmount().clearValue();
        panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtHinmokuCode().clearValue();
        
      }

        response.data = panel;
        return response;

    }

    /*
     前回までの支払結果の値を設定します。
     */
    private void setSummaryMae(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {

        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtPayTotalMae().setValue(Decimal.ZERO);
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHokenSeikyuAmountMae().setValue(Decimal.ZERO);
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(Decimal.ZERO);
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtLimitOverAmountMae().setValue(Decimal.ZERO);

    }

    /*
     今回の支払状況の値を設定します。
     */
    private void setSummaryNowData(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {

        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtPayTotalNow().setValue(new Decimal(50000));
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHokenSeikyuAmountNow().setValue(new Decimal(45000));
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(new Decimal(5000));
        //計算　合計-10万　> 0  合計 
        //計算　合計-10万　<= 0 0 
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtLimitOverAmountNow().setValue(Decimal.ZERO);

    }

    /*
     請求明細の情報をセットします。
     */
    private void setSeikyuDetailData(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {
         
        if (panel.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getBtnAddSeikyuDetail().getText().toString().equals("明細を修正する")) {
            List<dgSeikyuDetail_Row> arraydata = updateRowSeikyuDetailTestData();
            DataGrid<dgSeikyuDetail_Row> grid = panel.getDgSeikyuDetail();
            grid.setDataSource(arraydata);
        } else {
            List<dgSeikyuDetail_Row> arraydata = createRowSeikyuDetailTestData();
            DataGrid<dgSeikyuDetail_Row> grid = panel.getDgSeikyuDetail();
            grid.setDataSource(arraydata);
        }

    }
    
    
    /*
     請求明細のテストデータです。（修正モード）
     */
    private List<dgSeikyuDetail_Row> updateRowSeikyuDetailTestData() {
        List<dgSeikyuDetail_Row> arrayData = new ArrayList<>();

        dgSeikyuDetail_Row item;
         
        item = createRowSeikyuDetailData(
                "",
                "",
                "修正",
                "20140615",
                "01:腰掛便座",
                "介護ケア用品　腰掛便座",
                "50000",
                "審査済み");
        arrayData.add(item);
        return arrayData;

    }
    
    /*
     請求明細のテストデータです。（追加モード）
     */
    private List<dgSeikyuDetail_Row> createRowSeikyuDetailTestData() {
        List<dgSeikyuDetail_Row> arrayData = new ArrayList<>();

        dgSeikyuDetail_Row item;
         
        item = createRowSeikyuDetailData(
                "",
                "",
                "追加",
                "20140615",
                "01:腰掛便座",
                "介護ケア用品　腰掛便座",
                "50000",
                "審査済み");
        arrayData.add(item);
        return arrayData;

    }


    /*
     引数を元にデータグリッド内に挿入する請求明細のデータを作成します。
     */
    private dgSeikyuDetail_Row createRowSeikyuDetailData(
            String 修正,
            String 削除,
            String 状態,
            String 購入日,
            String 種目,
            String 商品名,
            String 購入金額,
            String 審査方法) {

        dgSeikyuDetail_Row rowSeikyuDetaiData = new dgSeikyuDetail_Row(
                new Button(), new Button(), new TextBox(), new TextBoxDate(), new TextBox(), new TextBox(), new TextBoxNum(), new TextBox());
        
        rowSeikyuDetaiData.getTxtRowState().setValue(new RString(状態));
        rowSeikyuDetaiData.getTxtBuyYMD().setValue(new RDate(購入日));
        rowSeikyuDetaiData.getTxtShumoku().setValue(new RString(種目));
        rowSeikyuDetaiData.getTxtShohinName().setValue(new RString(商品名));
        rowSeikyuDetaiData.getTxtBuyAmount().setValue(new Decimal(購入金額));
        rowSeikyuDetaiData.getTxtShinsaMethod().setValue(new RString(審査方法));

        return rowSeikyuDetaiData;
    }

}

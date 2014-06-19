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
 * 福祉用具購入費支給申請 請求明細の情報を表示する。
 *
 * @author n8223
 */
public class YoguKonyuhiShikyuShinseiSeikyuDetail {

    public ResponseData<YoguKonyuhiShikyuShinseiSeikyuDetailDiv> onClick_btnAddSeikyuDetail(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiSeikyuDetailDiv> response = new ResponseData<>();

        setSeikyuDetailData(panel);
        setSummaryMae(panel);
        setSummaryNowData(panel);

        response.data = panel;
        return response;

    }

    /*
     前回までの支払結果の値を設定します。
     */
    private void setSummaryMae(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {

        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHiyoTotalMae().setValue(Decimal.ZERO);
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoMae().setValue(Decimal.ZERO);
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountMae().setValue(Decimal.ZERO);
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(Decimal.ZERO);

    }

    /*
     今回の支払状況の値を設定します。
     */
    private void setSummaryNowData(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {

        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHiyoTotalNow().setValue(new Decimal(50000));
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHokenTaishoHiyoNow().setValue(new Decimal(45000));
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtHokenKyufuAmountNow().setValue(new Decimal(5000));
        //計算　合計-10万　> 0  合計
        //計算　合計-10万　<= 0 0
        panel.getSeikyuSummary().getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(Decimal.ZERO);

    }

    /*
     請求明細の情報をセットします。
     */
    private void setSeikyuDetailData(YoguKonyuhiShikyuShinseiSeikyuDetailDiv panel) {

        List<dgSeikyuDetail_Row> arraydata = createRowSeikyuDetailTestData();
        DataGrid<dgSeikyuDetail_Row> grid = panel.getDgSeikyuDetail();
        grid.setDataSource(arraydata);

    }

    /*
     請求明細のテストデータです。
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

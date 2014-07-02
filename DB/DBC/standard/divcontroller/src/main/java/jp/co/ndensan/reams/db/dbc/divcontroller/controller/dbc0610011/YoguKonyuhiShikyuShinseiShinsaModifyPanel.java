/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0610011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiMishinsaSearchPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiSeikyuDetailDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiSeikyuDetailInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgSeikyuDetail_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KozaPayment;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShinseishaInfo;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ControlGenerator;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;

/**
 * 福祉用具購入費支給審査 (支給審査内容の初期値をセットします)パネルです。
 *
 * @author n8223 朴
 */
public class YoguKonyuhiShikyuShinseiShinsaModifyPanel {

    /*
     *　福祉用具購入費支給審査　未審査支給申請一覧の修正ボタン押下後、請求明細の情報に展開する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> onClick_btnModifyShinsei(
            YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> response = new ResponseData<>();

        //TODO 請求明細の情報を設定する。
        setSeikyuDetailData(panel);
        //TODO 支給申請内容の情報を設定する。
        setShikyuShinseiSeikyuDetailInput(panel);

        response.data = panel;
        return response;
    }

    /*
     * 福祉用具購入費支給審査 請求明細の修正ボタンを押下後、 詳細内容が表示する。
     */
    public ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> onClick_dgMeisai_modify(
            YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> response = new ResponseData<>();

        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("dbc0610011/YoguShinseiDetailList.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄  請求明細
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getTxtBuyYMD().setValue(cg.getAsRDate("購入日"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getDdlShumoku().setSelectedItem(cg.getAsRString("種目コード"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getTxtShohinName().setValue(cg.getAsRString("商品名"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getTxtSeizoJigyosha().setValue(cg.getAsRString("製造事業者"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getTxtHanbaiJigyosha().setValue(cg.getAsRString("販売事業者"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getTxtBuyAmount().setValue(cg.getAsDecimal("購入金額"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getTxtHinmokuCode().setValue(cg.getAsRString("品目コード"));
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput()
                .getRadShinsaMethod().setSelectedItem(new RString("judgeDone"));

        response.data = panel;
        return response;
    }

    /**
     * 明細を変更するボタンを押したときの処理です。
     *
     * @param panel
     * @param searchPanel
     * @return
     */
    public ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> onClick_ModifyDetail(
            YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
        ResponseData<YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv> response = new ResponseData<>();

        setModifiedDataToList(panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail(), panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getDgSeikyuDetail().getClickedRowId());
        clearInputDetailData(panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getYoguKonyuhiShikyuShinseiSeikyuDetailInput());
        response.data = panel;
        return response;
    }

    private void clearInputDetailData(YoguKonyuhiShikyuShinseiSeikyuDetailInputDiv div) {
        div.getTxtBuyYMD().clearValue();
        div.getDdlShumoku().setSelectedItem(null);
        div.getTxtShohinName().clearValue();
        div.getTxtSeizoJigyosha().clearValue();
        div.getTxtHanbaiJigyosha().clearValue();
        div.getTxtBuyAmount().clearValue();
        div.getTxtHinmokuCode().clearValue();
    }

    private void setModifiedDataToList(YoguKonyuhiShikyuShinseiSeikyuDetailDiv div, int clickedRowId) {
        //TODO clickedRowIdで-1が取れてしまうので暫定対応。
        clickedRowId = 0;
        div.getDgSeikyuDetail().getDataSource().get(clickedRowId).setRowState(RowState.Modified);
        div.getDgSeikyuDetail().getDataSource().get(clickedRowId).getTxtBuyYMD().setValue(
                div.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyYMD().getValue());
        div.getDgSeikyuDetail().getDataSource().get(clickedRowId).getTxtShumoku().setValue(
                div.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getDdlShumoku().getSelectedValue());
        div.getDgSeikyuDetail().getDataSource().get(clickedRowId).getTxtShohinName().setValue(
                div.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtShohinName().getValue());
        div.getDgSeikyuDetail().getDataSource().get(clickedRowId).getTxtBuyAmount().setValue(
                div.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getTxtBuyAmount().getValue());
        div.getDgSeikyuDetail().getDataSource().get(clickedRowId).getTxtShinsaMethod().setValue(
                div.getYoguKonyuhiShikyuShinseiSeikyuDetailInput().getRadShinsaMethod().getSelectedValue());
    }
    /*
     * 請求明細の情報をセットします。
     */

    private void setSeikyuDetailData(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
        panel.getYoguKonyuhiShikyuShinseiShinsaSeikyuDetail().getDgSeikyuDetail().setDataSource(getSeikyuDetailData());
    }

    private List<dgSeikyuDetail_Row> getSeikyuDetailData() {
        List<dgSeikyuDetail_Row> list = new ArrayList<>();
        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("dbc0610011/YoguShinseiDetailList.yml"));
        for (Map info : targetSource) {
            list.add(toDgSeikyuDetail_Row(info));
        }
        return list;
    }

    private static dgSeikyuDetail_Row toDgSeikyuDetail_Row(Map map) {
        ControlGenerator cg = new ControlGenerator(map);
        dgSeikyuDetail_Row row = new dgSeikyuDetail_Row(
                cg.getAsTextBoxDate("購入日"),
                cg.getAsTextBox("種目"),
                cg.getAsTextBox("商品名"),
                cg.getAsTextBoxNum("購入金額"),
                cg.getAsTextBox("審査方法"));
        return row;
    }

    /*
     * 支給申請内容の値を設定します。
     */
    private void setShikyuShinseiSeikyuDetailInput(
            YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {

        List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("dbc0610011/YoguShinseiShinsa.yml"));
        ControlGenerator cg = new ControlGenerator(targetSource.get(0));
        panel.getTxtTeikyoYM().setValue(cg.getAsRDate("提供年月"));
        panel.getTxtSeiriNo().setValue(cg.getAsRString("整理番号"));
        panel.getTxtKyufuritsu().setValue(cg.getAsDecimal("給付率"));

        setKozaInfo(panel);

        ShinseishaInfo.setData(panel.getYoguKonyuhiShikyuShinseiShinsaShinseisha(), 0);
    }

    private void setKozaInfo(YoguKonyuhiShikyuShinseiShinsaModifyPanelDiv panel) {
        panel.getYoguKonyuhiShikyuShinseiShinsaPaymentMethod().getRadPayMethod().setSelectedItem(new RString("payToKoza"));

        panel.getYoguKonyuhiShikyuShinseiShinsaPaymentMethod().getKozaPayment()
                .getRadKozaShubetsu().setSelectedItem(new RString("futsu"));
        KozaPayment.setData(panel.getYoguKonyuhiShikyuShinseiShinsaPaymentMethod().getKozaPayment(), 0);
    }
}

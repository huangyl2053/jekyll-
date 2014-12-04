/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0720011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.PaymentMethod;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinsaResultDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.JutakuKaishuShinseiDetailInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.dgJutakuKaishuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgMishinsaShikyuShinsei_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KozaPayment;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShinseishaInfo;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * @author n8223 朴
 */
public class JutakuKaishuShinseiPanel {

    /**
     * 住宅改修費支給申請審査 支給一覧の行を選択してから事前申請内容の情報を表示する。（事前申請用ボタン押下）
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_btnMod(JutakuKaishuShinseiPanelDiv panel) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        //支給内容をクリア処理が行う
        // setClearJutakuKaishuShinseiInfoDiv(panel);
        //YML データ
        String ymlDataName = "MishinsaShikyuShinseiJutakuKaishuShinsei.yml";

        dgMishinsaShikyuShinsei_Row selectedRow
                = (dgMishinsaShikyuShinsei_Row) ViewStateHolder.get("selectedRow", dgMishinsaShikyuShinsei_Row.class);
        //提供年月
        panel.getJutakuKaishuShinsaShinseiContents().getTxtTeikyoYM().
                setValue(selectedRow.getTxtTeikyoYM().getValue());
        //整理番号
        panel.getJutakuKaishuShinsaShinseiContents().getTxtSeiriNo().
                setValue(selectedRow.getTxtSeiriNo().getValue());
        //氏名
        panel.getJutakuKaishuShinsaShinseiContents().getTxtJutakuOwner().
                setValue(selectedRow.getTxtHihokenshaName());

        //今回の支払状況
        //見積額
        //txtPayTotalNow
//        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHiyoTotalNow().setValue(new Decimal(selectedRow.getTxtHiyoTotalAmount().getValue().toString()));
//
//        //txtHokenSeikyuAmountNow
//        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenTaishoHiyoNow().setValue(new Decimal(selectedRow.getTxtHiyoTotalAmount().getValue().toString()));
//
//        //txtRiyoshaFutanAmountNow
//        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenKyufuAmountNow().setValue(new Decimal(selectedRow.getTxtHokenKyufuAmount().getValue().toString()));
        //txtHiyoTotalAmount
        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountNow().setValue(new Decimal(selectedRow.getTxtRiyoshaFutanAmount().getValue().toString()));

        //事前申請内容の情報を表示する。
        setInfoData(panel, selectedRow, ymlDataName);

        set承認区分(panel.getJutakuKaishuShinsaResult());

        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費支給申請審査 データグリッドの修正ボタンをボタン押下後、改修内容を反映する。（事前申請用ボタン押下）
     *
     * @param panel JutakuKaishuShinseiInfoDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_btnModify(JutakuKaishuShinseiPanelDiv panel) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        //改修内容を反映する。
        setZizenShinseiDetailInput(panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiDetailInput());
        //TO DO
        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().
                getBtnModifyDetail().setText(new RString("明細を修正する"));

        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費支給申請審査 申請を追加するボタン押下後、申請内容の情報を表示する（明細を追加するボタン押下後、住宅改修明細を表示、改修内容などは、クリア処理が行う）
     *
     * @param panel JutakuKaishuShinseiPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_btnModifyDetail(JutakuKaishuShinseiPanelDiv panel) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        setModifiedDataToList(panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiDetailInput(),
                panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail().getClickedRowId());
        //クリア設定
        setJutakuKaishuJizenShinseiAddDetailInput(panel);

        response.data = panel;
        return response;

    }

    /**
     * 支払い方法ラジオボタンにより表示内容を変更する。
     *
     * @param panel
     * @return response
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_radPayMethod(JutakuKaishuShinseiPanelDiv panel) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        PaymentMethod.showSelectedPaymentMethod(panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinsaKoza());
        response.data = panel;
        return response;
    }

    /*
     * 住宅改修費支給申請審査   申請内容の情報を表示する。
     */
    private void setInfoData(JutakuKaishuShinseiPanelDiv panel, dgMishinsaShikyuShinsei_Row selectedRow, String ymlDataName) {

        //住宅所有者・被保険者との関係
        setJutakuOwnerData(panel, ymlDataName);

        //住宅改修明細
        setRowShikyuShinseiData(panel, selectedRow);

        //setZizenShinseiDetailInput(panel, ymlDataName);
        //前回・今回初期化設定
        setSummary(panel, ymlDataName);

        //申請者情報初期化設定
        setShinseishaInfo(panel, ymlDataName);

        //住宅改修理由書
        setShinseiReason(panel, ymlDataName);

        //口座振替申請情報（UR)
        setShinseiKozaInfo(panel, ymlDataName);
    }

    private void setRowShikyuShinseiData(JutakuKaishuShinseiPanelDiv panel, dgMishinsaShikyuShinsei_Row selectedRow) {

        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiTestData(panel, selectedRow);
        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
        grid.setDataSource(arraydata);
    }

    private void setJutakuOwnerData(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);
        //被保険者との関係
        panel.getJutakuKaishuShinsaShinseiContents().getTxtRelationWithHihokensha().
                setValue(new RString(ymlData.get(0).get("relationWithHihokensha").toString()));
    }

    private void setZizenShinseiDetailInput(JutakuKaishuShinseiDetailInputDiv div) {

        div.getJutakuKaishuDetailInput().getTxtKaishuContents().setValue(
                div.getDgJutakuKaishuDetail().getClickedItem().getTxtKaishuContents());
        div.getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().setValue(
                div.getDgJutakuKaishuDetail().getClickedItem().getTxtKaishuJigyosha());
        div.getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().setValue(
                div.getDgJutakuKaishuDetail().getClickedItem().getTxtKaishuTaishoAddress());
        div.getJutakuKaishuDetailInput().getTxtChakkoDueDate().setValue(
                div.getDgJutakuKaishuDetail().getClickedItem().getTxtChakkoDueDate().getValue());
        div.getJutakuKaishuDetailInput().getTxtKanseiDueDate().setValue(
                div.getDgJutakuKaishuDetail().getClickedItem().getTxtKanseiDueDate().getValue());
        div.getJutakuKaishuDetailInput().getTxtEstimatedAmount().setValue(
                div.getDgJutakuKaishuDetail().getClickedItem().getTxtMitsumoriAmount().getValue());
    }

    private void setSummary(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);

        String payTotalMae = ymlData.get(2).get("payTotalMae").toString();
        String hokenSeikyuAmountMae = ymlData.get(2).get("hokenSeikyuAmountMae").toString();
        String riyoshaFutanAmountMae = ymlData.get(2).get("riyoshaFutanAmountMae").toString();
        String limitOverAmountMae = ymlData.get(2).get("limitOverAmountMae").toString();

//        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHiyoTotalMae().setValue(new Decimal(payTotalMae));
//
//        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenTaishoHiyoMae().setValue(new Decimal(hokenSeikyuAmountMae));
//
//        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenKyufuAmountMae().setValue(new Decimal(riyoshaFutanAmountMae));
        panel.getJutakuKaishuShinsaResetInfo().getJutakuKaishuShinsaResetInfoSummary().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountMae().setValue(new Decimal(limitOverAmountMae));
    }

    private void setShinseishaInfo(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        ShinseishaInfo.setData(panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseisha(), 0);
    }

    private void setShinseiReason(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);

        String createDate = ymlData.get(4).get("createDate").toString();
        String creationJigyoshaNo = ymlData.get(4).get("creationJigyoshaNo").toString();
        String creationJigyoshaName = ymlData.get(4).get("creationJigyoshaName").toString();
        String creatorKanaName = ymlData.get(4).get("creatorKanaName").toString();
        String creatorName = ymlData.get(4).get("creatorName").toString();

        //TO DO
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreateDate().setValue(new RDate(createDate));
        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreationJigyoshaNo().setValue(new RString(creationJigyoshaNo));
        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreationJigyoshaName().setValue(new RString(creationJigyoshaName));
        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreatorKanaName().setValue(new RString(creatorKanaName));
        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreatorName().setValue(new RString(creatorName));

    }

    private void setShinseiKozaInfo(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinsaKoza().getRadPayMethod().setSelectedItem(new RString("payToKoza"));

        int rowId = 0;
        KozaPayment.setData(panel.getJutakuKaishuShinsaShinseiContents().getJutakuKaishuShinsaKoza().getKozaPayment(), rowId);
    }

    private void setModifiedDataToList(JutakuKaishuShinseiDetailInputDiv div, int clickedRowId) {
        //TODO clickedRowIdで-1が取れてしまうので暫定対応。
        clickedRowId = 0;
        div.getDgJutakuKaishuDetail().getDataSource().get(clickedRowId).setRowState(RowState.Modified);
        div.getDgJutakuKaishuDetail().getDataSource().get(clickedRowId).getTxtChakkoDueDate().setValue(
                div.getJutakuKaishuDetailInput().getTxtChakkoDueDate().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(clickedRowId).getTxtKanseiDueDate().setValue(
                div.getJutakuKaishuDetailInput().getTxtKanseiDueDate().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(clickedRowId).setTxtKaishuJigyosha(
                div.getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(clickedRowId).setTxtKaishuTaishoAddress(
                div.getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(clickedRowId).setTxtKaishuContents(
                div.getJutakuKaishuDetailInput().getTxtKaishuContents().getValue());
    }
    /*
     住宅改修明細をセットします。
     */

    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiTestData(
            JutakuKaishuShinseiPanelDiv panel, dgMishinsaShikyuShinsei_Row selectedRow) {

        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();

        String ymlDataName = "MishinsaShikyuShinseiDgJutakKaishiDetailRow.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        String chakkoDueDate = ymlData.get(0).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(0).get("kanseiDueDate").toString();
        String kaishuJigyosha = ymlData.get(0).get("kaishuJigyosha").toString();
        String kaishuTaishoAddress1 = ymlData.get(0).get("kaishuTaishoAddress1").toString();
        String kaishuContents = ymlData.get(0).get("kaishuContents").toString();

        String estimatedAmount = selectedRow.getTxtHiyoTotalAmount().getValue().toString();
        dgJutakuKaishuDetail_Row item;
        item = createRowShikyuShinseiListAddData(
                chakkoDueDate,
                kanseiDueDate,
                estimatedAmount,
                kaishuJigyosha,
                kaishuTaishoAddress1,
                kaishuContents
        );

        arrayData.add(item);
        return arrayData;

    }

    /*
     * 引数を元にデータグリッド内に挿入する支給申請データを作成します。
     */
    private dgJutakuKaishuDetail_Row createRowShikyuShinseiListAddData(
            String 着工予定日,
            String 完成予定日,
            String 見積金額,
            String 事業者,
            String 改修対象住所,
            String 改修内容) {

        dgJutakuKaishuDetail_Row rowShikyuShinseiListData = new dgJutakuKaishuDetail_Row(
                new TextBoxDate(), new TextBoxDate(), new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowShikyuShinseiListData.getTxtChakkoDueDate().setValue(new RDate(着工予定日));
        rowShikyuShinseiListData.getTxtKanseiDueDate().setValue(new RDate(完成予定日));
        rowShikyuShinseiListData.getTxtMitsumoriAmount().setValue(new Decimal(見積金額));
        rowShikyuShinseiListData.setTxtKaishuJigyosha(new RString(事業者));
        rowShikyuShinseiListData.setTxtKaishuTaishoAddress(new RString(改修対象住所));
        rowShikyuShinseiListData.setTxtKaishuContents(new RString(改修内容));

        return rowShikyuShinseiListData;
    }

    private void setJutakuKaishuJizenShinseiAddDetailInput(JutakuKaishuShinseiPanelDiv panel) {

        //改修の内容をクリア
        panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
                .clearValue();
        panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName()
                .clearValue();
        panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress()
                .clearValue();
        panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate()
                .clearValue();
        panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate()
                .clearValue();
        panel.getJutakuKaishuShinsaShinseiContents().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount()
                .clearValue();

    }

    private void set承認区分(JutakuKaishuShinsaResultDiv div) {
        div.getRadShonin().setSelectedItem(new RString("kyakka"));
    }
    /*
     * YML DATA
     */

    private List<HashMap> ymlData(String ymlDataName) {
        return YamlLoader.DBC.loadAsList(new RString("dbc0720011/" + ymlDataName));
    }
}

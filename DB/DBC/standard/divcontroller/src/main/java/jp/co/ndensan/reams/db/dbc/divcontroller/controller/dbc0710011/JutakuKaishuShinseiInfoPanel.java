/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *  JutakuData_1.yml JutakuData_1_1.yml JutakuData_1_2.yml JutakuData_1_3.yml
 *  JutakuData_2.yml JutakuData_2_1.yml JutakuData_2_2
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0710011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.PaymentMethod;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.JutakuKaishuShinseiDetailInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.dgJutakuKaishuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiInfoPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiContentsPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.KozaPayment;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShinseishaInfo;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 住宅改修支給申請登録画面です。
 *
 * @author n8223 朴
 */
public class JutakuKaishuShinseiInfoPanel {

    /**
     * 住宅改修費申請登録 支給一覧の行を選択してから事前申請内容の情報を表示する。（事前申請用ボタン押下）
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @param panel1 JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    //TODO 該当者一覧から人を特定したイベントでここの動作を行う。
    public ResponseData<JutakuKaishuShinseiInfoPanelDiv> onClick_btnShowDetail(
            JutakuKaishuShinseiInfoPanelDiv panel, JutakuKaishuShinseiListDiv panel1) {
        ResponseData<JutakuKaishuShinseiInfoPanelDiv> response = new ResponseData<>();

        if (is事前申請あり(panel1.getDgJutakuKaishuShinseiList().getClickedRowId())) {
            panel.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisplayNone(false);
        } else {
            panel.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisplayNone(true);
        }
        //支給内容をクリア処理が行う
        setClearJutakuKaishuShinseiInfoPanelDiv(panel);
        //事前申請用のデータ
        String ymlDataName = "JutakuData_1_1.yml";
        //事前申請内容の情報を表示する。
        setInfoData(panel, ymlDataName);

        response.data = panel;
        return response;
    }

    /**
     * 住宅改修費事前申請登録 住宅改修明細の修正ボタンをボタン押下後、改修内容を反映する。（事前申請用ボタン押下）
     *
     * @param panel JutakuKaishuShinseiInfoPanelDiv
     * @param panel1 JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiInfoPanelDiv> onSelectByModifyButton(
            JutakuKaishuShinseiInfoPanelDiv panel, JutakuKaishuShinseiListDiv panel1) {
        ResponseData<JutakuKaishuShinseiInfoPanelDiv> response = new ResponseData<>();

        //追加するデータ
        String ymlDataName = "JutakuData_1_1.yml";
        //改修内容を反映する。
        setZizenShinseiDetailInput(panel, ymlDataName);
        //TO DO
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().
                getBtnModifyDetail().setText(new RString("明細を修正する"));

        response.data = panel;
        return response;

    }

    /**
     * 住宅改修費事前申請登録 申請を追加するボタン押下後、事前申請内容の情報を表示する。（申請を追加するボタン押下）
     *
     * @param panel JutakuKaishuShinseiInfoPanelDiv
     * @param panel1 JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiInfoPanelDiv> onClick_btnAddShinsei(
            JutakuKaishuShinseiInfoPanelDiv panel, JutakuKaishuShinseiListDiv panel1) {
        ResponseData<JutakuKaishuShinseiInfoPanelDiv> response = new ResponseData<>();

        panel.getJutakuKaishuShinseiContents().getBtnShowJizenShinsei().setDisplayNone(true);

        //支給内容をクリア処理が行う
        setClearJutakuKaishuShinseiInfoPanelDiv(panel);
        //TODO 新規追加はデフォルト表示以外表示させない。
        ShinseishaInfo.setData(panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha(), 0);
//        //追加するデータ
//        String ymlDataName = "JutakuData_2_1.yml";
//        //事前申請内容の情報を表示する。
//        setInfoData(panel, ymlDataName);

        response.data = panel;
        return response;

    }

    /**
     * 住宅改修費事前申請登録
     * 申請を追加するボタン押下後、事前申請内容の情報を表示する（明細を追加するボタン押下後、住宅改修明細を表示し、改修内容などは、クリア処理が行う）
     *
     * @param panel JutakuKaishuShinseiInfoPanelDiv
     * @param panel1 JutakuKaishuShinseiListDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiInfoPanelDiv> onClick_btnModifyDetail(
            JutakuKaishuShinseiInfoPanelDiv panel, JutakuKaishuShinseiListDiv panel1) {
        ResponseData<JutakuKaishuShinseiInfoPanelDiv> response = new ResponseData<>();

        //TO DO　現在選択された内容があるのかチェックする。
        int selRowId = panel1.getDgJutakuKaishuShinseiList().getClickedRowId();
        String ymlDataName = "JutakuData_1_3.yml";

//        if (selRowId >= 0) {
//            ymlDataName = "JutakuData_1_3.yml";
//        } else {
//            //追加するデータ
//            ymlDataName = "JutakuData_2_2.yml";
//        }
//
//        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiAddTestData(
//                panel, panel1.getDgJutakuKaishuShinseiList().getClickedRowId(), ymlDataName);
//        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
//        grid.setDataSource(arraydata);
        setInputDateToList(panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().getJutakuKaishuShinseiDetailInput());
        //今回設定
        setSummaryAddNowData(panel, ymlDataName);
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
    public ResponseData<JutakuKaishuShinseiInfoPanelDiv> onClick_radPayMethod(
            JutakuKaishuShinseiInfoPanelDiv panel, JutakuKaishuShinseiListDiv panel1) {
        ResponseData<JutakuKaishuShinseiInfoPanelDiv> response = new ResponseData<>();

        PaymentMethod.showSelectedPaymentMethod(panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo());

        response.data = panel;
        return response;
    }

    private void setInputDateToList(JutakuKaishuShinseiDetailInputDiv div) {
        int modifiedRowId = 0;
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).setRowState(RowState.Modified);
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).getTxtChakkoDueDate().setValue(
                div.getJutakuKaishuDetailInput().getTxtChakkoDueDate().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).getTxtKanseiDueDate().setValue(
                div.getJutakuKaishuDetailInput().getTxtKanseiDueDate().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).getTxtMitsumoriAmount().setValue(
                div.getJutakuKaishuDetailInput().getTxtEstimatedAmount().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).setTxtKaishuJigyosha(
                div.getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).setTxtKaishuTaishoAddress(
                div.getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().getValue());
        div.getDgJutakuKaishuDetail().getDataSource().get(modifiedRowId).setTxtKaishuContents(
                div.getJutakuKaishuDetailInput().getTxtKaishuContents().getValue());
    }
    /*
     * 住宅改修費事前申請登録   事前申請内容の情報を表示する。
     */

    private void setInfoData(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        ////////////////////////////////////////
        //住宅所有者・被保険者との関係
        setJutakuOwnerData(panel, ymlDataName);

        if (ymlDataName.equals("JutakuData_1_1.yml")) {
            //住宅改修明細 ①
            setZizenJutakuKaishuDetail(panel, ymlDataName);
        }

        if (ymlDataName.equals("JutakuData_2_1.yml")) {
            //住宅改修明細 ②
            setZizenShinseiDetailInput(panel, ymlDataName);
        }

        //前回・今回初期化設定
        setSummary(panel, ymlDataName);
        //申請者情報初期化設定
        setShinseishaInfo(panel, ymlDataName);
        //住宅改修理由書
        setShinseiReason(panel, ymlDataName);
        //口座振替申請情報（UR)
        setShinseiKozaInfo(panel, ymlDataName);
        ////////////////////////////////////////
    }

    /*
     住宅所有者・被保険者との関係　の初期値をセットします。
     */
    private void setJutakuOwnerData(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        String teikyoYM = ymlData.get(0).get("teikyoYM").toString();
        String seiriNo = ymlData.get(0).get("seiriNo").toString();
        String jutakuOwner = ymlData.get(0).get("jutakuOwner").toString();
        String relationWithHihokensha = ymlData.get(0).get("relationWithHihokensha").toString();

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinseiContents().
                getTxtTeikyoYM().setValue(new RDate(teikyoYM));
        panel.getJutakuKaishuShinseiContents().
                getTxtSeiriNo().setValue(new RString(seiriNo));
        panel.getJutakuKaishuShinseiContents().
                getTxtJutakuOwner().setValue(new RString(jutakuOwner));
        panel.getJutakuKaishuShinseiContents().
                getTxtRelationWithHihokensha().setValue(new RString(relationWithHihokensha));
    }

    /*
     * 住宅改修明細をセットします。
     */
    private void setZizenJutakuKaishuDetail(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiTestData(ymlDataName);
        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();

        grid.setDataSource(arraydata);
    }

    /*
     住宅改修明細をセットします。
     */
    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiTestData(String ymlDataName) {

        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        String chakkoDueDate = ymlData.get(6).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(6).get("kanseiDueDate").toString();
        String mitsumoriAmount = ymlData.get(6).get("mitsumoriAmount").toString();
        String kaishuJigyosha = ymlData.get(6).get("kaishuJigyosha").toString();
        String kaishuTaishoAddress = ymlData.get(6).get("kaishuTaishoAddress").toString();
        String kaishuNaiyo = ymlData.get(6).get("kaishuNaiyo").toString();

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        dgJutakuKaishuDetail_Row item;
        item = createRowShikyuShinseiListData(
                chakkoDueDate,
                kanseiDueDate,
                mitsumoriAmount,
                kaishuJigyosha,
                kaishuTaishoAddress,
                kaishuNaiyo
        );

        arrayData.add(item);
        return arrayData;
    }

    /*
     引数を元にデータグリッド内に挿入する支給申請データを作成します。
     */
    private dgJutakuKaishuDetail_Row createRowShikyuShinseiListData(
            String 着工予定日,
            String 完成予定日,
            String 見積金額,
            String 事業者,
            String 改修住宅住所,
            String 改修内容) {

        dgJutakuKaishuDetail_Row rowShikyuShinseiListData = new dgJutakuKaishuDetail_Row(
                new TextBoxDate(), new TextBoxDate(), new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowShikyuShinseiListData.getTxtChakkoDueDate().setValue(new RDate(着工予定日));
        rowShikyuShinseiListData.getTxtKanseiDueDate().setValue(new RDate(完成予定日));
        rowShikyuShinseiListData.getTxtMitsumoriAmount().setValue(new Decimal(見積金額));
        rowShikyuShinseiListData.setTxtKaishuJigyosha(new RString(事業者));
        rowShikyuShinseiListData.setTxtKaishuTaishoAddress(new RString(改修住宅住所));
        rowShikyuShinseiListData.setTxtKaishuContents(new RString(改修内容));

        return rowShikyuShinseiListData;
    }

    /*
     *住宅改修明細の初期値をセットします。
     */
    private void setZizenShinseiDetailInput(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        String kaishuContents = ymlData.get(1).get("kaishuContents").toString();
        String kaishuJigyoshaName = ymlData.get(1).get("kaishuJigyoshaName").toString();
        String kaishuTaishoAddress1 = ymlData.get(1).get("kaishuTaishoAddress1").toString();
        String chakkoDueDate = ymlData.get(1).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(1).get("kanseiDueDate").toString();
        String estimatedAmount = ymlData.get(1).get("estimatedAmount").toString();
        /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
                .setValue(new RString(kaishuContents));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().
                setValue(new RString(kaishuJigyoshaName));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().
                setValue(new RString(kaishuTaishoAddress1));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate().
                setValue(new RDate(chakkoDueDate));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate().
                setValue(new RDate(kanseiDueDate));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount().
                setValue(new Decimal(estimatedAmount));
    }

    /*
     前回・今回　初期化設定の初期値をセットします。
     */
    private void setSummary(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        //前回
        String payTotalMae = ymlData.get(2).get("payTotalMae").toString();
        String hokenSeikyuAmountMae = ymlData.get(2).get("hokenSeikyuAmountMae").toString();
        String riyoshaFutanAmountMae = ymlData.get(2).get("riyoshaFutanAmountMae").toString();
        String limitOverAmountMae = ymlData.get(2).get("limitOverAmountMae").toString();
        //今回
        String payTotalNow = ymlData.get(2).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = ymlData.get(2).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = ymlData.get(2).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = ymlData.get(2).get("limitOverAmountNow").toString();

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        //前回
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHiyoTotalMae().setValue(new Decimal(payTotalMae));

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenTaishoHiyoMae().setValue(new Decimal(hokenSeikyuAmountMae));

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenKyufuAmountMae().setValue(new Decimal(riyoshaFutanAmountMae));

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountMae().setValue(new Decimal(limitOverAmountMae));

        //今回
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHiyoTotalNow().setValue(new Decimal(payTotalNow));

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenTaishoHiyoNow().setValue(new Decimal(hokenSeikyuAmountNow));

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenKyufuAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountNow().setValue(new Decimal(limitOverAmountNow));

    }

    /*
     申請者情報の初期値をセットします。
     */
    private void setShinseishaInfo(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        int rowId = 0;
        ShinseishaInfo.setData(panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha(), rowId);
    }

    /*
     住宅改修理由書の初期値をセットします。
     */
    private void setShinseiReason(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        String createDate = ymlData.get(4).get("createDate").toString();
        String creationJigyoshaNo = ymlData.get(4).get("creationJigyoshaNo").toString();
        String creationJigyoshaName = ymlData.get(4).get("creationJigyoshaName").toString();
        String creatorKanaName = ymlData.get(4).get("creatorKanaName").toString();
        String creatorName = ymlData.get(4).get("creatorName").toString();

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateDate().setValue(new RDate(createDate));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(new RString(creationJigyoshaNo));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setValue(new RString(creationJigyoshaName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().setValue(new RString(creatorKanaName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().setValue(new RString(creatorName));

    }

    /*
     口座振替申請情報（UR)の初期値をセットします。
     */
    private void setShinseiKozaInfo(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getRadPayMethod().setSelectedItem(new RString("payToKoza"));
        KozaPayment.setData(panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment(), 0);
    }

    /*
     住宅改修明細をセットします。
     */
    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiAddTestData(
            JutakuKaishuShinseiInfoPanelDiv panel, int rowId, String ymlDataName) {

        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        String chakkoDueDate = ymlData.get(0).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(0).get("kanseiDueDate").toString();
        String mitsumoriAmount = ymlData.get(0).get("mitsumoriAmount").toString();
        String kaishuJigyosha = ymlData.get(0).get("kaishuJigyosha").toString();
        String kaishuTaishoAddress = ymlData.get(0).get("kaishuTaishoAddress").toString();
        String kaishuNaiyo = ymlData.get(0).get("kaishuNaiyo").toString();

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        dgJutakuKaishuDetail_Row item;
        item = createRowShikyuShinseiListAddData(
                rowId,
                chakkoDueDate,
                kanseiDueDate,
                mitsumoriAmount,
                kaishuJigyosha,
                kaishuTaishoAddress,
                kaishuNaiyo
        );

        arrayData.add(item);
        return arrayData;

    }


    /*
     * 引数を元にデータグリッド内に挿入する支給申請データを作成します。
     */
    private dgJutakuKaishuDetail_Row createRowShikyuShinseiListAddData(
            int rowId,
            String 着工予定日,
            String 完成予定日,
            String 見積金額,
            String 事業者,
            String 改修住宅住所,
            String 改修内容) {

        dgJutakuKaishuDetail_Row rowShikyuShinseiListData = new dgJutakuKaishuDetail_Row(
                new TextBoxDate(), new TextBoxDate(), new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowShikyuShinseiListData.getTxtChakkoDueDate().setValue(new RDate(着工予定日));
        rowShikyuShinseiListData.getTxtKanseiDueDate().setValue(new RDate(完成予定日));
        rowShikyuShinseiListData.getTxtMitsumoriAmount().setValue(new Decimal(見積金額));
        rowShikyuShinseiListData.setTxtKaishuJigyosha(new RString(事業者));
        rowShikyuShinseiListData.setTxtKaishuTaishoAddress(new RString(改修住宅住所));
        rowShikyuShinseiListData.setTxtKaishuContents(new RString(改修内容));

        if (is事前申請あり(rowId)) {
            rowShikyuShinseiListData.setRowState(RowState.Modified);
        } else {
            rowShikyuShinseiListData.setRowState(RowState.Added);
        }

        return rowShikyuShinseiListData;
    }

    private boolean is事前申請あり(int rowId) {
//デモでは事前申請ありデータはrowId=0で固定にする。
        return (rowId == 0);
    }
    /*
     * 今回の支払状況の値を設定します。
     */

    private void setSummaryAddNowData(JutakuKaishuShinseiInfoPanelDiv panel, String ymlDataName) {

        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData(ymlDataName);

        //JutakuData.xml Read　②
        //今回
        String payTotalNow = ymlData.get(1).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = ymlData.get(1).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = ymlData.get(1).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = ymlData.get(1).get("limitOverAmountNow").toString();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary()
                .getTxtHiyoTotalNow().setValue(new Decimal(payTotalNow));
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary()
                .getTxtHokenTaishoHiyoNow().setValue(new Decimal(hokenSeikyuAmountNow));
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenKyufuAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountNow().setValue(new Decimal(limitOverAmountNow));

    }

    /*
     * クリア設定を行う
     */
    private void setJutakuKaishuJizenShinseiAddDetailInput(JutakuKaishuShinseiInfoPanelDiv panel) {

        //改修の内容をクリア
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount()
                .clearValue();

    }

    /*
     * JutakuKaishuShinseiInfoPanelDiv 申請内容　クリア処理を行う (事前・追加）
     */
    private void setClearJutakuKaishuShinseiInfoPanelDiv(JutakuKaishuShinseiInfoPanelDiv panel) {

        //  明細を追加する
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().
                getBtnModifyDetail().setText(new RString("明細を追加する"));

        //住宅所有者・被保険者との関係   clear
        panel.getJutakuKaishuShinseiContents().getTxtTeikyoYM().clearValue();
        panel.getJutakuKaishuShinseiContents().getTxtSeiriNo().clearValue();
        panel.getJutakuKaishuShinseiContents().getTxtJutakuOwner().clearValue();
        panel.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().clearValue();

        // 住宅改修明細 clear
        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();
        List<dgJutakuKaishuDetail_Row> arraydata = arrayData;
        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
        grid.setDataSource(arraydata);

        //住宅改修明細   clear
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount()
                .clearValue();

        //前回   clear
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHiyoTotalMae().clearValue();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenTaishoHiyoMae().clearValue();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenKyufuAmountMae().clearValue();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountMae().clearValue();

        //今回 clear
        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHiyoTotalNow().clearValue();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenTaishoHiyoNow().clearValue();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenKyufuAmountNow().clearValue();

        panel.getJutakuKaishuShinseiResetInfo().getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountNow().clearValue();

        //申請者情報初期化設定 clear
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtShinseiDate().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtUketsukeDate().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtShinseishaName().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtYubinNo().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtAddress().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtTelNo().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtJigyoshaNo().clearValue();

        //住宅改修理由書 clear
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateDate().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().clearValue();

        //口座振替申請情報 clear
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment().getTxtKinyuKikanCode().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment().getTxtKinyuKikanName().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment().getTxtKinyuKikanBrunchCode().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment().getTxtKinyuKikanBrunchName().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment().getTxtKozaMeigininKana().clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getKozaPayment().getTxtKozaMeiginin().clearValue();
    }

    // TO DO  JutakuData１.xml ①
    private List<HashMap> ymlData(String ymlDataName) {

        return YamlLoader.DBC.loadAsList(new RString("dbc0710011/").concat(ymlDataName));
    }
}

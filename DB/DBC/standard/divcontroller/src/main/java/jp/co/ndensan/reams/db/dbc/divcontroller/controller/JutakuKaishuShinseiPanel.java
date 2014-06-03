/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.MishinsaShikyuShinseiListPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgMishinsaShikyuShinsei_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 *
 * @author n8223
 */
public class JutakuKaishuShinseiPanel {

    /**
     * 住宅改修費支給申請審査 支給一覧の行を選択してから事前申請内容の情報を表示する。（事前申請用ボタン押下）
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @param panel1
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_btnMod(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        //支給内容をクリア処理が行う
        // setClearJutakuKaishuShinseiInfoDiv(panel);
        //YML データ
        String ymlDataName = "MishinsaShikyuShinseiJutakuKaishuShinsei.yml";

        ///////////////////////////////////////////////////////////////////////
        //未審査支給申請一覧画面から来るパラメタ情報（修正ボタン押下後）
        //未審査支給申請一覧 支給申請日、提供年月、氏名、整理番号
        dgMishinsaShikyuShinsei_Row selectedItems
                = panel1.getDgMishinsaShikyuShinsei().getClickedItem();
        //提供年月 
        panel.getJutakuKaishuShinseiContents().getTxtTeikyoYM().
                setValue(new RDate(selectedItems.getTxtTeikyoYM().getValue().toString()));
        //整理番号
        panel.getJutakuKaishuShinseiContents().getTxtSeiriNo().
                setValue(new RString(selectedItems.getTxtSeiriNo().getValue().toString()));
        //氏名
        panel.getJutakuKaishuShinseiContents().getTxtJutakuOwner().
                setValue(new RString(selectedItems.getTxtHihokenshaName().toString()));

        //今回の支払状況
        //見積額
        //txtPayTotalNow
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtPayTotalNow().setValue(new Decimal(selectedItems.getTxtHiyoTotalAmount().getValue().toString()));

        //txtHokenSeikyuAmountNow
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenSeikyuAmountNow().setValue(new Decimal(selectedItems.getTxtHiyoTotalAmount().getValue().toString()));

        //txtRiyoshaFutanAmountNow
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountNow().setValue(new Decimal(selectedItems.getTxtHokenKyufuAmount().getValue().toString()));

        //txtHiyoTotalAmount
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtLimitOverAmountNow().setValue(new Decimal(selectedItems.getTxtRiyoshaFutanAmount().getValue().toString()));

        //事前申請内容の情報を表示する。
        setInfoData(panel, panel1, ymlDataName);

        response.data = panel;
        return response;

    }


    /*
     * 住宅改修費支給申請審査   申請内容の情報を表示する。
     */
    private void setInfoData(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1, String ymlDataName) {

        //住宅所有者・被保険者との関係  
        setJutakuOwnerData(panel, ymlDataName);

        //住宅改修明細 
        setRowShikyuShinseiData(panel, panel1);

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

    private void setRowShikyuShinseiData(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1) {

        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiTestData(panel, panel1);
        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
        grid.setDataSource(arraydata);

    }

    private void setJutakuOwnerData(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);
        //被保険者との関係 
        String relationWithHihokensha = ymlData.get(0).get("relationWithHihokensha").toString();
         //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄

        //被保険者との関係 
        panel.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().
                setValue(new RString(relationWithHihokensha));

    }

    private void setZizenShinseiDetailInput(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);

        String kaishuContents = ymlData.get(1).get("kaishuContents").toString();
        String kaishuJigyoshaName = ymlData.get(1).get("kaishuJigyoshaName").toString();
        String kaishuTaishoAddress1 = ymlData.get(1).get("kaishuTaishoAddress1").toString();
        String chakkoDueDate = ymlData.get(1).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(1).get("kanseiDueDate").toString();
      //  String estimatedAmount = ymlData.get(1).get("estimatedAmount").toString();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
                .setValue(new RString(kaishuContents));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().
                setValue(new RString(kaishuJigyoshaName));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1().
                setValue(new RString(kaishuTaishoAddress1));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate().
                setValue(new RDate(chakkoDueDate));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate().
                setValue(new RDate(kanseiDueDate));

////////////////////////////////////////////////////////////////////////////////        
        dgJutakuKaishuDetail_Row selectedItems
                = panel.getJutakuKaishuShinseiContents().
                getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().
                getDgJutakuKaishuDetail().getClickedItem();

    }

    private void setSummary(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);

        //前回
        String payTotalMae = ymlData.get(2).get("payTotalMae").toString();
        String hokenSeikyuAmountMae = ymlData.get(2).get("hokenSeikyuAmountMae").toString();
        String riyoshaFutanAmountMae = ymlData.get(2).get("riyoshaFutanAmountMae").toString();
        String limitOverAmountMae = ymlData.get(2).get("limitOverAmountMae").toString();

        //今回
        //String limitOverAmountNow = ymlData.get(2).get("limitOverAmountNow").toString();
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        //前回
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtPayTotalMae().setValue(new Decimal(payTotalMae));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtHokenSeikyuAmountMae().setValue(new Decimal(hokenSeikyuAmountMae));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtRiyoshaFutanAmountMae().setValue(new Decimal(riyoshaFutanAmountMae));

        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
                getTxtLimitOverAmountMae().setValue(new Decimal(limitOverAmountMae));

        //今回
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtLimitOverAmountNow().setValue(new Decimal(limitOverAmountNow));
    }

    private void setShinseishaInfo(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);

        String shinseiYMD = ymlData.get(3).get("shinseiYMD").toString();
        String uketsukeYMD = ymlData.get(3).get("uketsukeYMD").toString();
        String shinseishaName = ymlData.get(3).get("shinseishaName").toString();
        String yubinNo = ymlData.get(3).get("yubinNo").toString();
        String address = ymlData.get(3).get("address").toString();
        String telNo = ymlData.get(3).get("telNo").toString();
        String jigyoshaNo = ymlData.get(3).get("jigyoshaNo").toString();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtShinseiYMD().setValue(new RDate(shinseiYMD));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtUketsukeYMD().setValue(new RDate(uketsukeYMD));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtShinseishaName().setValue(new RString(shinseishaName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtYubinNo().setValue(new YubinNo(yubinNo));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtAddress().setValue(new RString(address));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtTelNo().setValue(new RString(telNo));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().
                getTxtJigyoshaNo().setValue(new RString(jigyoshaNo));

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
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreateDate().setValue(new RDate(createDate));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreationJigyoshaNo().setValue(new RString(creationJigyoshaNo));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreationJigyoshaName().setValue(new RString(creationJigyoshaName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreatorKanaName().setValue(new RString(creatorKanaName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().
                getTxtCreatorName().setValue(new RString(creatorName));

    }

    private void setShinseiKozaInfo(JutakuKaishuShinseiPanelDiv panel, String ymlDataName) {

        List<HashMap> ymlData = ymlData(ymlDataName);

        String kinyuKikanCode = ymlData.get(5).get("kinyuKikanCode").toString();
        String kinyuKikanName = ymlData.get(5).get("kinyuKikanName").toString();
        String kinyuBranchCode = ymlData.get(5).get("kinyuBranchCode").toString();
        String kinyuBranchName = ymlData.get(5).get("kinyuBranchName").toString();
        String kozaMeigininKanaName = ymlData.get(5).get("kozaMeigininKanaName").toString();
        String kozaMeigininName = ymlData.get(5).get("kozaMeigininName").toString();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().
                getTxtKinyuKikanCode().setValue(new RString(kinyuKikanCode));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().
                getTxtKinyuKikanName().setValue(new RString(kinyuKikanName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().
                getTxtKinyuBranchCode().setValue(new RString(kinyuBranchCode));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().
                getTxtKinyuBranchName().setValue(new RString(kinyuBranchName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().
                getTxtKozaMeigininKanaName().setValue(new RString(kozaMeigininKanaName));
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().
                getTxtKozaMeigininName().setValue(new RString(kozaMeigininName));

    }

    /**
     * 住宅改修費支給申請審査
     * 申請を追加するボタン押下後、申請内容の情報を表示する（明細を追加するボタン押下後、住宅改修明細を表示、改修内容などは、クリア処理が行う）
     *
     * @param panel JutakuKaishuShinseiPanelDiv
     * @param panel1
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_btnAddDetail(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        //TO DO　現在選択された内容があるのかチェックする。
        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiAddTestData(panel, panel1);
        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
        grid.setDataSource(arraydata);

        //今回設定
        //setSummaryAddNowData(panel, ymlDataName);
        //クリア設定
        setJutakuKaishuJizenShinseiAddDetailInput(panel);

        response.data = panel;
        return response;

    }

    /*
     住宅改修明細をセットします。
     */
    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiTestData(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1) {

        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();

        String ymlDataName = "MishinsaShikyuShinseiDgJutakKaishiDetailRow.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        String chakkoDueDate = ymlData.get(0).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(0).get("kanseiDueDate").toString();
        String kaishuJigyosha = ymlData.get(0).get("kaishuJigyosha").toString();

        dgMishinsaShikyuShinsei_Row selectedItems
                = panel1.getDgMishinsaShikyuShinsei().getClickedItem();

        String estimatedAmount = selectedItems.getTxtHiyoTotalAmount().getValue().toString();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        dgJutakuKaishuDetail_Row item;
        item = createRowShikyuShinseiListAddData(
                chakkoDueDate,
                kanseiDueDate,
                estimatedAmount,
                kaishuJigyosha
        );

        arrayData.add(item);
        return arrayData;

    }

    /*
     住宅改修明細をセットします。
     */
    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiAddTestData(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1) {

        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();

        String ymlDataName = "MishinsaShikyuShinseiDgJutakKaishiDetailRow.yml";
        List<HashMap> ymlData = ymlData(ymlDataName);

        String chakkoDueDate = ymlData.get(0).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(0).get("kanseiDueDate").toString();
        //String mitsumoriAmount = ymlData.get(0).get("mitsumoriAmount").toString();
        String kaishuJigyosha = ymlData.get(0).get("kaishuJigyosha").toString();

        dgMishinsaShikyuShinsei_Row selectedItems
                = panel1.getDgMishinsaShikyuShinsei().getClickedItem();

        String mitsumoriAmount
                = selectedItems.getTxtHiyoTotalAmount().getValue().toString();

        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        dgJutakuKaishuDetail_Row item;
        item = createRowShikyuShinseiListAddData(
                chakkoDueDate,
                kanseiDueDate,
                mitsumoriAmount,
                kaishuJigyosha
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
            String 事業者
    ) {

        dgJutakuKaishuDetail_Row rowShikyuShinseiListData = new dgJutakuKaishuDetail_Row(
                new Button(), new Button(), new TextBoxDate(), new TextBoxDate(), new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY);

        rowShikyuShinseiListData.getTxtChakkoDueDate().setValue(new RDate(着工予定日));
        rowShikyuShinseiListData.getTxtKanseiDueDate().setValue(new RDate(完成予定日));
        rowShikyuShinseiListData.getTxtMitsumoriAmount().setValue(new Decimal(見積金額));
        rowShikyuShinseiListData.setTxtKaishuJigyosha(new RString(事業者));

        return rowShikyuShinseiListData;
    }

    private void setJutakuKaishuJizenShinseiAddDetailInput(JutakuKaishuShinseiPanelDiv panel) {

        //改修の内容をクリア
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName()
                .clearValue();
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1()
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

    /**
     * 住宅改修費支給申請審査 住宅改修明細の修正ボタンをボタン押下後、改修内容を反映する。（事前申請用ボタン押下）
     *
     * @param panel JutakuKaishuShinseiInfoDiv
     * @param panel1
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuShinseiPanelDiv> onClick_btnModify(JutakuKaishuShinseiPanelDiv panel, MishinsaShikyuShinseiListPanelDiv panel1) {
        ResponseData<JutakuKaishuShinseiPanelDiv> response = new ResponseData<>();

        //追加するデータ
        String ymlDataName = "MishinsaShikyuShinseiJutakuKaishuShinsei.yml";
        //改修内容を反映する。
        setZizenShinseiDetailInput(panel, ymlDataName);
        //TO DO 
        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().
                getBtnAddDetail().setText(new RString("明細を修正する"));

        response.data = panel;
        return response;
    }

    /* 
     * YML DATA 
     */
    private List<HashMap> ymlData(String ymlDataName) {

        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
    }

}

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// *  JutakuData_1.yml JutakuData_1_1.yml JutakuData_1_2.yml JutakuData_1_3.yml
// *  JutakuData_2.yml JutakuData_2_1.yml JutakuData_2_2
// */
//package jp.co.ndensan.reams.db.dbc.divcontroller.controller;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiInfoDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiListDiv;
//import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuDetail_Row;
//import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
//import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
//import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
//import jp.co.ndensan.reams.uz.uza.lang.RDate;
//import jp.co.ndensan.reams.uz.uza.lang.RString;
//import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
//import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
//import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
//
///**
// *
// * @author n8223
// */
//public class JutakuKaishuShinseiInfo {
//
//    /**
//     * 住宅改修費事前申請登録 支給一覧の行を選択してから事前申請内容の情報を表示する。（事前申請用ボタン押下）
//     *
//     * @param panel HihokenshaSearchGaitoshaPanelDiv
//     * @return PanelDivのResponseData
//     */
//    public ResponseData<JutakuKaishuShinseiInfoDiv> onClick_btnShowDetail(JutakuKaishuShinseiInfoDiv panel, JutakuKaishuShinseiListDiv panel1) {
//        ResponseData<JutakuKaishuShinseiInfoDiv> response = new ResponseData<>();
//
//        //支給内容をクリア処理が行う
//        setClearJutakuKaishuShinseiInfoDiv(panel);
//        //事前申請用のデータ
//        String ymlDataName = "JutakuData_1_1.yml";
//        //事前申請内容の情報を表示する。
//        setInfoData(panel, ymlDataName);
//
//        response.data = panel;
//        return response;
//
//    }
//
//    /**
//     * 住宅改修費事前申請登録 住宅改修明細の修正ボタンをボタン押下後、改修内容を反映する。（事前申請用ボタン押下）
//     *
//     * @param panel JutakuKaishuShinseiInfoDiv
//     * @return PanelDivのResponseData
//     */
//    public ResponseData<JutakuKaishuShinseiInfoDiv> onClick_btnModify(JutakuKaishuShinseiInfoDiv panel, JutakuKaishuShinseiListDiv panel1) {
//        ResponseData<JutakuKaishuShinseiInfoDiv> response = new ResponseData<>();
//
//        //追加するデータ
//        String ymlDataName = "JutakuData_1_1.yml";
//        //改修内容を反映する。
//        setZizenShinseiDetailInput(panel, ymlDataName);
//        //TO DO
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().
//                getBtnAddDetail().setText(new RString("明細を修正する"));
//
//        response.data = panel;
//        return response;
//
//
//    }
//
//    /**
//     * 住宅改修費事前申請登録 申請を追加するボタン押下後、事前申請内容の情報を表示する。（申請を追加するボタン押下）
//     *
//     * @param panel JutakuKaishuShinseiInfoDiv
//     * @return PanelDivのResponseData
//     */
//    public ResponseData<JutakuKaishuShinseiInfoDiv> onClick_btnAddShinsei(JutakuKaishuShinseiInfoDiv panel, JutakuKaishuShinseiListDiv panel1) {
//        ResponseData<JutakuKaishuShinseiInfoDiv> response = new ResponseData<>();
//
//        //支給内容をクリア処理が行う
//        setClearJutakuKaishuShinseiInfoDiv(panel);
//        //追加するデータ
//        String ymlDataName = "JutakuData_2_1.yml";
//        //事前申請内容の情報を表示する。
//
//        setInfoData(panel, ymlDataName);
//
//        response.data = panel;
//        return response;
//
//    }
//
//    /**
//     * 住宅改修費事前申請登録
//     * 申請を追加するボタン押下後、事前申請内容の情報を表示する（明細を追加するボタン押下後、住宅改修明細を表示し、改修内容などは、クリア処理が行う）
//     *
//     * @param panel JutakuKaishuShinseiInfoDiv
//     * @return PanelDivのResponseData
//     */
//    public ResponseData<JutakuKaishuShinseiInfoDiv> onClick_btnAddDetail(JutakuKaishuShinseiInfoDiv panel, JutakuKaishuShinseiListDiv panel1) {
//        ResponseData<JutakuKaishuShinseiInfoDiv> response = new ResponseData<>();
//
//        //TO DO　現在選択された内容があるのかチェックする。
//        int selRowId = panel1.getDgJutakuKaishuShinseiList().getClickedRowId();
//        String ymlDataName;
//
//        if (selRowId >= 0) {
//            ymlDataName = "JutakuData_1_3.yml";
//        } else {
//            //追加するデータ
//            ymlDataName = "JutakuData_2_2.yml";
//        }
//
//        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiAddTestData(panel, ymlDataName);
//        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
//        grid.setDataSource(arraydata);
//
//        //今回設定
//        setSummaryAddNowData(panel, ymlDataName);
//        //クリア設定
//        setJutakuKaishuJizenShinseiAddDetailInput(panel);
//
//        response.data = panel;
//        return response;
//
//    }
//
//    /*
//     * 住宅改修費事前申請登録   事前申請内容の情報を表示する。
//     */
//    private void setInfoData(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        ////////////////////////////////////////
//        //住宅所有者・被保険者との関係
//        setJutakuOwnerData(panel, ymlDataName);
//
//        if (ymlDataName.equals("JutakuData_1_1.yml")) {
//            //住宅改修明細 ①
//            setZizenJutakuKaishuDetail(panel, ymlDataName);
//        }
//
//        if (ymlDataName.equals("JutakuData_2_1.yml")) {
//            //住宅改修明細 ②
//            setZizenShinseiDetailInput(panel, ymlDataName);
//        }
//
//        //前回・今回初期化設定
//        setSummary(panel, ymlDataName);
//        //申請者情報初期化設定
//        setShinseishaInfo(panel, ymlDataName);
//        //住宅改修理由書
//        setShinseiReason(panel, ymlDataName);
//        //口座振替申請情報（UR)
//        setShinseiKozaInfo(panel, ymlDataName);
//        ////////////////////////////////////////
//    }
//
//    /*
//     住宅所有者・被保険者との関係　の初期値をセットします。
//     */
//    private void setJutakuOwnerData(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        String teikyoYM = ymlData.get(0).get("teikyoYM").toString();
//        String seiriNo = ymlData.get(0).get("seiriNo").toString();
//        String jutakuOwner = ymlData.get(0).get("jutakuOwner").toString();
//        String relationWithHihokensha = ymlData.get(0).get("relationWithHihokensha").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        panel.getJutakuKaishuShinseiContents().
//                getTxtTeikyoYM().setValue(new RDate(teikyoYM));
//        panel.getJutakuKaishuShinseiContents().
//                getTxtSeiriNo().setValue(new RString(seiriNo));
//        panel.getJutakuKaishuShinseiContents().
//                getTxtJutakuOwner().setValue(new RString(jutakuOwner));
//        panel.getJutakuKaishuShinseiContents().
//                getTxtRelationWithHihokensha().setValue(new RString(relationWithHihokensha));
//
//    }
//
//    /*
//     * 住宅改修明細をセットします。
//     */
//    private void setZizenJutakuKaishuDetail(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiTestData(ymlDataName);
//        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
//
//        grid.setDataSource(arraydata);
//
//    }
//
//    /*
//     住宅改修明細をセットします。
//     */
//    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiTestData(String ymlDataName) {
//
//        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        String chakkoDueDate = ymlData.get(6).get("chakkoDueDate").toString();
//        String kanseiDueDate = ymlData.get(6).get("kanseiDueDate").toString();
//        String mitsumoriAmount = ymlData.get(6).get("mitsumoriAmount").toString();
//        String kaishuJigyosha = ymlData.get(6).get("kaishuJigyosha").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        dgJutakuKaishuDetail_Row item;
//        item = createRowShikyuShinseiListData(
//                chakkoDueDate,
//                kanseiDueDate,
//                mitsumoriAmount,
//                kaishuJigyosha
//        );
//
//        arrayData.add(item);
//        return arrayData;
//
//    }
//
//    /*
//     引数を元にデータグリッド内に挿入する支給申請データを作成します。
//     */
//    private dgJutakuKaishuDetail_Row createRowShikyuShinseiListData(
//            String 着工予定日,
//            String 完成予定日,
//            String 見積金額,
//            String 事業者
//    ) {
//
//        dgJutakuKaishuDetail_Row rowShikyuShinseiListData = new dgJutakuKaishuDetail_Row(
//                new Button(), new Button(), new TextBoxDate(), new TextBoxDate(), new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        rowShikyuShinseiListData.getTxtChakkoDueDate().setValue(new RDate(着工予定日));
//        rowShikyuShinseiListData.getTxtKanseiDueDate().setValue(new RDate(完成予定日));
//        rowShikyuShinseiListData.getTxtMitsumoriAmount().setValue(new Decimal(見積金額));
//        rowShikyuShinseiListData.setTxtKaishuJigyosha(new RString(事業者));
//
//        return rowShikyuShinseiListData;
//    }
//
//    /*
//     *住宅改修明細の初期値をセットします。
//     */
//    private void setZizenShinseiDetailInput(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        String kaishuContents = ymlData.get(1).get("kaishuContents").toString();
//        String kaishuJigyoshaName = ymlData.get(1).get("kaishuJigyoshaName").toString();
//        String kaishuTaishoAddress1 = ymlData.get(1).get("kaishuTaishoAddress1").toString();
//        String chakkoDueDate = ymlData.get(1).get("chakkoDueDate").toString();
//        String kanseiDueDate = ymlData.get(1).get("kanseiDueDate").toString();
//        String estimatedAmount = ymlData.get(1).get("estimatedAmount").toString();
//        /////////////////////////////////////////////////////////////////////////////////////////
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
//                .setValue(new RString(kaishuContents));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().
//                setValue(new RString(kaishuJigyoshaName));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1().
//                setValue(new RString(kaishuTaishoAddress1));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate().
//                setValue(new RDate(chakkoDueDate));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate().
//                setValue(new RDate(kanseiDueDate));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount().
//                setValue(new Decimal(estimatedAmount));
//    }
//
//    /*
//     前回・今回　初期化設定の初期値をセットします。
//     */
//    private void setSummary(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        //前回
//        String payTotalMae = ymlData.get(2).get("payTotalMae").toString();
//        String hokenSeikyuAmountMae = ymlData.get(2).get("hokenSeikyuAmountMae").toString();
//        String riyoshaFutanAmountMae = ymlData.get(2).get("riyoshaFutanAmountMae").toString();
//        String limitOverAmountMae = ymlData.get(2).get("limitOverAmountMae").toString();
//        //今回
//        String payTotalNow = ymlData.get(2).get("payTotalNow").toString();
//        String hokenSeikyuAmountNow = ymlData.get(2).get("hokenSeikyuAmountNow").toString();
//        String riyoshaFutanAmountNow = ymlData.get(2).get("riyoshaFutanAmountNow").toString();
//        String limitOverAmountNow = ymlData.get(2).get("limitOverAmountNow").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        //前回
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtPayTotalMae().setValue(new Decimal(payTotalMae));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenSeikyuAmountMae().setValue(new Decimal(hokenSeikyuAmountMae));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtRiyoshaFutanAmountMae().setValue(new Decimal(riyoshaFutanAmountMae));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtLimitOverAmountMae().setValue(new Decimal(limitOverAmountMae));
//
//        //今回
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtPayTotalNow().setValue(new Decimal(payTotalNow));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenSeikyuAmountNow().setValue(new Decimal(hokenSeikyuAmountNow));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtRiyoshaFutanAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtLimitOverAmountNow().setValue(new Decimal(limitOverAmountNow));
//
//    }
//
//    /*
//     申請者情報の初期値をセットします。
//     */
//    private void setShinseishaInfo(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        String shinseiYMD = ymlData.get(3).get("shinseiYMD").toString();
//        String uketsukeYMD = ymlData.get(3).get("uketsukeYMD").toString();
//        String shinseishaName = ymlData.get(3).get("shinseishaName").toString();
//        String yubinNo = ymlData.get(3).get("yubinNo").toString();
//        String address = ymlData.get(3).get("address").toString();
//        String telNo = ymlData.get(3).get("telNo").toString();
//        String jigyoshaNo = ymlData.get(3).get("jigyoshaNo").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtShinseiYMD().setValue(new RDate(shinseiYMD));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtUketsukeYMD().setValue(new RDate(uketsukeYMD));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtShinseishaName().setValue(new RString(shinseishaName));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtYubinNo().setValue(new YubinNo(yubinNo));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtAddress().setValue(new RString(address));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtTelNo().setValue(new RString(telNo));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtJigyoshaNo().setValue(new RString(jigyoshaNo));
//
//    }
//
//    /*
//     住宅改修理由書の初期値をセットします。
//     */
//    private void setShinseiReason(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        String createDate = ymlData.get(4).get("createDate").toString();
//        String creationJigyoshaNo = ymlData.get(4).get("creationJigyoshaNo").toString();
//        String creationJigyoshaName = ymlData.get(4).get("creationJigyoshaName").toString();
//        String creatorKanaName = ymlData.get(4).get("creatorKanaName").toString();
//        String creatorName = ymlData.get(4).get("creatorName").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateDate().setValue(new RDate(createDate));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().setValue(new RString(creationJigyoshaNo));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().setValue(new RString(creationJigyoshaName));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().setValue(new RString(creatorKanaName));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().setValue(new RString(creatorName));
//
//    }
//
//    /*
//     口座振替申請情報（UR)の初期値をセットします。
//     */
//    private void setShinseiKozaInfo(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        String kinyuKikanCode = ymlData.get(5).get("kinyuKikanCode").toString();
//        String kinyuKikanName = ymlData.get(5).get("kinyuKikanName").toString();
//        String kinyuBranchCode = ymlData.get(5).get("kinyuBranchCode").toString();
//        String kinyuBranchName = ymlData.get(5).get("kinyuBranchName").toString();
//        String kozaMeigininKanaName = ymlData.get(5).get("kozaMeigininKanaName").toString();
//        String kozaMeigininName = ymlData.get(5).get("kozaMeigininName").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuKikanCode().setValue(new RString(kinyuKikanCode));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuKikanName().setValue(new RString(kinyuKikanName));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuBranchCode().setValue(new RString(kinyuBranchCode));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuBranchName().setValue(new RString(kinyuBranchName));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKozaMeigininKanaName().setValue(new RString(kozaMeigininKanaName));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKozaMeigininName().setValue(new RString(kozaMeigininName));
//
//    }
//
//    /*
//     住宅改修明細をセットします。
//     */
//    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiAddTestData(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//
//        //JutakuData.xml Read　②
//        String chakkoDueDate = ymlData.get(0).get("chakkoDueDate").toString();
//        String kanseiDueDate = ymlData.get(0).get("kanseiDueDate").toString();
//        String mitsumoriAmount = ymlData.get(0).get("mitsumoriAmount").toString();
//        String kaishuJigyosha = ymlData.get(0).get("kaishuJigyosha").toString();
//
//        //TO DO  JutakuData.xml Write　③
//        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
//        dgJutakuKaishuDetail_Row item;
//        item = createRowShikyuShinseiListAddData(
//                chakkoDueDate,
//                kanseiDueDate,
//                mitsumoriAmount,
//                kaishuJigyosha
//        );
//
//        arrayData.add(item);
//        return arrayData;
//
//    }
//
//
//    /*
//     * 引数を元にデータグリッド内に挿入する支給申請データを作成します。
//     */
//    private dgJutakuKaishuDetail_Row createRowShikyuShinseiListAddData(
//            String 着工予定日,
//            String 完成予定日,
//            String 見積金額,
//            String 事業者
//    ) {
//
//        dgJutakuKaishuDetail_Row rowShikyuShinseiListData = new dgJutakuKaishuDetail_Row(
//                new Button(), new Button(), new TextBoxDate(), new TextBoxDate(), new TextBoxNum(), RString.EMPTY, RString.EMPTY, RString.EMPTY);
//
//        rowShikyuShinseiListData.getTxtChakkoDueDate().setValue(new RDate(着工予定日));
//        rowShikyuShinseiListData.getTxtKanseiDueDate().setValue(new RDate(完成予定日));
//        rowShikyuShinseiListData.getTxtMitsumoriAmount().setValue(new Decimal(見積金額));
//        rowShikyuShinseiListData.setTxtKaishuJigyosha(new RString(事業者));
//
//        return rowShikyuShinseiListData;
//    }
//
//    /*
//     * 今回の支払状況の値を設定します。
//     */
//    private void setSummaryAddNowData(JutakuKaishuShinseiInfoDiv panel, String ymlDataName) {
//
//        //TO DO  JutakuData1.xml ①
//        List<HashMap> ymlData = ymlData(ymlDataName);
//
//        //JutakuData.xml Read　②
//        //今回
//        String payTotalNow = ymlData.get(1).get("payTotalNow").toString();
//        String hokenSeikyuAmountNow = ymlData.get(1).get("hokenSeikyuAmountNow").toString();
//        String riyoshaFutanAmountNow = ymlData.get(1).get("riyoshaFutanAmountNow").toString();
//        String limitOverAmountNow = ymlData.get(1).get("limitOverAmountNow").toString();
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary()
//                .getTxtPayTotalNow().setValue(new Decimal(payTotalNow));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary()
//                .getTxtHokenSeikyuAmountNow().setValue(new Decimal(hokenSeikyuAmountNow));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtRiyoshaFutanAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtLimitOverAmountNow().setValue(new Decimal(limitOverAmountNow));
//
//    }
//
//    /*
//     * クリア設定を行う
//     */
//    private void setJutakuKaishuJizenShinseiAddDetailInput(JutakuKaishuShinseiInfoDiv panel) {
//
//        //改修の内容をクリア
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount()
//                .clearValue();
//
//    }
//
//    /*
//     * JutakuKaishuShinseiInfoDiv 申請内容　クリア処理を行う (事前・追加）
//     */
//    private void setClearJutakuKaishuShinseiInfoDiv(JutakuKaishuShinseiInfoDiv panel) {
//
//       //  明細を追加する
//       panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().
//                getBtnAddDetail().setText(new RString("明細を追加する"));
//
//        //住宅所有者・被保険者との関係   clear
//        panel.getJutakuKaishuShinseiContents().getTxtTeikyoYM().clearValue();
//        panel.getJutakuKaishuShinseiContents().getTxtSeiriNo().clearValue();
//        panel.getJutakuKaishuShinseiContents().getTxtJutakuOwner().clearValue();
//        panel.getJutakuKaishuShinseiContents().getTxtRelationWithHihokensha().clearValue();
//
//        // 住宅改修明細 clear
//        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();
//        List<dgJutakuKaishuDetail_Row> arraydata = arrayData;
//        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getDgJutakuKaishuDetail();
//        grid.setDataSource(arraydata);
//
//        //住宅改修明細   clear
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuContents()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtChakkoDueDate()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtKanseiDueDate()
//                .clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiDetailInput().getJutakuKaishuDetailInput().getTxtEstimatedAmount()
//                .clearValue();
//
//        //前回   clear
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtPayTotalMae().clearValue();
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenSeikyuAmountMae().clearValue();
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtRiyoshaFutanAmountMae().clearValue();
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtLimitOverAmountMae().clearValue();
//
//        //今回 clear
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtPayTotalNow().clearValue();
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtHokenSeikyuAmountNow().clearValue();
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtRiyoshaFutanAmountNow().clearValue();;
//
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiDetail().
//                getJutakuKaishuShinseiKyufugakuSummary().getTblSeikyuSummary().
//                getTxtLimitOverAmountNow().clearValue();
//
//        //申請者情報初期化設定 clear
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtShinseiYMD().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtUketsukeYMD().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtShinseishaName().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtYubinNo().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtAddress().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtTelNo().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseisha().getTxtJigyoshaNo().clearValue();
//
//        //住宅改修理由書 clear
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreateDate().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaNo().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreationJigyoshaName().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorKanaName().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiReason().getTxtCreatorName().clearValue();
//
//        //口座振替申請情報 clear
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuKikanCode().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuKikanName().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuBranchCode().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKinyuBranchName().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKozaMeigininKanaName().clearValue();
//        panel.getJutakuKaishuShinseiContents().getJutakuKaishuShinseiKozaInfo().getTxtKozaMeigininName().clearValue();
//    }
//
//    // TO DO  JutakuData１.xml ①
//    private List<HashMap> ymlData(String ymlDataName) {
//
//        return YamlLoader.FOR_DBC.loadAsList(new RString(ymlDataName));
//    }
//}

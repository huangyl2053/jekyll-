/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuJizenShinseiContentsDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuDetail_Row;
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
 * 住宅改修費事前申請登録　事前申請内容の情報のパネルです。
 *
 * @author n8223
 */
public class JutakuKaishuShinseiContents {

    /**
     * 住宅改修費事前申請登録 事前申請内容の情報を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsDiv> onClick_btnShowDetail(JutakuKaishuJizenShinseiContentsDiv panel) {
        ResponseData<JutakuKaishuJizenShinseiContentsDiv> response = new ResponseData<>();

        //住宅所有者・被保険者との関係  
        setJutakuOwnerData(panel);
        //住宅改修明細 
        setZizenShinseiDetailInput(panel);
        //前回・今回初期化設定
        setSummary(panel);
        //申請者情報初期化設定
        setShinseishaInfo(panel);
        //住宅改修理由書
        setShinseiReason(panel);
        //口座振替申請情報（UR)
        setShinseiKozaInfo(panel);

        response.data = panel;
        return response;

    }

    /*
     住宅所有者・被保険者との関係　の初期値をセットします。
     */
    private void setJutakuOwnerData(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //JutakuData.xml Read　②
        String jutakuOwner = ymlData.get(3).get("jutakuOwner").toString();
        String relationWithHihokensha = ymlData.get(3).get("relationWithHihokensha").toString();
       ///////////////////////////////////////////////////////////////////////////////////////// 

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getTxtJutakuOwner().setValue(new RString(jutakuOwner));
        panel.getTxtRelationWithHihokensha().setValue(new RString(relationWithHihokensha));

    }

    /*
     /住宅改修明細の初期値をセットします。
     */
    private void setZizenShinseiDetailInput(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //JutakuData.xml Read　②
        String kaishuContents = ymlData.get(4).get("kaishuContents").toString();
        String kaishuJigyoshaName = ymlData.get(4).get("kaishuJigyoshaName").toString();
        String kaishuTaishoAddress1 = ymlData.get(4).get("kaishuTaishoAddress1").toString();
        String chakkoDueDate = ymlData.get(4).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(4).get("kanseiDueDate").toString();
        String estimatedAmount = ymlData.get(4).get("estimatedAmount").toString();
        ///////////////////////////////////////////////////////////////////////////////////////// 

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuContents().setValue(new RString(kaishuContents));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().setValue(new RString(kaishuJigyoshaName));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1().setValue(new RString(kaishuTaishoAddress1));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtChakkoDueDate().setValue(new RDate(chakkoDueDate));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKanseiDueDate().setValue(new RDate(kanseiDueDate));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtEstimatedAmount().setValue(new Decimal(estimatedAmount));

    }

    /*
     前回・今回　初期化設定の初期値をセットします。
     */
    private void setSummary(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //JutakuData.xml Read　② 
        //前回
        String payTotalMae = ymlData.get(5).get("payTotalMae").toString();
        String hokenSeikyuAmountMae = ymlData.get(5).get("hokenSeikyuAmountMae").toString();
        String riyoshaFutanAmountMae = ymlData.get(5).get("riyoshaFutanAmountMae").toString();
        String limitOverAmountMae = ymlData.get(5).get("limitOverAmountMae").toString();
        //今回
        String payTotalNow = ymlData.get(5).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = ymlData.get(5).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = ymlData.get(5).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = ymlData.get(5).get("limitOverAmountNow").toString();
        ///////////////////////////////////////////////////////////////////////////////////////// 

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        //前回
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtPayTotalMae().setValue(new Decimal(payTotalMae));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtHokenSeikyuAmountMae().setValue(new Decimal(hokenSeikyuAmountMae));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtRiyoshaFutanAmountMae().setValue(new Decimal(riyoshaFutanAmountMae));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtLimitOverAmountMae().setValue(new Decimal(limitOverAmountMae));

        //今回
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtPayTotalNow().setValue(new Decimal(payTotalNow));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtHokenSeikyuAmountNow().setValue(new Decimal(hokenSeikyuAmountNow));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtLimitOverAmountNow().setValue(new Decimal(limitOverAmountNow));

    }

    /*
     申請者情報の初期値をセットします。
     */
    private void setShinseishaInfo(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //JutakuData.xml Read　② 
        String shinseiYMD = ymlData.get(6).get("shinseiYMD").toString();
        String uketsukeYMD = ymlData.get(6).get("uketsukeYMD").toString();
        String shinseishaName = ymlData.get(6).get("shinseishaName").toString();
        String yubinNo = ymlData.get(6).get("yubinNo").toString();
        String address = ymlData.get(6).get("address").toString();
        String telNo = ymlData.get(6).get("telNo").toString();
        String jigyoshaNo = ymlData.get(6).get("jigyoshaNo").toString();
       ///////////////////////////////////////////////////////////////////////////////////////// 

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuJizenShinseiSha().getTxtShinseiYMD().setValue(new RDate(shinseiYMD));
        panel.getJutakuKaishuJizenShinseiSha().getTxtUketsukeYMD().setValue(new RDate(uketsukeYMD));
        panel.getJutakuKaishuJizenShinseiSha().getTxtShinseishaName().setValue(new RString(shinseishaName));
        panel.getJutakuKaishuJizenShinseiSha().getTxtYubinNo().setValue(new YubinNo(yubinNo));
        panel.getJutakuKaishuJizenShinseiSha().getTxtAddress().setValue(new RString(address));
        panel.getJutakuKaishuJizenShinseiSha().getTxtTelNo().setValue(new RString(telNo));
        panel.getJutakuKaishuJizenShinseiSha().getTxtJigyoshaNo().setValue(new RString(jigyoshaNo));

    }

    /*
     住宅改修理由書の初期値をセットします。
     */
    private void setShinseiReason(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //JutakuData.xml Read　② 
        String createDate = ymlData.get(7).get("createDate").toString();
        String creationJigyoshaNo = ymlData.get(7).get("creationJigyoshaNo").toString();
        String creationJigyoshaName = ymlData.get(7).get("creationJigyoshaName").toString();
        String creatorKanaName = ymlData.get(7).get("creatorKanaName").toString();
        String creatorName = ymlData.get(7).get("creatorName").toString();
       /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuJizenShinseiReason().getTxtCreateDate().setValue(new RDate(createDate));
        panel.getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaNo().setValue(new RString(creationJigyoshaNo));
        panel.getJutakuKaishuJizenShinseiReason().getTxtCreationJigyoshaName().setValue(new RString(creationJigyoshaName));
        panel.getJutakuKaishuJizenShinseiReason().getTxtCreatorKanaName().setValue(new RString(creatorKanaName));
        panel.getJutakuKaishuJizenShinseiReason().getTxtCreatorName().setValue(new RString(creatorName));

    }

    /*
     口座振替申請情報（UR)の初期値をセットします。
     */
    private void setShinseiKozaInfo(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuData1.xml ①
        List<HashMap> ymlData = ymlData();

        //JutakuData.xml Read　② 
        String kinyuKikanCode = ymlData.get(8).get("kinyuKikanCode").toString();
        String kinyuKikanName = ymlData.get(8).get("kinyuKikanName").toString();
        String kinyuBranchCode = ymlData.get(8).get("kinyuBranchCode").toString();
        String kinyuBranchName = ymlData.get(8).get("kinyuBranchName").toString();
        String kozaMeigininKanaName = ymlData.get(8).get("kozaMeigininKanaName").toString();
        String kozaMeigininName = ymlData.get(8).get("kozaMeigininName").toString();
        ///////////////////////////////////////////////////////////////////////////////////////// 

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuKikanCode().setValue(new RString(kinyuKikanCode));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuKikanName().setValue(new RString(kinyuKikanName));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuBranchCode().setValue(new RString(kinyuBranchCode));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuBranchName().setValue(new RString(kinyuBranchName));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKozaMeigininKanaName().setValue(new RString(kozaMeigininKanaName));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKozaMeigininName().setValue(new RString(kozaMeigininName));

    }

    /**
     * 住宅改修費事前申請登録 明細を追加するボタンを押下後、住宅改修明細を表示する。
     *
     * @param panel HihokenshaSearchGaitoshaPanelDiv
     * @return PanelDivのResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsDiv> onClick_btnAddDetail(JutakuKaishuJizenShinseiContentsDiv panel) {
        ResponseData<JutakuKaishuJizenShinseiContentsDiv> response = new ResponseData<>();

        //住宅改修明細
        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiTestData();
        DataGrid<dgJutakuKaishuDetail_Row> grid = panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().getDgJutakuKaishuDetail();
        grid.setDataSource(arraydata);

        //今回設定
        setSummaryNowData(panel);

        //クリア設定
        setJutakuKaishuJizenShinseiDetailInput(panel);

        response.data = panel;
        return response;

    }

    /*
     住宅改修明細をセットします。
     */
    private List<dgJutakuKaishuDetail_Row> createRowShikyuShinseiTestData() {

        List<dgJutakuKaishuDetail_Row> arrayData = new ArrayList<>();

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuHihokenshaSearchData.xml ①
        List<HashMap> ymlData = YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData.yml"));

        //JutakuData.xml Read　② 
        String chakkoDueDate = ymlData.get(9).get("chakkoDueDate").toString();
        String kanseiDueDate = ymlData.get(9).get("kanseiDueDate").toString();
        String mitsumoriAmount = ymlData.get(9).get("mitsumoriAmount").toString();
        String kaishuJigyosha = ymlData.get(9).get("kaishuJigyosha").toString();

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        dgJutakuKaishuDetail_Row item;
        item = createRowShikyuShinseiListData(
                chakkoDueDate,
                kanseiDueDate,
                mitsumoriAmount,
                kaishuJigyosha
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

    /*
     今回の支払状況の値を設定します。
     */
    private void setSummaryNowData(JutakuKaishuJizenShinseiContentsDiv panel) {

        ///////////////////////////////////////////////////////////////////////////////////////// 
        //TO DO  JutakuHihokenshaSearchData.xml ①
        List<HashMap> ymlData = YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData.yml"));

        //JutakuData.xml Read　② 
        //今回
        String payTotalNow = ymlData.get(10).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = ymlData.get(10).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = ymlData.get(10).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = ymlData.get(10).get("limitOverAmountNow").toString();
        ///////////////////////////////////////////////////////////////////////////////////////// 

        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtPayTotalNow().setValue(new Decimal(payTotalNow));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtHokenSeikyuAmountNow().setValue(new Decimal(hokenSeikyuAmountNow));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtRiyoshaFutanAmountNow().setValue(new Decimal(riyoshaFutanAmountNow));
        panel.getJutakuKaishuZizenShinseiDetail().
                getJutakuKaishuJizenShinseiKyufugakuSummary().
                getTblSeikyuSummary().getTxtLimitOverAmountNow().setValue(new Decimal(limitOverAmountNow));

    }

    /*
     クリア設定を行う
     */
    private void setJutakuKaishuJizenShinseiDetailInput(JutakuKaishuJizenShinseiContentsDiv panel) {

        //改修の内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuContents().clearValue();

        //事業者の内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().clearValue();
        //着・完成日内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress1().clearValue();
        //着・完成日内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtChakkoDueDate().clearValue();
        //見積額をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKanseiDueDate().clearValue();

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtEstimatedAmount().clearValue();

    }

    // TO DO  JutakuData１.xml ①
    private List<HashMap> ymlData() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("JutakuData_1.yml"));
    }
}

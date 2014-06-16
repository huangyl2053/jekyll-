package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0700011;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.JutakuKaishuDetailInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.dgJutakuKaishuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiContentsPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 住宅改修費事前申請登録　事前申請内容のパネルです。
 *
 * @author n8223 朴
 */
public class JutakuKaishuJizenShinseiContentsPanel {

    private final List<HashMap> targetSource = YamlLoader.DBC.loadAsList(new RString("dbc0700011/JutakuData.yml"));

    /**
     * 住宅改修費事前申請登録 事前申請内容の情報を表示する。
     *
     * @param shinseiPanel 住宅改修事前申請panel
     * @param hihokenshaPanel 被保険者panel
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onLoad(JutakuKaishuJizenShinseiContentsPanelDiv shinseiPanel,
            JutakuKaishuJizenShinseiHihokenshaPanelDiv hihokenshaPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        //住宅所有者・被保険者との関係　
        setJutakuOwnerData(shinseiPanel);
        //住宅改修明細 　　　　　　　　　
        setZizenShinseiDetailInput(shinseiPanel);
        //前回・今回　初期化設定　　　　　　
        setSummary(shinseiPanel);
        //申請者情報　初期化設定　　　　　　
        setShinseishaInfo(shinseiPanel);
        //住宅改修理由書
        setShinseiReason(shinseiPanel);
        //口座振替申請情報（UR)
        setShinseiKozaInfo(shinseiPanel);

        response.data = shinseiPanel;
        return response;

    }

    /*
     住宅所有者・被保険者との関係　の初期値をセットします。
     */
    private void setJutakuOwnerData(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        String jutakuOwner = targetSource.get(2).get("jutakuOwner").toString();
        String relationWithHihokensha = targetSource.get(2).get("relationWithHihokensha").toString();
       /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getTxtJutakuOwner().setValue(new RString(jutakuOwner));
        panel.getTxtRelationWithHihokensha().setValue(new RString(relationWithHihokensha));

    }

    /*
     /住宅改修明細の初期値をセットします。
     */
    private void setZizenShinseiDetailInput(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        String kaishuContents = targetSource.get(3).get("kaishuContents").toString();
        String kaishuJigyoshaName = targetSource.get(3).get("kaishuJigyoshaName").toString();
        String kaishuTaishoAddress1 = targetSource.get(3).get("kaishuTaishoAddress1").toString();
        String chakkoDueDate = targetSource.get(3).get("chakkoDueDate").toString();
        String kanseiDueDate = targetSource.get(3).get("kanseiDueDate").toString();
        String estimatedAmount = targetSource.get(3).get("estimatedAmount").toString();
        /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuContents().setValue(new RString(kaishuContents));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().setValue(new RString(kaishuJigyoshaName));

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().setValue(new RString(kaishuTaishoAddress1));

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
    private void setSummary(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        //前回
        String payTotalMae = targetSource.get(4).get("payTotalMae").toString();
        String hokenSeikyuAmountMae = targetSource.get(4).get("hokenSeikyuAmountMae").toString();
        String riyoshaFutanAmountMae = targetSource.get(4).get("riyoshaFutanAmountMae").toString();
        String limitOverAmountMae = targetSource.get(4).get("limitOverAmountMae").toString();
        //今回
        String payTotalNow = targetSource.get(4).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = targetSource.get(4).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = targetSource.get(4).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = targetSource.get(4).get("limitOverAmountNow").toString();
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
    private void setShinseishaInfo(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        String shinseiYMD = targetSource.get(5).get("shinseiYMD").toString();
        String uketsukeYMD = targetSource.get(5).get("uketsukeYMD").toString();
        String shinseishaName = targetSource.get(5).get("shinseishaName").toString();
        String yubinNo = targetSource.get(5).get("yubinNo").toString();
        String address = targetSource.get(5).get("address").toString();
        String telNo = targetSource.get(5).get("telNo").toString();
        String jigyoshaNo = targetSource.get(5).get("jigyoshaNo").toString();
       /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuJizenShinseisha().getTxtShinseiDate().setValue(new RDate(shinseiYMD));
        panel.getJutakuKaishuJizenShinseisha().getTxtUketsukeDate().setValue(new RDate(uketsukeYMD));
        panel.getJutakuKaishuJizenShinseisha().getTxtShinseishaName().setValue(new RString(shinseishaName));
        panel.getJutakuKaishuJizenShinseisha().getTxtYubinNo().setValue(new YubinNo(yubinNo));
        panel.getJutakuKaishuJizenShinseisha().getTxtAddress().setValue(new RString(address));
        panel.getJutakuKaishuJizenShinseisha().getTxtTelNo().setValue(new RString(telNo));
        panel.getJutakuKaishuJizenShinseisha().getTxtJigyoshaNo().setValue(new RString(jigyoshaNo));

    }

    /*
     住宅改修理由書の初期値をセットします。
     */
    private void setShinseiReason(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        String createDate = targetSource.get(6).get("createDate").toString();
        String creationJigyoshaNo = targetSource.get(6).get("creationJigyoshaNo").toString();
        String creationJigyoshaName = targetSource.get(6).get("creationJigyoshaName").toString();
        String creatorKanaName = targetSource.get(6).get("creatorKanaName").toString();
        String creatorName = targetSource.get(6).get("creatorName").toString();
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
    private void setShinseiKozaInfo(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        String kinyuKikanCode = targetSource.get(7).get("kinyuKikanCode").toString();
        String kinyuKikanName = targetSource.get(7).get("kinyuKikanName").toString();
        String kinyuBranchCode = targetSource.get(7).get("kinyuBranchCode").toString();
        String kinyuBranchName = targetSource.get(7).get("kinyuBranchName").toString();
        String kozaMeigininKanaName = targetSource.get(7).get("kozaMeigininKanaName").toString();
        String kozaMeigininName = targetSource.get(7).get("kozaMeigininName").toString();
        /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        //初期値を設定したいものに値を入れる。値をセットしなければ空欄
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuKikanCode().setValue(new RString(kinyuKikanCode));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuKikanName().setValue(new RString(kinyuKikanName));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuKikanBrunchCode().setValue(new RString(kinyuBranchCode));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKinyuKikanBrunchName().setValue(new RString(kinyuBranchName));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKozaMeigininKana().setValue(new RString(kozaMeigininKanaName));
        panel.getJutakuKaishuJizenShinseiKozaInfo().getTxtKozaMeiginin().setValue(new RString(kozaMeigininName));

    }

    /**
     * 住宅改修費事前申請登録 明細を追加するボタンを押下後、住宅改修明細を表示する。
     *
     * @param shinseiPanel 申請panel
     * @param hihokenshaPanel 被保険者panel
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onClick_btnModifyDetail(
            JutakuKaishuJizenShinseiContentsPanelDiv shinseiPanel,
            JutakuKaishuJizenShinseiHihokenshaPanelDiv hihokenshaPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        //住宅改修明細
//        List<dgJutakuKaishuDetail_Row> arraydata = createRowShikyuShinseiTestData();
        shinseiPanel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getDgJutakuKaishuDetail().setDataSource(
                        getShikyuShinseiInputData(shinseiPanel.getJutakuKaishuZizenShinseiDetail()
                                .getJutakuKaishuJizenShinseiDetailInput().getJutakuKaishuDetailInput()));

        //今回設定
        setSummaryNowData(shinseiPanel);

        //クリア設定
        setJutakuKaishuJizenShinseiDetailInput(shinseiPanel);

        response.data = shinseiPanel;
        return response;

    }

    private List<dgJutakuKaishuDetail_Row> getShikyuShinseiInputData(JutakuKaishuDetailInputDiv div) {

        List<dgJutakuKaishuDetail_Row> list = new ArrayList<>();

        TextBoxDate chakkoDate = new TextBoxDate();
        chakkoDate.setValue(div.getTxtChakkoDueDate().getValue());

        TextBoxDate kanseiDate = new TextBoxDate();
        kanseiDate.setValue(div.getTxtKanseiDueDate().getValue());

        TextBoxNum amount = new TextBoxNum();
        amount.setValue(div.getTxtEstimatedAmount().getValue());

        dgJutakuKaishuDetail_Row row = new dgJutakuKaishuDetail_Row(
                chakkoDate,
                kanseiDate,
                amount,
                div.getTxtKaishuJigyoshaName().getValue(),
                div.getTxtKaishuTaishoAddress().getValue(),
                div.getTxtKaishuContents().getValue()
        );
        list.add(row);
        return list;
    }

    /*
     今回の支払状況の値を設定します。
     */
    private void setSummaryNowData(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        /////////////////////////////////////////////////////////////////////////////////////////
        //JutakuData.xml Read　②
        //今回
        String payTotalNow = targetSource.get(9).get("payTotalNow").toString();
        String hokenSeikyuAmountNow = targetSource.get(9).get("hokenSeikyuAmountNow").toString();
        String riyoshaFutanAmountNow = targetSource.get(9).get("riyoshaFutanAmountNow").toString();
        String limitOverAmountNow = targetSource.get(9).get("limitOverAmountNow").toString();
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
     クリア設定
     */
    private void setJutakuKaishuJizenShinseiDetailInput(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        //改修の内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuContents().clearValue();

        //事業者の内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().clearValue();
        //着・完成日内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().clearValue();
        //着・完成日内容をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtChakkoDueDate().clearValue();
        //見積額をクリア
        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKanseiDueDate().clearValue();

        panel.getJutakuKaishuZizenShinseiDetail().getJutakuKaishuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtEstimatedAmount().clearValue();

    }
}

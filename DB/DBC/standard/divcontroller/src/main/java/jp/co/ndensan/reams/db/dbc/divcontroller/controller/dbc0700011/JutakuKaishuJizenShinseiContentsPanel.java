package jp.co.ndensan.reams.db.dbc.divcontroller.controller.dbc0700011;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.PaymentMethod;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.JutakuKaishuDetailInputDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.JutakuKaishuShinseiDetailInput.dgJutakuKaishuDetail_Row;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiContentsPanelDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dbc0700011.JutakuKaishuJizenShinseiHihokenshaPanelDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShinseishaInfo;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ShinseishaInfo.ShinseishaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaShokaiSimpleDiv;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.RowState;
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
     * @param contentsPanel 住宅改修事前申請panel
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onLoad(
            JutakuKaishuJizenShinseiContentsPanelDiv contentsPanel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

//        //住宅所有者・被保険者との関係　
//        setJutakuOwnerData(contentsPanel);
//        //住宅改修明細 　　　　　　　　　
//        setZizenShinseiDetailInput(contentsPanel);
//        //申請者情報　初期化設定　　　　　　
//        setShinseishaInfo(contentsPanel);
//        //住宅改修理由書
//        setShinseiReason(contentsPanel);
//        //口座振替申請情報（UR)
//        setShinseiKozaInfo(contentsPanel);
        setDefaultData(contentsPanel, hihoPanel);

        response.data = contentsPanel;
        return response;
    }

    /**
     * 住宅改修費事前申請登録 明細を追加するボタンを押下後、住宅改修明細を表示する。
     *
     * @param contentsPanel 申請panel
     * @return ResponseData
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onClick_btnModifyDetail(
            JutakuKaishuJizenShinseiContentsPanelDiv contentsPanel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        //住宅改修明細
        contentsPanel.getJutakuJizenShinseiDetailInput().
                getDgJutakuKaishuDetail().setDataSource(
                        getShikyuShinseiInputData(contentsPanel
                                .getJutakuJizenShinseiDetailInput().getJutakuKaishuDetailInput()));

        contentsPanel.getJutakuJizenShinseiDetailInput().getDgJutakuKaishuDetail()
                .getDataSource().get(0).setRowState(RowState.Added);

        //クリア設定
        setJutakuKaishuJizenShinseiDetailInput(contentsPanel);

        response.data = contentsPanel;
        return response;

    }

    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onClick_copyToAddress(
            JutakuKaishuJizenShinseiContentsPanelDiv panel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        panel.getJutakuJizenShinseiDetailInput().getJutakuKaishuDetailInput()
                .getTxtKaishuTaishoAddress().setValue(
                        hihoPanel.getKaigoAtena().getAtenaInfo().getTxtJusho().getValue());

        response.data = panel;
        return response;
    }

    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onClick_btnClear(
            JutakuKaishuJizenShinseiContentsPanelDiv panel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        //クリア設定
        setJutakuKaishuJizenShinseiDetailInput(panel);

        response.data = panel;
        return response;
    }

    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onChange_ddlShinseishaKubun(
            JutakuKaishuJizenShinseiContentsPanelDiv panel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        String 申請者区分key = panel.getJutakuKaishuJizenShinseisha().getDdlShinseishaKubun().getSelectedItem().toString();

//        switch (申請者区分key) {
//            case "myself":
//                disableJigyosha(panel.getJutakuKaishuJizenShinseisha());
//                setHonninInfo(panel.getJutakuKaishuJizenShinseisha(), hihoPanel.getKaigoAtena().getAtenaInfo());
//                break;
//            case "family":
//            case "other":
//            case "blank":
//                clearToShinseishaInfo(panel.getJutakuKaishuJizenShinseisha());
//                disableJigyosha(panel.getJutakuKaishuJizenShinseisha());
//                break;
//            case "serviceJigyosha":
//                clearToShinseishaInfo(panel.getJutakuKaishuJizenShinseisha());
//                ableJigyosha(panel.getJutakuKaishuJizenShinseisha());
//                break;
//        }
        response.data = panel;
        return response;
    }

    /**
     * 支払い方法ラジオボタンにより表示内容を変更する。
     *
     * @param panel
     * @return response
     */
    public ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> onClick_radPayMethod(
            JutakuKaishuJizenShinseiContentsPanelDiv panel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        ResponseData<JutakuKaishuJizenShinseiContentsPanelDiv> response = new ResponseData<>();

        PaymentMethod.showSelectedPaymentMethod(panel.getJutakuKaishuJizenShinseiKoza());

        response.data = panel;
        return response;
    }

    private void clearToShinseishaInfo(ShinseishaInfoDiv div) {
        div.getTxtAddress().clearValue();
        div.getTxtJigyoshaNo().clearValue();
        div.getTxtShinseishaName().clearValue();
        div.getTxtShinseishaNameKana().clearValue();
        div.getTxtTelNo().clearValue();
        div.getTxtYubinNo().clearValue();
    }

//    private void disableJigyosha(ShinseishaInfoDiv div) {
//        div.getTxtJigyoshaNo().setDisabled(true);
//        div.getBtnJigyoshaInputGuide().setDisabled(true);
//        div.getTxtShinseishaNameKana().setLabelLText(new RString("氏名"));
//        div.getTxtShinseishaName().setReadOnly(false);
//        div.getTxtShinseishaNameKana().setReadOnly(false);
//    }

//    private void ableJigyosha(ShinseishaInfoDiv div) {
//        div.getTxtJigyoshaNo().setDisabled(false);
//        div.getBtnJigyoshaInputGuide().setDisabled(false);
//        div.getTxtShinseishaNameKana().setLabelLText(new RString("　　"));
//        div.getTxtShinseishaName().setReadOnly(true);
//        div.getTxtShinseishaNameKana().setReadOnly(true);
//    }

    private void setHonninInfo(ShinseishaInfoDiv shinseishaDiv, AtenaShokaiSimpleDiv atenaDiv) {
        shinseishaDiv.getTxtShinseishaNameKana().setValue(atenaDiv.getTxtAtenaKanaMeisho().getValue());
        shinseishaDiv.getTxtShinseishaName().setValue(atenaDiv.getTxtAtenaMeisho().getValue());
        shinseishaDiv.getTxtYubinNo().setValue(atenaDiv.getTxtYubinNo().getValue());
        shinseishaDiv.getTxtAddress().setValue(atenaDiv.getTxtJusho().getValue());
        shinseishaDiv.getTxtTelNo().setValue(new RString("0123456789"));
    }

    private void setDefaultData(JutakuKaishuJizenShinseiContentsPanelDiv panel, JutakuKaishuJizenShinseiHihokenshaPanelDiv hihoPanel) {
        panel.getJutakuKaishuJizenShinseisha().getTxtShinseiDate().setValue(new RDate("20140711"));

        panel.getJutakuKaishuJizenShinseiKoza().getRadPayMethod().setSelectedItem(new RString("payToKoza"));
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getRadKozaShubetsu().setSelectedItem(new RString("futsu"));

        setHonninInfo(panel.getJutakuKaishuJizenShinseisha(), hihoPanel.getKaigoAtena().getAtenaInfo());
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
        String kaishuTaishoAddress1 = targetSource.get(3).get("kaishuTaishoAddress").toString();
        String chakkoDueDate = targetSource.get(3).get("chakkoDueDate").toString();
        String kanseiDueDate = targetSource.get(3).get("kanseiDueDate").toString();
        String estimatedAmount = targetSource.get(3).get("estimatedAmount").toString();
        /////////////////////////////////////////////////////////////////////////////////////////

        //TO DO  JutakuData.xml Write　③
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuContents().setValue(new RString(kaishuContents));

        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().setValue(new RString(kaishuJigyoshaName));

        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().setValue(new RString(kaishuTaishoAddress1));
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtChakkoDueDate().setValue(new RDate(chakkoDueDate));

        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKanseiDueDate().setValue(new RDate(kanseiDueDate));

        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtEstimatedAmount().setValue(new Decimal(estimatedAmount));
    }

    /*
     申請者情報の初期値をセットします。
     */
    private void setShinseishaInfo(JutakuKaishuJizenShinseiContentsPanelDiv panel) {
        ShinseishaInfo.setData(panel.getJutakuKaishuJizenShinseisha(), 0);
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

        panel.getJutakuKaishuJizenShinseiKoza().getRadPayMethod().setSelectedItem(new RString("payToKoza"));

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
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getTxtKinyuKikanCode().setValue(new RString(kinyuKikanCode));
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getTxtKinyuKikanName().setValue(new RString(kinyuKikanName));
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getTxtKinyuKikanBrunchCode().setValue(new RString(kinyuBranchCode));
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getTxtKinyuKikanBrunchName().setValue(new RString(kinyuBranchName));
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getTxtKozaMeigininKana().setValue(new RString(kozaMeigininKanaName));
        panel.getJutakuKaishuJizenShinseiKoza().getKozaPayment().getTxtKozaMeiginin().setValue(new RString(kozaMeigininName));
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
     クリア設定
     */
    private void setJutakuKaishuJizenShinseiDetailInput(JutakuKaishuJizenShinseiContentsPanelDiv panel) {

        //改修の内容をクリア
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuContents().clearValue();

        //事業者の内容をクリア
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuJigyoshaName().clearValue();
        //着・完成日内容をクリア
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKaishuTaishoAddress().clearValue();
        //着・完成日内容をクリア
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtChakkoDueDate().clearValue();
        //見積額をクリア
        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtKanseiDueDate().clearValue();

        panel.getJutakuJizenShinseiDetailInput().
                getJutakuKaishuDetailInput().getTxtEstimatedAmount().clearValue();
    }
}

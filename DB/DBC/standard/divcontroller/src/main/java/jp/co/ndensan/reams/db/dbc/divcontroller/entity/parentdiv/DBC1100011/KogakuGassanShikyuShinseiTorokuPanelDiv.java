package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanShikyuShinseiTorokuPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("tabShinseiToroku")
    private tabShinseiTorokuDiv tabShinseiToroku;
    @JsonProperty("btnNaiyoKakutei")
    private Button btnNaiyoKakutei;
    @JsonProperty("btnShinseiJohoModoru")
    private Button btnShinseiJohoModoru;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * gettabShinseiToroku
     * @return tabShinseiToroku
     */
    @JsonProperty("tabShinseiToroku")
    public tabShinseiTorokuDiv getTabShinseiToroku() {
        return tabShinseiToroku;
    }

    /*
     * settabShinseiToroku
     * @param tabShinseiToroku tabShinseiToroku
     */
    @JsonProperty("tabShinseiToroku")
    public void setTabShinseiToroku(tabShinseiTorokuDiv tabShinseiToroku) {
        this.tabShinseiToroku = tabShinseiToroku;
    }

    /*
     * getbtnNaiyoKakutei
     * @return btnNaiyoKakutei
     */
    @JsonProperty("btnNaiyoKakutei")
    public Button getBtnNaiyoKakutei() {
        return btnNaiyoKakutei;
    }

    /*
     * setbtnNaiyoKakutei
     * @param btnNaiyoKakutei btnNaiyoKakutei
     */
    @JsonProperty("btnNaiyoKakutei")
    public void setBtnNaiyoKakutei(Button btnNaiyoKakutei) {
        this.btnNaiyoKakutei = btnNaiyoKakutei;
    }

    /*
     * getbtnShinseiJohoModoru
     * @return btnShinseiJohoModoru
     */
    @JsonProperty("btnShinseiJohoModoru")
    public Button getBtnShinseiJohoModoru() {
        return btnShinseiJohoModoru;
    }

    /*
     * setbtnShinseiJohoModoru
     * @param btnShinseiJohoModoru btnShinseiJohoModoru
     */
    @JsonProperty("btnShinseiJohoModoru")
    public void setBtnShinseiJohoModoru(Button btnShinseiJohoModoru) {
        this.btnShinseiJohoModoru = btnShinseiJohoModoru;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabShinseiTorokuPanel1Div getTabShinseiTorokuPanel1() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1);
    }

    @JsonIgnore
    public KaigoShikakuJohoPanelDiv getKaigoShikakuJohoPanel() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKaigoShikakuJohoPanel(KaigoShikakuJohoPanelDiv KaigoShikakuJohoPanel) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().setKaigoShikakuJohoPanel(KaigoShikakuJohoPanel);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoShikakuJoho() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getDdlKaigoShikakuJoho();
    }

    @JsonIgnore
    public void setDdlKaigoShikakuJoho(DropDownList ddlKaigoShikakuJoho) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setDdlKaigoShikakuJoho(ddlKaigoShikakuJoho);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikakuJoho1() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getTxtKaigoShikakuJoho1();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJoho1(TextBox txtKaigoShikakuJoho1) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setTxtKaigoShikakuJoho1(txtKaigoShikakuJoho1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKaigoShikakuJohoKanyuYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getTxtKaigoShikakuJohoKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJohoKanyuYMD(TextBoxDateRange txtKaigoShikakuJohoKanyuYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setTxtKaigoShikakuJohoKanyuYMD(txtKaigoShikakuJohoKanyuYMD);
    }

    @JsonIgnore
    public HihokenshaJohoPanelDiv getHihokenshaJohoPanel() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel();
    }

    @JsonIgnore
    public void setHihokenshaJohoPanel(HihokenshaJohoPanelDiv HihokenshaJohoPanel) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().setHihokenshaJohoPanel(HihokenshaJohoPanel);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho1() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho1();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho1(DropDownList ddlHihokenshaJoho1) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho1(ddlHihokenshaJoho1);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho2() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho2();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho2(DropDownList ddlHihokenshaJoho2) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho2(ddlHihokenshaJoho2);
    }

    @JsonIgnore
    public TextBoxDate getTxtHihokenshaJohoShikakuSoshitsuYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoShikakuSoshitsuYMD(TextBoxDate txtHihokenshaJohoShikakuSoshitsuYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoShikakuSoshitsuYMD(txtHihokenshaJohoShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho3() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho3();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho3(DropDownList ddlHihokenshaJoho3) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho3(ddlHihokenshaJoho3);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSikiYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSikiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSikiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSikiYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSikiYMD(txtHihokenshaJohoKeisanKikanSikiYMD);
    }

    @JsonIgnore
    public Label getLblHihokenshaJohoKeisanKikan() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getLblHihokenshaJohoKeisanKikan();
    }

    @JsonIgnore
    public void setLblHihokenshaJohoKeisanKikan(Label lblHihokenshaJohoKeisanKikan) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setLblHihokenshaJohoKeisanKikan(lblHihokenshaJohoKeisanKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSyukiYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSyukiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSyukiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSyukiYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSyukiYMD(txtHihokenshaJohoKeisanKikanSyukiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel2Div getTabShinseiTorokuPanel2() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2);
    }

    @JsonIgnore
    public KokuhoShikakuJohoPanelDiv getKokuhoShikakuJohoPanel() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanelDiv KokuhoShikakuJohoPanel) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHokensyaBango() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHokensyaBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHokensyaBango(TextBox txtKokuhoShikakuHokensyaBango) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHokensyaBango(txtKokuhoShikakuHokensyaBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoKigo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoKigo(TextBox txtKokuhoShikakuHikonensyaSyoKigo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoKigo(txtKokuhoShikakuHikonensyaSyoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoBango() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoBango(TextBox txtKokuhoShikakuHikonensyaSyoBango) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoBango(txtKokuhoShikakuHikonensyaSyoBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku1() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku1();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku1(TextBox txtKokuhoShikaku1) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku1(txtKokuhoShikaku1);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoShikaku2() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku2();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku2(DropDownList txtKokuhoShikaku2) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku2(txtKokuhoShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku3() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku3();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku3(TextBox txtKokuhoShikaku3) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku3(txtKokuhoShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoShikakuKanyuYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuKanyuYMD(TextBoxDateRange txtKokuhoShikakuKanyuYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuKanyuYMD(txtKokuhoShikakuKanyuYMD);
    }

    @JsonIgnore
    public KokiShikakuJohoPanelDiv getKokiShikakuJohoPanel() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKokiShikakuJohoPanel(KokiShikakuJohoPanelDiv KokiShikakuJohoPanel) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokiShikakuJohoPanel(KokiShikakuJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku();
    }

    @JsonIgnore
    public void setTxtKokiShikaku(TextBox txtKokiShikaku) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku(txtKokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku2() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku2();
    }

    @JsonIgnore
    public void setTxtKokiShikaku2(TextBox txtKokiShikaku2) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku2(txtKokiShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku3() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku3();
    }

    @JsonIgnore
    public void setTxtKokiShikaku3(TextBox txtKokiShikaku3) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku3(txtKokiShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiShikakuKanyuKikan() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikakuKanyuKikan();
    }

    @JsonIgnore
    public void setTxtKokiShikakuKanyuKikan(TextBoxDateRange txtKokiShikakuKanyuKikan) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikakuKanyuKikan(txtKokiShikakuKanyuKikan);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel3Div getTabShinseiTorokuPanel3() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel3();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public tabShinseiTorokuPanel4Div getTabShinseiTorokuPanel4() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4);
    }

    @JsonIgnore
    public TorokuKanyRirekiuListPanelDiv getTorokuKanyRirekiuListPanel() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel();
    }

    @JsonIgnore
    public void setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanelDiv TorokuKanyRirekiuListPanel) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanel);
    }

    @JsonIgnore
    public Button getBtnKanyuJohoTsuika() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().getBtnKanyuJohoTsuika();
    }

    @JsonIgnore
    public void setBtnKanyuJohoTsuika(Button btnKanyuJohoTsuika) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().setBtnKanyuJohoTsuika(btnKanyuJohoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgTorokuKanyRirekiuList_Row> getDgTorokuKanyRirekiuList() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().getDgTorokuKanyRirekiuList();
    }

    @JsonIgnore
    public void setDgTorokuKanyRirekiuList(DataGrid<dgTorokuKanyRirekiuList_Row> dgTorokuKanyRirekiuList) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().setDgTorokuKanyRirekiuList(dgTorokuKanyRirekiuList);
    }

    @JsonIgnore
    public KanyuInfoPanelDiv getKanyuInfoPanel() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel();
    }

    @JsonIgnore
    public void setKanyuInfoPanel(KanyuInfoPanelDiv KanyuInfoPanel) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().setKanyuInfoPanel(KanyuInfoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKanyuInfoHokensyaMei() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtKanyuInfoHokensyaMei();
    }

    @JsonIgnore
    public void setTxtKanyuInfoHokensyaMei(TextBox txtKanyuInfoHokensyaMei) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtKanyuInfoHokensyaMei(txtKanyuInfoHokensyaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuInfoKanyuKikanYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtKanyuInfoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuInfoKanyuKikanYMD(TextBoxDateRange txtKanyuInfoKanyuKikanYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtKanyuInfoKanyuKikanYMD(txtKanyuInfoKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekKakutei() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getBtnKanyuRirekKakutei();
    }

    @JsonIgnore
    public void setBtnKanyuRirekKakutei(Button btnKanyuRirekKakutei) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setBtnKanyuRirekKakutei(btnKanyuRirekKakutei);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekiModoru() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getBtnKanyuRirekiModoru();
    }

    @JsonIgnore
    public void setBtnKanyuRirekiModoru(Button btnKanyuRirekiModoru) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setBtnKanyuRirekiModoru(btnKanyuRirekiModoru);
    }

    // </editor-fold>
}

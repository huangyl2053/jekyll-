package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShinseiToroku のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShinseiTorokuPanel1")
    private tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1;
    @JsonProperty("tabShinseiTorokuPanel2")
    private tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2;
    @JsonProperty("tabShinseiTorokuPanel3")
    private tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3;
    @JsonProperty("tabShinseiTorokuPanel4")
    private tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShinseiTorokuPanel1
     * @return tabShinseiTorokuPanel1
     */
    @JsonProperty("tabShinseiTorokuPanel1")
    public tabShinseiTorokuPanel1Div getTabShinseiTorokuPanel1() {
        return tabShinseiTorokuPanel1;
    }

    /*
     * settabShinseiTorokuPanel1
     * @param tabShinseiTorokuPanel1 tabShinseiTorokuPanel1
     */
    @JsonProperty("tabShinseiTorokuPanel1")
    public void setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1) {
        this.tabShinseiTorokuPanel1 = tabShinseiTorokuPanel1;
    }

    /*
     * gettabShinseiTorokuPanel2
     * @return tabShinseiTorokuPanel2
     */
    @JsonProperty("tabShinseiTorokuPanel2")
    public tabShinseiTorokuPanel2Div getTabShinseiTorokuPanel2() {
        return tabShinseiTorokuPanel2;
    }

    /*
     * settabShinseiTorokuPanel2
     * @param tabShinseiTorokuPanel2 tabShinseiTorokuPanel2
     */
    @JsonProperty("tabShinseiTorokuPanel2")
    public void setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2) {
        this.tabShinseiTorokuPanel2 = tabShinseiTorokuPanel2;
    }

    /*
     * gettabShinseiTorokuPanel3
     * @return tabShinseiTorokuPanel3
     */
    @JsonProperty("tabShinseiTorokuPanel3")
    public tabShinseiTorokuPanel3Div getTabShinseiTorokuPanel3() {
        return tabShinseiTorokuPanel3;
    }

    /*
     * settabShinseiTorokuPanel3
     * @param tabShinseiTorokuPanel3 tabShinseiTorokuPanel3
     */
    @JsonProperty("tabShinseiTorokuPanel3")
    public void setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3) {
        this.tabShinseiTorokuPanel3 = tabShinseiTorokuPanel3;
    }

    /*
     * gettabShinseiTorokuPanel4
     * @return tabShinseiTorokuPanel4
     */
    @JsonProperty("tabShinseiTorokuPanel4")
    public tabShinseiTorokuPanel4Div getTabShinseiTorokuPanel4() {
        return tabShinseiTorokuPanel4;
    }

    /*
     * settabShinseiTorokuPanel4
     * @param tabShinseiTorokuPanel4 tabShinseiTorokuPanel4
     */
    @JsonProperty("tabShinseiTorokuPanel4")
    public void setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4) {
        this.tabShinseiTorokuPanel4 = tabShinseiTorokuPanel4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KaigoShikakuJohoPanelDiv getKaigoShikakuJohoPanel() {
        return this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKaigoShikakuJohoPanel(KaigoShikakuJohoPanelDiv KaigoShikakuJohoPanel) {
        this.getTabShinseiTorokuPanel1().setKaigoShikakuJohoPanel(KaigoShikakuJohoPanel);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoShikakuJoho() {
        return this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getDdlKaigoShikakuJoho();
    }

    @JsonIgnore
    public void setDdlKaigoShikakuJoho(DropDownList ddlKaigoShikakuJoho) {
        this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setDdlKaigoShikakuJoho(ddlKaigoShikakuJoho);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikakuJoho1() {
        return this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getTxtKaigoShikakuJoho1();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJoho1(TextBox txtKaigoShikakuJoho1) {
        this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setTxtKaigoShikakuJoho1(txtKaigoShikakuJoho1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKaigoShikakuJohoKanyuYMD() {
        return this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getTxtKaigoShikakuJohoKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJohoKanyuYMD(TextBoxDateRange txtKaigoShikakuJohoKanyuYMD) {
        this.getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setTxtKaigoShikakuJohoKanyuYMD(txtKaigoShikakuJohoKanyuYMD);
    }

    @JsonIgnore
    public HihokenshaJohoPanelDiv getHihokenshaJohoPanel() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel();
    }

    @JsonIgnore
    public void setHihokenshaJohoPanel(HihokenshaJohoPanelDiv HihokenshaJohoPanel) {
        this.getTabShinseiTorokuPanel1().setHihokenshaJohoPanel(HihokenshaJohoPanel);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho1() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho1();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho1(DropDownList ddlHihokenshaJoho1) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho1(ddlHihokenshaJoho1);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho2() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho2();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho2(DropDownList ddlHihokenshaJoho2) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho2(ddlHihokenshaJoho2);
    }

    @JsonIgnore
    public TextBoxDate getTxtHihokenshaJohoShikakuSoshitsuYMD() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoShikakuSoshitsuYMD(TextBoxDate txtHihokenshaJohoShikakuSoshitsuYMD) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoShikakuSoshitsuYMD(txtHihokenshaJohoShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho3() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho3();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho3(DropDownList ddlHihokenshaJoho3) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho3(ddlHihokenshaJoho3);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSikiYMD() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSikiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSikiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSikiYMD) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSikiYMD(txtHihokenshaJohoKeisanKikanSikiYMD);
    }

    @JsonIgnore
    public Label getLblHihokenshaJohoKeisanKikan() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getLblHihokenshaJohoKeisanKikan();
    }

    @JsonIgnore
    public void setLblHihokenshaJohoKeisanKikan(Label lblHihokenshaJohoKeisanKikan) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setLblHihokenshaJohoKeisanKikan(lblHihokenshaJohoKeisanKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSyukiYMD() {
        return this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSyukiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSyukiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSyukiYMD) {
        this.getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSyukiYMD(txtHihokenshaJohoKeisanKikanSyukiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabShinseiTorokuPanel1().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabShinseiTorokuPanel1().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public KokuhoShikakuJohoPanelDiv getKokuhoShikakuJohoPanel() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanelDiv KokuhoShikakuJohoPanel) {
        this.getTabShinseiTorokuPanel2().setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHokensyaBango() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHokensyaBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHokensyaBango(TextBox txtKokuhoShikakuHokensyaBango) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHokensyaBango(txtKokuhoShikakuHokensyaBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoKigo() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoKigo(TextBox txtKokuhoShikakuHikonensyaSyoKigo) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoKigo(txtKokuhoShikakuHikonensyaSyoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoBango() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoBango(TextBox txtKokuhoShikakuHikonensyaSyoBango) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoBango(txtKokuhoShikakuHikonensyaSyoBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku1() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku1();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku1(TextBox txtKokuhoShikaku1) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku1(txtKokuhoShikaku1);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoShikaku2() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku2();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku2(DropDownList txtKokuhoShikaku2) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku2(txtKokuhoShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku3() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku3();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku3(TextBox txtKokuhoShikaku3) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku3(txtKokuhoShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoShikakuKanyuYMD() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuKanyuYMD(TextBoxDateRange txtKokuhoShikakuKanyuYMD) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuKanyuYMD(txtKokuhoShikakuKanyuYMD);
    }

    @JsonIgnore
    public KokiShikakuJohoPanelDiv getKokiShikakuJohoPanel() {
        return this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKokiShikakuJohoPanel(KokiShikakuJohoPanelDiv KokiShikakuJohoPanel) {
        this.getTabShinseiTorokuPanel2().setKokiShikakuJohoPanel(KokiShikakuJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku() {
        return this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku();
    }

    @JsonIgnore
    public void setTxtKokiShikaku(TextBox txtKokiShikaku) {
        this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku(txtKokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku2() {
        return this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku2();
    }

    @JsonIgnore
    public void setTxtKokiShikaku2(TextBox txtKokiShikaku2) {
        this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku2(txtKokiShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku3() {
        return this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku3();
    }

    @JsonIgnore
    public void setTxtKokiShikaku3(TextBox txtKokiShikaku3) {
        this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku3(txtKokiShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiShikakuKanyuKikan() {
        return this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikakuKanyuKikan();
    }

    @JsonIgnore
    public void setTxtKokiShikakuKanyuKikan(TextBoxDateRange txtKokiShikakuKanyuKikan) {
        this.getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikakuKanyuKikan(txtKokiShikakuKanyuKikan);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public TorokuKanyRirekiuListPanelDiv getTorokuKanyRirekiuListPanel() {
        return this.getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel();
    }

    @JsonIgnore
    public void setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanelDiv TorokuKanyRirekiuListPanel) {
        this.getTabShinseiTorokuPanel4().setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanel);
    }

    @JsonIgnore
    public Button getBtnKanyuJohoTsuika() {
        return this.getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().getBtnKanyuJohoTsuika();
    }

    @JsonIgnore
    public void setBtnKanyuJohoTsuika(Button btnKanyuJohoTsuika) {
        this.getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().setBtnKanyuJohoTsuika(btnKanyuJohoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgTorokuKanyRirekiuList_Row> getDgTorokuKanyRirekiuList() {
        return this.getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().getDgTorokuKanyRirekiuList();
    }

    @JsonIgnore
    public void setDgTorokuKanyRirekiuList(DataGrid<dgTorokuKanyRirekiuList_Row> dgTorokuKanyRirekiuList) {
        this.getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().setDgTorokuKanyRirekiuList(dgTorokuKanyRirekiuList);
    }

    @JsonIgnore
    public KanyuInfoPanelDiv getKanyuInfoPanel() {
        return this.getTabShinseiTorokuPanel4().getKanyuInfoPanel();
    }

    @JsonIgnore
    public void setKanyuInfoPanel(KanyuInfoPanelDiv KanyuInfoPanel) {
        this.getTabShinseiTorokuPanel4().setKanyuInfoPanel(KanyuInfoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKanyuInfoHokensyaMei() {
        return this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtKanyuInfoHokensyaMei();
    }

    @JsonIgnore
    public void setTxtKanyuInfoHokensyaMei(TextBox txtKanyuInfoHokensyaMei) {
        this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtKanyuInfoHokensyaMei(txtKanyuInfoHokensyaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuInfoKanyuKikanYMD() {
        return this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtKanyuInfoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuInfoKanyuKikanYMD(TextBoxDateRange txtKanyuInfoKanyuKikanYMD) {
        this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtKanyuInfoKanyuKikanYMD(txtKanyuInfoKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekKakutei() {
        return this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().getBtnKanyuRirekKakutei();
    }

    @JsonIgnore
    public void setBtnKanyuRirekKakutei(Button btnKanyuRirekKakutei) {
        this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().setBtnKanyuRirekKakutei(btnKanyuRirekKakutei);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekiModoru() {
        return this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().getBtnKanyuRirekiModoru();
    }

    @JsonIgnore
    public void setBtnKanyuRirekiModoru(Button btnKanyuRirekiModoru) {
        this.getTabShinseiTorokuPanel4().getKanyuInfoPanel().setBtnKanyuRirekiModoru(btnKanyuRirekiModoru);
    }

    // </editor-fold>
}

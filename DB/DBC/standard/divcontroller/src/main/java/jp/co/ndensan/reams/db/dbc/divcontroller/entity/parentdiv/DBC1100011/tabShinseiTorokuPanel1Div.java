package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * tabShinseiTorokuPanel1 のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuPanel1Div extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoShikakuJohoPanel")
    private KaigoShikakuJohoPanelDiv KaigoShikakuJohoPanel;
    @JsonProperty("HihokenshaJohoPanel")
    private HihokenshaJohoPanelDiv HihokenshaJohoPanel;
    @JsonProperty("txtBiko")
    private TextBoxMultiLine txtBiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoShikakuJohoPanel
     * @return KaigoShikakuJohoPanel
     */
    @JsonProperty("KaigoShikakuJohoPanel")
    public KaigoShikakuJohoPanelDiv getKaigoShikakuJohoPanel() {
        return KaigoShikakuJohoPanel;
    }

    /*
     * setKaigoShikakuJohoPanel
     * @param KaigoShikakuJohoPanel KaigoShikakuJohoPanel
     */
    @JsonProperty("KaigoShikakuJohoPanel")
    public void setKaigoShikakuJohoPanel(KaigoShikakuJohoPanelDiv KaigoShikakuJohoPanel) {
        this.KaigoShikakuJohoPanel = KaigoShikakuJohoPanel;
    }

    /*
     * getHihokenshaJohoPanel
     * @return HihokenshaJohoPanel
     */
    @JsonProperty("HihokenshaJohoPanel")
    public HihokenshaJohoPanelDiv getHihokenshaJohoPanel() {
        return HihokenshaJohoPanel;
    }

    /*
     * setHihokenshaJohoPanel
     * @param HihokenshaJohoPanel HihokenshaJohoPanel
     */
    @JsonProperty("HihokenshaJohoPanel")
    public void setHihokenshaJohoPanel(HihokenshaJohoPanelDiv HihokenshaJohoPanel) {
        this.HihokenshaJohoPanel = HihokenshaJohoPanel;
    }

    /*
     * gettxtBiko
     * @return txtBiko
     */
    @JsonProperty("txtBiko")
    public TextBoxMultiLine getTxtBiko() {
        return txtBiko;
    }

    /*
     * settxtBiko
     * @param txtBiko txtBiko
     */
    @JsonProperty("txtBiko")
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.txtBiko = txtBiko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlKaigoShikakuJoho() {
        return this.getKaigoShikakuJohoPanel().getDdlKaigoShikakuJoho();
    }

    @JsonIgnore
    public void setDdlKaigoShikakuJoho(DropDownList ddlKaigoShikakuJoho) {
        this.getKaigoShikakuJohoPanel().setDdlKaigoShikakuJoho(ddlKaigoShikakuJoho);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikakuJoho1() {
        return this.getKaigoShikakuJohoPanel().getTxtKaigoShikakuJoho1();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJoho1(TextBox txtKaigoShikakuJoho1) {
        this.getKaigoShikakuJohoPanel().setTxtKaigoShikakuJoho1(txtKaigoShikakuJoho1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKaigoShikakuJohoKanyuYMD() {
        return this.getKaigoShikakuJohoPanel().getTxtKaigoShikakuJohoKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJohoKanyuYMD(TextBoxDateRange txtKaigoShikakuJohoKanyuYMD) {
        this.getKaigoShikakuJohoPanel().setTxtKaigoShikakuJohoKanyuYMD(txtKaigoShikakuJohoKanyuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho1() {
        return this.getHihokenshaJohoPanel().getDdlHihokenshaJoho1();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho1(DropDownList ddlHihokenshaJoho1) {
        this.getHihokenshaJohoPanel().setDdlHihokenshaJoho1(ddlHihokenshaJoho1);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho2() {
        return this.getHihokenshaJohoPanel().getDdlHihokenshaJoho2();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho2(DropDownList ddlHihokenshaJoho2) {
        this.getHihokenshaJohoPanel().setDdlHihokenshaJoho2(ddlHihokenshaJoho2);
    }

    @JsonIgnore
    public TextBoxDate getTxtHihokenshaJohoShikakuSoshitsuYMD() {
        return this.getHihokenshaJohoPanel().getTxtHihokenshaJohoShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoShikakuSoshitsuYMD(TextBoxDate txtHihokenshaJohoShikakuSoshitsuYMD) {
        this.getHihokenshaJohoPanel().setTxtHihokenshaJohoShikakuSoshitsuYMD(txtHihokenshaJohoShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho3() {
        return this.getHihokenshaJohoPanel().getDdlHihokenshaJoho3();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho3(DropDownList ddlHihokenshaJoho3) {
        this.getHihokenshaJohoPanel().setDdlHihokenshaJoho3(ddlHihokenshaJoho3);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSikiYMD() {
        return this.getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSikiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSikiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSikiYMD) {
        this.getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSikiYMD(txtHihokenshaJohoKeisanKikanSikiYMD);
    }

    @JsonIgnore
    public Label getLblHihokenshaJohoKeisanKikan() {
        return this.getHihokenshaJohoPanel().getLblHihokenshaJohoKeisanKikan();
    }

    @JsonIgnore
    public void setLblHihokenshaJohoKeisanKikan(Label lblHihokenshaJohoKeisanKikan) {
        this.getHihokenshaJohoPanel().setLblHihokenshaJohoKeisanKikan(lblHihokenshaJohoKeisanKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSyukiYMD() {
        return this.getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSyukiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSyukiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSyukiYMD) {
        this.getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSyukiYMD(txtHihokenshaJohoKeisanKikanSyukiYMD);
    }

    // </editor-fold>
}

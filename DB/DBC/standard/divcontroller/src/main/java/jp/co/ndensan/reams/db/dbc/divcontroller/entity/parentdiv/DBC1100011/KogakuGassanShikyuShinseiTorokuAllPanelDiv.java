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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KogakuGassanShikyuShinseiTorokuAllPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuAllPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuNewPanel")
    private KogakuGassanShikyuShinseiTorokuNewPanelDiv KogakuGassanShikyuShinseiTorokuNewPanel;
    @JsonProperty("KogakuGassanShikyuShinseiTorokuPanel")
    private KogakuGassanShikyuShinseiTorokuPanelDiv KogakuGassanShikyuShinseiTorokuPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuGassanShikyuShinseiTorokuNewPanel
     * @return KogakuGassanShikyuShinseiTorokuNewPanel
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuNewPanel")
    public KogakuGassanShikyuShinseiTorokuNewPanelDiv getKogakuGassanShikyuShinseiTorokuNewPanel() {
        return KogakuGassanShikyuShinseiTorokuNewPanel;
    }

    /*
     * setKogakuGassanShikyuShinseiTorokuNewPanel
     * @param KogakuGassanShikyuShinseiTorokuNewPanel KogakuGassanShikyuShinseiTorokuNewPanel
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuNewPanel")
    public void setKogakuGassanShikyuShinseiTorokuNewPanel(KogakuGassanShikyuShinseiTorokuNewPanelDiv KogakuGassanShikyuShinseiTorokuNewPanel) {
        this.KogakuGassanShikyuShinseiTorokuNewPanel = KogakuGassanShikyuShinseiTorokuNewPanel;
    }

    /*
     * getKogakuGassanShikyuShinseiTorokuPanel
     * @return KogakuGassanShikyuShinseiTorokuPanel
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuPanel")
    public KogakuGassanShikyuShinseiTorokuPanelDiv getKogakuGassanShikyuShinseiTorokuPanel() {
        return KogakuGassanShikyuShinseiTorokuPanel;
    }

    /*
     * setKogakuGassanShikyuShinseiTorokuPanel
     * @param KogakuGassanShikyuShinseiTorokuPanel KogakuGassanShikyuShinseiTorokuPanel
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuPanel")
    public void setKogakuGassanShikyuShinseiTorokuPanel(KogakuGassanShikyuShinseiTorokuPanelDiv KogakuGassanShikyuShinseiTorokuPanel) {
        this.KogakuGassanShikyuShinseiTorokuPanel = KogakuGassanShikyuShinseiTorokuPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlTeishutsuHokenshaBango() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDdlTeishutsuHokenshaBango();
    }

    @JsonIgnore
    public void setDdlTeishutsuHokenshaBango(DropDownList ddlTeishutsuHokenshaBango) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setDdlTeishutsuHokenshaBango(ddlTeishutsuHokenshaBango);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango1() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtKaigoShikyuShinseishoSeiriBango1();
    }

    @JsonIgnore
    public void setTxtKaigoShikyuShinseishoSeiriBango1(TextBox txtKaigoShikyuShinseishoSeiriBango1) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtKaigoShikyuShinseishoSeiriBango1(txtKaigoShikyuShinseishoSeiriBango1);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango2() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtKaigoShikyuShinseishoSeiriBango2();
    }

    @JsonIgnore
    public void setTxtKaigoShikyuShinseishoSeiriBango2(TextBox txtKaigoShikyuShinseishoSeiriBango2) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtKaigoShikyuShinseishoSeiriBango2(txtKaigoShikyuShinseishoSeiriBango2);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango3() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtKaigoShikyuShinseishoSeiriBango3();
    }

    @JsonIgnore
    public void setTxtKaigoShikyuShinseishoSeiriBango3(TextBox txtKaigoShikyuShinseishoSeiriBango3) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtKaigoShikyuShinseishoSeiriBango3(txtKaigoShikyuShinseishoSeiriBango3);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango4() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtKaigoShikyuShinseishoSeiriBango4();
    }

    @JsonIgnore
    public void setTxtKaigoShikyuShinseishoSeiriBango4(TextBox txtKaigoShikyuShinseishoSeiriBango4) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtKaigoShikyuShinseishoSeiriBango4(txtKaigoShikyuShinseishoSeiriBango4);
    }

    @JsonIgnore
    public TextBoxNum getTxtRirekiBango() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtRirekiBango();
    }

    @JsonIgnore
    public void setTxtRirekiBango(TextBoxNum txtRirekiBango) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtRirekiBango(txtRirekiBango);
    }

    @JsonIgnore
    public DropDownList getDdlShinseiTaisyoNendo() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDdlShinseiTaisyoNendo();
    }

    @JsonIgnore
    public void setDdlShinseiTaisyoNendo(DropDownList ddlShinseiTaisyoNendo) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setDdlShinseiTaisyoNendo(ddlShinseiTaisyoNendo);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango1() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtIryoShikyuShinseishoSeiriBango1();
    }

    @JsonIgnore
    public void setTxtIryoShikyuShinseishoSeiriBango1(TextBox txtIryoShikyuShinseishoSeiriBango1) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtIryoShikyuShinseishoSeiriBango1(txtIryoShikyuShinseishoSeiriBango1);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango2() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtIryoShikyuShinseishoSeiriBango2();
    }

    @JsonIgnore
    public void setTxtIryoShikyuShinseishoSeiriBango2(TextBox txtIryoShikyuShinseishoSeiriBango2) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtIryoShikyuShinseishoSeiriBango2(txtIryoShikyuShinseishoSeiriBango2);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango3() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtIryoShikyuShinseishoSeiriBango3();
    }

    @JsonIgnore
    public void setTxtIryoShikyuShinseishoSeiriBango3(TextBox txtIryoShikyuShinseishoSeiriBango3) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtIryoShikyuShinseishoSeiriBango3(txtIryoShikyuShinseishoSeiriBango3);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango4() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtIryoShikyuShinseishoSeiriBango4();
    }

    @JsonIgnore
    public void setTxtIryoShikyuShinseishoSeiriBango4(TextBox txtIryoShikyuShinseishoSeiriBango4) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtIryoShikyuShinseishoSeiriBango4(txtIryoShikyuShinseishoSeiriBango4);
    }

    @JsonIgnore
    public TextBox getTxtShikyuShinseiKubun() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtShikyuShinseiKubun();
    }

    @JsonIgnore
    public void setTxtShikyuShinseiKubun(TextBox txtShikyuShinseiKubun) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtShikyuShinseiKubun(txtShikyuShinseiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlShikyuShinseiKeitai() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDdlShikyuShinseiKeitai();
    }

    @JsonIgnore
    public void setDdlShikyuShinseiKeitai(DropDownList ddlShikyuShinseiKeitai) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setDdlShikyuShinseiKeitai(ddlShikyuShinseiKeitai);
    }

    @JsonIgnore
    public DaihyoshaPanelDiv getDaihyoshaPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel();
    }

    @JsonIgnore
    public void setDaihyoshaPanel(DaihyoshaPanelDiv DaihyoshaPanel) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setDaihyoshaPanel(DaihyoshaPanel);
    }

    @JsonIgnore
    public TextBox getTxtDaihyoshaShimei() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().getTxtDaihyoshaShimei();
    }

    @JsonIgnore
    public void setTxtDaihyoshaShimei(TextBox txtDaihyoshaShimei) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().setTxtDaihyoshaShimei(txtDaihyoshaShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDaihyoshaTelNo() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().getTxtDaihyoshaTelNo();
    }

    @JsonIgnore
    public void setTxtDaihyoshaTelNo(TextBoxTelNo txtDaihyoshaTelNo) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().setTxtDaihyoshaTelNo(txtDaihyoshaTelNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtDaihyoshaYubinNo() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().getTxtDaihyoshaYubinNo();
    }

    @JsonIgnore
    public void setTxtDaihyoshaYubinNo(TextBoxYubinNo txtDaihyoshaYubinNo) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().setTxtDaihyoshaYubinNo(txtDaihyoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtDaihyoshaJusyo() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().getTxtDaihyoshaJusyo();
    }

    @JsonIgnore
    public void setTxtDaihyoshaJusyo(TextBox txtDaihyoshaJusyo) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDaihyoshaPanel().setTxtDaihyoshaJusyo(txtDaihyoshaJusyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkKofuShinseiUmu() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getChkKofuShinseiUmu();
    }

    @JsonIgnore
    public void setChkKofuShinseiUmu(CheckBoxList chkKofuShinseiUmu) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setChkKofuShinseiUmu(chkKofuShinseiUmu);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setLin1(lin1);
    }

    @JsonIgnore
    public Button getBtnShinseiJohoTsuika() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getBtnShinseiJohoTsuika();
    }

    @JsonIgnore
    public void setBtnShinseiJohoTsuika(Button btnShinseiJohoTsuika) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setBtnShinseiJohoTsuika(btnShinseiJohoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return this.getKogakuGassanShikyuShinseiTorokuNewPanel().getDgShinseiJoho();
    }

    @JsonIgnore
    public void setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.getKogakuGassanShikyuShinseiTorokuNewPanel().setDgShinseiJoho(dgShinseiJoho);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().setLin2(lin2);
    }

    @JsonIgnore
    public tabShinseiTorokuDiv getTabShinseiToroku() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku();
    }

    @JsonIgnore
    public void setTabShinseiToroku(tabShinseiTorokuDiv tabShinseiToroku) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().setTabShinseiToroku(tabShinseiToroku);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel1Div getTabShinseiTorokuPanel1() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1);
    }

    @JsonIgnore
    public KaigoShikakuJohoPanelDiv getKaigoShikakuJohoPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKaigoShikakuJohoPanel(KaigoShikakuJohoPanelDiv KaigoShikakuJohoPanel) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().setKaigoShikakuJohoPanel(KaigoShikakuJohoPanel);
    }

    @JsonIgnore
    public DropDownList getDdlKaigoShikakuJoho() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getDdlKaigoShikakuJoho();
    }

    @JsonIgnore
    public void setDdlKaigoShikakuJoho(DropDownList ddlKaigoShikakuJoho) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setDdlKaigoShikakuJoho(ddlKaigoShikakuJoho);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikakuJoho1() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getTxtKaigoShikakuJoho1();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJoho1(TextBox txtKaigoShikakuJoho1) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setTxtKaigoShikakuJoho1(txtKaigoShikakuJoho1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKaigoShikakuJohoKanyuYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().getTxtKaigoShikakuJohoKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKaigoShikakuJohoKanyuYMD(TextBoxDateRange txtKaigoShikakuJohoKanyuYMD) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikakuJohoPanel().setTxtKaigoShikakuJohoKanyuYMD(txtKaigoShikakuJohoKanyuYMD);
    }

    @JsonIgnore
    public HihokenshaJohoPanelDiv getHihokenshaJohoPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel();
    }

    @JsonIgnore
    public void setHihokenshaJohoPanel(HihokenshaJohoPanelDiv HihokenshaJohoPanel) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().setHihokenshaJohoPanel(HihokenshaJohoPanel);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho1() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho1();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho1(DropDownList ddlHihokenshaJoho1) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho1(ddlHihokenshaJoho1);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho2() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho2();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho2(DropDownList ddlHihokenshaJoho2) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho2(ddlHihokenshaJoho2);
    }

    @JsonIgnore
    public TextBoxDate getTxtHihokenshaJohoShikakuSoshitsuYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoShikakuSoshitsuYMD(TextBoxDate txtHihokenshaJohoShikakuSoshitsuYMD) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoShikakuSoshitsuYMD(txtHihokenshaJohoShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaJoho3() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getDdlHihokenshaJoho3();
    }

    @JsonIgnore
    public void setDdlHihokenshaJoho3(DropDownList ddlHihokenshaJoho3) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setDdlHihokenshaJoho3(ddlHihokenshaJoho3);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSikiYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSikiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSikiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSikiYMD) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSikiYMD(txtHihokenshaJohoKeisanKikanSikiYMD);
    }

    @JsonIgnore
    public Label getLblHihokenshaJohoKeisanKikan() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getLblHihokenshaJohoKeisanKikan();
    }

    @JsonIgnore
    public void setLblHihokenshaJohoKeisanKikan(Label lblHihokenshaJohoKeisanKikan) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setLblHihokenshaJohoKeisanKikan(lblHihokenshaJohoKeisanKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHihokenshaJohoKeisanKikanSyukiYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().getTxtHihokenshaJohoKeisanKikanSyukiYMD();
    }

    @JsonIgnore
    public void setTxtHihokenshaJohoKeisanKikanSyukiYMD(TextBoxFlexibleDate txtHihokenshaJohoKeisanKikanSyukiYMD) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getHihokenshaJohoPanel().setTxtHihokenshaJohoKeisanKikanSyukiYMD(txtHihokenshaJohoKeisanKikanSyukiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel1().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel2Div getTabShinseiTorokuPanel2() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2);
    }

    @JsonIgnore
    public KokuhoShikakuJohoPanelDiv getKokuhoShikakuJohoPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanelDiv KokuhoShikakuJohoPanel) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokuhoShikakuJohoPanel(KokuhoShikakuJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHokensyaBango() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHokensyaBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHokensyaBango(TextBox txtKokuhoShikakuHokensyaBango) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHokensyaBango(txtKokuhoShikakuHokensyaBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoKigo() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoKigo(TextBox txtKokuhoShikakuHikonensyaSyoKigo) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoKigo(txtKokuhoShikakuHikonensyaSyoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikakuHikonensyaSyoBango() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuHikonensyaSyoBango();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuHikonensyaSyoBango(TextBox txtKokuhoShikakuHikonensyaSyoBango) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuHikonensyaSyoBango(txtKokuhoShikakuHikonensyaSyoBango);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku1() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku1();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku1(TextBox txtKokuhoShikaku1) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku1(txtKokuhoShikaku1);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoShikaku2() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku2();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku2(DropDownList txtKokuhoShikaku2) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku2(txtKokuhoShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoShikaku3() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikaku3();
    }

    @JsonIgnore
    public void setTxtKokuhoShikaku3(TextBox txtKokuhoShikaku3) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikaku3(txtKokuhoShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoShikakuKanyuYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().getTxtKokuhoShikakuKanyuYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoShikakuKanyuYMD(TextBoxDateRange txtKokuhoShikakuKanyuYMD) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikakuJohoPanel().setTxtKokuhoShikakuKanyuYMD(txtKokuhoShikakuKanyuYMD);
    }

    @JsonIgnore
    public KokiShikakuJohoPanelDiv getKokiShikakuJohoPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel();
    }

    @JsonIgnore
    public void setKokiShikakuJohoPanel(KokiShikakuJohoPanelDiv KokiShikakuJohoPanel) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokiShikakuJohoPanel(KokiShikakuJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku();
    }

    @JsonIgnore
    public void setTxtKokiShikaku(TextBox txtKokiShikaku) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku(txtKokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku2() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku2();
    }

    @JsonIgnore
    public void setTxtKokiShikaku2(TextBox txtKokiShikaku2) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku2(txtKokiShikaku2);
    }

    @JsonIgnore
    public TextBox getTxtKokiShikaku3() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikaku3();
    }

    @JsonIgnore
    public void setTxtKokiShikaku3(TextBox txtKokiShikaku3) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikaku3(txtKokiShikaku3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiShikakuKanyuKikan() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().getTxtKokiShikakuKanyuKikan();
    }

    @JsonIgnore
    public void setTxtKokiShikakuKanyuKikan(TextBoxDateRange txtKokiShikakuKanyuKikan) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikakuJohoPanel().setTxtKokiShikakuKanyuKikan(txtKokiShikakuKanyuKikan);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel3Div getTabShinseiTorokuPanel3() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel3();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public tabShinseiTorokuPanel4Div getTabShinseiTorokuPanel4() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4);
    }

    @JsonIgnore
    public TorokuKanyRirekiuListPanelDiv getTorokuKanyRirekiuListPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel();
    }

    @JsonIgnore
    public void setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanelDiv TorokuKanyRirekiuListPanel) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().setTorokuKanyRirekiuListPanel(TorokuKanyRirekiuListPanel);
    }

    @JsonIgnore
    public Button getBtnKanyuJohoTsuika() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().getBtnKanyuJohoTsuika();
    }

    @JsonIgnore
    public void setBtnKanyuJohoTsuika(Button btnKanyuJohoTsuika) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().setBtnKanyuJohoTsuika(btnKanyuJohoTsuika);
    }

    @JsonIgnore
    public DataGrid<dgTorokuKanyRirekiuList_Row> getDgTorokuKanyRirekiuList() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().getDgTorokuKanyRirekiuList();
    }

    @JsonIgnore
    public void setDgTorokuKanyRirekiuList(DataGrid<dgTorokuKanyRirekiuList_Row> dgTorokuKanyRirekiuList) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getTorokuKanyRirekiuListPanel().setDgTorokuKanyRirekiuList(dgTorokuKanyRirekiuList);
    }

    @JsonIgnore
    public KanyuInfoPanelDiv getKanyuInfoPanel() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel();
    }

    @JsonIgnore
    public void setKanyuInfoPanel(KanyuInfoPanelDiv KanyuInfoPanel) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().setKanyuInfoPanel(KanyuInfoPanel);
    }

    @JsonIgnore
    public TextBox getTxtKanyuInfoHokensyaMei() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtKanyuInfoHokensyaMei();
    }

    @JsonIgnore
    public void setTxtKanyuInfoHokensyaMei(TextBox txtKanyuInfoHokensyaMei) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtKanyuInfoHokensyaMei(txtKanyuInfoHokensyaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuInfoKanyuKikanYMD() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtKanyuInfoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuInfoKanyuKikanYMD(TextBoxDateRange txtKanyuInfoKanyuKikanYMD) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtKanyuInfoKanyuKikanYMD(txtKanyuInfoKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekKakutei() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getBtnKanyuRirekKakutei();
    }

    @JsonIgnore
    public void setBtnKanyuRirekKakutei(Button btnKanyuRirekKakutei) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setBtnKanyuRirekKakutei(btnKanyuRirekKakutei);
    }

    @JsonIgnore
    public Button getBtnKanyuRirekiModoru() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().getBtnKanyuRirekiModoru();
    }

    @JsonIgnore
    public void setBtnKanyuRirekiModoru(Button btnKanyuRirekiModoru) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuInfoPanel().setBtnKanyuRirekiModoru(btnKanyuRirekiModoru);
    }

    @JsonIgnore
    public Button getBtnNaiyoKakutei() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getBtnNaiyoKakutei();
    }

    @JsonIgnore
    public void setBtnNaiyoKakutei(Button btnNaiyoKakutei) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().setBtnNaiyoKakutei(btnNaiyoKakutei);
    }

    @JsonIgnore
    public Button getBtnShinseiJohoModoru() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getBtnShinseiJohoModoru();
    }

    @JsonIgnore
    public void setBtnShinseiJohoModoru(Button btnShinseiJohoModoru) {
        this.getKogakuGassanShikyuShinseiTorokuPanel().setBtnShinseiJohoModoru(btnShinseiJohoModoru);
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getKogakuGassanShikyuShinseiTorokuPanel().getCcdKaigoAtenaInfo();
    }

    // </editor-fold>
}

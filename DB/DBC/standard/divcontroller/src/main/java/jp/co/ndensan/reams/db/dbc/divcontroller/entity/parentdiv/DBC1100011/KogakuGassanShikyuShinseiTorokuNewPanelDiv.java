package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * KogakuGassanShikyuShinseiTorokuNewPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuNewPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTeishutsuHokenshaBango")
    private DropDownList ddlTeishutsuHokenshaBango;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango1")
    private TextBox txtKaigoShikyuShinseishoSeiriBango1;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango2")
    private TextBox txtKaigoShikyuShinseishoSeiriBango2;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango3")
    private TextBox txtKaigoShikyuShinseishoSeiriBango3;
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango4")
    private TextBox txtKaigoShikyuShinseishoSeiriBango4;
    @JsonProperty("txtRirekiBango")
    private TextBoxNum txtRirekiBango;
    @JsonProperty("ddlShinseiTaisyoNendo")
    private DropDownList ddlShinseiTaisyoNendo;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango1")
    private TextBox txtIryoShikyuShinseishoSeiriBango1;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango2")
    private TextBox txtIryoShikyuShinseishoSeiriBango2;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango3")
    private TextBox txtIryoShikyuShinseishoSeiriBango3;
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango4")
    private TextBox txtIryoShikyuShinseishoSeiriBango4;
    @JsonProperty("txtShikyuShinseiKubun")
    private TextBox txtShikyuShinseiKubun;
    @JsonProperty("ddlShikyuShinseiKeitai")
    private DropDownList ddlShikyuShinseiKeitai;
    @JsonProperty("DaihyoshaPanel")
    private DaihyoshaPanelDiv DaihyoshaPanel;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("chkKofuShinseiUmu")
    private CheckBoxList chkKofuShinseiUmu;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnShinseiJohoTsuika")
    private Button btnShinseiJohoTsuika;
    @JsonProperty("dgShinseiJoho")
    private DataGrid<dgShinseiJoho_Row> dgShinseiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTeishutsuHokenshaBango
     * @return ddlTeishutsuHokenshaBango
     */
    @JsonProperty("ddlTeishutsuHokenshaBango")
    public DropDownList getDdlTeishutsuHokenshaBango() {
        return ddlTeishutsuHokenshaBango;
    }

    /*
     * setddlTeishutsuHokenshaBango
     * @param ddlTeishutsuHokenshaBango ddlTeishutsuHokenshaBango
     */
    @JsonProperty("ddlTeishutsuHokenshaBango")
    public void setDdlTeishutsuHokenshaBango(DropDownList ddlTeishutsuHokenshaBango) {
        this.ddlTeishutsuHokenshaBango = ddlTeishutsuHokenshaBango;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango1
     * @return txtKaigoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango1")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango1() {
        return txtKaigoShikyuShinseishoSeiriBango1;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango1
     * @param txtKaigoShikyuShinseishoSeiriBango1 txtKaigoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango1")
    public void setTxtKaigoShikyuShinseishoSeiriBango1(TextBox txtKaigoShikyuShinseishoSeiriBango1) {
        this.txtKaigoShikyuShinseishoSeiriBango1 = txtKaigoShikyuShinseishoSeiriBango1;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango2
     * @return txtKaigoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango2")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango2() {
        return txtKaigoShikyuShinseishoSeiriBango2;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango2
     * @param txtKaigoShikyuShinseishoSeiriBango2 txtKaigoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango2")
    public void setTxtKaigoShikyuShinseishoSeiriBango2(TextBox txtKaigoShikyuShinseishoSeiriBango2) {
        this.txtKaigoShikyuShinseishoSeiriBango2 = txtKaigoShikyuShinseishoSeiriBango2;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango3
     * @return txtKaigoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango3")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango3() {
        return txtKaigoShikyuShinseishoSeiriBango3;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango3
     * @param txtKaigoShikyuShinseishoSeiriBango3 txtKaigoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango3")
    public void setTxtKaigoShikyuShinseishoSeiriBango3(TextBox txtKaigoShikyuShinseishoSeiriBango3) {
        this.txtKaigoShikyuShinseishoSeiriBango3 = txtKaigoShikyuShinseishoSeiriBango3;
    }

    /*
     * gettxtKaigoShikyuShinseishoSeiriBango4
     * @return txtKaigoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango4")
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango4() {
        return txtKaigoShikyuShinseishoSeiriBango4;
    }

    /*
     * settxtKaigoShikyuShinseishoSeiriBango4
     * @param txtKaigoShikyuShinseishoSeiriBango4 txtKaigoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtKaigoShikyuShinseishoSeiriBango4")
    public void setTxtKaigoShikyuShinseishoSeiriBango4(TextBox txtKaigoShikyuShinseishoSeiriBango4) {
        this.txtKaigoShikyuShinseishoSeiriBango4 = txtKaigoShikyuShinseishoSeiriBango4;
    }

    /*
     * gettxtRirekiBango
     * @return txtRirekiBango
     */
    @JsonProperty("txtRirekiBango")
    public TextBoxNum getTxtRirekiBango() {
        return txtRirekiBango;
    }

    /*
     * settxtRirekiBango
     * @param txtRirekiBango txtRirekiBango
     */
    @JsonProperty("txtRirekiBango")
    public void setTxtRirekiBango(TextBoxNum txtRirekiBango) {
        this.txtRirekiBango = txtRirekiBango;
    }

    /*
     * getddlShinseiTaisyoNendo
     * @return ddlShinseiTaisyoNendo
     */
    @JsonProperty("ddlShinseiTaisyoNendo")
    public DropDownList getDdlShinseiTaisyoNendo() {
        return ddlShinseiTaisyoNendo;
    }

    /*
     * setddlShinseiTaisyoNendo
     * @param ddlShinseiTaisyoNendo ddlShinseiTaisyoNendo
     */
    @JsonProperty("ddlShinseiTaisyoNendo")
    public void setDdlShinseiTaisyoNendo(DropDownList ddlShinseiTaisyoNendo) {
        this.ddlShinseiTaisyoNendo = ddlShinseiTaisyoNendo;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango1
     * @return txtIryoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango1")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango1() {
        return txtIryoShikyuShinseishoSeiriBango1;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango1
     * @param txtIryoShikyuShinseishoSeiriBango1 txtIryoShikyuShinseishoSeiriBango1
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango1")
    public void setTxtIryoShikyuShinseishoSeiriBango1(TextBox txtIryoShikyuShinseishoSeiriBango1) {
        this.txtIryoShikyuShinseishoSeiriBango1 = txtIryoShikyuShinseishoSeiriBango1;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango2
     * @return txtIryoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango2")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango2() {
        return txtIryoShikyuShinseishoSeiriBango2;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango2
     * @param txtIryoShikyuShinseishoSeiriBango2 txtIryoShikyuShinseishoSeiriBango2
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango2")
    public void setTxtIryoShikyuShinseishoSeiriBango2(TextBox txtIryoShikyuShinseishoSeiriBango2) {
        this.txtIryoShikyuShinseishoSeiriBango2 = txtIryoShikyuShinseishoSeiriBango2;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango3
     * @return txtIryoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango3")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango3() {
        return txtIryoShikyuShinseishoSeiriBango3;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango3
     * @param txtIryoShikyuShinseishoSeiriBango3 txtIryoShikyuShinseishoSeiriBango3
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango3")
    public void setTxtIryoShikyuShinseishoSeiriBango3(TextBox txtIryoShikyuShinseishoSeiriBango3) {
        this.txtIryoShikyuShinseishoSeiriBango3 = txtIryoShikyuShinseishoSeiriBango3;
    }

    /*
     * gettxtIryoShikyuShinseishoSeiriBango4
     * @return txtIryoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango4")
    public TextBox getTxtIryoShikyuShinseishoSeiriBango4() {
        return txtIryoShikyuShinseishoSeiriBango4;
    }

    /*
     * settxtIryoShikyuShinseishoSeiriBango4
     * @param txtIryoShikyuShinseishoSeiriBango4 txtIryoShikyuShinseishoSeiriBango4
     */
    @JsonProperty("txtIryoShikyuShinseishoSeiriBango4")
    public void setTxtIryoShikyuShinseishoSeiriBango4(TextBox txtIryoShikyuShinseishoSeiriBango4) {
        this.txtIryoShikyuShinseishoSeiriBango4 = txtIryoShikyuShinseishoSeiriBango4;
    }

    /*
     * gettxtShikyuShinseiKubun
     * @return txtShikyuShinseiKubun
     */
    @JsonProperty("txtShikyuShinseiKubun")
    public TextBox getTxtShikyuShinseiKubun() {
        return txtShikyuShinseiKubun;
    }

    /*
     * settxtShikyuShinseiKubun
     * @param txtShikyuShinseiKubun txtShikyuShinseiKubun
     */
    @JsonProperty("txtShikyuShinseiKubun")
    public void setTxtShikyuShinseiKubun(TextBox txtShikyuShinseiKubun) {
        this.txtShikyuShinseiKubun = txtShikyuShinseiKubun;
    }

    /*
     * getddlShikyuShinseiKeitai
     * @return ddlShikyuShinseiKeitai
     */
    @JsonProperty("ddlShikyuShinseiKeitai")
    public DropDownList getDdlShikyuShinseiKeitai() {
        return ddlShikyuShinseiKeitai;
    }

    /*
     * setddlShikyuShinseiKeitai
     * @param ddlShikyuShinseiKeitai ddlShikyuShinseiKeitai
     */
    @JsonProperty("ddlShikyuShinseiKeitai")
    public void setDdlShikyuShinseiKeitai(DropDownList ddlShikyuShinseiKeitai) {
        this.ddlShikyuShinseiKeitai = ddlShikyuShinseiKeitai;
    }

    /*
     * getDaihyoshaPanel
     * @return DaihyoshaPanel
     */
    @JsonProperty("DaihyoshaPanel")
    public DaihyoshaPanelDiv getDaihyoshaPanel() {
        return DaihyoshaPanel;
    }

    /*
     * setDaihyoshaPanel
     * @param DaihyoshaPanel DaihyoshaPanel
     */
    @JsonProperty("DaihyoshaPanel")
    public void setDaihyoshaPanel(DaihyoshaPanelDiv DaihyoshaPanel) {
        this.DaihyoshaPanel = DaihyoshaPanel;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * getchkKofuShinseiUmu
     * @return chkKofuShinseiUmu
     */
    @JsonProperty("chkKofuShinseiUmu")
    public CheckBoxList getChkKofuShinseiUmu() {
        return chkKofuShinseiUmu;
    }

    /*
     * setchkKofuShinseiUmu
     * @param chkKofuShinseiUmu chkKofuShinseiUmu
     */
    @JsonProperty("chkKofuShinseiUmu")
    public void setChkKofuShinseiUmu(CheckBoxList chkKofuShinseiUmu) {
        this.chkKofuShinseiUmu = chkKofuShinseiUmu;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getbtnShinseiJohoTsuika
     * @return btnShinseiJohoTsuika
     */
    @JsonProperty("btnShinseiJohoTsuika")
    public Button getBtnShinseiJohoTsuika() {
        return btnShinseiJohoTsuika;
    }

    /*
     * setbtnShinseiJohoTsuika
     * @param btnShinseiJohoTsuika btnShinseiJohoTsuika
     */
    @JsonProperty("btnShinseiJohoTsuika")
    public void setBtnShinseiJohoTsuika(Button btnShinseiJohoTsuika) {
        this.btnShinseiJohoTsuika = btnShinseiJohoTsuika;
    }

    /*
     * getdgShinseiJoho
     * @return dgShinseiJoho
     */
    @JsonProperty("dgShinseiJoho")
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return dgShinseiJoho;
    }

    /*
     * setdgShinseiJoho
     * @param dgShinseiJoho dgShinseiJoho
     */
    @JsonProperty("dgShinseiJoho")
    public void setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.dgShinseiJoho = dgShinseiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtDaihyoshaShimei() {
        return this.getDaihyoshaPanel().getTxtDaihyoshaShimei();
    }

    @JsonIgnore
    public void setTxtDaihyoshaShimei(TextBox txtDaihyoshaShimei) {
        this.getDaihyoshaPanel().setTxtDaihyoshaShimei(txtDaihyoshaShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDaihyoshaTelNo() {
        return this.getDaihyoshaPanel().getTxtDaihyoshaTelNo();
    }

    @JsonIgnore
    public void setTxtDaihyoshaTelNo(TextBoxTelNo txtDaihyoshaTelNo) {
        this.getDaihyoshaPanel().setTxtDaihyoshaTelNo(txtDaihyoshaTelNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtDaihyoshaYubinNo() {
        return this.getDaihyoshaPanel().getTxtDaihyoshaYubinNo();
    }

    @JsonIgnore
    public void setTxtDaihyoshaYubinNo(TextBoxYubinNo txtDaihyoshaYubinNo) {
        this.getDaihyoshaPanel().setTxtDaihyoshaYubinNo(txtDaihyoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtDaihyoshaJusyo() {
        return this.getDaihyoshaPanel().getTxtDaihyoshaJusyo();
    }

    @JsonIgnore
    public void setTxtDaihyoshaJusyo(TextBox txtDaihyoshaJusyo) {
        this.getDaihyoshaPanel().setTxtDaihyoshaJusyo(txtDaihyoshaJusyo);
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyugakuKeisanKekkaTorokuDetailPanel のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuDetailPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSanteiKubun")
    private TextBox txtSanteiKubun;
    @JsonProperty("txtStatusFlg")
    private TextBox txtStatusFlg;
    @JsonProperty("txtTaishoNendo")
    private TextBoxDate txtTaishoNendo;
    @JsonProperty("txtShoKisaiHokenshaNoa")
    private TextBox txtShoKisaiHokenshaNoa;
    @JsonProperty("txtShikyuShinseishoSeiriNo")
    private TextBox txtShikyuShinseishoSeiriNo;
    @JsonProperty("txtSofuYM")
    private TextBoxDate txtSofuYM;
    @JsonProperty("chkSaiso")
    private CheckBoxList chkSaiso;
    @JsonProperty("tabMeisai")
    private tabMeisaiDiv tabMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSanteiKubun
     * @return txtSanteiKubun
     */
    @JsonProperty("txtSanteiKubun")
    public TextBox getTxtSanteiKubun() {
        return txtSanteiKubun;
    }

    /*
     * settxtSanteiKubun
     * @param txtSanteiKubun txtSanteiKubun
     */
    @JsonProperty("txtSanteiKubun")
    public void setTxtSanteiKubun(TextBox txtSanteiKubun) {
        this.txtSanteiKubun = txtSanteiKubun;
    }

    /*
     * gettxtStatusFlg
     * @return txtStatusFlg
     */
    @JsonProperty("txtStatusFlg")
    public TextBox getTxtStatusFlg() {
        return txtStatusFlg;
    }

    /*
     * settxtStatusFlg
     * @param txtStatusFlg txtStatusFlg
     */
    @JsonProperty("txtStatusFlg")
    public void setTxtStatusFlg(TextBox txtStatusFlg) {
        this.txtStatusFlg = txtStatusFlg;
    }

    /*
     * gettxtTaishoNendo
     * @return txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public TextBoxDate getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    /*
     * settxtTaishoNendo
     * @param txtTaishoNendo txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public void setTxtTaishoNendo(TextBoxDate txtTaishoNendo) {
        this.txtTaishoNendo = txtTaishoNendo;
    }

    /*
     * gettxtShoKisaiHokenshaNoa
     * @return txtShoKisaiHokenshaNoa
     */
    @JsonProperty("txtShoKisaiHokenshaNoa")
    public TextBox getTxtShoKisaiHokenshaNoa() {
        return txtShoKisaiHokenshaNoa;
    }

    /*
     * settxtShoKisaiHokenshaNoa
     * @param txtShoKisaiHokenshaNoa txtShoKisaiHokenshaNoa
     */
    @JsonProperty("txtShoKisaiHokenshaNoa")
    public void setTxtShoKisaiHokenshaNoa(TextBox txtShoKisaiHokenshaNoa) {
        this.txtShoKisaiHokenshaNoa = txtShoKisaiHokenshaNoa;
    }

    /*
     * gettxtShikyuShinseishoSeiriNo
     * @return txtShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtShikyuShinseishoSeiriNo")
    public TextBox getTxtShikyuShinseishoSeiriNo() {
        return txtShikyuShinseishoSeiriNo;
    }

    /*
     * settxtShikyuShinseishoSeiriNo
     * @param txtShikyuShinseishoSeiriNo txtShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtShikyuShinseishoSeiriNo")
    public void setTxtShikyuShinseishoSeiriNo(TextBox txtShikyuShinseishoSeiriNo) {
        this.txtShikyuShinseishoSeiriNo = txtShikyuShinseishoSeiriNo;
    }

    /*
     * gettxtSofuYM
     * @return txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public TextBoxDate getTxtSofuYM() {
        return txtSofuYM;
    }

    /*
     * settxtSofuYM
     * @param txtSofuYM txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public void setTxtSofuYM(TextBoxDate txtSofuYM) {
        this.txtSofuYM = txtSofuYM;
    }

    /*
     * getchkSaiso
     * @return chkSaiso
     */
    @JsonProperty("chkSaiso")
    public CheckBoxList getChkSaiso() {
        return chkSaiso;
    }

    /*
     * setchkSaiso
     * @param chkSaiso chkSaiso
     */
    @JsonProperty("chkSaiso")
    public void setChkSaiso(CheckBoxList chkSaiso) {
        this.chkSaiso = chkSaiso;
    }

    /*
     * gettabMeisai
     * @return tabMeisai
     */
    @JsonProperty("tabMeisai")
    public tabMeisaiDiv getTabMeisai() {
        return tabMeisai;
    }

    /*
     * settabMeisai
     * @param tabMeisai tabMeisai
     */
    @JsonProperty("tabMeisai")
    public void setTabMeisai(tabMeisaiDiv tabMeisai) {
        this.tabMeisai = tabMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabShikyugakuKeisanKekkaTorokuUchiwakeDiv getTabShikyugakuKeisanKekkaTorokuUchiwake() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake();
    }

    @JsonIgnore
    public void  setTabShikyugakuKeisanKekkaTorokuUchiwake(tabShikyugakuKeisanKekkaTorokuUchiwakeDiv tabShikyugakuKeisanKekkaTorokuUchiwake) {
        this.getTabMeisai().setTabShikyugakuKeisanKekkaTorokuUchiwake(tabShikyugakuKeisanKekkaTorokuUchiwake);
    }

    @JsonIgnore
    public ShikyugakuKeisanKekkaTorokuUchiwakeListDiv getShikyugakuKeisanKekkaTorokuUchiwakeList() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList();
    }

    @JsonIgnore
    public void  setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeListDiv ShikyugakuKeisanKekkaTorokuUchiwakeList) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeList);
    }

    @JsonIgnore
    public Button getBtnUchiwakeAdd() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getBtnUchiwakeAdd();
    }

    @JsonIgnore
    public void  setBtnUchiwakeAdd(Button btnUchiwakeAdd) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setBtnUchiwakeAdd(btnUchiwakeAdd);
    }

    @JsonIgnore
    public DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> getDgKogakuGassanShikyugakuKeisanKekkaMeisai() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getDgKogakuGassanShikyugakuKeisanKekkaMeisai();
    }

    @JsonIgnore
    public void  setDgKogakuGassanShikyugakuKeisanKekkaMeisai(DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> dgKogakuGassanShikyugakuKeisanKekkaMeisai) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setDgKogakuGassanShikyugakuKeisanKekkaMeisai(dgKogakuGassanShikyugakuKeisanKekkaMeisai);
    }

    @JsonIgnore
    public GokeiJohoPanelDiv getGokeiJohoPanel() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel();
    }

    @JsonIgnore
    public void  setGokeiJohoPanel(GokeiJohoPanelDiv GokeiJohoPanel) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setGokeiJohoPanel(GokeiJohoPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70FutangakuGokei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70FutangakuGokei(TextBoxNum txtJohoOver70FutangakuGokei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70FutangakuGokei(txtJohoOver70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70ShikyugakuGokei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70ShikyugakuGokei(TextBoxNum txtJohoOver70ShikyugakuGokei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70ShikyugakuGokei(txtJohoOver70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70FutangakuGokei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70FutangakuGokei(TextBoxNum txtJohoUnder70FutangakuGokei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70FutangakuGokei(txtJohoUnder70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoFutangakuGokei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoFutangakuGokei(TextBoxNum txtJohoFutangakuGokei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoFutangakuGokei(txtJohoFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70ShikyugakuGokei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70ShikyugakuGokei(TextBoxNum txtJohoUnder70ShikyugakuGokei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70ShikyugakuGokei(txtJohoUnder70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoShikyugakuGokei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoShikyugakuGokei(TextBoxNum txtJohoShikyugakuGokei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoShikyugakuGokei(txtJohoShikyugakuGokei);
    }

    @JsonIgnore
    public ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv getShikyugakuKeisanKekkaTorokuUchiwakeDetail() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail();
    }

    @JsonIgnore
    public void  setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv ShikyugakuKeisanKekkaTorokuUchiwakeDetail) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetail);
    }

    @JsonIgnore
    public DropDownList getDdlHokenSeido() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getDdlHokenSeido();
    }

    @JsonIgnore
    public void  setDdlHokenSeido(DropDownList ddlHokenSeido) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setDdlHokenSeido(ddlHokenSeido);
    }

    @JsonIgnore
    public TextBox getTxtShoKisaiHokenshaNo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShoKisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShoKisaiHokenshaNo(TextBox txtShoKisaiHokenshaNo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShoKisaiHokenshaNo(txtShoKisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHokenshaMei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHokenshaMei();
    }

    @JsonIgnore
    public void  setTxtHokenshaMei(TextBox txtHokenshaMei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHokenshaMei(txtHokenshaMei);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin3(lin3);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaShoKigo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtKokuhoHihokenshaShoKigo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHihokenshaShoKigo(TextBox txtKokuhoHihokenshaShoKigo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtKokuhoHihokenshaShoKigo(txtKokuhoHihokenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtTaishoshaShimei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtTaishoshaShimei();
    }

    @JsonIgnore
    public void  setTxtTaishoshaShimei(TextBox txtTaishoshaShimei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtTaishoshaShimei(txtTaishoshaShimei);
    }

    @JsonIgnore
    public TextBox getTxtHiHokenshaShoNo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHiHokenshaShoNo();
    }

    @JsonIgnore
    public void  setTxtHiHokenshaShoNo(TextBox txtHiHokenshaShoNo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHiHokenshaShoNo(txtHiHokenshaShoNo);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNom() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtJikoFutanSeiriNom();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNom(TextBox txtJikoFutanSeiriNom) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtJikoFutanSeiriNom(txtJikoFutanSeiriNom);
    }

    @JsonIgnore
    public HorizontalLine getLin4() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin4();
    }

    @JsonIgnore
    public void  setLin4(HorizontalLine lin4) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin4(lin4);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Futangaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Futangaku();
    }

    @JsonIgnore
    public void  setTxtOver70Futangaku(TextBoxNum txtOver70Futangaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Futangaku(txtOver70Futangaku);
    }

    @JsonIgnore
    public TextBox getTxtOver70AmbunRitsu() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70AmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtOver70AmbunRitsu(TextBox txtOver70AmbunRitsu) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70AmbunRitsu(txtOver70AmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Shikyugaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70Shikyugaku(TextBoxNum txtOver70Shikyugaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Shikyugaku(txtOver70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Futangaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Futangaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Futangaku(TextBoxNum txtUnder70Futangaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Futangaku(txtUnder70Futangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutangaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtFutangaku();
    }

    @JsonIgnore
    public void  setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtFutangaku(txtFutangaku);
    }

    @JsonIgnore
    public TextBox getTxtAmbunRitsu() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtAmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtAmbunRitsu(TextBox txtAmbunRitsu) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtAmbunRitsu(txtAmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Shikyugaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Shikyugaku(TextBoxNum txtUnder70Shikyugaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Shikyugaku(txtUnder70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtShikyuGaku(TextBoxNum txtShikyuGaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShikyuGaku(txtShikyuGaku);
    }

    @JsonIgnore
    public HorizontalLine getLin5() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin5();
    }

    @JsonIgnore
    public void  setLin5(HorizontalLine lin5) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin5(lin5);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Biko() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Biko();
    }

    @JsonIgnore
    public void  setTxtOver70Biko(TextBoxNum txtOver70Biko) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Biko(txtOver70Biko);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Biko() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Biko();
    }

    @JsonIgnore
    public void  setTxtUnder70Biko(TextBoxNum txtUnder70Biko) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Biko(txtUnder70Biko);
    }

    @JsonIgnore
    public HorizontalLine getLin7() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin7();
    }

    @JsonIgnore
    public void  setLin7(HorizontalLine lin7) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin7(lin7);
    }

    @JsonIgnore
    public Button getBtnUchiwakeKakutei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeKakutei();
    }

    @JsonIgnore
    public void  setBtnUchiwakeKakutei(Button btnUchiwakeKakutei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeKakutei(btnUchiwakeKakutei);
    }

    @JsonIgnore
    public Button getBtnUchiwakeIchiramModoru() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeIchiramModoru();
    }

    @JsonIgnore
    public void  setBtnUchiwakeIchiramModoru(Button btnUchiwakeIchiramModoru) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeIchiramModoru(btnUchiwakeIchiramModoru);
    }

    @JsonIgnore
    public tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv getTabShikyugakuKeisanKekkaTorokuShikyuGaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku();
    }

    @JsonIgnore
    public void  setTabShikyugakuKeisanKekkaTorokuShikyuGaku(tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv tabShikyugakuKeisanKekkaTorokuShikyuGaku) {
        this.getTabMeisai().setTabShikyugakuKeisanKekkaTorokuShikyuGaku(tabShikyugakuKeisanKekkaTorokuShikyuGaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikan() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtTaishoKeisanKikan();
    }

    @JsonIgnore
    public void  setTxtTaishoKeisanKikan(TextBoxDateRange txtTaishoKeisanKikan) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtTaishoKeisanKikan(txtTaishoKeisanKikan);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtJikoFutanSeiriNo();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtJikoFutanSeiriNo(txtJikoFutanSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiFutanSogaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiFutanSogaku();
    }

    @JsonIgnore
    public void  setTxtSetaiFutanSogaku(TextBoxNum txtSetaiFutanSogaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiFutanSogaku(txtSetaiFutanSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiShikyuSogaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiShikyuSogaku();
    }

    @JsonIgnore
    public void  setTxtSetaiShikyuSogaku(TextBoxNum txtSetaiShikyuSogaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiShikyuSogaku(txtSetaiShikyuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SetaiShikyuSogaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SetaiShikyuSogaku();
    }

    @JsonIgnore
    public void  setTxtOver70SetaiShikyuSogaku(TextBoxNum txtOver70SetaiShikyuSogaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SetaiShikyuSogaku(txtOver70SetaiShikyuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiGassanGaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiGassanGaku();
    }

    @JsonIgnore
    public void  setTxtSetaiGassanGaku(TextBoxNum txtSetaiGassanGaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiGassanGaku(txtSetaiGassanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SetaiGassanGaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SetaiGassanGaku();
    }

    @JsonIgnore
    public void  setTxtOver70SetaiGassanGaku(TextBoxNum txtOver70SetaiGassanGaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SetaiGassanGaku(txtOver70SetaiGassanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHonninShikyugaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtHonninShikyugaku();
    }

    @JsonIgnore
    public void  setTxtHonninShikyugaku(TextBoxNum txtHonninShikyugaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtHonninShikyugaku(txtHonninShikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70HonninShikyugaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70HonninShikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70HonninShikyugaku(TextBoxNum txtOver70HonninShikyugaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70HonninShikyugaku(txtOver70HonninShikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSanteiKijunGaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSanteiKijunGaku();
    }

    @JsonIgnore
    public void  setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSanteiKijunGaku(txtSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SanteiKijyunGaku() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SanteiKijyunGaku();
    }

    @JsonIgnore
    public void  setTxtOver70SanteiKijyunGaku(TextBoxNum txtOver70SanteiKijyunGaku) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SanteiKijyunGaku(txtOver70SanteiKijyunGaku);
    }

    @JsonIgnore
    public CheckBoxList getCblTeiShotoku1SaiKeisanUmu() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getCblTeiShotoku1SaiKeisanUmu();
    }

    @JsonIgnore
    public void  setCblTeiShotoku1SaiKeisanUmu(CheckBoxList cblTeiShotoku1SaiKeisanUmu) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setCblTeiShotoku1SaiKeisanUmu(cblTeiShotoku1SaiKeisanUmu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv getTabShikyugakuKeisanKekkaTorokuRenrakuhyo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo();
    }

    @JsonIgnore
    public void  setTabShikyugakuKeisanKekkaTorokuRenrakuhyo(tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv tabShikyugakuKeisanKekkaTorokuRenrakuhyo) {
        this.getTabMeisai().setTabShikyugakuKeisanKekkaTorokuRenrakuhyo(tabShikyugakuKeisanKekkaTorokuRenrakuhyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchiYMD() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getTxtTsuchiYMD();
    }

    @JsonIgnore
    public void  setTxtTsuchiYMD(TextBoxDate txtTsuchiYMD) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setTxtTsuchiYMD(txtTsuchiYMD);
    }

    @JsonIgnore
    public RenrakuhyoHakkoshaPanelDiv getRenrakuhyoHakkoshaPanel() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel();
    }

    @JsonIgnore
    public void  setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanelDiv RenrakuhyoHakkoshaPanel) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanel);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaMei() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaMei();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaMei(TextBox txtRenrakuhyoHakkoshaMei) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaMei(txtRenrakuhyoHakkoshaMei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtRenrakuhyoHakkoshaYubinNo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaYubinNo(TextBoxYubinNo txtRenrakuhyoHakkoshaYubinNo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaYubinNo(txtRenrakuhyoHakkoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaJusho() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaJusho();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaJusho(TextBox txtRenrakuhyoHakkoshaJusho) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaJusho(txtRenrakuhyoHakkoshaJusho);
    }

    @JsonIgnore
    public ToiawasesakiPanelDiv getToiawasesakiPanel() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel();
    }

    @JsonIgnore
    public void  setToiawasesakiPanel(ToiawasesakiPanelDiv ToiawasesakiPanel) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setToiawasesakiPanel(ToiawasesakiPanel);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho1() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiMeisho1();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho1(TextBox txtToiawasesakiMeisho1) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiMeisho1(txtToiawasesakiMeisho1);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtToiawasesakiYobinNo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiYobinNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiYobinNo(TextBoxYubinNo txtToiawasesakiYobinNo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiYobinNo(txtToiawasesakiYobinNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho2() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiMeisho2();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho2(TextBox txtToiawasesakiMeisho2) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiMeisho2(txtToiawasesakiMeisho2);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiTelNo() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiTelNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiTelNo(TextBox txtToiawasesakiTelNo) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiTelNo(txtToiawasesakiTelNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiJusho() {
        return this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiJusho();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiJusho(TextBox txtToiawasesakiJusho) {
        this.getTabMeisai().getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiJusho(txtToiawasesakiJusho);
    }

    // </editor-fold>
}

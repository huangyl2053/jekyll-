package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuTesuryoSeikyuShosaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuTesuryoSeikyuShosaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtSeikyuSakuseiYMD")
    private TextBox txtSeikyuSakuseiYMD;
    @JsonProperty("txtHdnShikibetsuCode")
    private TextBoxCode txtHdnShikibetsuCode;
    @JsonProperty("ddlKozaShubetsu")
    private DropDownList ddlKozaShubetsu;
    @JsonProperty("txtKozaNo")
    private TextBoxCode txtKozaNo;
    @JsonProperty("txtKozaNameKana")
    private TextBoxKana txtKozaNameKana;
    @JsonProperty("txtKozaName")
    private TextBox txtKozaName;
    @JsonProperty("JutakuTesuryoSeikyuMeisai")
    private JutakuTesuryoSeikyuMeisaiDiv JutakuTesuryoSeikyuMeisai;
    @JsonProperty("ccdKinyuKikanInput")
    private KinyuKikanInputDiv ccdKinyuKikanInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * gettxtSeikyuSakuseiYMD
     * @return txtSeikyuSakuseiYMD
     */
    @JsonProperty("txtSeikyuSakuseiYMD")
    public TextBox getTxtSeikyuSakuseiYMD() {
        return txtSeikyuSakuseiYMD;
    }

    /*
     * settxtSeikyuSakuseiYMD
     * @param txtSeikyuSakuseiYMD txtSeikyuSakuseiYMD
     */
    @JsonProperty("txtSeikyuSakuseiYMD")
    public void setTxtSeikyuSakuseiYMD(TextBox txtSeikyuSakuseiYMD) {
        this.txtSeikyuSakuseiYMD = txtSeikyuSakuseiYMD;
    }

    /*
     * gettxtHdnShikibetsuCode
     * @return txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public TextBoxCode getTxtHdnShikibetsuCode() {
        return txtHdnShikibetsuCode;
    }

    /*
     * settxtHdnShikibetsuCode
     * @param txtHdnShikibetsuCode txtHdnShikibetsuCode
     */
    @JsonProperty("txtHdnShikibetsuCode")
    public void setTxtHdnShikibetsuCode(TextBoxCode txtHdnShikibetsuCode) {
        this.txtHdnShikibetsuCode = txtHdnShikibetsuCode;
    }

    /*
     * getddlKozaShubetsu
     * @return ddlKozaShubetsu
     */
    @JsonProperty("ddlKozaShubetsu")
    public DropDownList getDdlKozaShubetsu() {
        return ddlKozaShubetsu;
    }

    /*
     * setddlKozaShubetsu
     * @param ddlKozaShubetsu ddlKozaShubetsu
     */
    @JsonProperty("ddlKozaShubetsu")
    public void setDdlKozaShubetsu(DropDownList ddlKozaShubetsu) {
        this.ddlKozaShubetsu = ddlKozaShubetsu;
    }

    /*
     * gettxtKozaNo
     * @return txtKozaNo
     */
    @JsonProperty("txtKozaNo")
    public TextBoxCode getTxtKozaNo() {
        return txtKozaNo;
    }

    /*
     * settxtKozaNo
     * @param txtKozaNo txtKozaNo
     */
    @JsonProperty("txtKozaNo")
    public void setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.txtKozaNo = txtKozaNo;
    }

    /*
     * gettxtKozaNameKana
     * @return txtKozaNameKana
     */
    @JsonProperty("txtKozaNameKana")
    public TextBoxKana getTxtKozaNameKana() {
        return txtKozaNameKana;
    }

    /*
     * settxtKozaNameKana
     * @param txtKozaNameKana txtKozaNameKana
     */
    @JsonProperty("txtKozaNameKana")
    public void setTxtKozaNameKana(TextBoxKana txtKozaNameKana) {
        this.txtKozaNameKana = txtKozaNameKana;
    }

    /*
     * gettxtKozaName
     * @return txtKozaName
     */
    @JsonProperty("txtKozaName")
    public TextBox getTxtKozaName() {
        return txtKozaName;
    }

    /*
     * settxtKozaName
     * @param txtKozaName txtKozaName
     */
    @JsonProperty("txtKozaName")
    public void setTxtKozaName(TextBox txtKozaName) {
        this.txtKozaName = txtKozaName;
    }

    /*
     * getJutakuTesuryoSeikyuMeisai
     * @return JutakuTesuryoSeikyuMeisai
     */
    @JsonProperty("JutakuTesuryoSeikyuMeisai")
    public JutakuTesuryoSeikyuMeisaiDiv getJutakuTesuryoSeikyuMeisai() {
        return JutakuTesuryoSeikyuMeisai;
    }

    /*
     * setJutakuTesuryoSeikyuMeisai
     * @param JutakuTesuryoSeikyuMeisai JutakuTesuryoSeikyuMeisai
     */
    @JsonProperty("JutakuTesuryoSeikyuMeisai")
    public void setJutakuTesuryoSeikyuMeisai(JutakuTesuryoSeikyuMeisaiDiv JutakuTesuryoSeikyuMeisai) {
        this.JutakuTesuryoSeikyuMeisai = JutakuTesuryoSeikyuMeisai;
    }

    /*
     * getccdKinyuKikanInput
     * @return ccdKinyuKikanInput
     */
    @JsonProperty("ccdKinyuKikanInput")
    public IKinyuKikanInputDiv getCcdKinyuKikanInput() {
        return ccdKinyuKikanInput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgSeikyuMeisai_Row> getDgSeikyuMeisai() {
        return this.getJutakuTesuryoSeikyuMeisai().getDgSeikyuMeisai();
    }

    @JsonIgnore
    public void  setDgSeikyuMeisai(DataGrid<dgSeikyuMeisai_Row> dgSeikyuMeisai) {
        this.getJutakuTesuryoSeikyuMeisai().setDgSeikyuMeisai(dgSeikyuMeisai);
    }

    @JsonIgnore
    public SeikyuMeisaiShosaiPanelDiv getSeikyuMeisaiShosaiPanel() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel();
    }

    @JsonIgnore
    public void  setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanelDiv SeikyuMeisaiShosaiPanel) {
        this.getJutakuTesuryoSeikyuMeisai().setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanel);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JutakuKaishuRiyushoPanelDiv getJutakuKaishuRiyushoPanel() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanelDiv JutakuKaishuRiyushoPanel) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtRiyushoSakuseiYMD() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiYMD(TextBoxDate txtRiyushoSakuseiYMD) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseiYMD(txtRiyushoSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxKana getTxtRiyushoSakuseishaMeiKana() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMeiKana(TextBoxKana txtRiyushoSakuseishaMeiKana) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMeiKana(txtRiyushoSakuseishaMeiKana);
    }

    @JsonIgnore
    public TextBox getTxtRiyushoSakuseishaMei() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMei(TextBox txtRiyushoSakuseishaMei) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMei(txtRiyushoSakuseishaMei);
    }

    @JsonIgnore
    public JutakuKaishuPanelDiv getJutakuKaishuPanel() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuPanel(JutakuKaishuPanelDiv JutakuKaishuPanel) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setJutakuKaishuPanel(JutakuKaishuPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishuShikyuShinseiYMD() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishuShikyuShinseiYMD(TextBoxDate txtKaishuShikyuShinseiYMD) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuShikyuShinseiYMD(txtKaishuShikyuShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJutakuKaishuChakkoYMD() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuChakkoYMD(TextBoxDate txtJutakuKaishuChakkoYMD) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuChakkoYMD(txtJutakuKaishuChakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtJutakuKaishuJigyoshaMeisho() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuJigyoshaMeisho(TextBox txtJutakuKaishuJigyoshaMeisho) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuJigyoshaMeisho(txtJutakuKaishuJigyoshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKaishuTaishoJutakuJusho() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho();
    }

    @JsonIgnore
    public void  setTxtKaishuTaishoJutakuJusho(TextBox txtKaishuTaishoJutakuJusho) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuTaishoJutakuJusho(txtKaishuTaishoJutakuJusho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKaishuNaiyokashoKibo() {
        return this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo();
    }

    @JsonIgnore
    public void  setTxtKaishuNaiyokashoKibo(TextBoxMultiLine txtKaishuNaiyokashoKibo) {
        this.getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuNaiyokashoKibo(txtKaishuNaiyokashoKibo);
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuShukeiPanelDiv getJutakuTesuryoSeikyuShukeiPanel() {
        return this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanelDiv JutakuTesuryoSeikyuShukeiPanel) {
        this.getJutakuTesuryoSeikyuMeisai().setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiTanka() {
        return this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiTanka(TextBoxNum txtRiyushoSakuseiTanka) {
        this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiTanka(txtRiyushoSakuseiTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiKensu() {
        return this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiKensu(TextBoxNum txtRiyushoSakuseiKensu) {
        this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiKensu(txtRiyushoSakuseiKensu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiSeikyuKingaku() {
        return this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiSeikyuKingaku(TextBoxNum txtRiyushoSakuseiSeikyuKingaku) {
        this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiSeikyuKingaku(txtRiyushoSakuseiSeikyuKingaku);
    }

    @JsonIgnore
    public Button getBtnShukei() {
        return this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getBtnShukei();
    }

    @JsonIgnore
    public void  setBtnShukei(Button btnShukei) {
        this.getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setBtnShukei(btnShukei);
    }

    // </editor-fold>
}

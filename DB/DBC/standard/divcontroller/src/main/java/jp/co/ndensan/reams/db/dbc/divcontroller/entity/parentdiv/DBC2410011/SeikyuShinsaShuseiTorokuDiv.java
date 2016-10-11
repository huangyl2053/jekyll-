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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SeikyuShinsaShuseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikyuShinsaShuseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchJutakuTesuryoSeikyuJohoPanel")
    private SearchJutakuTesuryoSeikyuJohoPanelDiv SearchJutakuTesuryoSeikyuJohoPanel;
    @JsonProperty("JutakuTesuryoSeikyuKetteiPanel")
    private JutakuTesuryoSeikyuKetteiPanelDiv JutakuTesuryoSeikyuKetteiPanel;
    @JsonProperty("JutakuTesuryoSeikyuShosaiPanel")
    private JutakuTesuryoSeikyuShosaiPanelDiv JutakuTesuryoSeikyuShosaiPanel;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchJutakuTesuryoSeikyuJohoPanel
     * @return SearchJutakuTesuryoSeikyuJohoPanel
     */
    @JsonProperty("SearchJutakuTesuryoSeikyuJohoPanel")
    public SearchJutakuTesuryoSeikyuJohoPanelDiv getSearchJutakuTesuryoSeikyuJohoPanel() {
        return SearchJutakuTesuryoSeikyuJohoPanel;
    }

    /*
     * setSearchJutakuTesuryoSeikyuJohoPanel
     * @param SearchJutakuTesuryoSeikyuJohoPanel SearchJutakuTesuryoSeikyuJohoPanel
     */
    @JsonProperty("SearchJutakuTesuryoSeikyuJohoPanel")
    public void setSearchJutakuTesuryoSeikyuJohoPanel(SearchJutakuTesuryoSeikyuJohoPanelDiv SearchJutakuTesuryoSeikyuJohoPanel) {
        this.SearchJutakuTesuryoSeikyuJohoPanel = SearchJutakuTesuryoSeikyuJohoPanel;
    }

    /*
     * getJutakuTesuryoSeikyuKetteiPanel
     * @return JutakuTesuryoSeikyuKetteiPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuKetteiPanel")
    public JutakuTesuryoSeikyuKetteiPanelDiv getJutakuTesuryoSeikyuKetteiPanel() {
        return JutakuTesuryoSeikyuKetteiPanel;
    }

    /*
     * setJutakuTesuryoSeikyuKetteiPanel
     * @param JutakuTesuryoSeikyuKetteiPanel JutakuTesuryoSeikyuKetteiPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuKetteiPanel")
    public void setJutakuTesuryoSeikyuKetteiPanel(JutakuTesuryoSeikyuKetteiPanelDiv JutakuTesuryoSeikyuKetteiPanel) {
        this.JutakuTesuryoSeikyuKetteiPanel = JutakuTesuryoSeikyuKetteiPanel;
    }

    /*
     * getJutakuTesuryoSeikyuShosaiPanel
     * @return JutakuTesuryoSeikyuShosaiPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuShosaiPanel")
    public JutakuTesuryoSeikyuShosaiPanelDiv getJutakuTesuryoSeikyuShosaiPanel() {
        return JutakuTesuryoSeikyuShosaiPanel;
    }

    /*
     * setJutakuTesuryoSeikyuShosaiPanel
     * @param JutakuTesuryoSeikyuShosaiPanel JutakuTesuryoSeikyuShosaiPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuShosaiPanel")
    public void setJutakuTesuryoSeikyuShosaiPanel(JutakuTesuryoSeikyuShosaiPanelDiv JutakuTesuryoSeikyuShosaiPanel) {
        this.JutakuTesuryoSeikyuShosaiPanel = JutakuTesuryoSeikyuShosaiPanel;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtSerchJigyosyaNo() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaNo();
    }

    @JsonIgnore
    public void  setTxtSerchJigyosyaNo(TextBox txtSerchJigyosyaNo) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setTxtSerchJigyosyaNo(txtSerchJigyosyaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getBtnJigyoshaInputGuide();
    }

    @JsonIgnore
    public void  setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setBtnJigyoshaInputGuide(btnJigyoshaInputGuide);
    }

    @JsonIgnore
    public TextBox getTxtSerchJigyosyaName() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSerchJigyosyaName();
    }

    @JsonIgnore
    public void  setTxtSerchJigyosyaName(TextBox txtSerchJigyosyaName) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setTxtSerchJigyosyaName(txtSerchJigyosyaName);
    }

    @JsonIgnore
    public TextBoxDate getTxtSearchSakuseiYM() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getTxtSearchSakuseiYM();
    }

    @JsonIgnore
    public void  setTxtSearchSakuseiYM(TextBoxDate txtSearchSakuseiYM) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setTxtSearchSakuseiYM(txtSearchSakuseiYM);
    }

    @JsonIgnore
    public CheckBoxList getChkSerchKetteiZumi() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getChkSerchKetteiZumi();
    }

    @JsonIgnore
    public void  setChkSerchKetteiZumi(CheckBoxList chkSerchKetteiZumi) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setChkSerchKetteiZumi(chkSerchKetteiZumi);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuJohoPanelDiv getJutakuTesuryoSeikyuJohoPanel() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getJutakuTesuryoSeikyuJohoPanel();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuJohoPanel(JutakuTesuryoSeikyuJohoPanelDiv JutakuTesuryoSeikyuJohoPanel) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().setJutakuTesuryoSeikyuJohoPanel(JutakuTesuryoSeikyuJohoPanel);
    }

    @JsonIgnore
    public DataGrid<dgSeikyu_Row> getDgSeikyu() {
        return this.getSearchJutakuTesuryoSeikyuJohoPanel().getJutakuTesuryoSeikyuJohoPanel().getDgSeikyu();
    }

    @JsonIgnore
    public void  setDgSeikyu(DataGrid<dgSeikyu_Row> dgSeikyu) {
        this.getSearchJutakuTesuryoSeikyuJohoPanel().getJutakuTesuryoSeikyuJohoPanel().setDgSeikyu(dgSeikyu);
    }

    @JsonIgnore
    public tblSeikyuKetteiDiv getTblSeikyuKettei() {
        return this.getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei();
    }

    @JsonIgnore
    public void  setTblSeikyuKettei(tblSeikyuKetteiDiv tblSeikyuKettei) {
        this.getJutakuTesuryoSeikyuKetteiPanel().setTblSeikyuKettei(tblSeikyuKettei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getTxtKetteiYMD();
    }

    @JsonIgnore
    public RadioButton getRadShikyuFushikyuKubun() {
        return this.getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getRadShikyuFushikyuKubun();
    }

    @JsonIgnore
    public TextBoxDate getTxtTesuryoShiharaiYoteiYMD() {
        return this.getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getTxtTesuryoShiharaiYoteiYMD();
    }

    @JsonIgnore
    public Space getSpaSeikyuKettei() {
        return this.getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getSpaSeikyuKettei();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return this.getJutakuTesuryoSeikyuKetteiPanel().getTblSeikyuKettei().getTxtFushikyuRiyu();
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyoshaNo() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void  setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void  setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public TextBox getTxtSeikyuSakuseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtSeikyuSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtSeikyuSakuseiYMD(TextBox txtSeikyuSakuseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtSeikyuSakuseiYMD(txtSeikyuSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtHdnShikibetsuCode() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtHdnShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtHdnShikibetsuCode(TextBoxCode txtHdnShikibetsuCode) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtHdnShikibetsuCode(txtHdnShikibetsuCode);
    }

    @JsonIgnore
    public DropDownList getDdlKozaShubetsu() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getDdlKozaShubetsu();
    }

    @JsonIgnore
    public void  setDdlKozaShubetsu(DropDownList ddlKozaShubetsu) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setDdlKozaShubetsu(ddlKozaShubetsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKozaNo() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNo();
    }

    @JsonIgnore
    public void  setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtKozaNo(txtKozaNo);
    }

    @JsonIgnore
    public TextBoxKana getTxtKozaNameKana() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaNameKana();
    }

    @JsonIgnore
    public void  setTxtKozaNameKana(TextBoxKana txtKozaNameKana) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtKozaNameKana(txtKozaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtKozaName() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getTxtKozaName();
    }

    @JsonIgnore
    public void  setTxtKozaName(TextBox txtKozaName) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setTxtKozaName(txtKozaName);
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuMeisaiDiv getJutakuTesuryoSeikyuMeisai() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuMeisai(JutakuTesuryoSeikyuMeisaiDiv JutakuTesuryoSeikyuMeisai) {
        this.getJutakuTesuryoSeikyuShosaiPanel().setJutakuTesuryoSeikyuMeisai(JutakuTesuryoSeikyuMeisai);
    }

    @JsonIgnore
    public DataGrid<dgSeikyuMeisai_Row> getDgSeikyuMeisai() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getDgSeikyuMeisai();
    }

    @JsonIgnore
    public void  setDgSeikyuMeisai(DataGrid<dgSeikyuMeisai_Row> dgSeikyuMeisai) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().setDgSeikyuMeisai(dgSeikyuMeisai);
    }

    @JsonIgnore
    public SeikyuMeisaiShosaiPanelDiv getSeikyuMeisaiShosaiPanel() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel();
    }

    @JsonIgnore
    public void  setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanelDiv SeikyuMeisaiShosaiPanel) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanel);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JutakuKaishuRiyushoPanelDiv getJutakuKaishuRiyushoPanel() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanelDiv JutakuKaishuRiyushoPanel) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtRiyushoSakuseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiYMD(TextBoxDate txtRiyushoSakuseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseiYMD(txtRiyushoSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxKana getTxtRiyushoSakuseishaMeiKana() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMeiKana(TextBoxKana txtRiyushoSakuseishaMeiKana) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMeiKana(txtRiyushoSakuseishaMeiKana);
    }

    @JsonIgnore
    public TextBox getTxtRiyushoSakuseishaMei() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMei(TextBox txtRiyushoSakuseishaMei) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMei(txtRiyushoSakuseishaMei);
    }

    @JsonIgnore
    public JutakuKaishuPanelDiv getJutakuKaishuPanel() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuPanel(JutakuKaishuPanelDiv JutakuKaishuPanel) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().setJutakuKaishuPanel(JutakuKaishuPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishuShikyuShinseiYMD() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishuShikyuShinseiYMD(TextBoxDate txtKaishuShikyuShinseiYMD) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuShikyuShinseiYMD(txtKaishuShikyuShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJutakuKaishuChakkoYMD() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuChakkoYMD(TextBoxDate txtJutakuKaishuChakkoYMD) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuChakkoYMD(txtJutakuKaishuChakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtJutakuKaishuJigyoshaMeisho() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuJigyoshaMeisho(TextBox txtJutakuKaishuJigyoshaMeisho) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuJigyoshaMeisho(txtJutakuKaishuJigyoshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKaishuTaishoJutakuJusho() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho();
    }

    @JsonIgnore
    public void  setTxtKaishuTaishoJutakuJusho(TextBox txtKaishuTaishoJutakuJusho) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuTaishoJutakuJusho(txtKaishuTaishoJutakuJusho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKaishuNaiyokashoKibo() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo();
    }

    @JsonIgnore
    public void  setTxtKaishuNaiyokashoKibo(TextBoxMultiLine txtKaishuNaiyokashoKibo) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuNaiyokashoKibo(txtKaishuNaiyokashoKibo);
    }

    @JsonIgnore
    public JutakuTesuryoSeikyuShukeiPanelDiv getJutakuTesuryoSeikyuShukeiPanel() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel();
    }

    @JsonIgnore
    public void  setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanelDiv JutakuTesuryoSeikyuShukeiPanel) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiTanka() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiTanka(TextBoxNum txtRiyushoSakuseiTanka) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiTanka(txtRiyushoSakuseiTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiKensu() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiKensu(TextBoxNum txtRiyushoSakuseiKensu) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiKensu(txtRiyushoSakuseiKensu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiSeikyuKingaku() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiSeikyuKingaku(TextBoxNum txtRiyushoSakuseiSeikyuKingaku) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiSeikyuKingaku(txtRiyushoSakuseiSeikyuKingaku);
    }

    @JsonIgnore
    public Button getBtnShukei() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().getBtnShukei();
    }

    @JsonIgnore
    public void  setBtnShukei(Button btnShukei) {
        this.getJutakuTesuryoSeikyuShosaiPanel().getJutakuTesuryoSeikyuMeisai().getJutakuTesuryoSeikyuShukeiPanel().setBtnShukei(btnShukei);
    }

    @JsonIgnore
    public IKinyuKikanInputDiv getCcdKinyuKikanInput() {
        return this.getJutakuTesuryoSeikyuShosaiPanel().getCcdKinyuKikanInput();
    }

    // </editor-fold>
}

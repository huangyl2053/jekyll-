package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
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
 * JutakuTesuryoSeikyuMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuTesuryoSeikyuMeisaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSeikyuMeisai")
    private DataGrid<dgSeikyuMeisai_Row> dgSeikyuMeisai;
    @JsonProperty("SeikyuMeisaiShosaiPanel")
    private SeikyuMeisaiShosaiPanelDiv SeikyuMeisaiShosaiPanel;
    @JsonProperty("JutakuTesuryoSeikyuShukeiPanel")
    private JutakuTesuryoSeikyuShukeiPanelDiv JutakuTesuryoSeikyuShukeiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgSeikyuMeisai
     * @return dgSeikyuMeisai
     */
    @JsonProperty("dgSeikyuMeisai")
    public DataGrid<dgSeikyuMeisai_Row> getDgSeikyuMeisai() {
        return dgSeikyuMeisai;
    }

    /*
     * setdgSeikyuMeisai
     * @param dgSeikyuMeisai dgSeikyuMeisai
     */
    @JsonProperty("dgSeikyuMeisai")
    public void setDgSeikyuMeisai(DataGrid<dgSeikyuMeisai_Row> dgSeikyuMeisai) {
        this.dgSeikyuMeisai = dgSeikyuMeisai;
    }

    /*
     * getSeikyuMeisaiShosaiPanel
     * @return SeikyuMeisaiShosaiPanel
     */
    @JsonProperty("SeikyuMeisaiShosaiPanel")
    public SeikyuMeisaiShosaiPanelDiv getSeikyuMeisaiShosaiPanel() {
        return SeikyuMeisaiShosaiPanel;
    }

    /*
     * setSeikyuMeisaiShosaiPanel
     * @param SeikyuMeisaiShosaiPanel SeikyuMeisaiShosaiPanel
     */
    @JsonProperty("SeikyuMeisaiShosaiPanel")
    public void setSeikyuMeisaiShosaiPanel(SeikyuMeisaiShosaiPanelDiv SeikyuMeisaiShosaiPanel) {
        this.SeikyuMeisaiShosaiPanel = SeikyuMeisaiShosaiPanel;
    }

    /*
     * getJutakuTesuryoSeikyuShukeiPanel
     * @return JutakuTesuryoSeikyuShukeiPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuShukeiPanel")
    public JutakuTesuryoSeikyuShukeiPanelDiv getJutakuTesuryoSeikyuShukeiPanel() {
        return JutakuTesuryoSeikyuShukeiPanel;
    }

    /*
     * setJutakuTesuryoSeikyuShukeiPanel
     * @param JutakuTesuryoSeikyuShukeiPanel JutakuTesuryoSeikyuShukeiPanel
     */
    @JsonProperty("JutakuTesuryoSeikyuShukeiPanel")
    public void setJutakuTesuryoSeikyuShukeiPanel(JutakuTesuryoSeikyuShukeiPanelDiv JutakuTesuryoSeikyuShukeiPanel) {
        this.JutakuTesuryoSeikyuShukeiPanel = JutakuTesuryoSeikyuShukeiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getSeikyuMeisaiShosaiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getSeikyuMeisaiShosaiPanel().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void  setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getSeikyuMeisaiShosaiPanel().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JutakuKaishuRiyushoPanelDiv getJutakuKaishuRiyushoPanel() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanelDiv JutakuKaishuRiyushoPanel) {
        this.getSeikyuMeisaiShosaiPanel().setJutakuKaishuRiyushoPanel(JutakuKaishuRiyushoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtRiyushoSakuseiYMD() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiYMD(TextBoxDate txtRiyushoSakuseiYMD) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseiYMD(txtRiyushoSakuseiYMD);
    }

    @JsonIgnore
    public TextBoxKana getTxtRiyushoSakuseishaMeiKana() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMeiKana();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMeiKana(TextBoxKana txtRiyushoSakuseishaMeiKana) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMeiKana(txtRiyushoSakuseishaMeiKana);
    }

    @JsonIgnore
    public TextBox getTxtRiyushoSakuseishaMei() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().getTxtRiyushoSakuseishaMei();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseishaMei(TextBox txtRiyushoSakuseishaMei) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuRiyushoPanel().setTxtRiyushoSakuseishaMei(txtRiyushoSakuseishaMei);
    }

    @JsonIgnore
    public JutakuKaishuPanelDiv getJutakuKaishuPanel() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel();
    }

    @JsonIgnore
    public void  setJutakuKaishuPanel(JutakuKaishuPanelDiv JutakuKaishuPanel) {
        this.getSeikyuMeisaiShosaiPanel().setJutakuKaishuPanel(JutakuKaishuPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishuShikyuShinseiYMD() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuShikyuShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtKaishuShikyuShinseiYMD(TextBoxDate txtKaishuShikyuShinseiYMD) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuShikyuShinseiYMD(txtKaishuShikyuShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtJutakuKaishuChakkoYMD() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuChakkoYMD();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuChakkoYMD(TextBoxDate txtJutakuKaishuChakkoYMD) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuChakkoYMD(txtJutakuKaishuChakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtJutakuKaishuJigyoshaMeisho() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtJutakuKaishuJigyoshaMeisho();
    }

    @JsonIgnore
    public void  setTxtJutakuKaishuJigyoshaMeisho(TextBox txtJutakuKaishuJigyoshaMeisho) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtJutakuKaishuJigyoshaMeisho(txtJutakuKaishuJigyoshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKaishuTaishoJutakuJusho() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuTaishoJutakuJusho();
    }

    @JsonIgnore
    public void  setTxtKaishuTaishoJutakuJusho(TextBox txtKaishuTaishoJutakuJusho) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuTaishoJutakuJusho(txtKaishuTaishoJutakuJusho);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKaishuNaiyokashoKibo() {
        return this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().getTxtKaishuNaiyokashoKibo();
    }

    @JsonIgnore
    public void  setTxtKaishuNaiyokashoKibo(TextBoxMultiLine txtKaishuNaiyokashoKibo) {
        this.getSeikyuMeisaiShosaiPanel().getJutakuKaishuPanel().setTxtKaishuNaiyokashoKibo(txtKaishuNaiyokashoKibo);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiTanka() {
        return this.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiTanka();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiTanka(TextBoxNum txtRiyushoSakuseiTanka) {
        this.getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiTanka(txtRiyushoSakuseiTanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiKensu() {
        return this.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiKensu();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiKensu(TextBoxNum txtRiyushoSakuseiKensu) {
        this.getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiKensu(txtRiyushoSakuseiKensu);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyushoSakuseiSeikyuKingaku() {
        return this.getJutakuTesuryoSeikyuShukeiPanel().getTxtRiyushoSakuseiSeikyuKingaku();
    }

    @JsonIgnore
    public void  setTxtRiyushoSakuseiSeikyuKingaku(TextBoxNum txtRiyushoSakuseiSeikyuKingaku) {
        this.getJutakuTesuryoSeikyuShukeiPanel().setTxtRiyushoSakuseiSeikyuKingaku(txtRiyushoSakuseiSeikyuKingaku);
    }

    @JsonIgnore
    public Button getBtnShukei() {
        return this.getJutakuTesuryoSeikyuShukeiPanel().getBtnShukei();
    }

    @JsonIgnore
    public void  setBtnShukei(Button btnShukei) {
        this.getJutakuTesuryoSeikyuShukeiPanel().setBtnShukei(btnShukei);
    }

    // </editor-fold>
}

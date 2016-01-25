package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810025;
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
 * panelTokutei のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelTokuteiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgdTokuteiYichiran")
    private DataGrid<dgdTokuteiYichiran_Row> dgdTokuteiYichiran;
    @JsonProperty("lblGokei")
    private Label lblGokei;
    @JsonProperty("txtHiyogakuTotal")
    private TextBoxNum txtHiyogakuTotal;
    @JsonProperty("txtHokenbunTotal")
    private TextBoxNum txtHokenbunTotal;
    @JsonProperty("txtRiyoshaFutangakuTotal")
    private TextBoxNum txtRiyoshaFutangakuTotal;
    @JsonProperty("panelMeisai")
    private panelMeisaiDiv panelMeisai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgdTokuteiYichiran
     * @return dgdTokuteiYichiran
     */
    @JsonProperty("dgdTokuteiYichiran")
    public DataGrid<dgdTokuteiYichiran_Row> getDgdTokuteiYichiran() {
        return dgdTokuteiYichiran;
    }

    /*
     * setdgdTokuteiYichiran
     * @param dgdTokuteiYichiran dgdTokuteiYichiran
     */
    @JsonProperty("dgdTokuteiYichiran")
    public void setDgdTokuteiYichiran(DataGrid<dgdTokuteiYichiran_Row> dgdTokuteiYichiran) {
        this.dgdTokuteiYichiran = dgdTokuteiYichiran;
    }

    /*
     * getlblGokei
     * @return lblGokei
     */
    @JsonProperty("lblGokei")
    public Label getLblGokei() {
        return lblGokei;
    }

    /*
     * setlblGokei
     * @param lblGokei lblGokei
     */
    @JsonProperty("lblGokei")
    public void setLblGokei(Label lblGokei) {
        this.lblGokei = lblGokei;
    }

    /*
     * gettxtHiyogakuTotal
     * @return txtHiyogakuTotal
     */
    @JsonProperty("txtHiyogakuTotal")
    public TextBoxNum getTxtHiyogakuTotal() {
        return txtHiyogakuTotal;
    }

    /*
     * settxtHiyogakuTotal
     * @param txtHiyogakuTotal txtHiyogakuTotal
     */
    @JsonProperty("txtHiyogakuTotal")
    public void setTxtHiyogakuTotal(TextBoxNum txtHiyogakuTotal) {
        this.txtHiyogakuTotal = txtHiyogakuTotal;
    }

    /*
     * gettxtHokenbunTotal
     * @return txtHokenbunTotal
     */
    @JsonProperty("txtHokenbunTotal")
    public TextBoxNum getTxtHokenbunTotal() {
        return txtHokenbunTotal;
    }

    /*
     * settxtHokenbunTotal
     * @param txtHokenbunTotal txtHokenbunTotal
     */
    @JsonProperty("txtHokenbunTotal")
    public void setTxtHokenbunTotal(TextBoxNum txtHokenbunTotal) {
        this.txtHokenbunTotal = txtHokenbunTotal;
    }

    /*
     * gettxtRiyoshaFutangakuTotal
     * @return txtRiyoshaFutangakuTotal
     */
    @JsonProperty("txtRiyoshaFutangakuTotal")
    public TextBoxNum getTxtRiyoshaFutangakuTotal() {
        return txtRiyoshaFutangakuTotal;
    }

    /*
     * settxtRiyoshaFutangakuTotal
     * @param txtRiyoshaFutangakuTotal txtRiyoshaFutangakuTotal
     */
    @JsonProperty("txtRiyoshaFutangakuTotal")
    public void setTxtRiyoshaFutangakuTotal(TextBoxNum txtRiyoshaFutangakuTotal) {
        this.txtRiyoshaFutangakuTotal = txtRiyoshaFutangakuTotal;
    }

    /*
     * getpanelMeisai
     * @return panelMeisai
     */
    @JsonProperty("panelMeisai")
    public panelMeisaiDiv getPanelMeisai() {
        return panelMeisai;
    }

    /*
     * setpanelMeisai
     * @param panelMeisai panelMeisai
     */
    @JsonProperty("panelMeisai")
    public void setPanelMeisai(panelMeisaiDiv panelMeisai) {
        this.panelMeisai = panelMeisai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtServiceCodeShuruyi() {
        return this.getPanelMeisai().getTxtServiceCodeShuruyi();
    }

    @JsonIgnore
    public void  setTxtServiceCodeShuruyi(TextBoxCode txtServiceCodeShuruyi) {
        this.getPanelMeisai().setTxtServiceCodeShuruyi(txtServiceCodeShuruyi);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCodeKoumoku() {
        return this.getPanelMeisai().getTxtServiceCodeKoumoku();
    }

    @JsonIgnore
    public void  setTxtServiceCodeKoumoku(TextBoxCode txtServiceCodeKoumoku) {
        this.getPanelMeisai().setTxtServiceCodeKoumoku(txtServiceCodeKoumoku);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelMeisai().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelMeisai().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojyuntanka() {
        return this.getPanelMeisai().getTxtHyojyuntanka();
    }

    @JsonIgnore
    public void  setTxtHyojyuntanka(TextBoxNum txtHyojyuntanka) {
        this.getPanelMeisai().setTxtHyojyuntanka(txtHyojyuntanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutangenndogaku() {
        return this.getPanelMeisai().getTxtFutangenndogaku();
    }

    @JsonIgnore
    public void  setTxtFutangenndogaku(TextBoxNum txtFutangenndogaku) {
        this.getPanelMeisai().setTxtFutangenndogaku(txtFutangenndogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNisu() {
        return this.getPanelMeisai().getTxtNisu();
    }

    @JsonIgnore
    public void  setTxtNisu(TextBoxNum txtNisu) {
        this.getPanelMeisai().setTxtNisu(txtNisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyogaku() {
        return this.getPanelMeisai().getTxtHiyogaku();
    }

    @JsonIgnore
    public void  setTxtHiyogaku(TextBoxNum txtHiyogaku) {
        this.getPanelMeisai().setTxtHiyogaku(txtHiyogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenbun() {
        return this.getPanelMeisai().getTxtHokenbun();
    }

    @JsonIgnore
    public void  setTxtHokenbun(TextBoxNum txtHokenbun) {
        this.getPanelMeisai().setTxtHokenbun(txtHokenbun);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshafutangaku() {
        return this.getPanelMeisai().getTxtRiyoshafutangaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshafutangaku(TextBoxNum txtRiyoshafutangaku) {
        this.getPanelMeisai().setTxtRiyoshafutangaku(txtRiyoshafutangaku);
    }

    @JsonIgnore
    public HorizontalLine getHlThree() {
        return this.getPanelMeisai().getHlThree();
    }

    @JsonIgnore
    public void  setHlThree(HorizontalLine hlThree) {
        this.getPanelMeisai().setHlThree(hlThree);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiGaku() {
        return this.getPanelMeisai().getTxtTanyiGaku();
    }

    @JsonIgnore
    public void  setTxtTanyiGaku(TextBoxNum txtTanyiGaku) {
        this.getPanelMeisai().setTxtTanyiGaku(txtTanyiGaku);
    }

    @JsonIgnore
    public TextBox getTxtShikyukubun() {
        return this.getPanelMeisai().getTxtShikyukubun();
    }

    @JsonIgnore
    public void  setTxtShikyukubun(TextBox txtShikyukubun) {
        this.getPanelMeisai().setTxtShikyukubun(txtShikyukubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiGaku() {
        return this.getPanelMeisai().getTxtShiharaiGaku();
    }

    @JsonIgnore
    public void  setTxtShiharaiGaku(TextBoxNum txtShiharaiGaku) {
        this.getPanelMeisai().setTxtShiharaiGaku(txtShiharaiGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZogenten() {
        return this.getPanelMeisai().getTxtZogenten();
    }

    @JsonIgnore
    public void  setTxtZogenten(TextBoxNum txtZogenten) {
        this.getPanelMeisai().setTxtZogenten(txtZogenten);
    }

    @JsonIgnore
    public Button getBtnclose() {
        return this.getPanelMeisai().getBtnclose();
    }

    @JsonIgnore
    public void  setBtnclose(Button btnclose) {
        this.getPanelMeisai().setBtnclose(btnclose);
    }

    // </editor-fold>
}

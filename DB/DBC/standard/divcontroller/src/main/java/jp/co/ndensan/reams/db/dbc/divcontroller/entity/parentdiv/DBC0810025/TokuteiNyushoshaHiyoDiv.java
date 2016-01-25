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
 * TokuteiNyushoshaHiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiNyushoshaHiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelTokutei")
    private panelTokuteiDiv panelTokutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
    }

    /*
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpanelTokutei
     * @return panelTokutei
     */
    @JsonProperty("panelTokutei")
    public panelTokuteiDiv getPanelTokutei() {
        return panelTokutei;
    }

    /*
     * setpanelTokutei
     * @param panelTokutei panelTokutei
     */
    @JsonProperty("panelTokutei")
    public void setPanelTokutei(panelTokuteiDiv panelTokutei) {
        this.panelTokutei = panelTokutei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgdTokuteiYichiran_Row> getDgdTokuteiYichiran() {
        return this.getPanelTokutei().getDgdTokuteiYichiran();
    }

    @JsonIgnore
    public void  setDgdTokuteiYichiran(DataGrid<dgdTokuteiYichiran_Row> dgdTokuteiYichiran) {
        this.getPanelTokutei().setDgdTokuteiYichiran(dgdTokuteiYichiran);
    }

    @JsonIgnore
    public Label getLblGokei() {
        return this.getPanelTokutei().getLblGokei();
    }

    @JsonIgnore
    public void  setLblGokei(Label lblGokei) {
        this.getPanelTokutei().setLblGokei(lblGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyogakuTotal() {
        return this.getPanelTokutei().getTxtHiyogakuTotal();
    }

    @JsonIgnore
    public void  setTxtHiyogakuTotal(TextBoxNum txtHiyogakuTotal) {
        this.getPanelTokutei().setTxtHiyogakuTotal(txtHiyogakuTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenbunTotal() {
        return this.getPanelTokutei().getTxtHokenbunTotal();
    }

    @JsonIgnore
    public void  setTxtHokenbunTotal(TextBoxNum txtHokenbunTotal) {
        this.getPanelTokutei().setTxtHokenbunTotal(txtHokenbunTotal);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutangakuTotal() {
        return this.getPanelTokutei().getTxtRiyoshaFutangakuTotal();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutangakuTotal(TextBoxNum txtRiyoshaFutangakuTotal) {
        this.getPanelTokutei().setTxtRiyoshaFutangakuTotal(txtRiyoshaFutangakuTotal);
    }

    @JsonIgnore
    public panelMeisaiDiv getPanelMeisai() {
        return this.getPanelTokutei().getPanelMeisai();
    }

    @JsonIgnore
    public void  setPanelMeisai(panelMeisaiDiv panelMeisai) {
        this.getPanelTokutei().setPanelMeisai(panelMeisai);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCodeShuruyi() {
        return this.getPanelTokutei().getPanelMeisai().getTxtServiceCodeShuruyi();
    }

    @JsonIgnore
    public void  setTxtServiceCodeShuruyi(TextBoxCode txtServiceCodeShuruyi) {
        this.getPanelTokutei().getPanelMeisai().setTxtServiceCodeShuruyi(txtServiceCodeShuruyi);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCodeKoumoku() {
        return this.getPanelTokutei().getPanelMeisai().getTxtServiceCodeKoumoku();
    }

    @JsonIgnore
    public void  setTxtServiceCodeKoumoku(TextBoxCode txtServiceCodeKoumoku) {
        this.getPanelTokutei().getPanelMeisai().setTxtServiceCodeKoumoku(txtServiceCodeKoumoku);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelTokutei().getPanelMeisai().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelTokutei().getPanelMeisai().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojyuntanka() {
        return this.getPanelTokutei().getPanelMeisai().getTxtHyojyuntanka();
    }

    @JsonIgnore
    public void  setTxtHyojyuntanka(TextBoxNum txtHyojyuntanka) {
        this.getPanelTokutei().getPanelMeisai().setTxtHyojyuntanka(txtHyojyuntanka);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutangenndogaku() {
        return this.getPanelTokutei().getPanelMeisai().getTxtFutangenndogaku();
    }

    @JsonIgnore
    public void  setTxtFutangenndogaku(TextBoxNum txtFutangenndogaku) {
        this.getPanelTokutei().getPanelMeisai().setTxtFutangenndogaku(txtFutangenndogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtNisu() {
        return this.getPanelTokutei().getPanelMeisai().getTxtNisu();
    }

    @JsonIgnore
    public void  setTxtNisu(TextBoxNum txtNisu) {
        this.getPanelTokutei().getPanelMeisai().setTxtNisu(txtNisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyogaku() {
        return this.getPanelTokutei().getPanelMeisai().getTxtHiyogaku();
    }

    @JsonIgnore
    public void  setTxtHiyogaku(TextBoxNum txtHiyogaku) {
        this.getPanelTokutei().getPanelMeisai().setTxtHiyogaku(txtHiyogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenbun() {
        return this.getPanelTokutei().getPanelMeisai().getTxtHokenbun();
    }

    @JsonIgnore
    public void  setTxtHokenbun(TextBoxNum txtHokenbun) {
        this.getPanelTokutei().getPanelMeisai().setTxtHokenbun(txtHokenbun);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshafutangaku() {
        return this.getPanelTokutei().getPanelMeisai().getTxtRiyoshafutangaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshafutangaku(TextBoxNum txtRiyoshafutangaku) {
        this.getPanelTokutei().getPanelMeisai().setTxtRiyoshafutangaku(txtRiyoshafutangaku);
    }

    @JsonIgnore
    public HorizontalLine getHlThree() {
        return this.getPanelTokutei().getPanelMeisai().getHlThree();
    }

    @JsonIgnore
    public void  setHlThree(HorizontalLine hlThree) {
        this.getPanelTokutei().getPanelMeisai().setHlThree(hlThree);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiGaku() {
        return this.getPanelTokutei().getPanelMeisai().getTxtTanyiGaku();
    }

    @JsonIgnore
    public void  setTxtTanyiGaku(TextBoxNum txtTanyiGaku) {
        this.getPanelTokutei().getPanelMeisai().setTxtTanyiGaku(txtTanyiGaku);
    }

    @JsonIgnore
    public TextBox getTxtShikyukubun() {
        return this.getPanelTokutei().getPanelMeisai().getTxtShikyukubun();
    }

    @JsonIgnore
    public void  setTxtShikyukubun(TextBox txtShikyukubun) {
        this.getPanelTokutei().getPanelMeisai().setTxtShikyukubun(txtShikyukubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiGaku() {
        return this.getPanelTokutei().getPanelMeisai().getTxtShiharaiGaku();
    }

    @JsonIgnore
    public void  setTxtShiharaiGaku(TextBoxNum txtShiharaiGaku) {
        this.getPanelTokutei().getPanelMeisai().setTxtShiharaiGaku(txtShiharaiGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZogenten() {
        return this.getPanelTokutei().getPanelMeisai().getTxtZogenten();
    }

    @JsonIgnore
    public void  setTxtZogenten(TextBoxNum txtZogenten) {
        this.getPanelTokutei().getPanelMeisai().setTxtZogenten(txtZogenten);
    }

    @JsonIgnore
    public Button getBtnclose() {
        return this.getPanelTokutei().getPanelMeisai().getBtnclose();
    }

    @JsonIgnore
    public void  setBtnclose(Button btnclose) {
        this.getPanelTokutei().getPanelMeisai().setBtnclose(btnclose);
    }

    // </editor-fold>
}

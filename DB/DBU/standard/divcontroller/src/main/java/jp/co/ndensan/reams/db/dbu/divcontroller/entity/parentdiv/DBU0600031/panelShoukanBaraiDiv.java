package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031;
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
 * panelShoukanBarai のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShoukanBaraiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelHukushiYouguJoho")
    private panelHukushiYouguJohoDiv panelHukushiYouguJoho;
    @JsonProperty("panelJuutakuKaishuuhi")
    private panelJuutakuKaishuuhiDiv panelJuutakuKaishuuhi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelHukushiYouguJoho
     * @return panelHukushiYouguJoho
     */
    @JsonProperty("panelHukushiYouguJoho")
    public panelHukushiYouguJohoDiv getPanelHukushiYouguJoho() {
        return panelHukushiYouguJoho;
    }

    /*
     * setpanelHukushiYouguJoho
     * @param panelHukushiYouguJoho panelHukushiYouguJoho
     */
    @JsonProperty("panelHukushiYouguJoho")
    public void setPanelHukushiYouguJoho(panelHukushiYouguJohoDiv panelHukushiYouguJoho) {
        this.panelHukushiYouguJoho = panelHukushiYouguJoho;
    }

    /*
     * getpanelJuutakuKaishuuhi
     * @return panelJuutakuKaishuuhi
     */
    @JsonProperty("panelJuutakuKaishuuhi")
    public panelJuutakuKaishuuhiDiv getPanelJuutakuKaishuuhi() {
        return panelJuutakuKaishuuhi;
    }

    /*
     * setpanelJuutakuKaishuuhi
     * @param panelJuutakuKaishuuhi panelJuutakuKaishuuhi
     */
    @JsonProperty("panelJuutakuKaishuuhi")
    public void setPanelJuutakuKaishuuhi(panelJuutakuKaishuuhiDiv panelJuutakuKaishuuhi) {
        this.panelJuutakuKaishuuhi = panelJuutakuKaishuuhi;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLabelMaeNando() {
        return this.getPanelHukushiYouguJoho().getLabelMaeNando();
    }

    @JsonIgnore
    public void  setLabelMaeNando(Label labelMaeNando) {
        this.getPanelHukushiYouguJoho().setLabelMaeNando(labelMaeNando);
    }

    @JsonIgnore
    public TextBox getTxtMaeNando() {
        return this.getPanelHukushiYouguJoho().getTxtMaeNando();
    }

    @JsonIgnore
    public void  setTxtMaeNando(TextBox txtMaeNando) {
        this.getPanelHukushiYouguJoho().setTxtMaeNando(txtMaeNando);
    }

    @JsonIgnore
    public TextBox getTxtMaeKingakuGoukei() {
        return this.getPanelHukushiYouguJoho().getTxtMaeKingakuGoukei();
    }

    @JsonIgnore
    public void  setTxtMaeKingakuGoukei(TextBox txtMaeKingakuGoukei) {
        this.getPanelHukushiYouguJoho().setTxtMaeKingakuGoukei(txtMaeKingakuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtMaeSeikyukuGoukei() {
        return this.getPanelHukushiYouguJoho().getTxtMaeSeikyukuGoukei();
    }

    @JsonIgnore
    public void  setTxtMaeSeikyukuGoukei(TextBox txtMaeSeikyukuGoukei) {
        this.getPanelHukushiYouguJoho().setTxtMaeSeikyukuGoukei(txtMaeSeikyukuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtMaeSeihutankuGoukei() {
        return this.getPanelHukushiYouguJoho().getTxtMaeSeihutankuGoukei();
    }

    @JsonIgnore
    public void  setTxtMaeSeihutankuGoukei(TextBox txtMaeSeihutankuGoukei) {
        this.getPanelHukushiYouguJoho().setTxtMaeSeihutankuGoukei(txtMaeSeihutankuGoukei);
    }

    @JsonIgnore
    public Label getLabelKonNando() {
        return this.getPanelHukushiYouguJoho().getLabelKonNando();
    }

    @JsonIgnore
    public void  setLabelKonNando(Label labelKonNando) {
        this.getPanelHukushiYouguJoho().setLabelKonNando(labelKonNando);
    }

    @JsonIgnore
    public TextBox getTxtKonNando() {
        return this.getPanelHukushiYouguJoho().getTxtKonNando();
    }

    @JsonIgnore
    public void  setTxtKonNando(TextBox txtKonNando) {
        this.getPanelHukushiYouguJoho().setTxtKonNando(txtKonNando);
    }

    @JsonIgnore
    public TextBox getTxtKonKingakuGoukei() {
        return this.getPanelHukushiYouguJoho().getTxtKonKingakuGoukei();
    }

    @JsonIgnore
    public void  setTxtKonKingakuGoukei(TextBox txtKonKingakuGoukei) {
        this.getPanelHukushiYouguJoho().setTxtKonKingakuGoukei(txtKonKingakuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtKonSeikyukuGoukei() {
        return this.getPanelHukushiYouguJoho().getTxtKonSeikyukuGoukei();
    }

    @JsonIgnore
    public void  setTxtKonSeikyukuGoukei(TextBox txtKonSeikyukuGoukei) {
        this.getPanelHukushiYouguJoho().setTxtKonSeikyukuGoukei(txtKonSeikyukuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtKonSeihutankuGoukei() {
        return this.getPanelHukushiYouguJoho().getTxtKonSeihutankuGoukei();
    }

    @JsonIgnore
    public void  setTxtKonSeihutankuGoukei(TextBox txtKonSeihutankuGoukei) {
        this.getPanelHukushiYouguJoho().setTxtKonSeihutankuGoukei(txtKonSeihutankuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtKaishuuHiyouGoukei() {
        return this.getPanelJuutakuKaishuuhi().getTxtKaishuuHiyouGoukei();
    }

    @JsonIgnore
    public void  setTxtKaishuuHiyouGoukei(TextBox txtKaishuuHiyouGoukei) {
        this.getPanelJuutakuKaishuuhi().setTxtKaishuuHiyouGoukei(txtKaishuuHiyouGoukei);
    }

    @JsonIgnore
    public TextBox getTxtHokenSeikyuGakuGoukei() {
        return this.getPanelJuutakuKaishuuhi().getTxtHokenSeikyuGakuGoukei();
    }

    @JsonIgnore
    public void  setTxtHokenSeikyuGakuGoukei(TextBox txtHokenSeikyuGakuGoukei) {
        this.getPanelJuutakuKaishuuhi().setTxtHokenSeikyuGakuGoukei(txtHokenSeikyuGakuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtRiyoushaHutanGakuGoukei() {
        return this.getPanelJuutakuKaishuuhi().getTxtRiyoushaHutanGakuGoukei();
    }

    @JsonIgnore
    public void  setTxtRiyoushaHutanGakuGoukei(TextBox txtRiyoushaHutanGakuGoukei) {
        this.getPanelJuutakuKaishuuhi().setTxtRiyoushaHutanGakuGoukei(txtRiyoushaHutanGakuGoukei);
    }

    // </editor-fold>
}

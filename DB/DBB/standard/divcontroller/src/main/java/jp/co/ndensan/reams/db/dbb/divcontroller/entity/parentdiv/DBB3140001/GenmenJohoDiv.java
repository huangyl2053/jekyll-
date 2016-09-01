package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GenmenJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenmenJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtUketsukeiYMD")
    private TextBoxDate txtUketsukeiYMD;
    @JsonProperty("btnGemmenShurui")
    private Button btnGemmenShurui;
    @JsonProperty("txtGemmenShurui")
    private TextBox txtGemmenShurui;
    @JsonProperty("txtGenmenRitsu")
    private TextBoxNum txtGenmenRitsu;
    @JsonProperty("lblPercent")
    private Label lblPercent;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtUketsukeiYMD
     * @return txtUketsukeiYMD
     */
    @JsonProperty("txtUketsukeiYMD")
    public TextBoxDate getTxtUketsukeiYMD() {
        return txtUketsukeiYMD;
    }

    /*
     * settxtUketsukeiYMD
     * @param txtUketsukeiYMD txtUketsukeiYMD
     */
    @JsonProperty("txtUketsukeiYMD")
    public void setTxtUketsukeiYMD(TextBoxDate txtUketsukeiYMD) {
        this.txtUketsukeiYMD = txtUketsukeiYMD;
    }

    /*
     * getbtnGemmenShurui
     * @return btnGemmenShurui
     */
    @JsonProperty("btnGemmenShurui")
    public Button getBtnGemmenShurui() {
        return btnGemmenShurui;
    }

    /*
     * setbtnGemmenShurui
     * @param btnGemmenShurui btnGemmenShurui
     */
    @JsonProperty("btnGemmenShurui")
    public void setBtnGemmenShurui(Button btnGemmenShurui) {
        this.btnGemmenShurui = btnGemmenShurui;
    }

    /*
     * gettxtGemmenShurui
     * @return txtGemmenShurui
     */
    @JsonProperty("txtGemmenShurui")
    public TextBox getTxtGemmenShurui() {
        return txtGemmenShurui;
    }

    /*
     * settxtGemmenShurui
     * @param txtGemmenShurui txtGemmenShurui
     */
    @JsonProperty("txtGemmenShurui")
    public void setTxtGemmenShurui(TextBox txtGemmenShurui) {
        this.txtGemmenShurui = txtGemmenShurui;
    }

    /*
     * gettxtGenmenRitsu
     * @return txtGenmenRitsu
     */
    @JsonProperty("txtGenmenRitsu")
    public TextBoxNum getTxtGenmenRitsu() {
        return txtGenmenRitsu;
    }

    /*
     * settxtGenmenRitsu
     * @param txtGenmenRitsu txtGenmenRitsu
     */
    @JsonProperty("txtGenmenRitsu")
    public void setTxtGenmenRitsu(TextBoxNum txtGenmenRitsu) {
        this.txtGenmenRitsu = txtGenmenRitsu;
    }

    /*
     * getlblPercent
     * @return lblPercent
     */
    @JsonProperty("lblPercent")
    public Label getLblPercent() {
        return lblPercent;
    }

    /*
     * setlblPercent
     * @param lblPercent lblPercent
     */
    @JsonProperty("lblPercent")
    public void setLblPercent(Label lblPercent) {
        this.lblPercent = lblPercent;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    // </editor-fold>
}

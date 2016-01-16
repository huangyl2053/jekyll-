package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0520011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyokaisoKariParam のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyokaisoKariParamDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKijunbi")
    private RadioButton radKijunbi;
    @JsonProperty("txtKijumbi")
    private TextBoxDate txtKijumbi;
    @JsonProperty("lblKyokaisoTourokusha")
    private Label lblKyokaisoTourokusha;
    @JsonProperty("radHani")
    private RadioButton radHani;
    @JsonProperty("radHaniRadio")
    private RadioButton radHaniRadio;
    @JsonProperty("txtHaniChushutsu")
    private TextBoxDateRange txtHaniChushutsu;
    @JsonProperty("radShiteiNashi")
    private RadioButton radShiteiNashi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKijunbi
     * @return radKijunbi
     */
    @JsonProperty("radKijunbi")
    public RadioButton getRadKijunbi() {
        return radKijunbi;
    }

    /*
     * setradKijunbi
     * @param radKijunbi radKijunbi
     */
    @JsonProperty("radKijunbi")
    public void setRadKijunbi(RadioButton radKijunbi) {
        this.radKijunbi = radKijunbi;
    }

    /*
     * gettxtKijumbi
     * @return txtKijumbi
     */
    @JsonProperty("txtKijumbi")
    public TextBoxDate getTxtKijumbi() {
        return txtKijumbi;
    }

    /*
     * settxtKijumbi
     * @param txtKijumbi txtKijumbi
     */
    @JsonProperty("txtKijumbi")
    public void setTxtKijumbi(TextBoxDate txtKijumbi) {
        this.txtKijumbi = txtKijumbi;
    }

    /*
     * getlblKyokaisoTourokusha
     * @return lblKyokaisoTourokusha
     */
    @JsonProperty("lblKyokaisoTourokusha")
    public Label getLblKyokaisoTourokusha() {
        return lblKyokaisoTourokusha;
    }

    /*
     * setlblKyokaisoTourokusha
     * @param lblKyokaisoTourokusha lblKyokaisoTourokusha
     */
    @JsonProperty("lblKyokaisoTourokusha")
    public void setLblKyokaisoTourokusha(Label lblKyokaisoTourokusha) {
        this.lblKyokaisoTourokusha = lblKyokaisoTourokusha;
    }

    /*
     * getradHani
     * @return radHani
     */
    @JsonProperty("radHani")
    public RadioButton getRadHani() {
        return radHani;
    }

    /*
     * setradHani
     * @param radHani radHani
     */
    @JsonProperty("radHani")
    public void setRadHani(RadioButton radHani) {
        this.radHani = radHani;
    }

    /*
     * getradHaniRadio
     * @return radHaniRadio
     */
    @JsonProperty("radHaniRadio")
    public RadioButton getRadHaniRadio() {
        return radHaniRadio;
    }

    /*
     * setradHaniRadio
     * @param radHaniRadio radHaniRadio
     */
    @JsonProperty("radHaniRadio")
    public void setRadHaniRadio(RadioButton radHaniRadio) {
        this.radHaniRadio = radHaniRadio;
    }

    /*
     * gettxtHaniChushutsu
     * @return txtHaniChushutsu
     */
    @JsonProperty("txtHaniChushutsu")
    public TextBoxDateRange getTxtHaniChushutsu() {
        return txtHaniChushutsu;
    }

    /*
     * settxtHaniChushutsu
     * @param txtHaniChushutsu txtHaniChushutsu
     */
    @JsonProperty("txtHaniChushutsu")
    public void setTxtHaniChushutsu(TextBoxDateRange txtHaniChushutsu) {
        this.txtHaniChushutsu = txtHaniChushutsu;
    }

    /*
     * getradShiteiNashi
     * @return radShiteiNashi
     */
    @JsonProperty("radShiteiNashi")
    public RadioButton getRadShiteiNashi() {
        return radShiteiNashi;
    }

    /*
     * setradShiteiNashi
     * @param radShiteiNashi radShiteiNashi
     */
    @JsonProperty("radShiteiNashi")
    public void setRadShiteiNashi(RadioButton radShiteiNashi) {
        this.radShiteiNashi = radShiteiNashi;
    }

    // </editor-fold>
}

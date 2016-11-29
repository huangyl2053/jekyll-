package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1141011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JikoFutangakuHoseiMadoguchi のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuHoseiMadoguchiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiharaiBasho")
    private TextBoxMultiLine txtShiharaiBasho;
    @JsonProperty("txtKaishiYMD")
    private TextBoxDate txtKaishiYMD;
    @JsonProperty("txtKaishiYoubi")
    private TextBox txtKaishiYoubi;
    @JsonProperty("txtKaishiJikanHH")
    private TextBoxNum txtKaishiJikanHH;
    @JsonProperty("txtKaishiJIkanMM")
    private TextBoxNum txtKaishiJIkanMM;
    @JsonProperty("txtShuryoYMD")
    private TextBoxDate txtShuryoYMD;
    @JsonProperty("txtShuryoYoubi")
    private TextBox txtShuryoYoubi;
    @JsonProperty("txtshuryoJikanHH")
    private TextBoxNum txtshuryoJikanHH;
    @JsonProperty("txtshuryoJikanMM")
    private TextBoxNum txtshuryoJikanMM;
    @JsonProperty("lblMadoguchiBaraiJoho")
    private Label lblMadoguchiBaraiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShiharaiBasho
     * @return txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBoxMultiLine getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    /*
     * settxtShiharaiBasho
     * @param txtShiharaiBasho txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBoxMultiLine txtShiharaiBasho) {
        this.txtShiharaiBasho = txtShiharaiBasho;
    }

    /*
     * gettxtKaishiYMD
     * @return txtKaishiYMD
     */
    @JsonProperty("txtKaishiYMD")
    public TextBoxDate getTxtKaishiYMD() {
        return txtKaishiYMD;
    }

    /*
     * settxtKaishiYMD
     * @param txtKaishiYMD txtKaishiYMD
     */
    @JsonProperty("txtKaishiYMD")
    public void setTxtKaishiYMD(TextBoxDate txtKaishiYMD) {
        this.txtKaishiYMD = txtKaishiYMD;
    }

    /*
     * gettxtKaishiYoubi
     * @return txtKaishiYoubi
     */
    @JsonProperty("txtKaishiYoubi")
    public TextBox getTxtKaishiYoubi() {
        return txtKaishiYoubi;
    }

    /*
     * settxtKaishiYoubi
     * @param txtKaishiYoubi txtKaishiYoubi
     */
    @JsonProperty("txtKaishiYoubi")
    public void setTxtKaishiYoubi(TextBox txtKaishiYoubi) {
        this.txtKaishiYoubi = txtKaishiYoubi;
    }

    /*
     * gettxtKaishiJikanHH
     * @return txtKaishiJikanHH
     */
    @JsonProperty("txtKaishiJikanHH")
    public TextBoxNum getTxtKaishiJikanHH() {
        return txtKaishiJikanHH;
    }

    /*
     * settxtKaishiJikanHH
     * @param txtKaishiJikanHH txtKaishiJikanHH
     */
    @JsonProperty("txtKaishiJikanHH")
    public void setTxtKaishiJikanHH(TextBoxNum txtKaishiJikanHH) {
        this.txtKaishiJikanHH = txtKaishiJikanHH;
    }

    /*
     * gettxtKaishiJIkanMM
     * @return txtKaishiJIkanMM
     */
    @JsonProperty("txtKaishiJIkanMM")
    public TextBoxNum getTxtKaishiJIkanMM() {
        return txtKaishiJIkanMM;
    }

    /*
     * settxtKaishiJIkanMM
     * @param txtKaishiJIkanMM txtKaishiJIkanMM
     */
    @JsonProperty("txtKaishiJIkanMM")
    public void setTxtKaishiJIkanMM(TextBoxNum txtKaishiJIkanMM) {
        this.txtKaishiJIkanMM = txtKaishiJIkanMM;
    }

    /*
     * gettxtShuryoYMD
     * @return txtShuryoYMD
     */
    @JsonProperty("txtShuryoYMD")
    public TextBoxDate getTxtShuryoYMD() {
        return txtShuryoYMD;
    }

    /*
     * settxtShuryoYMD
     * @param txtShuryoYMD txtShuryoYMD
     */
    @JsonProperty("txtShuryoYMD")
    public void setTxtShuryoYMD(TextBoxDate txtShuryoYMD) {
        this.txtShuryoYMD = txtShuryoYMD;
    }

    /*
     * gettxtShuryoYoubi
     * @return txtShuryoYoubi
     */
    @JsonProperty("txtShuryoYoubi")
    public TextBox getTxtShuryoYoubi() {
        return txtShuryoYoubi;
    }

    /*
     * settxtShuryoYoubi
     * @param txtShuryoYoubi txtShuryoYoubi
     */
    @JsonProperty("txtShuryoYoubi")
    public void setTxtShuryoYoubi(TextBox txtShuryoYoubi) {
        this.txtShuryoYoubi = txtShuryoYoubi;
    }

    /*
     * gettxtshuryoJikanHH
     * @return txtshuryoJikanHH
     */
    @JsonProperty("txtshuryoJikanHH")
    public TextBoxNum getTxtshuryoJikanHH() {
        return txtshuryoJikanHH;
    }

    /*
     * settxtshuryoJikanHH
     * @param txtshuryoJikanHH txtshuryoJikanHH
     */
    @JsonProperty("txtshuryoJikanHH")
    public void setTxtshuryoJikanHH(TextBoxNum txtshuryoJikanHH) {
        this.txtshuryoJikanHH = txtshuryoJikanHH;
    }

    /*
     * gettxtshuryoJikanMM
     * @return txtshuryoJikanMM
     */
    @JsonProperty("txtshuryoJikanMM")
    public TextBoxNum getTxtshuryoJikanMM() {
        return txtshuryoJikanMM;
    }

    /*
     * settxtshuryoJikanMM
     * @param txtshuryoJikanMM txtshuryoJikanMM
     */
    @JsonProperty("txtshuryoJikanMM")
    public void setTxtshuryoJikanMM(TextBoxNum txtshuryoJikanMM) {
        this.txtshuryoJikanMM = txtshuryoJikanMM;
    }

    /*
     * getlblMadoguchiBaraiJoho
     * @return lblMadoguchiBaraiJoho
     */
    @JsonProperty("lblMadoguchiBaraiJoho")
    public Label getLblMadoguchiBaraiJoho() {
        return lblMadoguchiBaraiJoho;
    }

    /*
     * setlblMadoguchiBaraiJoho
     * @param lblMadoguchiBaraiJoho lblMadoguchiBaraiJoho
     */
    @JsonProperty("lblMadoguchiBaraiJoho")
    public void setLblMadoguchiBaraiJoho(Label lblMadoguchiBaraiJoho) {
        this.lblMadoguchiBaraiJoho = lblMadoguchiBaraiJoho;
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuHani のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuHaniDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZenkaiTaishoYmdRange")
    private TextBoxDateRange txtZenkaiTaishoYmdRange;
    @JsonProperty("txtKonkaiTaishoYmdRange")
    private TextBoxDateRange txtKonkaiTaishoYmdRange;
    @JsonProperty("lbl01")
    private Label lbl01;
    @JsonProperty("txtKetteishaUketoriYmRange")
    private TextBoxDateRange txtKetteishaUketoriYmRange;
    @JsonProperty("radChushutsuTaisho")
    private RadioButton radChushutsuTaisho;
    @JsonProperty("txtTaishoSakuseiYMD")
    private TextBoxDate txtTaishoSakuseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZenkaiTaishoYmdRange
     * @return txtZenkaiTaishoYmdRange
     */
    @JsonProperty("txtZenkaiTaishoYmdRange")
    public TextBoxDateRange getTxtZenkaiTaishoYmdRange() {
        return txtZenkaiTaishoYmdRange;
    }

    /*
     * settxtZenkaiTaishoYmdRange
     * @param txtZenkaiTaishoYmdRange txtZenkaiTaishoYmdRange
     */
    @JsonProperty("txtZenkaiTaishoYmdRange")
    public void setTxtZenkaiTaishoYmdRange(TextBoxDateRange txtZenkaiTaishoYmdRange) {
        this.txtZenkaiTaishoYmdRange = txtZenkaiTaishoYmdRange;
    }

    /*
     * gettxtKonkaiTaishoYmdRange
     * @return txtKonkaiTaishoYmdRange
     */
    @JsonProperty("txtKonkaiTaishoYmdRange")
    public TextBoxDateRange getTxtKonkaiTaishoYmdRange() {
        return txtKonkaiTaishoYmdRange;
    }

    /*
     * settxtKonkaiTaishoYmdRange
     * @param txtKonkaiTaishoYmdRange txtKonkaiTaishoYmdRange
     */
    @JsonProperty("txtKonkaiTaishoYmdRange")
    public void setTxtKonkaiTaishoYmdRange(TextBoxDateRange txtKonkaiTaishoYmdRange) {
        this.txtKonkaiTaishoYmdRange = txtKonkaiTaishoYmdRange;
    }

    /*
     * getlbl01
     * @return lbl01
     */
    @JsonProperty("lbl01")
    public Label getLbl01() {
        return lbl01;
    }

    /*
     * setlbl01
     * @param lbl01 lbl01
     */
    @JsonProperty("lbl01")
    public void setLbl01(Label lbl01) {
        this.lbl01 = lbl01;
    }

    /*
     * gettxtKetteishaUketoriYmRange
     * @return txtKetteishaUketoriYmRange
     */
    @JsonProperty("txtKetteishaUketoriYmRange")
    public TextBoxDateRange getTxtKetteishaUketoriYmRange() {
        return txtKetteishaUketoriYmRange;
    }

    /*
     * settxtKetteishaUketoriYmRange
     * @param txtKetteishaUketoriYmRange txtKetteishaUketoriYmRange
     */
    @JsonProperty("txtKetteishaUketoriYmRange")
    public void setTxtKetteishaUketoriYmRange(TextBoxDateRange txtKetteishaUketoriYmRange) {
        this.txtKetteishaUketoriYmRange = txtKetteishaUketoriYmRange;
    }

    /*
     * getradChushutsuTaisho
     * @return radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public RadioButton getRadChushutsuTaisho() {
        return radChushutsuTaisho;
    }

    /*
     * setradChushutsuTaisho
     * @param radChushutsuTaisho radChushutsuTaisho
     */
    @JsonProperty("radChushutsuTaisho")
    public void setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.radChushutsuTaisho = radChushutsuTaisho;
    }

    /*
     * gettxtTaishoSakuseiYMD
     * @return txtTaishoSakuseiYMD
     */
    @JsonProperty("txtTaishoSakuseiYMD")
    public TextBoxDate getTxtTaishoSakuseiYMD() {
        return txtTaishoSakuseiYMD;
    }

    /*
     * settxtTaishoSakuseiYMD
     * @param txtTaishoSakuseiYMD txtTaishoSakuseiYMD
     */
    @JsonProperty("txtTaishoSakuseiYMD")
    public void setTxtTaishoSakuseiYMD(TextBoxDate txtTaishoSakuseiYMD) {
        this.txtTaishoSakuseiYMD = txtTaishoSakuseiYMD;
    }

    // </editor-fold>
}

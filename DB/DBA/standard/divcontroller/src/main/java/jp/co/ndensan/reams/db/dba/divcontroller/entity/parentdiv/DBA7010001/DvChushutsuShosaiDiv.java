package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvChushutsuShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvChushutsuShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKuhaku")
    private Label lblKuhaku;
    @JsonProperty("radKijunbiDate")
    private RadioButton radKijunbiDate;
    @JsonProperty("txtIryokikan")
    private TextBoxDateRange txtIryokikan;
    @JsonProperty("txtKijunDate")
    private TextBoxDate txtKijunDate;
    @JsonProperty("chkKijunDateNozoku")
    private CheckBoxList chkKijunDateNozoku;
    @JsonProperty("radHani")
    private RadioButton radHani;
    @JsonProperty("txtChushutsuHani")
    private TextBoxDateRange txtChushutsuHani;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblKuhaku
     * @return lblKuhaku
     */
    @JsonProperty("lblKuhaku")
    public Label getLblKuhaku() {
        return lblKuhaku;
    }

    /*
     * setlblKuhaku
     * @param lblKuhaku lblKuhaku
     */
    @JsonProperty("lblKuhaku")
    public void setLblKuhaku(Label lblKuhaku) {
        this.lblKuhaku = lblKuhaku;
    }

    /*
     * getradKijunbiDate
     * @return radKijunbiDate
     */
    @JsonProperty("radKijunbiDate")
    public RadioButton getRadKijunbiDate() {
        return radKijunbiDate;
    }

    /*
     * setradKijunbiDate
     * @param radKijunbiDate radKijunbiDate
     */
    @JsonProperty("radKijunbiDate")
    public void setRadKijunbiDate(RadioButton radKijunbiDate) {
        this.radKijunbiDate = radKijunbiDate;
    }

    /*
     * gettxtIryokikan
     * @return txtIryokikan
     */
    @JsonProperty("txtIryokikan")
    public TextBoxDateRange getTxtIryokikan() {
        return txtIryokikan;
    }

    /*
     * settxtIryokikan
     * @param txtIryokikan txtIryokikan
     */
    @JsonProperty("txtIryokikan")
    public void setTxtIryokikan(TextBoxDateRange txtIryokikan) {
        this.txtIryokikan = txtIryokikan;
    }

    /*
     * gettxtKijunDate
     * @return txtKijunDate
     */
    @JsonProperty("txtKijunDate")
    public TextBoxDate getTxtKijunDate() {
        return txtKijunDate;
    }

    /*
     * settxtKijunDate
     * @param txtKijunDate txtKijunDate
     */
    @JsonProperty("txtKijunDate")
    public void setTxtKijunDate(TextBoxDate txtKijunDate) {
        this.txtKijunDate = txtKijunDate;
    }

    /*
     * getchkKijunDateNozoku
     * @return chkKijunDateNozoku
     */
    @JsonProperty("chkKijunDateNozoku")
    public CheckBoxList getChkKijunDateNozoku() {
        return chkKijunDateNozoku;
    }

    /*
     * setchkKijunDateNozoku
     * @param chkKijunDateNozoku chkKijunDateNozoku
     */
    @JsonProperty("chkKijunDateNozoku")
    public void setChkKijunDateNozoku(CheckBoxList chkKijunDateNozoku) {
        this.chkKijunDateNozoku = chkKijunDateNozoku;
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
     * gettxtChushutsuHani
     * @return txtChushutsuHani
     */
    @JsonProperty("txtChushutsuHani")
    public TextBoxDateRange getTxtChushutsuHani() {
        return txtChushutsuHani;
    }

    /*
     * settxtChushutsuHani
     * @param txtChushutsuHani txtChushutsuHani
     */
    @JsonProperty("txtChushutsuHani")
    public void setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.txtChushutsuHani = txtChushutsuHani;
    }

    // </editor-fold>
}

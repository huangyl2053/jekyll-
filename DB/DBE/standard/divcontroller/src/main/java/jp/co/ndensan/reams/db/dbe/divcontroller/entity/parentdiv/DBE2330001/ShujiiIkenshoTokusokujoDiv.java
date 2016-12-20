package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.ShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIkenshoTokusokujo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoTokusokujoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtOverChosaIraiDay")
    private TextBoxNum txtOverChosaIraiDay;
    @JsonProperty("labOverChosaIraiDay")
    private Label labOverChosaIraiDay;
    @JsonProperty("txtKijunDay")
    private TextBoxDate txtKijunDay;
    @JsonProperty("chkInsatsuzumiTaisho")
    private CheckBoxList chkInsatsuzumiTaisho;
    @JsonProperty("radTokusokuHoho")
    private RadioButton radTokusokuHoho;
    @JsonProperty("txtTokusokuMemo")
    private TextBoxMultiLine txtTokusokuMemo;
    @JsonProperty("txtHakkoDay")
    private TextBoxDate txtHakkoDay;
    @JsonProperty("ccdIryokikanShujii")
    private ShujiiIryokikanAndShujiiInputDiv ccdIryokikanShujii;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtOverChosaIraiDay
     * @return txtOverChosaIraiDay
     */
    @JsonProperty("txtOverChosaIraiDay")
    public TextBoxNum getTxtOverChosaIraiDay() {
        return txtOverChosaIraiDay;
    }

    /*
     * settxtOverChosaIraiDay
     * @param txtOverChosaIraiDay txtOverChosaIraiDay
     */
    @JsonProperty("txtOverChosaIraiDay")
    public void setTxtOverChosaIraiDay(TextBoxNum txtOverChosaIraiDay) {
        this.txtOverChosaIraiDay = txtOverChosaIraiDay;
    }

    /*
     * getlabOverChosaIraiDay
     * @return labOverChosaIraiDay
     */
    @JsonProperty("labOverChosaIraiDay")
    public Label getLabOverChosaIraiDay() {
        return labOverChosaIraiDay;
    }

    /*
     * setlabOverChosaIraiDay
     * @param labOverChosaIraiDay labOverChosaIraiDay
     */
    @JsonProperty("labOverChosaIraiDay")
    public void setLabOverChosaIraiDay(Label labOverChosaIraiDay) {
        this.labOverChosaIraiDay = labOverChosaIraiDay;
    }

    /*
     * gettxtKijunDay
     * @return txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public TextBoxDate getTxtKijunDay() {
        return txtKijunDay;
    }

    /*
     * settxtKijunDay
     * @param txtKijunDay txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public void setTxtKijunDay(TextBoxDate txtKijunDay) {
        this.txtKijunDay = txtKijunDay;
    }

    /*
     * getchkInsatsuzumiTaisho
     * @return chkInsatsuzumiTaisho
     */
    @JsonProperty("chkInsatsuzumiTaisho")
    public CheckBoxList getChkInsatsuzumiTaisho() {
        return chkInsatsuzumiTaisho;
    }

    /*
     * setchkInsatsuzumiTaisho
     * @param chkInsatsuzumiTaisho chkInsatsuzumiTaisho
     */
    @JsonProperty("chkInsatsuzumiTaisho")
    public void setChkInsatsuzumiTaisho(CheckBoxList chkInsatsuzumiTaisho) {
        this.chkInsatsuzumiTaisho = chkInsatsuzumiTaisho;
    }

    /*
     * getradTokusokuHoho
     * @return radTokusokuHoho
     */
    @JsonProperty("radTokusokuHoho")
    public RadioButton getRadTokusokuHoho() {
        return radTokusokuHoho;
    }

    /*
     * setradTokusokuHoho
     * @param radTokusokuHoho radTokusokuHoho
     */
    @JsonProperty("radTokusokuHoho")
    public void setRadTokusokuHoho(RadioButton radTokusokuHoho) {
        this.radTokusokuHoho = radTokusokuHoho;
    }

    /*
     * gettxtTokusokuMemo
     * @return txtTokusokuMemo
     */
    @JsonProperty("txtTokusokuMemo")
    public TextBoxMultiLine getTxtTokusokuMemo() {
        return txtTokusokuMemo;
    }

    /*
     * settxtTokusokuMemo
     * @param txtTokusokuMemo txtTokusokuMemo
     */
    @JsonProperty("txtTokusokuMemo")
    public void setTxtTokusokuMemo(TextBoxMultiLine txtTokusokuMemo) {
        this.txtTokusokuMemo = txtTokusokuMemo;
    }

    /*
     * gettxtHakkoDay
     * @return txtHakkoDay
     */
    @JsonProperty("txtHakkoDay")
    public TextBoxDate getTxtHakkoDay() {
        return txtHakkoDay;
    }

    /*
     * settxtHakkoDay
     * @param txtHakkoDay txtHakkoDay
     */
    @JsonProperty("txtHakkoDay")
    public void setTxtHakkoDay(TextBoxDate txtHakkoDay) {
        this.txtHakkoDay = txtHakkoDay;
    }

    /*
     * getccdIryokikanShujii
     * @return ccdIryokikanShujii
     */
    @JsonProperty("ccdIryokikanShujii")
    public IShujiiIryokikanAndShujiiInputDiv getCcdIryokikanShujii() {
        return ccdIryokikanShujii;
    }

    // </editor-fold>
}

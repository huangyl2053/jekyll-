package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZenkaiJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class ZenkaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblZenkaiChosaItakusaki")
    private Label lblZenkaiChosaItakusaki;
    @JsonProperty("btnZenkaiChosaItakusakiGuide")
    private ButtonDialog btnZenkaiChosaItakusakiGuide;
    @JsonProperty("txtZenkaiNinteiChosaItakusakiName")
    private TextBox txtZenkaiNinteiChosaItakusakiName;
    @JsonProperty("lblZenkaiShujiiIryokikan")
    private Label lblZenkaiShujiiIryokikan;
    @JsonProperty("btnZenkaiShujiiIryokikanGuide")
    private ButtonDialog btnZenkaiShujiiIryokikanGuide;
    @JsonProperty("txtZenkaiShujiiIryokikanName")
    private TextBox txtZenkaiShujiiIryokikanName;
    @JsonProperty("ddlZenkaiNijiHanteiKekka")
    private DropDownList ddlZenkaiNijiHanteiKekka;
    @JsonProperty("txtZenkaiNinteiYukoKikan")
    private TextBox txtZenkaiNinteiYukoKikan;
    @JsonProperty("txtZenkaiYukoKaishiDateFrom")
    private TextBoxFlexibleDate txtZenkaiYukoKaishiDateFrom;
    @JsonProperty("lblZenkaiYukoKaishiDate")
    private Label lblZenkaiYukoKaishiDate;
    @JsonProperty("txtZenkaiYukoKaishiDateTo")
    private TextBoxFlexibleDate txtZenkaiYukoKaishiDateTo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblZenkaiChosaItakusaki
     * @return lblZenkaiChosaItakusaki
     */
    @JsonProperty("lblZenkaiChosaItakusaki")
    public Label getLblZenkaiChosaItakusaki() {
        return lblZenkaiChosaItakusaki;
    }

    /*
     * setlblZenkaiChosaItakusaki
     * @param lblZenkaiChosaItakusaki lblZenkaiChosaItakusaki
     */
    @JsonProperty("lblZenkaiChosaItakusaki")
    public void setLblZenkaiChosaItakusaki(Label lblZenkaiChosaItakusaki) {
        this.lblZenkaiChosaItakusaki = lblZenkaiChosaItakusaki;
    }

    /*
     * getbtnZenkaiChosaItakusakiGuide
     * @return btnZenkaiChosaItakusakiGuide
     */
    @JsonProperty("btnZenkaiChosaItakusakiGuide")
    public ButtonDialog getBtnZenkaiChosaItakusakiGuide() {
        return btnZenkaiChosaItakusakiGuide;
    }

    /*
     * setbtnZenkaiChosaItakusakiGuide
     * @param btnZenkaiChosaItakusakiGuide btnZenkaiChosaItakusakiGuide
     */
    @JsonProperty("btnZenkaiChosaItakusakiGuide")
    public void setBtnZenkaiChosaItakusakiGuide(ButtonDialog btnZenkaiChosaItakusakiGuide) {
        this.btnZenkaiChosaItakusakiGuide = btnZenkaiChosaItakusakiGuide;
    }

    /*
     * gettxtZenkaiNinteiChosaItakusakiName
     * @return txtZenkaiNinteiChosaItakusakiName
     */
    @JsonProperty("txtZenkaiNinteiChosaItakusakiName")
    public TextBox getTxtZenkaiNinteiChosaItakusakiName() {
        return txtZenkaiNinteiChosaItakusakiName;
    }

    /*
     * settxtZenkaiNinteiChosaItakusakiName
     * @param txtZenkaiNinteiChosaItakusakiName txtZenkaiNinteiChosaItakusakiName
     */
    @JsonProperty("txtZenkaiNinteiChosaItakusakiName")
    public void setTxtZenkaiNinteiChosaItakusakiName(TextBox txtZenkaiNinteiChosaItakusakiName) {
        this.txtZenkaiNinteiChosaItakusakiName = txtZenkaiNinteiChosaItakusakiName;
    }

    /*
     * getlblZenkaiShujiiIryokikan
     * @return lblZenkaiShujiiIryokikan
     */
    @JsonProperty("lblZenkaiShujiiIryokikan")
    public Label getLblZenkaiShujiiIryokikan() {
        return lblZenkaiShujiiIryokikan;
    }

    /*
     * setlblZenkaiShujiiIryokikan
     * @param lblZenkaiShujiiIryokikan lblZenkaiShujiiIryokikan
     */
    @JsonProperty("lblZenkaiShujiiIryokikan")
    public void setLblZenkaiShujiiIryokikan(Label lblZenkaiShujiiIryokikan) {
        this.lblZenkaiShujiiIryokikan = lblZenkaiShujiiIryokikan;
    }

    /*
     * getbtnZenkaiShujiiIryokikanGuide
     * @return btnZenkaiShujiiIryokikanGuide
     */
    @JsonProperty("btnZenkaiShujiiIryokikanGuide")
    public ButtonDialog getBtnZenkaiShujiiIryokikanGuide() {
        return btnZenkaiShujiiIryokikanGuide;
    }

    /*
     * setbtnZenkaiShujiiIryokikanGuide
     * @param btnZenkaiShujiiIryokikanGuide btnZenkaiShujiiIryokikanGuide
     */
    @JsonProperty("btnZenkaiShujiiIryokikanGuide")
    public void setBtnZenkaiShujiiIryokikanGuide(ButtonDialog btnZenkaiShujiiIryokikanGuide) {
        this.btnZenkaiShujiiIryokikanGuide = btnZenkaiShujiiIryokikanGuide;
    }

    /*
     * gettxtZenkaiShujiiIryokikanName
     * @return txtZenkaiShujiiIryokikanName
     */
    @JsonProperty("txtZenkaiShujiiIryokikanName")
    public TextBox getTxtZenkaiShujiiIryokikanName() {
        return txtZenkaiShujiiIryokikanName;
    }

    /*
     * settxtZenkaiShujiiIryokikanName
     * @param txtZenkaiShujiiIryokikanName txtZenkaiShujiiIryokikanName
     */
    @JsonProperty("txtZenkaiShujiiIryokikanName")
    public void setTxtZenkaiShujiiIryokikanName(TextBox txtZenkaiShujiiIryokikanName) {
        this.txtZenkaiShujiiIryokikanName = txtZenkaiShujiiIryokikanName;
    }

    /*
     * getddlZenkaiNijiHanteiKekka
     * @return ddlZenkaiNijiHanteiKekka
     */
    @JsonProperty("ddlZenkaiNijiHanteiKekka")
    public DropDownList getDdlZenkaiNijiHanteiKekka() {
        return ddlZenkaiNijiHanteiKekka;
    }

    /*
     * setddlZenkaiNijiHanteiKekka
     * @param ddlZenkaiNijiHanteiKekka ddlZenkaiNijiHanteiKekka
     */
    @JsonProperty("ddlZenkaiNijiHanteiKekka")
    public void setDdlZenkaiNijiHanteiKekka(DropDownList ddlZenkaiNijiHanteiKekka) {
        this.ddlZenkaiNijiHanteiKekka = ddlZenkaiNijiHanteiKekka;
    }

    /*
     * gettxtZenkaiNinteiYukoKikan
     * @return txtZenkaiNinteiYukoKikan
     */
    @JsonProperty("txtZenkaiNinteiYukoKikan")
    public TextBox getTxtZenkaiNinteiYukoKikan() {
        return txtZenkaiNinteiYukoKikan;
    }

    /*
     * settxtZenkaiNinteiYukoKikan
     * @param txtZenkaiNinteiYukoKikan txtZenkaiNinteiYukoKikan
     */
    @JsonProperty("txtZenkaiNinteiYukoKikan")
    public void setTxtZenkaiNinteiYukoKikan(TextBox txtZenkaiNinteiYukoKikan) {
        this.txtZenkaiNinteiYukoKikan = txtZenkaiNinteiYukoKikan;
    }

    /*
     * gettxtZenkaiYukoKaishiDateFrom
     * @return txtZenkaiYukoKaishiDateFrom
     */
    @JsonProperty("txtZenkaiYukoKaishiDateFrom")
    public TextBoxFlexibleDate getTxtZenkaiYukoKaishiDateFrom() {
        return txtZenkaiYukoKaishiDateFrom;
    }

    /*
     * settxtZenkaiYukoKaishiDateFrom
     * @param txtZenkaiYukoKaishiDateFrom txtZenkaiYukoKaishiDateFrom
     */
    @JsonProperty("txtZenkaiYukoKaishiDateFrom")
    public void setTxtZenkaiYukoKaishiDateFrom(TextBoxFlexibleDate txtZenkaiYukoKaishiDateFrom) {
        this.txtZenkaiYukoKaishiDateFrom = txtZenkaiYukoKaishiDateFrom;
    }

    /*
     * getlblZenkaiYukoKaishiDate
     * @return lblZenkaiYukoKaishiDate
     */
    @JsonProperty("lblZenkaiYukoKaishiDate")
    public Label getLblZenkaiYukoKaishiDate() {
        return lblZenkaiYukoKaishiDate;
    }

    /*
     * setlblZenkaiYukoKaishiDate
     * @param lblZenkaiYukoKaishiDate lblZenkaiYukoKaishiDate
     */
    @JsonProperty("lblZenkaiYukoKaishiDate")
    public void setLblZenkaiYukoKaishiDate(Label lblZenkaiYukoKaishiDate) {
        this.lblZenkaiYukoKaishiDate = lblZenkaiYukoKaishiDate;
    }

    /*
     * gettxtZenkaiYukoKaishiDateTo
     * @return txtZenkaiYukoKaishiDateTo
     */
    @JsonProperty("txtZenkaiYukoKaishiDateTo")
    public TextBoxFlexibleDate getTxtZenkaiYukoKaishiDateTo() {
        return txtZenkaiYukoKaishiDateTo;
    }

    /*
     * settxtZenkaiYukoKaishiDateTo
     * @param txtZenkaiYukoKaishiDateTo txtZenkaiYukoKaishiDateTo
     */
    @JsonProperty("txtZenkaiYukoKaishiDateTo")
    public void setTxtZenkaiYukoKaishiDateTo(TextBoxFlexibleDate txtZenkaiYukoKaishiDateTo) {
        this.txtZenkaiYukoKaishiDateTo = txtZenkaiYukoKaishiDateTo;
    }

    // </editor-fold>
}

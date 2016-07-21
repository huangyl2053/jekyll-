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
 * KaigoNinteiShinsakaiJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class KaigoNinteiShinsakaiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlNijiHanteiKekka")
    private DropDownList ddlNijiHanteiKekka;
    @JsonProperty("txtNinteiYukoKikan")
    private TextBox txtNinteiYukoKikan;
    @JsonProperty("txtCheckDay")
    private TextBox txtCheckDay;
    @JsonProperty("txtNinteiYukoKaishiDateFrom")
    private TextBoxFlexibleDate txtNinteiYukoKaishiDateFrom;
    @JsonProperty("lblNinteiYukoKaishiDate")
    private Label lblNinteiYukoKaishiDate;
    @JsonProperty("txtNinteiYukoKaishiDateTo")
    private TextBoxFlexibleDate txtNinteiYukoKaishiDateTo;
    @JsonProperty("txtNinteiYukoShuryoDateFrom")
    private TextBoxFlexibleDate txtNinteiYukoShuryoDateFrom;
    @JsonProperty("lblNinteiYukoShuryoDate")
    private Label lblNinteiYukoShuryoDate;
    @JsonProperty("txtNinteiYukoShuryoDate")
    private TextBoxFlexibleDate txtNinteiYukoShuryoDate;
    @JsonProperty("txtNijiHanteiDateFrom")
    private TextBoxFlexibleDate txtNijiHanteiDateFrom;
    @JsonProperty("lblNijiHanteiDate")
    private Label lblNijiHanteiDate;
    @JsonProperty("txtNijiHnateiDateTo")
    private TextBoxFlexibleDate txtNijiHnateiDateTo;
    @JsonProperty("txtKaisaiDateFrom")
    private TextBoxFlexibleDate txtKaisaiDateFrom;
    @JsonProperty("lblKaisaiDate")
    private Label lblKaisaiDate;
    @JsonProperty("txtKaisaiDateTo")
    private TextBoxFlexibleDate txtKaisaiDateTo;
    @JsonProperty("lblKaisaiNumber")
    private Label lblKaisaiNumber;
    @JsonProperty("txtKaisaiNumberStart")
    private TextBox txtKaisaiNumberStart;
    @JsonProperty("lblKaisaiNoFor")
    private Label lblKaisaiNoFor;
    @JsonProperty("txtKaisaiNumberEnd")
    private TextBox txtKaisaiNumberEnd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlNijiHanteiKekka
     * @return ddlNijiHanteiKekka
     */
    @JsonProperty("ddlNijiHanteiKekka")
    public DropDownList getDdlNijiHanteiKekka() {
        return ddlNijiHanteiKekka;
    }

    /*
     * setddlNijiHanteiKekka
     * @param ddlNijiHanteiKekka ddlNijiHanteiKekka
     */
    @JsonProperty("ddlNijiHanteiKekka")
    public void setDdlNijiHanteiKekka(DropDownList ddlNijiHanteiKekka) {
        this.ddlNijiHanteiKekka = ddlNijiHanteiKekka;
    }

    /*
     * gettxtNinteiYukoKikan
     * @return txtNinteiYukoKikan
     */
    @JsonProperty("txtNinteiYukoKikan")
    public TextBox getTxtNinteiYukoKikan() {
        return txtNinteiYukoKikan;
    }

    /*
     * settxtNinteiYukoKikan
     * @param txtNinteiYukoKikan txtNinteiYukoKikan
     */
    @JsonProperty("txtNinteiYukoKikan")
    public void setTxtNinteiYukoKikan(TextBox txtNinteiYukoKikan) {
        this.txtNinteiYukoKikan = txtNinteiYukoKikan;
    }

    /*
     * gettxtCheckDay
     * @return txtCheckDay
     */
    @JsonProperty("txtCheckDay")
    public TextBox getTxtCheckDay() {
        return txtCheckDay;
    }

    /*
     * settxtCheckDay
     * @param txtCheckDay txtCheckDay
     */
    @JsonProperty("txtCheckDay")
    public void setTxtCheckDay(TextBox txtCheckDay) {
        this.txtCheckDay = txtCheckDay;
    }

    /*
     * gettxtNinteiYukoKaishiDateFrom
     * @return txtNinteiYukoKaishiDateFrom
     */
    @JsonProperty("txtNinteiYukoKaishiDateFrom")
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiDateFrom() {
        return txtNinteiYukoKaishiDateFrom;
    }

    /*
     * settxtNinteiYukoKaishiDateFrom
     * @param txtNinteiYukoKaishiDateFrom txtNinteiYukoKaishiDateFrom
     */
    @JsonProperty("txtNinteiYukoKaishiDateFrom")
    public void setTxtNinteiYukoKaishiDateFrom(TextBoxFlexibleDate txtNinteiYukoKaishiDateFrom) {
        this.txtNinteiYukoKaishiDateFrom = txtNinteiYukoKaishiDateFrom;
    }

    /*
     * getlblNinteiYukoKaishiDate
     * @return lblNinteiYukoKaishiDate
     */
    @JsonProperty("lblNinteiYukoKaishiDate")
    public Label getLblNinteiYukoKaishiDate() {
        return lblNinteiYukoKaishiDate;
    }

    /*
     * setlblNinteiYukoKaishiDate
     * @param lblNinteiYukoKaishiDate lblNinteiYukoKaishiDate
     */
    @JsonProperty("lblNinteiYukoKaishiDate")
    public void setLblNinteiYukoKaishiDate(Label lblNinteiYukoKaishiDate) {
        this.lblNinteiYukoKaishiDate = lblNinteiYukoKaishiDate;
    }

    /*
     * gettxtNinteiYukoKaishiDateTo
     * @return txtNinteiYukoKaishiDateTo
     */
    @JsonProperty("txtNinteiYukoKaishiDateTo")
    public TextBoxFlexibleDate getTxtNinteiYukoKaishiDateTo() {
        return txtNinteiYukoKaishiDateTo;
    }

    /*
     * settxtNinteiYukoKaishiDateTo
     * @param txtNinteiYukoKaishiDateTo txtNinteiYukoKaishiDateTo
     */
    @JsonProperty("txtNinteiYukoKaishiDateTo")
    public void setTxtNinteiYukoKaishiDateTo(TextBoxFlexibleDate txtNinteiYukoKaishiDateTo) {
        this.txtNinteiYukoKaishiDateTo = txtNinteiYukoKaishiDateTo;
    }

    /*
     * gettxtNinteiYukoShuryoDateFrom
     * @return txtNinteiYukoShuryoDateFrom
     */
    @JsonProperty("txtNinteiYukoShuryoDateFrom")
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoDateFrom() {
        return txtNinteiYukoShuryoDateFrom;
    }

    /*
     * settxtNinteiYukoShuryoDateFrom
     * @param txtNinteiYukoShuryoDateFrom txtNinteiYukoShuryoDateFrom
     */
    @JsonProperty("txtNinteiYukoShuryoDateFrom")
    public void setTxtNinteiYukoShuryoDateFrom(TextBoxFlexibleDate txtNinteiYukoShuryoDateFrom) {
        this.txtNinteiYukoShuryoDateFrom = txtNinteiYukoShuryoDateFrom;
    }

    /*
     * getlblNinteiYukoShuryoDate
     * @return lblNinteiYukoShuryoDate
     */
    @JsonProperty("lblNinteiYukoShuryoDate")
    public Label getLblNinteiYukoShuryoDate() {
        return lblNinteiYukoShuryoDate;
    }

    /*
     * setlblNinteiYukoShuryoDate
     * @param lblNinteiYukoShuryoDate lblNinteiYukoShuryoDate
     */
    @JsonProperty("lblNinteiYukoShuryoDate")
    public void setLblNinteiYukoShuryoDate(Label lblNinteiYukoShuryoDate) {
        this.lblNinteiYukoShuryoDate = lblNinteiYukoShuryoDate;
    }

    /*
     * gettxtNinteiYukoShuryoDate
     * @return txtNinteiYukoShuryoDate
     */
    @JsonProperty("txtNinteiYukoShuryoDate")
    public TextBoxFlexibleDate getTxtNinteiYukoShuryoDate() {
        return txtNinteiYukoShuryoDate;
    }

    /*
     * settxtNinteiYukoShuryoDate
     * @param txtNinteiYukoShuryoDate txtNinteiYukoShuryoDate
     */
    @JsonProperty("txtNinteiYukoShuryoDate")
    public void setTxtNinteiYukoShuryoDate(TextBoxFlexibleDate txtNinteiYukoShuryoDate) {
        this.txtNinteiYukoShuryoDate = txtNinteiYukoShuryoDate;
    }

    /*
     * gettxtNijiHanteiDateFrom
     * @return txtNijiHanteiDateFrom
     */
    @JsonProperty("txtNijiHanteiDateFrom")
    public TextBoxFlexibleDate getTxtNijiHanteiDateFrom() {
        return txtNijiHanteiDateFrom;
    }

    /*
     * settxtNijiHanteiDateFrom
     * @param txtNijiHanteiDateFrom txtNijiHanteiDateFrom
     */
    @JsonProperty("txtNijiHanteiDateFrom")
    public void setTxtNijiHanteiDateFrom(TextBoxFlexibleDate txtNijiHanteiDateFrom) {
        this.txtNijiHanteiDateFrom = txtNijiHanteiDateFrom;
    }

    /*
     * getlblNijiHanteiDate
     * @return lblNijiHanteiDate
     */
    @JsonProperty("lblNijiHanteiDate")
    public Label getLblNijiHanteiDate() {
        return lblNijiHanteiDate;
    }

    /*
     * setlblNijiHanteiDate
     * @param lblNijiHanteiDate lblNijiHanteiDate
     */
    @JsonProperty("lblNijiHanteiDate")
    public void setLblNijiHanteiDate(Label lblNijiHanteiDate) {
        this.lblNijiHanteiDate = lblNijiHanteiDate;
    }

    /*
     * gettxtNijiHnateiDateTo
     * @return txtNijiHnateiDateTo
     */
    @JsonProperty("txtNijiHnateiDateTo")
    public TextBoxFlexibleDate getTxtNijiHnateiDateTo() {
        return txtNijiHnateiDateTo;
    }

    /*
     * settxtNijiHnateiDateTo
     * @param txtNijiHnateiDateTo txtNijiHnateiDateTo
     */
    @JsonProperty("txtNijiHnateiDateTo")
    public void setTxtNijiHnateiDateTo(TextBoxFlexibleDate txtNijiHnateiDateTo) {
        this.txtNijiHnateiDateTo = txtNijiHnateiDateTo;
    }

    /*
     * gettxtKaisaiDateFrom
     * @return txtKaisaiDateFrom
     */
    @JsonProperty("txtKaisaiDateFrom")
    public TextBoxFlexibleDate getTxtKaisaiDateFrom() {
        return txtKaisaiDateFrom;
    }

    /*
     * settxtKaisaiDateFrom
     * @param txtKaisaiDateFrom txtKaisaiDateFrom
     */
    @JsonProperty("txtKaisaiDateFrom")
    public void setTxtKaisaiDateFrom(TextBoxFlexibleDate txtKaisaiDateFrom) {
        this.txtKaisaiDateFrom = txtKaisaiDateFrom;
    }

    /*
     * getlblKaisaiDate
     * @return lblKaisaiDate
     */
    @JsonProperty("lblKaisaiDate")
    public Label getLblKaisaiDate() {
        return lblKaisaiDate;
    }

    /*
     * setlblKaisaiDate
     * @param lblKaisaiDate lblKaisaiDate
     */
    @JsonProperty("lblKaisaiDate")
    public void setLblKaisaiDate(Label lblKaisaiDate) {
        this.lblKaisaiDate = lblKaisaiDate;
    }

    /*
     * gettxtKaisaiDateTo
     * @return txtKaisaiDateTo
     */
    @JsonProperty("txtKaisaiDateTo")
    public TextBoxFlexibleDate getTxtKaisaiDateTo() {
        return txtKaisaiDateTo;
    }

    /*
     * settxtKaisaiDateTo
     * @param txtKaisaiDateTo txtKaisaiDateTo
     */
    @JsonProperty("txtKaisaiDateTo")
    public void setTxtKaisaiDateTo(TextBoxFlexibleDate txtKaisaiDateTo) {
        this.txtKaisaiDateTo = txtKaisaiDateTo;
    }

    /*
     * getlblKaisaiNumber
     * @return lblKaisaiNumber
     */
    @JsonProperty("lblKaisaiNumber")
    public Label getLblKaisaiNumber() {
        return lblKaisaiNumber;
    }

    /*
     * setlblKaisaiNumber
     * @param lblKaisaiNumber lblKaisaiNumber
     */
    @JsonProperty("lblKaisaiNumber")
    public void setLblKaisaiNumber(Label lblKaisaiNumber) {
        this.lblKaisaiNumber = lblKaisaiNumber;
    }

    /*
     * gettxtKaisaiNumberStart
     * @return txtKaisaiNumberStart
     */
    @JsonProperty("txtKaisaiNumberStart")
    public TextBox getTxtKaisaiNumberStart() {
        return txtKaisaiNumberStart;
    }

    /*
     * settxtKaisaiNumberStart
     * @param txtKaisaiNumberStart txtKaisaiNumberStart
     */
    @JsonProperty("txtKaisaiNumberStart")
    public void setTxtKaisaiNumberStart(TextBox txtKaisaiNumberStart) {
        this.txtKaisaiNumberStart = txtKaisaiNumberStart;
    }

    /*
     * getlblKaisaiNoFor
     * @return lblKaisaiNoFor
     */
    @JsonProperty("lblKaisaiNoFor")
    public Label getLblKaisaiNoFor() {
        return lblKaisaiNoFor;
    }

    /*
     * setlblKaisaiNoFor
     * @param lblKaisaiNoFor lblKaisaiNoFor
     */
    @JsonProperty("lblKaisaiNoFor")
    public void setLblKaisaiNoFor(Label lblKaisaiNoFor) {
        this.lblKaisaiNoFor = lblKaisaiNoFor;
    }

    /*
     * gettxtKaisaiNumberEnd
     * @return txtKaisaiNumberEnd
     */
    @JsonProperty("txtKaisaiNumberEnd")
    public TextBox getTxtKaisaiNumberEnd() {
        return txtKaisaiNumberEnd;
    }

    /*
     * settxtKaisaiNumberEnd
     * @param txtKaisaiNumberEnd txtKaisaiNumberEnd
     */
    @JsonProperty("txtKaisaiNumberEnd")
    public void setTxtKaisaiNumberEnd(TextBox txtKaisaiNumberEnd) {
        this.txtKaisaiNumberEnd = txtKaisaiNumberEnd;
    }

    // </editor-fold>
}

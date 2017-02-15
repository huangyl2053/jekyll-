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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
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
    private TextBoxDate txtCheckDay;
    @JsonProperty("txtNinteiYukoKaishiDateRange")
    private TextBoxDateRange txtNinteiYukoKaishiDateRange;
    @JsonProperty("txtNinteiYukoShuryoDateRange")
    private TextBoxDateRange txtNinteiYukoShuryoDateRange;
    @JsonProperty("txtNijiHanteiDateRange")
    private TextBoxDateRange txtNijiHanteiDateRange;
    @JsonProperty("txtKaisaiDateRange")
    private TextBoxDateRange txtKaisaiDateRange;
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
    public TextBoxDate getTxtCheckDay() {
        return txtCheckDay;
    }

    /*
     * settxtCheckDay
     * @param txtCheckDay txtCheckDay
     */
    @JsonProperty("txtCheckDay")
    public void setTxtCheckDay(TextBoxDate txtCheckDay) {
        this.txtCheckDay = txtCheckDay;
    }

    /*
     * gettxtNinteiYukoKaishiDateRange
     * @return txtNinteiYukoKaishiDateRange
     */
    @JsonProperty("txtNinteiYukoKaishiDateRange")
    public TextBoxDateRange getTxtNinteiYukoKaishiDateRange() {
        return txtNinteiYukoKaishiDateRange;
    }

    /*
     * settxtNinteiYukoKaishiDateRange
     * @param txtNinteiYukoKaishiDateRange txtNinteiYukoKaishiDateRange
     */
    @JsonProperty("txtNinteiYukoKaishiDateRange")
    public void setTxtNinteiYukoKaishiDateRange(TextBoxDateRange txtNinteiYukoKaishiDateRange) {
        this.txtNinteiYukoKaishiDateRange = txtNinteiYukoKaishiDateRange;
    }

    /*
     * gettxtNinteiYukoShuryoDateRange
     * @return txtNinteiYukoShuryoDateRange
     */
    @JsonProperty("txtNinteiYukoShuryoDateRange")
    public TextBoxDateRange getTxtNinteiYukoShuryoDateRange() {
        return txtNinteiYukoShuryoDateRange;
    }

    /*
     * settxtNinteiYukoShuryoDateRange
     * @param txtNinteiYukoShuryoDateRange txtNinteiYukoShuryoDateRange
     */
    @JsonProperty("txtNinteiYukoShuryoDateRange")
    public void setTxtNinteiYukoShuryoDateRange(TextBoxDateRange txtNinteiYukoShuryoDateRange) {
        this.txtNinteiYukoShuryoDateRange = txtNinteiYukoShuryoDateRange;
    }

    /*
     * gettxtNijiHanteiDateRange
     * @return txtNijiHanteiDateRange
     */
    @JsonProperty("txtNijiHanteiDateRange")
    public TextBoxDateRange getTxtNijiHanteiDateRange() {
        return txtNijiHanteiDateRange;
    }

    /*
     * settxtNijiHanteiDateRange
     * @param txtNijiHanteiDateRange txtNijiHanteiDateRange
     */
    @JsonProperty("txtNijiHanteiDateRange")
    public void setTxtNijiHanteiDateRange(TextBoxDateRange txtNijiHanteiDateRange) {
        this.txtNijiHanteiDateRange = txtNijiHanteiDateRange;
    }

    /*
     * gettxtKaisaiDateRange
     * @return txtKaisaiDateRange
     */
    @JsonProperty("txtKaisaiDateRange")
    public TextBoxDateRange getTxtKaisaiDateRange() {
        return txtKaisaiDateRange;
    }

    /*
     * settxtKaisaiDateRange
     * @param txtKaisaiDateRange txtKaisaiDateRange
     */
    @JsonProperty("txtKaisaiDateRange")
    public void setTxtKaisaiDateRange(TextBoxDateRange txtKaisaiDateRange) {
        this.txtKaisaiDateRange = txtKaisaiDateRange;
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

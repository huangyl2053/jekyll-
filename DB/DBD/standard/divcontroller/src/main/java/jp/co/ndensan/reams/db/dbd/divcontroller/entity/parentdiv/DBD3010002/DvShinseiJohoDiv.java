package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvShinseiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvShinseiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("txtShinseiShubetsu1")
    private TextBox txtShinseiShubetsu1;
    @JsonProperty("txtShinseiShubetsu2")
    private TextBox txtShinseiShubetsu2;
    @JsonProperty("txtShujiiMeisho")
    private TextBox txtShujiiMeisho;
    @JsonProperty("chkShiteii")
    private CheckBoxList chkShiteii;
    @JsonProperty("txtShujiIryokikanMeisho")
    private TextBox txtShujiIryokikanMeisho;
    @JsonProperty("btnChosaJokyo")
    private ButtonDialog btnChosaJokyo;
    @JsonProperty("chkShinsei")
    private CheckBoxList chkShinsei;
    @JsonProperty("txtShinseisha")
    private TextBox txtShinseisha;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("txtYokaigodoCode")
    private TextBoxCode txtYokaigodoCode;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiYMD")
    private TextBoxFlexibleDate txtNinteiYMD;
    @JsonProperty("txtYukoKikan")
    private TextBoxDateRange txtYukoKikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * gettxtShinseiShubetsu1
     * @return txtShinseiShubetsu1
     */
    @JsonProperty("txtShinseiShubetsu1")
    public TextBox getTxtShinseiShubetsu1() {
        return txtShinseiShubetsu1;
    }

    /*
     * settxtShinseiShubetsu1
     * @param txtShinseiShubetsu1 txtShinseiShubetsu1
     */
    @JsonProperty("txtShinseiShubetsu1")
    public void setTxtShinseiShubetsu1(TextBox txtShinseiShubetsu1) {
        this.txtShinseiShubetsu1 = txtShinseiShubetsu1;
    }

    /*
     * gettxtShinseiShubetsu2
     * @return txtShinseiShubetsu2
     */
    @JsonProperty("txtShinseiShubetsu2")
    public TextBox getTxtShinseiShubetsu2() {
        return txtShinseiShubetsu2;
    }

    /*
     * settxtShinseiShubetsu2
     * @param txtShinseiShubetsu2 txtShinseiShubetsu2
     */
    @JsonProperty("txtShinseiShubetsu2")
    public void setTxtShinseiShubetsu2(TextBox txtShinseiShubetsu2) {
        this.txtShinseiShubetsu2 = txtShinseiShubetsu2;
    }

    /*
     * gettxtShujiiMeisho
     * @return txtShujiiMeisho
     */
    @JsonProperty("txtShujiiMeisho")
    public TextBox getTxtShujiiMeisho() {
        return txtShujiiMeisho;
    }

    /*
     * settxtShujiiMeisho
     * @param txtShujiiMeisho txtShujiiMeisho
     */
    @JsonProperty("txtShujiiMeisho")
    public void setTxtShujiiMeisho(TextBox txtShujiiMeisho) {
        this.txtShujiiMeisho = txtShujiiMeisho;
    }

    /*
     * getchkShiteii
     * @return chkShiteii
     */
    @JsonProperty("chkShiteii")
    public CheckBoxList getChkShiteii() {
        return chkShiteii;
    }

    /*
     * setchkShiteii
     * @param chkShiteii chkShiteii
     */
    @JsonProperty("chkShiteii")
    public void setChkShiteii(CheckBoxList chkShiteii) {
        this.chkShiteii = chkShiteii;
    }

    /*
     * gettxtShujiIryokikanMeisho
     * @return txtShujiIryokikanMeisho
     */
    @JsonProperty("txtShujiIryokikanMeisho")
    public TextBox getTxtShujiIryokikanMeisho() {
        return txtShujiIryokikanMeisho;
    }

    /*
     * settxtShujiIryokikanMeisho
     * @param txtShujiIryokikanMeisho txtShujiIryokikanMeisho
     */
    @JsonProperty("txtShujiIryokikanMeisho")
    public void setTxtShujiIryokikanMeisho(TextBox txtShujiIryokikanMeisho) {
        this.txtShujiIryokikanMeisho = txtShujiIryokikanMeisho;
    }

    /*
     * getbtnChosaJokyo
     * @return btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public ButtonDialog getBtnChosaJokyo() {
        return btnChosaJokyo;
    }

    /*
     * setbtnChosaJokyo
     * @param btnChosaJokyo btnChosaJokyo
     */
    @JsonProperty("btnChosaJokyo")
    public void setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.btnChosaJokyo = btnChosaJokyo;
    }

    /*
     * getchkShinsei
     * @return chkShinsei
     */
    @JsonProperty("chkShinsei")
    public CheckBoxList getChkShinsei() {
        return chkShinsei;
    }

    /*
     * setchkShinsei
     * @param chkShinsei chkShinsei
     */
    @JsonProperty("chkShinsei")
    public void setChkShinsei(CheckBoxList chkShinsei) {
        this.chkShinsei = chkShinsei;
    }

    /*
     * gettxtShinseisha
     * @return txtShinseisha
     */
    @JsonProperty("txtShinseisha")
    public TextBox getTxtShinseisha() {
        return txtShinseisha;
    }

    /*
     * settxtShinseisha
     * @param txtShinseisha txtShinseisha
     */
    @JsonProperty("txtShinseisha")
    public void setTxtShinseisha(TextBox txtShinseisha) {
        this.txtShinseisha = txtShinseisha;
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

    /*
     * gettxtYokaigodoCode
     * @return txtYokaigodoCode
     */
    @JsonProperty("txtYokaigodoCode")
    public TextBoxCode getTxtYokaigodoCode() {
        return txtYokaigodoCode;
    }

    /*
     * settxtYokaigodoCode
     * @param txtYokaigodoCode txtYokaigodoCode
     */
    @JsonProperty("txtYokaigodoCode")
    public void setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.txtYokaigodoCode = txtYokaigodoCode;
    }

    /*
     * gettxtYokaigodo
     * @return txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    /*
     * settxtYokaigodo
     * @param txtYokaigodo txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo = txtYokaigodo;
    }

    /*
     * gettxtNinteiYMD
     * @return txtNinteiYMD
     */
    @JsonProperty("txtNinteiYMD")
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return txtNinteiYMD;
    }

    /*
     * settxtNinteiYMD
     * @param txtNinteiYMD txtNinteiYMD
     */
    @JsonProperty("txtNinteiYMD")
    public void setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
        this.txtNinteiYMD = txtNinteiYMD;
    }

    /*
     * gettxtYukoKikan
     * @return txtYukoKikan
     */
    @JsonProperty("txtYukoKikan")
    public TextBoxDateRange getTxtYukoKikan() {
        return txtYukoKikan;
    }

    /*
     * settxtYukoKikan
     * @param txtYukoKikan txtYukoKikan
     */
    @JsonProperty("txtYukoKikan")
    public void setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.txtYukoKikan = txtYukoKikan;
    }

    // </editor-fold>
}

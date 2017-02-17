package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-06_05-07-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radDoi")
    private RadioButton radDoi;
    @JsonProperty("txtShujiiIryoKikanCode")
    private TextBoxCode txtShujiiIryoKikanCode;
    @JsonProperty("btnToSearchIryoKikan")
    private ButtonDialog btnToSearchIryoKikan;
    @JsonProperty("txtShujiiIryoKikanMei")
    private TextBox txtShujiiIryoKikanMei;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("btnShujiiGuide")
    private ButtonDialog btnShujiiGuide;
    @JsonProperty("txtSujiiName")
    private TextBox txtSujiiName;
    @JsonProperty("txtKinyuYMD")
    private TextBoxDate txtKinyuYMD;
    @JsonProperty("txtShujiiIryoKikanShozaichi")
    private TextBoxJusho txtShujiiIryoKikanShozaichi;
    @JsonProperty("txtShujiiIryoKikanTelNumber")
    private TextBoxTelNo txtShujiiIryoKikanTelNumber;
    @JsonProperty("txtShujiiIryoKikanFaxNumber")
    private TextBoxTelNo txtShujiiIryoKikanFaxNumber;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradDoi
     * @return radDoi
     */
    @JsonProperty("radDoi")
    public RadioButton getRadDoi() {
        return radDoi;
    }

    /*
     * setradDoi
     * @param radDoi radDoi
     */
    @JsonProperty("radDoi")
    public void setRadDoi(RadioButton radDoi) {
        this.radDoi = radDoi;
    }

    /*
     * gettxtShujiiIryoKikanCode
     * @return txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return txtShujiiIryoKikanCode;
    }

    /*
     * settxtShujiiIryoKikanCode
     * @param txtShujiiIryoKikanCode txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public void setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.txtShujiiIryoKikanCode = txtShujiiIryoKikanCode;
    }

    /*
     * getbtnToSearchIryoKikan
     * @return btnToSearchIryoKikan
     */
    @JsonProperty("btnToSearchIryoKikan")
    public ButtonDialog getBtnToSearchIryoKikan() {
        return btnToSearchIryoKikan;
    }

    /*
     * setbtnToSearchIryoKikan
     * @param btnToSearchIryoKikan btnToSearchIryoKikan
     */
    @JsonProperty("btnToSearchIryoKikan")
    public void setBtnToSearchIryoKikan(ButtonDialog btnToSearchIryoKikan) {
        this.btnToSearchIryoKikan = btnToSearchIryoKikan;
    }

    /*
     * gettxtShujiiIryoKikanMei
     * @return txtShujiiIryoKikanMei
     */
    @JsonProperty("txtShujiiIryoKikanMei")
    public TextBox getTxtShujiiIryoKikanMei() {
        return txtShujiiIryoKikanMei;
    }

    /*
     * settxtShujiiIryoKikanMei
     * @param txtShujiiIryoKikanMei txtShujiiIryoKikanMei
     */
    @JsonProperty("txtShujiiIryoKikanMei")
    public void setTxtShujiiIryoKikanMei(TextBox txtShujiiIryoKikanMei) {
        this.txtShujiiIryoKikanMei = txtShujiiIryoKikanMei;
    }

    /*
     * gettxtShujiiCode
     * @return txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    /*
     * settxtShujiiCode
     * @param txtShujiiCode txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode = txtShujiiCode;
    }

    /*
     * getbtnShujiiGuide
     * @return btnShujiiGuide
     */
    @JsonProperty("btnShujiiGuide")
    public ButtonDialog getBtnShujiiGuide() {
        return btnShujiiGuide;
    }

    /*
     * setbtnShujiiGuide
     * @param btnShujiiGuide btnShujiiGuide
     */
    @JsonProperty("btnShujiiGuide")
    public void setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.btnShujiiGuide = btnShujiiGuide;
    }

    /*
     * gettxtSujiiName
     * @return txtSujiiName
     */
    @JsonProperty("txtSujiiName")
    public TextBox getTxtSujiiName() {
        return txtSujiiName;
    }

    /*
     * settxtSujiiName
     * @param txtSujiiName txtSujiiName
     */
    @JsonProperty("txtSujiiName")
    public void setTxtSujiiName(TextBox txtSujiiName) {
        this.txtSujiiName = txtSujiiName;
    }

    /*
     * gettxtKinyuYMD
     * @return txtKinyuYMD
     */
    @JsonProperty("txtKinyuYMD")
    public TextBoxDate getTxtKinyuYMD() {
        return txtKinyuYMD;
    }

    /*
     * settxtKinyuYMD
     * @param txtKinyuYMD txtKinyuYMD
     */
    @JsonProperty("txtKinyuYMD")
    public void setTxtKinyuYMD(TextBoxDate txtKinyuYMD) {
        this.txtKinyuYMD = txtKinyuYMD;
    }

    /*
     * gettxtShujiiIryoKikanShozaichi
     * @return txtShujiiIryoKikanShozaichi
     */
    @JsonProperty("txtShujiiIryoKikanShozaichi")
    public TextBoxJusho getTxtShujiiIryoKikanShozaichi() {
        return txtShujiiIryoKikanShozaichi;
    }

    /*
     * settxtShujiiIryoKikanShozaichi
     * @param txtShujiiIryoKikanShozaichi txtShujiiIryoKikanShozaichi
     */
    @JsonProperty("txtShujiiIryoKikanShozaichi")
    public void setTxtShujiiIryoKikanShozaichi(TextBoxJusho txtShujiiIryoKikanShozaichi) {
        this.txtShujiiIryoKikanShozaichi = txtShujiiIryoKikanShozaichi;
    }

    /*
     * gettxtShujiiIryoKikanTelNumber
     * @return txtShujiiIryoKikanTelNumber
     */
    @JsonProperty("txtShujiiIryoKikanTelNumber")
    public TextBoxTelNo getTxtShujiiIryoKikanTelNumber() {
        return txtShujiiIryoKikanTelNumber;
    }

    /*
     * settxtShujiiIryoKikanTelNumber
     * @param txtShujiiIryoKikanTelNumber txtShujiiIryoKikanTelNumber
     */
    @JsonProperty("txtShujiiIryoKikanTelNumber")
    public void setTxtShujiiIryoKikanTelNumber(TextBoxTelNo txtShujiiIryoKikanTelNumber) {
        this.txtShujiiIryoKikanTelNumber = txtShujiiIryoKikanTelNumber;
    }

    /*
     * gettxtShujiiIryoKikanFaxNumber
     * @return txtShujiiIryoKikanFaxNumber
     */
    @JsonProperty("txtShujiiIryoKikanFaxNumber")
    public TextBoxTelNo getTxtShujiiIryoKikanFaxNumber() {
        return txtShujiiIryoKikanFaxNumber;
    }

    /*
     * settxtShujiiIryoKikanFaxNumber
     * @param txtShujiiIryoKikanFaxNumber txtShujiiIryoKikanFaxNumber
     */
    @JsonProperty("txtShujiiIryoKikanFaxNumber")
    public void setTxtShujiiIryoKikanFaxNumber(TextBoxTelNo txtShujiiIryoKikanFaxNumber) {
        this.txtShujiiIryoKikanFaxNumber = txtShujiiIryoKikanFaxNumber;
    }

    // </editor-fold>
}

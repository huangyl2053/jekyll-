package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaJokyoInput;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteiChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNinteiChosainCode")
    private TextBoxCode txtNinteiChosainCode;
    @JsonProperty("btnChosainGuide")
    private ButtonDialog btnChosainGuide;
    @JsonProperty("txtNinteiChosainName")
    private TextBox txtNinteiChosainName;
    @JsonProperty("txtNinteiChosaItakusakiCode")
    private TextBoxCode txtNinteiChosaItakusakiCode;
    @JsonProperty("btnItakusakiGuide")
    private ButtonDialog btnItakusakiGuide;
    @JsonProperty("txtNinteiChosaItakusakiName")
    private TextBox txtNinteiChosaItakusakiName;
    @JsonProperty("txtNinteiChosaYubinNo")
    private TextBoxYubinNo txtNinteiChosaYubinNo;
    @JsonProperty("txtNinteiChosaJusho")
    private TextBoxJusho txtNinteiChosaJusho;
    @JsonProperty("txtNinteiChosaTelNo")
    private TextBoxTelNo txtNinteiChosaTelNo;
    @JsonProperty("txtNinteiChosaIraiDay")
    private TextBoxDate txtNinteiChosaIraiDay;
    @JsonProperty("txtNinteiChosaJisshiYoteiDay")
    private TextBoxDate txtNinteiChosaJisshiYoteiDay;
    @JsonProperty("txtNinteiChosaJisshiDay")
    private TextBoxDate txtNinteiChosaJisshiDay;
    @JsonProperty("ddlNinteiChosaItakusakiKubun")
    private DropDownList ddlNinteiChosaItakusakiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtNinteiChosainCode")
    public TextBoxCode getTxtNinteiChosainCode() {
        return txtNinteiChosainCode;
    }

    @JsonProperty("txtNinteiChosainCode")
    public void setTxtNinteiChosainCode(TextBoxCode txtNinteiChosainCode) {
        this.txtNinteiChosainCode=txtNinteiChosainCode;
    }

    @JsonProperty("btnChosainGuide")
    public ButtonDialog getBtnChosainGuide() {
        return btnChosainGuide;
    }

    @JsonProperty("btnChosainGuide")
    public void setBtnChosainGuide(ButtonDialog btnChosainGuide) {
        this.btnChosainGuide=btnChosainGuide;
    }

    @JsonProperty("txtNinteiChosainName")
    public TextBox getTxtNinteiChosainName() {
        return txtNinteiChosainName;
    }

    @JsonProperty("txtNinteiChosainName")
    public void setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.txtNinteiChosainName=txtNinteiChosainName;
    }

    @JsonProperty("txtNinteiChosaItakusakiCode")
    public TextBoxCode getTxtNinteiChosaItakusakiCode() {
        return txtNinteiChosaItakusakiCode;
    }

    @JsonProperty("txtNinteiChosaItakusakiCode")
    public void setTxtNinteiChosaItakusakiCode(TextBoxCode txtNinteiChosaItakusakiCode) {
        this.txtNinteiChosaItakusakiCode=txtNinteiChosaItakusakiCode;
    }

    @JsonProperty("btnItakusakiGuide")
    public ButtonDialog getBtnItakusakiGuide() {
        return btnItakusakiGuide;
    }

    @JsonProperty("btnItakusakiGuide")
    public void setBtnItakusakiGuide(ButtonDialog btnItakusakiGuide) {
        this.btnItakusakiGuide=btnItakusakiGuide;
    }

    @JsonProperty("txtNinteiChosaItakusakiName")
    public TextBox getTxtNinteiChosaItakusakiName() {
        return txtNinteiChosaItakusakiName;
    }

    @JsonProperty("txtNinteiChosaItakusakiName")
    public void setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.txtNinteiChosaItakusakiName=txtNinteiChosaItakusakiName;
    }

    @JsonProperty("txtNinteiChosaYubinNo")
    public TextBoxYubinNo getTxtNinteiChosaYubinNo() {
        return txtNinteiChosaYubinNo;
    }

    @JsonProperty("txtNinteiChosaYubinNo")
    public void setTxtNinteiChosaYubinNo(TextBoxYubinNo txtNinteiChosaYubinNo) {
        this.txtNinteiChosaYubinNo=txtNinteiChosaYubinNo;
    }

    @JsonProperty("txtNinteiChosaJusho")
    public TextBoxJusho getTxtNinteiChosaJusho() {
        return txtNinteiChosaJusho;
    }

    @JsonProperty("txtNinteiChosaJusho")
    public void setTxtNinteiChosaJusho(TextBoxJusho txtNinteiChosaJusho) {
        this.txtNinteiChosaJusho=txtNinteiChosaJusho;
    }

    @JsonProperty("txtNinteiChosaTelNo")
    public TextBoxTelNo getTxtNinteiChosaTelNo() {
        return txtNinteiChosaTelNo;
    }

    @JsonProperty("txtNinteiChosaTelNo")
    public void setTxtNinteiChosaTelNo(TextBoxTelNo txtNinteiChosaTelNo) {
        this.txtNinteiChosaTelNo=txtNinteiChosaTelNo;
    }

    @JsonProperty("txtNinteiChosaIraiDay")
    public TextBoxDate getTxtNinteiChosaIraiDay() {
        return txtNinteiChosaIraiDay;
    }

    @JsonProperty("txtNinteiChosaIraiDay")
    public void setTxtNinteiChosaIraiDay(TextBoxDate txtNinteiChosaIraiDay) {
        this.txtNinteiChosaIraiDay=txtNinteiChosaIraiDay;
    }

    @JsonProperty("txtNinteiChosaJisshiYoteiDay")
    public TextBoxDate getTxtNinteiChosaJisshiYoteiDay() {
        return txtNinteiChosaJisshiYoteiDay;
    }

    @JsonProperty("txtNinteiChosaJisshiYoteiDay")
    public void setTxtNinteiChosaJisshiYoteiDay(TextBoxDate txtNinteiChosaJisshiYoteiDay) {
        this.txtNinteiChosaJisshiYoteiDay=txtNinteiChosaJisshiYoteiDay;
    }

    @JsonProperty("txtNinteiChosaJisshiDay")
    public TextBoxDate getTxtNinteiChosaJisshiDay() {
        return txtNinteiChosaJisshiDay;
    }

    @JsonProperty("txtNinteiChosaJisshiDay")
    public void setTxtNinteiChosaJisshiDay(TextBoxDate txtNinteiChosaJisshiDay) {
        this.txtNinteiChosaJisshiDay=txtNinteiChosaJisshiDay;
    }

    @JsonProperty("ddlNinteiChosaItakusakiKubun")
    public DropDownList getDdlNinteiChosaItakusakiKubun() {
        return ddlNinteiChosaItakusakiKubun;
    }

    @JsonProperty("ddlNinteiChosaItakusakiKubun")
    public void setDdlNinteiChosaItakusakiKubun(DropDownList ddlNinteiChosaItakusakiKubun) {
        this.ddlNinteiChosaItakusakiKubun=ddlNinteiChosaItakusakiKubun;
    }

}

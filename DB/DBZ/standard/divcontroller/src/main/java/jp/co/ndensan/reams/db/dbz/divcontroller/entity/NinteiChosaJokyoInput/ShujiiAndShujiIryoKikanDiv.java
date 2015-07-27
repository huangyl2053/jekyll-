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
 * ShujiiAndShujiIryoKikan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiAndShujiIryoKikanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("btnShujiiGuide")
    private ButtonDialog btnShujiiGuide;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("txtShujiiIryoKikanCode")
    private TextBoxCode txtShujiiIryoKikanCode;
    @JsonProperty("btnIryoKikanGuide")
    private ButtonDialog btnIryoKikanGuide;
    @JsonProperty("txtShujiiIryoKikanName")
    private TextBox txtShujiiIryoKikanName;
    @JsonProperty("txtShujiiIryoKikanYubinNo")
    private TextBoxYubinNo txtShujiiIryoKikanYubinNo;
    @JsonProperty("txtShujiiIryoKikanJusho")
    private TextBoxJusho txtShujiiIryoKikanJusho;
    @JsonProperty("txtShujiiIryoKikanTelNo")
    private TextBoxTelNo txtShujiiIryoKikanTelNo;
    @JsonProperty("txtShujiiIryoKikanIraiDay")
    private TextBoxDate txtShujiiIryoKikanIraiDay;
    @JsonProperty("txtShujiiIryoKikanNyushuYoteiDay")
    private TextBoxDate txtShujiiIryoKikanNyushuYoteiDay;
    @JsonProperty("txtShujiiIryoKikanNyushuDay")
    private TextBoxDate txtShujiiIryoKikanNyushuDay;
    @JsonProperty("chkShujiiKubun")
    private CheckBoxList chkShujiiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode=txtShujiiCode;
    }

    @JsonProperty("btnShujiiGuide")
    public ButtonDialog getBtnShujiiGuide() {
        return btnShujiiGuide;
    }

    @JsonProperty("btnShujiiGuide")
    public void setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.btnShujiiGuide=btnShujiiGuide;
    }

    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    @JsonProperty("txtShujiiName")
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName=txtShujiiName;
    }

    @JsonProperty("txtShujiiIryoKikanCode")
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return txtShujiiIryoKikanCode;
    }

    @JsonProperty("txtShujiiIryoKikanCode")
    public void setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.txtShujiiIryoKikanCode=txtShujiiIryoKikanCode;
    }

    @JsonProperty("btnIryoKikanGuide")
    public ButtonDialog getBtnIryoKikanGuide() {
        return btnIryoKikanGuide;
    }

    @JsonProperty("btnIryoKikanGuide")
    public void setBtnIryoKikanGuide(ButtonDialog btnIryoKikanGuide) {
        this.btnIryoKikanGuide=btnIryoKikanGuide;
    }

    @JsonProperty("txtShujiiIryoKikanName")
    public TextBox getTxtShujiiIryoKikanName() {
        return txtShujiiIryoKikanName;
    }

    @JsonProperty("txtShujiiIryoKikanName")
    public void setTxtShujiiIryoKikanName(TextBox txtShujiiIryoKikanName) {
        this.txtShujiiIryoKikanName=txtShujiiIryoKikanName;
    }

    @JsonProperty("txtShujiiIryoKikanYubinNo")
    public TextBoxYubinNo getTxtShujiiIryoKikanYubinNo() {
        return txtShujiiIryoKikanYubinNo;
    }

    @JsonProperty("txtShujiiIryoKikanYubinNo")
    public void setTxtShujiiIryoKikanYubinNo(TextBoxYubinNo txtShujiiIryoKikanYubinNo) {
        this.txtShujiiIryoKikanYubinNo=txtShujiiIryoKikanYubinNo;
    }

    @JsonProperty("txtShujiiIryoKikanJusho")
    public TextBoxJusho getTxtShujiiIryoKikanJusho() {
        return txtShujiiIryoKikanJusho;
    }

    @JsonProperty("txtShujiiIryoKikanJusho")
    public void setTxtShujiiIryoKikanJusho(TextBoxJusho txtShujiiIryoKikanJusho) {
        this.txtShujiiIryoKikanJusho=txtShujiiIryoKikanJusho;
    }

    @JsonProperty("txtShujiiIryoKikanTelNo")
    public TextBoxTelNo getTxtShujiiIryoKikanTelNo() {
        return txtShujiiIryoKikanTelNo;
    }

    @JsonProperty("txtShujiiIryoKikanTelNo")
    public void setTxtShujiiIryoKikanTelNo(TextBoxTelNo txtShujiiIryoKikanTelNo) {
        this.txtShujiiIryoKikanTelNo=txtShujiiIryoKikanTelNo;
    }

    @JsonProperty("txtShujiiIryoKikanIraiDay")
    public TextBoxDate getTxtShujiiIryoKikanIraiDay() {
        return txtShujiiIryoKikanIraiDay;
    }

    @JsonProperty("txtShujiiIryoKikanIraiDay")
    public void setTxtShujiiIryoKikanIraiDay(TextBoxDate txtShujiiIryoKikanIraiDay) {
        this.txtShujiiIryoKikanIraiDay=txtShujiiIryoKikanIraiDay;
    }

    @JsonProperty("txtShujiiIryoKikanNyushuYoteiDay")
    public TextBoxDate getTxtShujiiIryoKikanNyushuYoteiDay() {
        return txtShujiiIryoKikanNyushuYoteiDay;
    }

    @JsonProperty("txtShujiiIryoKikanNyushuYoteiDay")
    public void setTxtShujiiIryoKikanNyushuYoteiDay(TextBoxDate txtShujiiIryoKikanNyushuYoteiDay) {
        this.txtShujiiIryoKikanNyushuYoteiDay=txtShujiiIryoKikanNyushuYoteiDay;
    }

    @JsonProperty("txtShujiiIryoKikanNyushuDay")
    public TextBoxDate getTxtShujiiIryoKikanNyushuDay() {
        return txtShujiiIryoKikanNyushuDay;
    }

    @JsonProperty("txtShujiiIryoKikanNyushuDay")
    public void setTxtShujiiIryoKikanNyushuDay(TextBoxDate txtShujiiIryoKikanNyushuDay) {
        this.txtShujiiIryoKikanNyushuDay=txtShujiiIryoKikanNyushuDay;
    }

    @JsonProperty("chkShujiiKubun")
    public CheckBoxList getChkShujiiKubun() {
        return chkShujiiKubun;
    }

    @JsonProperty("chkShujiiKubun")
    public void setChkShujiiKubun(CheckBoxList chkShujiiKubun) {
        this.chkShujiiKubun=chkShujiiKubun;
    }

}

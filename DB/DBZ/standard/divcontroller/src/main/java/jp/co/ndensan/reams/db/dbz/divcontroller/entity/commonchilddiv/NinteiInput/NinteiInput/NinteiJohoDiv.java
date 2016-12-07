package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radNinteiKubun")
    private RadioButton radNinteiKubun;
    @JsonProperty("chkMinashiKoshinNintei")
    private CheckBoxList chkMinashiKoshinNintei;
    @JsonProperty("txtNinteiYMD")
    private TextBoxFlexibleDate txtNinteiYMD;
    @JsonProperty("txtYokaigodoCode")
    private TextBoxCode txtYokaigodoCode;
    @JsonProperty("btnYokaigodoGuide")
    private ButtonDialog btnYokaigodoGuide;
    @JsonProperty("txtYokaigodoName")
    private TextBox txtYokaigodoName;
    @JsonProperty("txtYukoKaishiYMD")
    private TextBoxFlexibleDate txtYukoKaishiYMD;
    @JsonProperty("txtYukoShuryoYMD")
    private TextBoxFlexibleDate txtYukoShuryoYMD;
    @JsonProperty("btnAfter6Month")
    private Button btnAfter6Month;
    @JsonProperty("btnAfter12Month")
    private Button btnAfter12Month;
    @JsonProperty("btnAfter18Month")
    private Button btnAfter18Month;
    @JsonProperty("btnAfter24Month")
    private Button btnAfter24Month;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradNinteiKubun
     * @return radNinteiKubun
     */
    @JsonProperty("radNinteiKubun")
    public RadioButton getRadNinteiKubun() {
        return radNinteiKubun;
    }

    /*
     * setradNinteiKubun
     * @param radNinteiKubun radNinteiKubun
     */
    @JsonProperty("radNinteiKubun")
    public void setRadNinteiKubun(RadioButton radNinteiKubun) {
        this.radNinteiKubun = radNinteiKubun;
    }

    /*
     * getchkMinashiKoshinNintei
     * @return chkMinashiKoshinNintei
     */
    @JsonProperty("chkMinashiKoshinNintei")
    public CheckBoxList getChkMinashiKoshinNintei() {
        return chkMinashiKoshinNintei;
    }

    /*
     * setchkMinashiKoshinNintei
     * @param chkMinashiKoshinNintei chkMinashiKoshinNintei
     */
    @JsonProperty("chkMinashiKoshinNintei")
    public void setChkMinashiKoshinNintei(CheckBoxList chkMinashiKoshinNintei) {
        this.chkMinashiKoshinNintei = chkMinashiKoshinNintei;
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
     * getbtnYokaigodoGuide
     * @return btnYokaigodoGuide
     */
    @JsonProperty("btnYokaigodoGuide")
    public ButtonDialog getBtnYokaigodoGuide() {
        return btnYokaigodoGuide;
    }

    /*
     * setbtnYokaigodoGuide
     * @param btnYokaigodoGuide btnYokaigodoGuide
     */
    @JsonProperty("btnYokaigodoGuide")
    public void setBtnYokaigodoGuide(ButtonDialog btnYokaigodoGuide) {
        this.btnYokaigodoGuide = btnYokaigodoGuide;
    }

    /*
     * gettxtYokaigodoName
     * @return txtYokaigodoName
     */
    @JsonProperty("txtYokaigodoName")
    public TextBox getTxtYokaigodoName() {
        return txtYokaigodoName;
    }

    /*
     * settxtYokaigodoName
     * @param txtYokaigodoName txtYokaigodoName
     */
    @JsonProperty("txtYokaigodoName")
    public void setTxtYokaigodoName(TextBox txtYokaigodoName) {
        this.txtYokaigodoName = txtYokaigodoName;
    }

    /*
     * gettxtYukoKaishiYMD
     * @return txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public TextBoxFlexibleDate getTxtYukoKaishiYMD() {
        return txtYukoKaishiYMD;
    }

    /*
     * settxtYukoKaishiYMD
     * @param txtYukoKaishiYMD txtYukoKaishiYMD
     */
    @JsonProperty("txtYukoKaishiYMD")
    public void setTxtYukoKaishiYMD(TextBoxFlexibleDate txtYukoKaishiYMD) {
        this.txtYukoKaishiYMD = txtYukoKaishiYMD;
    }

    /*
     * gettxtYukoShuryoYMD
     * @return txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public TextBoxFlexibleDate getTxtYukoShuryoYMD() {
        return txtYukoShuryoYMD;
    }

    /*
     * settxtYukoShuryoYMD
     * @param txtYukoShuryoYMD txtYukoShuryoYMD
     */
    @JsonProperty("txtYukoShuryoYMD")
    public void setTxtYukoShuryoYMD(TextBoxFlexibleDate txtYukoShuryoYMD) {
        this.txtYukoShuryoYMD = txtYukoShuryoYMD;
    }

    /*
     * getbtnAfter6Month
     * @return btnAfter6Month
     */
    @JsonProperty("btnAfter6Month")
    public Button getBtnAfter6Month() {
        return btnAfter6Month;
    }

    /*
     * setbtnAfter6Month
     * @param btnAfter6Month btnAfter6Month
     */
    @JsonProperty("btnAfter6Month")
    public void setBtnAfter6Month(Button btnAfter6Month) {
        this.btnAfter6Month = btnAfter6Month;
    }

    /*
     * getbtnAfter12Month
     * @return btnAfter12Month
     */
    @JsonProperty("btnAfter12Month")
    public Button getBtnAfter12Month() {
        return btnAfter12Month;
    }

    /*
     * setbtnAfter12Month
     * @param btnAfter12Month btnAfter12Month
     */
    @JsonProperty("btnAfter12Month")
    public void setBtnAfter12Month(Button btnAfter12Month) {
        this.btnAfter12Month = btnAfter12Month;
    }

    /*
     * getbtnAfter18Month
     * @return btnAfter18Month
     */
    @JsonProperty("btnAfter18Month")
    public Button getBtnAfter18Month() {
        return btnAfter18Month;
    }

    /*
     * setbtnAfter18Month
     * @param btnAfter18Month btnAfter18Month
     */
    @JsonProperty("btnAfter18Month")
    public void setBtnAfter18Month(Button btnAfter18Month) {
        this.btnAfter18Month = btnAfter18Month;
    }

    /*
     * getbtnAfter24Month
     * @return btnAfter24Month
     */
    @JsonProperty("btnAfter24Month")
    public Button getBtnAfter24Month() {
        return btnAfter24Month;
    }

    /*
     * setbtnAfter24Month
     * @param btnAfter24Month btnAfter24Month
     */
    @JsonProperty("btnAfter24Month")
    public void setBtnAfter24Month(Button btnAfter24Month) {
        this.btnAfter24Month = btnAfter24Month;
    }

    // </editor-fold>
}

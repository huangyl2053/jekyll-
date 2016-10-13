package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * TodokedeshaJoho のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class TodokedeshaJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("radTodokedeKubun")
    private RadioButton radTodokedeKubun;
    @JsonProperty("txtTodokedeYM")
    private TextBoxDate txtTodokedeYM;
    @JsonProperty("radKeikakuKubun")
    private RadioButton radKeikakuKubun;
    @JsonProperty("txtKeikakuTekiyoStartYMD")
    private TextBoxDate txtKeikakuTekiyoStartYMD;
    @JsonProperty("txtKeikakuTekiyoEndYMD")
    private TextBoxDate txtKeikakuTekiyoEndYMD;
    @JsonProperty("Todokedesha")
    private TodokedeshaDiv Todokedesha;
    @JsonProperty("radKeikakuSakuseiKubun")
    private RadioButton radKeikakuSakuseiKubun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getradTodokedeKubun
     * @return radTodokedeKubun
     */
    @JsonProperty("radTodokedeKubun")
    public RadioButton getRadTodokedeKubun() {
        return radTodokedeKubun;
    }

    /*
     * setradTodokedeKubun
     * @param radTodokedeKubun radTodokedeKubun
     */
    @JsonProperty("radTodokedeKubun")
    public void setRadTodokedeKubun(RadioButton radTodokedeKubun) {
        this.radTodokedeKubun = radTodokedeKubun;
    }

    /*
     * gettxtTodokedeYM
     * @return txtTodokedeYM
     */
    @JsonProperty("txtTodokedeYM")
    public TextBoxDate getTxtTodokedeYM() {
        return txtTodokedeYM;
    }

    /*
     * settxtTodokedeYM
     * @param txtTodokedeYM txtTodokedeYM
     */
    @JsonProperty("txtTodokedeYM")
    public void setTxtTodokedeYM(TextBoxDate txtTodokedeYM) {
        this.txtTodokedeYM = txtTodokedeYM;
    }

    /*
     * getradKeikakuKubun
     * @return radKeikakuKubun
     */
    @JsonProperty("radKeikakuKubun")
    public RadioButton getRadKeikakuKubun() {
        return radKeikakuKubun;
    }

    /*
     * setradKeikakuKubun
     * @param radKeikakuKubun radKeikakuKubun
     */
    @JsonProperty("radKeikakuKubun")
    public void setRadKeikakuKubun(RadioButton radKeikakuKubun) {
        this.radKeikakuKubun = radKeikakuKubun;
    }

    /*
     * gettxtKeikakuTekiyoStartYMD
     * @return txtKeikakuTekiyoStartYMD
     */
    @JsonProperty("txtKeikakuTekiyoStartYMD")
    public TextBoxDate getTxtKeikakuTekiyoStartYMD() {
        return txtKeikakuTekiyoStartYMD;
    }

    /*
     * settxtKeikakuTekiyoStartYMD
     * @param txtKeikakuTekiyoStartYMD txtKeikakuTekiyoStartYMD
     */
    @JsonProperty("txtKeikakuTekiyoStartYMD")
    public void setTxtKeikakuTekiyoStartYMD(TextBoxDate txtKeikakuTekiyoStartYMD) {
        this.txtKeikakuTekiyoStartYMD = txtKeikakuTekiyoStartYMD;
    }

    /*
     * gettxtKeikakuTekiyoEndYMD
     * @return txtKeikakuTekiyoEndYMD
     */
    @JsonProperty("txtKeikakuTekiyoEndYMD")
    public TextBoxDate getTxtKeikakuTekiyoEndYMD() {
        return txtKeikakuTekiyoEndYMD;
    }

    /*
     * settxtKeikakuTekiyoEndYMD
     * @param txtKeikakuTekiyoEndYMD txtKeikakuTekiyoEndYMD
     */
    @JsonProperty("txtKeikakuTekiyoEndYMD")
    public void setTxtKeikakuTekiyoEndYMD(TextBoxDate txtKeikakuTekiyoEndYMD) {
        this.txtKeikakuTekiyoEndYMD = txtKeikakuTekiyoEndYMD;
    }

    /*
     * getTodokedesha
     * @return Todokedesha
     */
    @JsonProperty("Todokedesha")
    public TodokedeshaDiv getTodokedesha() {
        return Todokedesha;
    }

    /*
     * setTodokedesha
     * @param Todokedesha Todokedesha
     */
    @JsonProperty("Todokedesha")
    public void setTodokedesha(TodokedeshaDiv Todokedesha) {
        this.Todokedesha = Todokedesha;
    }

    /*
     * getradKeikakuSakuseiKubun
     * @return radKeikakuSakuseiKubun
     */
    @JsonProperty("radKeikakuSakuseiKubun")
    public RadioButton getRadKeikakuSakuseiKubun() {
        return radKeikakuSakuseiKubun;
    }

    /*
     * setradKeikakuSakuseiKubun
     * @param radKeikakuSakuseiKubun radKeikakuSakuseiKubun
     */
    @JsonProperty("radKeikakuSakuseiKubun")
    public void setRadKeikakuSakuseiKubun(RadioButton radKeikakuSakuseiKubun) {
        this.radKeikakuSakuseiKubun = radKeikakuSakuseiKubun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxAtenaMeisho getTxtTodokedeshaShimei() {
        return this.getTodokedesha().getTxtTodokedeshaShimei();
    }

    @JsonIgnore
    public void setTxtTodokedeshaShimei(TextBoxAtenaMeisho txtTodokedeshaShimei) {
        this.getTodokedesha().setTxtTodokedeshaShimei(txtTodokedeshaShimei);
    }

    @JsonIgnore
    public TextBoxAtenaKanaMeisho getTxtTodokedeshaShimeiKana() {
        return this.getTodokedesha().getTxtTodokedeshaShimeiKana();
    }

    @JsonIgnore
    public void setTxtTodokedeshaShimeiKana(TextBoxAtenaKanaMeisho txtTodokedeshaShimeiKana) {
        this.getTodokedesha().setTxtTodokedeshaShimeiKana(txtTodokedeshaShimeiKana);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtTodokedeshaYubinNo() {
        return this.getTodokedesha().getTxtTodokedeshaYubinNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaYubinNo(TextBoxYubinNo txtTodokedeshaYubinNo) {
        this.getTodokedesha().setTxtTodokedeshaYubinNo(txtTodokedeshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaJusho() {
        return this.getTodokedesha().getTxtTodokedeshaJusho();
    }

    @JsonIgnore
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.getTodokedesha().setTxtTodokedeshaJusho(txtTodokedeshaJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTodokedeshaTelNo() {
        return this.getTodokedesha().getTxtTodokedeshaTelNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaTelNo(TextBoxTelNo txtTodokedeshaTelNo) {
        this.getTodokedesha().setTxtTodokedeshaTelNo(txtTodokedeshaTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlTodokedeshaKankeiKubun() {
        return this.getTodokedesha().getDdlTodokedeshaKankeiKubun();
    }

    @JsonIgnore
    public void setDdlTodokedeshaKankeiKubun(DropDownList ddlTodokedeshaKankeiKubun) {
        this.getTodokedesha().setDdlTodokedeshaKankeiKubun(ddlTodokedeshaKankeiKubun);
    }

    // </editor-fold>
}

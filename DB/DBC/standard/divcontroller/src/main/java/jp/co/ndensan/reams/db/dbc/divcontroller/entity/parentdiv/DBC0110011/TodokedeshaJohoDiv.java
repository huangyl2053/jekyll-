package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

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
    @JsonProperty("radKeikakuKubun")
    private RadioButton radKeikakuKubun;
    @JsonProperty("radTodokedeKubun")
    private RadioButton radTodokedeKubun;
    @JsonProperty("txtTodokedeYMD")
    private TextBoxDate txtTodokedeYMD;
    @JsonProperty("txtKeikakuTekiyoStartYMD")
    private TextBoxDate txtKeikakuTekiyoStartYMD;
    @JsonProperty("txtKeikakuTekiyoEndYMD")
    private TextBoxDate txtKeikakuTekiyoEndYMD;
    @JsonProperty("txtTodokedeshaName")
    private TextBox txtTodokedeshaName;
    @JsonProperty("txtTodokedeshaNameKana")
    private TextBox txtTodokedeshaNameKana;
    @JsonProperty("txtTodokedeshaYubinNo")
    private TextBox txtTodokedeshaYubinNo;
    @JsonProperty("txtTodokedeshaJusho")
    private TextBox txtTodokedeshaJusho;
    @JsonProperty("txtTodokedeshaTelNo")
    private TextBox txtTodokedeshaTelNo;
    @JsonProperty("ddlTodokedeshaKankeiKubun")
    private DropDownList ddlTodokedeshaKankeiKubun;
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
     * gettxtTodokedeYMD
     * @return txtTodokedeYMD
     */
    @JsonProperty("txtTodokedeYMD")
    public TextBoxDate getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    /*
     * settxtTodokedeYMD
     * @param txtTodokedeYMD txtTodokedeYMD
     */
    @JsonProperty("txtTodokedeYMD")
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.txtTodokedeYMD = txtTodokedeYMD;
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
     * gettxtTodokedeshaName
     * @return txtTodokedeshaName
     */
    @JsonProperty("txtTodokedeshaName")
    public TextBox getTxtTodokedeshaName() {
        return txtTodokedeshaName;
    }

    /*
     * settxtTodokedeshaName
     * @param txtTodokedeshaName txtTodokedeshaName
     */
    @JsonProperty("txtTodokedeshaName")
    public void setTxtTodokedeshaName(TextBox txtTodokedeshaName) {
        this.txtTodokedeshaName = txtTodokedeshaName;
    }

    /*
     * gettxtTodokedeshaNameKana
     * @return txtTodokedeshaNameKana
     */
    @JsonProperty("txtTodokedeshaNameKana")
    public TextBox getTxtTodokedeshaNameKana() {
        return txtTodokedeshaNameKana;
    }

    /*
     * settxtTodokedeshaNameKana
     * @param txtTodokedeshaNameKana txtTodokedeshaNameKana
     */
    @JsonProperty("txtTodokedeshaNameKana")
    public void setTxtTodokedeshaNameKana(TextBox txtTodokedeshaNameKana) {
        this.txtTodokedeshaNameKana = txtTodokedeshaNameKana;
    }

    /*
     * gettxtTodokedeshaYubinNo
     * @return txtTodokedeshaYubinNo
     */
    @JsonProperty("txtTodokedeshaYubinNo")
    public TextBox getTxtTodokedeshaYubinNo() {
        return txtTodokedeshaYubinNo;
    }

    /*
     * settxtTodokedeshaYubinNo
     * @param txtTodokedeshaYubinNo txtTodokedeshaYubinNo
     */
    @JsonProperty("txtTodokedeshaYubinNo")
    public void setTxtTodokedeshaYubinNo(TextBox txtTodokedeshaYubinNo) {
        this.txtTodokedeshaYubinNo = txtTodokedeshaYubinNo;
    }

    /*
     * gettxtTodokedeshaJusho
     * @return txtTodokedeshaJusho
     */
    @JsonProperty("txtTodokedeshaJusho")
    public TextBox getTxtTodokedeshaJusho() {
        return txtTodokedeshaJusho;
    }

    /*
     * settxtTodokedeshaJusho
     * @param txtTodokedeshaJusho txtTodokedeshaJusho
     */
    @JsonProperty("txtTodokedeshaJusho")
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.txtTodokedeshaJusho = txtTodokedeshaJusho;
    }

    /*
     * gettxtTodokedeshaTelNo
     * @return txtTodokedeshaTelNo
     */
    @JsonProperty("txtTodokedeshaTelNo")
    public TextBox getTxtTodokedeshaTelNo() {
        return txtTodokedeshaTelNo;
    }

    /*
     * settxtTodokedeshaTelNo
     * @param txtTodokedeshaTelNo txtTodokedeshaTelNo
     */
    @JsonProperty("txtTodokedeshaTelNo")
    public void setTxtTodokedeshaTelNo(TextBox txtTodokedeshaTelNo) {
        this.txtTodokedeshaTelNo = txtTodokedeshaTelNo;
    }

    /*
     * getddlTodokedeshaKankeiKubun
     * @return ddlTodokedeshaKankeiKubun
     */
    @JsonProperty("ddlTodokedeshaKankeiKubun")
    public DropDownList getDdlTodokedeshaKankeiKubun() {
        return ddlTodokedeshaKankeiKubun;
    }

    /*
     * setddlTodokedeshaKankeiKubun
     * @param ddlTodokedeshaKankeiKubun ddlTodokedeshaKankeiKubun
     */
    @JsonProperty("ddlTodokedeshaKankeiKubun")
    public void setDdlTodokedeshaKankeiKubun(DropDownList ddlTodokedeshaKankeiKubun) {
        this.ddlTodokedeshaKankeiKubun = ddlTodokedeshaKankeiKubun;
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

    // </editor-fold>
}

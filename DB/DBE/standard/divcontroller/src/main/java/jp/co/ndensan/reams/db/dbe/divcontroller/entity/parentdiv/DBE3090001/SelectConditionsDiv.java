package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE3090001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SelectConditions のクラスファイル 
 * 
 * @author 自動生成
 */
public class SelectConditionsDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radJyoken")
    private RadioButton radJyoken;
    @JsonProperty("txtShinseibi")
    private TextBoxDateRange txtShinseibi;
    @JsonProperty("txtIchijiHanteibi")
    private TextBoxDateRange txtIchijiHanteibi;
    @JsonProperty("TextBoxNum")
    private TextBoxNum TextBoxNum;
    @JsonProperty("btnKensakuClear")
    private Button btnKensakuClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradJyoken
     * @return radJyoken
     */
    @JsonProperty("radJyoken")
    public RadioButton getRadJyoken() {
        return radJyoken;
    }

    /*
     * setradJyoken
     * @param radJyoken radJyoken
     */
    @JsonProperty("radJyoken")
    public void setRadJyoken(RadioButton radJyoken) {
        this.radJyoken = radJyoken;
    }

    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxDateRange getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDateRange txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    /*
     * gettxtIchijiHanteibi
     * @return txtIchijiHanteibi
     */
    @JsonProperty("txtIchijiHanteibi")
    public TextBoxDateRange getTxtIchijiHanteibi() {
        return txtIchijiHanteibi;
    }

    /*
     * settxtIchijiHanteibi
     * @param txtIchijiHanteibi txtIchijiHanteibi
     */
    @JsonProperty("txtIchijiHanteibi")
    public void setTxtIchijiHanteibi(TextBoxDateRange txtIchijiHanteibi) {
        this.txtIchijiHanteibi = txtIchijiHanteibi;
    }

    /*
     * getTextBoxNum
     * @return TextBoxNum
     */
    @JsonProperty("TextBoxNum")
    public TextBoxNum getTextBoxNum() {
        return TextBoxNum;
    }

    /*
     * setTextBoxNum
     * @param TextBoxNum TextBoxNum
     */
    @JsonProperty("TextBoxNum")
    public void setTextBoxNum(TextBoxNum TextBoxNum) {
        this.TextBoxNum = TextBoxNum;
    }

    /*
     * getbtnKensakuClear
     * @return btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public Button getBtnKensakuClear() {
        return btnKensakuClear;
    }

    /*
     * setbtnKensakuClear
     * @param btnKensakuClear btnKensakuClear
     */
    @JsonProperty("btnKensakuClear")
    public void setBtnKensakuClear(Button btnKensakuClear) {
        this.btnKensakuClear = btnKensakuClear;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1320001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuShosaiB20 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuShosaiB20Div extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuShosaiB21")
    private ChushutsuShosaiB21Div ChushutsuShosaiB21;
    @JsonProperty("ChushutsuShosaiB22")
    private ChushutsuShosaiB22Div ChushutsuShosaiB22;
    @JsonProperty("ChushutsuShosaiB23")
    private ChushutsuShosaiB23Div ChushutsuShosaiB23;
    @JsonProperty("ChushutsuShosaiB24")
    private ChushutsuShosaiB24Div ChushutsuShosaiB24;
    @JsonProperty("ChushutsuShosaiB25")
    private ChushutsuShosaiB25Div ChushutsuShosaiB25;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuShosaiB21
     * @return ChushutsuShosaiB21
     */
    @JsonProperty("ChushutsuShosaiB21")
    public ChushutsuShosaiB21Div getChushutsuShosaiB21() {
        return ChushutsuShosaiB21;
    }

    /*
     * setChushutsuShosaiB21
     * @param ChushutsuShosaiB21 ChushutsuShosaiB21
     */
    @JsonProperty("ChushutsuShosaiB21")
    public void setChushutsuShosaiB21(ChushutsuShosaiB21Div ChushutsuShosaiB21) {
        this.ChushutsuShosaiB21 = ChushutsuShosaiB21;
    }

    /*
     * getChushutsuShosaiB22
     * @return ChushutsuShosaiB22
     */
    @JsonProperty("ChushutsuShosaiB22")
    public ChushutsuShosaiB22Div getChushutsuShosaiB22() {
        return ChushutsuShosaiB22;
    }

    /*
     * setChushutsuShosaiB22
     * @param ChushutsuShosaiB22 ChushutsuShosaiB22
     */
    @JsonProperty("ChushutsuShosaiB22")
    public void setChushutsuShosaiB22(ChushutsuShosaiB22Div ChushutsuShosaiB22) {
        this.ChushutsuShosaiB22 = ChushutsuShosaiB22;
    }

    /*
     * getChushutsuShosaiB23
     * @return ChushutsuShosaiB23
     */
    @JsonProperty("ChushutsuShosaiB23")
    public ChushutsuShosaiB23Div getChushutsuShosaiB23() {
        return ChushutsuShosaiB23;
    }

    /*
     * setChushutsuShosaiB23
     * @param ChushutsuShosaiB23 ChushutsuShosaiB23
     */
    @JsonProperty("ChushutsuShosaiB23")
    public void setChushutsuShosaiB23(ChushutsuShosaiB23Div ChushutsuShosaiB23) {
        this.ChushutsuShosaiB23 = ChushutsuShosaiB23;
    }

    /*
     * getChushutsuShosaiB24
     * @return ChushutsuShosaiB24
     */
    @JsonProperty("ChushutsuShosaiB24")
    public ChushutsuShosaiB24Div getChushutsuShosaiB24() {
        return ChushutsuShosaiB24;
    }

    /*
     * setChushutsuShosaiB24
     * @param ChushutsuShosaiB24 ChushutsuShosaiB24
     */
    @JsonProperty("ChushutsuShosaiB24")
    public void setChushutsuShosaiB24(ChushutsuShosaiB24Div ChushutsuShosaiB24) {
        this.ChushutsuShosaiB24 = ChushutsuShosaiB24;
    }

    /*
     * getChushutsuShosaiB25
     * @return ChushutsuShosaiB25
     */
    @JsonProperty("ChushutsuShosaiB25")
    public ChushutsuShosaiB25Div getChushutsuShosaiB25() {
        return ChushutsuShosaiB25;
    }

    /*
     * setChushutsuShosaiB25
     * @param ChushutsuShosaiB25 ChushutsuShosaiB25
     */
    @JsonProperty("ChushutsuShosaiB25")
    public void setChushutsuShosaiB25(ChushutsuShosaiB25Div ChushutsuShosaiB25) {
        this.ChushutsuShosaiB25 = ChushutsuShosaiB25;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHaniJoken1() {
        return this.getChushutsuShosaiB21().getRadHaniJoken1();
    }

    @JsonIgnore
    public void  setRadHaniJoken1(RadioButton radHaniJoken1) {
        this.getChushutsuShosaiB21().setRadHaniJoken1(radHaniJoken1);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken2() {
        return this.getChushutsuShosaiB22().getRadHaniJoken2();
    }

    @JsonIgnore
    public void  setRadHaniJoken2(RadioButton radHaniJoken2) {
        this.getChushutsuShosaiB22().setRadHaniJoken2(radHaniJoken2);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseishaNomi() {
        return this.getChushutsuShosaiB22().getChkShinseishaNomi();
    }

    @JsonIgnore
    public void  setChkShinseishaNomi(CheckBoxList chkShinseishaNomi) {
        this.getChushutsuShosaiB22().setChkShinseishaNomi(chkShinseishaNomi);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken3() {
        return this.getChushutsuShosaiB23().getRadHaniJoken3();
    }

    @JsonIgnore
    public void  setRadHaniJoken3(RadioButton radHaniJoken3) {
        this.getChushutsuShosaiB23().setRadHaniJoken3(radHaniJoken3);
    }

    @JsonIgnore
    public RadioButton getRadHaniJoken4() {
        return this.getChushutsuShosaiB24().getRadHaniJoken4();
    }

    @JsonIgnore
    public void  setRadHaniJoken4(RadioButton radHaniJoken4) {
        this.getChushutsuShosaiB24().setRadHaniJoken4(radHaniJoken4);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuHani() {
        return this.getChushutsuShosaiB25().getTxtChushutsuHani();
    }

    @JsonIgnore
    public void  setTxtChushutsuHani(TextBoxDateRange txtChushutsuHani) {
        this.getChushutsuShosaiB25().setTxtChushutsuHani(txtChushutsuHani);
    }

    @JsonIgnore
    public CheckBoxList getChkChokkinNomi2() {
        return this.getChushutsuShosaiB25().getChkChokkinNomi2();
    }

    @JsonIgnore
    public void  setChkChokkinNomi2(CheckBoxList chkChokkinNomi2) {
        this.getChushutsuShosaiB25().setChkChokkinNomi2(chkChokkinNomi2);
    }

    // </editor-fold>
}

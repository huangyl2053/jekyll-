package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * TextBoxes のクラスファイル 
 * 
 * @author 自動生成
 */
public class TextBoxesDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTextBox")
    private TextBox txtTextBox;
    @JsonProperty("txtTextBoxCode")
    private TextBoxCode txtTextBoxCode;
    @JsonProperty("txtTextBoxDate")
    private TextBoxDate txtTextBoxDate;
    @JsonProperty("txtTextBoxDateRange")
    private TextBoxDateRange txtTextBoxDateRange;
    @JsonProperty("txtTextBoxDateRangeSlider")
    private TextBoxDateRangeSlider txtTextBoxDateRangeSlider;
    @JsonProperty("txtTextBoxKana")
    private TextBoxKana txtTextBoxKana;
    @JsonProperty("txtTextBoxMultiLine")
    private TextBoxMultiLine txtTextBoxMultiLine;
    @JsonProperty("txtTextBoxNum")
    private TextBoxNum txtTextBoxNum;
    @JsonProperty("txtTextBoxTime")
    private TextBoxTime txtTextBoxTime;
    @JsonProperty("txtTextBoxYubinNo")
    private TextBoxYubinNo txtTextBoxYubinNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTextBox")
    public TextBox getTxtTextBox() {
        return txtTextBox;
    }

    @JsonProperty("txtTextBox")
    public void setTxtTextBox(TextBox txtTextBox) {
        this.txtTextBox=txtTextBox;
    }

    @JsonProperty("txtTextBoxCode")
    public TextBoxCode getTxtTextBoxCode() {
        return txtTextBoxCode;
    }

    @JsonProperty("txtTextBoxCode")
    public void setTxtTextBoxCode(TextBoxCode txtTextBoxCode) {
        this.txtTextBoxCode=txtTextBoxCode;
    }

    @JsonProperty("txtTextBoxDate")
    public TextBoxDate getTxtTextBoxDate() {
        return txtTextBoxDate;
    }

    @JsonProperty("txtTextBoxDate")
    public void setTxtTextBoxDate(TextBoxDate txtTextBoxDate) {
        this.txtTextBoxDate=txtTextBoxDate;
    }

    @JsonProperty("txtTextBoxDateRange")
    public TextBoxDateRange getTxtTextBoxDateRange() {
        return txtTextBoxDateRange;
    }

    @JsonProperty("txtTextBoxDateRange")
    public void setTxtTextBoxDateRange(TextBoxDateRange txtTextBoxDateRange) {
        this.txtTextBoxDateRange=txtTextBoxDateRange;
    }

    @JsonProperty("txtTextBoxDateRangeSlider")
    public TextBoxDateRangeSlider getTxtTextBoxDateRangeSlider() {
        return txtTextBoxDateRangeSlider;
    }

    @JsonProperty("txtTextBoxDateRangeSlider")
    public void setTxtTextBoxDateRangeSlider(TextBoxDateRangeSlider txtTextBoxDateRangeSlider) {
        this.txtTextBoxDateRangeSlider=txtTextBoxDateRangeSlider;
    }

    @JsonProperty("txtTextBoxKana")
    public TextBoxKana getTxtTextBoxKana() {
        return txtTextBoxKana;
    }

    @JsonProperty("txtTextBoxKana")
    public void setTxtTextBoxKana(TextBoxKana txtTextBoxKana) {
        this.txtTextBoxKana=txtTextBoxKana;
    }

    @JsonProperty("txtTextBoxMultiLine")
    public TextBoxMultiLine getTxtTextBoxMultiLine() {
        return txtTextBoxMultiLine;
    }

    @JsonProperty("txtTextBoxMultiLine")
    public void setTxtTextBoxMultiLine(TextBoxMultiLine txtTextBoxMultiLine) {
        this.txtTextBoxMultiLine=txtTextBoxMultiLine;
    }

    @JsonProperty("txtTextBoxNum")
    public TextBoxNum getTxtTextBoxNum() {
        return txtTextBoxNum;
    }

    @JsonProperty("txtTextBoxNum")
    public void setTxtTextBoxNum(TextBoxNum txtTextBoxNum) {
        this.txtTextBoxNum=txtTextBoxNum;
    }

    @JsonProperty("txtTextBoxTime")
    public TextBoxTime getTxtTextBoxTime() {
        return txtTextBoxTime;
    }

    @JsonProperty("txtTextBoxTime")
    public void setTxtTextBoxTime(TextBoxTime txtTextBoxTime) {
        this.txtTextBoxTime=txtTextBoxTime;
    }

    @JsonProperty("txtTextBoxYubinNo")
    public TextBoxYubinNo getTxtTextBoxYubinNo() {
        return txtTextBoxYubinNo;
    }

    @JsonProperty("txtTextBoxYubinNo")
    public void setTxtTextBoxYubinNo(TextBoxYubinNo txtTextBoxYubinNo) {
        this.txtTextBoxYubinNo=txtTextBoxYubinNo;
    }

}

package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IKyodoJukyushaIdoRenrakuhyoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyodoJukyushaIdoRenrakuhyoKihonDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyodoJukyushaIdoRenrakuhyoKogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyodoJukyushaIdoRenrakuhyoShokanDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KyodoJukyushaIdoRenrakuhyoTeiseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyodoJukyushaIdoRenrakuhyo のクラスファイル
 *
 * @author 自動生成
 */
public class KyodoJukyushaIdoRenrakuhyoDiv extends Panel implements IKyodoJukyushaIdoRenrakuhyoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("TextBox1")
    private TextBox TextBox1;
    @JsonProperty("TextBoxDate1")
    private TextBoxDate TextBoxDate1;
    @JsonProperty("TextBoxDate2")
    private TextBoxDate TextBoxDate2;
    @JsonProperty("TextBox2")
    private TextBox TextBox2;
    @JsonProperty("RadioButton5")
    private RadioButton RadioButton5;
    @JsonProperty("DropDownList1")
    private DropDownList DropDownList1;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoTeisei")
    private KyodoJukyushaIdoRenrakuhyoTeiseiDiv KyodoJukyushaIdoRenrakuhyoTeisei;
    @JsonProperty("CheckBoxList1")
    private CheckBoxList CheckBoxList1;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihon")
    private KyodoJukyushaIdoRenrakuhyoKihonDiv KyodoJukyushaIdoRenrakuhyoKihon;
    @JsonProperty("CheckBoxList2")
    private CheckBoxList CheckBoxList2;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokan")
    private KyodoJukyushaIdoRenrakuhyoShokanDiv KyodoJukyushaIdoRenrakuhyoShokan;
    @JsonProperty("CheckBoxList3")
    private CheckBoxList CheckBoxList3;
    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogaku")
    private KyodoJukyushaIdoRenrakuhyoKogakuDiv KyodoJukyushaIdoRenrakuhyoKogaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBox1")
    public TextBox getTextBox1() {
        return TextBox1;
    }

    @JsonProperty("TextBox1")
    public void setTextBox1(TextBox TextBox1) {
        this.TextBox1 = TextBox1;
    }

    @JsonProperty("TextBoxDate1")
    public TextBoxDate getTextBoxDate1() {
        return TextBoxDate1;
    }

    @JsonProperty("TextBoxDate1")
    public void setTextBoxDate1(TextBoxDate TextBoxDate1) {
        this.TextBoxDate1 = TextBoxDate1;
    }

    @JsonProperty("TextBoxDate2")
    public TextBoxDate getTextBoxDate2() {
        return TextBoxDate2;
    }

    @JsonProperty("TextBoxDate2")
    public void setTextBoxDate2(TextBoxDate TextBoxDate2) {
        this.TextBoxDate2 = TextBoxDate2;
    }

    @JsonProperty("TextBox2")
    public TextBox getTextBox2() {
        return TextBox2;
    }

    @JsonProperty("TextBox2")
    public void setTextBox2(TextBox TextBox2) {
        this.TextBox2 = TextBox2;
    }

    @JsonProperty("RadioButton5")
    public RadioButton getRadioButton5() {
        return RadioButton5;
    }

    @JsonProperty("RadioButton5")
    public void setRadioButton5(RadioButton RadioButton5) {
        this.RadioButton5 = RadioButton5;
    }

    @JsonProperty("DropDownList1")
    public DropDownList getDropDownList1() {
        return DropDownList1;
    }

    @JsonProperty("DropDownList1")
    public void setDropDownList1(DropDownList DropDownList1) {
        this.DropDownList1 = DropDownList1;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoTeisei")
    public KyodoJukyushaIdoRenrakuhyoTeiseiDiv getKyodoJukyushaIdoRenrakuhyoTeisei() {
        return KyodoJukyushaIdoRenrakuhyoTeisei;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoTeisei")
    public void setKyodoJukyushaIdoRenrakuhyoTeisei(KyodoJukyushaIdoRenrakuhyoTeiseiDiv KyodoJukyushaIdoRenrakuhyoTeisei) {
        this.KyodoJukyushaIdoRenrakuhyoTeisei = KyodoJukyushaIdoRenrakuhyoTeisei;
    }

    @JsonProperty("CheckBoxList1")
    public CheckBoxList getCheckBoxList1() {
        return CheckBoxList1;
    }

    @JsonProperty("CheckBoxList1")
    public void setCheckBoxList1(CheckBoxList CheckBoxList1) {
        this.CheckBoxList1 = CheckBoxList1;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihon")
    public KyodoJukyushaIdoRenrakuhyoKihonDiv getKyodoJukyushaIdoRenrakuhyoKihon() {
        return KyodoJukyushaIdoRenrakuhyoKihon;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKihon")
    public void setKyodoJukyushaIdoRenrakuhyoKihon(KyodoJukyushaIdoRenrakuhyoKihonDiv KyodoJukyushaIdoRenrakuhyoKihon) {
        this.KyodoJukyushaIdoRenrakuhyoKihon = KyodoJukyushaIdoRenrakuhyoKihon;
    }

    @JsonProperty("CheckBoxList2")
    public CheckBoxList getCheckBoxList2() {
        return CheckBoxList2;
    }

    @JsonProperty("CheckBoxList2")
    public void setCheckBoxList2(CheckBoxList CheckBoxList2) {
        this.CheckBoxList2 = CheckBoxList2;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokan")
    public KyodoJukyushaIdoRenrakuhyoShokanDiv getKyodoJukyushaIdoRenrakuhyoShokan() {
        return KyodoJukyushaIdoRenrakuhyoShokan;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoShokan")
    public void setKyodoJukyushaIdoRenrakuhyoShokan(KyodoJukyushaIdoRenrakuhyoShokanDiv KyodoJukyushaIdoRenrakuhyoShokan) {
        this.KyodoJukyushaIdoRenrakuhyoShokan = KyodoJukyushaIdoRenrakuhyoShokan;
    }

    @JsonProperty("CheckBoxList3")
    public CheckBoxList getCheckBoxList3() {
        return CheckBoxList3;
    }

    @JsonProperty("CheckBoxList3")
    public void setCheckBoxList3(CheckBoxList CheckBoxList3) {
        this.CheckBoxList3 = CheckBoxList3;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogaku")
    public KyodoJukyushaIdoRenrakuhyoKogakuDiv getKyodoJukyushaIdoRenrakuhyoKogaku() {
        return KyodoJukyushaIdoRenrakuhyoKogaku;
    }

    @JsonProperty("KyodoJukyushaIdoRenrakuhyoKogaku")
    public void setKyodoJukyushaIdoRenrakuhyoKogaku(KyodoJukyushaIdoRenrakuhyoKogakuDiv KyodoJukyushaIdoRenrakuhyoKogaku) {
        this.KyodoJukyushaIdoRenrakuhyoKogaku = KyodoJukyushaIdoRenrakuhyoKogaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getHorizontalLine1() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getHorizontalLine1();
    }

    @JsonIgnore
    public void setHorizontalLine1(HorizontalLine HorizontalLine1) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setHorizontalLine1(HorizontalLine1);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate3() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getTextBoxDate3();
    }

    @JsonIgnore
    public void setTextBoxDate3(TextBoxDate TextBoxDate3) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setTextBoxDate3(TextBoxDate3);
    }

    @JsonIgnore
    public RadioButton getRadioButton6() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getRadioButton6();
    }

    @JsonIgnore
    public void setRadioButton6(RadioButton RadioButton6) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setRadioButton6(RadioButton6);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLine5() {
        return this.getKyodoJukyushaIdoRenrakuhyoTeisei().getHorizontalLine5();
    }

    @JsonIgnore
    public void setHorizontalLine5(HorizontalLine HorizontalLine5) {
        this.getKyodoJukyushaIdoRenrakuhyoTeisei().setHorizontalLine5(HorizontalLine5);
    }

//    @JsonIgnore
//    public RadioButton getRadioButton1() {
//        return this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().getRadioButton1();
//    }
//
//    @JsonIgnore
//    public void  setRadioButton1(RadioButton RadioButton1) {
//        this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().setRadioButton1(RadioButton1);
//    }
//
//    @JsonIgnore
//    public RadioButton getRadioButton2() {
//        return this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().getRadioButton2();
//    }
//
//    @JsonIgnore
//    public void  setRadioButton2(RadioButton RadioButton2) {
//        this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().setRadioButton2(RadioButton2);
//    }
//
//    @JsonIgnore
//    public RadioButton getRadioButton3() {
//        return this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().getRadioButton3();
//    }
//
//    @JsonIgnore
//    public void  setRadioButton3(RadioButton RadioButton3) {
//        this.getKyodoJukyushaIdoRenrakuhyoKogaku().getPanel1().setRadioButton3(RadioButton3);
//    }
    //--------------- この行より下にコードを追加してください -------------------
}

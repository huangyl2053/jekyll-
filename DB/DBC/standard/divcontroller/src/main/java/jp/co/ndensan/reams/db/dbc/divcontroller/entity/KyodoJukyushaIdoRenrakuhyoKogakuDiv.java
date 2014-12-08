package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.Panel1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyodoJukyushaIdoRenrakuhyoKogaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoJukyushaIdoRenrakuhyoKogakuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBoxNum3")
    private TextBoxNum TextBoxNum3;
    @JsonProperty("TextBox8")
    private TextBox TextBox8;
    @JsonProperty("TextBox9")
    private TextBox TextBox9;
    @JsonProperty("TextBox10")
    private TextBox TextBox10;
    @JsonProperty("TextBox6")
    private TextBox TextBox6;
    @JsonProperty("TextBox11")
    private TextBox TextBox11;
    @JsonProperty("TextBox12")
    private TextBox TextBox12;
    @JsonProperty("Panel1")
    private Panel1Div Panel1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBoxNum3")
    public TextBoxNum getTextBoxNum3() {
        return TextBoxNum3;
    }

    @JsonProperty("TextBoxNum3")
    public void setTextBoxNum3(TextBoxNum TextBoxNum3) {
        this.TextBoxNum3=TextBoxNum3;
    }

    @JsonProperty("TextBox8")
    public TextBox getTextBox8() {
        return TextBox8;
    }

    @JsonProperty("TextBox8")
    public void setTextBox8(TextBox TextBox8) {
        this.TextBox8=TextBox8;
    }

    @JsonProperty("TextBox9")
    public TextBox getTextBox9() {
        return TextBox9;
    }

    @JsonProperty("TextBox9")
    public void setTextBox9(TextBox TextBox9) {
        this.TextBox9=TextBox9;
    }

    @JsonProperty("TextBox10")
    public TextBox getTextBox10() {
        return TextBox10;
    }

    @JsonProperty("TextBox10")
    public void setTextBox10(TextBox TextBox10) {
        this.TextBox10=TextBox10;
    }

    @JsonProperty("TextBox6")
    public TextBox getTextBox6() {
        return TextBox6;
    }

    @JsonProperty("TextBox6")
    public void setTextBox6(TextBox TextBox6) {
        this.TextBox6=TextBox6;
    }

    @JsonProperty("TextBox11")
    public TextBox getTextBox11() {
        return TextBox11;
    }

    @JsonProperty("TextBox11")
    public void setTextBox11(TextBox TextBox11) {
        this.TextBox11=TextBox11;
    }

    @JsonProperty("TextBox12")
    public TextBox getTextBox12() {
        return TextBox12;
    }

    @JsonProperty("TextBox12")
    public void setTextBox12(TextBox TextBox12) {
        this.TextBox12=TextBox12;
    }

    @JsonProperty("Panel1")
    public Panel1Div getPanel1() {
        return Panel1;
    }

    @JsonProperty("Panel1")
    public void setPanel1(Panel1Div Panel1) {
        this.Panel1=Panel1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTextBox13() {
        return this.getPanel1().getTextBox13();
    }

    @JsonIgnore
    public void  setTextBox13(TextBox TextBox13) {
        this.getPanel1().setTextBox13(TextBox13);
    }

    @JsonIgnore
    public TextBox getTextBox14() {
        return this.getPanel1().getTextBox14();
    }

    @JsonIgnore
    public void  setTextBox14(TextBox TextBox14) {
        this.getPanel1().setTextBox14(TextBox14);
    }

    @JsonIgnore
    public TextBox getTextBox15() {
        return this.getPanel1().getTextBox15();
    }

    @JsonIgnore
    public void  setTextBox15(TextBox TextBox15) {
        this.getPanel1().setTextBox15(TextBox15);
    }

}

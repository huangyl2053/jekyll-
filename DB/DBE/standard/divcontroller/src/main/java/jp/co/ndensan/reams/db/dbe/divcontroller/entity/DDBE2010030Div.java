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
 * DDBE2010030 のクラスファイル 
 * 
 * @author 自動生成
 */
public class DDBE2010030Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lbIraiKubun")
    private Label lbIraiKubun;
    @JsonProperty("DDIraikubun")
    private DropDownList DDIraikubun;
    @JsonProperty("lbChosaKaisu")
    private Label lbChosaKaisu;
    @JsonProperty("TextChosaKaisu")
    private TextBox TextChosaKaisu;
    @JsonProperty("TextBoxIraisaki")
    private TextBox TextBoxIraisaki;
    @JsonProperty("lbIraisaki")
    private Label lbIraisaki;
    @JsonProperty("TextBoxIraisakiMei")
    private TextBox TextBoxIraisakiMei;
    @JsonProperty("lbChosain")
    private Label lbChosain;
    @JsonProperty("TextBoxChosain")
    private TextBox TextBoxChosain;
    @JsonProperty("TextBoxChosainMei")
    private TextBox TextBoxChosainMei;
    @JsonProperty("lbIraibi")
    private Label lbIraibi;
    @JsonProperty("TextBoxIraiYMD")
    private TextBoxDate TextBoxIraiYMD;
    @JsonProperty("lbChosaKigen")
    private Label lbChosaKigen;
    @JsonProperty("TextBoxKigenYMD")
    private TextBoxDate TextBoxKigenYMD;
    @JsonProperty("btnIraiToroku")
    private Button btnIraiToroku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lbIraiKubun")
    public Label getLbIraiKubun() {
        return lbIraiKubun;
    }

    @JsonProperty("lbIraiKubun")
    public void setLbIraiKubun(Label lbIraiKubun) {
        this.lbIraiKubun=lbIraiKubun;
    }

    @JsonProperty("DDIraikubun")
    public DropDownList getDDIraikubun() {
        return DDIraikubun;
    }

    @JsonProperty("DDIraikubun")
    public void setDDIraikubun(DropDownList DDIraikubun) {
        this.DDIraikubun=DDIraikubun;
    }

    @JsonProperty("lbChosaKaisu")
    public Label getLbChosaKaisu() {
        return lbChosaKaisu;
    }

    @JsonProperty("lbChosaKaisu")
    public void setLbChosaKaisu(Label lbChosaKaisu) {
        this.lbChosaKaisu=lbChosaKaisu;
    }

    @JsonProperty("TextChosaKaisu")
    public TextBox getTextChosaKaisu() {
        return TextChosaKaisu;
    }

    @JsonProperty("TextChosaKaisu")
    public void setTextChosaKaisu(TextBox TextChosaKaisu) {
        this.TextChosaKaisu=TextChosaKaisu;
    }

    @JsonProperty("TextBoxIraisaki")
    public TextBox getTextBoxIraisaki() {
        return TextBoxIraisaki;
    }

    @JsonProperty("TextBoxIraisaki")
    public void setTextBoxIraisaki(TextBox TextBoxIraisaki) {
        this.TextBoxIraisaki=TextBoxIraisaki;
    }

    @JsonProperty("lbIraisaki")
    public Label getLbIraisaki() {
        return lbIraisaki;
    }

    @JsonProperty("lbIraisaki")
    public void setLbIraisaki(Label lbIraisaki) {
        this.lbIraisaki=lbIraisaki;
    }

    @JsonProperty("TextBoxIraisakiMei")
    public TextBox getTextBoxIraisakiMei() {
        return TextBoxIraisakiMei;
    }

    @JsonProperty("TextBoxIraisakiMei")
    public void setTextBoxIraisakiMei(TextBox TextBoxIraisakiMei) {
        this.TextBoxIraisakiMei=TextBoxIraisakiMei;
    }

    @JsonProperty("lbChosain")
    public Label getLbChosain() {
        return lbChosain;
    }

    @JsonProperty("lbChosain")
    public void setLbChosain(Label lbChosain) {
        this.lbChosain=lbChosain;
    }

    @JsonProperty("TextBoxChosain")
    public TextBox getTextBoxChosain() {
        return TextBoxChosain;
    }

    @JsonProperty("TextBoxChosain")
    public void setTextBoxChosain(TextBox TextBoxChosain) {
        this.TextBoxChosain=TextBoxChosain;
    }

    @JsonProperty("TextBoxChosainMei")
    public TextBox getTextBoxChosainMei() {
        return TextBoxChosainMei;
    }

    @JsonProperty("TextBoxChosainMei")
    public void setTextBoxChosainMei(TextBox TextBoxChosainMei) {
        this.TextBoxChosainMei=TextBoxChosainMei;
    }

    @JsonProperty("lbIraibi")
    public Label getLbIraibi() {
        return lbIraibi;
    }

    @JsonProperty("lbIraibi")
    public void setLbIraibi(Label lbIraibi) {
        this.lbIraibi=lbIraibi;
    }

    @JsonProperty("TextBoxIraiYMD")
    public TextBoxDate getTextBoxIraiYMD() {
        return TextBoxIraiYMD;
    }

    @JsonProperty("TextBoxIraiYMD")
    public void setTextBoxIraiYMD(TextBoxDate TextBoxIraiYMD) {
        this.TextBoxIraiYMD=TextBoxIraiYMD;
    }

    @JsonProperty("lbChosaKigen")
    public Label getLbChosaKigen() {
        return lbChosaKigen;
    }

    @JsonProperty("lbChosaKigen")
    public void setLbChosaKigen(Label lbChosaKigen) {
        this.lbChosaKigen=lbChosaKigen;
    }

    @JsonProperty("TextBoxKigenYMD")
    public TextBoxDate getTextBoxKigenYMD() {
        return TextBoxKigenYMD;
    }

    @JsonProperty("TextBoxKigenYMD")
    public void setTextBoxKigenYMD(TextBoxDate TextBoxKigenYMD) {
        this.TextBoxKigenYMD=TextBoxKigenYMD;
    }

    @JsonProperty("btnIraiToroku")
    public Button getBtnIraiToroku() {
        return btnIraiToroku;
    }

    @JsonProperty("btnIraiToroku")
    public void setBtnIraiToroku(Button btnIraiToroku) {
        this.btnIraiToroku=btnIraiToroku;
    }

}

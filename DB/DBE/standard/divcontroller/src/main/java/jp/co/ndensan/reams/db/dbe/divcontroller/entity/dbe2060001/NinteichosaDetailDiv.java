package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2060001;
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
 * NinteichosaDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShozokuKikan")
    private Label lblShozokuKikan;
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("lblChosaJisshiDate")
    private Label lblChosaJisshiDate;
    @JsonProperty("txtChosaJisshiDate")
    private TextBoxDate txtChosaJisshiDate;
    @JsonProperty("lblChosain")
    private Label lblChosain;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("txtChosainName")
    private TextBox txtChosainName;
    @JsonProperty("lblChosaJisshiBasho")
    private Label lblChosaJisshiBasho;
    @JsonProperty("radChosaJisshiBasho")
    private RadioButton radChosaJisshiBasho;
    @JsonProperty("txtChosaJisshiBashoFreeInput")
    private TextBox txtChosaJisshiBashoFreeInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShozokuKikan")
    public Label getLblShozokuKikan() {
        return lblShozokuKikan;
    }

    @JsonProperty("lblShozokuKikan")
    public void setLblShozokuKikan(Label lblShozokuKikan) {
        this.lblShozokuKikan=lblShozokuKikan;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode=txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName=txtChosaItakusakiName;
    }

    @JsonProperty("lblChosaJisshiDate")
    public Label getLblChosaJisshiDate() {
        return lblChosaJisshiDate;
    }

    @JsonProperty("lblChosaJisshiDate")
    public void setLblChosaJisshiDate(Label lblChosaJisshiDate) {
        this.lblChosaJisshiDate=lblChosaJisshiDate;
    }

    @JsonProperty("txtChosaJisshiDate")
    public TextBoxDate getTxtChosaJisshiDate() {
        return txtChosaJisshiDate;
    }

    @JsonProperty("txtChosaJisshiDate")
    public void setTxtChosaJisshiDate(TextBoxDate txtChosaJisshiDate) {
        this.txtChosaJisshiDate=txtChosaJisshiDate;
    }

    @JsonProperty("lblChosain")
    public Label getLblChosain() {
        return lblChosain;
    }

    @JsonProperty("lblChosain")
    public void setLblChosain(Label lblChosain) {
        this.lblChosain=lblChosain;
    }

    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode=txtChosainCode;
    }

    @JsonProperty("txtChosainName")
    public TextBox getTxtChosainName() {
        return txtChosainName;
    }

    @JsonProperty("txtChosainName")
    public void setTxtChosainName(TextBox txtChosainName) {
        this.txtChosainName=txtChosainName;
    }

    @JsonProperty("lblChosaJisshiBasho")
    public Label getLblChosaJisshiBasho() {
        return lblChosaJisshiBasho;
    }

    @JsonProperty("lblChosaJisshiBasho")
    public void setLblChosaJisshiBasho(Label lblChosaJisshiBasho) {
        this.lblChosaJisshiBasho=lblChosaJisshiBasho;
    }

    @JsonProperty("radChosaJisshiBasho")
    public RadioButton getRadChosaJisshiBasho() {
        return radChosaJisshiBasho;
    }

    @JsonProperty("radChosaJisshiBasho")
    public void setRadChosaJisshiBasho(RadioButton radChosaJisshiBasho) {
        this.radChosaJisshiBasho=radChosaJisshiBasho;
    }

    @JsonProperty("txtChosaJisshiBashoFreeInput")
    public TextBox getTxtChosaJisshiBashoFreeInput() {
        return txtChosaJisshiBashoFreeInput;
    }

    @JsonProperty("txtChosaJisshiBashoFreeInput")
    public void setTxtChosaJisshiBashoFreeInput(TextBox txtChosaJisshiBashoFreeInput) {
        this.txtChosaJisshiBashoFreeInput=txtChosaJisshiBashoFreeInput;
    }

}

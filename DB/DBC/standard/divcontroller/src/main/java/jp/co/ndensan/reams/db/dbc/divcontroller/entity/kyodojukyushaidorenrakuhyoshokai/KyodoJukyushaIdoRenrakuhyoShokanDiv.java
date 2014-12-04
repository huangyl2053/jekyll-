package jp.co.ndensan.reams.db.dbc.divcontroller.entity.kyodojukyushaidorenrakuhyoshokai;
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
 * KyodoJukyushaIdoRenrakuhyoShokan のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyodoJukyushaIdoRenrakuhyoShokanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBoxNum4")
    private TextBoxNum TextBoxNum4;
    @JsonProperty("TextBox19")
    private TextBox TextBox19;
    @JsonProperty("TextBox20")
    private TextBox TextBox20;
    @JsonProperty("TextBox21")
    private TextBox TextBox21;
    @JsonProperty("TextBoxDateRange1")
    private TextBoxDateRange TextBoxDateRange1;
    @JsonProperty("TextBox22")
    private TextBox TextBox22;
    @JsonProperty("TextBoxNum2")
    private TextBoxNum TextBoxNum2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBoxNum4")
    public TextBoxNum getTextBoxNum4() {
        return TextBoxNum4;
    }

    @JsonProperty("TextBoxNum4")
    public void setTextBoxNum4(TextBoxNum TextBoxNum4) {
        this.TextBoxNum4=TextBoxNum4;
    }

    @JsonProperty("TextBox19")
    public TextBox getTextBox19() {
        return TextBox19;
    }

    @JsonProperty("TextBox19")
    public void setTextBox19(TextBox TextBox19) {
        this.TextBox19=TextBox19;
    }

    @JsonProperty("TextBox20")
    public TextBox getTextBox20() {
        return TextBox20;
    }

    @JsonProperty("TextBox20")
    public void setTextBox20(TextBox TextBox20) {
        this.TextBox20=TextBox20;
    }

    @JsonProperty("TextBox21")
    public TextBox getTextBox21() {
        return TextBox21;
    }

    @JsonProperty("TextBox21")
    public void setTextBox21(TextBox TextBox21) {
        this.TextBox21=TextBox21;
    }

    @JsonProperty("TextBoxDateRange1")
    public TextBoxDateRange getTextBoxDateRange1() {
        return TextBoxDateRange1;
    }

    @JsonProperty("TextBoxDateRange1")
    public void setTextBoxDateRange1(TextBoxDateRange TextBoxDateRange1) {
        this.TextBoxDateRange1=TextBoxDateRange1;
    }

    @JsonProperty("TextBox22")
    public TextBox getTextBox22() {
        return TextBox22;
    }

    @JsonProperty("TextBox22")
    public void setTextBox22(TextBox TextBox22) {
        this.TextBox22=TextBox22;
    }

    @JsonProperty("TextBoxNum2")
    public TextBoxNum getTextBoxNum2() {
        return TextBoxNum2;
    }

    @JsonProperty("TextBoxNum2")
    public void setTextBoxNum2(TextBoxNum TextBoxNum2) {
        this.TextBoxNum2=TextBoxNum2;
    }

}

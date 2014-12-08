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
 * Panel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class Panel1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TextBox13")
    private TextBox TextBox13;
    @JsonProperty("TextBox14")
    private TextBox TextBox14;
    @JsonProperty("TextBox15")
    private TextBox TextBox15;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TextBox13")
    public TextBox getTextBox13() {
        return TextBox13;
    }

    @JsonProperty("TextBox13")
    public void setTextBox13(TextBox TextBox13) {
        this.TextBox13=TextBox13;
    }

    @JsonProperty("TextBox14")
    public TextBox getTextBox14() {
        return TextBox14;
    }

    @JsonProperty("TextBox14")
    public void setTextBox14(TextBox TextBox14) {
        this.TextBox14=TextBox14;
    }

    @JsonProperty("TextBox15")
    public TextBox getTextBox15() {
        return TextBox15;
    }

    @JsonProperty("TextBox15")
    public void setTextBox15(TextBox TextBox15) {
        this.TextBox15=TextBox15;
    }

}

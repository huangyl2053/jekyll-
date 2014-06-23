package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
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
 * FukaHikakuZanteiGaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuZanteiGaku1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGemmenGaku1")
    private Label lblGemmenGaku1;
    @JsonProperty("txtGemmenGaku1")
    private TextBox txtGemmenGaku1;
    @JsonProperty("lblZanteiGoukeiGaku1")
    private Label lblZanteiGoukeiGaku1;
    @JsonProperty("txtZanteiGoukeiGaku1")
    private TextBox txtZanteiGoukeiGaku1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblGemmenGaku1")
    public Label getLblGemmenGaku1() {
        return lblGemmenGaku1;
    }

    @JsonProperty("lblGemmenGaku1")
    public void setLblGemmenGaku1(Label lblGemmenGaku1) {
        this.lblGemmenGaku1=lblGemmenGaku1;
    }

    @JsonProperty("txtGemmenGaku1")
    public TextBox getTxtGemmenGaku1() {
        return txtGemmenGaku1;
    }

    @JsonProperty("txtGemmenGaku1")
    public void setTxtGemmenGaku1(TextBox txtGemmenGaku1) {
        this.txtGemmenGaku1=txtGemmenGaku1;
    }

    @JsonProperty("lblZanteiGoukeiGaku1")
    public Label getLblZanteiGoukeiGaku1() {
        return lblZanteiGoukeiGaku1;
    }

    @JsonProperty("lblZanteiGoukeiGaku1")
    public void setLblZanteiGoukeiGaku1(Label lblZanteiGoukeiGaku1) {
        this.lblZanteiGoukeiGaku1=lblZanteiGoukeiGaku1;
    }

    @JsonProperty("txtZanteiGoukeiGaku1")
    public TextBox getTxtZanteiGoukeiGaku1() {
        return txtZanteiGoukeiGaku1;
    }

    @JsonProperty("txtZanteiGoukeiGaku1")
    public void setTxtZanteiGoukeiGaku1(TextBox txtZanteiGoukeiGaku1) {
        this.txtZanteiGoukeiGaku1=txtZanteiGoukeiGaku1;
    }

}

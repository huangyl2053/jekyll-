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
 * FukaHikakuZanteiGaku2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukaHikakuZanteiGaku2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGemmenGaku2")
    private Label lblGemmenGaku2;
    @JsonProperty("txtGemmenGaku2")
    private TextBox txtGemmenGaku2;
    @JsonProperty("lblZanteiGoukeiGaku2")
    private Label lblZanteiGoukeiGaku2;
    @JsonProperty("txtZanteiGoukeiGaku2")
    private TextBox txtZanteiGoukeiGaku2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblGemmenGaku2")
    public Label getLblGemmenGaku2() {
        return lblGemmenGaku2;
    }

    @JsonProperty("lblGemmenGaku2")
    public void setLblGemmenGaku2(Label lblGemmenGaku2) {
        this.lblGemmenGaku2=lblGemmenGaku2;
    }

    @JsonProperty("txtGemmenGaku2")
    public TextBox getTxtGemmenGaku2() {
        return txtGemmenGaku2;
    }

    @JsonProperty("txtGemmenGaku2")
    public void setTxtGemmenGaku2(TextBox txtGemmenGaku2) {
        this.txtGemmenGaku2=txtGemmenGaku2;
    }

    @JsonProperty("lblZanteiGoukeiGaku2")
    public Label getLblZanteiGoukeiGaku2() {
        return lblZanteiGoukeiGaku2;
    }

    @JsonProperty("lblZanteiGoukeiGaku2")
    public void setLblZanteiGoukeiGaku2(Label lblZanteiGoukeiGaku2) {
        this.lblZanteiGoukeiGaku2=lblZanteiGoukeiGaku2;
    }

    @JsonProperty("txtZanteiGoukeiGaku2")
    public TextBox getTxtZanteiGoukeiGaku2() {
        return txtZanteiGoukeiGaku2;
    }

    @JsonProperty("txtZanteiGoukeiGaku2")
    public void setTxtZanteiGoukeiGaku2(TextBox txtZanteiGoukeiGaku2) {
        this.txtZanteiGoukeiGaku2=txtZanteiGoukeiGaku2;
    }

}

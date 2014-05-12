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
 * DDBE2010040 のクラスファイル 
 * 
 * @author 自動生成
 */
public class DDBE2010040Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lbKanryoYMD")
    private Label lbKanryoYMD;
    @JsonProperty("TextBoxKanryoYMD")
    private TextBoxDate TextBoxKanryoYMD;
    @JsonProperty("btnIraishoHakko")
    private Button btnIraishoHakko;
    @JsonProperty("btnDataShuturyoku")
    private Button btnDataShuturyoku;
    @JsonProperty("btnKanryoToroku")
    private Button btnKanryoToroku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lbKanryoYMD")
    public Label getLbKanryoYMD() {
        return lbKanryoYMD;
    }

    @JsonProperty("lbKanryoYMD")
    public void setLbKanryoYMD(Label lbKanryoYMD) {
        this.lbKanryoYMD=lbKanryoYMD;
    }

    @JsonProperty("TextBoxKanryoYMD")
    public TextBoxDate getTextBoxKanryoYMD() {
        return TextBoxKanryoYMD;
    }

    @JsonProperty("TextBoxKanryoYMD")
    public void setTextBoxKanryoYMD(TextBoxDate TextBoxKanryoYMD) {
        this.TextBoxKanryoYMD=TextBoxKanryoYMD;
    }

    @JsonProperty("btnIraishoHakko")
    public Button getBtnIraishoHakko() {
        return btnIraishoHakko;
    }

    @JsonProperty("btnIraishoHakko")
    public void setBtnIraishoHakko(Button btnIraishoHakko) {
        this.btnIraishoHakko=btnIraishoHakko;
    }

    @JsonProperty("btnDataShuturyoku")
    public Button getBtnDataShuturyoku() {
        return btnDataShuturyoku;
    }

    @JsonProperty("btnDataShuturyoku")
    public void setBtnDataShuturyoku(Button btnDataShuturyoku) {
        this.btnDataShuturyoku=btnDataShuturyoku;
    }

    @JsonProperty("btnKanryoToroku")
    public Button getBtnKanryoToroku() {
        return btnKanryoToroku;
    }

    @JsonProperty("btnKanryoToroku")
    public void setBtnKanryoToroku(Button btnKanryoToroku) {
        this.btnKanryoToroku=btnKanryoToroku;
    }

}

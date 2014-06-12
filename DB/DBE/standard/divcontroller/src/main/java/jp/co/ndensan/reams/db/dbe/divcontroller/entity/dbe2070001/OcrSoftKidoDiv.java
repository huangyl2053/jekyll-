package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2070001;
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
 * OcrSoftKido のクラスファイル 
 * 
 * @author 自動生成
 */
public class OcrSoftKidoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnOcrDataNyuryoku")
    private Button btnOcrDataNyuryoku;
    @JsonProperty("lblOcrSoft")
    private Label lblOcrSoft;
    @JsonProperty("btnCloseOcrSoft")
    private Button btnCloseOcrSoft;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnOcrDataNyuryoku")
    public Button getBtnOcrDataNyuryoku() {
        return btnOcrDataNyuryoku;
    }

    @JsonProperty("btnOcrDataNyuryoku")
    public void setBtnOcrDataNyuryoku(Button btnOcrDataNyuryoku) {
        this.btnOcrDataNyuryoku=btnOcrDataNyuryoku;
    }

    @JsonProperty("lblOcrSoft")
    public Label getLblOcrSoft() {
        return lblOcrSoft;
    }

    @JsonProperty("lblOcrSoft")
    public void setLblOcrSoft(Label lblOcrSoft) {
        this.lblOcrSoft=lblOcrSoft;
    }

    @JsonProperty("btnCloseOcrSoft")
    public Button getBtnCloseOcrSoft() {
        return btnCloseOcrSoft;
    }

    @JsonProperty("btnCloseOcrSoft")
    public void setBtnCloseOcrSoft(Button btnCloseOcrSoft) {
        this.btnCloseOcrSoft=btnCloseOcrSoft;
    }

}

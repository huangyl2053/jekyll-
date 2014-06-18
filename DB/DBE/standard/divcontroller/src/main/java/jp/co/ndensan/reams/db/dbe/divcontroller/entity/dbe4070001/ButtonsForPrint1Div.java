package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
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
 * ButtonsForPrint1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsForPrint1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToPrintFromCondition1")
    private Button btnToPrintFromCondition1;
    @JsonProperty("btnToPrintAdditions")
    private Button btnToPrintAdditions;
    @JsonProperty("btnToReturnIchiran")
    private Button btnToReturnIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToPrintFromCondition1")
    public Button getBtnToPrintFromCondition1() {
        return btnToPrintFromCondition1;
    }

    @JsonProperty("btnToPrintFromCondition1")
    public void setBtnToPrintFromCondition1(Button btnToPrintFromCondition1) {
        this.btnToPrintFromCondition1=btnToPrintFromCondition1;
    }

    @JsonProperty("btnToPrintAdditions")
    public Button getBtnToPrintAdditions() {
        return btnToPrintAdditions;
    }

    @JsonProperty("btnToPrintAdditions")
    public void setBtnToPrintAdditions(Button btnToPrintAdditions) {
        this.btnToPrintAdditions=btnToPrintAdditions;
    }

    @JsonProperty("btnToReturnIchiran")
    public Button getBtnToReturnIchiran() {
        return btnToReturnIchiran;
    }

    @JsonProperty("btnToReturnIchiran")
    public void setBtnToReturnIchiran(Button btnToReturnIchiran) {
        this.btnToReturnIchiran=btnToReturnIchiran;
    }

}

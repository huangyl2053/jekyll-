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
 * ButtonsForPrint2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsForPrint2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToReturn")
    private Button btnToReturn;
    @JsonProperty("btnToPrintFromCondition2")
    private Button btnToPrintFromCondition2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToReturn")
    public Button getBtnToReturn() {
        return btnToReturn;
    }

    @JsonProperty("btnToReturn")
    public void setBtnToReturn(Button btnToReturn) {
        this.btnToReturn=btnToReturn;
    }

    @JsonProperty("btnToPrintFromCondition2")
    public Button getBtnToPrintFromCondition2() {
        return btnToPrintFromCondition2;
    }

    @JsonProperty("btnToPrintFromCondition2")
    public void setBtnToPrintFromCondition2(Button btnToPrintFromCondition2) {
        this.btnToPrintFromCondition2=btnToPrintFromCondition2;
    }

}

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
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
 * ButtonsForNinteichosaIraiListTop のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsForNinteichosaIraiListTopDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToAuto")
    private Button btnToAuto;
    @JsonProperty("btnToByHand")
    private Button btnToByHand;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToAuto")
    public Button getBtnToAuto() {
        return btnToAuto;
    }

    @JsonProperty("btnToAuto")
    public void setBtnToAuto(Button btnToAuto) {
        this.btnToAuto=btnToAuto;
    }

    @JsonProperty("btnToByHand")
    public Button getBtnToByHand() {
        return btnToByHand;
    }

    @JsonProperty("btnToByHand")
    public void setBtnToByHand(Button btnToByHand) {
        this.btnToByHand=btnToByHand;
    }

}

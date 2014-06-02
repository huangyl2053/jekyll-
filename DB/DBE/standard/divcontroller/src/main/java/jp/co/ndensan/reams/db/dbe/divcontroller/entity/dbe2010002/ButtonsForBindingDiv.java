package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010002;
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
 * ButtonsForBinding のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsForBindingDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToFree")
    private Button btnToFree;
    @JsonProperty("btnToBind")
    private Button btnToBind;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToFree")
    public Button getBtnToFree() {
        return btnToFree;
    }

    @JsonProperty("btnToFree")
    public void setBtnToFree(Button btnToFree) {
        this.btnToFree=btnToFree;
    }

    @JsonProperty("btnToBind")
    public Button getBtnToBind() {
        return btnToBind;
    }

    @JsonProperty("btnToBind")
    public void setBtnToBind(Button btnToBind) {
        this.btnToBind=btnToBind;
    }

}

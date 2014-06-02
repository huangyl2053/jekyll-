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
 * ButtonsForNinteichosaIraiEntry のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsForNinteichosaIraiEntryDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToCallNext")
    private Button btnToCallNext;
    @JsonProperty("btnToReturn")
    private Button btnToReturn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToCallNext")
    public Button getBtnToCallNext() {
        return btnToCallNext;
    }

    @JsonProperty("btnToCallNext")
    public void setBtnToCallNext(Button btnToCallNext) {
        this.btnToCallNext=btnToCallNext;
    }

    @JsonProperty("btnToReturn")
    public Button getBtnToReturn() {
        return btnToReturn;
    }

    @JsonProperty("btnToReturn")
    public void setBtnToReturn(Button btnToReturn) {
        this.btnToReturn=btnToReturn;
    }

}

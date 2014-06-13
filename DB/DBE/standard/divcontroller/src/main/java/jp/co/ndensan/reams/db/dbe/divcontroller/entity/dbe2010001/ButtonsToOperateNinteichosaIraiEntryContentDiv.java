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
 * ButtonsToOperateNinteichosaIraiEntryContent のクラスファイル 
 * 
 * @author 自動生成
 */
public class ButtonsToOperateNinteichosaIraiEntryContentDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToRepair")
    private Button btnToRepair;
    @JsonProperty("btnToEntryChosaIrai")
    private Button btnToEntryChosaIrai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToRepair")
    public Button getBtnToRepair() {
        return btnToRepair;
    }

    @JsonProperty("btnToRepair")
    public void setBtnToRepair(Button btnToRepair) {
        this.btnToRepair=btnToRepair;
    }

    @JsonProperty("btnToEntryChosaIrai")
    public Button getBtnToEntryChosaIrai() {
        return btnToEntryChosaIrai;
    }

    @JsonProperty("btnToEntryChosaIrai")
    public void setBtnToEntryChosaIrai(Button btnToEntryChosaIrai) {
        this.btnToEntryChosaIrai=btnToEntryChosaIrai;
    }

}

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.ButtonToEntryChosaIraiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiContentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiEntry のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiContent")
    private NinteichosaIraiContentDiv NinteichosaIraiContent;
    @JsonProperty("ButtonToEntryChosaIrai")
    private ButtonToEntryChosaIraiDiv ButtonToEntryChosaIrai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteichosaIraiContent")
    public NinteichosaIraiContentDiv getNinteichosaIraiContent() {
        return NinteichosaIraiContent;
    }

    @JsonProperty("NinteichosaIraiContent")
    public void setNinteichosaIraiContent(NinteichosaIraiContentDiv NinteichosaIraiContent) {
        this.NinteichosaIraiContent=NinteichosaIraiContent;
    }

    @JsonProperty("ButtonToEntryChosaIrai")
    public ButtonToEntryChosaIraiDiv getButtonToEntryChosaIrai() {
        return ButtonToEntryChosaIrai;
    }

    @JsonProperty("ButtonToEntryChosaIrai")
    public void setButtonToEntryChosaIrai(ButtonToEntryChosaIraiDiv ButtonToEntryChosaIrai) {
        this.ButtonToEntryChosaIrai=ButtonToEntryChosaIrai;
    }

}

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryMainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

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
    @JsonProperty("txtCurrentIndex")
    private TextBoxNum txtCurrentIndex;
    @JsonProperty("NinteichosaIraiEntryTarget")
    private NinteichosaIraiEntryTargetDiv NinteichosaIraiEntryTarget;
    @JsonProperty("NinteichosaIraiEntryMain")
    private NinteichosaIraiEntryMainDiv NinteichosaIraiEntryMain;
    @JsonProperty("ButtonsForNinteichosaIraiEntry")
    private ButtonsForNinteichosaIraiEntryDiv ButtonsForNinteichosaIraiEntry;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtCurrentIndex")
    public TextBoxNum getTxtCurrentIndex() {
        return txtCurrentIndex;
    }

    @JsonProperty("txtCurrentIndex")
    public void setTxtCurrentIndex(TextBoxNum txtCurrentIndex) {
        this.txtCurrentIndex=txtCurrentIndex;
    }

    @JsonProperty("NinteichosaIraiEntryTarget")
    public NinteichosaIraiEntryTargetDiv getNinteichosaIraiEntryTarget() {
        return NinteichosaIraiEntryTarget;
    }

    @JsonProperty("NinteichosaIraiEntryTarget")
    public void setNinteichosaIraiEntryTarget(NinteichosaIraiEntryTargetDiv NinteichosaIraiEntryTarget) {
        this.NinteichosaIraiEntryTarget=NinteichosaIraiEntryTarget;
    }

    @JsonProperty("NinteichosaIraiEntryMain")
    public NinteichosaIraiEntryMainDiv getNinteichosaIraiEntryMain() {
        return NinteichosaIraiEntryMain;
    }

    @JsonProperty("NinteichosaIraiEntryMain")
    public void setNinteichosaIraiEntryMain(NinteichosaIraiEntryMainDiv NinteichosaIraiEntryMain) {
        this.NinteichosaIraiEntryMain=NinteichosaIraiEntryMain;
    }

    @JsonProperty("ButtonsForNinteichosaIraiEntry")
    public ButtonsForNinteichosaIraiEntryDiv getButtonsForNinteichosaIraiEntry() {
        return ButtonsForNinteichosaIraiEntry;
    }

    @JsonProperty("ButtonsForNinteichosaIraiEntry")
    public void setButtonsForNinteichosaIraiEntry(ButtonsForNinteichosaIraiEntryDiv ButtonsForNinteichosaIraiEntry) {
        this.ButtonsForNinteichosaIraiEntry=ButtonsForNinteichosaIraiEntry;
    }

}

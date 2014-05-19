package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.ButtonsForNinteichosaIraiListDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiCompletionDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ButtonsForNinteichosaIraiList")
    private ButtonsForNinteichosaIraiListDiv ButtonsForNinteichosaIraiList;
    @JsonProperty("dgNinteichosaIraiList")
    private DataGrid<dgNinteichosaIraiList_Row> dgNinteichosaIraiList;
    @JsonProperty("NinteichosaIraiEntry")
    private NinteichosaIraiEntryDiv NinteichosaIraiEntry;
    @JsonProperty("NinteichosaIraiCompletion")
    private NinteichosaIraiCompletionDiv NinteichosaIraiCompletion;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ButtonsForNinteichosaIraiList")
    public ButtonsForNinteichosaIraiListDiv getButtonsForNinteichosaIraiList() {
        return ButtonsForNinteichosaIraiList;
    }

    @JsonProperty("ButtonsForNinteichosaIraiList")
    public void setButtonsForNinteichosaIraiList(ButtonsForNinteichosaIraiListDiv ButtonsForNinteichosaIraiList) {
        this.ButtonsForNinteichosaIraiList=ButtonsForNinteichosaIraiList;
    }

    @JsonProperty("dgNinteichosaIraiList")
    public DataGrid<dgNinteichosaIraiList_Row> getDgNinteichosaIraiList() {
        return dgNinteichosaIraiList;
    }

    @JsonProperty("dgNinteichosaIraiList")
    public void setDgNinteichosaIraiList(DataGrid<dgNinteichosaIraiList_Row> dgNinteichosaIraiList) {
        this.dgNinteichosaIraiList=dgNinteichosaIraiList;
    }

    @JsonProperty("NinteichosaIraiEntry")
    public NinteichosaIraiEntryDiv getNinteichosaIraiEntry() {
        return NinteichosaIraiEntry;
    }

    @JsonProperty("NinteichosaIraiEntry")
    public void setNinteichosaIraiEntry(NinteichosaIraiEntryDiv NinteichosaIraiEntry) {
        this.NinteichosaIraiEntry=NinteichosaIraiEntry;
    }

    @JsonProperty("NinteichosaIraiCompletion")
    public NinteichosaIraiCompletionDiv getNinteichosaIraiCompletion() {
        return NinteichosaIraiCompletion;
    }

    @JsonProperty("NinteichosaIraiCompletion")
    public void setNinteichosaIraiCompletion(NinteichosaIraiCompletionDiv NinteichosaIraiCompletion) {
        this.NinteichosaIraiCompletion=NinteichosaIraiCompletion;
    }

}

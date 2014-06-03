package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryPaperDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryRequestDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetChosainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiEntryContent のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryContentDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiEntryTargetChosain")
    private NinteichosaIraiEntryTargetChosainDiv NinteichosaIraiEntryTargetChosain;
    @JsonProperty("NinteichosaIraiEntryRequest")
    private NinteichosaIraiEntryRequestDiv NinteichosaIraiEntryRequest;
    @JsonProperty("NinteichosaIraiEntryTokusoku")
    private NinteichosaIraiEntryTokusokuDiv NinteichosaIraiEntryTokusoku;
    @JsonProperty("NinteichosaIraiEntryPaper")
    private NinteichosaIraiEntryPaperDiv NinteichosaIraiEntryPaper;
    @JsonProperty("ButtonsToOperateNinteichosaIraiEntryContent")
    private ButtonsToOperateNinteichosaIraiEntryContentDiv ButtonsToOperateNinteichosaIraiEntryContent;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteichosaIraiEntryTargetChosain")
    public NinteichosaIraiEntryTargetChosainDiv getNinteichosaIraiEntryTargetChosain() {
        return NinteichosaIraiEntryTargetChosain;
    }

    @JsonProperty("NinteichosaIraiEntryTargetChosain")
    public void setNinteichosaIraiEntryTargetChosain(NinteichosaIraiEntryTargetChosainDiv NinteichosaIraiEntryTargetChosain) {
        this.NinteichosaIraiEntryTargetChosain=NinteichosaIraiEntryTargetChosain;
    }

    @JsonProperty("NinteichosaIraiEntryRequest")
    public NinteichosaIraiEntryRequestDiv getNinteichosaIraiEntryRequest() {
        return NinteichosaIraiEntryRequest;
    }

    @JsonProperty("NinteichosaIraiEntryRequest")
    public void setNinteichosaIraiEntryRequest(NinteichosaIraiEntryRequestDiv NinteichosaIraiEntryRequest) {
        this.NinteichosaIraiEntryRequest=NinteichosaIraiEntryRequest;
    }

    @JsonProperty("NinteichosaIraiEntryTokusoku")
    public NinteichosaIraiEntryTokusokuDiv getNinteichosaIraiEntryTokusoku() {
        return NinteichosaIraiEntryTokusoku;
    }

    @JsonProperty("NinteichosaIraiEntryTokusoku")
    public void setNinteichosaIraiEntryTokusoku(NinteichosaIraiEntryTokusokuDiv NinteichosaIraiEntryTokusoku) {
        this.NinteichosaIraiEntryTokusoku=NinteichosaIraiEntryTokusoku;
    }

    @JsonProperty("NinteichosaIraiEntryPaper")
    public NinteichosaIraiEntryPaperDiv getNinteichosaIraiEntryPaper() {
        return NinteichosaIraiEntryPaper;
    }

    @JsonProperty("NinteichosaIraiEntryPaper")
    public void setNinteichosaIraiEntryPaper(NinteichosaIraiEntryPaperDiv NinteichosaIraiEntryPaper) {
        this.NinteichosaIraiEntryPaper=NinteichosaIraiEntryPaper;
    }

    @JsonProperty("ButtonsToOperateNinteichosaIraiEntryContent")
    public ButtonsToOperateNinteichosaIraiEntryContentDiv getButtonsToOperateNinteichosaIraiEntryContent() {
        return ButtonsToOperateNinteichosaIraiEntryContent;
    }

    @JsonProperty("ButtonsToOperateNinteichosaIraiEntryContent")
    public void setButtonsToOperateNinteichosaIraiEntryContent(ButtonsToOperateNinteichosaIraiEntryContentDiv ButtonsToOperateNinteichosaIraiEntryContent) {
        this.ButtonsToOperateNinteichosaIraiEntryContent=ButtonsToOperateNinteichosaIraiEntryContent;
    }

}

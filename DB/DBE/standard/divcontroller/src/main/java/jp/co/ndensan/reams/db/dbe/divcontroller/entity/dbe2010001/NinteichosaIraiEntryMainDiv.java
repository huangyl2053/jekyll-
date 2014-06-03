package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.ButtonsToOperateNinteichosaIraiEntryContentDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryRequestDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTargetChosainDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiEntryMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryMainDiv extends Panel {
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
    @JsonProperty("lblPadding1")
    private Label lblPadding1;
    @JsonProperty("NinteichosaIraiEntryTokusoku")
    private NinteichosaIraiEntryTokusokuDiv NinteichosaIraiEntryTokusoku;
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

    @JsonProperty("lblPadding1")
    public Label getLblPadding1() {
        return lblPadding1;
    }

    @JsonProperty("lblPadding1")
    public void setLblPadding1(Label lblPadding1) {
        this.lblPadding1=lblPadding1;
    }

    @JsonProperty("NinteichosaIraiEntryTokusoku")
    public NinteichosaIraiEntryTokusokuDiv getNinteichosaIraiEntryTokusoku() {
        return NinteichosaIraiEntryTokusoku;
    }

    @JsonProperty("NinteichosaIraiEntryTokusoku")
    public void setNinteichosaIraiEntryTokusoku(NinteichosaIraiEntryTokusokuDiv NinteichosaIraiEntryTokusoku) {
        this.NinteichosaIraiEntryTokusoku=NinteichosaIraiEntryTokusoku;
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

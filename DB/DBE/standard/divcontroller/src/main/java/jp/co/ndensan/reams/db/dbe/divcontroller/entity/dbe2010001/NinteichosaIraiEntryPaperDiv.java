package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryPaperPublishDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiEntryPaper のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryPaperDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkPaperType")
    private CheckBoxList chkPaperType;
    @JsonProperty("linChohyo")
    private HorizontalLine linChohyo;
    @JsonProperty("NinteichosaIraiEntryPaperPublish")
    private NinteichosaIraiEntryPaperPublishDiv NinteichosaIraiEntryPaperPublish;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("chkPaperType")
    public CheckBoxList getChkPaperType() {
        return chkPaperType;
    }

    @JsonProperty("chkPaperType")
    public void setChkPaperType(CheckBoxList chkPaperType) {
        this.chkPaperType=chkPaperType;
    }

    @JsonProperty("linChohyo")
    public HorizontalLine getLinChohyo() {
        return linChohyo;
    }

    @JsonProperty("linChohyo")
    public void setLinChohyo(HorizontalLine linChohyo) {
        this.linChohyo=linChohyo;
    }

    @JsonProperty("NinteichosaIraiEntryPaperPublish")
    public NinteichosaIraiEntryPaperPublishDiv getNinteichosaIraiEntryPaperPublish() {
        return NinteichosaIraiEntryPaperPublish;
    }

    @JsonProperty("NinteichosaIraiEntryPaperPublish")
    public void setNinteichosaIraiEntryPaperPublish(NinteichosaIraiEntryPaperPublishDiv NinteichosaIraiEntryPaperPublish) {
        this.NinteichosaIraiEntryPaperPublish=NinteichosaIraiEntryPaperPublish;
    }

}

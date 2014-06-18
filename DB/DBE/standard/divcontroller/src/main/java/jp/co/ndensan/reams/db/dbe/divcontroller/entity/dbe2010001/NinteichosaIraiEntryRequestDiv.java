package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryPaperDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryRequestContentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaIraiEntryRequest のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryRequestDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiEntryRequestContent")
    private NinteichosaIraiEntryRequestContentDiv NinteichosaIraiEntryRequestContent;
    @JsonProperty("NinteichosaIraiEntryPaper")
    private NinteichosaIraiEntryPaperDiv NinteichosaIraiEntryPaper;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("NinteichosaIraiEntryRequestContent")
    public NinteichosaIraiEntryRequestContentDiv getNinteichosaIraiEntryRequestContent() {
        return NinteichosaIraiEntryRequestContent;
    }

    @JsonProperty("NinteichosaIraiEntryRequestContent")
    public void setNinteichosaIraiEntryRequestContent(NinteichosaIraiEntryRequestContentDiv NinteichosaIraiEntryRequestContent) {
        this.NinteichosaIraiEntryRequestContent=NinteichosaIraiEntryRequestContent;
    }

    @JsonProperty("NinteichosaIraiEntryPaper")
    public NinteichosaIraiEntryPaperDiv getNinteichosaIraiEntryPaper() {
        return NinteichosaIraiEntryPaper;
    }

    @JsonProperty("NinteichosaIraiEntryPaper")
    public void setNinteichosaIraiEntryPaper(NinteichosaIraiEntryPaperDiv NinteichosaIraiEntryPaper) {
        this.NinteichosaIraiEntryPaper=NinteichosaIraiEntryPaper;
    }

}

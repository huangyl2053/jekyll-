package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2010001.NinteichosaIraiEntryTokusokuContentDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * NinteichosaIraiEntryTokusoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryTokusokuDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokusoku")
    private Label lblTokusoku;
    @JsonProperty("radTokusoku")
    private RadioButton radTokusoku;
    @JsonProperty("NinteichosaIraiEntryTokusokuContent")
    private NinteichosaIraiEntryTokusokuContentDiv NinteichosaIraiEntryTokusokuContent;
    @JsonProperty("lblPadding2")
    private Label lblPadding2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblTokusoku")
    public Label getLblTokusoku() {
        return lblTokusoku;
    }

    @JsonProperty("lblTokusoku")
    public void setLblTokusoku(Label lblTokusoku) {
        this.lblTokusoku=lblTokusoku;
    }

    @JsonProperty("radTokusoku")
    public RadioButton getRadTokusoku() {
        return radTokusoku;
    }

    @JsonProperty("radTokusoku")
    public void setRadTokusoku(RadioButton radTokusoku) {
        this.radTokusoku=radTokusoku;
    }

    @JsonProperty("NinteichosaIraiEntryTokusokuContent")
    public NinteichosaIraiEntryTokusokuContentDiv getNinteichosaIraiEntryTokusokuContent() {
        return NinteichosaIraiEntryTokusokuContent;
    }

    @JsonProperty("NinteichosaIraiEntryTokusokuContent")
    public void setNinteichosaIraiEntryTokusokuContent(NinteichosaIraiEntryTokusokuContentDiv NinteichosaIraiEntryTokusokuContent) {
        this.NinteichosaIraiEntryTokusokuContent=NinteichosaIraiEntryTokusokuContent;
    }

    @JsonProperty("lblPadding2")
    public Label getLblPadding2() {
        return lblPadding2;
    }

    @JsonProperty("lblPadding2")
    public void setLblPadding2(Label lblPadding2) {
        this.lblPadding2=lblPadding2;
    }

}

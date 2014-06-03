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
    @JsonProperty("btnToPublishChohyo")
    private Button btnToPublishChohyo;
    @JsonProperty("chkPaperType")
    private CheckBoxList chkPaperType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToPublishChohyo")
    public Button getBtnToPublishChohyo() {
        return btnToPublishChohyo;
    }

    @JsonProperty("btnToPublishChohyo")
    public void setBtnToPublishChohyo(Button btnToPublishChohyo) {
        this.btnToPublishChohyo=btnToPublishChohyo;
    }

    @JsonProperty("chkPaperType")
    public CheckBoxList getChkPaperType() {
        return chkPaperType;
    }

    @JsonProperty("chkPaperType")
    public void setChkPaperType(CheckBoxList chkPaperType) {
        this.chkPaperType=chkPaperType;
    }

}

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
 * NinteichosaIraiEntryPaperPublish のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryPaperPublishDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIraishoHakkoDate")
    private TextBoxFlexibleDate txtIraishoHakkoDate;
    @JsonProperty("btnToPublishChohyo")
    private Button btnToPublishChohyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIraishoHakkoDate")
    public TextBoxFlexibleDate getTxtIraishoHakkoDate() {
        return txtIraishoHakkoDate;
    }

    @JsonProperty("txtIraishoHakkoDate")
    public void setTxtIraishoHakkoDate(TextBoxFlexibleDate txtIraishoHakkoDate) {
        this.txtIraishoHakkoDate=txtIraishoHakkoDate;
    }

    @JsonProperty("btnToPublishChohyo")
    public Button getBtnToPublishChohyo() {
        return btnToPublishChohyo;
    }

    @JsonProperty("btnToPublishChohyo")
    public void setBtnToPublishChohyo(Button btnToPublishChohyo) {
        this.btnToPublishChohyo=btnToPublishChohyo;
    }

}

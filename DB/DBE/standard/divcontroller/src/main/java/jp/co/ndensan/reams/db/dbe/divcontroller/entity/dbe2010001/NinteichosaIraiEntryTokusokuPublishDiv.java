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
 * NinteichosaIraiEntryTokusokuPublish のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraiEntryTokusokuPublishDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToPublishTokusokujo")
    private Button btnToPublishTokusokujo;
    @JsonProperty("txtTokusokujoHakkoDate")
    private TextBoxFlexibleDate txtTokusokujoHakkoDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToPublishTokusokujo")
    public Button getBtnToPublishTokusokujo() {
        return btnToPublishTokusokujo;
    }

    @JsonProperty("btnToPublishTokusokujo")
    public void setBtnToPublishTokusokujo(Button btnToPublishTokusokujo) {
        this.btnToPublishTokusokujo=btnToPublishTokusokujo;
    }

    @JsonProperty("txtTokusokujoHakkoDate")
    public TextBoxFlexibleDate getTxtTokusokujoHakkoDate() {
        return txtTokusokujoHakkoDate;
    }

    @JsonProperty("txtTokusokujoHakkoDate")
    public void setTxtTokusokujoHakkoDate(TextBoxFlexibleDate txtTokusokujoHakkoDate) {
        this.txtTokusokujoHakkoDate=txtTokusokujoHakkoDate;
    }

}

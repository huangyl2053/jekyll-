package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320002;
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
 * Gemmen のクラスファイル 
 * 
 * @author 自動生成
 */
public class GemmenDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGemmenShinseiYMD")
    private TextBoxDate txtGemmenShinseiYMD;
    @JsonProperty("txtGemmenShinseiGaku")
    private TextBoxNum txtGemmenShinseiGaku;
    @JsonProperty("txtGemmenShinseiRiyu")
    private TextBox txtGemmenShinseiRiyu;
    @JsonProperty("txtGemmenKetteiYMD")
    private TextBoxDate txtGemmenKetteiYMD;
    @JsonProperty("txtGemmenShurui")
    private TextBox txtGemmenShurui;
    @JsonProperty("txtGemmenShouninRiyu")
    private TextBox txtGemmenShouninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtGemmenShinseiYMD")
    public TextBoxDate getTxtGemmenShinseiYMD() {
        return txtGemmenShinseiYMD;
    }

    @JsonProperty("txtGemmenShinseiYMD")
    public void setTxtGemmenShinseiYMD(TextBoxDate txtGemmenShinseiYMD) {
        this.txtGemmenShinseiYMD=txtGemmenShinseiYMD;
    }

    @JsonProperty("txtGemmenShinseiGaku")
    public TextBoxNum getTxtGemmenShinseiGaku() {
        return txtGemmenShinseiGaku;
    }

    @JsonProperty("txtGemmenShinseiGaku")
    public void setTxtGemmenShinseiGaku(TextBoxNum txtGemmenShinseiGaku) {
        this.txtGemmenShinseiGaku=txtGemmenShinseiGaku;
    }

    @JsonProperty("txtGemmenShinseiRiyu")
    public TextBox getTxtGemmenShinseiRiyu() {
        return txtGemmenShinseiRiyu;
    }

    @JsonProperty("txtGemmenShinseiRiyu")
    public void setTxtGemmenShinseiRiyu(TextBox txtGemmenShinseiRiyu) {
        this.txtGemmenShinseiRiyu=txtGemmenShinseiRiyu;
    }

    @JsonProperty("txtGemmenKetteiYMD")
    public TextBoxDate getTxtGemmenKetteiYMD() {
        return txtGemmenKetteiYMD;
    }

    @JsonProperty("txtGemmenKetteiYMD")
    public void setTxtGemmenKetteiYMD(TextBoxDate txtGemmenKetteiYMD) {
        this.txtGemmenKetteiYMD=txtGemmenKetteiYMD;
    }

    @JsonProperty("txtGemmenShurui")
    public TextBox getTxtGemmenShurui() {
        return txtGemmenShurui;
    }

    @JsonProperty("txtGemmenShurui")
    public void setTxtGemmenShurui(TextBox txtGemmenShurui) {
        this.txtGemmenShurui=txtGemmenShurui;
    }

    @JsonProperty("txtGemmenShouninRiyu")
    public TextBox getTxtGemmenShouninRiyu() {
        return txtGemmenShouninRiyu;
    }

    @JsonProperty("txtGemmenShouninRiyu")
    public void setTxtGemmenShouninRiyu(TextBox txtGemmenShouninRiyu) {
        this.txtGemmenShouninRiyu=txtGemmenShouninRiyu;
    }

}

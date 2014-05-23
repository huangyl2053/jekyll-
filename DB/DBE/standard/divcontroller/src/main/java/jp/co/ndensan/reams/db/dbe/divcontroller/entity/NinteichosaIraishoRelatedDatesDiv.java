package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
 * NinteichosaIraishoRelatedDates のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaIraishoRelatedDatesDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShoriDateOfChosa")
    private Label lblShoriDateOfChosa;
    @JsonProperty("txtShoriDateOfChosa")
    private TextBoxDate txtShoriDateOfChosa;
    @JsonProperty("lblHakkoDateOfChosa")
    private Label lblHakkoDateOfChosa;
    @JsonProperty("txtHakkoDateOfChosa")
    private TextBoxDate txtHakkoDateOfChosa;
    @JsonProperty("lblKigenDateOfChosa")
    private Label lblKigenDateOfChosa;
    @JsonProperty("txtKigenDateOfChosa")
    private TextBoxDate txtKigenDateOfChosa;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShoriDateOfChosa")
    public Label getLblShoriDateOfChosa() {
        return lblShoriDateOfChosa;
    }

    @JsonProperty("lblShoriDateOfChosa")
    public void setLblShoriDateOfChosa(Label lblShoriDateOfChosa) {
        this.lblShoriDateOfChosa=lblShoriDateOfChosa;
    }

    @JsonProperty("txtShoriDateOfChosa")
    public TextBoxDate getTxtShoriDateOfChosa() {
        return txtShoriDateOfChosa;
    }

    @JsonProperty("txtShoriDateOfChosa")
    public void setTxtShoriDateOfChosa(TextBoxDate txtShoriDateOfChosa) {
        this.txtShoriDateOfChosa=txtShoriDateOfChosa;
    }

    @JsonProperty("lblHakkoDateOfChosa")
    public Label getLblHakkoDateOfChosa() {
        return lblHakkoDateOfChosa;
    }

    @JsonProperty("lblHakkoDateOfChosa")
    public void setLblHakkoDateOfChosa(Label lblHakkoDateOfChosa) {
        this.lblHakkoDateOfChosa=lblHakkoDateOfChosa;
    }

    @JsonProperty("txtHakkoDateOfChosa")
    public TextBoxDate getTxtHakkoDateOfChosa() {
        return txtHakkoDateOfChosa;
    }

    @JsonProperty("txtHakkoDateOfChosa")
    public void setTxtHakkoDateOfChosa(TextBoxDate txtHakkoDateOfChosa) {
        this.txtHakkoDateOfChosa=txtHakkoDateOfChosa;
    }

    @JsonProperty("lblKigenDateOfChosa")
    public Label getLblKigenDateOfChosa() {
        return lblKigenDateOfChosa;
    }

    @JsonProperty("lblKigenDateOfChosa")
    public void setLblKigenDateOfChosa(Label lblKigenDateOfChosa) {
        this.lblKigenDateOfChosa=lblKigenDateOfChosa;
    }

    @JsonProperty("txtKigenDateOfChosa")
    public TextBoxDate getTxtKigenDateOfChosa() {
        return txtKigenDateOfChosa;
    }

    @JsonProperty("txtKigenDateOfChosa")
    public void setTxtKigenDateOfChosa(TextBoxDate txtKigenDateOfChosa) {
        this.txtKigenDateOfChosa=txtKigenDateOfChosa;
    }

}

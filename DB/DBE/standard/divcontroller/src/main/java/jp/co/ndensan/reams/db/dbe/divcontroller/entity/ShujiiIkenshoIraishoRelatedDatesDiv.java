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
 * ShujiiIkenshoIraishoRelatedDates のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoIraishoRelatedDatesDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShoriDateOfIkensho")
    private Label lblShoriDateOfIkensho;
    @JsonProperty("txtShoriDateOfIkensho")
    private TextBoxDate txtShoriDateOfIkensho;
    @JsonProperty("lblHakkoDateOfIkensho")
    private Label lblHakkoDateOfIkensho;
    @JsonProperty("txtHakkoDateOfIkensho")
    private TextBoxDate txtHakkoDateOfIkensho;
    @JsonProperty("lblKigenDateOfIkensho")
    private Label lblKigenDateOfIkensho;
    @JsonProperty("txtKigenDateOfIkensho")
    private TextBoxDate txtKigenDateOfIkensho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShoriDateOfIkensho")
    public Label getLblShoriDateOfIkensho() {
        return lblShoriDateOfIkensho;
    }

    @JsonProperty("lblShoriDateOfIkensho")
    public void setLblShoriDateOfIkensho(Label lblShoriDateOfIkensho) {
        this.lblShoriDateOfIkensho=lblShoriDateOfIkensho;
    }

    @JsonProperty("txtShoriDateOfIkensho")
    public TextBoxDate getTxtShoriDateOfIkensho() {
        return txtShoriDateOfIkensho;
    }

    @JsonProperty("txtShoriDateOfIkensho")
    public void setTxtShoriDateOfIkensho(TextBoxDate txtShoriDateOfIkensho) {
        this.txtShoriDateOfIkensho=txtShoriDateOfIkensho;
    }

    @JsonProperty("lblHakkoDateOfIkensho")
    public Label getLblHakkoDateOfIkensho() {
        return lblHakkoDateOfIkensho;
    }

    @JsonProperty("lblHakkoDateOfIkensho")
    public void setLblHakkoDateOfIkensho(Label lblHakkoDateOfIkensho) {
        this.lblHakkoDateOfIkensho=lblHakkoDateOfIkensho;
    }

    @JsonProperty("txtHakkoDateOfIkensho")
    public TextBoxDate getTxtHakkoDateOfIkensho() {
        return txtHakkoDateOfIkensho;
    }

    @JsonProperty("txtHakkoDateOfIkensho")
    public void setTxtHakkoDateOfIkensho(TextBoxDate txtHakkoDateOfIkensho) {
        this.txtHakkoDateOfIkensho=txtHakkoDateOfIkensho;
    }

    @JsonProperty("lblKigenDateOfIkensho")
    public Label getLblKigenDateOfIkensho() {
        return lblKigenDateOfIkensho;
    }

    @JsonProperty("lblKigenDateOfIkensho")
    public void setLblKigenDateOfIkensho(Label lblKigenDateOfIkensho) {
        this.lblKigenDateOfIkensho=lblKigenDateOfIkensho;
    }

    @JsonProperty("txtKigenDateOfIkensho")
    public TextBoxDate getTxtKigenDateOfIkensho() {
        return txtKigenDateOfIkensho;
    }

    @JsonProperty("txtKigenDateOfIkensho")
    public void setTxtKigenDateOfIkensho(TextBoxDate txtKigenDateOfIkensho) {
        this.txtKigenDateOfIkensho=txtKigenDateOfIkensho;
    }

}

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
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
    @JsonProperty("txtShoriDateOfIkensho")
    private TextBoxDate txtShoriDateOfIkensho;
    @JsonProperty("txtHakkoDateOfIkensho")
    private TextBoxDate txtHakkoDateOfIkensho;
    @JsonProperty("txtKigenDateOfIkensho")
    private TextBoxDate txtKigenDateOfIkensho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShoriDateOfIkensho")
    public TextBoxDate getTxtShoriDateOfIkensho() {
        return txtShoriDateOfIkensho;
    }

    @JsonProperty("txtShoriDateOfIkensho")
    public void setTxtShoriDateOfIkensho(TextBoxDate txtShoriDateOfIkensho) {
        this.txtShoriDateOfIkensho=txtShoriDateOfIkensho;
    }

    @JsonProperty("txtHakkoDateOfIkensho")
    public TextBoxDate getTxtHakkoDateOfIkensho() {
        return txtHakkoDateOfIkensho;
    }

    @JsonProperty("txtHakkoDateOfIkensho")
    public void setTxtHakkoDateOfIkensho(TextBoxDate txtHakkoDateOfIkensho) {
        this.txtHakkoDateOfIkensho=txtHakkoDateOfIkensho;
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

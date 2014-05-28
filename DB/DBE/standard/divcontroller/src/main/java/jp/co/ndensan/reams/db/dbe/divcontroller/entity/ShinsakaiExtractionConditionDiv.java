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
 * ShinsakaiExtractionCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiExtractionConditionDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKaisaiDate")
    private Label lblKaisaiDate;
    @JsonProperty("txtKaisaiDate")
    private TextBoxDate txtKaisaiDate;
    @JsonProperty("lblAfterThis")
    private Label lblAfterThis;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKaisaiDate")
    public Label getLblKaisaiDate() {
        return lblKaisaiDate;
    }

    @JsonProperty("lblKaisaiDate")
    public void setLblKaisaiDate(Label lblKaisaiDate) {
        this.lblKaisaiDate=lblKaisaiDate;
    }

    @JsonProperty("txtKaisaiDate")
    public TextBoxDate getTxtKaisaiDate() {
        return txtKaisaiDate;
    }

    @JsonProperty("txtKaisaiDate")
    public void setTxtKaisaiDate(TextBoxDate txtKaisaiDate) {
        this.txtKaisaiDate=txtKaisaiDate;
    }

    @JsonProperty("lblAfterThis")
    public Label getLblAfterThis() {
        return lblAfterThis;
    }

    @JsonProperty("lblAfterThis")
    public void setLblAfterThis(Label lblAfterThis) {
        this.lblAfterThis=lblAfterThis;
    }

}

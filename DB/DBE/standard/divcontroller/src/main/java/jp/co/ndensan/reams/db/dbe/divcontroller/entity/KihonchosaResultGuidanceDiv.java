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
 * KihonchosaResultGuidance のクラスファイル 
 * 
 * @author 自動生成
 */
public class KihonchosaResultGuidanceDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblItemNo")
    private Label lblItemNo;
    @JsonProperty("lblItemName")
    private Label lblItemName;
    @JsonProperty("btnToEditTokkijiko")
    private Button btnToEditTokkijiko;
    @JsonProperty("lblPaddingItemNo")
    private Label lblPaddingItemNo;
    @JsonProperty("radChoices")
    private RadioButton radChoices;
    @JsonProperty("btnSelectPrevious")
    private Button btnSelectPrevious;
    @JsonProperty("btnSelectNext")
    private Button btnSelectNext;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblItemNo")
    public Label getLblItemNo() {
        return lblItemNo;
    }

    @JsonProperty("lblItemNo")
    public void setLblItemNo(Label lblItemNo) {
        this.lblItemNo=lblItemNo;
    }

    @JsonProperty("lblItemName")
    public Label getLblItemName() {
        return lblItemName;
    }

    @JsonProperty("lblItemName")
    public void setLblItemName(Label lblItemName) {
        this.lblItemName=lblItemName;
    }

    @JsonProperty("btnToEditTokkijiko")
    public Button getBtnToEditTokkijiko() {
        return btnToEditTokkijiko;
    }

    @JsonProperty("btnToEditTokkijiko")
    public void setBtnToEditTokkijiko(Button btnToEditTokkijiko) {
        this.btnToEditTokkijiko=btnToEditTokkijiko;
    }

    @JsonProperty("lblPaddingItemNo")
    public Label getLblPaddingItemNo() {
        return lblPaddingItemNo;
    }

    @JsonProperty("lblPaddingItemNo")
    public void setLblPaddingItemNo(Label lblPaddingItemNo) {
        this.lblPaddingItemNo=lblPaddingItemNo;
    }

    @JsonProperty("radChoices")
    public RadioButton getRadChoices() {
        return radChoices;
    }

    @JsonProperty("radChoices")
    public void setRadChoices(RadioButton radChoices) {
        this.radChoices=radChoices;
    }

    @JsonProperty("btnSelectPrevious")
    public Button getBtnSelectPrevious() {
        return btnSelectPrevious;
    }

    @JsonProperty("btnSelectPrevious")
    public void setBtnSelectPrevious(Button btnSelectPrevious) {
        this.btnSelectPrevious=btnSelectPrevious;
    }

    @JsonProperty("btnSelectNext")
    public Button getBtnSelectNext() {
        return btnSelectNext;
    }

    @JsonProperty("btnSelectNext")
    public void setBtnSelectNext(Button btnSelectNext) {
        this.btnSelectNext=btnSelectNext;
    }

}

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
 * YokaigoNintei のクラスファイル 
 * 
 * @author 自動生成
 */
public class YokaigoNinteiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinseiDateRange")
    private Label lblShinseiDateRange;
    @JsonProperty("txtShinseiDateRange")
    private TextBoxDateRange txtShinseiDateRange;
    @JsonProperty("lblNinteiKetteiDateRange")
    private Label lblNinteiKetteiDateRange;
    @JsonProperty("txtNinteiDate")
    private TextBoxDateRange txtNinteiDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinseiDateRange")
    public Label getLblShinseiDateRange() {
        return lblShinseiDateRange;
    }

    @JsonProperty("lblShinseiDateRange")
    public void setLblShinseiDateRange(Label lblShinseiDateRange) {
        this.lblShinseiDateRange=lblShinseiDateRange;
    }

    @JsonProperty("txtShinseiDateRange")
    public TextBoxDateRange getTxtShinseiDateRange() {
        return txtShinseiDateRange;
    }

    @JsonProperty("txtShinseiDateRange")
    public void setTxtShinseiDateRange(TextBoxDateRange txtShinseiDateRange) {
        this.txtShinseiDateRange=txtShinseiDateRange;
    }

    @JsonProperty("lblNinteiKetteiDateRange")
    public Label getLblNinteiKetteiDateRange() {
        return lblNinteiKetteiDateRange;
    }

    @JsonProperty("lblNinteiKetteiDateRange")
    public void setLblNinteiKetteiDateRange(Label lblNinteiKetteiDateRange) {
        this.lblNinteiKetteiDateRange=lblNinteiKetteiDateRange;
    }

    @JsonProperty("txtNinteiDate")
    public TextBoxDateRange getTxtNinteiDate() {
        return txtNinteiDate;
    }

    @JsonProperty("txtNinteiDate")
    public void setTxtNinteiDate(TextBoxDateRange txtNinteiDate) {
        this.txtNinteiDate=txtNinteiDate;
    }

}

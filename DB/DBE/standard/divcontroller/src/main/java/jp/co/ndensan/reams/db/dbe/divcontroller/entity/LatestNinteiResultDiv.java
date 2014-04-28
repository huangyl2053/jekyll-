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
 * LatestNinteiResult のクラスファイル 
 * 
 * @author 自動生成
 */
public class LatestNinteiResultDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblYokaigodo")
    private Label lblYokaigodo;
    @JsonProperty("txtYokaigodo")
    private TextBoxCode txtYokaigodo;
    @JsonProperty("lblNinteiDate")
    private Label lblNinteiDate;
    @JsonProperty("txtNinteiDate")
    private TextBoxDate txtNinteiDate;
    @JsonProperty("lblYukoKikan")
    private Label lblYukoKikan;
    @JsonProperty("txtNinteiYukokikan")
    private TextBoxDateRange txtNinteiYukokikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblYokaigodo")
    public Label getLblYokaigodo() {
        return lblYokaigodo;
    }

    @JsonProperty("lblYokaigodo")
    public void setLblYokaigodo(Label lblYokaigodo) {
        this.lblYokaigodo=lblYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public TextBoxCode getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBoxCode txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("lblNinteiDate")
    public Label getLblNinteiDate() {
        return lblNinteiDate;
    }

    @JsonProperty("lblNinteiDate")
    public void setLblNinteiDate(Label lblNinteiDate) {
        this.lblNinteiDate=lblNinteiDate;
    }

    @JsonProperty("txtNinteiDate")
    public TextBoxDate getTxtNinteiDate() {
        return txtNinteiDate;
    }

    @JsonProperty("txtNinteiDate")
    public void setTxtNinteiDate(TextBoxDate txtNinteiDate) {
        this.txtNinteiDate=txtNinteiDate;
    }

    @JsonProperty("lblYukoKikan")
    public Label getLblYukoKikan() {
        return lblYukoKikan;
    }

    @JsonProperty("lblYukoKikan")
    public void setLblYukoKikan(Label lblYukoKikan) {
        this.lblYukoKikan=lblYukoKikan;
    }

    @JsonProperty("txtNinteiYukokikan")
    public TextBoxDateRange getTxtNinteiYukokikan() {
        return txtNinteiYukokikan;
    }

    @JsonProperty("txtNinteiYukokikan")
    public void setTxtNinteiYukokikan(TextBoxDateRange txtNinteiYukokikan) {
        this.txtNinteiYukokikan=txtNinteiYukokikan;
    }

}

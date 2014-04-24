package jp.co.ndensan.reams.db.dba.divcontroller.entity;
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
 * DBCommonInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class DBCommonInfoPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiKikan")
    private TextBoxDateRange txtNinteiKikan;
    @JsonProperty("txtKyuHihokenshaNo")
    private TextBox txtKyuHihokenshaNo;
    @JsonProperty("KyuShichosonLabel")
    private Label KyuShichosonLabel;
    @JsonProperty("txtKyuShichosonCode")
    private TextBoxCode txtKyuShichosonCode;
    @JsonProperty("txtKyuShichoson")
    private TextBox txtKyuShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtNinteiKikan")
    public TextBoxDateRange getTxtNinteiKikan() {
        return txtNinteiKikan;
    }

    @JsonProperty("txtNinteiKikan")
    public void setTxtNinteiKikan(TextBoxDateRange txtNinteiKikan) {
        this.txtNinteiKikan=txtNinteiKikan;
    }

    @JsonProperty("txtKyuHihokenshaNo")
    public TextBox getTxtKyuHihokenshaNo() {
        return txtKyuHihokenshaNo;
    }

    @JsonProperty("txtKyuHihokenshaNo")
    public void setTxtKyuHihokenshaNo(TextBox txtKyuHihokenshaNo) {
        this.txtKyuHihokenshaNo=txtKyuHihokenshaNo;
    }

    @JsonProperty("KyuShichosonLabel")
    public Label getKyuShichosonLabel() {
        return KyuShichosonLabel;
    }

    @JsonProperty("KyuShichosonLabel")
    public void setKyuShichosonLabel(Label KyuShichosonLabel) {
        this.KyuShichosonLabel=KyuShichosonLabel;
    }

    @JsonProperty("txtKyuShichosonCode")
    public TextBoxCode getTxtKyuShichosonCode() {
        return txtKyuShichosonCode;
    }

    @JsonProperty("txtKyuShichosonCode")
    public void setTxtKyuShichosonCode(TextBoxCode txtKyuShichosonCode) {
        this.txtKyuShichosonCode=txtKyuShichosonCode;
    }

    @JsonProperty("txtKyuShichoson")
    public TextBox getTxtKyuShichoson() {
        return txtKyuShichoson;
    }

    @JsonProperty("txtKyuShichoson")
    public void setTxtKyuShichoson(TextBox txtKyuShichoson) {
        this.txtKyuShichoson=txtKyuShichoson;
    }

}

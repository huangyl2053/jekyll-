package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0410011;
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
 * HihokenshashoHakkoTaishoshaDbJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshashoHakkoTaishoshaDbJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiKikan")
    private TextBoxDateRange txtNinteiKikan;
    @JsonProperty("txtKyuHihokenshaNo")
    private TextBoxCode txtKyuHihokenshaNo;
    @JsonProperty("txtKyuShichoson")
    private TextBox txtKyuShichoson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
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
    public TextBoxCode getTxtKyuHihokenshaNo() {
        return txtKyuHihokenshaNo;
    }

    @JsonProperty("txtKyuHihokenshaNo")
    public void setTxtKyuHihokenshaNo(TextBoxCode txtKyuHihokenshaNo) {
        this.txtKyuHihokenshaNo=txtKyuHihokenshaNo;
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

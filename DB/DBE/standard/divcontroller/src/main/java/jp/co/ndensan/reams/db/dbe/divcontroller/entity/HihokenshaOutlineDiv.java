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
 * HihokenshaOutline のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaOutlineDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHihokenshaNo")
    private Label lblHihokenshaNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("lblHihokenshaKubun")
    private Label lblHihokenshaKubun;
    @JsonProperty("txtHihokenshaKubun")
    private TextBox txtHihokenshaKubun;
    @JsonProperty("lblShimsei")
    private Label lblShimsei;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblHihokenshaNo")
    public Label getLblHihokenshaNo() {
        return lblHihokenshaNo;
    }

    @JsonProperty("lblHihokenshaNo")
    public void setLblHihokenshaNo(Label lblHihokenshaNo) {
        this.lblHihokenshaNo=lblHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("lblHihokenshaKubun")
    public Label getLblHihokenshaKubun() {
        return lblHihokenshaKubun;
    }

    @JsonProperty("lblHihokenshaKubun")
    public void setLblHihokenshaKubun(Label lblHihokenshaKubun) {
        this.lblHihokenshaKubun=lblHihokenshaKubun;
    }

    @JsonProperty("txtHihokenshaKubun")
    public TextBox getTxtHihokenshaKubun() {
        return txtHihokenshaKubun;
    }

    @JsonProperty("txtHihokenshaKubun")
    public void setTxtHihokenshaKubun(TextBox txtHihokenshaKubun) {
        this.txtHihokenshaKubun=txtHihokenshaKubun;
    }

    @JsonProperty("lblShimsei")
    public Label getLblShimsei() {
        return lblShimsei;
    }

    @JsonProperty("lblShimsei")
    public void setLblShimsei(Label lblShimsei) {
        this.lblShimsei=lblShimsei;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

}

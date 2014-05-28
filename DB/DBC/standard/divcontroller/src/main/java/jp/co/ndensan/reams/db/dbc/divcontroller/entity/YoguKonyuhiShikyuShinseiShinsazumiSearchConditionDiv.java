package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
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
 * YoguKonyuhiShikyuShinseiShinsazumiSearchCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiShinsazumiSearchConditionDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinsaDateRange")
    private TextBoxDateRange txtShinsaDateRange;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("btnSearchShinsazumi")
    private Button btnSearchShinsazumi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinsaDateRange")
    public TextBoxDateRange getTxtShinsaDateRange() {
        return txtShinsaDateRange;
    }

    @JsonProperty("txtShinsaDateRange")
    public void setTxtShinsaDateRange(TextBoxDateRange txtShinsaDateRange) {
        this.txtShinsaDateRange=txtShinsaDateRange;
    }

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("btnSearchShinsazumi")
    public Button getBtnSearchShinsazumi() {
        return btnSearchShinsazumi;
    }

    @JsonProperty("btnSearchShinsazumi")
    public void setBtnSearchShinsazumi(Button btnSearchShinsazumi) {
        this.btnSearchShinsazumi=btnSearchShinsazumi;
    }

}

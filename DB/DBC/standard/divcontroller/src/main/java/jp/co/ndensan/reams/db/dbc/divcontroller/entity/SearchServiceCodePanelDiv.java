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
 * SearchServiceCodePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchServiceCodePanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchServiceShuruiCode")
    private TextBoxCode txtSearchServiceShuruiCode;
    @JsonProperty("txtSearchServiceItemCode")
    private TextBoxCode txtSearchServiceItemCode;
    @JsonProperty("btnSearchServiceCodeDialog")
    private ButtonDialog btnSearchServiceCodeDialog;
    @JsonProperty("txtSearchServiceName")
    private TextBox txtSearchServiceName;
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtSearchServiceShuruiCode")
    public TextBoxCode getTxtSearchServiceShuruiCode() {
        return txtSearchServiceShuruiCode;
    }

    @JsonProperty("txtSearchServiceShuruiCode")
    public void setTxtSearchServiceShuruiCode(TextBoxCode txtSearchServiceShuruiCode) {
        this.txtSearchServiceShuruiCode=txtSearchServiceShuruiCode;
    }

    @JsonProperty("txtSearchServiceItemCode")
    public TextBoxCode getTxtSearchServiceItemCode() {
        return txtSearchServiceItemCode;
    }

    @JsonProperty("txtSearchServiceItemCode")
    public void setTxtSearchServiceItemCode(TextBoxCode txtSearchServiceItemCode) {
        this.txtSearchServiceItemCode=txtSearchServiceItemCode;
    }

    @JsonProperty("btnSearchServiceCodeDialog")
    public ButtonDialog getBtnSearchServiceCodeDialog() {
        return btnSearchServiceCodeDialog;
    }

    @JsonProperty("btnSearchServiceCodeDialog")
    public void setBtnSearchServiceCodeDialog(ButtonDialog btnSearchServiceCodeDialog) {
        this.btnSearchServiceCodeDialog=btnSearchServiceCodeDialog;
    }

    @JsonProperty("txtSearchServiceName")
    public TextBox getTxtSearchServiceName() {
        return txtSearchServiceName;
    }

    @JsonProperty("txtSearchServiceName")
    public void setTxtSearchServiceName(TextBox txtSearchServiceName) {
        this.txtSearchServiceName=txtSearchServiceName;
    }

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch=btnSearch;
    }

}

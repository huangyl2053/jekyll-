package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1400011;
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
 * SearchToKyufujissekiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchToKyufujissekiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("btnSearchJigyosha")
    private ButtonDialog btnSearchJigyosha;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private ButtonDialog btnSearchHihokensha;
    @JsonProperty("txtHihoName")
    private TextBox txtHihoName;
    @JsonProperty("txtTeikyoYMRange")
    private TextBoxDateRange txtTeikyoYMRange;
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
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo=txtJigyoshaNo;
    }

    @JsonProperty("btnSearchJigyosha")
    public ButtonDialog getBtnSearchJigyosha() {
        return btnSearchJigyosha;
    }

    @JsonProperty("btnSearchJigyosha")
    public void setBtnSearchJigyosha(ButtonDialog btnSearchJigyosha) {
        this.btnSearchJigyosha=btnSearchJigyosha;
    }

    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName=txtJigyoshaName;
    }

    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo=txtHihoNo;
    }

    @JsonProperty("btnSearchHihokensha")
    public ButtonDialog getBtnSearchHihokensha() {
        return btnSearchHihokensha;
    }

    @JsonProperty("btnSearchHihokensha")
    public void setBtnSearchHihokensha(ButtonDialog btnSearchHihokensha) {
        this.btnSearchHihokensha=btnSearchHihokensha;
    }

    @JsonProperty("txtHihoName")
    public TextBox getTxtHihoName() {
        return txtHihoName;
    }

    @JsonProperty("txtHihoName")
    public void setTxtHihoName(TextBox txtHihoName) {
        this.txtHihoName=txtHihoName;
    }

    @JsonProperty("txtTeikyoYMRange")
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return txtTeikyoYMRange;
    }

    @JsonProperty("txtTeikyoYMRange")
    public void setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.txtTeikyoYMRange=txtTeikyoYMRange;
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

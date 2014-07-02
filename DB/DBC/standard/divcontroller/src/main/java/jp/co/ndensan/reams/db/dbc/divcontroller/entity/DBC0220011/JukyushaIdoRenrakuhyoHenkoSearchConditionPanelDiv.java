package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0220011;
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
 * JukyushaIdoRenrakuhyoHenkoSearchConditionPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIdoDateRange")
    private TextBoxDateRange txtIdoDateRange;
    @JsonProperty("txtSearchHihoNo")
    private TextBoxCode txtSearchHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private Button btnSearchHihokensha;
    @JsonProperty("ddlShichosonCode")
    private DropDownList ddlShichosonCode;
    @JsonProperty("chkIsSearchDeletedData")
    private CheckBoxList chkIsSearchDeletedData;
    @JsonProperty("lblSearchCondition")
    private Label lblSearchCondition;
    @JsonProperty("btnClearSearchCondition")
    private Button btnClearSearchCondition;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("btnKari")
    private Button btnKari;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIdoDateRange")
    public TextBoxDateRange getTxtIdoDateRange() {
        return txtIdoDateRange;
    }

    @JsonProperty("txtIdoDateRange")
    public void setTxtIdoDateRange(TextBoxDateRange txtIdoDateRange) {
        this.txtIdoDateRange=txtIdoDateRange;
    }

    @JsonProperty("txtSearchHihoNo")
    public TextBoxCode getTxtSearchHihoNo() {
        return txtSearchHihoNo;
    }

    @JsonProperty("txtSearchHihoNo")
    public void setTxtSearchHihoNo(TextBoxCode txtSearchHihoNo) {
        this.txtSearchHihoNo=txtSearchHihoNo;
    }

    @JsonProperty("btnSearchHihokensha")
    public Button getBtnSearchHihokensha() {
        return btnSearchHihokensha;
    }

    @JsonProperty("btnSearchHihokensha")
    public void setBtnSearchHihokensha(Button btnSearchHihokensha) {
        this.btnSearchHihokensha=btnSearchHihokensha;
    }

    @JsonProperty("ddlShichosonCode")
    public DropDownList getDdlShichosonCode() {
        return ddlShichosonCode;
    }

    @JsonProperty("ddlShichosonCode")
    public void setDdlShichosonCode(DropDownList ddlShichosonCode) {
        this.ddlShichosonCode=ddlShichosonCode;
    }

    @JsonProperty("chkIsSearchDeletedData")
    public CheckBoxList getChkIsSearchDeletedData() {
        return chkIsSearchDeletedData;
    }

    @JsonProperty("chkIsSearchDeletedData")
    public void setChkIsSearchDeletedData(CheckBoxList chkIsSearchDeletedData) {
        this.chkIsSearchDeletedData=chkIsSearchDeletedData;
    }

    @JsonProperty("lblSearchCondition")
    public Label getLblSearchCondition() {
        return lblSearchCondition;
    }

    @JsonProperty("lblSearchCondition")
    public void setLblSearchCondition(Label lblSearchCondition) {
        this.lblSearchCondition=lblSearchCondition;
    }

    @JsonProperty("btnClearSearchCondition")
    public Button getBtnClearSearchCondition() {
        return btnClearSearchCondition;
    }

    @JsonProperty("btnClearSearchCondition")
    public void setBtnClearSearchCondition(Button btnClearSearchCondition) {
        this.btnClearSearchCondition=btnClearSearchCondition;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch=btnSearch;
    }

    @JsonProperty("btnKari")
    public Button getBtnKari() {
        return btnKari;
    }

    @JsonProperty("btnKari")
    public void setBtnKari(Button btnKari) {
        this.btnKari=btnKari;
    }

}

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
 * YoguKonyuhiShikyuShinseiSeikyuDetailInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiSeikyuDetailInputDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtBuyYMD")
    private TextBoxDate txtBuyYMD;
    @JsonProperty("ddlShumoku")
    private DropDownList ddlShumoku;
    @JsonProperty("txtShohinName")
    private TextBox txtShohinName;
    @JsonProperty("btnShohinmeiSearch")
    private Button btnShohinmeiSearch;
    @JsonProperty("txtSeizoJigyosha")
    private TextBox txtSeizoJigyosha;
    @JsonProperty("txtHanbaiJigyosha")
    private TextBox txtHanbaiJigyosha;
    @JsonProperty("txtBuyAmount")
    private TextBoxNum txtBuyAmount;
    @JsonProperty("txtHinmokuCode")
    private TextBoxCode txtHinmokuCode;
    @JsonProperty("radShinsaMethod")
    private RadioButton radShinsaMethod;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnModifyDetail")
    private Button btnModifyDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtBuyYMD")
    public TextBoxDate getTxtBuyYMD() {
        return txtBuyYMD;
    }

    @JsonProperty("txtBuyYMD")
    public void setTxtBuyYMD(TextBoxDate txtBuyYMD) {
        this.txtBuyYMD=txtBuyYMD;
    }

    @JsonProperty("ddlShumoku")
    public DropDownList getDdlShumoku() {
        return ddlShumoku;
    }

    @JsonProperty("ddlShumoku")
    public void setDdlShumoku(DropDownList ddlShumoku) {
        this.ddlShumoku=ddlShumoku;
    }

    @JsonProperty("txtShohinName")
    public TextBox getTxtShohinName() {
        return txtShohinName;
    }

    @JsonProperty("txtShohinName")
    public void setTxtShohinName(TextBox txtShohinName) {
        this.txtShohinName=txtShohinName;
    }

    @JsonProperty("btnShohinmeiSearch")
    public Button getBtnShohinmeiSearch() {
        return btnShohinmeiSearch;
    }

    @JsonProperty("btnShohinmeiSearch")
    public void setBtnShohinmeiSearch(Button btnShohinmeiSearch) {
        this.btnShohinmeiSearch=btnShohinmeiSearch;
    }

    @JsonProperty("txtSeizoJigyosha")
    public TextBox getTxtSeizoJigyosha() {
        return txtSeizoJigyosha;
    }

    @JsonProperty("txtSeizoJigyosha")
    public void setTxtSeizoJigyosha(TextBox txtSeizoJigyosha) {
        this.txtSeizoJigyosha=txtSeizoJigyosha;
    }

    @JsonProperty("txtHanbaiJigyosha")
    public TextBox getTxtHanbaiJigyosha() {
        return txtHanbaiJigyosha;
    }

    @JsonProperty("txtHanbaiJigyosha")
    public void setTxtHanbaiJigyosha(TextBox txtHanbaiJigyosha) {
        this.txtHanbaiJigyosha=txtHanbaiJigyosha;
    }

    @JsonProperty("txtBuyAmount")
    public TextBoxNum getTxtBuyAmount() {
        return txtBuyAmount;
    }

    @JsonProperty("txtBuyAmount")
    public void setTxtBuyAmount(TextBoxNum txtBuyAmount) {
        this.txtBuyAmount=txtBuyAmount;
    }

    @JsonProperty("txtHinmokuCode")
    public TextBoxCode getTxtHinmokuCode() {
        return txtHinmokuCode;
    }

    @JsonProperty("txtHinmokuCode")
    public void setTxtHinmokuCode(TextBoxCode txtHinmokuCode) {
        this.txtHinmokuCode=txtHinmokuCode;
    }

    @JsonProperty("radShinsaMethod")
    public RadioButton getRadShinsaMethod() {
        return radShinsaMethod;
    }

    @JsonProperty("radShinsaMethod")
    public void setRadShinsaMethod(RadioButton radShinsaMethod) {
        this.radShinsaMethod=radShinsaMethod;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("btnModifyDetail")
    public Button getBtnModifyDetail() {
        return btnModifyDetail;
    }

    @JsonProperty("btnModifyDetail")
    public void setBtnModifyDetail(Button btnModifyDetail) {
        this.btnModifyDetail=btnModifyDetail;
    }

}

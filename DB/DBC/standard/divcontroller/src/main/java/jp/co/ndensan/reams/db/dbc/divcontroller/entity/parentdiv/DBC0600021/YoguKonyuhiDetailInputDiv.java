package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoguKonyuhiDetailInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiDetailInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    /*
     * gettxtBuyYMD
     * @return txtBuyYMD
     */
    @JsonProperty("txtBuyYMD")
    public TextBoxDate getTxtBuyYMD() {
        return txtBuyYMD;
    }

    /*
     * settxtBuyYMD
     * @param txtBuyYMD txtBuyYMD
     */
    @JsonProperty("txtBuyYMD")
    public void setTxtBuyYMD(TextBoxDate txtBuyYMD) {
        this.txtBuyYMD = txtBuyYMD;
    }

    /*
     * getddlShumoku
     * @return ddlShumoku
     */
    @JsonProperty("ddlShumoku")
    public DropDownList getDdlShumoku() {
        return ddlShumoku;
    }

    /*
     * setddlShumoku
     * @param ddlShumoku ddlShumoku
     */
    @JsonProperty("ddlShumoku")
    public void setDdlShumoku(DropDownList ddlShumoku) {
        this.ddlShumoku = ddlShumoku;
    }

    /*
     * gettxtShohinName
     * @return txtShohinName
     */
    @JsonProperty("txtShohinName")
    public TextBox getTxtShohinName() {
        return txtShohinName;
    }

    /*
     * settxtShohinName
     * @param txtShohinName txtShohinName
     */
    @JsonProperty("txtShohinName")
    public void setTxtShohinName(TextBox txtShohinName) {
        this.txtShohinName = txtShohinName;
    }

    /*
     * getbtnShohinmeiSearch
     * @return btnShohinmeiSearch
     */
    @JsonProperty("btnShohinmeiSearch")
    public Button getBtnShohinmeiSearch() {
        return btnShohinmeiSearch;
    }

    /*
     * setbtnShohinmeiSearch
     * @param btnShohinmeiSearch btnShohinmeiSearch
     */
    @JsonProperty("btnShohinmeiSearch")
    public void setBtnShohinmeiSearch(Button btnShohinmeiSearch) {
        this.btnShohinmeiSearch = btnShohinmeiSearch;
    }

    /*
     * gettxtSeizoJigyosha
     * @return txtSeizoJigyosha
     */
    @JsonProperty("txtSeizoJigyosha")
    public TextBox getTxtSeizoJigyosha() {
        return txtSeizoJigyosha;
    }

    /*
     * settxtSeizoJigyosha
     * @param txtSeizoJigyosha txtSeizoJigyosha
     */
    @JsonProperty("txtSeizoJigyosha")
    public void setTxtSeizoJigyosha(TextBox txtSeizoJigyosha) {
        this.txtSeizoJigyosha = txtSeizoJigyosha;
    }

    /*
     * gettxtHanbaiJigyosha
     * @return txtHanbaiJigyosha
     */
    @JsonProperty("txtHanbaiJigyosha")
    public TextBox getTxtHanbaiJigyosha() {
        return txtHanbaiJigyosha;
    }

    /*
     * settxtHanbaiJigyosha
     * @param txtHanbaiJigyosha txtHanbaiJigyosha
     */
    @JsonProperty("txtHanbaiJigyosha")
    public void setTxtHanbaiJigyosha(TextBox txtHanbaiJigyosha) {
        this.txtHanbaiJigyosha = txtHanbaiJigyosha;
    }

    /*
     * gettxtBuyAmount
     * @return txtBuyAmount
     */
    @JsonProperty("txtBuyAmount")
    public TextBoxNum getTxtBuyAmount() {
        return txtBuyAmount;
    }

    /*
     * settxtBuyAmount
     * @param txtBuyAmount txtBuyAmount
     */
    @JsonProperty("txtBuyAmount")
    public void setTxtBuyAmount(TextBoxNum txtBuyAmount) {
        this.txtBuyAmount = txtBuyAmount;
    }

    /*
     * gettxtHinmokuCode
     * @return txtHinmokuCode
     */
    @JsonProperty("txtHinmokuCode")
    public TextBoxCode getTxtHinmokuCode() {
        return txtHinmokuCode;
    }

    /*
     * settxtHinmokuCode
     * @param txtHinmokuCode txtHinmokuCode
     */
    @JsonProperty("txtHinmokuCode")
    public void setTxtHinmokuCode(TextBoxCode txtHinmokuCode) {
        this.txtHinmokuCode = txtHinmokuCode;
    }

    /*
     * getradShinsaMethod
     * @return radShinsaMethod
     */
    @JsonProperty("radShinsaMethod")
    public RadioButton getRadShinsaMethod() {
        return radShinsaMethod;
    }

    /*
     * setradShinsaMethod
     * @param radShinsaMethod radShinsaMethod
     */
    @JsonProperty("radShinsaMethod")
    public void setRadShinsaMethod(RadioButton radShinsaMethod) {
        this.radShinsaMethod = radShinsaMethod;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnModifyDetail
     * @return btnModifyDetail
     */
    @JsonProperty("btnModifyDetail")
    public Button getBtnModifyDetail() {
        return btnModifyDetail;
    }

    /*
     * setbtnModifyDetail
     * @param btnModifyDetail btnModifyDetail
     */
    @JsonProperty("btnModifyDetail")
    public void setBtnModifyDetail(Button btnModifyDetail) {
        this.btnModifyDetail = btnModifyDetail;
    }

    // </editor-fold>
}

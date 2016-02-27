package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.FukushiyoguShohinGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * FukushiyoguShohinGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class FukushiyoguShohinGuideDiv extends Panel implements IFukushiyoguShohinGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKijunDay")
    private TextBoxDate txtKijunDay;
    @JsonProperty("btnSelect")
    private Button btnSelect;
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgFukushiyoguShohin")
    private DataGrid<dgFukushiyoguShohin_Row> dgFukushiyoguShohin;
    @JsonProperty("panInput")
    private panInputDiv panInput;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("FukushiyoguShohinMode")
    private RString FukushiyoguShohinMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKijunDay
     * @return txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public TextBoxDate getTxtKijunDay() {
        return txtKijunDay;
    }

    /*
     * settxtKijunDay
     * @param txtKijunDay txtKijunDay
     */
    @JsonProperty("txtKijunDay")
    public void setTxtKijunDay(TextBoxDate txtKijunDay) {
        this.txtKijunDay = txtKijunDay;
    }

    /*
     * getbtnSelect
     * @return btnSelect
     */
    @JsonProperty("btnSelect")
    public Button getBtnSelect() {
        return btnSelect;
    }

    /*
     * setbtnSelect
     * @param btnSelect btnSelect
     */
    @JsonProperty("btnSelect")
    public void setBtnSelect(Button btnSelect) {
        this.btnSelect = btnSelect;
    }

    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgFukushiyoguShohin
     * @return dgFukushiyoguShohin
     */
    @JsonProperty("dgFukushiyoguShohin")
    public DataGrid<dgFukushiyoguShohin_Row> getDgFukushiyoguShohin() {
        return dgFukushiyoguShohin;
    }

    /*
     * setdgFukushiyoguShohin
     * @param dgFukushiyoguShohin dgFukushiyoguShohin
     */
    @JsonProperty("dgFukushiyoguShohin")
    public void setDgFukushiyoguShohin(DataGrid<dgFukushiyoguShohin_Row> dgFukushiyoguShohin) {
        this.dgFukushiyoguShohin = dgFukushiyoguShohin;
    }

    /*
     * getpanInput
     * @return panInput
     */
    @JsonProperty("panInput")
    public panInputDiv getPanInput() {
        return panInput;
    }

    /*
     * setpanInput
     * @param panInput panInput
     */
    @JsonProperty("panInput")
    public void setPanInput(panInputDiv panInput) {
        this.panInput = panInput;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * getFukushiyoguShohinMode
     * @return FukushiyoguShohinMode
     */
    @JsonProperty("FukushiyoguShohinMode")
    public RString getFukushiyoguShohinMode() {
        return FukushiyoguShohinMode;
    }

    /*
     * setFukushiyoguShohinMode
     * @param FukushiyoguShohinMode FukushiyoguShohinMode
     */
    @JsonProperty("FukushiyoguShohinMode")
    public void setFukushiyoguShohinMode(RString FukushiyoguShohinMode) {
        this.FukushiyoguShohinMode = FukushiyoguShohinMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtKanriKaishiDay() {
        return this.getPanInput().getTxtKanriKaishiDay();
    }

    @JsonIgnore
    public void  setTxtKanriKaishiDay(TextBoxDate txtKanriKaishiDay) {
        this.getPanInput().setTxtKanriKaishiDay(txtKanriKaishiDay);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanriShuryoDay() {
        return this.getPanInput().getTxtKanriShuryoDay();
    }

    @JsonIgnore
    public void  setTxtKanriShuryoDay(TextBoxDate txtKanriShuryoDay) {
        this.getPanInput().setTxtKanriShuryoDay(txtKanriShuryoDay);
    }

    @JsonIgnore
    public TextBox getTxtShohinmei() {
        return this.getPanInput().getTxtShohinmei();
    }

    @JsonIgnore
    public void  setTxtShohinmei(TextBox txtShohinmei) {
        this.getPanInput().setTxtShohinmei(txtShohinmei);
    }

    @JsonIgnore
    public TextBox getTxtHinmokuCode() {
        return this.getPanInput().getTxtHinmokuCode();
    }

    @JsonIgnore
    public void  setTxtHinmokuCode(TextBox txtHinmokuCode) {
        this.getPanInput().setTxtHinmokuCode(txtHinmokuCode);
    }

    @JsonIgnore
    public TextBox getTxtSeizoJigyoshamei() {
        return this.getPanInput().getTxtSeizoJigyoshamei();
    }

    @JsonIgnore
    public void  setTxtSeizoJigyoshamei(TextBox txtSeizoJigyoshamei) {
        this.getPanInput().setTxtSeizoJigyoshamei(txtSeizoJigyoshamei);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

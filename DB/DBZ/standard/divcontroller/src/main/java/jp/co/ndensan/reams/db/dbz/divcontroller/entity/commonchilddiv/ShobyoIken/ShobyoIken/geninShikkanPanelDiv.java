package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * geninShikkanPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class geninShikkanPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private ButtonDialog btnAdd;
    @JsonProperty("dgGenyin")
    private DataGrid<dgGenyin_Row> dgGenyin;
    @JsonProperty("geninShikkanShosai")
    private geninShikkanShosaiDiv geninShikkanShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public ButtonDialog getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(ButtonDialog btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgGenyin
     * @return dgGenyin
     */
    @JsonProperty("dgGenyin")
    public DataGrid<dgGenyin_Row> getDgGenyin() {
        return dgGenyin;
    }

    /*
     * setdgGenyin
     * @param dgGenyin dgGenyin
     */
    @JsonProperty("dgGenyin")
    public void setDgGenyin(DataGrid<dgGenyin_Row> dgGenyin) {
        this.dgGenyin = dgGenyin;
    }

    /*
     * getgeninShikkanShosai
     * @return geninShikkanShosai
     */
    @JsonProperty("geninShikkanShosai")
    public geninShikkanShosaiDiv getGeninShikkanShosai() {
        return geninShikkanShosai;
    }

    /*
     * setgeninShikkanShosai
     * @param geninShikkanShosai geninShikkanShosai
     */
    @JsonProperty("geninShikkanShosai")
    public void setGeninShikkanShosai(geninShikkanShosaiDiv geninShikkanShosai) {
        this.geninShikkanShosai = geninShikkanShosai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtGeninShikkanCode() {
        return this.getGeninShikkanShosai().getTxtGeninShikkanCode();
    }

    @JsonIgnore
    public void  setTxtGeninShikkanCode(TextBoxCode txtGeninShikkanCode) {
        this.getGeninShikkanShosai().setTxtGeninShikkanCode(txtGeninShikkanCode);
    }

    @JsonIgnore
    public ButtonDialog getBtnToSearch() {
        return this.getGeninShikkanShosai().getBtnToSearch();
    }

    @JsonIgnore
    public void  setBtnToSearch(ButtonDialog btnToSearch) {
        this.getGeninShikkanShosai().setBtnToSearch(btnToSearch);
    }

    @JsonIgnore
    public TextBox getTxtMeisho() {
        return this.getGeninShikkanShosai().getTxtMeisho();
    }

    @JsonIgnore
    public void  setTxtMeisho(TextBox txtMeisho) {
        this.getGeninShikkanShosai().setTxtMeisho(txtMeisho);
    }

    @JsonIgnore
    public RadioButton getRadIsShutaruGeninShikkan() {
        return this.getGeninShikkanShosai().getRadIsShutaruGeninShikkan();
    }

    @JsonIgnore
    public void  setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.getGeninShikkanShosai().setRadIsShutaruGeninShikkan(radIsShutaruGeninShikkan);
    }

    @JsonIgnore
    public Button getBtnNo() {
        return this.getGeninShikkanShosai().getBtnNo();
    }

    @JsonIgnore
    public void  setBtnNo(Button btnNo) {
        this.getGeninShikkanShosai().setBtnNo(btnNo);
    }

    @JsonIgnore
    public Button getBtnOK() {
        return this.getGeninShikkanShosai().getBtnOK();
    }

    @JsonIgnore
    public void  setBtnOK(Button btnOK) {
        this.getGeninShikkanShosai().setBtnOK(btnOK);
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TekiyoJogaiRireki;
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
 * TekiyoJogaiRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiRirekiDiv extends Panel implements ITekiyoJogaiRirekiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelTekiyoRireki")
    private panelTekiyoRirekiDiv panelTekiyoRireki;
    @JsonProperty("panelTekiyoInput")
    private panelTekiyoInputDiv panelTekiyoInput;
    @JsonProperty("panelTekiyoJokaiTekiInput")
    private panelTekiyoJokaiTekiInputDiv panelTekiyoJokaiTekiInput;
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    private panelTekiyoJokaiKaiJyoInputDiv panelTekiyoJokaiKaiJyoInput;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnInputClear")
    private Button btnInputClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelTekiyoRireki
     * @return panelTekiyoRireki
     */
    @JsonProperty("panelTekiyoRireki")
    public panelTekiyoRirekiDiv getPanelTekiyoRireki() {
        return panelTekiyoRireki;
    }

    /*
     * setpanelTekiyoRireki
     * @param panelTekiyoRireki panelTekiyoRireki
     */
    @JsonProperty("panelTekiyoRireki")
    public void setPanelTekiyoRireki(panelTekiyoRirekiDiv panelTekiyoRireki) {
        this.panelTekiyoRireki = panelTekiyoRireki;
    }

    /*
     * getpanelTekiyoInput
     * @return panelTekiyoInput
     */
    @JsonProperty("panelTekiyoInput")
    public panelTekiyoInputDiv getPanelTekiyoInput() {
        return panelTekiyoInput;
    }

    /*
     * setpanelTekiyoInput
     * @param panelTekiyoInput panelTekiyoInput
     */
    @JsonProperty("panelTekiyoInput")
    public void setPanelTekiyoInput(panelTekiyoInputDiv panelTekiyoInput) {
        this.panelTekiyoInput = panelTekiyoInput;
    }

    /*
     * getpanelTekiyoJokaiTekiInput
     * @return panelTekiyoJokaiTekiInput
     */
    @JsonProperty("panelTekiyoJokaiTekiInput")
    public panelTekiyoJokaiTekiInputDiv getPanelTekiyoJokaiTekiInput() {
        return panelTekiyoJokaiTekiInput;
    }

    /*
     * setpanelTekiyoJokaiTekiInput
     * @param panelTekiyoJokaiTekiInput panelTekiyoJokaiTekiInput
     */
    @JsonProperty("panelTekiyoJokaiTekiInput")
    public void setPanelTekiyoJokaiTekiInput(panelTekiyoJokaiTekiInputDiv panelTekiyoJokaiTekiInput) {
        this.panelTekiyoJokaiTekiInput = panelTekiyoJokaiTekiInput;
    }

    /*
     * getpanelTekiyoJokaiKaiJyoInput
     * @return panelTekiyoJokaiKaiJyoInput
     */
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    public panelTekiyoJokaiKaiJyoInputDiv getPanelTekiyoJokaiKaiJyoInput() {
        return panelTekiyoJokaiKaiJyoInput;
    }

    /*
     * setpanelTekiyoJokaiKaiJyoInput
     * @param panelTekiyoJokaiKaiJyoInput panelTekiyoJokaiKaiJyoInput
     */
    @JsonProperty("panelTekiyoJokaiKaiJyoInput")
    public void setPanelTekiyoJokaiKaiJyoInput(panelTekiyoJokaiKaiJyoInputDiv panelTekiyoJokaiKaiJyoInput) {
        this.panelTekiyoJokaiKaiJyoInput = panelTekiyoJokaiKaiJyoInput;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnInputClear
     * @return btnInputClear
     */
    @JsonProperty("btnInputClear")
    public Button getBtnInputClear() {
        return btnInputClear;
    }

    /*
     * setbtnInputClear
     * @param btnInputClear btnInputClear
     */
    @JsonProperty("btnInputClear")
    public void setBtnInputClear(Button btnInputClear) {
        this.btnInputClear = btnInputClear;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelTekiyoRireki().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelTekiyoRireki().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<datagridTekiyoJogai_Row> getDatagridTekiyoJogai() {
        return this.getPanelTekiyoRireki().getDatagridTekiyoJogai();
    }

    @JsonIgnore
    public void  setDatagridTekiyoJogai(DataGrid<datagridTekiyoJogai_Row> datagridTekiyoJogai) {
        this.getPanelTekiyoRireki().setDatagridTekiyoJogai(datagridTekiyoJogai);
    }

    @JsonIgnore
    public TextBoxDate getTxtNyusyoDateInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtNyusyoDateInput();
    }

    @JsonIgnore
    public void  setTxtNyusyoDateInput(TextBoxDate txtNyusyoDateInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtNyusyoDateInput(txtNyusyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoDateInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtTekiyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTekiyoDateInput(TextBoxDate txtTekiyoDateInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtTekiyoDateInput(txtTekiyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTkyoTododkDateIn() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getTxtTkyoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtTkyoTododkDateIn(TextBoxDate txtTkyoTododkDateIn) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setTxtTkyoTododkDateIn(txtTkyoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyuInput() {
        return this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().getDdlTekiyoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyuInput(DropDownList ddlTekiyoJiyuInput) {
        this.getPanelTekiyoJokaiTekiInput().getPanelJogaisyaTekiyo().setDdlTekiyoJiyuInput(ddlTekiyoJiyuInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaisyoDateInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtTaisyoDateInput();
    }

    @JsonIgnore
    public void  setTxtTaisyoDateInput(TextBoxDate txtTaisyoDateInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtTaisyoDateInput(txtTaisyoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoDateInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtKaijoDateInput();
    }

    @JsonIgnore
    public void  setTxtKaijoDateInput(TextBoxDate txtKaijoDateInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtKaijoDateInput(txtKaijoDateInput);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijoTododkDateIn() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getTxtKaijoTododkDateIn();
    }

    @JsonIgnore
    public void  setTxtKaijoTododkDateIn(TextBoxDate txtKaijoTododkDateIn) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setTxtKaijoTododkDateIn(txtKaijoTododkDateIn);
    }

    @JsonIgnore
    public DropDownList getDdlKaijoJiyuInput() {
        return this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().getDdlKaijoJiyuInput();
    }

    @JsonIgnore
    public void  setDdlKaijoJiyuInput(DropDownList ddlKaijoJiyuInput) {
        this.getPanelTekiyoJokaiKaiJyoInput().getPanelJogaisyaKaijo().setDdlKaijoJiyuInput(ddlKaijoJiyuInput);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

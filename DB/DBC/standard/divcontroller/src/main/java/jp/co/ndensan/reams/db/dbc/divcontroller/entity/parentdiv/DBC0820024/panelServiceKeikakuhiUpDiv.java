package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820024;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelServiceKeikakuhiUp のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelServiceKeikakuHiUpDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlJigyoshaKubun")
    private DropDownList ddlJigyoshaKubun;
    @JsonProperty("rdoShinsahouhou")
    private RadioButton rdoShinsahouhou;
    @JsonProperty("txtTodokedeYMD")
    private TextBoxDate txtTodokedeYMD;
    @JsonProperty("txtTantoKaigoshien")
    private TextBoxCode txtTantoKaigoshien;
    @JsonProperty("txtTanyiTanka")
    private TextBoxNum txtTanyiTanka;
    @JsonProperty("hlThree")
    private HorizontalLine hlThree;
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdYichiran")
    private DataGrid<dgdYichiran_Row> dgdYichiran;
    @JsonProperty("txtGokeiTanyi")
    private TextBoxNum txtGokeiTanyi;
    @JsonProperty("txtSeikyugaku")
    private TextBoxNum txtSeikyugaku;
    @JsonProperty("panelServiceKeikakuhiUp")
    private panelServiceKeikakuhiUpDiv panelServiceKeikakuhiUp;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlJigyoshaKubun
     * @return ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public DropDownList getDdlJigyoshaKubun() {
        return ddlJigyoshaKubun;
    }

    /*
     * setddlJigyoshaKubun
     * @param ddlJigyoshaKubun ddlJigyoshaKubun
     */
    @JsonProperty("ddlJigyoshaKubun")
    public void setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.ddlJigyoshaKubun = ddlJigyoshaKubun;
    }

    /*
     * getrdoShinsahouhou
     * @return rdoShinsahouhou
     */
    @JsonProperty("rdoShinsahouhou")
    public RadioButton getRdoShinsahouhou() {
        return rdoShinsahouhou;
    }

    /*
     * setrdoShinsahouhou
     * @param rdoShinsahouhou rdoShinsahouhou
     */
    @JsonProperty("rdoShinsahouhou")
    public void setRdoShinsahouhou(RadioButton rdoShinsahouhou) {
        this.rdoShinsahouhou = rdoShinsahouhou;
    }

    /*
     * gettxtTodokedeYMD
     * @return txtTodokedeYMD
     */
    @JsonProperty("txtTodokedeYMD")
    public TextBoxDate getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    /*
     * settxtTodokedeYMD
     * @param txtTodokedeYMD txtTodokedeYMD
     */
    @JsonProperty("txtTodokedeYMD")
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.txtTodokedeYMD = txtTodokedeYMD;
    }

    /*
     * gettxtTantoKaigoshien
     * @return txtTantoKaigoshien
     */
    @JsonProperty("txtTantoKaigoshien")
    public TextBoxCode getTxtTantoKaigoshien() {
        return txtTantoKaigoshien;
    }

    /*
     * settxtTantoKaigoshien
     * @param txtTantoKaigoshien txtTantoKaigoshien
     */
    @JsonProperty("txtTantoKaigoshien")
    public void setTxtTantoKaigoshien(TextBoxCode txtTantoKaigoshien) {
        this.txtTantoKaigoshien = txtTantoKaigoshien;
    }

    /*
     * gettxtTanyiTanka
     * @return txtTanyiTanka
     */
    @JsonProperty("txtTanyiTanka")
    public TextBoxNum getTxtTanyiTanka() {
        return txtTanyiTanka;
    }

    /*
     * settxtTanyiTanka
     * @param txtTanyiTanka txtTanyiTanka
     */
    @JsonProperty("txtTanyiTanka")
    public void setTxtTanyiTanka(TextBoxNum txtTanyiTanka) {
        this.txtTanyiTanka = txtTanyiTanka;
    }

    /*
     * gethlThree
     * @return hlThree
     */
    @JsonProperty("hlThree")
    public HorizontalLine getHlThree() {
        return hlThree;
    }

    /*
     * sethlThree
     * @param hlThree hlThree
     */
    @JsonProperty("hlThree")
    public void setHlThree(HorizontalLine hlThree) {
        this.hlThree = hlThree;
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
     * getdgdYichiran
     * @return dgdYichiran
     */
    @JsonProperty("dgdYichiran")
    public DataGrid<dgdYichiran_Row> getDgdYichiran() {
        return dgdYichiran;
    }

    /*
     * setdgdYichiran
     * @param dgdYichiran dgdYichiran
     */
    @JsonProperty("dgdYichiran")
    public void setDgdYichiran(DataGrid<dgdYichiran_Row> dgdYichiran) {
        this.dgdYichiran = dgdYichiran;
    }

    /*
     * gettxtGokeiTanyi
     * @return txtGokeiTanyi
     */
    @JsonProperty("txtGokeiTanyi")
    public TextBoxNum getTxtGokeiTanyi() {
        return txtGokeiTanyi;
    }

    /*
     * settxtGokeiTanyi
     * @param txtGokeiTanyi txtGokeiTanyi
     */
    @JsonProperty("txtGokeiTanyi")
    public void setTxtGokeiTanyi(TextBoxNum txtGokeiTanyi) {
        this.txtGokeiTanyi = txtGokeiTanyi;
    }

    /*
     * gettxtSeikyugaku
     * @return txtSeikyugaku
     */
    @JsonProperty("txtSeikyugaku")
    public TextBoxNum getTxtSeikyugaku() {
        return txtSeikyugaku;
    }

    /*
     * settxtSeikyugaku
     * @param txtSeikyugaku txtSeikyugaku
     */
    @JsonProperty("txtSeikyugaku")
    public void setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.txtSeikyugaku = txtSeikyugaku;
    }

    /*
     * getpanelServiceKeikakuhiUp
     * @return panelServiceKeikakuhiUp
     */
    @JsonProperty("panelServiceKeikakuhiUp")
    public panelServiceKeikakuhiUpDiv getPanelServiceKeikakuhiUp() {
        return panelServiceKeikakuhiUp;
    }

    /*
     * setpanelServiceKeikakuhiUp
     * @param panelServiceKeikakuhiUp panelServiceKeikakuhiUp
     */
    @JsonProperty("panelServiceKeikakuhiUp")
    public void setPanelServiceKeikakuhiUp(panelServiceKeikakuhiUpDiv panelServiceKeikakuhiUp) {
        this.panelServiceKeikakuhiUp = panelServiceKeikakuhiUp;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtTanyiUp() {
        return this.getPanelServiceKeikakuhiUp().getTxtTanyiUp();
    }

    @JsonIgnore
    public void  setTxtTanyiUp(TextBoxNum txtTanyiUp) {
        this.getPanelServiceKeikakuhiUp().setTxtTanyiUp(txtTanyiUp);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelServiceKeikakuhiUp().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelServiceKeikakuhiUp().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelServiceKeikakuhiUp().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelServiceKeikakuhiUp().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyiSu() {
        return this.getPanelServiceKeikakuhiUp().getTxtServiceTanyiSu();
    }

    @JsonIgnore
    public void  setTxtServiceTanyiSu(TextBoxNum txtServiceTanyiSu) {
        this.getPanelServiceKeikakuhiUp().setTxtServiceTanyiSu(txtServiceTanyiSu);
    }

    @JsonIgnore
    public TextBox getTxtTekiyoUp() {
        return this.getPanelServiceKeikakuhiUp().getTxtTekiyoUp();
    }

    @JsonIgnore
    public void  setTxtTekiyoUp(TextBox txtTekiyoUp) {
        this.getPanelServiceKeikakuhiUp().setTxtTekiyoUp(txtTekiyoUp);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelServiceKeikakuhiUp().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelServiceKeikakuhiUp().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelServiceKeikakuhiUp().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelServiceKeikakuhiUp().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelServiceKeikakuhiUp().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelServiceKeikakuhiUp().setBtnClear(btnClear);
    }

    @JsonIgnore
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput() {
        return this.getPanelServiceKeikakuhiUp().getCcdServiceCodeInput();
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810024;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * panelServiceKeikakuHiUp のクラスファイル 
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
    @JsonProperty("dgdYichiran")
    private DataGrid<dgdYichiran_Row> dgdYichiran;
    @JsonProperty("txtGokeiTanyi")
    private TextBoxNum txtGokeiTanyi;
    @JsonProperty("txtSeikyugaku")
    private TextBoxNum txtSeikyugaku;
    @JsonProperty("panelServiceKeikakuhiUp1")
    private panelServiceKeikakuhiUp1Div panelServiceKeikakuhiUp1;

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
     * getpanelServiceKeikakuhiUp1
     * @return panelServiceKeikakuhiUp1
     */
    @JsonProperty("panelServiceKeikakuhiUp1")
    public panelServiceKeikakuhiUp1Div getPanelServiceKeikakuhiUp1() {
        return panelServiceKeikakuhiUp1;
    }

    /*
     * setpanelServiceKeikakuhiUp1
     * @param panelServiceKeikakuhiUp1 panelServiceKeikakuhiUp1
     */
    @JsonProperty("panelServiceKeikakuhiUp1")
    public void setPanelServiceKeikakuhiUp1(panelServiceKeikakuhiUp1Div panelServiceKeikakuhiUp1) {
        this.panelServiceKeikakuhiUp1 = panelServiceKeikakuhiUp1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtServiceCode1() {
        return this.getPanelServiceKeikakuhiUp1().getTxtServiceCode1();
    }

    @JsonIgnore
    public void  setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.getPanelServiceKeikakuhiUp1().setTxtServiceCode1(txtServiceCode1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode2() {
        return this.getPanelServiceKeikakuhiUp1().getTxtServiceCode2();
    }

    @JsonIgnore
    public void  setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.getPanelServiceKeikakuhiUp1().setTxtServiceCode2(txtServiceCode2);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getPanelServiceKeikakuhiUp1().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getPanelServiceKeikakuhiUp1().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelServiceKeikakuhiUp1().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelServiceKeikakuhiUp1().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiUp() {
        return this.getPanelServiceKeikakuhiUp1().getTxtTanyiUp();
    }

    @JsonIgnore
    public void  setTxtTanyiUp(TextBoxNum txtTanyiUp) {
        this.getPanelServiceKeikakuhiUp1().setTxtTanyiUp(txtTanyiUp);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelServiceKeikakuhiUp1().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelServiceKeikakuhiUp1().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelServiceKeikakuhiUp1().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelServiceKeikakuhiUp1().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyiSu() {
        return this.getPanelServiceKeikakuhiUp1().getTxtServiceTanyiSu();
    }

    @JsonIgnore
    public void  setTxtServiceTanyiSu(TextBoxNum txtServiceTanyiSu) {
        this.getPanelServiceKeikakuhiUp1().setTxtServiceTanyiSu(txtServiceTanyiSu);
    }

    @JsonIgnore
    public TextBox getTxtTekiyoUp() {
        return this.getPanelServiceKeikakuhiUp1().getTxtTekiyoUp();
    }

    @JsonIgnore
    public void  setTxtTekiyoUp(TextBox txtTekiyoUp) {
        this.getPanelServiceKeikakuhiUp1().setTxtTekiyoUp(txtTekiyoUp);
    }

    @JsonIgnore
    public HorizontalLine getHrFree() {
        return this.getPanelServiceKeikakuhiUp1().getHrFree();
    }

    @JsonIgnore
    public void  setHrFree(HorizontalLine hrFree) {
        this.getPanelServiceKeikakuhiUp1().setHrFree(hrFree);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtShinsaYM() {
        return this.getPanelServiceKeikakuhiUp1().getTxtShinsaYM();
    }

    @JsonIgnore
    public void  setTxtShinsaYM(TextBoxYearMonth txtShinsaYM) {
        this.getPanelServiceKeikakuhiUp1().setTxtShinsaYM(txtShinsaYM);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubun() {
        return this.getPanelServiceKeikakuhiUp1().getTxtShikyuKubun();
    }

    @JsonIgnore
    public void  setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.getPanelServiceKeikakuhiUp1().setTxtShikyuKubun(txtShikyuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyi() {
        return this.getPanelServiceKeikakuhiUp1().getTxtServiceTanyi();
    }

    @JsonIgnore
    public void  setTxtServiceTanyi(TextBoxNum txtServiceTanyi) {
        this.getPanelServiceKeikakuhiUp1().setTxtServiceTanyi(txtServiceTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtShihanayiKingaku() {
        return this.getPanelServiceKeikakuhiUp1().getTxtShihanayiKingaku();
    }

    @JsonIgnore
    public void  setTxtShihanayiKingaku(TextBoxNum txtShihanayiKingaku) {
        this.getPanelServiceKeikakuhiUp1().setTxtShihanayiKingaku(txtShihanayiKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZougenten() {
        return this.getPanelServiceKeikakuhiUp1().getTxtZougenten();
    }

    @JsonIgnore
    public void  setTxtZougenten(TextBoxNum txtZougenten) {
        this.getPanelServiceKeikakuhiUp1().setTxtZougenten(txtZougenten);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote1() {
        return this.getPanelServiceKeikakuhiUp1().getTxtNote1();
    }

    @JsonIgnore
    public void  setTxtNote1(TextBoxMultiLine txtNote1) {
        this.getPanelServiceKeikakuhiUp1().setTxtNote1(txtNote1);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote2() {
        return this.getPanelServiceKeikakuhiUp1().getTxtNote2();
    }

    @JsonIgnore
    public void  setTxtNote2(TextBoxMultiLine txtNote2) {
        this.getPanelServiceKeikakuhiUp1().setTxtNote2(txtNote2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote3() {
        return this.getPanelServiceKeikakuhiUp1().getTxtNote3();
    }

    @JsonIgnore
    public void  setTxtNote3(TextBoxMultiLine txtNote3) {
        this.getPanelServiceKeikakuhiUp1().setTxtNote3(txtNote3);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelServiceKeikakuhiUp1().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelServiceKeikakuhiUp1().setBtnClose(btnClose);
    }

    // </editor-fold>
}

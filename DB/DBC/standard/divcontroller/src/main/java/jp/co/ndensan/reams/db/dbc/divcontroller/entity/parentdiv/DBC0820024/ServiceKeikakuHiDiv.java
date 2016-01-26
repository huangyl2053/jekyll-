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
 * ServiceKeikakuHi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceKeikakuHiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelCcd")
    private panelCcdDiv panelCcd;
    @JsonProperty("panelHead")
    private panelHeadDiv panelHead;
    @JsonProperty("panelServiceKeikakuHiUp")
    private panelServiceKeikakuHiUpDiv panelServiceKeikakuHiUp;
    @JsonProperty("panelServiceKeikakuhiDown")
    private panelServiceKeikakuhiDownDiv panelServiceKeikakuhiDown;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelCcd
     * @return panelCcd
     */
    @JsonProperty("panelCcd")
    public panelCcdDiv getPanelCcd() {
        return panelCcd;
    }

    /*
     * setpanelCcd
     * @param panelCcd panelCcd
     */
    @JsonProperty("panelCcd")
    public void setPanelCcd(panelCcdDiv panelCcd) {
        this.panelCcd = panelCcd;
    }

    /*
     * getpanelHead
     * @return panelHead
     */
    @JsonProperty("panelHead")
    public panelHeadDiv getPanelHead() {
        return panelHead;
    }

    /*
     * setpanelHead
     * @param panelHead panelHead
     */
    @JsonProperty("panelHead")
    public void setPanelHead(panelHeadDiv panelHead) {
        this.panelHead = panelHead;
    }

    /*
     * getpanelServiceKeikakuHiUp
     * @return panelServiceKeikakuHiUp
     */
    @JsonProperty("panelServiceKeikakuHiUp")
    public panelServiceKeikakuHiUpDiv getPanelServiceKeikakuHiUp() {
        return panelServiceKeikakuHiUp;
    }

    /*
     * setpanelServiceKeikakuHiUp
     * @param panelServiceKeikakuHiUp panelServiceKeikakuHiUp
     */
    @JsonProperty("panelServiceKeikakuHiUp")
    public void setPanelServiceKeikakuHiUp(panelServiceKeikakuHiUpDiv panelServiceKeikakuHiUp) {
        this.panelServiceKeikakuHiUp = panelServiceKeikakuHiUp;
    }

    /*
     * getpanelServiceKeikakuhiDown
     * @return panelServiceKeikakuhiDown
     */
    @JsonProperty("panelServiceKeikakuhiDown")
    public panelServiceKeikakuhiDownDiv getPanelServiceKeikakuhiDown() {
        return panelServiceKeikakuhiDown;
    }

    /*
     * setpanelServiceKeikakuhiDown
     * @param panelServiceKeikakuhiDown panelServiceKeikakuhiDown
     */
    @JsonProperty("panelServiceKeikakuhiDown")
    public void setPanelServiceKeikakuhiDown(panelServiceKeikakuhiDownDiv panelServiceKeikakuhiDown) {
        this.panelServiceKeikakuhiDown = panelServiceKeikakuhiDown;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlJigyoshaKubun() {
        return this.getPanelServiceKeikakuHiUp().getDdlJigyoshaKubun();
    }

    @JsonIgnore
    public void  setDdlJigyoshaKubun(DropDownList ddlJigyoshaKubun) {
        this.getPanelServiceKeikakuHiUp().setDdlJigyoshaKubun(ddlJigyoshaKubun);
    }

    @JsonIgnore
    public RadioButton getRdoShinsahouhou() {
        return this.getPanelServiceKeikakuHiUp().getRdoShinsahouhou();
    }

    @JsonIgnore
    public void  setRdoShinsahouhou(RadioButton rdoShinsahouhou) {
        this.getPanelServiceKeikakuHiUp().setRdoShinsahouhou(rdoShinsahouhou);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYMD() {
        return this.getPanelServiceKeikakuHiUp().getTxtTodokedeYMD();
    }

    @JsonIgnore
    public void  setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.getPanelServiceKeikakuHiUp().setTxtTodokedeYMD(txtTodokedeYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtTantoKaigoshien() {
        return this.getPanelServiceKeikakuHiUp().getTxtTantoKaigoshien();
    }

    @JsonIgnore
    public void  setTxtTantoKaigoshien(TextBoxCode txtTantoKaigoshien) {
        this.getPanelServiceKeikakuHiUp().setTxtTantoKaigoshien(txtTantoKaigoshien);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiTanka() {
        return this.getPanelServiceKeikakuHiUp().getTxtTanyiTanka();
    }

    @JsonIgnore
    public void  setTxtTanyiTanka(TextBoxNum txtTanyiTanka) {
        this.getPanelServiceKeikakuHiUp().setTxtTanyiTanka(txtTanyiTanka);
    }

    @JsonIgnore
    public HorizontalLine getHlThree() {
        return this.getPanelServiceKeikakuHiUp().getHlThree();
    }

    @JsonIgnore
    public void  setHlThree(HorizontalLine hlThree) {
        this.getPanelServiceKeikakuHiUp().setHlThree(hlThree);
    }

    @JsonIgnore
    public Button getBtnAdd() {
        return this.getPanelServiceKeikakuHiUp().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getPanelServiceKeikakuHiUp().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgdYichiran_Row> getDgdYichiran() {
        return this.getPanelServiceKeikakuHiUp().getDgdYichiran();
    }

    @JsonIgnore
    public void  setDgdYichiran(DataGrid<dgdYichiran_Row> dgdYichiran) {
        this.getPanelServiceKeikakuHiUp().setDgdYichiran(dgdYichiran);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiTanyi() {
        return this.getPanelServiceKeikakuHiUp().getTxtGokeiTanyi();
    }

    @JsonIgnore
    public void  setTxtGokeiTanyi(TextBoxNum txtGokeiTanyi) {
        this.getPanelServiceKeikakuHiUp().setTxtGokeiTanyi(txtGokeiTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugaku() {
        return this.getPanelServiceKeikakuHiUp().getTxtSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.getPanelServiceKeikakuHiUp().setTxtSeikyugaku(txtSeikyugaku);
    }

    @JsonIgnore
    public panelServiceKeikakuhiUpDiv getPanelServiceKeikakuhiUp() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp();
    }

    @JsonIgnore
    public void  setPanelServiceKeikakuhiUp(panelServiceKeikakuhiUpDiv panelServiceKeikakuhiUp) {
        this.getPanelServiceKeikakuHiUp().setPanelServiceKeikakuhiUp(panelServiceKeikakuhiUp);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiUp() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getTxtTanyiUp();
    }

    @JsonIgnore
    public void  setTxtTanyiUp(TextBoxNum txtTanyiUp) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setTxtTanyiUp(txtTanyiUp);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyiSu() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getTxtServiceTanyiSu();
    }

    @JsonIgnore
    public void  setTxtServiceTanyiSu(TextBoxNum txtServiceTanyiSu) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setTxtServiceTanyiSu(txtServiceTanyiSu);
    }

    @JsonIgnore
    public TextBox getTxtTekiyoUp() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getTxtTekiyoUp();
    }

    @JsonIgnore
    public void  setTxtTekiyoUp(TextBox txtTekiyoUp) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setTxtTekiyoUp(txtTekiyoUp);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().setBtnClear(btnClear);
    }

    @JsonIgnore
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp().getCcdServiceCodeInput();
    }

    @JsonIgnore
    public DropDownList getDdlShiteiJigyoshaKubunCode() {
        return this.getPanelServiceKeikakuhiDown().getDdlShiteiJigyoshaKubunCode();
    }

    @JsonIgnore
    public void  setDdlShiteiJigyoshaKubunCode(DropDownList ddlShiteiJigyoshaKubunCode) {
        this.getPanelServiceKeikakuhiDown().setDdlShiteiJigyoshaKubunCode(ddlShiteiJigyoshaKubunCode);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeDate() {
        return this.getPanelServiceKeikakuhiDown().getTxtTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtTodokedeDate(TextBoxDate txtTodokedeDate) {
        this.getPanelServiceKeikakuhiDown().setTxtTodokedeDate(txtTodokedeDate);
    }

    @JsonIgnore
    public RadioButton getRdoShinsaHouhou() {
        return this.getPanelServiceKeikakuhiDown().getRdoShinsaHouhou();
    }

    @JsonIgnore
    public void  setRdoShinsaHouhou(RadioButton rdoShinsaHouhou) {
        this.getPanelServiceKeikakuhiDown().setRdoShinsaHouhou(rdoShinsaHouhou);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiDown() {
        return this.getPanelServiceKeikakuhiDown().getTxtTanyiDown();
    }

    @JsonIgnore
    public void  setTxtTanyiDown(TextBoxNum txtTanyiDown) {
        this.getPanelServiceKeikakuhiDown().setTxtTanyiDown(txtTanyiDown);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyisuTanka() {
        return this.getPanelServiceKeikakuhiDown().getTxtTanyisuTanka();
    }

    @JsonIgnore
    public void  setTxtTanyisuTanka(TextBoxNum txtTanyisuTanka) {
        this.getPanelServiceKeikakuhiDown().setTxtTanyisuTanka(txtTanyisuTanka);
    }

    @JsonIgnore
    public Button getBtnkeisan() {
        return this.getPanelServiceKeikakuhiDown().getBtnkeisan();
    }

    @JsonIgnore
    public void  setBtnkeisan(Button btnkeisan) {
        this.getPanelServiceKeikakuhiDown().setBtnkeisan(btnkeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugakuDown() {
        return this.getPanelServiceKeikakuhiDown().getTxtSeikyugakuDown();
    }

    @JsonIgnore
    public void  setTxtSeikyugakuDown(TextBoxNum txtSeikyugakuDown) {
        this.getPanelServiceKeikakuhiDown().setTxtSeikyugakuDown(txtSeikyugakuDown);
    }

    @JsonIgnore
    public TextBoxCode getTxtTantoukayigoshien() {
        return this.getPanelServiceKeikakuhiDown().getTxtTantoukayigoshien();
    }

    @JsonIgnore
    public void  setTxtTantoukayigoshien(TextBoxCode txtTantoukayigoshien) {
        this.getPanelServiceKeikakuhiDown().setTxtTantoukayigoshien(txtTantoukayigoshien);
    }

    @JsonIgnore
    public TextBox getTxtTekiyo() {
        return this.getPanelServiceKeikakuhiDown().getTxtTekiyo();
    }

    @JsonIgnore
    public void  setTxtTekiyo(TextBox txtTekiyo) {
        this.getPanelServiceKeikakuhiDown().setTxtTekiyo(txtTekiyo);
    }

    @JsonIgnore
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput2() {
        return this.getPanelServiceKeikakuhiDown().getCcdServiceCodeInput2();
    }

    // </editor-fold>
}

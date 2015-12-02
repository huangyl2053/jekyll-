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
    public panelServiceKeikakuhiUp1Div getPanelServiceKeikakuhiUp1() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1();
    }

    @JsonIgnore
    public void  setPanelServiceKeikakuhiUp1(panelServiceKeikakuhiUp1Div panelServiceKeikakuhiUp1) {
        this.getPanelServiceKeikakuHiUp().setPanelServiceKeikakuhiUp1(panelServiceKeikakuhiUp1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode1() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtServiceCode1();
    }

    @JsonIgnore
    public void  setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtServiceCode1(txtServiceCode1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode2() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtServiceCode2();
    }

    @JsonIgnore
    public void  setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtServiceCode2(txtServiceCode2);
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(Button btnSearch) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiUp() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtTanyiUp();
    }

    @JsonIgnore
    public void  setTxtTanyiUp(TextBoxNum txtTanyiUp) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtTanyiUp(txtTanyiUp);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public Button getBtnKeisan() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getBtnKeisan();
    }

    @JsonIgnore
    public void  setBtnKeisan(Button btnKeisan) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setBtnKeisan(btnKeisan);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyiSu() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtServiceTanyiSu();
    }

    @JsonIgnore
    public void  setTxtServiceTanyiSu(TextBoxNum txtServiceTanyiSu) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtServiceTanyiSu(txtServiceTanyiSu);
    }

    @JsonIgnore
    public TextBox getTxtTekiyoUp() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtTekiyoUp();
    }

    @JsonIgnore
    public void  setTxtTekiyoUp(TextBox txtTekiyoUp) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtTekiyoUp(txtTekiyoUp);
    }

    @JsonIgnore
    public HorizontalLine getHrFree() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getHrFree();
    }

    @JsonIgnore
    public void  setHrFree(HorizontalLine hrFree) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setHrFree(hrFree);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtShinsaYM() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtShinsaYM();
    }

    @JsonIgnore
    public void  setTxtShinsaYM(TextBoxYearMonth txtShinsaYM) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtShinsaYM(txtShinsaYM);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubun() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtShikyuKubun();
    }

    @JsonIgnore
    public void  setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtShikyuKubun(txtShikyuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyi() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtServiceTanyi();
    }

    @JsonIgnore
    public void  setTxtServiceTanyi(TextBoxNum txtServiceTanyi) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtServiceTanyi(txtServiceTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtShihanayiKingaku() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtShihanayiKingaku();
    }

    @JsonIgnore
    public void  setTxtShihanayiKingaku(TextBoxNum txtShihanayiKingaku) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtShihanayiKingaku(txtShihanayiKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZougenten() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtZougenten();
    }

    @JsonIgnore
    public void  setTxtZougenten(TextBoxNum txtZougenten) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtZougenten(txtZougenten);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote1() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtNote1();
    }

    @JsonIgnore
    public void  setTxtNote1(TextBoxMultiLine txtNote1) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtNote1(txtNote1);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote2() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtNote2();
    }

    @JsonIgnore
    public void  setTxtNote2(TextBoxMultiLine txtNote2) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtNote2(txtNote2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote3() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getTxtNote3();
    }

    @JsonIgnore
    public void  setTxtNote3(TextBoxMultiLine txtNote3) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setTxtNote3(txtNote3);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelServiceKeikakuHiUp().getPanelServiceKeikakuhiUp1().setBtnClose(btnClose);
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
    public TextBoxCode getTxtServiceCodeDown1() {
        return this.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown1();
    }

    @JsonIgnore
    public void  setTxtServiceCodeDown1(TextBoxCode txtServiceCodeDown1) {
        this.getPanelServiceKeikakuhiDown().setTxtServiceCodeDown1(txtServiceCodeDown1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCodeDown2() {
        return this.getPanelServiceKeikakuhiDown().getTxtServiceCodeDown2();
    }

    @JsonIgnore
    public void  setTxtServiceCodeDown2(TextBoxCode txtServiceCodeDown2) {
        this.getPanelServiceKeikakuhiDown().setTxtServiceCodeDown2(txtServiceCodeDown2);
    }

    @JsonIgnore
    public Button getBtns() {
        return this.getPanelServiceKeikakuhiDown().getBtns();
    }

    @JsonIgnore
    public void  setBtns(Button btns) {
        this.getPanelServiceKeikakuhiDown().setBtns(btns);
    }

    @JsonIgnore
    public TextBox getTxtServiceNamedown() {
        return this.getPanelServiceKeikakuhiDown().getTxtServiceNamedown();
    }

    @JsonIgnore
    public void  setTxtServiceNamedown(TextBox txtServiceNamedown) {
        this.getPanelServiceKeikakuhiDown().setTxtServiceNamedown(txtServiceNamedown);
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
    public HorizontalLine getHlthree() {
        return this.getPanelServiceKeikakuhiDown().getHlthree();
    }

    @JsonIgnore
    public void  setHlthree(HorizontalLine hlthree) {
        this.getPanelServiceKeikakuhiDown().setHlthree(hlthree);
    }

    @JsonIgnore
    public TextBoxYearMonth getTxtShinsaYmdown() {
        return this.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown();
    }

    @JsonIgnore
    public void  setTxtShinsaYmdown(TextBoxYearMonth txtShinsaYmdown) {
        this.getPanelServiceKeikakuhiDown().setTxtShinsaYmdown(txtShinsaYmdown);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubundown() {
        return this.getPanelServiceKeikakuhiDown().getTxtShikyuKubundown();
    }

    @JsonIgnore
    public void  setTxtShikyuKubundown(TextBox txtShikyuKubundown) {
        this.getPanelServiceKeikakuhiDown().setTxtShikyuKubundown(txtShikyuKubundown);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyidown() {
        return this.getPanelServiceKeikakuhiDown().getTxtServiceTanyidown();
    }

    @JsonIgnore
    public void  setTxtServiceTanyidown(TextBoxNum txtServiceTanyidown) {
        this.getPanelServiceKeikakuhiDown().setTxtServiceTanyidown(txtServiceTanyidown);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiKingaku() {
        return this.getPanelServiceKeikakuhiDown().getTxtShiharaiKingaku();
    }

    @JsonIgnore
    public void  setTxtShiharaiKingaku(TextBoxNum txtShiharaiKingaku) {
        this.getPanelServiceKeikakuhiDown().setTxtShiharaiKingaku(txtShiharaiKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZougentendown() {
        return this.getPanelServiceKeikakuhiDown().getTxtZougentendown();
    }

    @JsonIgnore
    public void  setTxtZougentendown(TextBoxNum txtZougentendown) {
        this.getPanelServiceKeikakuhiDown().setTxtZougentendown(txtZougentendown);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote1down() {
        return this.getPanelServiceKeikakuhiDown().getTxtNote1down();
    }

    @JsonIgnore
    public void  setTxtNote1down(TextBoxMultiLine txtNote1down) {
        this.getPanelServiceKeikakuhiDown().setTxtNote1down(txtNote1down);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote2down() {
        return this.getPanelServiceKeikakuhiDown().getTxtNote2down();
    }

    @JsonIgnore
    public void  setTxtNote2down(TextBoxMultiLine txtNote2down) {
        this.getPanelServiceKeikakuhiDown().setTxtNote2down(txtNote2down);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote3down() {
        return this.getPanelServiceKeikakuhiDown().getTxtNote3down();
    }

    @JsonIgnore
    public void  setTxtNote3down(TextBoxMultiLine txtNote3down) {
        this.getPanelServiceKeikakuhiDown().setTxtNote3down(txtNote3down);
    }

    // </editor-fold>
}

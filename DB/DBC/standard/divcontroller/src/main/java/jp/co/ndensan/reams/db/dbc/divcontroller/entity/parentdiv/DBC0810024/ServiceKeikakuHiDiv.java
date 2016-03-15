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

/**
 * ServiceKeikakuHi のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceKeikakuHiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
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
    @JsonProperty("panelServiceKeikakuhiUp1")
    private panelServiceKeikakuhiUp1Div panelServiceKeikakuhiUp1;
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
    public TextBoxCode getTxtJigyoshaKubun() {
        return this.getPanelServiceKeikakuhiUp1().getTxtJigyoshaKubun();
    }

    @JsonIgnore
    public void  setTxtJigyoshaKubun(TextBoxCode txtJigyoshaKubun) {
        this.getPanelServiceKeikakuhiUp1().setTxtJigyoshaKubun(txtJigyoshaKubun);
    }

    @JsonIgnore
    public RadioButton getRdoShinsahouhou() {
        return this.getPanelServiceKeikakuhiUp1().getRdoShinsahouhou();
    }

    @JsonIgnore
    public void  setRdoShinsahouhou(RadioButton rdoShinsahouhou) {
        this.getPanelServiceKeikakuhiUp1().setRdoShinsahouhou(rdoShinsahouhou);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYMD() {
        return this.getPanelServiceKeikakuhiUp1().getTxtTodokedeYMD();
    }

    @JsonIgnore
    public void  setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.getPanelServiceKeikakuhiUp1().setTxtTodokedeYMD(txtTodokedeYMD);
    }

    @JsonIgnore
    public TextBoxCode getTxtTantoKaigoshien() {
        return this.getPanelServiceKeikakuhiUp1().getTxtTantoKaigoshien();
    }

    @JsonIgnore
    public void  setTxtTantoKaigoshien(TextBoxCode txtTantoKaigoshien) {
        this.getPanelServiceKeikakuhiUp1().setTxtTantoKaigoshien(txtTantoKaigoshien);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiTanka() {
        return this.getPanelServiceKeikakuhiUp1().getTxtTanyiTanka();
    }

    @JsonIgnore
    public void  setTxtTanyiTanka(TextBoxNum txtTanyiTanka) {
        this.getPanelServiceKeikakuhiUp1().setTxtTanyiTanka(txtTanyiTanka);
    }

    @JsonIgnore
    public HorizontalLine getHlThree() {
        return this.getPanelServiceKeikakuhiUp1().getHlThree();
    }

    @JsonIgnore
    public void  setHlThree(HorizontalLine hlThree) {
        this.getPanelServiceKeikakuhiUp1().setHlThree(hlThree);
    }

    @JsonIgnore
    public DataGrid<dgdYichiran_Row> getDgdYichiran() {
        return this.getPanelServiceKeikakuhiUp1().getDgdYichiran();
    }

    @JsonIgnore
    public void  setDgdYichiran(DataGrid<dgdYichiran_Row> dgdYichiran) {
        this.getPanelServiceKeikakuhiUp1().setDgdYichiran(dgdYichiran);
    }

    @JsonIgnore
    public TextBoxNum getTxtGokeiTanyi() {
        return this.getPanelServiceKeikakuhiUp1().getTxtGokeiTanyi();
    }

    @JsonIgnore
    public void  setTxtGokeiTanyi(TextBoxNum txtGokeiTanyi) {
        this.getPanelServiceKeikakuhiUp1().setTxtGokeiTanyi(txtGokeiTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugaku() {
        return this.getPanelServiceKeikakuhiUp1().getTxtSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.getPanelServiceKeikakuhiUp1().setTxtSeikyugaku(txtSeikyugaku);
    }

    @JsonIgnore
    public panelServiceKeikakuhiUpDiv getPanelServiceKeikakuhiUp() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp();
    }

    @JsonIgnore
    public void  setPanelServiceKeikakuhiUp(panelServiceKeikakuhiUpDiv panelServiceKeikakuhiUp) {
        this.getPanelServiceKeikakuhiUp1().setPanelServiceKeikakuhiUp(panelServiceKeikakuhiUp);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode1() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtServiceCode1();
    }

    @JsonIgnore
    public void  setTxtServiceCode1(TextBoxCode txtServiceCode1) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtServiceCode1(txtServiceCode1);
    }

    @JsonIgnore
    public TextBoxCode getTxtServiceCode2() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtServiceCode2();
    }

    @JsonIgnore
    public void  setTxtServiceCode2(TextBoxCode txtServiceCode2) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtServiceCode2(txtServiceCode2);
    }

    @JsonIgnore
    public TextBox getTxtServiceName() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtServiceName();
    }

    @JsonIgnore
    public void  setTxtServiceName(TextBox txtServiceName) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtServiceName(txtServiceName);
    }

    @JsonIgnore
    public TextBoxNum getTxtTanyiUp() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtTanyiUp();
    }

    @JsonIgnore
    public void  setTxtTanyiUp(TextBoxNum txtTanyiUp) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtTanyiUp(txtTanyiUp);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaisu() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtKaisu();
    }

    @JsonIgnore
    public void  setTxtKaisu(TextBoxNum txtKaisu) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtKaisu(txtKaisu);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyiSu() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtServiceTanyiSu();
    }

    @JsonIgnore
    public void  setTxtServiceTanyiSu(TextBoxNum txtServiceTanyiSu) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtServiceTanyiSu(txtServiceTanyiSu);
    }

    @JsonIgnore
    public TextBox getTxtTekiyoUp() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtTekiyoUp();
    }

    @JsonIgnore
    public void  setTxtTekiyoUp(TextBox txtTekiyoUp) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtTekiyoUp(txtTekiyoUp);
    }

    @JsonIgnore
    public HorizontalLine getHrFree() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getHrFree();
    }

    @JsonIgnore
    public void  setHrFree(HorizontalLine hrFree) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setHrFree(hrFree);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaYM() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtShinsaYM();
    }

    @JsonIgnore
    public void  setTxtShinsaYM(TextBoxDate txtShinsaYM) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtShinsaYM(txtShinsaYM);
    }

    @JsonIgnore
    public TextBox getTxtShikyuKubun() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtShikyuKubun();
    }

    @JsonIgnore
    public void  setTxtShikyuKubun(TextBox txtShikyuKubun) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtShikyuKubun(txtShikyuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtServiceTanyi() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtServiceTanyi();
    }

    @JsonIgnore
    public void  setTxtServiceTanyi(TextBoxNum txtServiceTanyi) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtServiceTanyi(txtServiceTanyi);
    }

    @JsonIgnore
    public TextBoxNum getTxtShihanayiKingaku() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtShihanayiKingaku();
    }

    @JsonIgnore
    public void  setTxtShihanayiKingaku(TextBoxNum txtShihanayiKingaku) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtShihanayiKingaku(txtShihanayiKingaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtZougenten() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtZougenten();
    }

    @JsonIgnore
    public void  setTxtZougenten(TextBoxNum txtZougenten) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtZougenten(txtZougenten);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote1() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtNote1();
    }

    @JsonIgnore
    public void  setTxtNote1(TextBoxMultiLine txtNote1) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtNote1(txtNote1);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote2() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtNote2();
    }

    @JsonIgnore
    public void  setTxtNote2(TextBoxMultiLine txtNote2) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtNote2(txtNote2);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNote3() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getTxtNote3();
    }

    @JsonIgnore
    public void  setTxtNote3(TextBoxMultiLine txtNote3) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setTxtNote3(txtNote3);
    }

    @JsonIgnore
    public Button getBtnClose() {
        return this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().getBtnClose();
    }

    @JsonIgnore
    public void  setBtnClose(Button btnClose) {
        this.getPanelServiceKeikakuhiUp1().getPanelServiceKeikakuhiUp().setBtnClose(btnClose);
    }

    @JsonIgnore
    public TextBoxCode getTxtShiteiJigyoshaKubunCode() {
        return this.getPanelServiceKeikakuhiDown().getTxtShiteiJigyoshaKubunCode();
    }

    @JsonIgnore
    public void  setTxtShiteiJigyoshaKubunCode(TextBoxCode txtShiteiJigyoshaKubunCode) {
        this.getPanelServiceKeikakuhiDown().setTxtShiteiJigyoshaKubunCode(txtShiteiJigyoshaKubunCode);
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
    public TextBoxDate getTxtShinsaYmdown() {
        return this.getPanelServiceKeikakuhiDown().getTxtShinsaYmdown();
    }

    @JsonIgnore
    public void  setTxtShinsaYmdown(TextBoxDate txtShinsaYmdown) {
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

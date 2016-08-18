package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * ServiceAddAndServicePlanCreate のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class ServiceAddAndServicePlanCreateDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinkiToroku")
    private ShinkiTorokuDiv ShinkiToroku;
    @JsonProperty("TodokedeshaJoho")
    private TodokedeshaJohoDiv TodokedeshaJoho;
    @JsonProperty("JigyoshaJoho")
    private JigyoshaJohoDiv JigyoshaJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinkiToroku
     * @return ShinkiToroku
     */
    @JsonProperty("ShinkiToroku")
    public ShinkiTorokuDiv getShinkiToroku() {
        return ShinkiToroku;
    }

    /*
     * setShinkiToroku
     * @param ShinkiToroku ShinkiToroku
     */
    @JsonProperty("ShinkiToroku")
    public void setShinkiToroku(ShinkiTorokuDiv ShinkiToroku) {
        this.ShinkiToroku = ShinkiToroku;
    }

    /*
     * getTodokedeshaJoho
     * @return TodokedeshaJoho
     */
    @JsonProperty("TodokedeshaJoho")
    public TodokedeshaJohoDiv getTodokedeshaJoho() {
        return TodokedeshaJoho;
    }

    /*
     * setTodokedeshaJoho
     * @param TodokedeshaJoho TodokedeshaJoho
     */
    @JsonProperty("TodokedeshaJoho")
    public void setTodokedeshaJoho(TodokedeshaJohoDiv TodokedeshaJoho) {
        this.TodokedeshaJoho = TodokedeshaJoho;
    }

    /*
     * getJigyoshaJoho
     * @return JigyoshaJoho
     */
    @JsonProperty("JigyoshaJoho")
    public JigyoshaJohoDiv getJigyoshaJoho() {
        return JigyoshaJoho;
    }

    /*
     * setJigyoshaJoho
     * @param JigyoshaJoho JigyoshaJoho
     */
    @JsonProperty("JigyoshaJoho")
    public void setJigyoshaJoho(JigyoshaJohoDiv JigyoshaJoho) {
        this.JigyoshaJoho = JigyoshaJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTorokuState() {
        return this.getShinkiToroku().getTxtTorokuState();
    }

    @JsonIgnore
    public void setTxtTorokuState(TextBox txtTorokuState) {
        this.getShinkiToroku().setTxtTorokuState(txtTorokuState);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiShinki() {
        return this.getShinkiToroku().getTxtNinteiShinseiShinki();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiShinki(TextBox txtNinteiShinseiShinki) {
        this.getShinkiToroku().setTxtNinteiShinseiShinki(txtNinteiShinseiShinki);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiSaishinsei() {
        return this.getShinkiToroku().getTxtNinteiShinseiSaishinsei();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiSaishinsei(TextBox txtNinteiShinseiSaishinsei) {
        this.getShinkiToroku().setTxtNinteiShinseiSaishinsei(txtNinteiShinseiSaishinsei);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiHenkoShinsei() {
        return this.getShinkiToroku().getTxtNinteiShinseiHenkoShinsei();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiHenkoShinsei(TextBox txtNinteiShinseiHenkoShinsei) {
        this.getShinkiToroku().setTxtNinteiShinseiHenkoShinsei(txtNinteiShinseiHenkoShinsei);
    }

    @JsonIgnore
    public TextBox getTxtNinteiShinseiServiceHenko() {
        return this.getShinkiToroku().getTxtNinteiShinseiServiceHenko();
    }

    @JsonIgnore
    public void setTxtNinteiShinseiServiceHenko(TextBox txtNinteiShinseiServiceHenko) {
        this.getShinkiToroku().setTxtNinteiShinseiServiceHenko(txtNinteiShinseiServiceHenko);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getTodokedeshaJoho().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getTodokedeshaJoho().setLin1(lin1);
    }

    @JsonIgnore
    public RadioButton getRadKeikakuKubun() {
        return this.getTodokedeshaJoho().getRadKeikakuKubun();
    }

    @JsonIgnore
    public void setRadKeikakuKubun(RadioButton radKeikakuKubun) {
        this.getTodokedeshaJoho().setRadKeikakuKubun(radKeikakuKubun);
    }

    @JsonIgnore
    public RadioButton getRadTodokedeKubun() {
        return this.getTodokedeshaJoho().getRadTodokedeKubun();
    }

    @JsonIgnore
    public void setRadTodokedeKubun(RadioButton radTodokedeKubun) {
        this.getTodokedeshaJoho().setRadTodokedeKubun(radTodokedeKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokedeYMD() {
        return this.getTodokedeshaJoho().getTxtTodokedeYMD();
    }

    @JsonIgnore
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.getTodokedeshaJoho().setTxtTodokedeYMD(txtTodokedeYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeikakuTekiyoStartYMD() {
        return this.getTodokedeshaJoho().getTxtKeikakuTekiyoStartYMD();
    }

    @JsonIgnore
    public void setTxtKeikakuTekiyoStartYMD(TextBoxDate txtKeikakuTekiyoStartYMD) {
        this.getTodokedeshaJoho().setTxtKeikakuTekiyoStartYMD(txtKeikakuTekiyoStartYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeikakuTekiyoEndYMD() {
        return this.getTodokedeshaJoho().getTxtKeikakuTekiyoEndYMD();
    }

    @JsonIgnore
    public void setTxtKeikakuTekiyoEndYMD(TextBoxDate txtKeikakuTekiyoEndYMD) {
        this.getTodokedeshaJoho().setTxtKeikakuTekiyoEndYMD(txtKeikakuTekiyoEndYMD);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaName() {
        return this.getTodokedeshaJoho().getTxtTodokedeshaName();
    }

    @JsonIgnore
    public void setTxtTodokedeshaName(TextBox txtTodokedeshaName) {
        this.getTodokedeshaJoho().setTxtTodokedeshaName(txtTodokedeshaName);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaNameKana() {
        return this.getTodokedeshaJoho().getTxtTodokedeshaNameKana();
    }

    @JsonIgnore
    public void setTxtTodokedeshaNameKana(TextBox txtTodokedeshaNameKana) {
        this.getTodokedeshaJoho().setTxtTodokedeshaNameKana(txtTodokedeshaNameKana);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaYubinNo() {
        return this.getTodokedeshaJoho().getTxtTodokedeshaYubinNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaYubinNo(TextBox txtTodokedeshaYubinNo) {
        this.getTodokedeshaJoho().setTxtTodokedeshaYubinNo(txtTodokedeshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaJusho() {
        return this.getTodokedeshaJoho().getTxtTodokedeshaJusho();
    }

    @JsonIgnore
    public void setTxtTodokedeshaJusho(TextBox txtTodokedeshaJusho) {
        this.getTodokedeshaJoho().setTxtTodokedeshaJusho(txtTodokedeshaJusho);
    }

    @JsonIgnore
    public TextBox getTxtTodokedeshaTelNo() {
        return this.getTodokedeshaJoho().getTxtTodokedeshaTelNo();
    }

    @JsonIgnore
    public void setTxtTodokedeshaTelNo(TextBox txtTodokedeshaTelNo) {
        this.getTodokedeshaJoho().setTxtTodokedeshaTelNo(txtTodokedeshaTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlTodokedeshaKankeiKubun() {
        return this.getTodokedeshaJoho().getDdlTodokedeshaKankeiKubun();
    }

    @JsonIgnore
    public void setDdlTodokedeshaKankeiKubun(DropDownList ddlTodokedeshaKankeiKubun) {
        this.getTodokedeshaJoho().setDdlTodokedeshaKankeiKubun(ddlTodokedeshaKankeiKubun);
    }

    @JsonIgnore
    public RadioButton getRadKeikakuSakuseiKubun() {
        return this.getTodokedeshaJoho().getRadKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void setRadKeikakuSakuseiKubun(RadioButton radKeikakuSakuseiKubun) {
        this.getTodokedeshaJoho().setRadKeikakuSakuseiKubun(radKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getJigyoshaJoho().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getJigyoshaJoho().setLin2(lin2);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaNo() {
        return this.getJigyoshaJoho().getTxtJigyoshaNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaNo(TextBox txtJigyoshaNo) {
        this.getJigyoshaJoho().setTxtJigyoshaNo(txtJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyoshaKensaku() {
        return this.getJigyoshaJoho().getBtnJigyoshaKensaku();
    }

    @JsonIgnore
    public void setBtnJigyoshaKensaku(ButtonDialog btnJigyoshaKensaku) {
        this.getJigyoshaJoho().setBtnJigyoshaKensaku(btnJigyoshaKensaku);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaName() {
        return this.getJigyoshaJoho().getTxtJigyoshaName();
    }

    @JsonIgnore
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.getJigyoshaJoho().setTxtJigyoshaName(txtJigyoshaName);
    }

    @JsonIgnore
    public RadioButton getRadServiceShurui() {
        return this.getJigyoshaJoho().getRadServiceShurui();
    }

    @JsonIgnore
    public void setRadServiceShurui(RadioButton radServiceShurui) {
        this.getJigyoshaJoho().setRadServiceShurui(radServiceShurui);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaYubinNo() {
        return this.getJigyoshaJoho().getTxtJigyoshaYubinNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaYubinNo(TextBox txtJigyoshaYubinNo) {
        this.getJigyoshaJoho().setTxtJigyoshaYubinNo(txtJigyoshaYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJigyoshaJusho() {
        return this.getJigyoshaJoho().getTxtJigyoshaJusho();
    }

    @JsonIgnore
    public void setTxtJigyoshaJusho(TextBoxMultiLine txtJigyoshaJusho) {
        this.getJigyoshaJoho().setTxtJigyoshaJusho(txtJigyoshaJusho);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaTelNo() {
        return this.getJigyoshaJoho().getTxtJigyoshaTelNo();
    }

    @JsonIgnore
    public void setTxtJigyoshaTelNo(TextBox txtJigyoshaTelNo) {
        this.getJigyoshaJoho().setTxtJigyoshaTelNo(txtJigyoshaTelNo);
    }

    @JsonIgnore
    public TextBox getTxtJigyoshaKanrishaName() {
        return this.getJigyoshaJoho().getTxtJigyoshaKanrishaName();
    }

    @JsonIgnore
    public void setTxtJigyoshaKanrishaName(TextBox txtJigyoshaKanrishaName) {
        this.getJigyoshaJoho().setTxtJigyoshaKanrishaName(txtJigyoshaKanrishaName);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaNo() {
        return this.getJigyoshaJoho().getTxtItakusakiJigyoshaNo();
    }

    @JsonIgnore
    public void setTxtItakusakiJigyoshaNo(TextBox txtItakusakiJigyoshaNo) {
        this.getJigyoshaJoho().setTxtItakusakiJigyoshaNo(txtItakusakiJigyoshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnItakuSakiJigyoshaKensaku() {
        return this.getJigyoshaJoho().getBtnItakuSakiJigyoshaKensaku();
    }

    @JsonIgnore
    public void setBtnItakuSakiJigyoshaKensaku(ButtonDialog btnItakuSakiJigyoshaKensaku) {
        this.getJigyoshaJoho().setBtnItakuSakiJigyoshaKensaku(btnItakuSakiJigyoshaKensaku);
    }

    @JsonIgnore
    public TextBox getTxtItakusakiJigyoshaName() {
        return this.getJigyoshaJoho().getTxtItakusakiJigyoshaName();
    }

    @JsonIgnore
    public void setTxtItakusakiJigyoshaName(TextBox txtItakusakiJigyoshaName) {
        this.getJigyoshaJoho().setTxtItakusakiJigyoshaName(txtItakusakiJigyoshaName);
    }

    @JsonIgnore
    public Label getLblJigyoshaDescription() {
        return this.getJigyoshaJoho().getLblJigyoshaDescription();
    }

    @JsonIgnore
    public void setLblJigyoshaDescription(Label lblJigyoshaDescription) {
        this.getJigyoshaJoho().setLblJigyoshaDescription(lblJigyoshaDescription);
    }

    @JsonIgnore
    public TextBoxDate getTxtJigyoshaHenkoYMD() {
        return this.getJigyoshaJoho().getTxtJigyoshaHenkoYMD();
    }

    @JsonIgnore
    public void setTxtJigyoshaHenkoYMD(TextBoxDate txtJigyoshaHenkoYMD) {
        this.getJigyoshaJoho().setTxtJigyoshaHenkoYMD(txtJigyoshaHenkoYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtJigyoshaHenkoJiyu() {
        return this.getJigyoshaJoho().getTxtJigyoshaHenkoJiyu();
    }

    @JsonIgnore
    public void setTxtJigyoshaHenkoJiyu(TextBoxMultiLine txtJigyoshaHenkoJiyu) {
        this.getJigyoshaJoho().setTxtJigyoshaHenkoJiyu(txtJigyoshaHenkoJiyu);
    }

    // </editor-fold>
}

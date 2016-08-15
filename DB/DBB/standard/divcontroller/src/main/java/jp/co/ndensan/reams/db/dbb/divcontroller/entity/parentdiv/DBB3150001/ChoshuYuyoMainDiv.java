package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * ChoshuYuyoMain のクラスファイル
 *
 * @reamsid_L DBB-1680-010 gongliang
 */
public class ChoshuYuyoMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiJokyo")
    private TextBox txtShinseiJokyo;
    @JsonProperty("btnTeisei")
    private Button btnTeisei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("tblChoshuYuyo")
    private tblChoshuYuyoDiv tblChoshuYuyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiJokyo
     * @return txtShinseiJokyo
     */
    @JsonProperty("txtShinseiJokyo")
    public TextBox getTxtShinseiJokyo() {
        return txtShinseiJokyo;
    }

    /*
     * settxtShinseiJokyo
     * @param txtShinseiJokyo txtShinseiJokyo
     */
    @JsonProperty("txtShinseiJokyo")
    public void setTxtShinseiJokyo(TextBox txtShinseiJokyo) {
        this.txtShinseiJokyo = txtShinseiJokyo;
    }

    /*
     * getbtnTeisei
     * @return btnTeisei
     */
    @JsonProperty("btnTeisei")
    public Button getBtnTeisei() {
        return btnTeisei;
    }

    /*
     * setbtnTeisei
     * @param btnTeisei btnTeisei
     */
    @JsonProperty("btnTeisei")
    public void setBtnTeisei(Button btnTeisei) {
        this.btnTeisei = btnTeisei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * gettblChoshuYuyo
     * @return tblChoshuYuyo
     */
    @JsonProperty("tblChoshuYuyo")
    public tblChoshuYuyoDiv getTblChoshuYuyo() {
        return tblChoshuYuyo;
    }

    /*
     * settblChoshuYuyo
     * @param tblChoshuYuyo tblChoshuYuyo
     */
    @JsonProperty("tblChoshuYuyo")
    public void setTblChoshuYuyo(tblChoshuYuyoDiv tblChoshuYuyo) {
        this.tblChoshuYuyo = tblChoshuYuyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TorikeshiJohoDiv getTorikeshiJoho() {
        return this.getTblChoshuYuyo().getTorikeshiJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtTorikeshiYMD() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getTxtTorikeshiYMD();
    }

    @JsonIgnore
    public void setTxtTorikeshiYMD(TextBoxDate txtTorikeshiYMD) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setTxtTorikeshiYMD(txtTorikeshiYMD);
    }

    @JsonIgnore
    public ButtonDialog getBtnTorikeshiShurui() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getBtnTorikeshiShurui();
    }

    @JsonIgnore
    public void setBtnTorikeshiShurui(ButtonDialog btnTorikeshiShurui) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setBtnTorikeshiShurui(btnTorikeshiShurui);
    }

    @JsonIgnore
    public TextBox getTxtTorikeshiShurui() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getTxtTorikeshiShurui();
    }

    @JsonIgnore
    public void setTxtTorikeshiShurui(TextBox txtTorikeshiShurui) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setTxtTorikeshiShurui(txtTorikeshiShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return this.getTblChoshuYuyo().getTorikeshiJoho().getTxtTorikeshiRiyu();
    }

    @JsonIgnore
    public void setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.getTblChoshuYuyo().getTorikeshiJoho().setTxtTorikeshiRiyu(txtTorikeshiRiyu);
    }

    @JsonIgnore
    public ShinseiJohoDiv getShinseiJoho() {
        return this.getTblChoshuYuyo().getShinseiJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiNendo() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxDate txtChoteiNendo) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaNendo() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtFukaNendo();
    }

    @JsonIgnore
    public void setTxtFukaNendo(TextBoxDate txtFukaNendo) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public ButtonDialog getBtnYuyoShurui() {
        return this.getTblChoshuYuyo().getShinseiJoho().getBtnYuyoShurui();
    }

    @JsonIgnore
    public void setBtnYuyoShurui(ButtonDialog btnYuyoShurui) {
        this.getTblChoshuYuyo().getShinseiJoho().setBtnYuyoShurui(btnYuyoShurui);
    }

    @JsonIgnore
    public TextBox getTxtYuyoShurui() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtYuyoShurui();
    }

    @JsonIgnore
    public void setTxtYuyoShurui(TextBox txtYuyoShurui) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtYuyoShurui(txtYuyoShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getTblChoshuYuyo().getShinseiJoho().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getTblChoshuYuyo().getShinseiJoho().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getTblChoshuYuyo().getKetteiJoho();
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTblChoshuYuyo().getKetteiJoho().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTblChoshuYuyo().getKetteiJoho().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getTblChoshuYuyo().getKetteiJoho().getRadKetteiKubun();
    }

    @JsonIgnore
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getTblChoshuYuyo().getKetteiJoho().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return this.getTblChoshuYuyo().getKetteiJoho().getTxtKetteiRiyu();
    }

    @JsonIgnore
    public void setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.getTblChoshuYuyo().getKetteiJoho().setTxtKetteiRiyu(txtKetteiRiyu);
    }

    @JsonIgnore
    public KiwarigakuDiv getKiwarigaku() {
        return this.getTblChoshuYuyo().getKiwarigaku();
    }

    @JsonIgnore
    public FuchoTablePanelDiv getFuchoTablePanel() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel();
    }

    @JsonIgnore
    public void setFuchoTablePanel(FuchoTablePanelDiv FuchoTablePanel) {
        this.getTblChoshuYuyo().getKiwarigaku().setFuchoTablePanel(FuchoTablePanel);
    }

    @JsonIgnore
    public Label getLblFucho() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFucho();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki4Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki4Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku13() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku13();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi13() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi13();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo13() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo13();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki5Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki5Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku14() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku14();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi14() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi14();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo14() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo14();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki6Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki6Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi1() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi1();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku1() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku1();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi1() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi1();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo1() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo1();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki7Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki7Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi2();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku2();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi2();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo2();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki8Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki8Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi3() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi3();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku3() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku3();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi3() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi3();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo3() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo3();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki9Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki9Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi4() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi4();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku4() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku4();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi4() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi4();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo4() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo4();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki10Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki10Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi5() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi5();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku5() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku5();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi5() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi5();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo5() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo5();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki11Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki11Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi6() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi6();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku6() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku6();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi6() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi6();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo6() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo6();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki12Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki12Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi7() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi7();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku7() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku7();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi7() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi7();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo7() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo7();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki1Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki1Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi8() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi8();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku8() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku8();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi8() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi8();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo8() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo8();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki2Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki2Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi9() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi9();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku9() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku9();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi9() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi9();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo9() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo9();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki3Gatsu() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki3Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku10() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku10();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi10() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi10();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo10() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo10();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki4Gatsu2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki4Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku11() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku11();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi11() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi11();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo11() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo11();
    }

    @JsonIgnore
    public Label getLblFuchoTsuki5Gatsu2() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsuki5Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku12() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGaku12();
    }

    @JsonIgnore
    public Label getLblYuyoKikanKaishi12() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanKaishi12();
    }

    @JsonIgnore
    public Label getLblYuyoKikanShuryo12() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblYuyoKikanShuryo12();
    }

    @JsonIgnore
    public Label getLblFuchoTsukiTotal() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoTsukiTotal();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGakuTotal() {
        return this.getTblChoshuYuyo().getKiwarigaku().getFuchoTablePanel().getLblFuchoNofuGakuTotal();
    }

    // </editor-fold>
}

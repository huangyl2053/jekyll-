package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * GemmenMain のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class GemmenMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinseiJokyo")
    private ShinseiJokyoDiv ShinseiJokyo;
    @JsonProperty("TorikeshiInfo")
    private TorikeshiInfoDiv TorikeshiInfo;
    @JsonProperty("Shinseiinfo")
    private ShinseiinfoDiv Shinseiinfo;
    @JsonProperty("Keteiinfo")
    private KeteiinfoDiv Keteiinfo;
    @JsonProperty("Kiwarigaku")
    private KiwarigakuDiv Kiwarigaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinseiJokyo
     * @return ShinseiJokyo
     */
    @JsonProperty("ShinseiJokyo")
    public ShinseiJokyoDiv getShinseiJokyo() {
        return ShinseiJokyo;
    }

    /*
     * setShinseiJokyo
     * @param ShinseiJokyo ShinseiJokyo
     */
    @JsonProperty("ShinseiJokyo")
    public void setShinseiJokyo(ShinseiJokyoDiv ShinseiJokyo) {
        this.ShinseiJokyo = ShinseiJokyo;
    }

    /*
     * getTorikeshiInfo
     * @return TorikeshiInfo
     */
    @JsonProperty("TorikeshiInfo")
    public TorikeshiInfoDiv getTorikeshiInfo() {
        return TorikeshiInfo;
    }

    /*
     * setTorikeshiInfo
     * @param TorikeshiInfo TorikeshiInfo
     */
    @JsonProperty("TorikeshiInfo")
    public void setTorikeshiInfo(TorikeshiInfoDiv TorikeshiInfo) {
        this.TorikeshiInfo = TorikeshiInfo;
    }

    /*
     * getShinseiinfo
     * @return Shinseiinfo
     */
    @JsonProperty("Shinseiinfo")
    public ShinseiinfoDiv getShinseiinfo() {
        return Shinseiinfo;
    }

    /*
     * setShinseiinfo
     * @param Shinseiinfo Shinseiinfo
     */
    @JsonProperty("Shinseiinfo")
    public void setShinseiinfo(ShinseiinfoDiv Shinseiinfo) {
        this.Shinseiinfo = Shinseiinfo;
    }

    /*
     * getKeteiinfo
     * @return Keteiinfo
     */
    @JsonProperty("Keteiinfo")
    public KeteiinfoDiv getKeteiinfo() {
        return Keteiinfo;
    }

    /*
     * setKeteiinfo
     * @param Keteiinfo Keteiinfo
     */
    @JsonProperty("Keteiinfo")
    public void setKeteiinfo(KeteiinfoDiv Keteiinfo) {
        this.Keteiinfo = Keteiinfo;
    }

    /*
     * getKiwarigaku
     * @return Kiwarigaku
     */
    @JsonProperty("Kiwarigaku")
    public KiwarigakuDiv getKiwarigaku() {
        return Kiwarigaku;
    }

    /*
     * setKiwarigaku
     * @param Kiwarigaku Kiwarigaku
     */
    @JsonProperty("Kiwarigaku")
    public void setKiwarigaku(KiwarigakuDiv Kiwarigaku) {
        this.Kiwarigaku = Kiwarigaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtShinseiJokyo() {
        return this.getShinseiJokyo().getTxtShinseiJokyo();
    }

    @JsonIgnore
    public void setTxtShinseiJokyo(TextBox txtShinseiJokyo) {
        this.getShinseiJokyo().setTxtShinseiJokyo(txtShinseiJokyo);
    }

    @JsonIgnore
    public Button getBtnTesei() {
        return this.getShinseiJokyo().getBtnTesei();
    }

    @JsonIgnore
    public void setBtnTesei(Button btnTesei) {
        this.getShinseiJokyo().setBtnTesei(btnTesei);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getShinseiJokyo().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getShinseiJokyo().setBtnTorikeshi(btnTorikeshi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTorikeshiYMD() {
        return this.getTorikeshiInfo().getTxtTorikeshiYMD();
    }

    @JsonIgnore
    public void setTxtTorikeshiYMD(TextBoxDate txtTorikeshiYMD) {
        this.getTorikeshiInfo().setTxtTorikeshiYMD(txtTorikeshiYMD);
    }

    @JsonIgnore
    public ButtonDialog getBtnTorikeshiShurui() {
        return this.getTorikeshiInfo().getBtnTorikeshiShurui();
    }

    @JsonIgnore
    public void setBtnTorikeshiShurui(ButtonDialog btnTorikeshiShurui) {
        this.getTorikeshiInfo().setBtnTorikeshiShurui(btnTorikeshiShurui);
    }

    @JsonIgnore
    public TextBox getTxtTorikeshiShurui() {
        return this.getTorikeshiInfo().getTxtTorikeshiShurui();
    }

    @JsonIgnore
    public void setTxtTorikeshiShurui(TextBox txtTorikeshiShurui) {
        this.getTorikeshiInfo().setTxtTorikeshiShurui(txtTorikeshiShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTorikeshiRiyu() {
        return this.getTorikeshiInfo().getTxtTorikeshiRiyu();
    }

    @JsonIgnore
    public void setTxtTorikeshiRiyu(TextBoxMultiLine txtTorikeshiRiyu) {
        this.getTorikeshiInfo().setTxtTorikeshiRiyu(txtTorikeshiRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtChoteiYY() {
        return this.getShinseiinfo().getTxtChoteiYY();
    }

    @JsonIgnore
    public void setTxtChoteiYY(TextBoxDate txtChoteiYY) {
        this.getShinseiinfo().setTxtChoteiYY(txtChoteiYY);
    }

    @JsonIgnore
    public TextBoxDate getTxtFukaYY() {
        return this.getShinseiinfo().getTxtFukaYY();
    }

    @JsonIgnore
    public void setTxtFukaYY(TextBoxDate txtFukaYY) {
        this.getShinseiinfo().setTxtFukaYY(txtFukaYY);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getShinseiinfo().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getShinseiinfo().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinseiGemmengaku() {
        return this.getShinseiinfo().getTxtShinseiGemmengaku();
    }

    @JsonIgnore
    public void setTxtShinseiGemmengaku(TextBoxNum txtShinseiGemmengaku) {
        this.getShinseiinfo().setTxtShinseiGemmengaku(txtShinseiGemmengaku);
    }

    @JsonIgnore
    public ButtonDialog getBtnGemmenShurui() {
        return this.getShinseiinfo().getBtnGemmenShurui();
    }

    @JsonIgnore
    public void setBtnGemmenShurui(ButtonDialog btnGemmenShurui) {
        this.getShinseiinfo().setBtnGemmenShurui(btnGemmenShurui);
    }

    @JsonIgnore
    public TextBox getTxtGemmenShurui() {
        return this.getShinseiinfo().getTxtGemmenShurui();
    }

    @JsonIgnore
    public void setTxtGemmenShurui(TextBox txtGemmenShurui) {
        this.getShinseiinfo().setTxtGemmenShurui(txtGemmenShurui);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShinseiinfo().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShinseiinfo().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getKeteiinfo().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getKeteiinfo().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiGemmengaku() {
        return this.getKeteiinfo().getTxtZenkaiGemmengaku();
    }

    @JsonIgnore
    public void setTxtZenkaiGemmengaku(TextBoxNum txtZenkaiGemmengaku) {
        this.getKeteiinfo().setTxtZenkaiGemmengaku(txtZenkaiGemmengaku);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getKeteiinfo().getRadKetteiKubun();
    }

    @JsonIgnore
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getKeteiinfo().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKetteiRiyu() {
        return this.getKeteiinfo().getTxtKetteiRiyu();
    }

    @JsonIgnore
    public void setTxtKetteiRiyu(TextBoxMultiLine txtKetteiRiyu) {
        this.getKeteiinfo().setTxtKetteiRiyu(txtKetteiRiyu);
    }

    @JsonIgnore
    public Space getSpaKetteiJoho() {
        return this.getKeteiinfo().getSpaKetteiJoho();
    }

    @JsonIgnore
    public void setSpaKetteiJoho(Space spaKetteiJoho) {
        this.getKeteiinfo().setSpaKetteiJoho(spaKetteiJoho);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmengaku() {
        return this.getKiwarigaku().getTxtGemmengaku();
    }

    @JsonIgnore
    public void setTxtGemmengaku(TextBoxNum txtGemmengaku) {
        this.getKiwarigaku().setTxtGemmengaku(txtGemmengaku);
    }

    @JsonIgnore
    public Button getBtnCalculate() {
        return this.getKiwarigaku().getBtnCalculate();
    }

    @JsonIgnore
    public void setBtnCalculate(Button btnCalculate) {
        this.getKiwarigaku().setBtnCalculate(btnCalculate);
    }

    @JsonIgnore
    public KiwarigakuPanel1Div getKiwarigakuPanel1() {
        return this.getKiwarigaku().getKiwarigakuPanel1();
    }

    @JsonIgnore
    public void setKiwarigakuPanel1(KiwarigakuPanel1Div KiwarigakuPanel1) {
        this.getKiwarigaku().setKiwarigakuPanel1(KiwarigakuPanel1);
    }

    @JsonIgnore
    public Label getLblFucho() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFucho();
    }

    @JsonIgnore
    public Label getLblTokucho() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokucho();
    }

    @JsonIgnore
    public Label getLblKiwarigakuTsuki() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigakuTsuki();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen();
    }

    @JsonIgnore
    public Label getLblTokuchoKi() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo();
    }

    @JsonIgnore
    public Label getLblKiwarigaku4Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku4Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae13() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae13();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo13() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo13();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen13() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen13();
    }

    @JsonIgnore
    public Label getLblTokuchoKi1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi1();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae1();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo1();
    }

    @JsonIgnore
    public Label getLblKiwarigaku5Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku5Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae14() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae14();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo14() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo14();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen14() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen14();
    }

    @JsonIgnore
    public Label getLblKiwarigaku6Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku6Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi1();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae1();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo1();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen1() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen1();
    }

    @JsonIgnore
    public Label getLblTokuchoKi2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi2();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae2();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku7Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku7Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi2();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae2();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo2();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku8Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku8Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi3();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae3();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo3();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen3();
    }

    @JsonIgnore
    public Label getLblTokuchoKi3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi3();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae3();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo3() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo3();
    }

    @JsonIgnore
    public Label getLblKiwarigaku9Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku9Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi4();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae4();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo4();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen4();
    }

    @JsonIgnore
    public Label getLblKiwarigaku10Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku10Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi5();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae5();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo5();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen5();
    }

    @JsonIgnore
    public Label getLblTokuchoKi4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi4();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae4();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo4() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo4();
    }

    @JsonIgnore
    public Label getLblKiwarigaku11Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku11Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi6();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae6();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo6();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen6();
    }

    @JsonIgnore
    public Label getLblKiwarigaku12Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku12Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi7() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi7();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae7() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae7();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo7() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo7();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen7() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen7();
    }

    @JsonIgnore
    public Label getLblTokuchoKi5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi5();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae5();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo5() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo5();
    }

    @JsonIgnore
    public Label getLblKiwarigaku1Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku1Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi8() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi8();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae8() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae8();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo8() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo8();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen8() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen8();
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku2Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi9() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi9();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae9() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae9();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo9() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo9();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen9() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen9();
    }

    @JsonIgnore
    public Label getLblTokuchoKi6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoKi6();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMae6();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo6() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGo6();
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Gatsu() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku3Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae10() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae10();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo10() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo10();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen10() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen10();
    }

    @JsonIgnore
    public Label getLblKiwarigaku4Gatsu2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku4Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae11() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae11();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo11() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo11();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen11() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen11();
    }

    @JsonIgnore
    public Label getLblKiwarigaku5Gatsu2() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigaku5Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae12() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMae12();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo12() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGo12();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen12() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoNokigen12();
    }

    @JsonIgnore
    public Label getLblKiwarigakuTotal() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblKiwarigakuTotal();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMaeTotal() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemMaeTotal();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGoTotal() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblFuchoGemmemGoTotal();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMaeTotal() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemMaeTotal();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGoTotal() {
        return this.getKiwarigaku().getKiwarigakuPanel1().getLblTokuchoGemmemGoTotal();
    }

    @JsonIgnore
    public KiwarigakuKanendo1Div getKiwarigakuKanendo1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1();
    }

    @JsonIgnore
    public void setKiwarigakuKanendo1(KiwarigakuKanendo1Div KiwarigakuKanendo1) {
        this.getKiwarigaku().setKiwarigakuKanendo1(KiwarigakuKanendo1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoChoteiYY1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getTxtKanendoChoteiYY1();
    }

    @JsonIgnore
    public void setTxtKanendoChoteiYY1(TextBoxDate txtKanendoChoteiYY1) {
        this.getKiwarigaku().getKiwarigakuKanendo1().setTxtKanendoChoteiYY1(txtKanendoChoteiYY1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoFukaYY1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getTxtKanendoFukaYY1();
    }

    @JsonIgnore
    public void setTxtKanendoFukaYY1(TextBoxDate txtKanendoFukaYY1) {
        this.getKiwarigaku().getKiwarigakuKanendo1().setTxtKanendoFukaYY1(txtKanendoFukaYY1);
    }

    @JsonIgnore
    public KiwarigakuPanel2Div getKiwarigakuPanel2() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2();
    }

    @JsonIgnore
    public void setKiwarigakuPanel2(KiwarigakuPanel2Div KiwarigakuPanel2) {
        this.getKiwarigaku().getKiwarigakuKanendo1().setKiwarigakuPanel2(KiwarigakuPanel2);
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Tsuki() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKiwarigaku2Tsuki();
    }

    @JsonIgnore
    public Label getLblKi2() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKi2();
    }

    @JsonIgnore
    public Label getLblGemmemMae2() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblGemmemMae2();
    }

    @JsonIgnore
    public Label getLblGemmemGo2() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblGemmemGo2();
    }

    @JsonIgnore
    public Label getLblNokigen2() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblNokigen2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku24Gatsu() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKiwarigaku24Gatsu();
    }

    @JsonIgnore
    public Label getKi1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getKi1();
    }

    @JsonIgnore
    public Label getMae1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getMae1();
    }

    @JsonIgnore
    public Label getGo1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getGo1();
    }

    @JsonIgnore
    public Label getNokigen1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getNokigen1();
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Total() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKiwarigaku2Total();
    }

    @JsonIgnore
    public Label getMaeTotalMae1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getMaeTotalMae1();
    }

    @JsonIgnore
    public Label getMaeTotalGo1() {
        return this.getKiwarigaku().getKiwarigakuKanendo1().getKiwarigakuPanel2().getMaeTotalGo1();
    }

    @JsonIgnore
    public KiwarigakuKanendo2Div getKiwarigakuKanendo2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2();
    }

    @JsonIgnore
    public void setKiwarigakuKanendo2(KiwarigakuKanendo2Div KiwarigakuKanendo2) {
        this.getKiwarigaku().setKiwarigakuKanendo2(KiwarigakuKanendo2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoChoteiYY2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getTxtKanendoChoteiYY2();
    }

    @JsonIgnore
    public void setTxtKanendoChoteiYY2(TextBoxDate txtKanendoChoteiYY2) {
        this.getKiwarigaku().getKiwarigakuKanendo2().setTxtKanendoChoteiYY2(txtKanendoChoteiYY2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoFukaYY2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getTxtKanendoFukaYY2();
    }

    @JsonIgnore
    public void setTxtKanendoFukaYY2(TextBoxDate txtKanendoFukaYY2) {
        this.getKiwarigaku().getKiwarigakuKanendo2().setTxtKanendoFukaYY2(txtKanendoFukaYY2);
    }

    @JsonIgnore
    public KiwarigakuPanel3Div getKiwarigakuPanel3() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3();
    }

    @JsonIgnore
    public void setKiwarigakuPanel3(KiwarigakuPanel3Div KiwarigakuPanel3) {
        this.getKiwarigaku().getKiwarigakuKanendo2().setKiwarigakuPanel3(KiwarigakuPanel3);
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Tsuki() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKiwarigaku3Tsuki();
    }

    @JsonIgnore
    public Label getLblKi3() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKi3();
    }

    @JsonIgnore
    public Label getLblGemmemMae3() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblGemmemMae3();
    }

    @JsonIgnore
    public Label getLblGemmemGo3() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblGemmemGo3();
    }

    @JsonIgnore
    public Label getLblNokigen3() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblNokigen3();
    }

    @JsonIgnore
    public Label getLblKiwarigaku34Gatsu() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKiwarigaku34Gatsu();
    }

    @JsonIgnore
    public Label getKi2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getKi2();
    }

    @JsonIgnore
    public Label getMae2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getMae2();
    }

    @JsonIgnore
    public Label getGo2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getGo2();
    }

    @JsonIgnore
    public Label getNokigen() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getNokigen();
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Total() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKiwarigaku3Total();
    }

    @JsonIgnore
    public Label getMaeTotalMae2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getMaeTotalMae2();
    }

    @JsonIgnore
    public Label getMaeTotalGo2() {
        return this.getKiwarigaku().getKiwarigakuKanendo2().getKiwarigakuPanel3().getMaeTotalGo2();
    }

    // </editor-fold>
}

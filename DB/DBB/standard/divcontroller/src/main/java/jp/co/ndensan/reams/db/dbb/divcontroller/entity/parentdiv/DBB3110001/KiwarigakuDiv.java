package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * Kiwarigaku のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class KiwarigakuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGemmengaku")
    private TextBoxNum txtGemmengaku;
    @JsonProperty("btnCalculate")
    private Button btnCalculate;
    @JsonProperty("KiwarigakuPanel1")
    private KiwarigakuPanel1Div KiwarigakuPanel1;
    @JsonProperty("KiwarigakuKanendo1")
    private KiwarigakuKanendo1Div KiwarigakuKanendo1;
    @JsonProperty("KiwarigakuKanendo2")
    private KiwarigakuKanendo2Div KiwarigakuKanendo2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGemmengaku
     * @return txtGemmengaku
     */
    @JsonProperty("txtGemmengaku")
    public TextBoxNum getTxtGemmengaku() {
        return txtGemmengaku;
    }

    /*
     * settxtGemmengaku
     * @param txtGemmengaku txtGemmengaku
     */
    @JsonProperty("txtGemmengaku")
    public void setTxtGemmengaku(TextBoxNum txtGemmengaku) {
        this.txtGemmengaku = txtGemmengaku;
    }

    /*
     * getbtnCalculate
     * @return btnCalculate
     */
    @JsonProperty("btnCalculate")
    public Button getBtnCalculate() {
        return btnCalculate;
    }

    /*
     * setbtnCalculate
     * @param btnCalculate btnCalculate
     */
    @JsonProperty("btnCalculate")
    public void setBtnCalculate(Button btnCalculate) {
        this.btnCalculate = btnCalculate;
    }

    /*
     * getKiwarigakuPanel1
     * @return KiwarigakuPanel1
     */
    @JsonProperty("KiwarigakuPanel1")
    public KiwarigakuPanel1Div getKiwarigakuPanel1() {
        return KiwarigakuPanel1;
    }

    /*
     * setKiwarigakuPanel1
     * @param KiwarigakuPanel1 KiwarigakuPanel1
     */
    @JsonProperty("KiwarigakuPanel1")
    public void setKiwarigakuPanel1(KiwarigakuPanel1Div KiwarigakuPanel1) {
        this.KiwarigakuPanel1 = KiwarigakuPanel1;
    }

    /*
     * getKiwarigakuKanendo1
     * @return KiwarigakuKanendo1
     */
    @JsonProperty("KiwarigakuKanendo1")
    public KiwarigakuKanendo1Div getKiwarigakuKanendo1() {
        return KiwarigakuKanendo1;
    }

    /*
     * setKiwarigakuKanendo1
     * @param KiwarigakuKanendo1 KiwarigakuKanendo1
     */
    @JsonProperty("KiwarigakuKanendo1")
    public void setKiwarigakuKanendo1(KiwarigakuKanendo1Div KiwarigakuKanendo1) {
        this.KiwarigakuKanendo1 = KiwarigakuKanendo1;
    }

    /*
     * getKiwarigakuKanendo2
     * @return KiwarigakuKanendo2
     */
    @JsonProperty("KiwarigakuKanendo2")
    public KiwarigakuKanendo2Div getKiwarigakuKanendo2() {
        return KiwarigakuKanendo2;
    }

    /*
     * setKiwarigakuKanendo2
     * @param KiwarigakuKanendo2 KiwarigakuKanendo2
     */
    @JsonProperty("KiwarigakuKanendo2")
    public void setKiwarigakuKanendo2(KiwarigakuKanendo2Div KiwarigakuKanendo2) {
        this.KiwarigakuKanendo2 = KiwarigakuKanendo2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblFucho() {
        return this.getKiwarigakuPanel1().getLblFucho();
    }

    @JsonIgnore
    public Label getLblTokucho() {
        return this.getKiwarigakuPanel1().getLblTokucho();
    }

    @JsonIgnore
    public Label getLblKiwarigakuTsuki() {
        return this.getKiwarigakuPanel1().getLblKiwarigakuTsuki();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getKiwarigakuPanel1().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen();
    }

    @JsonIgnore
    public Label getLblTokuchoKi() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo();
    }

    @JsonIgnore
    public Label getLblKiwarigaku4Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku4Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.getKiwarigakuPanel1().getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae13() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae13();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo13() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo13();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen13() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen13();
    }

    @JsonIgnore
    public Label getLblTokuchoKi1() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi1();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae1() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae1();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo1() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo1();
    }

    @JsonIgnore
    public Label getLblKiwarigaku5Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku5Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.getKiwarigakuPanel1().getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae14() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae14();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo14() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo14();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen14() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen14();
    }

    @JsonIgnore
    public Label getLblKiwarigaku6Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku6Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi1() {
        return this.getKiwarigakuPanel1().getLblFuchoKi1();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae1() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae1();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo1() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo1();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen1() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen1();
    }

    @JsonIgnore
    public Label getLblTokuchoKi2() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi2();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae2() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae2();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo2() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku7Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku7Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi2() {
        return this.getKiwarigakuPanel1().getLblFuchoKi2();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae2() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae2();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo2() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo2();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen2() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku8Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku8Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi3() {
        return this.getKiwarigakuPanel1().getLblFuchoKi3();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae3() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae3();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo3() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo3();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen3() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen3();
    }

    @JsonIgnore
    public Label getLblTokuchoKi3() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi3();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae3() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae3();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo3() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo3();
    }

    @JsonIgnore
    public Label getLblKiwarigaku9Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku9Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi4() {
        return this.getKiwarigakuPanel1().getLblFuchoKi4();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae4() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae4();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo4() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo4();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen4() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen4();
    }

    @JsonIgnore
    public Label getLblKiwarigaku10Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku10Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi5() {
        return this.getKiwarigakuPanel1().getLblFuchoKi5();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae5() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae5();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo5() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo5();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen5() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen5();
    }

    @JsonIgnore
    public Label getLblTokuchoKi4() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi4();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae4() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae4();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo4() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo4();
    }

    @JsonIgnore
    public Label getLblKiwarigaku11Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku11Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi6() {
        return this.getKiwarigakuPanel1().getLblFuchoKi6();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae6() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae6();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo6() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo6();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen6() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen6();
    }

    @JsonIgnore
    public Label getLblKiwarigaku12Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku12Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi7() {
        return this.getKiwarigakuPanel1().getLblFuchoKi7();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae7() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae7();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo7() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo7();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen7() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen7();
    }

    @JsonIgnore
    public Label getLblTokuchoKi5() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi5();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae5() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae5();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo5() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo5();
    }

    @JsonIgnore
    public Label getLblKiwarigaku1Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku1Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi8() {
        return this.getKiwarigakuPanel1().getLblFuchoKi8();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae8() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae8();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo8() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo8();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen8() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen8();
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku2Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi9() {
        return this.getKiwarigakuPanel1().getLblFuchoKi9();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae9() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae9();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo9() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo9();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen9() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen9();
    }

    @JsonIgnore
    public Label getLblTokuchoKi6() {
        return this.getKiwarigakuPanel1().getLblTokuchoKi6();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMae6() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMae6();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGo6() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGo6();
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Gatsu() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku3Gatsu();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getKiwarigakuPanel1().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae10() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae10();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo10() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo10();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen10() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen10();
    }

    @JsonIgnore
    public Label getLblKiwarigaku4Gatsu2() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku4Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getKiwarigakuPanel1().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae11() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae11();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo11() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo11();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen11() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen11();
    }

    @JsonIgnore
    public Label getLblKiwarigaku5Gatsu2() {
        return this.getKiwarigakuPanel1().getLblKiwarigaku5Gatsu2();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getKiwarigakuPanel1().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMae12() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMae12();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGo12() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGo12();
    }

    @JsonIgnore
    public Label getLblFuchoNokigen12() {
        return this.getKiwarigakuPanel1().getLblFuchoNokigen12();
    }

    @JsonIgnore
    public Label getLblKiwarigakuTotal() {
        return this.getKiwarigakuPanel1().getLblKiwarigakuTotal();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemMaeTotal() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemMaeTotal();
    }

    @JsonIgnore
    public Label getLblFuchoGemmemGoTotal() {
        return this.getKiwarigakuPanel1().getLblFuchoGemmemGoTotal();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemMaeTotal() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemMaeTotal();
    }

    @JsonIgnore
    public Label getLblTokuchoGemmemGoTotal() {
        return this.getKiwarigakuPanel1().getLblTokuchoGemmemGoTotal();
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoChoteiYY1() {
        return this.getKiwarigakuKanendo1().getTxtKanendoChoteiYY1();
    }

    @JsonIgnore
    public void setTxtKanendoChoteiYY1(TextBoxDate txtKanendoChoteiYY1) {
        this.getKiwarigakuKanendo1().setTxtKanendoChoteiYY1(txtKanendoChoteiYY1);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoFukaYY1() {
        return this.getKiwarigakuKanendo1().getTxtKanendoFukaYY1();
    }

    @JsonIgnore
    public void setTxtKanendoFukaYY1(TextBoxDate txtKanendoFukaYY1) {
        this.getKiwarigakuKanendo1().setTxtKanendoFukaYY1(txtKanendoFukaYY1);
    }

    @JsonIgnore
    public KiwarigakuPanel2Div getKiwarigakuPanel2() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2();
    }

    @JsonIgnore
    public void setKiwarigakuPanel2(KiwarigakuPanel2Div KiwarigakuPanel2) {
        this.getKiwarigakuKanendo1().setKiwarigakuPanel2(KiwarigakuPanel2);
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Tsuki() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKiwarigaku2Tsuki();
    }

    @JsonIgnore
    public Label getLblKi2() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKi2();
    }

    @JsonIgnore
    public Label getLblGemmemMae2() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblGemmemMae2();
    }

    @JsonIgnore
    public Label getLblGemmemGo2() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblGemmemGo2();
    }

    @JsonIgnore
    public Label getLblNokigen2() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblNokigen2();
    }

    @JsonIgnore
    public Label getLblKiwarigaku24Gatsu() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKiwarigaku24Gatsu();
    }

    @JsonIgnore
    public Label getKi1() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getKi1();
    }

    @JsonIgnore
    public Label getMae1() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getMae1();
    }

    @JsonIgnore
    public Label getGo1() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getGo1();
    }

    @JsonIgnore
    public Label getNokigen1() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getNokigen1();
    }

    @JsonIgnore
    public Label getLblKiwarigaku2Total() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getLblKiwarigaku2Total();
    }

    @JsonIgnore
    public Label getMaeTotalMae1() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getMaeTotalMae1();
    }

    @JsonIgnore
    public Label getMaeTotalGo1() {
        return this.getKiwarigakuKanendo1().getKiwarigakuPanel2().getMaeTotalGo1();
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoChoteiYY2() {
        return this.getKiwarigakuKanendo2().getTxtKanendoChoteiYY2();
    }

    @JsonIgnore
    public void setTxtKanendoChoteiYY2(TextBoxDate txtKanendoChoteiYY2) {
        this.getKiwarigakuKanendo2().setTxtKanendoChoteiYY2(txtKanendoChoteiYY2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKanendoFukaYY2() {
        return this.getKiwarigakuKanendo2().getTxtKanendoFukaYY2();
    }

    @JsonIgnore
    public void setTxtKanendoFukaYY2(TextBoxDate txtKanendoFukaYY2) {
        this.getKiwarigakuKanendo2().setTxtKanendoFukaYY2(txtKanendoFukaYY2);
    }

    @JsonIgnore
    public KiwarigakuPanel3Div getKiwarigakuPanel3() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3();
    }

    @JsonIgnore
    public void setKiwarigakuPanel3(KiwarigakuPanel3Div KiwarigakuPanel3) {
        this.getKiwarigakuKanendo2().setKiwarigakuPanel3(KiwarigakuPanel3);
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Tsuki() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKiwarigaku3Tsuki();
    }

    @JsonIgnore
    public Label getLblKi3() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKi3();
    }

    @JsonIgnore
    public Label getLblGemmemMae3() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblGemmemMae3();
    }

    @JsonIgnore
    public Label getLblGemmemGo3() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblGemmemGo3();
    }

    @JsonIgnore
    public Label getLblNokigen3() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblNokigen3();
    }

    @JsonIgnore
    public Label getLblKiwarigaku34Gatsu() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKiwarigaku34Gatsu();
    }

    @JsonIgnore
    public Label getKi2() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getKi2();
    }

    @JsonIgnore
    public Label getMae2() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getMae2();
    }

    @JsonIgnore
    public Label getGo2() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getGo2();
    }

    @JsonIgnore
    public Label getNokigen() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getNokigen();
    }

    @JsonIgnore
    public Label getLblKiwarigaku3Total() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getLblKiwarigaku3Total();
    }

    @JsonIgnore
    public Label getMaeTotalMae2() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getMaeTotalMae2();
    }

    @JsonIgnore
    public Label getMaeTotalGo2() {
        return this.getKiwarigakuKanendo2().getKiwarigakuPanel3().getMaeTotalGo2();
    }

    // </editor-fold>
}

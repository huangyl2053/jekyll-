package jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinchokuJokyoKojin;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinchoKujokyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinchoKujokyoDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTableCell1")
    private celTableCell1AttplShinchoKujokyo celTableCell1;
    @JsonProperty("celTableCell2")
    private celTableCell2AttplShinchoKujokyo celTableCell2;
    @JsonProperty("celTableCell3")
    private celTableCell3AttplShinchoKujokyo celTableCell3;
    @JsonProperty("celTableCell7")
    private celTableCell7AttplShinchoKujokyo celTableCell7;
    @JsonProperty("celTableCell8")
    private celTableCell8AttplShinchoKujokyo celTableCell8;
    @JsonProperty("celTableCell9")
    private celTableCell9AttplShinchoKujokyo celTableCell9;
    @JsonProperty("celTableCell10")
    private celTableCell10AttplShinchoKujokyo celTableCell10;
    @JsonProperty("celTableCell11")
    private celTableCell11AttplShinchoKujokyo celTableCell11;
    @JsonProperty("celTableCell12")
    private celTableCell12AttplShinchoKujokyo celTableCell12;
    @JsonProperty("celTableCell13")
    private celTableCell13AttplShinchoKujokyo celTableCell13;
    @JsonProperty("celTableCell4")
    private celTableCell4AttplShinchoKujokyo celTableCell4;
    @JsonProperty("celTableCell5")
    private celTableCell5AttplShinchoKujokyo celTableCell5;
    @JsonProperty("celTableCell6")
    private celTableCell6AttplShinchoKujokyo celTableCell6;
    @JsonProperty("celTableCell14")
    private celTableCell14AttplShinchoKujokyo celTableCell14;
    @JsonProperty("celTableCell15")
    private celTableCell15AttplShinchoKujokyo celTableCell15;
    @JsonProperty("celTableCell16")
    private celTableCell16AttplShinchoKujokyo celTableCell16;
    @JsonProperty("celTableCell17")
    private celTableCell17AttplShinchoKujokyo celTableCell17;
    @JsonProperty("celTableCell18")
    private celTableCell18AttplShinchoKujokyo celTableCell18;
    @JsonProperty("celTableCell19")
    private celTableCell19AttplShinchoKujokyo celTableCell19;
    @JsonProperty("celTableCell20")
    private celTableCell20AttplShinchoKujokyo celTableCell20;
    @JsonProperty("celTableCell21")
    private celTableCell21AttplShinchoKujokyo celTableCell21;
    @JsonProperty("celTableCell22")
    private celTableCell22AttplShinchoKujokyo celTableCell22;
    @JsonProperty("celTableCell23")
    private celTableCell23AttplShinchoKujokyo celTableCell23;
    @JsonProperty("celTableCell24")
    private celTableCell24AttplShinchoKujokyo celTableCell24;
    @JsonProperty("celTableCell25")
    private celTableCell25AttplShinchoKujokyo celTableCell25;
    @JsonProperty("celTableCell26")
    private celTableCell26AttplShinchoKujokyo celTableCell26;
    @JsonProperty("celTableCell27")
    private celTableCell27AttplShinchoKujokyo celTableCell27;
    @JsonProperty("celTableCell28")
    private celTableCell28AttplShinchoKujokyo celTableCell28;
    @JsonProperty("celTableCell29")
    private celTableCell29AttplShinchoKujokyo celTableCell29;
    @JsonProperty("celTableCell30")
    private celTableCell30AttplShinchoKujokyo celTableCell30;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShinseiToroku() {
        return this.celTableCell2.getLblShinseiToroku();
    }

    @JsonIgnore
    public Label getLblNinteiChosaIrai() {
        return this.celTableCell3.getLblNinteiChosaIrai();
    }

    @JsonIgnore
    public Label getLblNinteiChosaJisshi() {
        return this.celTableCell7.getLblNinteiChosaJisshi();
    }

    @JsonIgnore
    public Label getShujiIkenshoSakuseiIrai() {
        return this.celTableCell8.getShujiIkenshoSakuseiIrai();
    }

    @JsonIgnore
    public Label getLblShujiiIkenshoToroku() {
        return this.celTableCell9.getLblShujiiIkenshoToroku();
    }

    @JsonIgnore
    public Label getIblIchijiHantei() {
        return this.celTableCell10.getIblIchijiHantei();
    }

    @JsonIgnore
    public Label getLblMasking() {
        return this.celTableCell11.getLblMasking();
    }

    @JsonIgnore
    public Label getLblKaigoNinteiShinsakaiWaritsuke() {
        return this.celTableCell12.getLblKaigoNinteiShinsakaiWaritsuke();
    }

    @JsonIgnore
    public Label getLblKaigoNinteiShinsakaiJissi() {
        return this.celTableCell13.getLblKaigoNinteiShinsakaiJissi();
    }

    @JsonIgnore
    public Label getLblYoteiDay() {
        return this.celTableCell4.getLblYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiTorokuYoteiDay() {
        return this.celTableCell5.getTxtShinseiTorokuYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiYoteiDay() {
        return this.celTableCell6.getTxtNinteiChosaIraiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiYoteiDay() {
        return this.celTableCell14.getTxtNinteiChosaJisshiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiYoteiDay() {
        return this.celTableCell15.getTxtShujiIkenshoSakuseiIraiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoTorokuYoteiDay() {
        return this.celTableCell16.getTxtShujiiIkenshoTorokuYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiYoteiDay() {
        return this.celTableCell17.getTxtIchijiHanteiYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingYoteiDay() {
        return this.celTableCell18.getTxtMaskingYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay() {
        return this.celTableCell19.getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiYoteiDay() {
        return this.celTableCell20.getTxtKaigoNinteiShinsakaiJissiYoteiDay();
    }

    @JsonIgnore
    public Label getLblKanryoDay() {
        return this.celTableCell21.getLblKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiTorokuKanryoDay() {
        return this.celTableCell22.getTxtShinseiTorokuKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraiKanryoDay() {
        return this.celTableCell23.getTxtNinteiChosaIraiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshiKanryoDay() {
        return this.celTableCell24.getTxtNinteiChosaJisshiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiKanryoDay() {
        return this.celTableCell25.getTxtShujiIkenshoSakuseiIraiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoTorokuKanryoDay() {
        return this.celTableCell26.getTxtShujiiIkenshoTorokuKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiKanryoDay() {
        return this.celTableCell27.getTxtIchijiHanteiKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtMaskingKanryo() {
        return this.celTableCell28.getTxtMaskingKanryo();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay() {
        return this.celTableCell29.getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay();
    }

    @JsonIgnore
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiKanryoDay() {
        return this.celTableCell30.getTxtKaigoNinteiShinsakaiJissiKanryoDay();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celTableCell1")
    private celTableCell1AttplShinchoKujokyo getCelTableCell1() {
        return celTableCell1;
    }

    @JsonProperty("celTableCell1")
    private void setCelTableCell1(celTableCell1AttplShinchoKujokyo celTableCell1) {
        this.celTableCell1=celTableCell1;
    }

    @JsonProperty("celTableCell2")
    private celTableCell2AttplShinchoKujokyo getCelTableCell2() {
        return celTableCell2;
    }

    @JsonProperty("celTableCell2")
    private void setCelTableCell2(celTableCell2AttplShinchoKujokyo celTableCell2) {
        this.celTableCell2=celTableCell2;
    }

    @JsonProperty("celTableCell3")
    private celTableCell3AttplShinchoKujokyo getCelTableCell3() {
        return celTableCell3;
    }

    @JsonProperty("celTableCell3")
    private void setCelTableCell3(celTableCell3AttplShinchoKujokyo celTableCell3) {
        this.celTableCell3=celTableCell3;
    }

    @JsonProperty("celTableCell7")
    private celTableCell7AttplShinchoKujokyo getCelTableCell7() {
        return celTableCell7;
    }

    @JsonProperty("celTableCell7")
    private void setCelTableCell7(celTableCell7AttplShinchoKujokyo celTableCell7) {
        this.celTableCell7=celTableCell7;
    }

    @JsonProperty("celTableCell8")
    private celTableCell8AttplShinchoKujokyo getCelTableCell8() {
        return celTableCell8;
    }

    @JsonProperty("celTableCell8")
    private void setCelTableCell8(celTableCell8AttplShinchoKujokyo celTableCell8) {
        this.celTableCell8=celTableCell8;
    }

    @JsonProperty("celTableCell9")
    private celTableCell9AttplShinchoKujokyo getCelTableCell9() {
        return celTableCell9;
    }

    @JsonProperty("celTableCell9")
    private void setCelTableCell9(celTableCell9AttplShinchoKujokyo celTableCell9) {
        this.celTableCell9=celTableCell9;
    }

    @JsonProperty("celTableCell10")
    private celTableCell10AttplShinchoKujokyo getCelTableCell10() {
        return celTableCell10;
    }

    @JsonProperty("celTableCell10")
    private void setCelTableCell10(celTableCell10AttplShinchoKujokyo celTableCell10) {
        this.celTableCell10=celTableCell10;
    }

    @JsonProperty("celTableCell11")
    private celTableCell11AttplShinchoKujokyo getCelTableCell11() {
        return celTableCell11;
    }

    @JsonProperty("celTableCell11")
    private void setCelTableCell11(celTableCell11AttplShinchoKujokyo celTableCell11) {
        this.celTableCell11=celTableCell11;
    }

    @JsonProperty("celTableCell12")
    private celTableCell12AttplShinchoKujokyo getCelTableCell12() {
        return celTableCell12;
    }

    @JsonProperty("celTableCell12")
    private void setCelTableCell12(celTableCell12AttplShinchoKujokyo celTableCell12) {
        this.celTableCell12=celTableCell12;
    }

    @JsonProperty("celTableCell13")
    private celTableCell13AttplShinchoKujokyo getCelTableCell13() {
        return celTableCell13;
    }

    @JsonProperty("celTableCell13")
    private void setCelTableCell13(celTableCell13AttplShinchoKujokyo celTableCell13) {
        this.celTableCell13=celTableCell13;
    }

    @JsonProperty("celTableCell4")
    private celTableCell4AttplShinchoKujokyo getCelTableCell4() {
        return celTableCell4;
    }

    @JsonProperty("celTableCell4")
    private void setCelTableCell4(celTableCell4AttplShinchoKujokyo celTableCell4) {
        this.celTableCell4=celTableCell4;
    }

    @JsonProperty("celTableCell5")
    private celTableCell5AttplShinchoKujokyo getCelTableCell5() {
        return celTableCell5;
    }

    @JsonProperty("celTableCell5")
    private void setCelTableCell5(celTableCell5AttplShinchoKujokyo celTableCell5) {
        this.celTableCell5=celTableCell5;
    }

    @JsonProperty("celTableCell6")
    private celTableCell6AttplShinchoKujokyo getCelTableCell6() {
        return celTableCell6;
    }

    @JsonProperty("celTableCell6")
    private void setCelTableCell6(celTableCell6AttplShinchoKujokyo celTableCell6) {
        this.celTableCell6=celTableCell6;
    }

    @JsonProperty("celTableCell14")
    private celTableCell14AttplShinchoKujokyo getCelTableCell14() {
        return celTableCell14;
    }

    @JsonProperty("celTableCell14")
    private void setCelTableCell14(celTableCell14AttplShinchoKujokyo celTableCell14) {
        this.celTableCell14=celTableCell14;
    }

    @JsonProperty("celTableCell15")
    private celTableCell15AttplShinchoKujokyo getCelTableCell15() {
        return celTableCell15;
    }

    @JsonProperty("celTableCell15")
    private void setCelTableCell15(celTableCell15AttplShinchoKujokyo celTableCell15) {
        this.celTableCell15=celTableCell15;
    }

    @JsonProperty("celTableCell16")
    private celTableCell16AttplShinchoKujokyo getCelTableCell16() {
        return celTableCell16;
    }

    @JsonProperty("celTableCell16")
    private void setCelTableCell16(celTableCell16AttplShinchoKujokyo celTableCell16) {
        this.celTableCell16=celTableCell16;
    }

    @JsonProperty("celTableCell17")
    private celTableCell17AttplShinchoKujokyo getCelTableCell17() {
        return celTableCell17;
    }

    @JsonProperty("celTableCell17")
    private void setCelTableCell17(celTableCell17AttplShinchoKujokyo celTableCell17) {
        this.celTableCell17=celTableCell17;
    }

    @JsonProperty("celTableCell18")
    private celTableCell18AttplShinchoKujokyo getCelTableCell18() {
        return celTableCell18;
    }

    @JsonProperty("celTableCell18")
    private void setCelTableCell18(celTableCell18AttplShinchoKujokyo celTableCell18) {
        this.celTableCell18=celTableCell18;
    }

    @JsonProperty("celTableCell19")
    private celTableCell19AttplShinchoKujokyo getCelTableCell19() {
        return celTableCell19;
    }

    @JsonProperty("celTableCell19")
    private void setCelTableCell19(celTableCell19AttplShinchoKujokyo celTableCell19) {
        this.celTableCell19=celTableCell19;
    }

    @JsonProperty("celTableCell20")
    private celTableCell20AttplShinchoKujokyo getCelTableCell20() {
        return celTableCell20;
    }

    @JsonProperty("celTableCell20")
    private void setCelTableCell20(celTableCell20AttplShinchoKujokyo celTableCell20) {
        this.celTableCell20=celTableCell20;
    }

    @JsonProperty("celTableCell21")
    private celTableCell21AttplShinchoKujokyo getCelTableCell21() {
        return celTableCell21;
    }

    @JsonProperty("celTableCell21")
    private void setCelTableCell21(celTableCell21AttplShinchoKujokyo celTableCell21) {
        this.celTableCell21=celTableCell21;
    }

    @JsonProperty("celTableCell22")
    private celTableCell22AttplShinchoKujokyo getCelTableCell22() {
        return celTableCell22;
    }

    @JsonProperty("celTableCell22")
    private void setCelTableCell22(celTableCell22AttplShinchoKujokyo celTableCell22) {
        this.celTableCell22=celTableCell22;
    }

    @JsonProperty("celTableCell23")
    private celTableCell23AttplShinchoKujokyo getCelTableCell23() {
        return celTableCell23;
    }

    @JsonProperty("celTableCell23")
    private void setCelTableCell23(celTableCell23AttplShinchoKujokyo celTableCell23) {
        this.celTableCell23=celTableCell23;
    }

    @JsonProperty("celTableCell24")
    private celTableCell24AttplShinchoKujokyo getCelTableCell24() {
        return celTableCell24;
    }

    @JsonProperty("celTableCell24")
    private void setCelTableCell24(celTableCell24AttplShinchoKujokyo celTableCell24) {
        this.celTableCell24=celTableCell24;
    }

    @JsonProperty("celTableCell25")
    private celTableCell25AttplShinchoKujokyo getCelTableCell25() {
        return celTableCell25;
    }

    @JsonProperty("celTableCell25")
    private void setCelTableCell25(celTableCell25AttplShinchoKujokyo celTableCell25) {
        this.celTableCell25=celTableCell25;
    }

    @JsonProperty("celTableCell26")
    private celTableCell26AttplShinchoKujokyo getCelTableCell26() {
        return celTableCell26;
    }

    @JsonProperty("celTableCell26")
    private void setCelTableCell26(celTableCell26AttplShinchoKujokyo celTableCell26) {
        this.celTableCell26=celTableCell26;
    }

    @JsonProperty("celTableCell27")
    private celTableCell27AttplShinchoKujokyo getCelTableCell27() {
        return celTableCell27;
    }

    @JsonProperty("celTableCell27")
    private void setCelTableCell27(celTableCell27AttplShinchoKujokyo celTableCell27) {
        this.celTableCell27=celTableCell27;
    }

    @JsonProperty("celTableCell28")
    private celTableCell28AttplShinchoKujokyo getCelTableCell28() {
        return celTableCell28;
    }

    @JsonProperty("celTableCell28")
    private void setCelTableCell28(celTableCell28AttplShinchoKujokyo celTableCell28) {
        this.celTableCell28=celTableCell28;
    }

    @JsonProperty("celTableCell29")
    private celTableCell29AttplShinchoKujokyo getCelTableCell29() {
        return celTableCell29;
    }

    @JsonProperty("celTableCell29")
    private void setCelTableCell29(celTableCell29AttplShinchoKujokyo celTableCell29) {
        this.celTableCell29=celTableCell29;
    }

    @JsonProperty("celTableCell30")
    private celTableCell30AttplShinchoKujokyo getCelTableCell30() {
        return celTableCell30;
    }

    @JsonProperty("celTableCell30")
    private void setCelTableCell30(celTableCell30AttplShinchoKujokyo celTableCell30) {
        this.celTableCell30=celTableCell30;
    }

}
/**
 * celTableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell1AttplShinchoKujokyo extends TableCell {

}
/**
 * celTableCell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell2AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblShinseiToroku")
    private Label lblShinseiToroku;

    @JsonProperty("lblShinseiToroku")
    public Label getLblShinseiToroku() {
        return lblShinseiToroku;
    }

    @JsonProperty("lblShinseiToroku")
    public void setLblShinseiToroku(Label lblShinseiToroku) {
        this.lblShinseiToroku=lblShinseiToroku;
    }

}
/**
 * celTableCell3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell3AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblNinteiChosaIrai")
    private Label lblNinteiChosaIrai;

    @JsonProperty("lblNinteiChosaIrai")
    public Label getLblNinteiChosaIrai() {
        return lblNinteiChosaIrai;
    }

    @JsonProperty("lblNinteiChosaIrai")
    public void setLblNinteiChosaIrai(Label lblNinteiChosaIrai) {
        this.lblNinteiChosaIrai=lblNinteiChosaIrai;
    }

}
/**
 * celTableCell7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell7AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblNinteiChosaJisshi")
    private Label lblNinteiChosaJisshi;

    @JsonProperty("lblNinteiChosaJisshi")
    public Label getLblNinteiChosaJisshi() {
        return lblNinteiChosaJisshi;
    }

    @JsonProperty("lblNinteiChosaJisshi")
    public void setLblNinteiChosaJisshi(Label lblNinteiChosaJisshi) {
        this.lblNinteiChosaJisshi=lblNinteiChosaJisshi;
    }

}
/**
 * celTableCell8 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell8AttplShinchoKujokyo extends TableCell {
    @JsonProperty("ShujiIkenshoSakuseiIrai")
    private Label ShujiIkenshoSakuseiIrai;

    @JsonProperty("ShujiIkenshoSakuseiIrai")
    public Label getShujiIkenshoSakuseiIrai() {
        return ShujiIkenshoSakuseiIrai;
    }

    @JsonProperty("ShujiIkenshoSakuseiIrai")
    public void setShujiIkenshoSakuseiIrai(Label ShujiIkenshoSakuseiIrai) {
        this.ShujiIkenshoSakuseiIrai=ShujiIkenshoSakuseiIrai;
    }

}
/**
 * celTableCell9 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell9AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblShujiiIkenshoToroku")
    private Label lblShujiiIkenshoToroku;

    @JsonProperty("lblShujiiIkenshoToroku")
    public Label getLblShujiiIkenshoToroku() {
        return lblShujiiIkenshoToroku;
    }

    @JsonProperty("lblShujiiIkenshoToroku")
    public void setLblShujiiIkenshoToroku(Label lblShujiiIkenshoToroku) {
        this.lblShujiiIkenshoToroku=lblShujiiIkenshoToroku;
    }

}
/**
 * celTableCell10 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell10AttplShinchoKujokyo extends TableCell {
    @JsonProperty("IblIchijiHantei")
    private Label IblIchijiHantei;

    @JsonProperty("IblIchijiHantei")
    public Label getIblIchijiHantei() {
        return IblIchijiHantei;
    }

    @JsonProperty("IblIchijiHantei")
    public void setIblIchijiHantei(Label IblIchijiHantei) {
        this.IblIchijiHantei=IblIchijiHantei;
    }

}
/**
 * celTableCell11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell11AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblMasking")
    private Label lblMasking;

    @JsonProperty("lblMasking")
    public Label getLblMasking() {
        return lblMasking;
    }

    @JsonProperty("lblMasking")
    public void setLblMasking(Label lblMasking) {
        this.lblMasking=lblMasking;
    }

}
/**
 * celTableCell12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell12AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblKaigoNinteiShinsakaiWaritsuke")
    private Label lblKaigoNinteiShinsakaiWaritsuke;

    @JsonProperty("lblKaigoNinteiShinsakaiWaritsuke")
    public Label getLblKaigoNinteiShinsakaiWaritsuke() {
        return lblKaigoNinteiShinsakaiWaritsuke;
    }

    @JsonProperty("lblKaigoNinteiShinsakaiWaritsuke")
    public void setLblKaigoNinteiShinsakaiWaritsuke(Label lblKaigoNinteiShinsakaiWaritsuke) {
        this.lblKaigoNinteiShinsakaiWaritsuke=lblKaigoNinteiShinsakaiWaritsuke;
    }

}
/**
 * celTableCell13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell13AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblKaigoNinteiShinsakaiJissi")
    private Label lblKaigoNinteiShinsakaiJissi;

    @JsonProperty("lblKaigoNinteiShinsakaiJissi")
    public Label getLblKaigoNinteiShinsakaiJissi() {
        return lblKaigoNinteiShinsakaiJissi;
    }

    @JsonProperty("lblKaigoNinteiShinsakaiJissi")
    public void setLblKaigoNinteiShinsakaiJissi(Label lblKaigoNinteiShinsakaiJissi) {
        this.lblKaigoNinteiShinsakaiJissi=lblKaigoNinteiShinsakaiJissi;
    }

}
/**
 * celTableCell4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell4AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblYoteiDay")
    private Label lblYoteiDay;

    @JsonProperty("lblYoteiDay")
    public Label getLblYoteiDay() {
        return lblYoteiDay;
    }

    @JsonProperty("lblYoteiDay")
    public void setLblYoteiDay(Label lblYoteiDay) {
        this.lblYoteiDay=lblYoteiDay;
    }

}
/**
 * celTableCell5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell5AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtShinseiTorokuYoteiDay")
    private TextBoxDate txtShinseiTorokuYoteiDay;

    @JsonProperty("txtShinseiTorokuYoteiDay")
    public TextBoxDate getTxtShinseiTorokuYoteiDay() {
        return txtShinseiTorokuYoteiDay;
    }

    @JsonProperty("txtShinseiTorokuYoteiDay")
    public void setTxtShinseiTorokuYoteiDay(TextBoxDate txtShinseiTorokuYoteiDay) {
        this.txtShinseiTorokuYoteiDay=txtShinseiTorokuYoteiDay;
    }

}
/**
 * celTableCell6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell6AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtNinteiChosaIraiYoteiDay")
    private TextBoxDate txtNinteiChosaIraiYoteiDay;

    @JsonProperty("txtNinteiChosaIraiYoteiDay")
    public TextBoxDate getTxtNinteiChosaIraiYoteiDay() {
        return txtNinteiChosaIraiYoteiDay;
    }

    @JsonProperty("txtNinteiChosaIraiYoteiDay")
    public void setTxtNinteiChosaIraiYoteiDay(TextBoxDate txtNinteiChosaIraiYoteiDay) {
        this.txtNinteiChosaIraiYoteiDay=txtNinteiChosaIraiYoteiDay;
    }

}
/**
 * celTableCell14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell14AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtNinteiChosaJisshiYoteiDay")
    private TextBoxDate txtNinteiChosaJisshiYoteiDay;

    @JsonProperty("txtNinteiChosaJisshiYoteiDay")
    public TextBoxDate getTxtNinteiChosaJisshiYoteiDay() {
        return txtNinteiChosaJisshiYoteiDay;
    }

    @JsonProperty("txtNinteiChosaJisshiYoteiDay")
    public void setTxtNinteiChosaJisshiYoteiDay(TextBoxDate txtNinteiChosaJisshiYoteiDay) {
        this.txtNinteiChosaJisshiYoteiDay=txtNinteiChosaJisshiYoteiDay;
    }

}
/**
 * celTableCell15 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell15AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtShujiIkenshoSakuseiIraiYoteiDay")
    private TextBoxDate txtShujiIkenshoSakuseiIraiYoteiDay;

    @JsonProperty("txtShujiIkenshoSakuseiIraiYoteiDay")
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiYoteiDay() {
        return txtShujiIkenshoSakuseiIraiYoteiDay;
    }

    @JsonProperty("txtShujiIkenshoSakuseiIraiYoteiDay")
    public void setTxtShujiIkenshoSakuseiIraiYoteiDay(TextBoxDate txtShujiIkenshoSakuseiIraiYoteiDay) {
        this.txtShujiIkenshoSakuseiIraiYoteiDay=txtShujiIkenshoSakuseiIraiYoteiDay;
    }

}
/**
 * celTableCell16 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell16AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtShujiiIkenshoTorokuYoteiDay")
    private TextBoxDate txtShujiiIkenshoTorokuYoteiDay;

    @JsonProperty("txtShujiiIkenshoTorokuYoteiDay")
    public TextBoxDate getTxtShujiiIkenshoTorokuYoteiDay() {
        return txtShujiiIkenshoTorokuYoteiDay;
    }

    @JsonProperty("txtShujiiIkenshoTorokuYoteiDay")
    public void setTxtShujiiIkenshoTorokuYoteiDay(TextBoxDate txtShujiiIkenshoTorokuYoteiDay) {
        this.txtShujiiIkenshoTorokuYoteiDay=txtShujiiIkenshoTorokuYoteiDay;
    }

}
/**
 * celTableCell17 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell17AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtIchijiHanteiYoteiDay")
    private TextBoxDate txtIchijiHanteiYoteiDay;

    @JsonProperty("txtIchijiHanteiYoteiDay")
    public TextBoxDate getTxtIchijiHanteiYoteiDay() {
        return txtIchijiHanteiYoteiDay;
    }

    @JsonProperty("txtIchijiHanteiYoteiDay")
    public void setTxtIchijiHanteiYoteiDay(TextBoxDate txtIchijiHanteiYoteiDay) {
        this.txtIchijiHanteiYoteiDay=txtIchijiHanteiYoteiDay;
    }

}
/**
 * celTableCell18 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell18AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtMaskingYoteiDay")
    private TextBoxDate txtMaskingYoteiDay;

    @JsonProperty("txtMaskingYoteiDay")
    public TextBoxDate getTxtMaskingYoteiDay() {
        return txtMaskingYoteiDay;
    }

    @JsonProperty("txtMaskingYoteiDay")
    public void setTxtMaskingYoteiDay(TextBoxDate txtMaskingYoteiDay) {
        this.txtMaskingYoteiDay=txtMaskingYoteiDay;
    }

}
/**
 * celTableCell19 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell19AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtKaigoNinteiShinsakaiWaritsukeYoteiDay")
    private TextBoxDate txtKaigoNinteiShinsakaiWaritsukeYoteiDay;

    @JsonProperty("txtKaigoNinteiShinsakaiWaritsukeYoteiDay")
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeYoteiDay() {
        return txtKaigoNinteiShinsakaiWaritsukeYoteiDay;
    }

    @JsonProperty("txtKaigoNinteiShinsakaiWaritsukeYoteiDay")
    public void setTxtKaigoNinteiShinsakaiWaritsukeYoteiDay(TextBoxDate txtKaigoNinteiShinsakaiWaritsukeYoteiDay) {
        this.txtKaigoNinteiShinsakaiWaritsukeYoteiDay=txtKaigoNinteiShinsakaiWaritsukeYoteiDay;
    }

}
/**
 * celTableCell20 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell20AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtKaigoNinteiShinsakaiJissiYoteiDay")
    private TextBoxDate txtKaigoNinteiShinsakaiJissiYoteiDay;

    @JsonProperty("txtKaigoNinteiShinsakaiJissiYoteiDay")
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiYoteiDay() {
        return txtKaigoNinteiShinsakaiJissiYoteiDay;
    }

    @JsonProperty("txtKaigoNinteiShinsakaiJissiYoteiDay")
    public void setTxtKaigoNinteiShinsakaiJissiYoteiDay(TextBoxDate txtKaigoNinteiShinsakaiJissiYoteiDay) {
        this.txtKaigoNinteiShinsakaiJissiYoteiDay=txtKaigoNinteiShinsakaiJissiYoteiDay;
    }

}
/**
 * celTableCell21 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell21AttplShinchoKujokyo extends TableCell {
    @JsonProperty("lblKanryoDay")
    private Label lblKanryoDay;

    @JsonProperty("lblKanryoDay")
    public Label getLblKanryoDay() {
        return lblKanryoDay;
    }

    @JsonProperty("lblKanryoDay")
    public void setLblKanryoDay(Label lblKanryoDay) {
        this.lblKanryoDay=lblKanryoDay;
    }

}
/**
 * celTableCell22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell22AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtShinseiTorokuKanryoDay")
    private TextBoxDate txtShinseiTorokuKanryoDay;

    @JsonProperty("txtShinseiTorokuKanryoDay")
    public TextBoxDate getTxtShinseiTorokuKanryoDay() {
        return txtShinseiTorokuKanryoDay;
    }

    @JsonProperty("txtShinseiTorokuKanryoDay")
    public void setTxtShinseiTorokuKanryoDay(TextBoxDate txtShinseiTorokuKanryoDay) {
        this.txtShinseiTorokuKanryoDay=txtShinseiTorokuKanryoDay;
    }

}
/**
 * celTableCell23 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell23AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtNinteiChosaIraiKanryoDay")
    private TextBoxDate txtNinteiChosaIraiKanryoDay;

    @JsonProperty("txtNinteiChosaIraiKanryoDay")
    public TextBoxDate getTxtNinteiChosaIraiKanryoDay() {
        return txtNinteiChosaIraiKanryoDay;
    }

    @JsonProperty("txtNinteiChosaIraiKanryoDay")
    public void setTxtNinteiChosaIraiKanryoDay(TextBoxDate txtNinteiChosaIraiKanryoDay) {
        this.txtNinteiChosaIraiKanryoDay=txtNinteiChosaIraiKanryoDay;
    }

}
/**
 * celTableCell24 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell24AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtNinteiChosaJisshiKanryoDay")
    private TextBoxDate txtNinteiChosaJisshiKanryoDay;

    @JsonProperty("txtNinteiChosaJisshiKanryoDay")
    public TextBoxDate getTxtNinteiChosaJisshiKanryoDay() {
        return txtNinteiChosaJisshiKanryoDay;
    }

    @JsonProperty("txtNinteiChosaJisshiKanryoDay")
    public void setTxtNinteiChosaJisshiKanryoDay(TextBoxDate txtNinteiChosaJisshiKanryoDay) {
        this.txtNinteiChosaJisshiKanryoDay=txtNinteiChosaJisshiKanryoDay;
    }

}
/**
 * celTableCell25 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell25AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtShujiIkenshoSakuseiIraiKanryoDay")
    private TextBoxDate txtShujiIkenshoSakuseiIraiKanryoDay;

    @JsonProperty("txtShujiIkenshoSakuseiIraiKanryoDay")
    public TextBoxDate getTxtShujiIkenshoSakuseiIraiKanryoDay() {
        return txtShujiIkenshoSakuseiIraiKanryoDay;
    }

    @JsonProperty("txtShujiIkenshoSakuseiIraiKanryoDay")
    public void setTxtShujiIkenshoSakuseiIraiKanryoDay(TextBoxDate txtShujiIkenshoSakuseiIraiKanryoDay) {
        this.txtShujiIkenshoSakuseiIraiKanryoDay=txtShujiIkenshoSakuseiIraiKanryoDay;
    }

}
/**
 * celTableCell26 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell26AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtShujiiIkenshoTorokuKanryoDay")
    private TextBoxDate txtShujiiIkenshoTorokuKanryoDay;

    @JsonProperty("txtShujiiIkenshoTorokuKanryoDay")
    public TextBoxDate getTxtShujiiIkenshoTorokuKanryoDay() {
        return txtShujiiIkenshoTorokuKanryoDay;
    }

    @JsonProperty("txtShujiiIkenshoTorokuKanryoDay")
    public void setTxtShujiiIkenshoTorokuKanryoDay(TextBoxDate txtShujiiIkenshoTorokuKanryoDay) {
        this.txtShujiiIkenshoTorokuKanryoDay=txtShujiiIkenshoTorokuKanryoDay;
    }

}
/**
 * celTableCell27 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell27AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtIchijiHanteiKanryoDay")
    private TextBoxDate txtIchijiHanteiKanryoDay;

    @JsonProperty("txtIchijiHanteiKanryoDay")
    public TextBoxDate getTxtIchijiHanteiKanryoDay() {
        return txtIchijiHanteiKanryoDay;
    }

    @JsonProperty("txtIchijiHanteiKanryoDay")
    public void setTxtIchijiHanteiKanryoDay(TextBoxDate txtIchijiHanteiKanryoDay) {
        this.txtIchijiHanteiKanryoDay=txtIchijiHanteiKanryoDay;
    }

}
/**
 * celTableCell28 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell28AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtMaskingKanryo")
    private TextBoxDate txtMaskingKanryo;

    @JsonProperty("txtMaskingKanryo")
    public TextBoxDate getTxtMaskingKanryo() {
        return txtMaskingKanryo;
    }

    @JsonProperty("txtMaskingKanryo")
    public void setTxtMaskingKanryo(TextBoxDate txtMaskingKanryo) {
        this.txtMaskingKanryo=txtMaskingKanryo;
    }

}
/**
 * celTableCell29 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell29AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtKaigoNinteiShinsakaiWaritsukeKanryoDay")
    private TextBoxDate txtKaigoNinteiShinsakaiWaritsukeKanryoDay;

    @JsonProperty("txtKaigoNinteiShinsakaiWaritsukeKanryoDay")
    public TextBoxDate getTxtKaigoNinteiShinsakaiWaritsukeKanryoDay() {
        return txtKaigoNinteiShinsakaiWaritsukeKanryoDay;
    }

    @JsonProperty("txtKaigoNinteiShinsakaiWaritsukeKanryoDay")
    public void setTxtKaigoNinteiShinsakaiWaritsukeKanryoDay(TextBoxDate txtKaigoNinteiShinsakaiWaritsukeKanryoDay) {
        this.txtKaigoNinteiShinsakaiWaritsukeKanryoDay=txtKaigoNinteiShinsakaiWaritsukeKanryoDay;
    }

}
/**
 * celTableCell30 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell30AttplShinchoKujokyo extends TableCell {
    @JsonProperty("txtKaigoNinteiShinsakaiJissiKanryoDay")
    private TextBoxDate txtKaigoNinteiShinsakaiJissiKanryoDay;

    @JsonProperty("txtKaigoNinteiShinsakaiJissiKanryoDay")
    public TextBoxDate getTxtKaigoNinteiShinsakaiJissiKanryoDay() {
        return txtKaigoNinteiShinsakaiJissiKanryoDay;
    }

    @JsonProperty("txtKaigoNinteiShinsakaiJissiKanryoDay")
    public void setTxtKaigoNinteiShinsakaiJissiKanryoDay(TextBoxDate txtKaigoNinteiShinsakaiJissiKanryoDay) {
        this.txtKaigoNinteiShinsakaiJissiKanryoDay=txtKaigoNinteiShinsakaiJissiKanryoDay;
    }

}

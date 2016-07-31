package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tblRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblRirekiDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celTableCell1")
    private celTableCell1AttblRireki celTableCell1;
    @JsonProperty("celTableCell2")
    private celTableCell2AttblRireki celTableCell2;
    @JsonProperty("celTableCell3")
    private celTableCell3AttblRireki celTableCell3;
    @JsonProperty("celTableCell10")
    private celTableCell10AttblRireki celTableCell10;
    @JsonProperty("celTableCell11")
    private celTableCell11AttblRireki celTableCell11;
    @JsonProperty("celTableCell12")
    private celTableCell12AttblRireki celTableCell12;
    @JsonProperty("celTableCell13")
    private celTableCell13AttblRireki celTableCell13;
    @JsonProperty("celTableCell14")
    private celTableCell14AttblRireki celTableCell14;
    @JsonProperty("celTableCell4")
    private celTableCell4AttblRireki celTableCell4;
    @JsonProperty("celTableCell5")
    private celTableCell5AttblRireki celTableCell5;
    @JsonProperty("celTableCell6")
    private celTableCell6AttblRireki celTableCell6;
    @JsonProperty("celTableCell15")
    private celTableCell15AttblRireki celTableCell15;
    @JsonProperty("celTableCell16")
    private celTableCell16AttblRireki celTableCell16;
    @JsonProperty("celTableCell17")
    private celTableCell17AttblRireki celTableCell17;
    @JsonProperty("celTableCell18")
    private celTableCell18AttblRireki celTableCell18;
    @JsonProperty("celTableCell19")
    private celTableCell19AttblRireki celTableCell19;
    @JsonProperty("celTableCell7")
    private celTableCell7AttblRireki celTableCell7;
    @JsonProperty("celTableCell8")
    private celTableCell8AttblRireki celTableCell8;
    @JsonProperty("celTableCell9")
    private celTableCell9AttblRireki celTableCell9;
    @JsonProperty("celTableCell20")
    private celTableCell20AttblRireki celTableCell20;
    @JsonProperty("celTableCell21")
    private celTableCell21AttblRireki celTableCell21;
    @JsonProperty("celTableCell22")
    private celTableCell22AttblRireki celTableCell22;
    @JsonProperty("celTableCell23")
    private celTableCell23AttblRireki celTableCell23;
    @JsonProperty("celTableCell24")
    private celTableCell24AttblRireki celTableCell24;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblYokaigodo() {
        return this.celTableCell3.getLblYokaigodo();
    }

    @JsonIgnore
    public Label getLblYukoKaishibi() {
        return this.celTableCell10.getLblYukoKaishibi();
    }

    @JsonIgnore
    public Label getLblYukoShuryobi() {
        return this.celTableCell11.getLblYukoShuryobi();
    }

    @JsonIgnore
    public Label getLblNinteibi() {
        return this.celTableCell12.getLblNinteibi();
    }

    @JsonIgnore
    public Label getLblServiceShurui() {
        return this.celTableCell13.getLblServiceShurui();
    }

    @JsonIgnore
    public Label getLblShinsakaiIken() {
        return this.celTableCell14.getLblShinsakaiIken();
    }

    @JsonIgnore
    public ButtonDialog getBtnZenkaiNinteichi() {
        return this.celTableCell4.getBtnZenkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunZenkai() {
        return this.celTableCell5.getTxtKubunZenkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoZenkai() {
        return this.celTableCell6.getTxtYokaigodoZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiZenkai() {
        return this.celTableCell15.getTxtYukoKaishibiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiZenkai() {
        return this.celTableCell16.getTxtYukoShuryobiZenkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiZenkai() {
        return this.celTableCell17.getTxtNinteibiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiZenkai() {
        return this.celTableCell18.getTxtServiceShuruiZenkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenZenkai() {
        return this.celTableCell19.getTxtShinsakaiIkenZenkai();
    }

    @JsonIgnore
    public ButtonDialog getBtnKonkaiNinteichi() {
        return this.celTableCell7.getBtnKonkaiNinteichi();
    }

    @JsonIgnore
    public TextBox getTxtKubunKonkai() {
        return this.celTableCell8.getTxtKubunKonkai();
    }

    @JsonIgnore
    public TextBox getTxtYokaigodoKonkai() {
        return this.celTableCell9.getTxtYokaigodoKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKaishibiKonkai() {
        return this.celTableCell20.getTxtYukoKaishibiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoShuryobiKonkai() {
        return this.celTableCell21.getTxtYukoShuryobiKonkai();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteibiKonkai() {
        return this.celTableCell22.getTxtNinteibiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtServiceShuruiKonkai() {
        return this.celTableCell23.getTxtServiceShuruiKonkai();
    }

    @JsonIgnore
    public TextBox getTxtShinsakaiIkenKonkai() {
        return this.celTableCell24.getTxtShinsakaiIkenKonkai();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcelTableCell1
     * @return celTableCell1
     */
    @JsonProperty("celTableCell1")
    private celTableCell1AttblRireki getCelTableCell1() {
        return celTableCell1;
    }

    /*
     * setcelTableCell1
     * @param celTableCell1 celTableCell1
     */
    @JsonProperty("celTableCell1")
    private void setCelTableCell1(celTableCell1AttblRireki celTableCell1) {
        this.celTableCell1 = celTableCell1;
    }

    /*
     * getcelTableCell2
     * @return celTableCell2
     */
    @JsonProperty("celTableCell2")
    private celTableCell2AttblRireki getCelTableCell2() {
        return celTableCell2;
    }

    /*
     * setcelTableCell2
     * @param celTableCell2 celTableCell2
     */
    @JsonProperty("celTableCell2")
    private void setCelTableCell2(celTableCell2AttblRireki celTableCell2) {
        this.celTableCell2 = celTableCell2;
    }

    /*
     * getcelTableCell3
     * @return celTableCell3
     */
    @JsonProperty("celTableCell3")
    private celTableCell3AttblRireki getCelTableCell3() {
        return celTableCell3;
    }

    /*
     * setcelTableCell3
     * @param celTableCell3 celTableCell3
     */
    @JsonProperty("celTableCell3")
    private void setCelTableCell3(celTableCell3AttblRireki celTableCell3) {
        this.celTableCell3 = celTableCell3;
    }

    /*
     * getcelTableCell10
     * @return celTableCell10
     */
    @JsonProperty("celTableCell10")
    private celTableCell10AttblRireki getCelTableCell10() {
        return celTableCell10;
    }

    /*
     * setcelTableCell10
     * @param celTableCell10 celTableCell10
     */
    @JsonProperty("celTableCell10")
    private void setCelTableCell10(celTableCell10AttblRireki celTableCell10) {
        this.celTableCell10 = celTableCell10;
    }

    /*
     * getcelTableCell11
     * @return celTableCell11
     */
    @JsonProperty("celTableCell11")
    private celTableCell11AttblRireki getCelTableCell11() {
        return celTableCell11;
    }

    /*
     * setcelTableCell11
     * @param celTableCell11 celTableCell11
     */
    @JsonProperty("celTableCell11")
    private void setCelTableCell11(celTableCell11AttblRireki celTableCell11) {
        this.celTableCell11 = celTableCell11;
    }

    /*
     * getcelTableCell12
     * @return celTableCell12
     */
    @JsonProperty("celTableCell12")
    private celTableCell12AttblRireki getCelTableCell12() {
        return celTableCell12;
    }

    /*
     * setcelTableCell12
     * @param celTableCell12 celTableCell12
     */
    @JsonProperty("celTableCell12")
    private void setCelTableCell12(celTableCell12AttblRireki celTableCell12) {
        this.celTableCell12 = celTableCell12;
    }

    /*
     * getcelTableCell13
     * @return celTableCell13
     */
    @JsonProperty("celTableCell13")
    private celTableCell13AttblRireki getCelTableCell13() {
        return celTableCell13;
    }

    /*
     * setcelTableCell13
     * @param celTableCell13 celTableCell13
     */
    @JsonProperty("celTableCell13")
    private void setCelTableCell13(celTableCell13AttblRireki celTableCell13) {
        this.celTableCell13 = celTableCell13;
    }

    /*
     * getcelTableCell14
     * @return celTableCell14
     */
    @JsonProperty("celTableCell14")
    private celTableCell14AttblRireki getCelTableCell14() {
        return celTableCell14;
    }

    /*
     * setcelTableCell14
     * @param celTableCell14 celTableCell14
     */
    @JsonProperty("celTableCell14")
    private void setCelTableCell14(celTableCell14AttblRireki celTableCell14) {
        this.celTableCell14 = celTableCell14;
    }

    /*
     * getcelTableCell4
     * @return celTableCell4
     */
    @JsonProperty("celTableCell4")
    private celTableCell4AttblRireki getCelTableCell4() {
        return celTableCell4;
    }

    /*
     * setcelTableCell4
     * @param celTableCell4 celTableCell4
     */
    @JsonProperty("celTableCell4")
    private void setCelTableCell4(celTableCell4AttblRireki celTableCell4) {
        this.celTableCell4 = celTableCell4;
    }

    /*
     * getcelTableCell5
     * @return celTableCell5
     */
    @JsonProperty("celTableCell5")
    private celTableCell5AttblRireki getCelTableCell5() {
        return celTableCell5;
    }

    /*
     * setcelTableCell5
     * @param celTableCell5 celTableCell5
     */
    @JsonProperty("celTableCell5")
    private void setCelTableCell5(celTableCell5AttblRireki celTableCell5) {
        this.celTableCell5 = celTableCell5;
    }

    /*
     * getcelTableCell6
     * @return celTableCell6
     */
    @JsonProperty("celTableCell6")
    private celTableCell6AttblRireki getCelTableCell6() {
        return celTableCell6;
    }

    /*
     * setcelTableCell6
     * @param celTableCell6 celTableCell6
     */
    @JsonProperty("celTableCell6")
    private void setCelTableCell6(celTableCell6AttblRireki celTableCell6) {
        this.celTableCell6 = celTableCell6;
    }

    /*
     * getcelTableCell15
     * @return celTableCell15
     */
    @JsonProperty("celTableCell15")
    private celTableCell15AttblRireki getCelTableCell15() {
        return celTableCell15;
    }

    /*
     * setcelTableCell15
     * @param celTableCell15 celTableCell15
     */
    @JsonProperty("celTableCell15")
    private void setCelTableCell15(celTableCell15AttblRireki celTableCell15) {
        this.celTableCell15 = celTableCell15;
    }

    /*
     * getcelTableCell16
     * @return celTableCell16
     */
    @JsonProperty("celTableCell16")
    private celTableCell16AttblRireki getCelTableCell16() {
        return celTableCell16;
    }

    /*
     * setcelTableCell16
     * @param celTableCell16 celTableCell16
     */
    @JsonProperty("celTableCell16")
    private void setCelTableCell16(celTableCell16AttblRireki celTableCell16) {
        this.celTableCell16 = celTableCell16;
    }

    /*
     * getcelTableCell17
     * @return celTableCell17
     */
    @JsonProperty("celTableCell17")
    private celTableCell17AttblRireki getCelTableCell17() {
        return celTableCell17;
    }

    /*
     * setcelTableCell17
     * @param celTableCell17 celTableCell17
     */
    @JsonProperty("celTableCell17")
    private void setCelTableCell17(celTableCell17AttblRireki celTableCell17) {
        this.celTableCell17 = celTableCell17;
    }

    /*
     * getcelTableCell18
     * @return celTableCell18
     */
    @JsonProperty("celTableCell18")
    private celTableCell18AttblRireki getCelTableCell18() {
        return celTableCell18;
    }

    /*
     * setcelTableCell18
     * @param celTableCell18 celTableCell18
     */
    @JsonProperty("celTableCell18")
    private void setCelTableCell18(celTableCell18AttblRireki celTableCell18) {
        this.celTableCell18 = celTableCell18;
    }

    /*
     * getcelTableCell19
     * @return celTableCell19
     */
    @JsonProperty("celTableCell19")
    private celTableCell19AttblRireki getCelTableCell19() {
        return celTableCell19;
    }

    /*
     * setcelTableCell19
     * @param celTableCell19 celTableCell19
     */
    @JsonProperty("celTableCell19")
    private void setCelTableCell19(celTableCell19AttblRireki celTableCell19) {
        this.celTableCell19 = celTableCell19;
    }

    /*
     * getcelTableCell7
     * @return celTableCell7
     */
    @JsonProperty("celTableCell7")
    private celTableCell7AttblRireki getCelTableCell7() {
        return celTableCell7;
    }

    /*
     * setcelTableCell7
     * @param celTableCell7 celTableCell7
     */
    @JsonProperty("celTableCell7")
    private void setCelTableCell7(celTableCell7AttblRireki celTableCell7) {
        this.celTableCell7 = celTableCell7;
    }

    /*
     * getcelTableCell8
     * @return celTableCell8
     */
    @JsonProperty("celTableCell8")
    private celTableCell8AttblRireki getCelTableCell8() {
        return celTableCell8;
    }

    /*
     * setcelTableCell8
     * @param celTableCell8 celTableCell8
     */
    @JsonProperty("celTableCell8")
    private void setCelTableCell8(celTableCell8AttblRireki celTableCell8) {
        this.celTableCell8 = celTableCell8;
    }

    /*
     * getcelTableCell9
     * @return celTableCell9
     */
    @JsonProperty("celTableCell9")
    private celTableCell9AttblRireki getCelTableCell9() {
        return celTableCell9;
    }

    /*
     * setcelTableCell9
     * @param celTableCell9 celTableCell9
     */
    @JsonProperty("celTableCell9")
    private void setCelTableCell9(celTableCell9AttblRireki celTableCell9) {
        this.celTableCell9 = celTableCell9;
    }

    /*
     * getcelTableCell20
     * @return celTableCell20
     */
    @JsonProperty("celTableCell20")
    private celTableCell20AttblRireki getCelTableCell20() {
        return celTableCell20;
    }

    /*
     * setcelTableCell20
     * @param celTableCell20 celTableCell20
     */
    @JsonProperty("celTableCell20")
    private void setCelTableCell20(celTableCell20AttblRireki celTableCell20) {
        this.celTableCell20 = celTableCell20;
    }

    /*
     * getcelTableCell21
     * @return celTableCell21
     */
    @JsonProperty("celTableCell21")
    private celTableCell21AttblRireki getCelTableCell21() {
        return celTableCell21;
    }

    /*
     * setcelTableCell21
     * @param celTableCell21 celTableCell21
     */
    @JsonProperty("celTableCell21")
    private void setCelTableCell21(celTableCell21AttblRireki celTableCell21) {
        this.celTableCell21 = celTableCell21;
    }

    /*
     * getcelTableCell22
     * @return celTableCell22
     */
    @JsonProperty("celTableCell22")
    private celTableCell22AttblRireki getCelTableCell22() {
        return celTableCell22;
    }

    /*
     * setcelTableCell22
     * @param celTableCell22 celTableCell22
     */
    @JsonProperty("celTableCell22")
    private void setCelTableCell22(celTableCell22AttblRireki celTableCell22) {
        this.celTableCell22 = celTableCell22;
    }

    /*
     * getcelTableCell23
     * @return celTableCell23
     */
    @JsonProperty("celTableCell23")
    private celTableCell23AttblRireki getCelTableCell23() {
        return celTableCell23;
    }

    /*
     * setcelTableCell23
     * @param celTableCell23 celTableCell23
     */
    @JsonProperty("celTableCell23")
    private void setCelTableCell23(celTableCell23AttblRireki celTableCell23) {
        this.celTableCell23 = celTableCell23;
    }

    /*
     * getcelTableCell24
     * @return celTableCell24
     */
    @JsonProperty("celTableCell24")
    private celTableCell24AttblRireki getCelTableCell24() {
        return celTableCell24;
    }

    /*
     * setcelTableCell24
     * @param celTableCell24 celTableCell24
     */
    @JsonProperty("celTableCell24")
    private void setCelTableCell24(celTableCell24AttblRireki celTableCell24) {
        this.celTableCell24 = celTableCell24;
    }

    // </editor-fold>
}
/**
 * celTableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell1AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    // </editor-fold>
}
/**
 * celTableCell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell2AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">

    // </editor-fold>
}
/**
 * celTableCell3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell3AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblYokaigodo")
    private Label lblYokaigodo;

    /*
     * getlblYokaigodo
     * @return lblYokaigodo
     */
    @JsonProperty("lblYokaigodo")
    public Label getLblYokaigodo() {
        return lblYokaigodo;
    }

    /*
     * setlblYokaigodo
     * @param lblYokaigodo lblYokaigodo
     */
    @JsonProperty("lblYokaigodo")
    public void setLblYokaigodo(Label lblYokaigodo) {
        this.lblYokaigodo = lblYokaigodo;
    }

    // </editor-fold>
}
/**
 * celTableCell10 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell10AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblYukoKaishibi")
    private Label lblYukoKaishibi;

    /*
     * getlblYukoKaishibi
     * @return lblYukoKaishibi
     */
    @JsonProperty("lblYukoKaishibi")
    public Label getLblYukoKaishibi() {
        return lblYukoKaishibi;
    }

    /*
     * setlblYukoKaishibi
     * @param lblYukoKaishibi lblYukoKaishibi
     */
    @JsonProperty("lblYukoKaishibi")
    public void setLblYukoKaishibi(Label lblYukoKaishibi) {
        this.lblYukoKaishibi = lblYukoKaishibi;
    }

    // </editor-fold>
}
/**
 * celTableCell11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell11AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblYukoShuryobi")
    private Label lblYukoShuryobi;

    /*
     * getlblYukoShuryobi
     * @return lblYukoShuryobi
     */
    @JsonProperty("lblYukoShuryobi")
    public Label getLblYukoShuryobi() {
        return lblYukoShuryobi;
    }

    /*
     * setlblYukoShuryobi
     * @param lblYukoShuryobi lblYukoShuryobi
     */
    @JsonProperty("lblYukoShuryobi")
    public void setLblYukoShuryobi(Label lblYukoShuryobi) {
        this.lblYukoShuryobi = lblYukoShuryobi;
    }

    // </editor-fold>
}
/**
 * celTableCell12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell12AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblNinteibi")
    private Label lblNinteibi;

    /*
     * getlblNinteibi
     * @return lblNinteibi
     */
    @JsonProperty("lblNinteibi")
    public Label getLblNinteibi() {
        return lblNinteibi;
    }

    /*
     * setlblNinteibi
     * @param lblNinteibi lblNinteibi
     */
    @JsonProperty("lblNinteibi")
    public void setLblNinteibi(Label lblNinteibi) {
        this.lblNinteibi = lblNinteibi;
    }

    // </editor-fold>
}
/**
 * celTableCell13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell13AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblServiceShurui")
    private Label lblServiceShurui;

    /*
     * getlblServiceShurui
     * @return lblServiceShurui
     */
    @JsonProperty("lblServiceShurui")
    public Label getLblServiceShurui() {
        return lblServiceShurui;
    }

    /*
     * setlblServiceShurui
     * @param lblServiceShurui lblServiceShurui
     */
    @JsonProperty("lblServiceShurui")
    public void setLblServiceShurui(Label lblServiceShurui) {
        this.lblServiceShurui = lblServiceShurui;
    }

    // </editor-fold>
}
/**
 * celTableCell14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell14AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("lblShinsakaiIken")
    private Label lblShinsakaiIken;

    /*
     * getlblShinsakaiIken
     * @return lblShinsakaiIken
     */
    @JsonProperty("lblShinsakaiIken")
    public Label getLblShinsakaiIken() {
        return lblShinsakaiIken;
    }

    /*
     * setlblShinsakaiIken
     * @param lblShinsakaiIken lblShinsakaiIken
     */
    @JsonProperty("lblShinsakaiIken")
    public void setLblShinsakaiIken(Label lblShinsakaiIken) {
        this.lblShinsakaiIken = lblShinsakaiIken;
    }

    // </editor-fold>
}
/**
 * celTableCell4 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell4AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("btnZenkaiNinteichi")
    private ButtonDialog btnZenkaiNinteichi;

    /*
     * getbtnZenkaiNinteichi
     * @return btnZenkaiNinteichi
     */
    @JsonProperty("btnZenkaiNinteichi")
    public ButtonDialog getBtnZenkaiNinteichi() {
        return btnZenkaiNinteichi;
    }

    /*
     * setbtnZenkaiNinteichi
     * @param btnZenkaiNinteichi btnZenkaiNinteichi
     */
    @JsonProperty("btnZenkaiNinteichi")
    public void setBtnZenkaiNinteichi(ButtonDialog btnZenkaiNinteichi) {
        this.btnZenkaiNinteichi = btnZenkaiNinteichi;
    }

    // </editor-fold>
}
/**
 * celTableCell5 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell5AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtKubunZenkai")
    private TextBox txtKubunZenkai;

    /*
     * gettxtKubunZenkai
     * @return txtKubunZenkai
     */
    @JsonProperty("txtKubunZenkai")
    public TextBox getTxtKubunZenkai() {
        return txtKubunZenkai;
    }

    /*
     * settxtKubunZenkai
     * @param txtKubunZenkai txtKubunZenkai
     */
    @JsonProperty("txtKubunZenkai")
    public void setTxtKubunZenkai(TextBox txtKubunZenkai) {
        this.txtKubunZenkai = txtKubunZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell6 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell6AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtYokaigodoZenkai")
    private TextBox txtYokaigodoZenkai;

    /*
     * gettxtYokaigodoZenkai
     * @return txtYokaigodoZenkai
     */
    @JsonProperty("txtYokaigodoZenkai")
    public TextBox getTxtYokaigodoZenkai() {
        return txtYokaigodoZenkai;
    }

    /*
     * settxtYokaigodoZenkai
     * @param txtYokaigodoZenkai txtYokaigodoZenkai
     */
    @JsonProperty("txtYokaigodoZenkai")
    public void setTxtYokaigodoZenkai(TextBox txtYokaigodoZenkai) {
        this.txtYokaigodoZenkai = txtYokaigodoZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell15 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell15AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtYukoKaishibiZenkai")
    private TextBoxFlexibleDate txtYukoKaishibiZenkai;

    /*
     * gettxtYukoKaishibiZenkai
     * @return txtYukoKaishibiZenkai
     */
    @JsonProperty("txtYukoKaishibiZenkai")
    public TextBoxFlexibleDate getTxtYukoKaishibiZenkai() {
        return txtYukoKaishibiZenkai;
    }

    /*
     * settxtYukoKaishibiZenkai
     * @param txtYukoKaishibiZenkai txtYukoKaishibiZenkai
     */
    @JsonProperty("txtYukoKaishibiZenkai")
    public void setTxtYukoKaishibiZenkai(TextBoxFlexibleDate txtYukoKaishibiZenkai) {
        this.txtYukoKaishibiZenkai = txtYukoKaishibiZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell16 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell16AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtYukoShuryobiZenkai")
    private TextBoxFlexibleDate txtYukoShuryobiZenkai;

    /*
     * gettxtYukoShuryobiZenkai
     * @return txtYukoShuryobiZenkai
     */
    @JsonProperty("txtYukoShuryobiZenkai")
    public TextBoxFlexibleDate getTxtYukoShuryobiZenkai() {
        return txtYukoShuryobiZenkai;
    }

    /*
     * settxtYukoShuryobiZenkai
     * @param txtYukoShuryobiZenkai txtYukoShuryobiZenkai
     */
    @JsonProperty("txtYukoShuryobiZenkai")
    public void setTxtYukoShuryobiZenkai(TextBoxFlexibleDate txtYukoShuryobiZenkai) {
        this.txtYukoShuryobiZenkai = txtYukoShuryobiZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell17 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell17AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtNinteibiZenkai")
    private TextBoxFlexibleDate txtNinteibiZenkai;

    /*
     * gettxtNinteibiZenkai
     * @return txtNinteibiZenkai
     */
    @JsonProperty("txtNinteibiZenkai")
    public TextBoxFlexibleDate getTxtNinteibiZenkai() {
        return txtNinteibiZenkai;
    }

    /*
     * settxtNinteibiZenkai
     * @param txtNinteibiZenkai txtNinteibiZenkai
     */
    @JsonProperty("txtNinteibiZenkai")
    public void setTxtNinteibiZenkai(TextBoxFlexibleDate txtNinteibiZenkai) {
        this.txtNinteibiZenkai = txtNinteibiZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell18 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell18AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtServiceShuruiZenkai")
    private TextBox txtServiceShuruiZenkai;

    /*
     * gettxtServiceShuruiZenkai
     * @return txtServiceShuruiZenkai
     */
    @JsonProperty("txtServiceShuruiZenkai")
    public TextBox getTxtServiceShuruiZenkai() {
        return txtServiceShuruiZenkai;
    }

    /*
     * settxtServiceShuruiZenkai
     * @param txtServiceShuruiZenkai txtServiceShuruiZenkai
     */
    @JsonProperty("txtServiceShuruiZenkai")
    public void setTxtServiceShuruiZenkai(TextBox txtServiceShuruiZenkai) {
        this.txtServiceShuruiZenkai = txtServiceShuruiZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell19 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell19AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtShinsakaiIkenZenkai")
    private TextBox txtShinsakaiIkenZenkai;

    /*
     * gettxtShinsakaiIkenZenkai
     * @return txtShinsakaiIkenZenkai
     */
    @JsonProperty("txtShinsakaiIkenZenkai")
    public TextBox getTxtShinsakaiIkenZenkai() {
        return txtShinsakaiIkenZenkai;
    }

    /*
     * settxtShinsakaiIkenZenkai
     * @param txtShinsakaiIkenZenkai txtShinsakaiIkenZenkai
     */
    @JsonProperty("txtShinsakaiIkenZenkai")
    public void setTxtShinsakaiIkenZenkai(TextBox txtShinsakaiIkenZenkai) {
        this.txtShinsakaiIkenZenkai = txtShinsakaiIkenZenkai;
    }

    // </editor-fold>
}
/**
 * celTableCell7 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell7AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("btnKonkaiNinteichi")
    private ButtonDialog btnKonkaiNinteichi;

    /*
     * getbtnKonkaiNinteichi
     * @return btnKonkaiNinteichi
     */
    @JsonProperty("btnKonkaiNinteichi")
    public ButtonDialog getBtnKonkaiNinteichi() {
        return btnKonkaiNinteichi;
    }

    /*
     * setbtnKonkaiNinteichi
     * @param btnKonkaiNinteichi btnKonkaiNinteichi
     */
    @JsonProperty("btnKonkaiNinteichi")
    public void setBtnKonkaiNinteichi(ButtonDialog btnKonkaiNinteichi) {
        this.btnKonkaiNinteichi = btnKonkaiNinteichi;
    }

    // </editor-fold>
}
/**
 * celTableCell8 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell8AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtKubunKonkai")
    private TextBox txtKubunKonkai;

    /*
     * gettxtKubunKonkai
     * @return txtKubunKonkai
     */
    @JsonProperty("txtKubunKonkai")
    public TextBox getTxtKubunKonkai() {
        return txtKubunKonkai;
    }

    /*
     * settxtKubunKonkai
     * @param txtKubunKonkai txtKubunKonkai
     */
    @JsonProperty("txtKubunKonkai")
    public void setTxtKubunKonkai(TextBox txtKubunKonkai) {
        this.txtKubunKonkai = txtKubunKonkai;
    }

    // </editor-fold>
}
/**
 * celTableCell9 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell9AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtYokaigodoKonkai")
    private TextBox txtYokaigodoKonkai;

    /*
     * gettxtYokaigodoKonkai
     * @return txtYokaigodoKonkai
     */
    @JsonProperty("txtYokaigodoKonkai")
    public TextBox getTxtYokaigodoKonkai() {
        return txtYokaigodoKonkai;
    }

    /*
     * settxtYokaigodoKonkai
     * @param txtYokaigodoKonkai txtYokaigodoKonkai
     */
    @JsonProperty("txtYokaigodoKonkai")
    public void setTxtYokaigodoKonkai(TextBox txtYokaigodoKonkai) {
        this.txtYokaigodoKonkai = txtYokaigodoKonkai;
    }

    // </editor-fold>
}
/**
 * celTableCell20 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell20AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtYukoKaishibiKonkai")
    private TextBoxFlexibleDate txtYukoKaishibiKonkai;

    /*
     * gettxtYukoKaishibiKonkai
     * @return txtYukoKaishibiKonkai
     */
    @JsonProperty("txtYukoKaishibiKonkai")
    public TextBoxFlexibleDate getTxtYukoKaishibiKonkai() {
        return txtYukoKaishibiKonkai;
    }

    /*
     * settxtYukoKaishibiKonkai
     * @param txtYukoKaishibiKonkai txtYukoKaishibiKonkai
     */
    @JsonProperty("txtYukoKaishibiKonkai")
    public void setTxtYukoKaishibiKonkai(TextBoxFlexibleDate txtYukoKaishibiKonkai) {
        this.txtYukoKaishibiKonkai = txtYukoKaishibiKonkai;
    }

    // </editor-fold>
}
/**
 * celTableCell21 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell21AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtYukoShuryobiKonkai")
    private TextBoxFlexibleDate txtYukoShuryobiKonkai;

    /*
     * gettxtYukoShuryobiKonkai
     * @return txtYukoShuryobiKonkai
     */
    @JsonProperty("txtYukoShuryobiKonkai")
    public TextBoxFlexibleDate getTxtYukoShuryobiKonkai() {
        return txtYukoShuryobiKonkai;
    }

    /*
     * settxtYukoShuryobiKonkai
     * @param txtYukoShuryobiKonkai txtYukoShuryobiKonkai
     */
    @JsonProperty("txtYukoShuryobiKonkai")
    public void setTxtYukoShuryobiKonkai(TextBoxFlexibleDate txtYukoShuryobiKonkai) {
        this.txtYukoShuryobiKonkai = txtYukoShuryobiKonkai;
    }

    // </editor-fold>
}
/**
 * celTableCell22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell22AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtNinteibiKonkai")
    private TextBoxFlexibleDate txtNinteibiKonkai;

    /*
     * gettxtNinteibiKonkai
     * @return txtNinteibiKonkai
     */
    @JsonProperty("txtNinteibiKonkai")
    public TextBoxFlexibleDate getTxtNinteibiKonkai() {
        return txtNinteibiKonkai;
    }

    /*
     * settxtNinteibiKonkai
     * @param txtNinteibiKonkai txtNinteibiKonkai
     */
    @JsonProperty("txtNinteibiKonkai")
    public void setTxtNinteibiKonkai(TextBoxFlexibleDate txtNinteibiKonkai) {
        this.txtNinteibiKonkai = txtNinteibiKonkai;
    }

    // </editor-fold>
}
/**
 * celTableCell23 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell23AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtServiceShuruiKonkai")
    private TextBox txtServiceShuruiKonkai;

    /*
     * gettxtServiceShuruiKonkai
     * @return txtServiceShuruiKonkai
     */
    @JsonProperty("txtServiceShuruiKonkai")
    public TextBox getTxtServiceShuruiKonkai() {
        return txtServiceShuruiKonkai;
    }

    /*
     * settxtServiceShuruiKonkai
     * @param txtServiceShuruiKonkai txtServiceShuruiKonkai
     */
    @JsonProperty("txtServiceShuruiKonkai")
    public void setTxtServiceShuruiKonkai(TextBox txtServiceShuruiKonkai) {
        this.txtServiceShuruiKonkai = txtServiceShuruiKonkai;
    }

    // </editor-fold>
}
/**
 * celTableCell24 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTableCell24AttblRireki extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    @JsonProperty("txtShinsakaiIkenKonkai")
    private TextBox txtShinsakaiIkenKonkai;

    /*
     * gettxtShinsakaiIkenKonkai
     * @return txtShinsakaiIkenKonkai
     */
    @JsonProperty("txtShinsakaiIkenKonkai")
    public TextBox getTxtShinsakaiIkenKonkai() {
        return txtShinsakaiIkenKonkai;
    }

    /*
     * settxtShinsakaiIkenKonkai
     * @param txtShinsakaiIkenKonkai txtShinsakaiIkenKonkai
     */
    @JsonProperty("txtShinsakaiIkenKonkai")
    public void setTxtShinsakaiIkenKonkai(TextBox txtShinsakaiIkenKonkai) {
        this.txtShinsakaiIkenKonkai = txtShinsakaiIkenKonkai;
    }

    // </editor-fold>
}

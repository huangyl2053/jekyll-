package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0700011;
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
 * tblSeikyuSummary のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSeikyuSummaryDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cell1")
    private cell1AttblSeikyuSummary cell1;
    @JsonProperty("cell2")
    private cell2AttblSeikyuSummary cell2;
    @JsonProperty("cell3")
    private cell3AttblSeikyuSummary cell3;
    @JsonProperty("cell10")
    private cell10AttblSeikyuSummary cell10;
    @JsonProperty("cell11")
    private cell11AttblSeikyuSummary cell11;
    @JsonProperty("cell4")
    private cell4AttblSeikyuSummary cell4;
    @JsonProperty("cell5")
    private cell5AttblSeikyuSummary cell5;
    @JsonProperty("cell6")
    private cell6AttblSeikyuSummary cell6;
    @JsonProperty("cell12")
    private cell12AttblSeikyuSummary cell12;
    @JsonProperty("cell13")
    private cell13AttblSeikyuSummary cell13;
    @JsonProperty("cell14")
    private cell14AttblSeikyuSummary cell14;
    @JsonProperty("cell7")
    private cell7AttblSeikyuSummary cell7;
    @JsonProperty("cell8")
    private cell8AttblSeikyuSummary cell8;
    @JsonProperty("cell9")
    private cell9AttblSeikyuSummary cell9;
    @JsonProperty("cell15")
    private cell15AttblSeikyuSummary cell15;
    @JsonProperty("cell16")
    private cell16AttblSeikyuSummary cell16;
    @JsonProperty("cell17")
    private cell17AttblSeikyuSummary cell17;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblSummary() {
        return this.cell1.getLblSummary();
    }

    @JsonIgnore
    public Label getLblHiyoTotal() {
        return this.cell2.getLblHiyoTotal();
    }

    @JsonIgnore
    public Label getLblHokenTaishoHiyo() {
        return this.cell3.getLblHokenTaishoHiyo();
    }

    @JsonIgnore
    public Label getLblHokenKyufuAmount() {
        return this.cell10.getLblHokenKyufuAmount();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutanAmount() {
        return this.cell11.getLblRiyoshaFutanAmount();
    }

    @JsonIgnore
    public Label getLblSummaryMae() {
        return this.cell4.getLblSummaryMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyoTotalMae() {
        return this.cell5.getTxtHiyoTotalMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenTaishoHiyoMae() {
        return this.cell6.getTxtHokenTaishoHiyoMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuAmountMae() {
        return this.cell12.getTxtHokenKyufuAmountMae();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return this.cell13.getTxtRiyoshaFutanAmountMae();
    }

    @JsonIgnore
    public Label getLblSummaryNow() {
        return this.cell7.getLblSummaryNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHiyoTotalNow() {
        return this.cell8.getTxtHiyoTotalNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenTaishoHiyoNow() {
        return this.cell9.getTxtHokenTaishoHiyoNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenKyufuAmountNow() {
        return this.cell15.getTxtHokenKyufuAmountNow();
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return this.cell16.getTxtRiyoshaFutanAmountNow();
    }

    @JsonIgnore
    public Button getBtnLimitOverCheck() {
        return this.cell17.getBtnLimitOverCheck();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getcell1
     * @return cell1
     */
    @JsonProperty("cell1")
    private cell1AttblSeikyuSummary getCell1() {
        return cell1;
    }

    /*
     * setcell1
     * @param cell1 cell1
     */
    @JsonProperty("cell1")
    private void setCell1(cell1AttblSeikyuSummary cell1) {
        this.cell1 = cell1;
    }

    /*
     * getcell2
     * @return cell2
     */
    @JsonProperty("cell2")
    private cell2AttblSeikyuSummary getCell2() {
        return cell2;
    }

    /*
     * setcell2
     * @param cell2 cell2
     */
    @JsonProperty("cell2")
    private void setCell2(cell2AttblSeikyuSummary cell2) {
        this.cell2 = cell2;
    }

    /*
     * getcell3
     * @return cell3
     */
    @JsonProperty("cell3")
    private cell3AttblSeikyuSummary getCell3() {
        return cell3;
    }

    /*
     * setcell3
     * @param cell3 cell3
     */
    @JsonProperty("cell3")
    private void setCell3(cell3AttblSeikyuSummary cell3) {
        this.cell3 = cell3;
    }

    /*
     * getcell10
     * @return cell10
     */
    @JsonProperty("cell10")
    private cell10AttblSeikyuSummary getCell10() {
        return cell10;
    }

    /*
     * setcell10
     * @param cell10 cell10
     */
    @JsonProperty("cell10")
    private void setCell10(cell10AttblSeikyuSummary cell10) {
        this.cell10 = cell10;
    }

    /*
     * getcell11
     * @return cell11
     */
    @JsonProperty("cell11")
    private cell11AttblSeikyuSummary getCell11() {
        return cell11;
    }

    /*
     * setcell11
     * @param cell11 cell11
     */
    @JsonProperty("cell11")
    private void setCell11(cell11AttblSeikyuSummary cell11) {
        this.cell11 = cell11;
    }

    /*
     * getcell4
     * @return cell4
     */
    @JsonProperty("cell4")
    private cell4AttblSeikyuSummary getCell4() {
        return cell4;
    }

    /*
     * setcell4
     * @param cell4 cell4
     */
    @JsonProperty("cell4")
    private void setCell4(cell4AttblSeikyuSummary cell4) {
        this.cell4 = cell4;
    }

    /*
     * getcell5
     * @return cell5
     */
    @JsonProperty("cell5")
    private cell5AttblSeikyuSummary getCell5() {
        return cell5;
    }

    /*
     * setcell5
     * @param cell5 cell5
     */
    @JsonProperty("cell5")
    private void setCell5(cell5AttblSeikyuSummary cell5) {
        this.cell5 = cell5;
    }

    /*
     * getcell6
     * @return cell6
     */
    @JsonProperty("cell6")
    private cell6AttblSeikyuSummary getCell6() {
        return cell6;
    }

    /*
     * setcell6
     * @param cell6 cell6
     */
    @JsonProperty("cell6")
    private void setCell6(cell6AttblSeikyuSummary cell6) {
        this.cell6 = cell6;
    }

    /*
     * getcell12
     * @return cell12
     */
    @JsonProperty("cell12")
    private cell12AttblSeikyuSummary getCell12() {
        return cell12;
    }

    /*
     * setcell12
     * @param cell12 cell12
     */
    @JsonProperty("cell12")
    private void setCell12(cell12AttblSeikyuSummary cell12) {
        this.cell12 = cell12;
    }

    /*
     * getcell13
     * @return cell13
     */
    @JsonProperty("cell13")
    private cell13AttblSeikyuSummary getCell13() {
        return cell13;
    }

    /*
     * setcell13
     * @param cell13 cell13
     */
    @JsonProperty("cell13")
    private void setCell13(cell13AttblSeikyuSummary cell13) {
        this.cell13 = cell13;
    }

    /*
     * getcell14
     * @return cell14
     */
    @JsonProperty("cell14")
    private cell14AttblSeikyuSummary getCell14() {
        return cell14;
    }

    /*
     * setcell14
     * @param cell14 cell14
     */
    @JsonProperty("cell14")
    private void setCell14(cell14AttblSeikyuSummary cell14) {
        this.cell14 = cell14;
    }

    /*
     * getcell7
     * @return cell7
     */
    @JsonProperty("cell7")
    private cell7AttblSeikyuSummary getCell7() {
        return cell7;
    }

    /*
     * setcell7
     * @param cell7 cell7
     */
    @JsonProperty("cell7")
    private void setCell7(cell7AttblSeikyuSummary cell7) {
        this.cell7 = cell7;
    }

    /*
     * getcell8
     * @return cell8
     */
    @JsonProperty("cell8")
    private cell8AttblSeikyuSummary getCell8() {
        return cell8;
    }

    /*
     * setcell8
     * @param cell8 cell8
     */
    @JsonProperty("cell8")
    private void setCell8(cell8AttblSeikyuSummary cell8) {
        this.cell8 = cell8;
    }

    /*
     * getcell9
     * @return cell9
     */
    @JsonProperty("cell9")
    private cell9AttblSeikyuSummary getCell9() {
        return cell9;
    }

    /*
     * setcell9
     * @param cell9 cell9
     */
    @JsonProperty("cell9")
    private void setCell9(cell9AttblSeikyuSummary cell9) {
        this.cell9 = cell9;
    }

    /*
     * getcell15
     * @return cell15
     */
    @JsonProperty("cell15")
    private cell15AttblSeikyuSummary getCell15() {
        return cell15;
    }

    /*
     * setcell15
     * @param cell15 cell15
     */
    @JsonProperty("cell15")
    private void setCell15(cell15AttblSeikyuSummary cell15) {
        this.cell15 = cell15;
    }

    /*
     * getcell16
     * @return cell16
     */
    @JsonProperty("cell16")
    private cell16AttblSeikyuSummary getCell16() {
        return cell16;
    }

    /*
     * setcell16
     * @param cell16 cell16
     */
    @JsonProperty("cell16")
    private void setCell16(cell16AttblSeikyuSummary cell16) {
        this.cell16 = cell16;
    }

    /*
     * getcell17
     * @return cell17
     */
    @JsonProperty("cell17")
    private cell17AttblSeikyuSummary getCell17() {
        return cell17;
    }

    /*
     * setcell17
     * @param cell17 cell17
     */
    @JsonProperty("cell17")
    private void setCell17(cell17AttblSeikyuSummary cell17) {
        this.cell17 = cell17;
    }

    // </editor-fold>
}
/**
 * cell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell1AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblSummary")
    private Label lblSummary;

    /*
     * getlblSummary
     * @return lblSummary
     */
    @JsonProperty("lblSummary")
    public Label getLblSummary() {
        return lblSummary;
    }

    /*
     * setlblSummary
     * @param lblSummary lblSummary
     */
    @JsonProperty("lblSummary")
    public void setLblSummary(Label lblSummary) {
        this.lblSummary = lblSummary;
    }

    // </editor-fold>
}
/**
 * cell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell2AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblHiyoTotal")
    private Label lblHiyoTotal;

    /*
     * getlblHiyoTotal
     * @return lblHiyoTotal
     */
    @JsonProperty("lblHiyoTotal")
    public Label getLblHiyoTotal() {
        return lblHiyoTotal;
    }

    /*
     * setlblHiyoTotal
     * @param lblHiyoTotal lblHiyoTotal
     */
    @JsonProperty("lblHiyoTotal")
    public void setLblHiyoTotal(Label lblHiyoTotal) {
        this.lblHiyoTotal = lblHiyoTotal;
    }

    // </editor-fold>
}
/**
 * cell3 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell3AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblHokenTaishoHiyo")
    private Label lblHokenTaishoHiyo;

    /*
     * getlblHokenTaishoHiyo
     * @return lblHokenTaishoHiyo
     */
    @JsonProperty("lblHokenTaishoHiyo")
    public Label getLblHokenTaishoHiyo() {
        return lblHokenTaishoHiyo;
    }

    /*
     * setlblHokenTaishoHiyo
     * @param lblHokenTaishoHiyo lblHokenTaishoHiyo
     */
    @JsonProperty("lblHokenTaishoHiyo")
    public void setLblHokenTaishoHiyo(Label lblHokenTaishoHiyo) {
        this.lblHokenTaishoHiyo = lblHokenTaishoHiyo;
    }

    // </editor-fold>
}
/**
 * cell10 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell10AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblHokenKyufuAmount")
    private Label lblHokenKyufuAmount;

    /*
     * getlblHokenKyufuAmount
     * @return lblHokenKyufuAmount
     */
    @JsonProperty("lblHokenKyufuAmount")
    public Label getLblHokenKyufuAmount() {
        return lblHokenKyufuAmount;
    }

    /*
     * setlblHokenKyufuAmount
     * @param lblHokenKyufuAmount lblHokenKyufuAmount
     */
    @JsonProperty("lblHokenKyufuAmount")
    public void setLblHokenKyufuAmount(Label lblHokenKyufuAmount) {
        this.lblHokenKyufuAmount = lblHokenKyufuAmount;
    }

    // </editor-fold>
}
/**
 * cell11 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell11AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblRiyoshaFutanAmount")
    private Label lblRiyoshaFutanAmount;

    /*
     * getlblRiyoshaFutanAmount
     * @return lblRiyoshaFutanAmount
     */
    @JsonProperty("lblRiyoshaFutanAmount")
    public Label getLblRiyoshaFutanAmount() {
        return lblRiyoshaFutanAmount;
    }

    /*
     * setlblRiyoshaFutanAmount
     * @param lblRiyoshaFutanAmount lblRiyoshaFutanAmount
     */
    @JsonProperty("lblRiyoshaFutanAmount")
    public void setLblRiyoshaFutanAmount(Label lblRiyoshaFutanAmount) {
        this.lblRiyoshaFutanAmount = lblRiyoshaFutanAmount;
    }

    // </editor-fold>
}
/**
 * cell4 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell4AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblSummaryMae")
    private Label lblSummaryMae;

    /*
     * getlblSummaryMae
     * @return lblSummaryMae
     */
    @JsonProperty("lblSummaryMae")
    public Label getLblSummaryMae() {
        return lblSummaryMae;
    }

    /*
     * setlblSummaryMae
     * @param lblSummaryMae lblSummaryMae
     */
    @JsonProperty("lblSummaryMae")
    public void setLblSummaryMae(Label lblSummaryMae) {
        this.lblSummaryMae = lblSummaryMae;
    }

    // </editor-fold>
}
/**
 * cell5 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell5AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtHiyoTotalMae")
    private TextBoxNum txtHiyoTotalMae;

    /*
     * gettxtHiyoTotalMae
     * @return txtHiyoTotalMae
     */
    @JsonProperty("txtHiyoTotalMae")
    public TextBoxNum getTxtHiyoTotalMae() {
        return txtHiyoTotalMae;
    }

    /*
     * settxtHiyoTotalMae
     * @param txtHiyoTotalMae txtHiyoTotalMae
     */
    @JsonProperty("txtHiyoTotalMae")
    public void setTxtHiyoTotalMae(TextBoxNum txtHiyoTotalMae) {
        this.txtHiyoTotalMae = txtHiyoTotalMae;
    }

    // </editor-fold>
}
/**
 * cell6 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell6AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtHokenTaishoHiyoMae")
    private TextBoxNum txtHokenTaishoHiyoMae;

    /*
     * gettxtHokenTaishoHiyoMae
     * @return txtHokenTaishoHiyoMae
     */
    @JsonProperty("txtHokenTaishoHiyoMae")
    public TextBoxNum getTxtHokenTaishoHiyoMae() {
        return txtHokenTaishoHiyoMae;
    }

    /*
     * settxtHokenTaishoHiyoMae
     * @param txtHokenTaishoHiyoMae txtHokenTaishoHiyoMae
     */
    @JsonProperty("txtHokenTaishoHiyoMae")
    public void setTxtHokenTaishoHiyoMae(TextBoxNum txtHokenTaishoHiyoMae) {
        this.txtHokenTaishoHiyoMae = txtHokenTaishoHiyoMae;
    }

    // </editor-fold>
}
/**
 * cell12 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell12AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtHokenKyufuAmountMae")
    private TextBoxNum txtHokenKyufuAmountMae;

    /*
     * gettxtHokenKyufuAmountMae
     * @return txtHokenKyufuAmountMae
     */
    @JsonProperty("txtHokenKyufuAmountMae")
    public TextBoxNum getTxtHokenKyufuAmountMae() {
        return txtHokenKyufuAmountMae;
    }

    /*
     * settxtHokenKyufuAmountMae
     * @param txtHokenKyufuAmountMae txtHokenKyufuAmountMae
     */
    @JsonProperty("txtHokenKyufuAmountMae")
    public void setTxtHokenKyufuAmountMae(TextBoxNum txtHokenKyufuAmountMae) {
        this.txtHokenKyufuAmountMae = txtHokenKyufuAmountMae;
    }

    // </editor-fold>
}
/**
 * cell13 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell13AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtRiyoshaFutanAmountMae")
    private TextBoxNum txtRiyoshaFutanAmountMae;

    /*
     * gettxtRiyoshaFutanAmountMae
     * @return txtRiyoshaFutanAmountMae
     */
    @JsonProperty("txtRiyoshaFutanAmountMae")
    public TextBoxNum getTxtRiyoshaFutanAmountMae() {
        return txtRiyoshaFutanAmountMae;
    }

    /*
     * settxtRiyoshaFutanAmountMae
     * @param txtRiyoshaFutanAmountMae txtRiyoshaFutanAmountMae
     */
    @JsonProperty("txtRiyoshaFutanAmountMae")
    public void setTxtRiyoshaFutanAmountMae(TextBoxNum txtRiyoshaFutanAmountMae) {
        this.txtRiyoshaFutanAmountMae = txtRiyoshaFutanAmountMae;
    }

    // </editor-fold>
}
/**
 * cell14 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell14AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">

    // </editor-fold>
}
/**
 * cell7 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell7AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("lblSummaryNow")
    private Label lblSummaryNow;

    /*
     * getlblSummaryNow
     * @return lblSummaryNow
     */
    @JsonProperty("lblSummaryNow")
    public Label getLblSummaryNow() {
        return lblSummaryNow;
    }

    /*
     * setlblSummaryNow
     * @param lblSummaryNow lblSummaryNow
     */
    @JsonProperty("lblSummaryNow")
    public void setLblSummaryNow(Label lblSummaryNow) {
        this.lblSummaryNow = lblSummaryNow;
    }

    // </editor-fold>
}
/**
 * cell8 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell8AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtHiyoTotalNow")
    private TextBoxNum txtHiyoTotalNow;

    /*
     * gettxtHiyoTotalNow
     * @return txtHiyoTotalNow
     */
    @JsonProperty("txtHiyoTotalNow")
    public TextBoxNum getTxtHiyoTotalNow() {
        return txtHiyoTotalNow;
    }

    /*
     * settxtHiyoTotalNow
     * @param txtHiyoTotalNow txtHiyoTotalNow
     */
    @JsonProperty("txtHiyoTotalNow")
    public void setTxtHiyoTotalNow(TextBoxNum txtHiyoTotalNow) {
        this.txtHiyoTotalNow = txtHiyoTotalNow;
    }

    // </editor-fold>
}
/**
 * cell9 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell9AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtHokenTaishoHiyoNow")
    private TextBoxNum txtHokenTaishoHiyoNow;

    /*
     * gettxtHokenTaishoHiyoNow
     * @return txtHokenTaishoHiyoNow
     */
    @JsonProperty("txtHokenTaishoHiyoNow")
    public TextBoxNum getTxtHokenTaishoHiyoNow() {
        return txtHokenTaishoHiyoNow;
    }

    /*
     * settxtHokenTaishoHiyoNow
     * @param txtHokenTaishoHiyoNow txtHokenTaishoHiyoNow
     */
    @JsonProperty("txtHokenTaishoHiyoNow")
    public void setTxtHokenTaishoHiyoNow(TextBoxNum txtHokenTaishoHiyoNow) {
        this.txtHokenTaishoHiyoNow = txtHokenTaishoHiyoNow;
    }

    // </editor-fold>
}
/**
 * cell15 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell15AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtHokenKyufuAmountNow")
    private TextBoxNum txtHokenKyufuAmountNow;

    /*
     * gettxtHokenKyufuAmountNow
     * @return txtHokenKyufuAmountNow
     */
    @JsonProperty("txtHokenKyufuAmountNow")
    public TextBoxNum getTxtHokenKyufuAmountNow() {
        return txtHokenKyufuAmountNow;
    }

    /*
     * settxtHokenKyufuAmountNow
     * @param txtHokenKyufuAmountNow txtHokenKyufuAmountNow
     */
    @JsonProperty("txtHokenKyufuAmountNow")
    public void setTxtHokenKyufuAmountNow(TextBoxNum txtHokenKyufuAmountNow) {
        this.txtHokenKyufuAmountNow = txtHokenKyufuAmountNow;
    }

    // </editor-fold>
}
/**
 * cell16 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell16AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("txtRiyoshaFutanAmountNow")
    private TextBoxNum txtRiyoshaFutanAmountNow;

    /*
     * gettxtRiyoshaFutanAmountNow
     * @return txtRiyoshaFutanAmountNow
     */
    @JsonProperty("txtRiyoshaFutanAmountNow")
    public TextBoxNum getTxtRiyoshaFutanAmountNow() {
        return txtRiyoshaFutanAmountNow;
    }

    /*
     * settxtRiyoshaFutanAmountNow
     * @param txtRiyoshaFutanAmountNow txtRiyoshaFutanAmountNow
     */
    @JsonProperty("txtRiyoshaFutanAmountNow")
    public void setTxtRiyoshaFutanAmountNow(TextBoxNum txtRiyoshaFutanAmountNow) {
        this.txtRiyoshaFutanAmountNow = txtRiyoshaFutanAmountNow;
    }

    // </editor-fold>
}
/**
 * cell17 のクラスファイル 
 * 
 * @author 自動生成
 */
class cell17AttblSeikyuSummary extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    @JsonProperty("btnLimitOverCheck")
    private Button btnLimitOverCheck;

    /*
     * getbtnLimitOverCheck
     * @return btnLimitOverCheck
     */
    @JsonProperty("btnLimitOverCheck")
    public Button getBtnLimitOverCheck() {
        return btnLimitOverCheck;
    }

    /*
     * setbtnLimitOverCheck
     * @param btnLimitOverCheck btnLimitOverCheck
     */
    @JsonProperty("btnLimitOverCheck")
    public void setBtnLimitOverCheck(Button btnLimitOverCheck) {
        this.btnLimitOverCheck = btnLimitOverCheck;
    }

    // </editor-fold>
}

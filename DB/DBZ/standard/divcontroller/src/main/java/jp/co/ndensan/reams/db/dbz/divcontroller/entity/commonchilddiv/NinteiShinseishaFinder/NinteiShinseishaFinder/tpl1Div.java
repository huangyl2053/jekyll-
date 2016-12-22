package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha.ISaikinShorishaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha.SaikinShorishaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

/**
 * tpl1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tpl1Div extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tcl1")
    private tcl1Attpl1 tcl1;
    @JsonProperty("tcl2")
    private tcl2Attpl1 tcl2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.tcl1.getTxtHihokenshaName();
    }

    @JsonIgnore
    public DropDownList getDdlHihokenshaNameMatchType() {
        return this.tcl1.getDdlHihokenshaNameMatchType();
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiFlag() {
        return this.tcl1.getChkMinashiFlag();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiDateFrom() {
        return this.tcl1.getTxtNinteiShinseiDateFrom();
    }

    @JsonIgnore
    public Label getLblNinteiShinseiDate() {
        return this.tcl1.getLblNinteiShinseiDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiShinseiDateTo() {
        return this.tcl1.getTxtNinteiShinseiDateTo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthDateFrom() {
        return this.tcl1.getTxtBirthDateFrom();
    }

    @JsonIgnore
    public Label getLblBirthDate() {
        return this.tcl1.getLblBirthDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtBirthDateTO() {
        return this.tcl1.getTxtBirthDateTO();
    }

    @JsonIgnore
    public DropDownList getDdlShinseijiShinseiKubun() {
        return this.tcl1.getDdlShinseijiShinseiKubun();
    }

    @JsonIgnore
    public CheckBoxList getChkSeibetsu() {
        return this.tcl1.getChkSeibetsu();
    }

    @JsonIgnore
    public ISaikinShorishaDiv getCcdSaikinShorisha() {
        return this.tcl2.getCcdSaikinShorisha();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettcl1
     * @return tcl1
     */
    @JsonProperty("tcl1")
    private tcl1Attpl1 getTcl1() {
        return tcl1;
    }

    /*
     * settcl1
     * @param tcl1 tcl1
     */
    @JsonProperty("tcl1")
    private void setTcl1(tcl1Attpl1 tcl1) {
        this.tcl1 = tcl1;
    }

    /*
     * gettcl2
     * @return tcl2
     */
    @JsonProperty("tcl2")
    private tcl2Attpl1 getTcl2() {
        return tcl2;
    }

    /*
     * settcl2
     * @param tcl2 tcl2
     */
    @JsonProperty("tcl2")
    private void setTcl2(tcl2Attpl1 tcl2) {
        this.tcl2 = tcl2;
    }

    // </editor-fold>
}
/**
 * tcl1 のクラスファイル 
 * 
 * @author 自動生成
 */
class tcl1Attpl1 extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("ddlHihokenshaNameMatchType")
    private DropDownList ddlHihokenshaNameMatchType;
    @JsonProperty("chkMinashiFlag")
    private CheckBoxList chkMinashiFlag;
    @JsonProperty("txtNinteiShinseiDateFrom")
    private TextBoxFlexibleDate txtNinteiShinseiDateFrom;
    @JsonProperty("lblNinteiShinseiDate")
    private Label lblNinteiShinseiDate;
    @JsonProperty("txtNinteiShinseiDateTo")
    private TextBoxFlexibleDate txtNinteiShinseiDateTo;
    @JsonProperty("txtBirthDateFrom")
    private TextBoxFlexibleDate txtBirthDateFrom;
    @JsonProperty("lblBirthDate")
    private Label lblBirthDate;
    @JsonProperty("txtBirthDateTO")
    private TextBoxFlexibleDate txtBirthDateTO;
    @JsonProperty("ddlShinseijiShinseiKubun")
    private DropDownList ddlShinseijiShinseiKubun;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
    }

    /*
     * getddlHihokenshaNameMatchType
     * @return ddlHihokenshaNameMatchType
     */
    @JsonProperty("ddlHihokenshaNameMatchType")
    public DropDownList getDdlHihokenshaNameMatchType() {
        return ddlHihokenshaNameMatchType;
    }

    /*
     * setddlHihokenshaNameMatchType
     * @param ddlHihokenshaNameMatchType ddlHihokenshaNameMatchType
     */
    @JsonProperty("ddlHihokenshaNameMatchType")
    public void setDdlHihokenshaNameMatchType(DropDownList ddlHihokenshaNameMatchType) {
        this.ddlHihokenshaNameMatchType = ddlHihokenshaNameMatchType;
    }

    /*
     * getchkMinashiFlag
     * @return chkMinashiFlag
     */
    @JsonProperty("chkMinashiFlag")
    public CheckBoxList getChkMinashiFlag() {
        return chkMinashiFlag;
    }

    /*
     * setchkMinashiFlag
     * @param chkMinashiFlag chkMinashiFlag
     */
    @JsonProperty("chkMinashiFlag")
    public void setChkMinashiFlag(CheckBoxList chkMinashiFlag) {
        this.chkMinashiFlag = chkMinashiFlag;
    }

    /*
     * gettxtNinteiShinseiDateFrom
     * @return txtNinteiShinseiDateFrom
     */
    @JsonProperty("txtNinteiShinseiDateFrom")
    public TextBoxFlexibleDate getTxtNinteiShinseiDateFrom() {
        return txtNinteiShinseiDateFrom;
    }

    /*
     * settxtNinteiShinseiDateFrom
     * @param txtNinteiShinseiDateFrom txtNinteiShinseiDateFrom
     */
    @JsonProperty("txtNinteiShinseiDateFrom")
    public void setTxtNinteiShinseiDateFrom(TextBoxFlexibleDate txtNinteiShinseiDateFrom) {
        this.txtNinteiShinseiDateFrom = txtNinteiShinseiDateFrom;
    }

    /*
     * getlblNinteiShinseiDate
     * @return lblNinteiShinseiDate
     */
    @JsonProperty("lblNinteiShinseiDate")
    public Label getLblNinteiShinseiDate() {
        return lblNinteiShinseiDate;
    }

    /*
     * setlblNinteiShinseiDate
     * @param lblNinteiShinseiDate lblNinteiShinseiDate
     */
    @JsonProperty("lblNinteiShinseiDate")
    public void setLblNinteiShinseiDate(Label lblNinteiShinseiDate) {
        this.lblNinteiShinseiDate = lblNinteiShinseiDate;
    }

    /*
     * gettxtNinteiShinseiDateTo
     * @return txtNinteiShinseiDateTo
     */
    @JsonProperty("txtNinteiShinseiDateTo")
    public TextBoxFlexibleDate getTxtNinteiShinseiDateTo() {
        return txtNinteiShinseiDateTo;
    }

    /*
     * settxtNinteiShinseiDateTo
     * @param txtNinteiShinseiDateTo txtNinteiShinseiDateTo
     */
    @JsonProperty("txtNinteiShinseiDateTo")
    public void setTxtNinteiShinseiDateTo(TextBoxFlexibleDate txtNinteiShinseiDateTo) {
        this.txtNinteiShinseiDateTo = txtNinteiShinseiDateTo;
    }

    /*
     * gettxtBirthDateFrom
     * @return txtBirthDateFrom
     */
    @JsonProperty("txtBirthDateFrom")
    public TextBoxFlexibleDate getTxtBirthDateFrom() {
        return txtBirthDateFrom;
    }

    /*
     * settxtBirthDateFrom
     * @param txtBirthDateFrom txtBirthDateFrom
     */
    @JsonProperty("txtBirthDateFrom")
    public void setTxtBirthDateFrom(TextBoxFlexibleDate txtBirthDateFrom) {
        this.txtBirthDateFrom = txtBirthDateFrom;
    }

    /*
     * getlblBirthDate
     * @return lblBirthDate
     */
    @JsonProperty("lblBirthDate")
    public Label getLblBirthDate() {
        return lblBirthDate;
    }

    /*
     * setlblBirthDate
     * @param lblBirthDate lblBirthDate
     */
    @JsonProperty("lblBirthDate")
    public void setLblBirthDate(Label lblBirthDate) {
        this.lblBirthDate = lblBirthDate;
    }

    /*
     * gettxtBirthDateTO
     * @return txtBirthDateTO
     */
    @JsonProperty("txtBirthDateTO")
    public TextBoxFlexibleDate getTxtBirthDateTO() {
        return txtBirthDateTO;
    }

    /*
     * settxtBirthDateTO
     * @param txtBirthDateTO txtBirthDateTO
     */
    @JsonProperty("txtBirthDateTO")
    public void setTxtBirthDateTO(TextBoxFlexibleDate txtBirthDateTO) {
        this.txtBirthDateTO = txtBirthDateTO;
    }

    /*
     * getddlShinseijiShinseiKubun
     * @return ddlShinseijiShinseiKubun
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    public DropDownList getDdlShinseijiShinseiKubun() {
        return ddlShinseijiShinseiKubun;
    }

    /*
     * setddlShinseijiShinseiKubun
     * @param ddlShinseijiShinseiKubun ddlShinseijiShinseiKubun
     */
    @JsonProperty("ddlShinseijiShinseiKubun")
    public void setDdlShinseijiShinseiKubun(DropDownList ddlShinseijiShinseiKubun) {
        this.ddlShinseijiShinseiKubun = ddlShinseijiShinseiKubun;
    }

    /*
     * getchkSeibetsu
     * @return chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public CheckBoxList getChkSeibetsu() {
        return chkSeibetsu;
    }

    /*
     * setchkSeibetsu
     * @param chkSeibetsu chkSeibetsu
     */
    @JsonProperty("chkSeibetsu")
    public void setChkSeibetsu(CheckBoxList chkSeibetsu) {
        this.chkSeibetsu = chkSeibetsu;
    }

    // </editor-fold>
}
/**
 * tcl2 のクラスファイル 
 * 
 * @author 自動生成
 */
class tcl2Attpl1 extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    @JsonProperty("ccdSaikinShorisha")
    private SaikinShorishaDiv ccdSaikinShorisha;

    /*
     * getccdSaikinShorisha
     * @return ccdSaikinShorisha
     */
    @JsonProperty("ccdSaikinShorisha")
    public ISaikinShorishaDiv getCcdSaikinShorisha() {
        return ccdSaikinShorisha;
    }

    // </editor-fold>
}

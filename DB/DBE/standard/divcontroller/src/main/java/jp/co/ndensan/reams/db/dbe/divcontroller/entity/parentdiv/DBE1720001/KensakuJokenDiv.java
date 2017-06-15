package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1720001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KensakuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class KensakuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-03-02_13-24-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNumber")
    private TextBoxCode txtHihokenshaNumber;
    @JsonProperty("spaceName")
    private HorizontalLine spaceName;
    @JsonProperty("txtHihokenshaNameJyouken")
    private TextBox txtHihokenshaNameJyouken;
    @JsonProperty("ddlHihokenshaNameMatchType")
    private DropDownList ddlHihokenshaNameMatchType;
    @JsonProperty("chkMinashiFlag")
    private CheckBoxList chkMinashiFlag;
    @JsonProperty("txtNinteiShinseiDateRange")
    private TextBoxDateRange txtNinteiShinseiDateRange;
    @JsonProperty("txtBirthDateRange")
    private TextBoxDateRange txtBirthDateRange;
    @JsonProperty("ddlShinseijiShinseiKubun")
    private DropDownList ddlShinseijiShinseiKubun;
    @JsonProperty("chkSeibetsu")
    private CheckBoxList chkSeibetsu;
    @JsonProperty("TextBoxNum")
    private TextBoxNum TextBoxNum;
    @JsonProperty("btnKyufuJissekiSearchClear")
    private Button btnKyufuJissekiSearchClear;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNumber
     * @return txtHihokenshaNumber
     */
    @JsonProperty("txtHihokenshaNumber")
    public TextBoxCode getTxtHihokenshaNumber() {
        return txtHihokenshaNumber;
    }

    /*
     * settxtHihokenshaNumber
     * @param txtHihokenshaNumber txtHihokenshaNumber
     */
    @JsonProperty("txtHihokenshaNumber")
    public void setTxtHihokenshaNumber(TextBoxCode txtHihokenshaNumber) {
        this.txtHihokenshaNumber = txtHihokenshaNumber;
    }

    /*
     * getspaceName
     * @return spaceName
     */
    @JsonProperty("spaceName")
    public HorizontalLine getSpaceName() {
        return spaceName;
    }

    /*
     * setspaceName
     * @param spaceName spaceName
     */
    @JsonProperty("spaceName")
    public void setSpaceName(HorizontalLine spaceName) {
        this.spaceName = spaceName;
    }

    /*
     * gettxtHihokenshaNameJyouken
     * @return txtHihokenshaNameJyouken
     */
    @JsonProperty("txtHihokenshaNameJyouken")
    public TextBox getTxtHihokenshaNameJyouken() {
        return txtHihokenshaNameJyouken;
    }

    /*
     * settxtHihokenshaNameJyouken
     * @param txtHihokenshaNameJyouken txtHihokenshaNameJyouken
     */
    @JsonProperty("txtHihokenshaNameJyouken")
    public void setTxtHihokenshaNameJyouken(TextBox txtHihokenshaNameJyouken) {
        this.txtHihokenshaNameJyouken = txtHihokenshaNameJyouken;
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
     * gettxtNinteiShinseiDateRange
     * @return txtNinteiShinseiDateRange
     */
    @JsonProperty("txtNinteiShinseiDateRange")
    public TextBoxDateRange getTxtNinteiShinseiDateRange() {
        return txtNinteiShinseiDateRange;
    }

    /*
     * settxtNinteiShinseiDateRange
     * @param txtNinteiShinseiDateRange txtNinteiShinseiDateRange
     */
    @JsonProperty("txtNinteiShinseiDateRange")
    public void setTxtNinteiShinseiDateRange(TextBoxDateRange txtNinteiShinseiDateRange) {
        this.txtNinteiShinseiDateRange = txtNinteiShinseiDateRange;
    }

    /*
     * gettxtBirthDateRange
     * @return txtBirthDateRange
     */
    @JsonProperty("txtBirthDateRange")
    public TextBoxDateRange getTxtBirthDateRange() {
        return txtBirthDateRange;
    }

    /*
     * settxtBirthDateRange
     * @param txtBirthDateRange txtBirthDateRange
     */
    @JsonProperty("txtBirthDateRange")
    public void setTxtBirthDateRange(TextBoxDateRange txtBirthDateRange) {
        this.txtBirthDateRange = txtBirthDateRange;
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

    /*
     * getTextBoxNum
     * @return TextBoxNum
     */
    @JsonProperty("TextBoxNum")
    public TextBoxNum getTextBoxNum() {
        return TextBoxNum;
    }

    /*
     * setTextBoxNum
     * @param TextBoxNum TextBoxNum
     */
    @JsonProperty("TextBoxNum")
    public void setTextBoxNum(TextBoxNum TextBoxNum) {
        this.TextBoxNum = TextBoxNum;
    }

    /*
     * getbtnKyufuJissekiSearchClear
     * @return btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public Button getBtnKyufuJissekiSearchClear() {
        return btnKyufuJissekiSearchClear;
    }

    /*
     * setbtnKyufuJissekiSearchClear
     * @param btnKyufuJissekiSearchClear btnKyufuJissekiSearchClear
     */
    @JsonProperty("btnKyufuJissekiSearchClear")
    public void setBtnKyufuJissekiSearchClear(Button btnKyufuJissekiSearchClear) {
        this.btnKyufuJissekiSearchClear = btnKyufuJissekiSearchClear;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    // </editor-fold>
}

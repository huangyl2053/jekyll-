package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * SokujiFukaKouseiMain のクラスファイル
 *
 * @reamsid_L DBB-0660-010 tianshuai
 */
public class SokujiFukaKouseiMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtChoteiYMD")
    private TextBoxDate txtChoteiYMD;
    @JsonProperty("ddlKoseiTsuki")
    private DropDownList ddlKoseiTsuki;
    @JsonProperty("ddlKoseigoTsuchishoNo")
    private DropDownList ddlKoseigoTsuchishoNo;
    @JsonProperty("btnYokunendoHyoji")
    private Button btnYokunendoHyoji;
    @JsonProperty("tabSokujiKousei")
    private tabSokujiKouseiDiv tabSokujiKousei;
    @JsonProperty("isHasWarningFlag")
    private RString isHasWarningFlag;
    @JsonProperty("tokuchoNofugakuValue10")
    private RString tokuchoNofugakuValue10;
    @JsonProperty("tokuchoNofugakuValue12")
    private RString tokuchoNofugakuValue12;
    @JsonProperty("tokuchoNofugakuValue02")
    private RString tokuchoNofugakuValue02;
    @JsonProperty("tokuchoNofugakuValue06")
    private RString tokuchoNofugakuValue06;
    @JsonProperty("tokuchoNofugakuValue08")
    private RString tokuchoNofugakuValue08;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiNendo
     * @return txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    /*
     * settxtChoteiNendo
     * @param txtChoteiNendo txtChoteiNendo
     */
    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo = txtChoteiNendo;
    }

    /*
     * gettxtFukaNendo
     * @return txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    /*
     * settxtFukaNendo
     * @param txtFukaNendo txtFukaNendo
     */
    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo = txtFukaNendo;
    }

    /*
     * gettxtChoteiYMD
     * @return txtChoteiYMD
     */
    @JsonProperty("txtChoteiYMD")
    public TextBoxDate getTxtChoteiYMD() {
        return txtChoteiYMD;
    }

    /*
     * settxtChoteiYMD
     * @param txtChoteiYMD txtChoteiYMD
     */
    @JsonProperty("txtChoteiYMD")
    public void setTxtChoteiYMD(TextBoxDate txtChoteiYMD) {
        this.txtChoteiYMD = txtChoteiYMD;
    }

    /*
     * getddlKoseiTsuki
     * @return ddlKoseiTsuki
     */
    @JsonProperty("ddlKoseiTsuki")
    public DropDownList getDdlKoseiTsuki() {
        return ddlKoseiTsuki;
    }

    /*
     * setddlKoseiTsuki
     * @param ddlKoseiTsuki ddlKoseiTsuki
     */
    @JsonProperty("ddlKoseiTsuki")
    public void setDdlKoseiTsuki(DropDownList ddlKoseiTsuki) {
        this.ddlKoseiTsuki = ddlKoseiTsuki;
    }

    /*
     * getddlKoseigoTsuchishoNo
     * @return ddlKoseigoTsuchishoNo
     */
    @JsonProperty("ddlKoseigoTsuchishoNo")
    public DropDownList getDdlKoseigoTsuchishoNo() {
        return ddlKoseigoTsuchishoNo;
    }

    /*
     * setddlKoseigoTsuchishoNo
     * @param ddlKoseigoTsuchishoNo ddlKoseigoTsuchishoNo
     */
    @JsonProperty("ddlKoseigoTsuchishoNo")
    public void setDdlKoseigoTsuchishoNo(DropDownList ddlKoseigoTsuchishoNo) {
        this.ddlKoseigoTsuchishoNo = ddlKoseigoTsuchishoNo;
    }

    /*
     * getbtnYokunendoHyoji
     * @return btnYokunendoHyoji
     */
    @JsonProperty("btnYokunendoHyoji")
    public Button getBtnYokunendoHyoji() {
        return btnYokunendoHyoji;
    }

    /*
     * setbtnYokunendoHyoji
     * @param btnYokunendoHyoji btnYokunendoHyoji
     */
    @JsonProperty("btnYokunendoHyoji")
    public void setBtnYokunendoHyoji(Button btnYokunendoHyoji) {
        this.btnYokunendoHyoji = btnYokunendoHyoji;
    }

    /*
     * gettabSokujiKousei
     * @return tabSokujiKousei
     */
    @JsonProperty("tabSokujiKousei")
    public tabSokujiKouseiDiv getTabSokujiKousei() {
        return tabSokujiKousei;
    }

    /*
     * settabSokujiKousei
     * @param tabSokujiKousei tabSokujiKousei
     */
    @JsonProperty("tabSokujiKousei")
    public void setTabSokujiKousei(tabSokujiKouseiDiv tabSokujiKousei) {
        this.tabSokujiKousei = tabSokujiKousei;
    }

    /*
     * getisHasWarningFlag
     * @return isHasWarningFlag
     */
    @JsonProperty("isHasWarningFlag")
    public RString getIsHasWarningFlag() {
        return isHasWarningFlag;
    }

    /*
     * setisHasWarningFlag
     * @param isHasWarningFlag isHasWarningFlag
     */
    @JsonProperty("isHasWarningFlag")
    public void setIsHasWarningFlag(RString isHasWarningFlag) {
        this.isHasWarningFlag = isHasWarningFlag;
    }

    /*
     * gettokuchoNofugakuValue10
     * @return tokuchoNofugakuValue10
     */
    @JsonProperty("tokuchoNofugakuValue10")
    public RString getTokuchoNofugakuValue10() {
        return tokuchoNofugakuValue10;
    }

    /*
     * settokuchoNofugakuValue10
     * @param tokuchoNofugakuValue10 tokuchoNofugakuValue10
     */
    @JsonProperty("tokuchoNofugakuValue10")
    public void setTokuchoNofugakuValue10(RString tokuchoNofugakuValue10) {
        this.tokuchoNofugakuValue10 = tokuchoNofugakuValue10;
    }

    /*
     * gettokuchoNofugakuValue12
     * @return tokuchoNofugakuValue12
     */
    @JsonProperty("tokuchoNofugakuValue12")
    public RString getTokuchoNofugakuValue12() {
        return tokuchoNofugakuValue12;
    }

    /*
     * settokuchoNofugakuValue12
     * @param tokuchoNofugakuValue12 tokuchoNofugakuValue12
     */
    @JsonProperty("tokuchoNofugakuValue12")
    public void setTokuchoNofugakuValue12(RString tokuchoNofugakuValue12) {
        this.tokuchoNofugakuValue12 = tokuchoNofugakuValue12;
    }

    /*
     * gettokuchoNofugakuValue02
     * @return tokuchoNofugakuValue02
     */
    @JsonProperty("tokuchoNofugakuValue02")
    public RString getTokuchoNofugakuValue02() {
        return tokuchoNofugakuValue02;
    }

    /*
     * settokuchoNofugakuValue02
     * @param tokuchoNofugakuValue02 tokuchoNofugakuValue02
     */
    @JsonProperty("tokuchoNofugakuValue02")
    public void setTokuchoNofugakuValue02(RString tokuchoNofugakuValue02) {
        this.tokuchoNofugakuValue02 = tokuchoNofugakuValue02;
    }

    /*
     * gettokuchoNofugakuValue06
     * @return tokuchoNofugakuValue06
     */
    @JsonProperty("tokuchoNofugakuValue06")
    public RString getTokuchoNofugakuValue06() {
        return tokuchoNofugakuValue06;
    }

    /*
     * settokuchoNofugakuValue06
     * @param tokuchoNofugakuValue06 tokuchoNofugakuValue06
     */
    @JsonProperty("tokuchoNofugakuValue06")
    public void setTokuchoNofugakuValue06(RString tokuchoNofugakuValue06) {
        this.tokuchoNofugakuValue06 = tokuchoNofugakuValue06;
    }

    /*
     * gettokuchoNofugakuValue08
     * @return tokuchoNofugakuValue08
     */
    @JsonProperty("tokuchoNofugakuValue08")
    public RString getTokuchoNofugakuValue08() {
        return tokuchoNofugakuValue08;
    }

    /*
     * settokuchoNofugakuValue08
     * @param tokuchoNofugakuValue08 tokuchoNofugakuValue08
     */
    @JsonProperty("tokuchoNofugakuValue08")
    public void setTokuchoNofugakuValue08(RString tokuchoNofugakuValue08) {
        this.tokuchoNofugakuValue08 = tokuchoNofugakuValue08;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SokujiKoseiTab1Div getSokujiKoseiTab1() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1();
    }

    @JsonIgnore
    public void setSokujiKoseiTab1(SokujiKoseiTab1Div SokujiKoseiTab1) {
        this.getTabSokujiKousei().setSokujiKoseiTab1(SokujiKoseiTab1);
    }

    @JsonIgnore
    public SokujikouseiFukakonkyoDiv getSokujikouseiFukakonkyo() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiFukakonkyo();
    }

    @JsonIgnore
    public void setSokujikouseiFukakonkyo(SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setSokujikouseiFukakonkyo(SokujikouseiFukakonkyo);
    }

    @JsonIgnore
    public GemmenGakuInputDiv getGemmenGakuInput() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getGemmenGakuInput();
    }

    @JsonIgnore
    public void setGemmenGakuInput(GemmenGakuInputDiv GemmenGakuInput) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setGemmenGakuInput(GemmenGakuInput);
    }

    @JsonIgnore
    public TextBoxNum getTxtGemmenGakuInput() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getGemmenGakuInput().getTxtGemmenGakuInput();
    }

    @JsonIgnore
    public void setTxtGemmenGakuInput(TextBoxNum txtGemmenGakuInput) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().getGemmenGakuInput().setTxtGemmenGakuInput(txtGemmenGakuInput);
    }

    @JsonIgnore
    public Button getBtnApplyGemmenGaku() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getGemmenGakuInput().getBtnApplyGemmenGaku();
    }

    @JsonIgnore
    public void setBtnApplyGemmenGaku(Button btnApplyGemmenGaku) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().getGemmenGakuInput().setBtnApplyGemmenGaku(btnApplyGemmenGaku);
    }

    @JsonIgnore
    public SokujikouseiKiwarigakuDiv getSokujikouseiKiwarigaku() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiKiwarigaku();
    }

    @JsonIgnore
    public void setSokujikouseiKiwarigaku(SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setSokujikouseiKiwarigaku(SokujikouseiKiwarigaku);
    }

    @JsonIgnore
    public DataGrid<dgFuchoKanendo_Row> getDgFuchoKanendo() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getDgFuchoKanendo();
    }

    @JsonIgnore
    public void setDgFuchoKanendo(DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setDgFuchoKanendo(dgFuchoKanendo);
    }

    @JsonIgnore
    public SokujiKoseiTab2Div getSokujiKoseiTab2() {
        return this.getTabSokujiKousei().getSokujiKoseiTab2();
    }

    @JsonIgnore
    public void setSokujiKoseiTab2(SokujiKoseiTab2Div SokujiKoseiTab2) {
        this.getTabSokujiKousei().setSokujiKoseiTab2(SokujiKoseiTab2);
    }

    @JsonIgnore
    public SokujikouseiSanteinoKisoDiv getSokujikouseiSanteinoKiso() {
        return this.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso();
    }

    @JsonIgnore
    public void setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso) {
        this.getTabSokujiKousei().getSokujiKoseiTab2().setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKiso);
    }

    @JsonIgnore
    public SokujikouseiJiyuDiv getSokujikouseiJiyu() {
        return this.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiJiyu();
    }

    @JsonIgnore
    public void setSokujikouseiJiyu(SokujikouseiJiyuDiv SokujikouseiJiyu) {
        this.getTabSokujiKousei().getSokujiKoseiTab2().setSokujikouseiJiyu(SokujikouseiJiyu);
    }

    // </editor-fold>
}

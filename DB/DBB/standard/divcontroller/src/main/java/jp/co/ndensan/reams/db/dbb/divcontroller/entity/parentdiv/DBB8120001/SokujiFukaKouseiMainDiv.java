package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB8120001.dgFuchoKanendo_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SokujiFukaKouseiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujiFukaKouseiMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
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
    @JsonProperty("tabSokujiKousei")
    private tabSokujiKouseiDiv tabSokujiKousei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtChoteiYMD")
    public TextBoxDate getTxtChoteiYMD() {
        return txtChoteiYMD;
    }

    @JsonProperty("txtChoteiYMD")
    public void setTxtChoteiYMD(TextBoxDate txtChoteiYMD) {
        this.txtChoteiYMD=txtChoteiYMD;
    }

    @JsonProperty("ddlKoseiTsuki")
    public DropDownList getDdlKoseiTsuki() {
        return ddlKoseiTsuki;
    }

    @JsonProperty("ddlKoseiTsuki")
    public void setDdlKoseiTsuki(DropDownList ddlKoseiTsuki) {
        this.ddlKoseiTsuki=ddlKoseiTsuki;
    }

    @JsonProperty("tabSokujiKousei")
    public tabSokujiKouseiDiv getTabSokujiKousei() {
        return tabSokujiKousei;
    }

    @JsonProperty("tabSokujiKousei")
    public void setTabSokujiKousei(tabSokujiKouseiDiv tabSokujiKousei) {
        this.tabSokujiKousei=tabSokujiKousei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SokujiKoseiTab1Div getSokujiKoseiTab1() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1();
    }

    @JsonIgnore
    public void  setSokujiKoseiTab1(SokujiKoseiTab1Div SokujiKoseiTab1) {
        this.getTabSokujiKousei().setSokujiKoseiTab1(SokujiKoseiTab1);
    }

    @JsonIgnore
    public SokujikouseiFukakonkyoDiv getSokujikouseiFukakonkyo() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiFukakonkyo();
    }

    @JsonIgnore
    public void  setSokujikouseiFukakonkyo(SokujikouseiFukakonkyoDiv SokujikouseiFukakonkyo) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setSokujikouseiFukakonkyo(SokujikouseiFukakonkyo);
    }

    @JsonIgnore
    public SokujikouseiKiwarigakuDiv getSokujikouseiKiwarigaku() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getSokujikouseiKiwarigaku();
    }

    @JsonIgnore
    public void  setSokujikouseiKiwarigaku(SokujikouseiKiwarigakuDiv SokujikouseiKiwarigaku) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setSokujikouseiKiwarigaku(SokujikouseiKiwarigaku);
    }

    @JsonIgnore
    public DataGrid<dgFuchoKanendo_Row> getDgFuchoKanendo() {
        return this.getTabSokujiKousei().getSokujiKoseiTab1().getDgFuchoKanendo();
    }

    @JsonIgnore
    public void  setDgFuchoKanendo(DataGrid<dgFuchoKanendo_Row> dgFuchoKanendo) {
        this.getTabSokujiKousei().getSokujiKoseiTab1().setDgFuchoKanendo(dgFuchoKanendo);
    }

    @JsonIgnore
    public SokujiKoseiTab2Div getSokujiKoseiTab2() {
        return this.getTabSokujiKousei().getSokujiKoseiTab2();
    }

    @JsonIgnore
    public void  setSokujiKoseiTab2(SokujiKoseiTab2Div SokujiKoseiTab2) {
        this.getTabSokujiKousei().setSokujiKoseiTab2(SokujiKoseiTab2);
    }

    @JsonIgnore
    public SokujikouseiSanteinoKisoDiv getSokujikouseiSanteinoKiso() {
        return this.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiSanteinoKiso();
    }

    @JsonIgnore
    public void  setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKisoDiv SokujikouseiSanteinoKiso) {
        this.getTabSokujiKousei().getSokujiKoseiTab2().setSokujikouseiSanteinoKiso(SokujikouseiSanteinoKiso);
    }

    @JsonIgnore
    public SokujikouseiJiyuDiv getSokujikouseiJiyu() {
        return this.getTabSokujiKousei().getSokujiKoseiTab2().getSokujikouseiJiyu();
    }

    @JsonIgnore
    public void  setSokujikouseiJiyu(SokujikouseiJiyuDiv SokujikouseiJiyu) {
        this.getTabSokujiKousei().getSokujiKoseiTab2().setSokujikouseiJiyu(SokujikouseiJiyu);
    }

    // </editor-fold>
}

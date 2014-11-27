package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA4010013;
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
 * tbl のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TableCell1")
    private TableCell1Attbl TableCell1;
    @JsonProperty("TableCell2")
    private TableCell2Attbl TableCell2;
    @JsonProperty("TableCell3")
    private TableCell3Attbl TableCell3;
    @JsonProperty("TableCell7")
    private TableCell7Attbl TableCell7;
    @JsonProperty("TableCell8")
    private TableCell8Attbl TableCell8;
    @JsonProperty("TableCell9")
    private TableCell9Attbl TableCell9;
    @JsonProperty("TableCell10")
    private TableCell10Attbl TableCell10;
    @JsonProperty("TableCell15")
    private TableCell15Attbl TableCell15;
    @JsonProperty("TableCell4")
    private TableCell4Attbl TableCell4;
    @JsonProperty("TableCell5")
    private TableCell5Attbl TableCell5;
    @JsonProperty("TableCell6")
    private TableCell6Attbl TableCell6;
    @JsonProperty("TableCell11")
    private TableCell11Attbl TableCell11;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShutokuDate() {
        return this.TableCell1.getLblShutokuDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return this.TableCell1.getTxtShutokuDate();
    }

    @JsonIgnore
    public Label getLblShutokuTodokedeDate() {
        return this.TableCell2.getLblShutokuTodokedeDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate3() {
        return this.TableCell2.getTextBoxFlexibleDate3();
    }

    @JsonIgnore
    public Label getLblShutokuJiyu() {
        return this.TableCell3.getLblShutokuJiyu();
    }

    @JsonIgnore
    public DropDownList getDropDownList5() {
        return this.TableCell3.getDropDownList5();
    }

    @JsonIgnore
    public Label getLblHihokenshaKubun() {
        return this.TableCell7.getLblHihokenshaKubun();
    }

    @JsonIgnore
    public DropDownList getDropDownList4() {
        return this.TableCell7.getDropDownList4();
    }

    @JsonIgnore
    public Label getLblShutokuShozaiHokensha() {
        return this.TableCell8.getLblShutokuShozaiHokensha();
    }

    @JsonIgnore
    public DropDownList getDropDownList3() {
        return this.TableCell8.getDropDownList3();
    }

    @JsonIgnore
    public Label getLblShutokuSochimotoHokensha() {
        return this.TableCell9.getLblShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return this.TableCell9.getDdlShutokuSochimotoHokensha();
    }

    @JsonIgnore
    public Label getLblKyuHokensha() {
        return this.TableCell10.getLblKyuHokensha();
    }

    @JsonIgnore
    public DropDownList getDdlShutokuKyuHokensha() {
        return this.TableCell10.getDdlShutokuKyuHokensha();
    }

    @JsonIgnore
    public Label getLblShoriDate() {
        return this.TableCell15.getLblShoriDate();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate2() {
        return this.TableCell15.getTextBoxFlexibleDate2();
    }

    @JsonIgnore
    public Label getLabel5() {
        return this.TableCell4.getLabel5();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate4() {
        return this.TableCell4.getTextBoxFlexibleDate4();
    }

    @JsonIgnore
    public Label getLabel6() {
        return this.TableCell5.getLabel6();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate5() {
        return this.TableCell5.getTextBoxFlexibleDate5();
    }

    @JsonIgnore
    public Label getLabel7() {
        return this.TableCell6.getLabel7();
    }

    @JsonIgnore
    public DropDownList getDropDownList2() {
        return this.TableCell6.getDropDownList2();
    }

    @JsonIgnore
    public Label getLabel8() {
        return this.TableCell11.getLabel8();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTextBoxFlexibleDate6() {
        return this.TableCell11.getTextBoxFlexibleDate6();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TableCell1")
    private TableCell1Attbl getTableCell1() {
        return TableCell1;
    }

    @JsonProperty("TableCell1")
    private void setTableCell1(TableCell1Attbl TableCell1) {
        this.TableCell1=TableCell1;
    }

    @JsonProperty("TableCell2")
    private TableCell2Attbl getTableCell2() {
        return TableCell2;
    }

    @JsonProperty("TableCell2")
    private void setTableCell2(TableCell2Attbl TableCell2) {
        this.TableCell2=TableCell2;
    }

    @JsonProperty("TableCell3")
    private TableCell3Attbl getTableCell3() {
        return TableCell3;
    }

    @JsonProperty("TableCell3")
    private void setTableCell3(TableCell3Attbl TableCell3) {
        this.TableCell3=TableCell3;
    }

    @JsonProperty("TableCell7")
    private TableCell7Attbl getTableCell7() {
        return TableCell7;
    }

    @JsonProperty("TableCell7")
    private void setTableCell7(TableCell7Attbl TableCell7) {
        this.TableCell7=TableCell7;
    }

    @JsonProperty("TableCell8")
    private TableCell8Attbl getTableCell8() {
        return TableCell8;
    }

    @JsonProperty("TableCell8")
    private void setTableCell8(TableCell8Attbl TableCell8) {
        this.TableCell8=TableCell8;
    }

    @JsonProperty("TableCell9")
    private TableCell9Attbl getTableCell9() {
        return TableCell9;
    }

    @JsonProperty("TableCell9")
    private void setTableCell9(TableCell9Attbl TableCell9) {
        this.TableCell9=TableCell9;
    }

    @JsonProperty("TableCell10")
    private TableCell10Attbl getTableCell10() {
        return TableCell10;
    }

    @JsonProperty("TableCell10")
    private void setTableCell10(TableCell10Attbl TableCell10) {
        this.TableCell10=TableCell10;
    }

    @JsonProperty("TableCell15")
    private TableCell15Attbl getTableCell15() {
        return TableCell15;
    }

    @JsonProperty("TableCell15")
    private void setTableCell15(TableCell15Attbl TableCell15) {
        this.TableCell15=TableCell15;
    }

    @JsonProperty("TableCell4")
    private TableCell4Attbl getTableCell4() {
        return TableCell4;
    }

    @JsonProperty("TableCell4")
    private void setTableCell4(TableCell4Attbl TableCell4) {
        this.TableCell4=TableCell4;
    }

    @JsonProperty("TableCell5")
    private TableCell5Attbl getTableCell5() {
        return TableCell5;
    }

    @JsonProperty("TableCell5")
    private void setTableCell5(TableCell5Attbl TableCell5) {
        this.TableCell5=TableCell5;
    }

    @JsonProperty("TableCell6")
    private TableCell6Attbl getTableCell6() {
        return TableCell6;
    }

    @JsonProperty("TableCell6")
    private void setTableCell6(TableCell6Attbl TableCell6) {
        this.TableCell6=TableCell6;
    }

    @JsonProperty("TableCell11")
    private TableCell11Attbl getTableCell11() {
        return TableCell11;
    }

    @JsonProperty("TableCell11")
    private void setTableCell11(TableCell11Attbl TableCell11) {
        this.TableCell11=TableCell11;
    }

}
/**
 * TableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell1Attbl extends TableCell {
    @JsonProperty("lblShutokuDate")
    private Label lblShutokuDate;
    @JsonProperty("txtShutokuDate")
    private TextBoxFlexibleDate txtShutokuDate;

    @JsonProperty("lblShutokuDate")
    public Label getLblShutokuDate() {
        return lblShutokuDate;
    }

    @JsonProperty("lblShutokuDate")
    public void setLblShutokuDate(Label lblShutokuDate) {
        this.lblShutokuDate=lblShutokuDate;
    }

    @JsonProperty("txtShutokuDate")
    public TextBoxFlexibleDate getTxtShutokuDate() {
        return txtShutokuDate;
    }

    @JsonProperty("txtShutokuDate")
    public void setTxtShutokuDate(TextBoxFlexibleDate txtShutokuDate) {
        this.txtShutokuDate=txtShutokuDate;
    }

}
/**
 * TableCell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell2Attbl extends TableCell {
    @JsonProperty("lblShutokuTodokedeDate")
    private Label lblShutokuTodokedeDate;
    @JsonProperty("TextBoxFlexibleDate3")
    private TextBoxFlexibleDate TextBoxFlexibleDate3;

    @JsonProperty("lblShutokuTodokedeDate")
    public Label getLblShutokuTodokedeDate() {
        return lblShutokuTodokedeDate;
    }

    @JsonProperty("lblShutokuTodokedeDate")
    public void setLblShutokuTodokedeDate(Label lblShutokuTodokedeDate) {
        this.lblShutokuTodokedeDate=lblShutokuTodokedeDate;
    }

    @JsonProperty("TextBoxFlexibleDate3")
    public TextBoxFlexibleDate getTextBoxFlexibleDate3() {
        return TextBoxFlexibleDate3;
    }

    @JsonProperty("TextBoxFlexibleDate3")
    public void setTextBoxFlexibleDate3(TextBoxFlexibleDate TextBoxFlexibleDate3) {
        this.TextBoxFlexibleDate3=TextBoxFlexibleDate3;
    }

}
/**
 * TableCell3 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell3Attbl extends TableCell {
    @JsonProperty("lblShutokuJiyu")
    private Label lblShutokuJiyu;
    @JsonProperty("DropDownList5")
    private DropDownList DropDownList5;

    @JsonProperty("lblShutokuJiyu")
    public Label getLblShutokuJiyu() {
        return lblShutokuJiyu;
    }

    @JsonProperty("lblShutokuJiyu")
    public void setLblShutokuJiyu(Label lblShutokuJiyu) {
        this.lblShutokuJiyu=lblShutokuJiyu;
    }

    @JsonProperty("DropDownList5")
    public DropDownList getDropDownList5() {
        return DropDownList5;
    }

    @JsonProperty("DropDownList5")
    public void setDropDownList5(DropDownList DropDownList5) {
        this.DropDownList5=DropDownList5;
    }

}
/**
 * TableCell7 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell7Attbl extends TableCell {
    @JsonProperty("lblHihokenshaKubun")
    private Label lblHihokenshaKubun;
    @JsonProperty("DropDownList4")
    private DropDownList DropDownList4;

    @JsonProperty("lblHihokenshaKubun")
    public Label getLblHihokenshaKubun() {
        return lblHihokenshaKubun;
    }

    @JsonProperty("lblHihokenshaKubun")
    public void setLblHihokenshaKubun(Label lblHihokenshaKubun) {
        this.lblHihokenshaKubun=lblHihokenshaKubun;
    }

    @JsonProperty("DropDownList4")
    public DropDownList getDropDownList4() {
        return DropDownList4;
    }

    @JsonProperty("DropDownList4")
    public void setDropDownList4(DropDownList DropDownList4) {
        this.DropDownList4=DropDownList4;
    }

}
/**
 * TableCell8 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell8Attbl extends TableCell {
    @JsonProperty("lblShutokuShozaiHokensha")
    private Label lblShutokuShozaiHokensha;
    @JsonProperty("DropDownList3")
    private DropDownList DropDownList3;

    @JsonProperty("lblShutokuShozaiHokensha")
    public Label getLblShutokuShozaiHokensha() {
        return lblShutokuShozaiHokensha;
    }

    @JsonProperty("lblShutokuShozaiHokensha")
    public void setLblShutokuShozaiHokensha(Label lblShutokuShozaiHokensha) {
        this.lblShutokuShozaiHokensha=lblShutokuShozaiHokensha;
    }

    @JsonProperty("DropDownList3")
    public DropDownList getDropDownList3() {
        return DropDownList3;
    }

    @JsonProperty("DropDownList3")
    public void setDropDownList3(DropDownList DropDownList3) {
        this.DropDownList3=DropDownList3;
    }

}
/**
 * TableCell9 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell9Attbl extends TableCell {
    @JsonProperty("lblShutokuSochimotoHokensha")
    private Label lblShutokuSochimotoHokensha;
    @JsonProperty("ddlShutokuSochimotoHokensha")
    private DropDownList ddlShutokuSochimotoHokensha;

    @JsonProperty("lblShutokuSochimotoHokensha")
    public Label getLblShutokuSochimotoHokensha() {
        return lblShutokuSochimotoHokensha;
    }

    @JsonProperty("lblShutokuSochimotoHokensha")
    public void setLblShutokuSochimotoHokensha(Label lblShutokuSochimotoHokensha) {
        this.lblShutokuSochimotoHokensha=lblShutokuSochimotoHokensha;
    }

    @JsonProperty("ddlShutokuSochimotoHokensha")
    public DropDownList getDdlShutokuSochimotoHokensha() {
        return ddlShutokuSochimotoHokensha;
    }

    @JsonProperty("ddlShutokuSochimotoHokensha")
    public void setDdlShutokuSochimotoHokensha(DropDownList ddlShutokuSochimotoHokensha) {
        this.ddlShutokuSochimotoHokensha=ddlShutokuSochimotoHokensha;
    }

}
/**
 * TableCell10 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell10Attbl extends TableCell {
    @JsonProperty("lblKyuHokensha")
    private Label lblKyuHokensha;
    @JsonProperty("ddlShutokuKyuHokensha")
    private DropDownList ddlShutokuKyuHokensha;

    @JsonProperty("lblKyuHokensha")
    public Label getLblKyuHokensha() {
        return lblKyuHokensha;
    }

    @JsonProperty("lblKyuHokensha")
    public void setLblKyuHokensha(Label lblKyuHokensha) {
        this.lblKyuHokensha=lblKyuHokensha;
    }

    @JsonProperty("ddlShutokuKyuHokensha")
    public DropDownList getDdlShutokuKyuHokensha() {
        return ddlShutokuKyuHokensha;
    }

    @JsonProperty("ddlShutokuKyuHokensha")
    public void setDdlShutokuKyuHokensha(DropDownList ddlShutokuKyuHokensha) {
        this.ddlShutokuKyuHokensha=ddlShutokuKyuHokensha;
    }

}
/**
 * TableCell15 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell15Attbl extends TableCell {
    @JsonProperty("lblShoriDate")
    private Label lblShoriDate;
    @JsonProperty("TextBoxFlexibleDate2")
    private TextBoxFlexibleDate TextBoxFlexibleDate2;

    @JsonProperty("lblShoriDate")
    public Label getLblShoriDate() {
        return lblShoriDate;
    }

    @JsonProperty("lblShoriDate")
    public void setLblShoriDate(Label lblShoriDate) {
        this.lblShoriDate=lblShoriDate;
    }

    @JsonProperty("TextBoxFlexibleDate2")
    public TextBoxFlexibleDate getTextBoxFlexibleDate2() {
        return TextBoxFlexibleDate2;
    }

    @JsonProperty("TextBoxFlexibleDate2")
    public void setTextBoxFlexibleDate2(TextBoxFlexibleDate TextBoxFlexibleDate2) {
        this.TextBoxFlexibleDate2=TextBoxFlexibleDate2;
    }

}
/**
 * TableCell4 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell4Attbl extends TableCell {
    @JsonProperty("Label5")
    private Label Label5;
    @JsonProperty("TextBoxFlexibleDate4")
    private TextBoxFlexibleDate TextBoxFlexibleDate4;

    @JsonProperty("Label5")
    public Label getLabel5() {
        return Label5;
    }

    @JsonProperty("Label5")
    public void setLabel5(Label Label5) {
        this.Label5=Label5;
    }

    @JsonProperty("TextBoxFlexibleDate4")
    public TextBoxFlexibleDate getTextBoxFlexibleDate4() {
        return TextBoxFlexibleDate4;
    }

    @JsonProperty("TextBoxFlexibleDate4")
    public void setTextBoxFlexibleDate4(TextBoxFlexibleDate TextBoxFlexibleDate4) {
        this.TextBoxFlexibleDate4=TextBoxFlexibleDate4;
    }

}
/**
 * TableCell5 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell5Attbl extends TableCell {
    @JsonProperty("Label6")
    private Label Label6;
    @JsonProperty("TextBoxFlexibleDate5")
    private TextBoxFlexibleDate TextBoxFlexibleDate5;

    @JsonProperty("Label6")
    public Label getLabel6() {
        return Label6;
    }

    @JsonProperty("Label6")
    public void setLabel6(Label Label6) {
        this.Label6=Label6;
    }

    @JsonProperty("TextBoxFlexibleDate5")
    public TextBoxFlexibleDate getTextBoxFlexibleDate5() {
        return TextBoxFlexibleDate5;
    }

    @JsonProperty("TextBoxFlexibleDate5")
    public void setTextBoxFlexibleDate5(TextBoxFlexibleDate TextBoxFlexibleDate5) {
        this.TextBoxFlexibleDate5=TextBoxFlexibleDate5;
    }

}
/**
 * TableCell6 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell6Attbl extends TableCell {
    @JsonProperty("Label7")
    private Label Label7;
    @JsonProperty("DropDownList2")
    private DropDownList DropDownList2;

    @JsonProperty("Label7")
    public Label getLabel7() {
        return Label7;
    }

    @JsonProperty("Label7")
    public void setLabel7(Label Label7) {
        this.Label7=Label7;
    }

    @JsonProperty("DropDownList2")
    public DropDownList getDropDownList2() {
        return DropDownList2;
    }

    @JsonProperty("DropDownList2")
    public void setDropDownList2(DropDownList DropDownList2) {
        this.DropDownList2=DropDownList2;
    }

}
/**
 * TableCell11 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell11Attbl extends TableCell {
    @JsonProperty("Label8")
    private Label Label8;
    @JsonProperty("TextBoxFlexibleDate6")
    private TextBoxFlexibleDate TextBoxFlexibleDate6;

    @JsonProperty("Label8")
    public Label getLabel8() {
        return Label8;
    }

    @JsonProperty("Label8")
    public void setLabel8(Label Label8) {
        this.Label8=Label8;
    }

    @JsonProperty("TextBoxFlexibleDate6")
    public TextBoxFlexibleDate getTextBoxFlexibleDate6() {
        return TextBoxFlexibleDate6;
    }

    @JsonProperty("TextBoxFlexibleDate6")
    public void setTextBoxFlexibleDate6(TextBoxFlexibleDate TextBoxFlexibleDate6) {
        this.TextBoxFlexibleDate6=TextBoxFlexibleDate6;
    }

}

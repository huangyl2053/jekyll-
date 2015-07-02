package jp.co.ndensan.reams.db.dbe.divcontroller.entity.DBE2020003;
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
 * tblSearchCondition のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblSearchConditionDiv extends TablePanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celR1C1")
    private celR1C1AttblSearchCondition celR1C1;
    @JsonProperty("celR1C2")
    private celR1C2AttblSearchCondition celR1C2;
    @JsonProperty("celR2C1")
    private celR2C1AttblSearchCondition celR2C1;
    @JsonProperty("celR2C2")
    private celR2C2AttblSearchCondition celR2C2;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public RadioButton getRadKensakuTaisho() {
        return this.celR1C1.getRadKensakuTaisho();
    }

    @JsonIgnore
    public DropDownList getDdlHokensha() {
        return this.celR2C1.getDdlHokensha();
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.celR2C1.getTxtShimei();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiShinseiYMD() {
        return this.celR2C1.getTxtNinteiShinseiYMD();
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosaItakusaki() {
        return this.celR2C1.getDdlNinteiChosaItakusaki();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiChosaYMD() {
        return this.celR2C1.getTxtNinteiChosaYMD();
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.celR2C2.getTxtHihokenshaNo();
    }

    @JsonIgnore
    public TextBox getTxtShikibetsuCode() {
        return this.celR2C2.getTxtShikibetsuCode();
    }

    @JsonIgnore
    public TextBoxKana getTxtKanaShimei() {
        return this.celR2C2.getTxtKanaShimei();
    }

    @JsonIgnore
    public TextBoxDate getTxtBirthDay() {
        return this.celR2C2.getTxtBirthDay();
    }

    @JsonIgnore
    public TextBox getTxtMemo() {
        return this.celR2C2.getTxtMemo();
    }

    @JsonIgnore
    public DropDownList getDdlNinteiChosain() {
        return this.celR2C2.getDdlNinteiChosain();
    }

    @JsonIgnore
    public TextBox getTxtMaxRow() {
        return this.celR2C2.getTxtMaxRow();
    }

    @JsonIgnore
    public Button getBtnSearch() {
        return this.celR2C2.getBtnSearch();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celR1C1")
    private celR1C1AttblSearchCondition getCelR1C1() {
        return celR1C1;
    }

    @JsonProperty("celR1C1")
    private void setCelR1C1(celR1C1AttblSearchCondition celR1C1) {
        this.celR1C1=celR1C1;
    }

    @JsonProperty("celR1C2")
    private celR1C2AttblSearchCondition getCelR1C2() {
        return celR1C2;
    }

    @JsonProperty("celR1C2")
    private void setCelR1C2(celR1C2AttblSearchCondition celR1C2) {
        this.celR1C2=celR1C2;
    }

    @JsonProperty("celR2C1")
    private celR2C1AttblSearchCondition getCelR2C1() {
        return celR2C1;
    }

    @JsonProperty("celR2C1")
    private void setCelR2C1(celR2C1AttblSearchCondition celR2C1) {
        this.celR2C1=celR2C1;
    }

    @JsonProperty("celR2C2")
    private celR2C2AttblSearchCondition getCelR2C2() {
        return celR2C2;
    }

    @JsonProperty("celR2C2")
    private void setCelR2C2(celR2C2AttblSearchCondition celR2C2) {
        this.celR2C2=celR2C2;
    }

    // </editor-fold>
}
/**
 * celR1C1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR1C1AttblSearchCondition extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("radKensakuTaisho")
    private RadioButton radKensakuTaisho;

    @JsonProperty("radKensakuTaisho")
    public RadioButton getRadKensakuTaisho() {
        return radKensakuTaisho;
    }

    @JsonProperty("radKensakuTaisho")
    public void setRadKensakuTaisho(RadioButton radKensakuTaisho) {
        this.radKensakuTaisho=radKensakuTaisho;
    }

    // </editor-fold>
}
/**
 * celR1C2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR1C2AttblSearchCondition extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">

    // </editor-fold>
}
/**
 * celR2C1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR2C1AttblSearchCondition extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("ddlHokensha")
    private DropDownList ddlHokensha;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtNinteiShinseiYMD")
    private TextBoxDateRange txtNinteiShinseiYMD;
    @JsonProperty("ddlNinteiChosaItakusaki")
    private DropDownList ddlNinteiChosaItakusaki;
    @JsonProperty("txtNinteiChosaYMD")
    private TextBoxDateRange txtNinteiChosaYMD;

    @JsonProperty("ddlHokensha")
    public DropDownList getDdlHokensha() {
        return ddlHokensha;
    }

    @JsonProperty("ddlHokensha")
    public void setDdlHokensha(DropDownList ddlHokensha) {
        this.ddlHokensha=ddlHokensha;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtNinteiShinseiYMD")
    public TextBoxDateRange getTxtNinteiShinseiYMD() {
        return txtNinteiShinseiYMD;
    }

    @JsonProperty("txtNinteiShinseiYMD")
    public void setTxtNinteiShinseiYMD(TextBoxDateRange txtNinteiShinseiYMD) {
        this.txtNinteiShinseiYMD=txtNinteiShinseiYMD;
    }

    @JsonProperty("ddlNinteiChosaItakusaki")
    public DropDownList getDdlNinteiChosaItakusaki() {
        return ddlNinteiChosaItakusaki;
    }

    @JsonProperty("ddlNinteiChosaItakusaki")
    public void setDdlNinteiChosaItakusaki(DropDownList ddlNinteiChosaItakusaki) {
        this.ddlNinteiChosaItakusaki=ddlNinteiChosaItakusaki;
    }

    @JsonProperty("txtNinteiChosaYMD")
    public TextBoxDateRange getTxtNinteiChosaYMD() {
        return txtNinteiChosaYMD;
    }

    @JsonProperty("txtNinteiChosaYMD")
    public void setTxtNinteiChosaYMD(TextBoxDateRange txtNinteiChosaYMD) {
        this.txtNinteiChosaYMD=txtNinteiChosaYMD;
    }

    // </editor-fold>
}
/**
 * celR2C2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celR2C2AttblSearchCondition extends TableCell {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("txtShikibetsuCode")
    private TextBox txtShikibetsuCode;
    @JsonProperty("txtKanaShimei")
    private TextBoxKana txtKanaShimei;
    @JsonProperty("txtBirthDay")
    private TextBoxDate txtBirthDay;
    @JsonProperty("txtMemo")
    private TextBox txtMemo;
    @JsonProperty("ddlNinteiChosain")
    private DropDownList ddlNinteiChosain;
    @JsonProperty("txtMaxRow")
    private TextBox txtMaxRow;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo=txtHihokenshaNo;
    }

    @JsonProperty("txtShikibetsuCode")
    public TextBox getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.txtShikibetsuCode=txtShikibetsuCode;
    }

    @JsonProperty("txtKanaShimei")
    public TextBoxKana getTxtKanaShimei() {
        return txtKanaShimei;
    }

    @JsonProperty("txtKanaShimei")
    public void setTxtKanaShimei(TextBoxKana txtKanaShimei) {
        this.txtKanaShimei=txtKanaShimei;
    }

    @JsonProperty("txtBirthDay")
    public TextBoxDate getTxtBirthDay() {
        return txtBirthDay;
    }

    @JsonProperty("txtBirthDay")
    public void setTxtBirthDay(TextBoxDate txtBirthDay) {
        this.txtBirthDay=txtBirthDay;
    }

    @JsonProperty("txtMemo")
    public TextBox getTxtMemo() {
        return txtMemo;
    }

    @JsonProperty("txtMemo")
    public void setTxtMemo(TextBox txtMemo) {
        this.txtMemo=txtMemo;
    }

    @JsonProperty("ddlNinteiChosain")
    public DropDownList getDdlNinteiChosain() {
        return ddlNinteiChosain;
    }

    @JsonProperty("ddlNinteiChosain")
    public void setDdlNinteiChosain(DropDownList ddlNinteiChosain) {
        this.ddlNinteiChosain=ddlNinteiChosain;
    }

    @JsonProperty("txtMaxRow")
    public TextBox getTxtMaxRow() {
        return txtMaxRow;
    }

    @JsonProperty("txtMaxRow")
    public void setTxtMaxRow(TextBox txtMaxRow) {
        this.txtMaxRow=txtMaxRow;
    }

    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch=btnSearch;
    }

    // </editor-fold>
}

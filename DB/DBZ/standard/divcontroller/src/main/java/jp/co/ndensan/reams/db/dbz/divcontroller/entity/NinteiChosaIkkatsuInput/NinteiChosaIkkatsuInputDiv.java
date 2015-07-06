package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaIkkatsuInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiChosaIkkatsuInput.INinteiChosaIkkatsuInputDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaIkkatsuInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaIkkatsuInputDiv extends Panel implements INinteiChosaIkkatsuInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblJikanwaku1")
    private tblJikanwaku1Div tblJikanwaku1;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("tblJikanwaku2")
    private tblJikanwaku2Div tblJikanwaku2;
    @JsonProperty("chkDay")
    private CheckBoxList chkDay;
    @JsonProperty("chkUpdate")
    private CheckBoxList chkUpdate;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("btnUpdate")
    private Button btnUpdate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblJikanwaku1")
    public tblJikanwaku1Div getTblJikanwaku1() {
        return tblJikanwaku1;
    }

    @JsonProperty("tblJikanwaku1")
    public void setTblJikanwaku1(tblJikanwaku1Div tblJikanwaku1) {
        this.tblJikanwaku1=tblJikanwaku1;
    }

    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1=lin1;
    }

    @JsonProperty("tblJikanwaku2")
    public tblJikanwaku2Div getTblJikanwaku2() {
        return tblJikanwaku2;
    }

    @JsonProperty("tblJikanwaku2")
    public void setTblJikanwaku2(tblJikanwaku2Div tblJikanwaku2) {
        this.tblJikanwaku2=tblJikanwaku2;
    }

    @JsonProperty("chkDay")
    public CheckBoxList getChkDay() {
        return chkDay;
    }

    @JsonProperty("chkDay")
    public void setChkDay(CheckBoxList chkDay) {
        this.chkDay=chkDay;
    }

    @JsonProperty("chkUpdate")
    public CheckBoxList getChkUpdate() {
        return chkUpdate;
    }

    @JsonProperty("chkUpdate")
    public void setChkUpdate(CheckBoxList chkUpdate) {
        this.chkUpdate=chkUpdate;
    }

    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack=btnBack;
    }

    @JsonProperty("btnUpdate")
    public Button getBtnUpdate() {
        return btnUpdate;
    }

    @JsonProperty("btnUpdate")
    public void setBtnUpdate(Button btnUpdate) {
        this.btnUpdate=btnUpdate;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkJikanwaku1() {
        return this.getTblJikanwaku1().getChkJikanwaku1();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku2() {
        return this.getTblJikanwaku1().getChkJikanwaku2();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku3() {
        return this.getTblJikanwaku1().getChkJikanwaku3();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku4() {
        return this.getTblJikanwaku1().getChkJikanwaku4();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku5() {
        return this.getTblJikanwaku1().getChkJikanwaku5();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime1() {
        return this.getTblJikanwaku1().getTxtStartTime1();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime2() {
        return this.getTblJikanwaku1().getTxtStartTime2();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime3() {
        return this.getTblJikanwaku1().getTxtStartTime3();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime4() {
        return this.getTblJikanwaku1().getTxtStartTime4();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime5() {
        return this.getTblJikanwaku1().getTxtStartTime5();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime1() {
        return this.getTblJikanwaku1().getTxtEndTime1();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime2() {
        return this.getTblJikanwaku1().getTxtEndTime2();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime3() {
        return this.getTblJikanwaku1().getTxtEndTime3();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime4() {
        return this.getTblJikanwaku1().getTxtEndTime4();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime5() {
        return this.getTblJikanwaku1().getTxtEndTime5();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku6() {
        return this.getTblJikanwaku2().getChkJikanwaku6();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku7() {
        return this.getTblJikanwaku2().getChkJikanwaku7();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku8() {
        return this.getTblJikanwaku2().getChkJikanwaku8();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku9() {
        return this.getTblJikanwaku2().getChkJikanwaku9();
    }

    @JsonIgnore
    public CheckBoxList getChkJikanwaku10() {
        return this.getTblJikanwaku2().getChkJikanwaku10();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime6() {
        return this.getTblJikanwaku2().getTxtStartTime6();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime7() {
        return this.getTblJikanwaku2().getTxtStartTime7();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime8() {
        return this.getTblJikanwaku2().getTxtStartTime8();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime9() {
        return this.getTblJikanwaku2().getTxtStartTime9();
    }

    @JsonIgnore
    public TextBoxTime getTxtStartTime10() {
        return this.getTblJikanwaku2().getTxtStartTime10();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime6() {
        return this.getTblJikanwaku2().getTxtEndTime6();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime7() {
        return this.getTblJikanwaku2().getTxtEndTime7();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime8() {
        return this.getTblJikanwaku2().getTxtEndTime8();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime9() {
        return this.getTblJikanwaku2().getTxtEndTime9();
    }

    @JsonIgnore
    public TextBoxTime getTxtEndTime10() {
        return this.getTblJikanwaku2().getTxtEndTime10();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

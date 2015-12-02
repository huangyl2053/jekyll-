package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Shujii のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShujiiSearch")
    private ShujiiSearchDiv ShujiiSearch;
    @JsonProperty("Shujiilchiran")
    private ShujiilchiranDiv Shujiilchiran;
    @JsonProperty("ShujiiJoholnput")
    private ShujiiJoholnputDiv ShujiiJoholnput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShujiiSearch
     * @return ShujiiSearch
     */
    @JsonProperty("ShujiiSearch")
    public ShujiiSearchDiv getShujiiSearch() {
        return ShujiiSearch;
    }

    /*
     * setShujiiSearch
     * @param ShujiiSearch ShujiiSearch
     */
    @JsonProperty("ShujiiSearch")
    public void setShujiiSearch(ShujiiSearchDiv ShujiiSearch) {
        this.ShujiiSearch = ShujiiSearch;
    }

    /*
     * getShujiilchiran
     * @return Shujiilchiran
     */
    @JsonProperty("Shujiilchiran")
    public ShujiilchiranDiv getShujiilchiran() {
        return Shujiilchiran;
    }

    /*
     * setShujiilchiran
     * @param Shujiilchiran Shujiilchiran
     */
    @JsonProperty("Shujiilchiran")
    public void setShujiilchiran(ShujiilchiranDiv Shujiilchiran) {
        this.Shujiilchiran = Shujiilchiran;
    }

    /*
     * getShujiiJoholnput
     * @return ShujiiJoholnput
     */
    @JsonProperty("ShujiiJoholnput")
    public ShujiiJoholnputDiv getShujiiJoholnput() {
        return ShujiiJoholnput;
    }

    /*
     * setShujiiJoholnput
     * @param ShujiiJoholnput ShujiiJoholnput
     */
    @JsonProperty("ShujiiJoholnput")
    public void setShujiiJoholnput(ShujiiJoholnputDiv ShujiiJoholnput) {
        this.ShujiiJoholnput = ShujiiJoholnput;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDropDownList1() {
        return this.getShujiiSearch().getDropDownList1();
    }

    @JsonIgnore
    public void  setDropDownList1(DropDownList DropDownList1) {
        this.getShujiiSearch().setDropDownList1(DropDownList1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode1() {
        return this.getShujiiSearch().getTextBoxCode1();
    }

    @JsonIgnore
    public void  setTextBoxCode1(TextBoxCode TextBoxCode1) {
        this.getShujiiSearch().setTextBoxCode1(TextBoxCode1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode2() {
        return this.getShujiiSearch().getTextBoxCode2();
    }

    @JsonIgnore
    public void  setTextBoxCode2(TextBoxCode TextBoxCode2) {
        this.getShujiiSearch().setTextBoxCode2(TextBoxCode2);
    }

    @JsonIgnore
    public TextBox getTextBox1() {
        return this.getShujiiSearch().getTextBox1();
    }

    @JsonIgnore
    public void  setTextBox1(TextBox TextBox1) {
        this.getShujiiSearch().setTextBox1(TextBox1);
    }

    @JsonIgnore
    public TextBoxKana getTextBoxKana1() {
        return this.getShujiiSearch().getTextBoxKana1();
    }

    @JsonIgnore
    public void  setTextBoxKana1(TextBoxKana TextBoxKana1) {
        this.getShujiiSearch().setTextBoxKana1(TextBoxKana1);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode3() {
        return this.getShujiiSearch().getTextBoxCode3();
    }

    @JsonIgnore
    public void  setTextBoxCode3(TextBoxCode TextBoxCode3) {
        this.getShujiiSearch().setTextBoxCode3(TextBoxCode3);
    }

    @JsonIgnore
    public TextBoxCode getTextBoxCode4() {
        return this.getShujiiSearch().getTextBoxCode4();
    }

    @JsonIgnore
    public void  setTextBoxCode4(TextBoxCode TextBoxCode4) {
        this.getShujiiSearch().setTextBoxCode4(TextBoxCode4);
    }

    @JsonIgnore
    public TextBox getTextBox2() {
        return this.getShujiiSearch().getTextBox2();
    }

    @JsonIgnore
    public void  setTextBox2(TextBox TextBox2) {
        this.getShujiiSearch().setTextBox2(TextBox2);
    }

    @JsonIgnore
    public TextBoxKana getTextBoxKana2() {
        return this.getShujiiSearch().getTextBoxKana2();
    }

    @JsonIgnore
    public void  setTextBoxKana2(TextBoxKana TextBoxKana2) {
        this.getShujiiSearch().setTextBoxKana2(TextBoxKana2);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum1() {
        return this.getShujiiSearch().getTextBoxNum1();
    }

    @JsonIgnore
    public void  setTextBoxNum1(TextBoxNum TextBoxNum1) {
        this.getShujiiSearch().setTextBoxNum1(TextBoxNum1);
    }

    @JsonIgnore
    public RadioButton getRadioButton1() {
        return this.getShujiiSearch().getRadioButton1();
    }

    @JsonIgnore
    public void  setRadioButton1(RadioButton RadioButton1) {
        this.getShujiiSearch().setRadioButton1(RadioButton1);
    }

    @JsonIgnore
    public Button getButton1() {
        return this.getShujiiSearch().getButton1();
    }

    @JsonIgnore
    public void  setButton1(Button Button1) {
        this.getShujiiSearch().setButton1(Button1);
    }

    @JsonIgnore
    public Button getButton2() {
        return this.getShujiiSearch().getButton2();
    }

    @JsonIgnore
    public void  setButton2(Button Button2) {
        this.getShujiiSearch().setButton2(Button2);
    }

    @JsonIgnore
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return this.getShujiilchiran().getPanelBatchParameter1().getDataGrid1();
    }

    @JsonIgnore
    public void  setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.getShujiilchiran().getPanelBatchParameter1().setDataGrid1(DataGrid1);
    }

    // </editor-fold>
}

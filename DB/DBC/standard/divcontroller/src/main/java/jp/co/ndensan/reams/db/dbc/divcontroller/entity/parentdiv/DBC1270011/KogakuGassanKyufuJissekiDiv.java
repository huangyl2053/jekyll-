package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1270011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuGassanKyufuJisseki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KogakuGassanKyufuJissekiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HorizontalLine4")
    private HorizontalLine HorizontalLine4;
    @JsonProperty("KogakuGassanKyufuJissekiList")
    private KogakuGassanKyufuJissekiListDiv KogakuGassanKyufuJissekiList;
    @JsonProperty("KogakuGassanKyufuJissekiDetail")
    private KogakuGassanKyufuJissekiDetailDiv KogakuGassanKyufuJissekiDetail;
    @JsonProperty("KogakuGassanKyufuJissekiKaigoKihon")
    private KaigoShikakuKihonDiv KogakuGassanKyufuJissekiKaigoKihon;
    @JsonProperty("KogakuGassanKyufuJissekiKihon")
    private KaigoAtenaInfoDiv KogakuGassanKyufuJissekiKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHorizontalLine4
     * @return HorizontalLine4
     */
    @JsonProperty("HorizontalLine4")
    public HorizontalLine getHorizontalLine4() {
        return HorizontalLine4;
    }

    /*
     * setHorizontalLine4
     * @param HorizontalLine4 HorizontalLine4
     */
    @JsonProperty("HorizontalLine4")
    public void setHorizontalLine4(HorizontalLine HorizontalLine4) {
        this.HorizontalLine4 = HorizontalLine4;
    }

    /*
     * getKogakuGassanKyufuJissekiList
     * @return KogakuGassanKyufuJissekiList
     */
    @JsonProperty("KogakuGassanKyufuJissekiList")
    public KogakuGassanKyufuJissekiListDiv getKogakuGassanKyufuJissekiList() {
        return KogakuGassanKyufuJissekiList;
    }

    /*
     * setKogakuGassanKyufuJissekiList
     * @param KogakuGassanKyufuJissekiList KogakuGassanKyufuJissekiList
     */
    @JsonProperty("KogakuGassanKyufuJissekiList")
    public void setKogakuGassanKyufuJissekiList(KogakuGassanKyufuJissekiListDiv KogakuGassanKyufuJissekiList) {
        this.KogakuGassanKyufuJissekiList = KogakuGassanKyufuJissekiList;
    }

    /*
     * getKogakuGassanKyufuJissekiDetail
     * @return KogakuGassanKyufuJissekiDetail
     */
    @JsonProperty("KogakuGassanKyufuJissekiDetail")
    public KogakuGassanKyufuJissekiDetailDiv getKogakuGassanKyufuJissekiDetail() {
        return KogakuGassanKyufuJissekiDetail;
    }

    /*
     * setKogakuGassanKyufuJissekiDetail
     * @param KogakuGassanKyufuJissekiDetail KogakuGassanKyufuJissekiDetail
     */
    @JsonProperty("KogakuGassanKyufuJissekiDetail")
    public void setKogakuGassanKyufuJissekiDetail(KogakuGassanKyufuJissekiDetailDiv KogakuGassanKyufuJissekiDetail) {
        this.KogakuGassanKyufuJissekiDetail = KogakuGassanKyufuJissekiDetail;
    }

    /*
     * getKogakuGassanKyufuJissekiKaigoKihon
     * @return KogakuGassanKyufuJissekiKaigoKihon
     */
    @JsonProperty("KogakuGassanKyufuJissekiKaigoKihon")
    public IKaigoShikakuKihonDiv getKogakuGassanKyufuJissekiKaigoKihon() {
        return KogakuGassanKyufuJissekiKaigoKihon;
    }

    /*
     * getKogakuGassanKyufuJissekiKihon
     * @return KogakuGassanKyufuJissekiKihon
     */
    @JsonProperty("KogakuGassanKyufuJissekiKihon")
    public IKaigoAtenaInfoDiv getKogakuGassanKyufuJissekiKihon() {
        return KogakuGassanKyufuJissekiKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getCheckBoxList1() {
        return this.getKogakuGassanKyufuJissekiList().getCheckBoxList1();
    }

    @JsonIgnore
    public void  setCheckBoxList1(CheckBoxList CheckBoxList1) {
        this.getKogakuGassanKyufuJissekiList().setCheckBoxList1(CheckBoxList1);
    }

    @JsonIgnore
    public DataGrid<DataGrid1_Row> getDataGrid1() {
        return this.getKogakuGassanKyufuJissekiList().getDataGrid1();
    }

    @JsonIgnore
    public void  setDataGrid1(DataGrid<DataGrid1_Row> DataGrid1) {
        this.getKogakuGassanKyufuJissekiList().setDataGrid1(DataGrid1);
    }

    @JsonIgnore
    public TextBox getTextBox1() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBox1();
    }

    @JsonIgnore
    public void  setTextBox1(TextBox TextBox1) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBox1(TextBox1);
    }

    @JsonIgnore
    public TextBox getTextBox6() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBox6();
    }

    @JsonIgnore
    public void  setTextBox6(TextBox TextBox6) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBox6(TextBox6);
    }

    @JsonIgnore
    public TextBox getTextBox5() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBox5();
    }

    @JsonIgnore
    public void  setTextBox5(TextBox TextBox5) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBox5(TextBox5);
    }

    @JsonIgnore
    public TextBox getTextBox4() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBox4();
    }

    @JsonIgnore
    public void  setTextBox4(TextBox TextBox4) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBox4(TextBox4);
    }

    @JsonIgnore
    public TextBox getTextBox3() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBox3();
    }

    @JsonIgnore
    public void  setTextBox3(TextBox TextBox3) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBox3(TextBox3);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate1() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxDate1();
    }

    @JsonIgnore
    public void  setTextBoxDate1(TextBoxDate TextBoxDate1) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxDate1(TextBoxDate1);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate3() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxDate3();
    }

    @JsonIgnore
    public void  setTextBoxDate3(TextBoxDate TextBoxDate3) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxDate3(TextBoxDate3);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum1() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxNum1();
    }

    @JsonIgnore
    public void  setTextBoxNum1(TextBoxNum TextBoxNum1) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxNum1(TextBoxNum1);
    }

    @JsonIgnore
    public TextBoxNum getTextBoxNum3() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxNum3();
    }

    @JsonIgnore
    public void  setTextBoxNum3(TextBoxNum TextBoxNum3) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxNum3(TextBoxNum3);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate6() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxDate6();
    }

    @JsonIgnore
    public void  setTextBoxDate6(TextBoxDate TextBoxDate6) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxDate6(TextBoxDate6);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate5() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxDate5();
    }

    @JsonIgnore
    public void  setTextBoxDate5(TextBoxDate TextBoxDate5) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxDate5(TextBoxDate5);
    }

    @JsonIgnore
    public TextBoxDate getTextBoxDate4() {
        return this.getKogakuGassanKyufuJissekiDetail().getTextBoxDate4();
    }

    @JsonIgnore
    public void  setTextBoxDate4(TextBoxDate TextBoxDate4) {
        this.getKogakuGassanKyufuJissekiDetail().setTextBoxDate4(TextBoxDate4);
    }

    @JsonIgnore
    public HorizontalLine getHorizontalLine5() {
        return this.getKogakuGassanKyufuJissekiDetail().getHorizontalLine5();
    }

    @JsonIgnore
    public void  setHorizontalLine5(HorizontalLine HorizontalLine5) {
        this.getKogakuGassanKyufuJissekiDetail().setHorizontalLine5(HorizontalLine5);
    }

    @JsonIgnore
    public Button getButton6() {
        return this.getKogakuGassanKyufuJissekiDetail().getButton6();
    }

    @JsonIgnore
    public void  setButton6(Button Button6) {
        this.getKogakuGassanKyufuJissekiDetail().setButton6(Button6);
    }

    // </editor-fold>
}

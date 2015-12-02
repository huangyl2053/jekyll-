package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoToiawasesaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoToiawasesakiDiv extends Panel implements IKaigoToiawasesakiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ToiawasesakiControl")
    private ToiawasesakiControlDiv ToiawasesakiControl;
    @JsonProperty("ToiawasesakiShosai")
    private ToiawasesakiShosaiDiv ToiawasesakiShosai;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;
    @JsonProperty("hdnChohyoBunruiID")
    private RString hdnChohyoBunruiID;
    @JsonProperty("hdnChohyoDokujiToiawasesakiUmu")
    private RString hdnChohyoDokujiToiawasesakiUmu;
    @JsonProperty("hdnSelectToiawasesaki")
    private RString hdnSelectToiawasesaki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getToiawasesakiControl
     * @return ToiawasesakiControl
     */
    @JsonProperty("ToiawasesakiControl")
    public ToiawasesakiControlDiv getToiawasesakiControl() {
        return ToiawasesakiControl;
    }

    /*
     * setToiawasesakiControl
     * @param ToiawasesakiControl ToiawasesakiControl
     */
    @JsonProperty("ToiawasesakiControl")
    public void setToiawasesakiControl(ToiawasesakiControlDiv ToiawasesakiControl) {
        this.ToiawasesakiControl = ToiawasesakiControl;
    }

    /*
     * getToiawasesakiShosai
     * @return ToiawasesakiShosai
     */
    @JsonProperty("ToiawasesakiShosai")
    public ToiawasesakiShosaiDiv getToiawasesakiShosai() {
        return ToiawasesakiShosai;
    }

    /*
     * setToiawasesakiShosai
     * @param ToiawasesakiShosai ToiawasesakiShosai
     */
    @JsonProperty("ToiawasesakiShosai")
    public void setToiawasesakiShosai(ToiawasesakiShosaiDiv ToiawasesakiShosai) {
        this.ToiawasesakiShosai = ToiawasesakiShosai;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * gethdnSubGyomuCode
     * @return hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    /*
     * sethdnSubGyomuCode
     * @param hdnSubGyomuCode hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode = hdnSubGyomuCode;
    }

    /*
     * gethdnChohyoBunruiID
     * @return hdnChohyoBunruiID
     */
    @JsonProperty("hdnChohyoBunruiID")
    public RString getHdnChohyoBunruiID() {
        return hdnChohyoBunruiID;
    }

    /*
     * sethdnChohyoBunruiID
     * @param hdnChohyoBunruiID hdnChohyoBunruiID
     */
    @JsonProperty("hdnChohyoBunruiID")
    public void setHdnChohyoBunruiID(RString hdnChohyoBunruiID) {
        this.hdnChohyoBunruiID = hdnChohyoBunruiID;
    }

    /*
     * gethdnChohyoDokujiToiawasesakiUmu
     * @return hdnChohyoDokujiToiawasesakiUmu
     */
    @JsonProperty("hdnChohyoDokujiToiawasesakiUmu")
    public RString getHdnChohyoDokujiToiawasesakiUmu() {
        return hdnChohyoDokujiToiawasesakiUmu;
    }

    /*
     * sethdnChohyoDokujiToiawasesakiUmu
     * @param hdnChohyoDokujiToiawasesakiUmu hdnChohyoDokujiToiawasesakiUmu
     */
    @JsonProperty("hdnChohyoDokujiToiawasesakiUmu")
    public void setHdnChohyoDokujiToiawasesakiUmu(RString hdnChohyoDokujiToiawasesakiUmu) {
        this.hdnChohyoDokujiToiawasesakiUmu = hdnChohyoDokujiToiawasesakiUmu;
    }

    /*
     * gethdnSelectToiawasesaki
     * @return hdnSelectToiawasesaki
     */
    @JsonProperty("hdnSelectToiawasesaki")
    public RString getHdnSelectToiawasesaki() {
        return hdnSelectToiawasesaki;
    }

    /*
     * sethdnSelectToiawasesaki
     * @param hdnSelectToiawasesaki hdnSelectToiawasesaki
     */
    @JsonProperty("hdnSelectToiawasesaki")
    public void setHdnSelectToiawasesaki(RString hdnSelectToiawasesaki) {
        this.hdnSelectToiawasesaki = hdnSelectToiawasesaki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddChohyoDokuji() {
        return this.getToiawasesakiControl().getBtnAddChohyoDokuji();
    }

    @JsonIgnore
    public void  setBtnAddChohyoDokuji(Button btnAddChohyoDokuji) {
        this.getToiawasesakiControl().setBtnAddChohyoDokuji(btnAddChohyoDokuji);
    }

    @JsonIgnore
    public DataGrid<dgToiawasesakiControl_Row> getDgToiawasesakiControl() {
        return this.getToiawasesakiControl().getDgToiawasesakiControl();
    }

    @JsonIgnore
    public void  setDgToiawasesakiControl(DataGrid<dgToiawasesakiControl_Row> dgToiawasesakiControl) {
        this.getToiawasesakiControl().setDgToiawasesakiControl(dgToiawasesakiControl);
    }

    @JsonIgnore
    public Label getLblHensyuTaisho() {
        return this.getToiawasesakiShosai().getLblHensyuTaisho();
    }

    @JsonIgnore
    public void  setLblHensyuTaisho(Label lblHensyuTaisho) {
        this.getToiawasesakiShosai().setLblHensyuTaisho(lblHensyuTaisho);
    }

    @JsonIgnore
    public Detail1Div getDetail1() {
        return this.getToiawasesakiShosai().getDetail1();
    }

    @JsonIgnore
    public void  setDetail1(Detail1Div Detail1) {
        this.getToiawasesakiShosai().setDetail1(Detail1);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getToiawasesakiShosai().getDetail1().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getToiawasesakiShosai().getDetail1().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShozaichi() {
        return this.getToiawasesakiShosai().getDetail1().getTxtShozaichi();
    }

    @JsonIgnore
    public void  setTxtShozaichi(TextBoxMultiLine txtShozaichi) {
        this.getToiawasesakiShosai().getDetail1().setTxtShozaichi(txtShozaichi);
    }

    @JsonIgnore
    public TextBox getTxtChoshaName() {
        return this.getToiawasesakiShosai().getDetail1().getTxtChoshaName();
    }

    @JsonIgnore
    public void  setTxtChoshaName(TextBox txtChoshaName) {
        this.getToiawasesakiShosai().getDetail1().setTxtChoshaName(txtChoshaName);
    }

    @JsonIgnore
    public Detail2Div getDetail2() {
        return this.getToiawasesakiShosai().getDetail2();
    }

    @JsonIgnore
    public void  setDetail2(Detail2Div Detail2) {
        this.getToiawasesakiShosai().setDetail2(Detail2);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getToiawasesakiShosai().getDetail2().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getToiawasesakiShosai().getDetail2().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBox getTxtNaisenNo() {
        return this.getToiawasesakiShosai().getDetail2().getTxtNaisenNo();
    }

    @JsonIgnore
    public void  setTxtNaisenNo(TextBox txtNaisenNo) {
        this.getToiawasesakiShosai().getDetail2().setTxtNaisenNo(txtNaisenNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBushoName() {
        return this.getToiawasesakiShosai().getDetail2().getTxtBushoName();
    }

    @JsonIgnore
    public void  setTxtBushoName(TextBoxMultiLine txtBushoName) {
        this.getToiawasesakiShosai().getDetail2().setTxtBushoName(txtBushoName);
    }

    @JsonIgnore
    public TextBox getTxtTantoshaName() {
        return this.getToiawasesakiShosai().getDetail2().getTxtTantoshaName();
    }

    @JsonIgnore
    public void  setTxtTantoshaName(TextBox txtTantoshaName) {
        this.getToiawasesakiShosai().getDetail2().setTxtTantoshaName(txtTantoshaName);
    }

    @JsonIgnore
    public HorizontalLine getLine1() {
        return this.getToiawasesakiShosai().getLine1();
    }

    @JsonIgnore
    public void  setLine1(HorizontalLine line1) {
        this.getToiawasesakiShosai().setLine1(line1);
    }

    @JsonIgnore
    public Button getBtnDecide() {
        return this.getToiawasesakiShosai().getBtnDecide();
    }

    @JsonIgnore
    public void  setBtnDecide(Button btnDecide) {
        this.getToiawasesakiShosai().setBtnDecide(btnDecide);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getToiawasesakiShosai().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getToiawasesakiShosai().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

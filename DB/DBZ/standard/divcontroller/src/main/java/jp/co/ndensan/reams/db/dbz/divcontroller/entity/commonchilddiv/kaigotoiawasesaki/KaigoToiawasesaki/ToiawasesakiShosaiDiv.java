package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigotoiawasesaki.KaigoToiawasesaki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ToiawasesakiShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ToiawasesakiShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHensyuTaisho")
    private Label lblHensyuTaisho;
    @JsonProperty("Detail1")
    private Detail1Div Detail1;
    @JsonProperty("Detail2")
    private Detail2Div Detail2;
    @JsonProperty("line1")
    private HorizontalLine line1;
    @JsonProperty("btnDecide")
    private Button btnDecide;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHensyuTaisho
     * @return lblHensyuTaisho
     */
    @JsonProperty("lblHensyuTaisho")
    public Label getLblHensyuTaisho() {
        return lblHensyuTaisho;
    }

    /*
     * setlblHensyuTaisho
     * @param lblHensyuTaisho lblHensyuTaisho
     */
    @JsonProperty("lblHensyuTaisho")
    public void setLblHensyuTaisho(Label lblHensyuTaisho) {
        this.lblHensyuTaisho = lblHensyuTaisho;
    }

    /*
     * getDetail1
     * @return Detail1
     */
    @JsonProperty("Detail1")
    public Detail1Div getDetail1() {
        return Detail1;
    }

    /*
     * setDetail1
     * @param Detail1 Detail1
     */
    @JsonProperty("Detail1")
    public void setDetail1(Detail1Div Detail1) {
        this.Detail1 = Detail1;
    }

    /*
     * getDetail2
     * @return Detail2
     */
    @JsonProperty("Detail2")
    public Detail2Div getDetail2() {
        return Detail2;
    }

    /*
     * setDetail2
     * @param Detail2 Detail2
     */
    @JsonProperty("Detail2")
    public void setDetail2(Detail2Div Detail2) {
        this.Detail2 = Detail2;
    }

    /*
     * getline1
     * @return line1
     */
    @JsonProperty("line1")
    public HorizontalLine getLine1() {
        return line1;
    }

    /*
     * setline1
     * @param line1 line1
     */
    @JsonProperty("line1")
    public void setLine1(HorizontalLine line1) {
        this.line1 = line1;
    }

    /*
     * getbtnDecide
     * @return btnDecide
     */
    @JsonProperty("btnDecide")
    public Button getBtnDecide() {
        return btnDecide;
    }

    /*
     * setbtnDecide
     * @param btnDecide btnDecide
     */
    @JsonProperty("btnDecide")
    public void setBtnDecide(Button btnDecide) {
        this.btnDecide = btnDecide;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getDetail1().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getDetail1().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShozaichi() {
        return this.getDetail1().getTxtShozaichi();
    }

    @JsonIgnore
    public void  setTxtShozaichi(TextBoxMultiLine txtShozaichi) {
        this.getDetail1().setTxtShozaichi(txtShozaichi);
    }

    @JsonIgnore
    public TextBox getTxtChoshaName() {
        return this.getDetail1().getTxtChoshaName();
    }

    @JsonIgnore
    public void  setTxtChoshaName(TextBox txtChoshaName) {
        this.getDetail1().setTxtChoshaName(txtChoshaName);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getDetail2().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getDetail2().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public TextBox getTxtNaisenNo() {
        return this.getDetail2().getTxtNaisenNo();
    }

    @JsonIgnore
    public void  setTxtNaisenNo(TextBox txtNaisenNo) {
        this.getDetail2().setTxtNaisenNo(txtNaisenNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBushoName() {
        return this.getDetail2().getTxtBushoName();
    }

    @JsonIgnore
    public void  setTxtBushoName(TextBoxMultiLine txtBushoName) {
        this.getDetail2().setTxtBushoName(txtBushoName);
    }

    @JsonIgnore
    public TextBox getTxtTantoshaName() {
        return this.getDetail2().getTxtTantoshaName();
    }

    @JsonIgnore
    public void  setTxtTantoshaName(TextBox txtTantoshaName) {
        this.getDetail2().setTxtTantoshaName(txtTantoshaName);
    }

    // </editor-fold>
}

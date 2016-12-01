package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShichoson")
    private TextBoxCode txtShichoson;
    @JsonProperty("btnToSearchShichoson")
    private ButtonDialog btnToSearchShichoson;
    @JsonProperty("txtShichosonmei")
    private TextBox txtShichosonmei;
    @JsonProperty("txtShichosonShokibetsuID")
    private TextBox txtShichosonShokibetsuID;
    @JsonProperty("txtShujiiIryoKikanCode")
    private TextBoxCode txtShujiiIryoKikanCode;
    @JsonProperty("btnToSearchIryoKikan")
    private ButtonDialog btnToSearchIryoKikan;
    @JsonProperty("txtShujiiIryoKikanMei")
    private TextBox txtShujiiIryoKikanMei;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("txtShujiiShimei")
    private TextBox txtShujiiShimei;
    @JsonProperty("txtShujiiKanaShimei")
    private TextBoxKana txtShujiiKanaShimei;
    @JsonProperty("radSeibetsu")
    private RadioButton radSeibetsu;
    @JsonProperty("radShiteiiFlag")
    private RadioButton radShiteiiFlag;
    @JsonProperty("txtShinryokaMei")
    private TextBox txtShinryokaMei;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtFaxNo")
    private TextBoxTelNo txtFaxNo;
    @JsonProperty("radJokyoFlag")
    private RadioButton radJokyoFlag;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("state")
    private RString state;
    @JsonProperty("hiddenInputDiv")
    private RString hiddenInputDiv;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShichoson
     * @return txtShichoson
     */
    @JsonProperty("txtShichoson")
    public TextBoxCode getTxtShichoson() {
        return txtShichoson;
    }

    /*
     * settxtShichoson
     * @param txtShichoson txtShichoson
     */
    @JsonProperty("txtShichoson")
    public void setTxtShichoson(TextBoxCode txtShichoson) {
        this.txtShichoson = txtShichoson;
    }

    /*
     * getbtnToSearchShichoson
     * @return btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public ButtonDialog getBtnToSearchShichoson() {
        return btnToSearchShichoson;
    }

    /*
     * setbtnToSearchShichoson
     * @param btnToSearchShichoson btnToSearchShichoson
     */
    @JsonProperty("btnToSearchShichoson")
    public void setBtnToSearchShichoson(ButtonDialog btnToSearchShichoson) {
        this.btnToSearchShichoson = btnToSearchShichoson;
    }

    /*
     * gettxtShichosonmei
     * @return txtShichosonmei
     */
    @JsonProperty("txtShichosonmei")
    public TextBox getTxtShichosonmei() {
        return txtShichosonmei;
    }

    /*
     * settxtShichosonmei
     * @param txtShichosonmei txtShichosonmei
     */
    @JsonProperty("txtShichosonmei")
    public void setTxtShichosonmei(TextBox txtShichosonmei) {
        this.txtShichosonmei = txtShichosonmei;
    }

    /*
     * gettxtShichosonShokibetsuID
     * @return txtShichosonShokibetsuID
     */
    @JsonProperty("txtShichosonShokibetsuID")
    public TextBox getTxtShichosonShokibetsuID() {
        return txtShichosonShokibetsuID;
    }

    /*
     * settxtShichosonShokibetsuID
     * @param txtShichosonShokibetsuID txtShichosonShokibetsuID
     */
    @JsonProperty("txtShichosonShokibetsuID")
    public void setTxtShichosonShokibetsuID(TextBox txtShichosonShokibetsuID) {
        this.txtShichosonShokibetsuID = txtShichosonShokibetsuID;
    }

    /*
     * gettxtShujiiIryoKikanCode
     * @return txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public TextBoxCode getTxtShujiiIryoKikanCode() {
        return txtShujiiIryoKikanCode;
    }

    /*
     * settxtShujiiIryoKikanCode
     * @param txtShujiiIryoKikanCode txtShujiiIryoKikanCode
     */
    @JsonProperty("txtShujiiIryoKikanCode")
    public void setTxtShujiiIryoKikanCode(TextBoxCode txtShujiiIryoKikanCode) {
        this.txtShujiiIryoKikanCode = txtShujiiIryoKikanCode;
    }

    /*
     * getbtnToSearchIryoKikan
     * @return btnToSearchIryoKikan
     */
    @JsonProperty("btnToSearchIryoKikan")
    public ButtonDialog getBtnToSearchIryoKikan() {
        return btnToSearchIryoKikan;
    }

    /*
     * setbtnToSearchIryoKikan
     * @param btnToSearchIryoKikan btnToSearchIryoKikan
     */
    @JsonProperty("btnToSearchIryoKikan")
    public void setBtnToSearchIryoKikan(ButtonDialog btnToSearchIryoKikan) {
        this.btnToSearchIryoKikan = btnToSearchIryoKikan;
    }

    /*
     * gettxtShujiiIryoKikanMei
     * @return txtShujiiIryoKikanMei
     */
    @JsonProperty("txtShujiiIryoKikanMei")
    public TextBox getTxtShujiiIryoKikanMei() {
        return txtShujiiIryoKikanMei;
    }

    /*
     * settxtShujiiIryoKikanMei
     * @param txtShujiiIryoKikanMei txtShujiiIryoKikanMei
     */
    @JsonProperty("txtShujiiIryoKikanMei")
    public void setTxtShujiiIryoKikanMei(TextBox txtShujiiIryoKikanMei) {
        this.txtShujiiIryoKikanMei = txtShujiiIryoKikanMei;
    }

    /*
     * gettxtShujiiCode
     * @return txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    /*
     * settxtShujiiCode
     * @param txtShujiiCode txtShujiiCode
     */
    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode = txtShujiiCode;
    }

    /*
     * gettxtShujiiShimei
     * @return txtShujiiShimei
     */
    @JsonProperty("txtShujiiShimei")
    public TextBox getTxtShujiiShimei() {
        return txtShujiiShimei;
    }

    /*
     * settxtShujiiShimei
     * @param txtShujiiShimei txtShujiiShimei
     */
    @JsonProperty("txtShujiiShimei")
    public void setTxtShujiiShimei(TextBox txtShujiiShimei) {
        this.txtShujiiShimei = txtShujiiShimei;
    }

    /*
     * gettxtShujiiKanaShimei
     * @return txtShujiiKanaShimei
     */
    @JsonProperty("txtShujiiKanaShimei")
    public TextBoxKana getTxtShujiiKanaShimei() {
        return txtShujiiKanaShimei;
    }

    /*
     * settxtShujiiKanaShimei
     * @param txtShujiiKanaShimei txtShujiiKanaShimei
     */
    @JsonProperty("txtShujiiKanaShimei")
    public void setTxtShujiiKanaShimei(TextBoxKana txtShujiiKanaShimei) {
        this.txtShujiiKanaShimei = txtShujiiKanaShimei;
    }

    /*
     * getradSeibetsu
     * @return radSeibetsu
     */
    @JsonProperty("radSeibetsu")
    public RadioButton getRadSeibetsu() {
        return radSeibetsu;
    }

    /*
     * setradSeibetsu
     * @param radSeibetsu radSeibetsu
     */
    @JsonProperty("radSeibetsu")
    public void setRadSeibetsu(RadioButton radSeibetsu) {
        this.radSeibetsu = radSeibetsu;
    }

    /*
     * getradShiteiiFlag
     * @return radShiteiiFlag
     */
    @JsonProperty("radShiteiiFlag")
    public RadioButton getRadShiteiiFlag() {
        return radShiteiiFlag;
    }

    /*
     * setradShiteiiFlag
     * @param radShiteiiFlag radShiteiiFlag
     */
    @JsonProperty("radShiteiiFlag")
    public void setRadShiteiiFlag(RadioButton radShiteiiFlag) {
        this.radShiteiiFlag = radShiteiiFlag;
    }

    /*
     * gettxtShinryokaMei
     * @return txtShinryokaMei
     */
    @JsonProperty("txtShinryokaMei")
    public TextBox getTxtShinryokaMei() {
        return txtShinryokaMei;
    }

    /*
     * settxtShinryokaMei
     * @param txtShinryokaMei txtShinryokaMei
     */
    @JsonProperty("txtShinryokaMei")
    public void setTxtShinryokaMei(TextBox txtShinryokaMei) {
        this.txtShinryokaMei = txtShinryokaMei;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtJusho
     * @return txtJusho
     */
    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    /*
     * settxtJusho
     * @param txtJusho txtJusho
     */
    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho = txtJusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtFaxNo
     * @return txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public TextBoxTelNo getTxtFaxNo() {
        return txtFaxNo;
    }

    /*
     * settxtFaxNo
     * @param txtFaxNo txtFaxNo
     */
    @JsonProperty("txtFaxNo")
    public void setTxtFaxNo(TextBoxTelNo txtFaxNo) {
        this.txtFaxNo = txtFaxNo;
    }

    /*
     * getradJokyoFlag
     * @return radJokyoFlag
     */
    @JsonProperty("radJokyoFlag")
    public RadioButton getRadJokyoFlag() {
        return radJokyoFlag;
    }

    /*
     * setradJokyoFlag
     * @param radJokyoFlag radJokyoFlag
     */
    @JsonProperty("radJokyoFlag")
    public void setRadJokyoFlag(RadioButton radJokyoFlag) {
        this.radJokyoFlag = radJokyoFlag;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getstate
     * @return state
     */
    @JsonProperty("state")
    public RString getState() {
        return state;
    }

    /*
     * setstate
     * @param state state
     */
    @JsonProperty("state")
    public void setState(RString state) {
        this.state = state;
    }

    /*
     * gethiddenInputDiv
     * @return hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public RString getHiddenInputDiv() {
        return hiddenInputDiv;
    }

    /*
     * sethiddenInputDiv
     * @param hiddenInputDiv hiddenInputDiv
     */
    @JsonProperty("hiddenInputDiv")
    public void setHiddenInputDiv(RString hiddenInputDiv) {
        this.hiddenInputDiv = hiddenInputDiv;
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SeikatsuHogoshaJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class SeikatsuHogoshaJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnZenkaiSeikatsuhogoshaKensaku")
    private Button btnZenkaiSeikatsuhogoshaKensaku;
    @JsonProperty("btnAtenaKensaku")
    private ButtonDialog btnAtenaKensaku;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtShikibetsuCode")
    private TextBoxCode txtShikibetsuCode;
    @JsonProperty("txtKojinNo")
    private TextBoxCode txtKojinNo;
    @JsonProperty("txtKanaShimei")
    private TextBox txtKanaShimei;
    @JsonProperty("txtGyoseiku")
    private TextBox txtGyoseiku;
    @JsonProperty("txtSetaiCode")
    private TextBoxCode txtSetaiCode;
    @JsonProperty("txtBirthYMD")
    private TextBoxDate txtBirthYMD;
    @JsonProperty("radSeibetsu")
    private RadioButton radSeibetsu;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("ccdZenkokuJushoInput")
    private ZenkokuJushoInputDiv ccdZenkokuJushoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnZenkaiSeikatsuhogoshaKensaku
     * @return btnZenkaiSeikatsuhogoshaKensaku
     */
    @JsonProperty("btnZenkaiSeikatsuhogoshaKensaku")
    public Button getBtnZenkaiSeikatsuhogoshaKensaku() {
        return btnZenkaiSeikatsuhogoshaKensaku;
    }

    /*
     * setbtnZenkaiSeikatsuhogoshaKensaku
     * @param btnZenkaiSeikatsuhogoshaKensaku btnZenkaiSeikatsuhogoshaKensaku
     */
    @JsonProperty("btnZenkaiSeikatsuhogoshaKensaku")
    public void setBtnZenkaiSeikatsuhogoshaKensaku(Button btnZenkaiSeikatsuhogoshaKensaku) {
        this.btnZenkaiSeikatsuhogoshaKensaku = btnZenkaiSeikatsuhogoshaKensaku;
    }

    /*
     * getbtnAtenaKensaku
     * @return btnAtenaKensaku
     */
    @JsonProperty("btnAtenaKensaku")
    public ButtonDialog getBtnAtenaKensaku() {
        return btnAtenaKensaku;
    }

    /*
     * setbtnAtenaKensaku
     * @param btnAtenaKensaku btnAtenaKensaku
     */
    @JsonProperty("btnAtenaKensaku")
    public void setBtnAtenaKensaku(ButtonDialog btnAtenaKensaku) {
        this.btnAtenaKensaku = btnAtenaKensaku;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtKojinNo
     * @return txtKojinNo
     */
    @JsonProperty("txtKojinNo")
    public TextBoxCode getTxtKojinNo() {
        return txtKojinNo;
    }

    /*
     * settxtKojinNo
     * @param txtKojinNo txtKojinNo
     */
    @JsonProperty("txtKojinNo")
    public void setTxtKojinNo(TextBoxCode txtKojinNo) {
        this.txtKojinNo = txtKojinNo;
    }

    /*
     * gettxtKanaShimei
     * @return txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public TextBox getTxtKanaShimei() {
        return txtKanaShimei;
    }

    /*
     * settxtKanaShimei
     * @param txtKanaShimei txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.txtKanaShimei = txtKanaShimei;
    }

    /*
     * gettxtGyoseiku
     * @return txtGyoseiku
     */
    @JsonProperty("txtGyoseiku")
    public TextBox getTxtGyoseiku() {
        return txtGyoseiku;
    }

    /*
     * settxtGyoseiku
     * @param txtGyoseiku txtGyoseiku
     */
    @JsonProperty("txtGyoseiku")
    public void setTxtGyoseiku(TextBox txtGyoseiku) {
        this.txtGyoseiku = txtGyoseiku;
    }

    /*
     * gettxtSetaiCode
     * @return txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public TextBoxCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    /*
     * settxtSetaiCode
     * @param txtSetaiCode txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.txtSetaiCode = txtSetaiCode;
    }

    /*
     * gettxtBirthYMD
     * @return txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public TextBoxDate getTxtBirthYMD() {
        return txtBirthYMD;
    }

    /*
     * settxtBirthYMD
     * @param txtBirthYMD txtBirthYMD
     */
    @JsonProperty("txtBirthYMD")
    public void setTxtBirthYMD(TextBoxDate txtBirthYMD) {
        this.txtBirthYMD = txtBirthYMD;
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
     * getccdZenkokuJushoInput
     * @return ccdZenkokuJushoInput
     */
    @JsonProperty("ccdZenkokuJushoInput")
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput() {
        return ccdZenkokuJushoInput;
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9040001;
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
 * ChosainJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosainJohoInputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("txtChosaItakusaki")
    private TextBoxCode txtChosaItakusaki;
    @JsonProperty("btnToSearchChosaItakusaki")
    private ButtonDialog btnToSearchChosaItakusaki;
    @JsonProperty("txtChosaItakusakiMeisho")
    private TextBox txtChosaItakusakiMeisho;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("txtChosainShimei")
    private TextBox txtChosainShimei;
    @JsonProperty("txtChosainKanaShimei")
    private TextBoxKana txtChosainKanaShimei;
    @JsonProperty("radSeibetsu")
    private RadioButton radSeibetsu;
    @JsonProperty("txtChiku")
    private TextBoxCode txtChiku;
    @JsonProperty("btnToSearchChiku")
    private ButtonDialog btnToSearchChiku;
    @JsonProperty("txtChikuMei")
    private TextBox txtChikuMei;
    @JsonProperty("ddlChosainShikaku")
    private DropDownList ddlChosainShikaku;
    @JsonProperty("txtChosaKanoNinzu")
    private TextBoxNum txtChosaKanoNinzu;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtFaxNo")
    private TextBoxTelNo txtFaxNo;
    @JsonProperty("TextBoxShozokuKikan")
    private TextBoxJusho TextBoxShozokuKikan;
    @JsonProperty("radChosainJokyo")
    private RadioButton radChosainJokyo;
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
     * gettxtChosaItakusaki
     * @return txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public TextBoxCode getTxtChosaItakusaki() {
        return txtChosaItakusaki;
    }

    /*
     * settxtChosaItakusaki
     * @param txtChosaItakusaki txtChosaItakusaki
     */
    @JsonProperty("txtChosaItakusaki")
    public void setTxtChosaItakusaki(TextBoxCode txtChosaItakusaki) {
        this.txtChosaItakusaki = txtChosaItakusaki;
    }

    /*
     * getbtnToSearchChosaItakusaki
     * @return btnToSearchChosaItakusaki
     */
    @JsonProperty("btnToSearchChosaItakusaki")
    public ButtonDialog getBtnToSearchChosaItakusaki() {
        return btnToSearchChosaItakusaki;
    }

    /*
     * setbtnToSearchChosaItakusaki
     * @param btnToSearchChosaItakusaki btnToSearchChosaItakusaki
     */
    @JsonProperty("btnToSearchChosaItakusaki")
    public void setBtnToSearchChosaItakusaki(ButtonDialog btnToSearchChosaItakusaki) {
        this.btnToSearchChosaItakusaki = btnToSearchChosaItakusaki;
    }

    /*
     * gettxtChosaItakusakiMeisho
     * @return txtChosaItakusakiMeisho
     */
    @JsonProperty("txtChosaItakusakiMeisho")
    public TextBox getTxtChosaItakusakiMeisho() {
        return txtChosaItakusakiMeisho;
    }

    /*
     * settxtChosaItakusakiMeisho
     * @param txtChosaItakusakiMeisho txtChosaItakusakiMeisho
     */
    @JsonProperty("txtChosaItakusakiMeisho")
    public void setTxtChosaItakusakiMeisho(TextBox txtChosaItakusakiMeisho) {
        this.txtChosaItakusakiMeisho = txtChosaItakusakiMeisho;
    }

    /*
     * gettxtChosainCode
     * @return txtChosainCode
     */
    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    /*
     * settxtChosainCode
     * @param txtChosainCode txtChosainCode
     */
    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode = txtChosainCode;
    }

    /*
     * gettxtChosainShimei
     * @return txtChosainShimei
     */
    @JsonProperty("txtChosainShimei")
    public TextBox getTxtChosainShimei() {
        return txtChosainShimei;
    }

    /*
     * settxtChosainShimei
     * @param txtChosainShimei txtChosainShimei
     */
    @JsonProperty("txtChosainShimei")
    public void setTxtChosainShimei(TextBox txtChosainShimei) {
        this.txtChosainShimei = txtChosainShimei;
    }

    /*
     * gettxtChosainKanaShimei
     * @return txtChosainKanaShimei
     */
    @JsonProperty("txtChosainKanaShimei")
    public TextBoxKana getTxtChosainKanaShimei() {
        return txtChosainKanaShimei;
    }

    /*
     * settxtChosainKanaShimei
     * @param txtChosainKanaShimei txtChosainKanaShimei
     */
    @JsonProperty("txtChosainKanaShimei")
    public void setTxtChosainKanaShimei(TextBoxKana txtChosainKanaShimei) {
        this.txtChosainKanaShimei = txtChosainKanaShimei;
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
     * gettxtChiku
     * @return txtChiku
     */
    @JsonProperty("txtChiku")
    public TextBoxCode getTxtChiku() {
        return txtChiku;
    }

    /*
     * settxtChiku
     * @param txtChiku txtChiku
     */
    @JsonProperty("txtChiku")
    public void setTxtChiku(TextBoxCode txtChiku) {
        this.txtChiku = txtChiku;
    }

    /*
     * getbtnToSearchChiku
     * @return btnToSearchChiku
     */
    @JsonProperty("btnToSearchChiku")
    public ButtonDialog getBtnToSearchChiku() {
        return btnToSearchChiku;
    }

    /*
     * setbtnToSearchChiku
     * @param btnToSearchChiku btnToSearchChiku
     */
    @JsonProperty("btnToSearchChiku")
    public void setBtnToSearchChiku(ButtonDialog btnToSearchChiku) {
        this.btnToSearchChiku = btnToSearchChiku;
    }

    /*
     * gettxtChikuMei
     * @return txtChikuMei
     */
    @JsonProperty("txtChikuMei")
    public TextBox getTxtChikuMei() {
        return txtChikuMei;
    }

    /*
     * settxtChikuMei
     * @param txtChikuMei txtChikuMei
     */
    @JsonProperty("txtChikuMei")
    public void setTxtChikuMei(TextBox txtChikuMei) {
        this.txtChikuMei = txtChikuMei;
    }

    /*
     * getddlChosainShikaku
     * @return ddlChosainShikaku
     */
    @JsonProperty("ddlChosainShikaku")
    public DropDownList getDdlChosainShikaku() {
        return ddlChosainShikaku;
    }

    /*
     * setddlChosainShikaku
     * @param ddlChosainShikaku ddlChosainShikaku
     */
    @JsonProperty("ddlChosainShikaku")
    public void setDdlChosainShikaku(DropDownList ddlChosainShikaku) {
        this.ddlChosainShikaku = ddlChosainShikaku;
    }

    /*
     * gettxtChosaKanoNinzu
     * @return txtChosaKanoNinzu
     */
    @JsonProperty("txtChosaKanoNinzu")
    public TextBoxNum getTxtChosaKanoNinzu() {
        return txtChosaKanoNinzu;
    }

    /*
     * settxtChosaKanoNinzu
     * @param txtChosaKanoNinzu txtChosaKanoNinzu
     */
    @JsonProperty("txtChosaKanoNinzu")
    public void setTxtChosaKanoNinzu(TextBoxNum txtChosaKanoNinzu) {
        this.txtChosaKanoNinzu = txtChosaKanoNinzu;
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
     * getTextBoxShozokuKikan
     * @return TextBoxShozokuKikan
     */
    @JsonProperty("TextBoxShozokuKikan")
    public TextBoxJusho getTextBoxShozokuKikan() {
        return TextBoxShozokuKikan;
    }

    /*
     * setTextBoxShozokuKikan
     * @param TextBoxShozokuKikan TextBoxShozokuKikan
     */
    @JsonProperty("TextBoxShozokuKikan")
    public void setTextBoxShozokuKikan(TextBoxJusho TextBoxShozokuKikan) {
        this.TextBoxShozokuKikan = TextBoxShozokuKikan;
    }

    /*
     * getradChosainJokyo
     * @return radChosainJokyo
     */
    @JsonProperty("radChosainJokyo")
    public RadioButton getRadChosainJokyo() {
        return radChosainJokyo;
    }

    /*
     * setradChosainJokyo
     * @param radChosainJokyo radChosainJokyo
     */
    @JsonProperty("radChosainJokyo")
    public void setRadChosainJokyo(RadioButton radChosainJokyo) {
        this.radChosainJokyo = radChosainJokyo;
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

package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020001;
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
 * ChushutsuJokenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHihokenshaAll")
    private RadioButton radHihokenshaAll;
    @JsonProperty("txtTainoKikanHihokenshaAll")
    private TextBoxNum txtTainoKikanHihokenshaAll;
    @JsonProperty("txtTainoNengetsuHihokenshaAll")
    private TextBox txtTainoNengetsuHihokenshaAll;
    @JsonProperty("radHihokenshaIgaiAll")
    private RadioButton radHihokenshaIgaiAll;
    @JsonProperty("HihokenshaIgai")
    private HihokenshaIgaiDiv HihokenshaIgai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHihokenshaAll
     * @return radHihokenshaAll
     */
    @JsonProperty("radHihokenshaAll")
    public RadioButton getRadHihokenshaAll() {
        return radHihokenshaAll;
    }

    /*
     * setradHihokenshaAll
     * @param radHihokenshaAll radHihokenshaAll
     */
    @JsonProperty("radHihokenshaAll")
    public void setRadHihokenshaAll(RadioButton radHihokenshaAll) {
        this.radHihokenshaAll = radHihokenshaAll;
    }

    /*
     * gettxtTainoKikanHihokenshaAll
     * @return txtTainoKikanHihokenshaAll
     */
    @JsonProperty("txtTainoKikanHihokenshaAll")
    public TextBoxNum getTxtTainoKikanHihokenshaAll() {
        return txtTainoKikanHihokenshaAll;
    }

    /*
     * settxtTainoKikanHihokenshaAll
     * @param txtTainoKikanHihokenshaAll txtTainoKikanHihokenshaAll
     */
    @JsonProperty("txtTainoKikanHihokenshaAll")
    public void setTxtTainoKikanHihokenshaAll(TextBoxNum txtTainoKikanHihokenshaAll) {
        this.txtTainoKikanHihokenshaAll = txtTainoKikanHihokenshaAll;
    }

    /*
     * gettxtTainoNengetsuHihokenshaAll
     * @return txtTainoNengetsuHihokenshaAll
     */
    @JsonProperty("txtTainoNengetsuHihokenshaAll")
    public TextBox getTxtTainoNengetsuHihokenshaAll() {
        return txtTainoNengetsuHihokenshaAll;
    }

    /*
     * settxtTainoNengetsuHihokenshaAll
     * @param txtTainoNengetsuHihokenshaAll txtTainoNengetsuHihokenshaAll
     */
    @JsonProperty("txtTainoNengetsuHihokenshaAll")
    public void setTxtTainoNengetsuHihokenshaAll(TextBox txtTainoNengetsuHihokenshaAll) {
        this.txtTainoNengetsuHihokenshaAll = txtTainoNengetsuHihokenshaAll;
    }

    /*
     * getradHihokenshaIgaiAll
     * @return radHihokenshaIgaiAll
     */
    @JsonProperty("radHihokenshaIgaiAll")
    public RadioButton getRadHihokenshaIgaiAll() {
        return radHihokenshaIgaiAll;
    }

    /*
     * setradHihokenshaIgaiAll
     * @param radHihokenshaIgaiAll radHihokenshaIgaiAll
     */
    @JsonProperty("radHihokenshaIgaiAll")
    public void setRadHihokenshaIgaiAll(RadioButton radHihokenshaIgaiAll) {
        this.radHihokenshaIgaiAll = radHihokenshaIgaiAll;
    }

    /*
     * getHihokenshaIgai
     * @return HihokenshaIgai
     */
    @JsonProperty("HihokenshaIgai")
    public HihokenshaIgaiDiv getHihokenshaIgai() {
        return HihokenshaIgai;
    }

    /*
     * setHihokenshaIgai
     * @param HihokenshaIgai HihokenshaIgai
     */
    @JsonProperty("HihokenshaIgai")
    public void setHihokenshaIgai(HihokenshaIgaiDiv HihokenshaIgai) {
        this.HihokenshaIgai = HihokenshaIgai;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkJukyushaAll() {
        return this.getHihokenshaIgai().getChkJukyushaAll();
    }

    @JsonIgnore
    public void  setChkJukyushaAll(CheckBoxList chkJukyushaAll) {
        this.getHihokenshaIgai().setChkJukyushaAll(chkJukyushaAll);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanJukyushaAll() {
        return this.getHihokenshaIgai().getTxtTainoKikanJukyushaAll();
    }

    @JsonIgnore
    public void  setTxtTainoKikanJukyushaAll(TextBoxNum txtTainoKikanJukyushaAll) {
        this.getHihokenshaIgai().setTxtTainoKikanJukyushaAll(txtTainoKikanJukyushaAll);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuJukyushaAll() {
        return this.getHihokenshaIgai().getTxtTainoNengetsuJukyushaAll();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuJukyushaAll(TextBox txtTainoNengetsuJukyushaAll) {
        this.getHihokenshaIgai().setTxtTainoNengetsuJukyushaAll(txtTainoNengetsuJukyushaAll);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiShinseisha() {
        return this.getHihokenshaIgai().getChkNinteiShinseisha();
    }

    @JsonIgnore
    public void  setChkNinteiShinseisha(CheckBoxList chkNinteiShinseisha) {
        this.getHihokenshaIgai().setChkNinteiShinseisha(chkNinteiShinseisha);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanNinteiShinseisha() {
        return this.getHihokenshaIgai().getTxtTainoKikanNinteiShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoKikanNinteiShinseisha(TextBoxNum txtTainoKikanNinteiShinseisha) {
        this.getHihokenshaIgai().setTxtTainoKikanNinteiShinseisha(txtTainoKikanNinteiShinseisha);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuNinteiShinseisha() {
        return this.getHihokenshaIgai().getTxtTainoNengetsuNinteiShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuNinteiShinseisha(TextBox txtTainoNengetsuNinteiShinseisha) {
        this.getHihokenshaIgai().setTxtTainoNengetsuNinteiShinseisha(txtTainoNengetsuNinteiShinseisha);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiYMD() {
        return this.getHihokenshaIgai().getChkNinteiYMD();
    }

    @JsonIgnore
    public void  setChkNinteiYMD(CheckBoxList chkNinteiYMD) {
        this.getHihokenshaIgai().setChkNinteiYMD(chkNinteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiDateFrom() {
        return this.getHihokenshaIgai().getTxtNinteiDateFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiDateFrom(TextBoxFlexibleDate txtNinteiDateFrom) {
        this.getHihokenshaIgai().setTxtNinteiDateFrom(txtNinteiDateFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMDTo() {
        return this.getHihokenshaIgai().getTxtNinteiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYMDTo(TextBoxFlexibleDate txtNinteiYMDTo) {
        this.getHihokenshaIgai().setTxtNinteiYMDTo(txtNinteiYMDTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanNinteiYMD() {
        return this.getHihokenshaIgai().getTxtTainoKikanNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtTainoKikanNinteiYMD(TextBoxNum txtTainoKikanNinteiYMD) {
        this.getHihokenshaIgai().setTxtTainoKikanNinteiYMD(txtTainoKikanNinteiYMD);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuNinteiYMD() {
        return this.getHihokenshaIgai().getTxtTainoNengetsuNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuNinteiYMD(TextBox txtTainoNengetsuNinteiYMD) {
        this.getHihokenshaIgai().setTxtTainoNengetsuNinteiYMD(txtTainoNengetsuNinteiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkShokanShinseisha() {
        return this.getHihokenshaIgai().getChkShokanShinseisha();
    }

    @JsonIgnore
    public void  setChkShokanShinseisha(CheckBoxList chkShokanShinseisha) {
        this.getHihokenshaIgai().setChkShokanShinseisha(chkShokanShinseisha);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanShokanShinseisha() {
        return this.getHihokenshaIgai().getTxtTainoKikanShokanShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoKikanShokanShinseisha(TextBoxNum txtTainoKikanShokanShinseisha) {
        this.getHihokenshaIgai().setTxtTainoKikanShokanShinseisha(txtTainoKikanShokanShinseisha);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuShokanShinseisha() {
        return this.getHihokenshaIgai().getTxtTainoNengetsuShokanShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuShokanShinseisha(TextBox txtTainoNengetsuShokanShinseisha) {
        this.getHihokenshaIgai().setTxtTainoNengetsuShokanShinseisha(txtTainoNengetsuShokanShinseisha);
    }

    @JsonIgnore
    public CheckBoxList getChkShokanKetteiYMD() {
        return this.getHihokenshaIgai().getChkShokanKetteiYMD();
    }

    @JsonIgnore
    public void  setChkShokanKetteiYMD(CheckBoxList chkShokanKetteiYMD) {
        this.getHihokenshaIgai().setChkShokanKetteiYMD(chkShokanKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokanKetteiYMDFrom() {
        return this.getHihokenshaIgai().getTxtShokanKetteiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtShokanKetteiYMDFrom(TextBoxFlexibleDate txtShokanKetteiYMDFrom) {
        this.getHihokenshaIgai().setTxtShokanKetteiYMDFrom(txtShokanKetteiYMDFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokanKetteiYMDTo() {
        return this.getHihokenshaIgai().getTxtShokanKetteiYMDTo();
    }

    @JsonIgnore
    public void  setTxtShokanKetteiYMDTo(TextBoxFlexibleDate txtShokanKetteiYMDTo) {
        this.getHihokenshaIgai().setTxtShokanKetteiYMDTo(txtShokanKetteiYMDTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanShokanKettei() {
        return this.getHihokenshaIgai().getTxtTainoKikanShokanKettei();
    }

    @JsonIgnore
    public void  setTxtTainoKikanShokanKettei(TextBoxNum txtTainoKikanShokanKettei) {
        this.getHihokenshaIgai().setTxtTainoKikanShokanKettei(txtTainoKikanShokanKettei);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuShokanKettei() {
        return this.getHihokenshaIgai().getTxtTainoNengetsuShokanKettei();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuShokanKettei(TextBox txtTainoNengetsuShokanKettei) {
        this.getHihokenshaIgai().setTxtTainoNengetsuShokanKettei(txtTainoNengetsuShokanKettei);
    }

    // </editor-fold>
}

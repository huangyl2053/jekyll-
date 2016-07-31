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
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHanteiKijun")
    private Label lblHanteiKijun;
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("ChushutsuJokenDetail")
    private ChushutsuJokenDetailDiv ChushutsuJokenDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHanteiKijun
     * @return lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public Label getLblHanteiKijun() {
        return lblHanteiKijun;
    }

    /*
     * setlblHanteiKijun
     * @param lblHanteiKijun lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public void setLblHanteiKijun(Label lblHanteiKijun) {
        this.lblHanteiKijun = lblHanteiKijun;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getChushutsuJokenDetail
     * @return ChushutsuJokenDetail
     */
    @JsonProperty("ChushutsuJokenDetail")
    public ChushutsuJokenDetailDiv getChushutsuJokenDetail() {
        return ChushutsuJokenDetail;
    }

    /*
     * setChushutsuJokenDetail
     * @param ChushutsuJokenDetail ChushutsuJokenDetail
     */
    @JsonProperty("ChushutsuJokenDetail")
    public void setChushutsuJokenDetail(ChushutsuJokenDetailDiv ChushutsuJokenDetail) {
        this.ChushutsuJokenDetail = ChushutsuJokenDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHihokenshaAll() {
        return this.getChushutsuJokenDetail().getRadHihokenshaAll();
    }

    @JsonIgnore
    public void  setRadHihokenshaAll(RadioButton radHihokenshaAll) {
        this.getChushutsuJokenDetail().setRadHihokenshaAll(radHihokenshaAll);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanHihokenshaAll() {
        return this.getChushutsuJokenDetail().getTxtTainoKikanHihokenshaAll();
    }

    @JsonIgnore
    public void  setTxtTainoKikanHihokenshaAll(TextBoxNum txtTainoKikanHihokenshaAll) {
        this.getChushutsuJokenDetail().setTxtTainoKikanHihokenshaAll(txtTainoKikanHihokenshaAll);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuHihokenshaAll() {
        return this.getChushutsuJokenDetail().getTxtTainoNengetsuHihokenshaAll();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuHihokenshaAll(TextBox txtTainoNengetsuHihokenshaAll) {
        this.getChushutsuJokenDetail().setTxtTainoNengetsuHihokenshaAll(txtTainoNengetsuHihokenshaAll);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaIgaiAll() {
        return this.getChushutsuJokenDetail().getRadHihokenshaIgaiAll();
    }

    @JsonIgnore
    public void  setRadHihokenshaIgaiAll(RadioButton radHihokenshaIgaiAll) {
        this.getChushutsuJokenDetail().setRadHihokenshaIgaiAll(radHihokenshaIgaiAll);
    }

    @JsonIgnore
    public HihokenshaIgaiDiv getHihokenshaIgai() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai();
    }

    @JsonIgnore
    public void  setHihokenshaIgai(HihokenshaIgaiDiv HihokenshaIgai) {
        this.getChushutsuJokenDetail().setHihokenshaIgai(HihokenshaIgai);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyushaAll() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getChkJukyushaAll();
    }

    @JsonIgnore
    public void  setChkJukyushaAll(CheckBoxList chkJukyushaAll) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setChkJukyushaAll(chkJukyushaAll);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanJukyushaAll() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanJukyushaAll();
    }

    @JsonIgnore
    public void  setTxtTainoKikanJukyushaAll(TextBoxNum txtTainoKikanJukyushaAll) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanJukyushaAll(txtTainoKikanJukyushaAll);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuJukyushaAll() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuJukyushaAll();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuJukyushaAll(TextBox txtTainoNengetsuJukyushaAll) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuJukyushaAll(txtTainoNengetsuJukyushaAll);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiShinseisha() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getChkNinteiShinseisha();
    }

    @JsonIgnore
    public void  setChkNinteiShinseisha(CheckBoxList chkNinteiShinseisha) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setChkNinteiShinseisha(chkNinteiShinseisha);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanNinteiShinseisha() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanNinteiShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoKikanNinteiShinseisha(TextBoxNum txtTainoKikanNinteiShinseisha) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanNinteiShinseisha(txtTainoKikanNinteiShinseisha);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuNinteiShinseisha() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuNinteiShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuNinteiShinseisha(TextBox txtTainoNengetsuNinteiShinseisha) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuNinteiShinseisha(txtTainoNengetsuNinteiShinseisha);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiYMD() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getChkNinteiYMD();
    }

    @JsonIgnore
    public void  setChkNinteiYMD(CheckBoxList chkNinteiYMD) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setChkNinteiYMD(chkNinteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiDateFrom() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtNinteiDateFrom();
    }

    @JsonIgnore
    public void  setTxtNinteiDateFrom(TextBoxFlexibleDate txtNinteiDateFrom) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtNinteiDateFrom(txtNinteiDateFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMDTo() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtNinteiYMDTo();
    }

    @JsonIgnore
    public void  setTxtNinteiYMDTo(TextBoxFlexibleDate txtNinteiYMDTo) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtNinteiYMDTo(txtNinteiYMDTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanNinteiYMD() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtTainoKikanNinteiYMD(TextBoxNum txtTainoKikanNinteiYMD) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanNinteiYMD(txtTainoKikanNinteiYMD);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuNinteiYMD() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuNinteiYMD(TextBox txtTainoNengetsuNinteiYMD) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuNinteiYMD(txtTainoNengetsuNinteiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkShokanShinseisha() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getChkShokanShinseisha();
    }

    @JsonIgnore
    public void  setChkShokanShinseisha(CheckBoxList chkShokanShinseisha) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setChkShokanShinseisha(chkShokanShinseisha);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanShokanShinseisha() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanShokanShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoKikanShokanShinseisha(TextBoxNum txtTainoKikanShokanShinseisha) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanShokanShinseisha(txtTainoKikanShokanShinseisha);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuShokanShinseisha() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuShokanShinseisha();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuShokanShinseisha(TextBox txtTainoNengetsuShokanShinseisha) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuShokanShinseisha(txtTainoNengetsuShokanShinseisha);
    }

    @JsonIgnore
    public CheckBoxList getChkShokanKetteiYMD() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getChkShokanKetteiYMD();
    }

    @JsonIgnore
    public void  setChkShokanKetteiYMD(CheckBoxList chkShokanKetteiYMD) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setChkShokanKetteiYMD(chkShokanKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokanKetteiYMDFrom() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtShokanKetteiYMDFrom();
    }

    @JsonIgnore
    public void  setTxtShokanKetteiYMDFrom(TextBoxFlexibleDate txtShokanKetteiYMDFrom) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtShokanKetteiYMDFrom(txtShokanKetteiYMDFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokanKetteiYMDTo() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtShokanKetteiYMDTo();
    }

    @JsonIgnore
    public void  setTxtShokanKetteiYMDTo(TextBoxFlexibleDate txtShokanKetteiYMDTo) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtShokanKetteiYMDTo(txtShokanKetteiYMDTo);
    }

    @JsonIgnore
    public TextBoxNum getTxtTainoKikanShokanKettei() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoKikanShokanKettei();
    }

    @JsonIgnore
    public void  setTxtTainoKikanShokanKettei(TextBoxNum txtTainoKikanShokanKettei) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoKikanShokanKettei(txtTainoKikanShokanKettei);
    }

    @JsonIgnore
    public TextBox getTxtTainoNengetsuShokanKettei() {
        return this.getChushutsuJokenDetail().getHihokenshaIgai().getTxtTainoNengetsuShokanKettei();
    }

    @JsonIgnore
    public void  setTxtTainoNengetsuShokanKettei(TextBox txtTainoNengetsuShokanKettei) {
        this.getChushutsuJokenDetail().getHihokenshaIgai().setTxtTainoNengetsuShokanKettei(txtTainoNengetsuShokanKettei);
    }

    // </editor-fold>
}

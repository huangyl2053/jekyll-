package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KetteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radKettaiKubun")
    private RadioButton radKettaiKubun;
    @JsonProperty("txtKettaiYMD")
    private TextBoxFlexibleDate txtKettaiYMD;
    @JsonProperty("txtTaishoNendo")
    private TextBoxFlexibleYear txtTaishoNendo;
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("txtHaakuYMD")
    private TextBoxFlexibleDate txtHaakuYMD;
    @JsonProperty("chkHasShogaishaTecho")
    private CheckBoxList chkHasShogaishaTecho;
    @JsonProperty("chkIsNinteishoHakkoTaishoGai")
    private CheckBoxList chkIsNinteishoHakkoTaishoGai;
    @JsonProperty("ddlNinchishoKoreishaJiritsudo")
    private DropDownList ddlNinchishoKoreishaJiritsudo;
    @JsonProperty("ddlShogaiKoreishaJiritsudo")
    private DropDownList ddlShogaiKoreishaJiritsudo;
    @JsonProperty("ddlNinteiKubun")
    private DropDownList ddlNinteiKubun;
    @JsonProperty("ddlNinteiNaiyo")
    private DropDownList ddlNinteiNaiyo;
    @JsonProperty("btnHiShoninRiyu")
    private ButtonDialog btnHiShoninRiyu;
    @JsonProperty("txtHiShoninRiyu")
    private TextBoxMultiLine txtHiShoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradKettaiKubun
     * @return radKettaiKubun
     */
    @JsonProperty("radKettaiKubun")
    public RadioButton getRadKettaiKubun() {
        return radKettaiKubun;
    }

    /*
     * setradKettaiKubun
     * @param radKettaiKubun radKettaiKubun
     */
    @JsonProperty("radKettaiKubun")
    public void setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.radKettaiKubun = radKettaiKubun;
    }

    /*
     * gettxtKettaiYMD
     * @return txtKettaiYMD
     */
    @JsonProperty("txtKettaiYMD")
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return txtKettaiYMD;
    }

    /*
     * settxtKettaiYMD
     * @param txtKettaiYMD txtKettaiYMD
     */
    @JsonProperty("txtKettaiYMD")
    public void setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.txtKettaiYMD = txtKettaiYMD;
    }

    /*
     * gettxtTaishoNendo
     * @return txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public TextBoxFlexibleYear getTxtTaishoNendo() {
        return txtTaishoNendo;
    }

    /*
     * settxtTaishoNendo
     * @param txtTaishoNendo txtTaishoNendo
     */
    @JsonProperty("txtTaishoNendo")
    public void setTxtTaishoNendo(TextBoxFlexibleYear txtTaishoNendo) {
        this.txtTaishoNendo = txtTaishoNendo;
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
     * gettxtHaakuYMD
     * @return txtHaakuYMD
     */
    @JsonProperty("txtHaakuYMD")
    public TextBoxFlexibleDate getTxtHaakuYMD() {
        return txtHaakuYMD;
    }

    /*
     * settxtHaakuYMD
     * @param txtHaakuYMD txtHaakuYMD
     */
    @JsonProperty("txtHaakuYMD")
    public void setTxtHaakuYMD(TextBoxFlexibleDate txtHaakuYMD) {
        this.txtHaakuYMD = txtHaakuYMD;
    }

    /*
     * getchkHasShogaishaTecho
     * @return chkHasShogaishaTecho
     */
    @JsonProperty("chkHasShogaishaTecho")
    public CheckBoxList getChkHasShogaishaTecho() {
        return chkHasShogaishaTecho;
    }

    /*
     * setchkHasShogaishaTecho
     * @param chkHasShogaishaTecho chkHasShogaishaTecho
     */
    @JsonProperty("chkHasShogaishaTecho")
    public void setChkHasShogaishaTecho(CheckBoxList chkHasShogaishaTecho) {
        this.chkHasShogaishaTecho = chkHasShogaishaTecho;
    }

    /*
     * getchkIsNinteishoHakkoTaishoGai
     * @return chkIsNinteishoHakkoTaishoGai
     */
    @JsonProperty("chkIsNinteishoHakkoTaishoGai")
    public CheckBoxList getChkIsNinteishoHakkoTaishoGai() {
        return chkIsNinteishoHakkoTaishoGai;
    }

    /*
     * setchkIsNinteishoHakkoTaishoGai
     * @param chkIsNinteishoHakkoTaishoGai chkIsNinteishoHakkoTaishoGai
     */
    @JsonProperty("chkIsNinteishoHakkoTaishoGai")
    public void setChkIsNinteishoHakkoTaishoGai(CheckBoxList chkIsNinteishoHakkoTaishoGai) {
        this.chkIsNinteishoHakkoTaishoGai = chkIsNinteishoHakkoTaishoGai;
    }

    /*
     * getddlNinchishoKoreishaJiritsudo
     * @return ddlNinchishoKoreishaJiritsudo
     */
    @JsonProperty("ddlNinchishoKoreishaJiritsudo")
    public DropDownList getDdlNinchishoKoreishaJiritsudo() {
        return ddlNinchishoKoreishaJiritsudo;
    }

    /*
     * setddlNinchishoKoreishaJiritsudo
     * @param ddlNinchishoKoreishaJiritsudo ddlNinchishoKoreishaJiritsudo
     */
    @JsonProperty("ddlNinchishoKoreishaJiritsudo")
    public void setDdlNinchishoKoreishaJiritsudo(DropDownList ddlNinchishoKoreishaJiritsudo) {
        this.ddlNinchishoKoreishaJiritsudo = ddlNinchishoKoreishaJiritsudo;
    }

    /*
     * getddlShogaiKoreishaJiritsudo
     * @return ddlShogaiKoreishaJiritsudo
     */
    @JsonProperty("ddlShogaiKoreishaJiritsudo")
    public DropDownList getDdlShogaiKoreishaJiritsudo() {
        return ddlShogaiKoreishaJiritsudo;
    }

    /*
     * setddlShogaiKoreishaJiritsudo
     * @param ddlShogaiKoreishaJiritsudo ddlShogaiKoreishaJiritsudo
     */
    @JsonProperty("ddlShogaiKoreishaJiritsudo")
    public void setDdlShogaiKoreishaJiritsudo(DropDownList ddlShogaiKoreishaJiritsudo) {
        this.ddlShogaiKoreishaJiritsudo = ddlShogaiKoreishaJiritsudo;
    }

    /*
     * getddlNinteiKubun
     * @return ddlNinteiKubun
     */
    @JsonProperty("ddlNinteiKubun")
    public DropDownList getDdlNinteiKubun() {
        return ddlNinteiKubun;
    }

    /*
     * setddlNinteiKubun
     * @param ddlNinteiKubun ddlNinteiKubun
     */
    @JsonProperty("ddlNinteiKubun")
    public void setDdlNinteiKubun(DropDownList ddlNinteiKubun) {
        this.ddlNinteiKubun = ddlNinteiKubun;
    }

    /*
     * getddlNinteiNaiyo
     * @return ddlNinteiNaiyo
     */
    @JsonProperty("ddlNinteiNaiyo")
    public DropDownList getDdlNinteiNaiyo() {
        return ddlNinteiNaiyo;
    }

    /*
     * setddlNinteiNaiyo
     * @param ddlNinteiNaiyo ddlNinteiNaiyo
     */
    @JsonProperty("ddlNinteiNaiyo")
    public void setDdlNinteiNaiyo(DropDownList ddlNinteiNaiyo) {
        this.ddlNinteiNaiyo = ddlNinteiNaiyo;
    }

    /*
     * getbtnHiShoninRiyu
     * @return btnHiShoninRiyu
     */
    @JsonProperty("btnHiShoninRiyu")
    public ButtonDialog getBtnHiShoninRiyu() {
        return btnHiShoninRiyu;
    }

    /*
     * setbtnHiShoninRiyu
     * @param btnHiShoninRiyu btnHiShoninRiyu
     */
    @JsonProperty("btnHiShoninRiyu")
    public void setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.btnHiShoninRiyu = btnHiShoninRiyu;
    }

    /*
     * gettxtHiShoninRiyu
     * @return txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return txtHiShoninRiyu;
    }

    /*
     * settxtHiShoninRiyu
     * @param txtHiShoninRiyu txtHiShoninRiyu
     */
    @JsonProperty("txtHiShoninRiyu")
    public void setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.txtHiShoninRiyu = txtHiShoninRiyu;
    }

    // </editor-fold>
}

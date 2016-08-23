package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.IGemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShinseiDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiYMD")
    private TextBoxFlexibleDate txtShinseiYMD;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;
    @JsonProperty("KetteiJoho")
    private KetteiJohoDiv KetteiJoho;
    @JsonProperty("txtDetermineShinsei")
    private Button txtDetermineShinsei;
    @JsonProperty("btnBackToShinseiList")
    private Button btnBackToShinseiList;
    @JsonProperty("ccdGemmenGengakuShinsei")
    private GemmenGengakuShinseiDiv ccdGemmenGengakuShinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    /*
     * getKetteiJoho
     * @return KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public KetteiJohoDiv getKetteiJoho() {
        return KetteiJoho;
    }

    /*
     * setKetteiJoho
     * @param KetteiJoho KetteiJoho
     */
    @JsonProperty("KetteiJoho")
    public void setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.KetteiJoho = KetteiJoho;
    }

    /*
     * gettxtDetermineShinsei
     * @return txtDetermineShinsei
     */
    @JsonProperty("txtDetermineShinsei")
    public Button getTxtDetermineShinsei() {
        return txtDetermineShinsei;
    }

    /*
     * settxtDetermineShinsei
     * @param txtDetermineShinsei txtDetermineShinsei
     */
    @JsonProperty("txtDetermineShinsei")
    public void setTxtDetermineShinsei(Button txtDetermineShinsei) {
        this.txtDetermineShinsei = txtDetermineShinsei;
    }

    /*
     * getbtnBackToShinseiList
     * @return btnBackToShinseiList
     */
    @JsonProperty("btnBackToShinseiList")
    public Button getBtnBackToShinseiList() {
        return btnBackToShinseiList;
    }

    /*
     * setbtnBackToShinseiList
     * @param btnBackToShinseiList btnBackToShinseiList
     */
    @JsonProperty("btnBackToShinseiList")
    public void setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.btnBackToShinseiList = btnBackToShinseiList;
    }

    /*
     * getccdGemmenGengakuShinsei
     * @return ccdGemmenGengakuShinsei
     */
    @JsonProperty("ccdGemmenGengakuShinsei")
    public IGemmenGengakuShinseiDiv getCcdGemmenGengakuShinsei() {
        return ccdGemmenGengakuShinsei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKettaiKubun() {
        return this.getKetteiJoho().getRadKettaiKubun();
    }

    @JsonIgnore
    public void  setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.getKetteiJoho().setRadKettaiKubun(radKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return this.getKetteiJoho().getTxtKettaiYMD();
    }

    @JsonIgnore
    public void  setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.getKetteiJoho().setTxtKettaiYMD(txtKettaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtTaishoNendo() {
        return this.getKetteiJoho().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtTaishoNendo(TextBoxFlexibleYear txtTaishoNendo) {
        this.getKetteiJoho().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return this.getKetteiJoho().getTxtKijunYMD();
    }

    @JsonIgnore
    public void  setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.getKetteiJoho().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHaakuYMD() {
        return this.getKetteiJoho().getTxtHaakuYMD();
    }

    @JsonIgnore
    public void  setTxtHaakuYMD(TextBoxFlexibleDate txtHaakuYMD) {
        this.getKetteiJoho().setTxtHaakuYMD(txtHaakuYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHasShogaishaTecho() {
        return this.getKetteiJoho().getChkHasShogaishaTecho();
    }

    @JsonIgnore
    public void  setChkHasShogaishaTecho(CheckBoxList chkHasShogaishaTecho) {
        this.getKetteiJoho().setChkHasShogaishaTecho(chkHasShogaishaTecho);
    }

    @JsonIgnore
    public CheckBoxList getChkIsNinteishoHakkoTaishoGai() {
        return this.getKetteiJoho().getChkIsNinteishoHakkoTaishoGai();
    }

    @JsonIgnore
    public void  setChkIsNinteishoHakkoTaishoGai(CheckBoxList chkIsNinteishoHakkoTaishoGai) {
        this.getKetteiJoho().setChkIsNinteishoHakkoTaishoGai(chkIsNinteishoHakkoTaishoGai);
    }

    @JsonIgnore
    public DropDownList getDdlNinchishoKoreishaJiritsudo() {
        return this.getKetteiJoho().getDdlNinchishoKoreishaJiritsudo();
    }

    @JsonIgnore
    public void  setDdlNinchishoKoreishaJiritsudo(DropDownList ddlNinchishoKoreishaJiritsudo) {
        this.getKetteiJoho().setDdlNinchishoKoreishaJiritsudo(ddlNinchishoKoreishaJiritsudo);
    }

    @JsonIgnore
    public DropDownList getDdlShogaiKoreishaJiritsudo() {
        return this.getKetteiJoho().getDdlShogaiKoreishaJiritsudo();
    }

    @JsonIgnore
    public void  setDdlShogaiKoreishaJiritsudo(DropDownList ddlShogaiKoreishaJiritsudo) {
        this.getKetteiJoho().setDdlShogaiKoreishaJiritsudo(ddlShogaiKoreishaJiritsudo);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiKubun() {
        return this.getKetteiJoho().getDdlNinteiKubun();
    }

    @JsonIgnore
    public void  setDdlNinteiKubun(DropDownList ddlNinteiKubun) {
        this.getKetteiJoho().setDdlNinteiKubun(ddlNinteiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiNaiyo() {
        return this.getKetteiJoho().getDdlNinteiNaiyo();
    }

    @JsonIgnore
    public void  setDdlNinteiNaiyo(DropDownList ddlNinteiNaiyo) {
        this.getKetteiJoho().setDdlNinteiNaiyo(ddlNinteiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getKetteiJoho().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getKetteiJoho().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    // </editor-fold>
}

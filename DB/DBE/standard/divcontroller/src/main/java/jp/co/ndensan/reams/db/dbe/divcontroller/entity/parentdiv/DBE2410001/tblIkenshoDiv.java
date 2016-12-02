package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblIkensho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblIkenshoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiShujiiIraiJoho")
    private KonkaiShujiiIraiJohoDiv KonkaiShujiiIraiJoho;
    @JsonProperty("ZenkaiShujiiIraiJoho")
    private ZenkaiShujiiIraiJohoDiv ZenkaiShujiiIraiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKonkaiShujiiIraiJoho
     * @return KonkaiShujiiIraiJoho
     */
    @JsonProperty("KonkaiShujiiIraiJoho")
    public KonkaiShujiiIraiJohoDiv getKonkaiShujiiIraiJoho() {
        return KonkaiShujiiIraiJoho;
    }

    /*
     * setKonkaiShujiiIraiJoho
     * @param KonkaiShujiiIraiJoho KonkaiShujiiIraiJoho
     */
    @JsonProperty("KonkaiShujiiIraiJoho")
    public void setKonkaiShujiiIraiJoho(KonkaiShujiiIraiJohoDiv KonkaiShujiiIraiJoho) {
        this.KonkaiShujiiIraiJoho = KonkaiShujiiIraiJoho;
    }

    /*
     * getZenkaiShujiiIraiJoho
     * @return ZenkaiShujiiIraiJoho
     */
    @JsonProperty("ZenkaiShujiiIraiJoho")
    public ZenkaiShujiiIraiJohoDiv getZenkaiShujiiIraiJoho() {
        return ZenkaiShujiiIraiJoho;
    }

    /*
     * setZenkaiShujiiIraiJoho
     * @param ZenkaiShujiiIraiJoho ZenkaiShujiiIraiJoho
     */
    @JsonProperty("ZenkaiShujiiIraiJoho")
    public void setZenkaiShujiiIraiJoho(ZenkaiShujiiIraiJohoDiv ZenkaiShujiiIraiJoho) {
        this.ZenkaiShujiiIraiJoho = ZenkaiShujiiIraiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBango() {
        return this.getKonkaiShujiiIraiJoho().getTxtIkenshoSakuseiIraiRirekiBango();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiRirekiBango(TextBoxCode txtIkenshoSakuseiIraiRirekiBango) {
        this.getKonkaiShujiiIraiJoho().setTxtIkenshoSakuseiIraiRirekiBango(txtIkenshoSakuseiIraiRirekiBango);
    }

    @JsonIgnore
    public TextBox getTxtIkenshoIraiKubun() {
        return this.getKonkaiShujiiIraiJoho().getTxtIkenshoIraiKubun();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiKubun(TextBox txtIkenshoIraiKubun) {
        this.getKonkaiShujiiIraiJoho().setTxtIkenshoIraiKubun(txtIkenshoIraiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoSakuseiKaisu() {
        return this.getKonkaiShujiiIraiJoho().getTxtIkenshoSakuseiKaisu();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiKaisu(TextBoxNum txtIkenshoSakuseiKaisu) {
        this.getKonkaiShujiiIraiJoho().setTxtIkenshoSakuseiKaisu(txtIkenshoSakuseiKaisu);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShiteiiKubun() {
        return this.getKonkaiShujiiIraiJoho().getTxtShujiiShiteiiKubun();
    }

    @JsonIgnore
    public void  setTxtShujiiShiteiiKubun(TextBox txtShujiiShiteiiKubun) {
        this.getKonkaiShujiiIraiJoho().setTxtShujiiShiteiiKubun(txtShujiiShiteiiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibi() {
        return this.getKonkaiShujiiIraiJoho().getTxtIkenshoIraibi();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.getKonkaiShujiiIraiJoho().setTxtIkenshoIraibi(txtIkenshoIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoKinyubi() {
        return this.getKonkaiShujiiIraiJoho().getTxtIkenshoKinyubi();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubi(TextBoxDate txtIkenshoKinyubi) {
        this.getKonkaiShujiiIraiJoho().setTxtIkenshoKinyubi(txtIkenshoKinyubi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekka() {
        return this.getKonkaiShujiiIraiJoho().getChkNinteiKekka();
    }

    @JsonIgnore
    public void  setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.getKonkaiShujiiIraiJoho().setChkNinteiKekka(chkNinteiKekka);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getKonkaiShujiiIraiJoho().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getKonkaiShujiiIraiJoho().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public TextBox getTxtShujii() {
        return this.getKonkaiShujiiIraiJoho().getTxtShujii();
    }

    @JsonIgnore
    public void  setTxtShujii(TextBox txtShujii) {
        this.getKonkaiShujiiIraiJoho().setTxtShujii(txtShujii);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCode() {
        return this.getKonkaiShujiiIraiJoho().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.getKonkaiShujiiIraiJoho().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikan() {
        return this.getKonkaiShujiiIraiJoho().getTxtIryoKikan();
    }

    @JsonIgnore
    public void  setTxtIryoKikan(TextBox txtIryoKikan) {
        this.getKonkaiShujiiIraiJoho().setTxtIryoKikan(txtIryoKikan);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinGango() {
        return this.getKonkaiShujiiIraiJoho().getTxtYubinGango();
    }

    @JsonIgnore
    public void  setTxtYubinGango(TextBoxYubinNo txtYubinGango) {
        this.getKonkaiShujiiIraiJoho().setTxtYubinGango(txtYubinGango);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getKonkaiShujiiIraiJoho().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getKonkaiShujiiIraiJoho().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoIkensho() {
        return this.getKonkaiShujiiIraiJoho().getTxtDenwaBangoIkensho();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoIkensho(TextBoxTelNo txtDenwaBangoIkensho) {
        this.getKonkaiShujiiIraiJoho().setTxtDenwaBangoIkensho(txtDenwaBangoIkensho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxIkensho() {
        return this.getKonkaiShujiiIraiJoho().getTxtFaxIkensho();
    }

    @JsonIgnore
    public void  setTxtFaxIkensho(TextBoxTelNo txtFaxIkensho) {
        this.getKonkaiShujiiIraiJoho().setTxtFaxIkensho(txtFaxIkensho);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanDaihyoshaShimei() {
        return this.getKonkaiShujiiIraiJoho().getTxtIryoKikanDaihyoshaShimei();
    }

    @JsonIgnore
    public void  setTxtIryoKikanDaihyoshaShimei(TextBox txtIryoKikanDaihyoshaShimei) {
        this.getKonkaiShujiiIraiJoho().setTxtIryoKikanDaihyoshaShimei(txtIryoKikanDaihyoshaShimei);
    }

    @JsonIgnore
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBangoZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIkenshoSakuseiIraiRirekiBangoZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiRirekiBangoZen(TextBoxCode txtIkenshoSakuseiIraiRirekiBangoZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIkenshoSakuseiIraiRirekiBangoZen(txtIkenshoSakuseiIraiRirekiBangoZen);
    }

    @JsonIgnore
    public TextBox getTxtIkenshoIraiKubunZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIkenshoIraiKubunZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiKubunZen(TextBox txtIkenshoIraiKubunZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIkenshoIraiKubunZen(txtIkenshoIraiKubunZen);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoSakuseiKaisuZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIkenshoSakuseiKaisuZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiKaisuZen(TextBoxNum txtIkenshoSakuseiKaisuZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIkenshoSakuseiKaisuZen(txtIkenshoSakuseiKaisuZen);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShiteiiKubunZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtShujiiShiteiiKubunZen();
    }

    @JsonIgnore
    public void  setTxtShujiiShiteiiKubunZen(TextBox txtShujiiShiteiiKubunZen) {
        this.getZenkaiShujiiIraiJoho().setTxtShujiiShiteiiKubunZen(txtShujiiShiteiiKubunZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibiZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIkenshoIraibiZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraibiZen(TextBoxDate txtIkenshoIraibiZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIkenshoIraibiZen(txtIkenshoIraibiZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoKinyubiZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIkenshoKinyubiZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubiZen(TextBoxDate txtIkenshoKinyubiZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIkenshoKinyubiZen(txtIkenshoKinyubiZen);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekkaZen() {
        return this.getZenkaiShujiiIraiJoho().getChkNinteiKekkaZen();
    }

    @JsonIgnore
    public void  setChkNinteiKekkaZen(CheckBoxList chkNinteiKekkaZen) {
        this.getZenkaiShujiiIraiJoho().setChkNinteiKekkaZen(chkNinteiKekkaZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCodeZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtShujiiCodeZen();
    }

    @JsonIgnore
    public void  setTxtShujiiCodeZen(TextBoxCode txtShujiiCodeZen) {
        this.getZenkaiShujiiIraiJoho().setTxtShujiiCodeZen(txtShujiiCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtShujiiZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtShujiiZen();
    }

    @JsonIgnore
    public void  setTxtShujiiZen(TextBox txtShujiiZen) {
        this.getZenkaiShujiiIraiJoho().setTxtShujiiZen(txtShujiiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIryoKikanCodeZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeZen(TextBoxCode txtIryoKikanCodeZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIryoKikanCodeZen(txtIryoKikanCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIryoKikanZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanZen(TextBox txtIryoKikanZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIryoKikanZen(txtIryoKikanZen);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinGangoZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtYubinGangoZen();
    }

    @JsonIgnore
    public void  setTxtYubinGangoZen(TextBoxYubinNo txtYubinGangoZen) {
        this.getZenkaiShujiiIraiJoho().setTxtYubinGangoZen(txtYubinGangoZen);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJushoZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtJushoZen();
    }

    @JsonIgnore
    public void  setTxtJushoZen(TextBoxJusho txtJushoZen) {
        this.getZenkaiShujiiIraiJoho().setTxtJushoZen(txtJushoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoIkenshoZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtDenwaBangoIkenshoZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoIkenshoZen(TextBoxTelNo txtDenwaBangoIkenshoZen) {
        this.getZenkaiShujiiIraiJoho().setTxtDenwaBangoIkenshoZen(txtDenwaBangoIkenshoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxIkenshoZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtFaxIkenshoZen();
    }

    @JsonIgnore
    public void  setTxtFaxIkenshoZen(TextBoxTelNo txtFaxIkenshoZen) {
        this.getZenkaiShujiiIraiJoho().setTxtFaxIkenshoZen(txtFaxIkenshoZen);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanDaihyoshaShimeiZen() {
        return this.getZenkaiShujiiIraiJoho().getTxtIryoKikanDaihyoshaShimeiZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanDaihyoshaShimeiZen(TextBox txtIryoKikanDaihyoshaShimeiZen) {
        this.getZenkaiShujiiIraiJoho().setTxtIryoKikanDaihyoshaShimeiZen(txtIryoKikanDaihyoshaShimeiZen);
    }

    // </editor-fold>
}

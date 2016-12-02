package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001;
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
 * KonkaiShujiiIraiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KonkaiShujiiIraiJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIkenshoSakuseiIraiRirekiBango")
    private TextBoxCode txtIkenshoSakuseiIraiRirekiBango;
    @JsonProperty("txtIkenshoIraiKubun")
    private TextBox txtIkenshoIraiKubun;
    @JsonProperty("txtIkenshoSakuseiKaisu")
    private TextBoxNum txtIkenshoSakuseiKaisu;
    @JsonProperty("txtShujiiShiteiiKubun")
    private TextBox txtShujiiShiteiiKubun;
    @JsonProperty("txtIkenshoIraibi")
    private TextBoxDate txtIkenshoIraibi;
    @JsonProperty("txtIkenshoKinyubi")
    private TextBoxDate txtIkenshoKinyubi;
    @JsonProperty("chkNinteiKekka")
    private CheckBoxList chkNinteiKekka;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("txtShujii")
    private TextBox txtShujii;
    @JsonProperty("txtIryoKikanCode")
    private TextBoxCode txtIryoKikanCode;
    @JsonProperty("txtIryoKikan")
    private TextBox txtIryoKikan;
    @JsonProperty("txtYubinGango")
    private TextBoxYubinNo txtYubinGango;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
    @JsonProperty("txtDenwaBangoIkensho")
    private TextBoxTelNo txtDenwaBangoIkensho;
    @JsonProperty("txtFaxIkensho")
    private TextBoxTelNo txtFaxIkensho;
    @JsonProperty("txtIryoKikanDaihyoshaShimei")
    private TextBox txtIryoKikanDaihyoshaShimei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIkenshoSakuseiIraiRirekiBango
     * @return txtIkenshoSakuseiIraiRirekiBango
     */
    @JsonProperty("txtIkenshoSakuseiIraiRirekiBango")
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBango() {
        return txtIkenshoSakuseiIraiRirekiBango;
    }

    /*
     * settxtIkenshoSakuseiIraiRirekiBango
     * @param txtIkenshoSakuseiIraiRirekiBango txtIkenshoSakuseiIraiRirekiBango
     */
    @JsonProperty("txtIkenshoSakuseiIraiRirekiBango")
    public void setTxtIkenshoSakuseiIraiRirekiBango(TextBoxCode txtIkenshoSakuseiIraiRirekiBango) {
        this.txtIkenshoSakuseiIraiRirekiBango = txtIkenshoSakuseiIraiRirekiBango;
    }

    /*
     * gettxtIkenshoIraiKubun
     * @return txtIkenshoIraiKubun
     */
    @JsonProperty("txtIkenshoIraiKubun")
    public TextBox getTxtIkenshoIraiKubun() {
        return txtIkenshoIraiKubun;
    }

    /*
     * settxtIkenshoIraiKubun
     * @param txtIkenshoIraiKubun txtIkenshoIraiKubun
     */
    @JsonProperty("txtIkenshoIraiKubun")
    public void setTxtIkenshoIraiKubun(TextBox txtIkenshoIraiKubun) {
        this.txtIkenshoIraiKubun = txtIkenshoIraiKubun;
    }

    /*
     * gettxtIkenshoSakuseiKaisu
     * @return txtIkenshoSakuseiKaisu
     */
    @JsonProperty("txtIkenshoSakuseiKaisu")
    public TextBoxNum getTxtIkenshoSakuseiKaisu() {
        return txtIkenshoSakuseiKaisu;
    }

    /*
     * settxtIkenshoSakuseiKaisu
     * @param txtIkenshoSakuseiKaisu txtIkenshoSakuseiKaisu
     */
    @JsonProperty("txtIkenshoSakuseiKaisu")
    public void setTxtIkenshoSakuseiKaisu(TextBoxNum txtIkenshoSakuseiKaisu) {
        this.txtIkenshoSakuseiKaisu = txtIkenshoSakuseiKaisu;
    }

    /*
     * gettxtShujiiShiteiiKubun
     * @return txtShujiiShiteiiKubun
     */
    @JsonProperty("txtShujiiShiteiiKubun")
    public TextBox getTxtShujiiShiteiiKubun() {
        return txtShujiiShiteiiKubun;
    }

    /*
     * settxtShujiiShiteiiKubun
     * @param txtShujiiShiteiiKubun txtShujiiShiteiiKubun
     */
    @JsonProperty("txtShujiiShiteiiKubun")
    public void setTxtShujiiShiteiiKubun(TextBox txtShujiiShiteiiKubun) {
        this.txtShujiiShiteiiKubun = txtShujiiShiteiiKubun;
    }

    /*
     * gettxtIkenshoIraibi
     * @return txtIkenshoIraibi
     */
    @JsonProperty("txtIkenshoIraibi")
    public TextBoxDate getTxtIkenshoIraibi() {
        return txtIkenshoIraibi;
    }

    /*
     * settxtIkenshoIraibi
     * @param txtIkenshoIraibi txtIkenshoIraibi
     */
    @JsonProperty("txtIkenshoIraibi")
    public void setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.txtIkenshoIraibi = txtIkenshoIraibi;
    }

    /*
     * gettxtIkenshoKinyubi
     * @return txtIkenshoKinyubi
     */
    @JsonProperty("txtIkenshoKinyubi")
    public TextBoxDate getTxtIkenshoKinyubi() {
        return txtIkenshoKinyubi;
    }

    /*
     * settxtIkenshoKinyubi
     * @param txtIkenshoKinyubi txtIkenshoKinyubi
     */
    @JsonProperty("txtIkenshoKinyubi")
    public void setTxtIkenshoKinyubi(TextBoxDate txtIkenshoKinyubi) {
        this.txtIkenshoKinyubi = txtIkenshoKinyubi;
    }

    /*
     * getchkNinteiKekka
     * @return chkNinteiKekka
     */
    @JsonProperty("chkNinteiKekka")
    public CheckBoxList getChkNinteiKekka() {
        return chkNinteiKekka;
    }

    /*
     * setchkNinteiKekka
     * @param chkNinteiKekka chkNinteiKekka
     */
    @JsonProperty("chkNinteiKekka")
    public void setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.chkNinteiKekka = chkNinteiKekka;
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
     * gettxtShujii
     * @return txtShujii
     */
    @JsonProperty("txtShujii")
    public TextBox getTxtShujii() {
        return txtShujii;
    }

    /*
     * settxtShujii
     * @param txtShujii txtShujii
     */
    @JsonProperty("txtShujii")
    public void setTxtShujii(TextBox txtShujii) {
        this.txtShujii = txtShujii;
    }

    /*
     * gettxtIryoKikanCode
     * @return txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public TextBoxCode getTxtIryoKikanCode() {
        return txtIryoKikanCode;
    }

    /*
     * settxtIryoKikanCode
     * @param txtIryoKikanCode txtIryoKikanCode
     */
    @JsonProperty("txtIryoKikanCode")
    public void setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.txtIryoKikanCode = txtIryoKikanCode;
    }

    /*
     * gettxtIryoKikan
     * @return txtIryoKikan
     */
    @JsonProperty("txtIryoKikan")
    public TextBox getTxtIryoKikan() {
        return txtIryoKikan;
    }

    /*
     * settxtIryoKikan
     * @param txtIryoKikan txtIryoKikan
     */
    @JsonProperty("txtIryoKikan")
    public void setTxtIryoKikan(TextBox txtIryoKikan) {
        this.txtIryoKikan = txtIryoKikan;
    }

    /*
     * gettxtYubinGango
     * @return txtYubinGango
     */
    @JsonProperty("txtYubinGango")
    public TextBoxYubinNo getTxtYubinGango() {
        return txtYubinGango;
    }

    /*
     * settxtYubinGango
     * @param txtYubinGango txtYubinGango
     */
    @JsonProperty("txtYubinGango")
    public void setTxtYubinGango(TextBoxYubinNo txtYubinGango) {
        this.txtYubinGango = txtYubinGango;
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
     * gettxtDenwaBangoIkensho
     * @return txtDenwaBangoIkensho
     */
    @JsonProperty("txtDenwaBangoIkensho")
    public TextBoxTelNo getTxtDenwaBangoIkensho() {
        return txtDenwaBangoIkensho;
    }

    /*
     * settxtDenwaBangoIkensho
     * @param txtDenwaBangoIkensho txtDenwaBangoIkensho
     */
    @JsonProperty("txtDenwaBangoIkensho")
    public void setTxtDenwaBangoIkensho(TextBoxTelNo txtDenwaBangoIkensho) {
        this.txtDenwaBangoIkensho = txtDenwaBangoIkensho;
    }

    /*
     * gettxtFaxIkensho
     * @return txtFaxIkensho
     */
    @JsonProperty("txtFaxIkensho")
    public TextBoxTelNo getTxtFaxIkensho() {
        return txtFaxIkensho;
    }

    /*
     * settxtFaxIkensho
     * @param txtFaxIkensho txtFaxIkensho
     */
    @JsonProperty("txtFaxIkensho")
    public void setTxtFaxIkensho(TextBoxTelNo txtFaxIkensho) {
        this.txtFaxIkensho = txtFaxIkensho;
    }

    /*
     * gettxtIryoKikanDaihyoshaShimei
     * @return txtIryoKikanDaihyoshaShimei
     */
    @JsonProperty("txtIryoKikanDaihyoshaShimei")
    public TextBox getTxtIryoKikanDaihyoshaShimei() {
        return txtIryoKikanDaihyoshaShimei;
    }

    /*
     * settxtIryoKikanDaihyoshaShimei
     * @param txtIryoKikanDaihyoshaShimei txtIryoKikanDaihyoshaShimei
     */
    @JsonProperty("txtIryoKikanDaihyoshaShimei")
    public void setTxtIryoKikanDaihyoshaShimei(TextBox txtIryoKikanDaihyoshaShimei) {
        this.txtIryoKikanDaihyoshaShimei = txtIryoKikanDaihyoshaShimei;
    }

    // </editor-fold>
}

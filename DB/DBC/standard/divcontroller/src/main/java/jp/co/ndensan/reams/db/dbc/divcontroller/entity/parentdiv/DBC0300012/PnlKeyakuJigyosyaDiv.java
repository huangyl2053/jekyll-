package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.IKinyuKikanInputDiv;
import jp.co.ndensan.reams.ua.uax.divcontroller.entity.commonchilddiv.KinyuKikanInput.KinyuKikanInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PnlKeyakuJigyosya のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlKeyakuJigyosyaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnCopy")
    private Button btnCopy;
    @JsonProperty("txtJigyosyakeiyakuNo")
    private TextBoxCode txtJigyosyakeiyakuNo;
    @JsonProperty("txtKeyakubi")
    private TextBoxDateRange txtKeyakubi;
    @JsonProperty("ddlKeyakusyurui")
    private DropDownList ddlKeyakusyurui;
    @JsonProperty("txtKeyakuJigyosyaMeisyo")
    private TextBoxAtenaMeisho txtKeyakuJigyosyaMeisyo;
    @JsonProperty("txtKeyakuJigyosyaMeisyoKana")
    private TextBoxAtenaKanaMeisho txtKeyakuJigyosyaMeisyoKana;
    @JsonProperty("txtJigyosyaYubinNo")
    private TextBoxYubinNo txtJigyosyaYubinNo;
    @JsonProperty("txtJigyosyaTel")
    private TextBoxTelNo txtJigyosyaTel;
    @JsonProperty("txtJigyosyaFax")
    private TextBoxTelNo txtJigyosyaFax;
    @JsonProperty("txtJigyosyaJyusyo")
    private TextBoxJusho txtJigyosyaJyusyo;
    @JsonProperty("txtSofusakiYubin")
    private TextBoxYubinNo txtSofusakiYubin;
    @JsonProperty("txtSofusakiJigyosya")
    private TextBoxAtenaMeisho txtSofusakiJigyosya;
    @JsonProperty("txtSofusakiJigyosyaKana")
    private TextBoxAtenaKanaMeisho txtSofusakiJigyosyaKana;
    @JsonProperty("txtSofusakiJyusyo")
    private TextBoxJusho txtSofusakiJyusyo;
    @JsonProperty("txtSofusakiBusyo")
    private TextBox txtSofusakiBusyo;
    @JsonProperty("ddlSofusakiKouzasyubetu")
    private DropDownList ddlSofusakiKouzasyubetu;
    @JsonProperty("txtSofusakiKouzabango")
    private TextBox txtSofusakiKouzabango;
    @JsonProperty("txtSofusakiKouzaMeiginin")
    private TextBoxAtenaMeisho txtSofusakiKouzaMeiginin;
    @JsonProperty("txtSofusakiKouzaMeigininKana")
    private TextBoxAtenaKanaMeisho txtSofusakiKouzaMeigininKana;
    @JsonProperty("ccdKinyukikan")
    private KinyuKikanInputDiv ccdKinyukikan;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnCopy
     * @return btnCopy
     */
    @JsonProperty("btnCopy")
    public Button getBtnCopy() {
        return btnCopy;
    }

    /*
     * setbtnCopy
     * @param btnCopy btnCopy
     */
    @JsonProperty("btnCopy")
    public void setBtnCopy(Button btnCopy) {
        this.btnCopy = btnCopy;
    }

    /*
     * gettxtJigyosyakeiyakuNo
     * @return txtJigyosyakeiyakuNo
     */
    @JsonProperty("txtJigyosyakeiyakuNo")
    public TextBoxCode getTxtJigyosyakeiyakuNo() {
        return txtJigyosyakeiyakuNo;
    }

    /*
     * settxtJigyosyakeiyakuNo
     * @param txtJigyosyakeiyakuNo txtJigyosyakeiyakuNo
     */
    @JsonProperty("txtJigyosyakeiyakuNo")
    public void setTxtJigyosyakeiyakuNo(TextBoxCode txtJigyosyakeiyakuNo) {
        this.txtJigyosyakeiyakuNo = txtJigyosyakeiyakuNo;
    }

    /*
     * gettxtKeyakubi
     * @return txtKeyakubi
     */
    @JsonProperty("txtKeyakubi")
    public TextBoxDateRange getTxtKeyakubi() {
        return txtKeyakubi;
    }

    /*
     * settxtKeyakubi
     * @param txtKeyakubi txtKeyakubi
     */
    @JsonProperty("txtKeyakubi")
    public void setTxtKeyakubi(TextBoxDateRange txtKeyakubi) {
        this.txtKeyakubi = txtKeyakubi;
    }

    /*
     * getddlKeyakusyurui
     * @return ddlKeyakusyurui
     */
    @JsonProperty("ddlKeyakusyurui")
    public DropDownList getDdlKeyakusyurui() {
        return ddlKeyakusyurui;
    }

    /*
     * setddlKeyakusyurui
     * @param ddlKeyakusyurui ddlKeyakusyurui
     */
    @JsonProperty("ddlKeyakusyurui")
    public void setDdlKeyakusyurui(DropDownList ddlKeyakusyurui) {
        this.ddlKeyakusyurui = ddlKeyakusyurui;
    }

    /*
     * gettxtKeyakuJigyosyaMeisyo
     * @return txtKeyakuJigyosyaMeisyo
     */
    @JsonProperty("txtKeyakuJigyosyaMeisyo")
    public TextBoxAtenaMeisho getTxtKeyakuJigyosyaMeisyo() {
        return txtKeyakuJigyosyaMeisyo;
    }

    /*
     * settxtKeyakuJigyosyaMeisyo
     * @param txtKeyakuJigyosyaMeisyo txtKeyakuJigyosyaMeisyo
     */
    @JsonProperty("txtKeyakuJigyosyaMeisyo")
    public void setTxtKeyakuJigyosyaMeisyo(TextBoxAtenaMeisho txtKeyakuJigyosyaMeisyo) {
        this.txtKeyakuJigyosyaMeisyo = txtKeyakuJigyosyaMeisyo;
    }

    /*
     * gettxtKeyakuJigyosyaMeisyoKana
     * @return txtKeyakuJigyosyaMeisyoKana
     */
    @JsonProperty("txtKeyakuJigyosyaMeisyoKana")
    public TextBoxAtenaKanaMeisho getTxtKeyakuJigyosyaMeisyoKana() {
        return txtKeyakuJigyosyaMeisyoKana;
    }

    /*
     * settxtKeyakuJigyosyaMeisyoKana
     * @param txtKeyakuJigyosyaMeisyoKana txtKeyakuJigyosyaMeisyoKana
     */
    @JsonProperty("txtKeyakuJigyosyaMeisyoKana")
    public void setTxtKeyakuJigyosyaMeisyoKana(TextBoxAtenaKanaMeisho txtKeyakuJigyosyaMeisyoKana) {
        this.txtKeyakuJigyosyaMeisyoKana = txtKeyakuJigyosyaMeisyoKana;
    }

    /*
     * gettxtJigyosyaYubinNo
     * @return txtJigyosyaYubinNo
     */
    @JsonProperty("txtJigyosyaYubinNo")
    public TextBoxYubinNo getTxtJigyosyaYubinNo() {
        return txtJigyosyaYubinNo;
    }

    /*
     * settxtJigyosyaYubinNo
     * @param txtJigyosyaYubinNo txtJigyosyaYubinNo
     */
    @JsonProperty("txtJigyosyaYubinNo")
    public void setTxtJigyosyaYubinNo(TextBoxYubinNo txtJigyosyaYubinNo) {
        this.txtJigyosyaYubinNo = txtJigyosyaYubinNo;
    }

    /*
     * gettxtJigyosyaTel
     * @return txtJigyosyaTel
     */
    @JsonProperty("txtJigyosyaTel")
    public TextBoxTelNo getTxtJigyosyaTel() {
        return txtJigyosyaTel;
    }

    /*
     * settxtJigyosyaTel
     * @param txtJigyosyaTel txtJigyosyaTel
     */
    @JsonProperty("txtJigyosyaTel")
    public void setTxtJigyosyaTel(TextBoxTelNo txtJigyosyaTel) {
        this.txtJigyosyaTel = txtJigyosyaTel;
    }

    /*
     * gettxtJigyosyaFax
     * @return txtJigyosyaFax
     */
    @JsonProperty("txtJigyosyaFax")
    public TextBoxTelNo getTxtJigyosyaFax() {
        return txtJigyosyaFax;
    }

    /*
     * settxtJigyosyaFax
     * @param txtJigyosyaFax txtJigyosyaFax
     */
    @JsonProperty("txtJigyosyaFax")
    public void setTxtJigyosyaFax(TextBoxTelNo txtJigyosyaFax) {
        this.txtJigyosyaFax = txtJigyosyaFax;
    }

    /*
     * gettxtJigyosyaJyusyo
     * @return txtJigyosyaJyusyo
     */
    @JsonProperty("txtJigyosyaJyusyo")
    public TextBoxJusho getTxtJigyosyaJyusyo() {
        return txtJigyosyaJyusyo;
    }

    /*
     * settxtJigyosyaJyusyo
     * @param txtJigyosyaJyusyo txtJigyosyaJyusyo
     */
    @JsonProperty("txtJigyosyaJyusyo")
    public void setTxtJigyosyaJyusyo(TextBoxJusho txtJigyosyaJyusyo) {
        this.txtJigyosyaJyusyo = txtJigyosyaJyusyo;
    }

    /*
     * gettxtSofusakiYubin
     * @return txtSofusakiYubin
     */
    @JsonProperty("txtSofusakiYubin")
    public TextBoxYubinNo getTxtSofusakiYubin() {
        return txtSofusakiYubin;
    }

    /*
     * settxtSofusakiYubin
     * @param txtSofusakiYubin txtSofusakiYubin
     */
    @JsonProperty("txtSofusakiYubin")
    public void setTxtSofusakiYubin(TextBoxYubinNo txtSofusakiYubin) {
        this.txtSofusakiYubin = txtSofusakiYubin;
    }

    /*
     * gettxtSofusakiJigyosya
     * @return txtSofusakiJigyosya
     */
    @JsonProperty("txtSofusakiJigyosya")
    public TextBoxAtenaMeisho getTxtSofusakiJigyosya() {
        return txtSofusakiJigyosya;
    }

    /*
     * settxtSofusakiJigyosya
     * @param txtSofusakiJigyosya txtSofusakiJigyosya
     */
    @JsonProperty("txtSofusakiJigyosya")
    public void setTxtSofusakiJigyosya(TextBoxAtenaMeisho txtSofusakiJigyosya) {
        this.txtSofusakiJigyosya = txtSofusakiJigyosya;
    }

    /*
     * gettxtSofusakiJigyosyaKana
     * @return txtSofusakiJigyosyaKana
     */
    @JsonProperty("txtSofusakiJigyosyaKana")
    public TextBoxAtenaKanaMeisho getTxtSofusakiJigyosyaKana() {
        return txtSofusakiJigyosyaKana;
    }

    /*
     * settxtSofusakiJigyosyaKana
     * @param txtSofusakiJigyosyaKana txtSofusakiJigyosyaKana
     */
    @JsonProperty("txtSofusakiJigyosyaKana")
    public void setTxtSofusakiJigyosyaKana(TextBoxAtenaKanaMeisho txtSofusakiJigyosyaKana) {
        this.txtSofusakiJigyosyaKana = txtSofusakiJigyosyaKana;
    }

    /*
     * gettxtSofusakiJyusyo
     * @return txtSofusakiJyusyo
     */
    @JsonProperty("txtSofusakiJyusyo")
    public TextBoxJusho getTxtSofusakiJyusyo() {
        return txtSofusakiJyusyo;
    }

    /*
     * settxtSofusakiJyusyo
     * @param txtSofusakiJyusyo txtSofusakiJyusyo
     */
    @JsonProperty("txtSofusakiJyusyo")
    public void setTxtSofusakiJyusyo(TextBoxJusho txtSofusakiJyusyo) {
        this.txtSofusakiJyusyo = txtSofusakiJyusyo;
    }

    /*
     * gettxtSofusakiBusyo
     * @return txtSofusakiBusyo
     */
    @JsonProperty("txtSofusakiBusyo")
    public TextBox getTxtSofusakiBusyo() {
        return txtSofusakiBusyo;
    }

    /*
     * settxtSofusakiBusyo
     * @param txtSofusakiBusyo txtSofusakiBusyo
     */
    @JsonProperty("txtSofusakiBusyo")
    public void setTxtSofusakiBusyo(TextBox txtSofusakiBusyo) {
        this.txtSofusakiBusyo = txtSofusakiBusyo;
    }

    /*
     * getddlSofusakiKouzasyubetu
     * @return ddlSofusakiKouzasyubetu
     */
    @JsonProperty("ddlSofusakiKouzasyubetu")
    public DropDownList getDdlSofusakiKouzasyubetu() {
        return ddlSofusakiKouzasyubetu;
    }

    /*
     * setddlSofusakiKouzasyubetu
     * @param ddlSofusakiKouzasyubetu ddlSofusakiKouzasyubetu
     */
    @JsonProperty("ddlSofusakiKouzasyubetu")
    public void setDdlSofusakiKouzasyubetu(DropDownList ddlSofusakiKouzasyubetu) {
        this.ddlSofusakiKouzasyubetu = ddlSofusakiKouzasyubetu;
    }

    /*
     * gettxtSofusakiKouzabango
     * @return txtSofusakiKouzabango
     */
    @JsonProperty("txtSofusakiKouzabango")
    public TextBox getTxtSofusakiKouzabango() {
        return txtSofusakiKouzabango;
    }

    /*
     * settxtSofusakiKouzabango
     * @param txtSofusakiKouzabango txtSofusakiKouzabango
     */
    @JsonProperty("txtSofusakiKouzabango")
    public void setTxtSofusakiKouzabango(TextBox txtSofusakiKouzabango) {
        this.txtSofusakiKouzabango = txtSofusakiKouzabango;
    }

    /*
     * gettxtSofusakiKouzaMeiginin
     * @return txtSofusakiKouzaMeiginin
     */
    @JsonProperty("txtSofusakiKouzaMeiginin")
    public TextBoxAtenaMeisho getTxtSofusakiKouzaMeiginin() {
        return txtSofusakiKouzaMeiginin;
    }

    /*
     * settxtSofusakiKouzaMeiginin
     * @param txtSofusakiKouzaMeiginin txtSofusakiKouzaMeiginin
     */
    @JsonProperty("txtSofusakiKouzaMeiginin")
    public void setTxtSofusakiKouzaMeiginin(TextBoxAtenaMeisho txtSofusakiKouzaMeiginin) {
        this.txtSofusakiKouzaMeiginin = txtSofusakiKouzaMeiginin;
    }

    /*
     * gettxtSofusakiKouzaMeigininKana
     * @return txtSofusakiKouzaMeigininKana
     */
    @JsonProperty("txtSofusakiKouzaMeigininKana")
    public TextBoxAtenaKanaMeisho getTxtSofusakiKouzaMeigininKana() {
        return txtSofusakiKouzaMeigininKana;
    }

    /*
     * settxtSofusakiKouzaMeigininKana
     * @param txtSofusakiKouzaMeigininKana txtSofusakiKouzaMeigininKana
     */
    @JsonProperty("txtSofusakiKouzaMeigininKana")
    public void setTxtSofusakiKouzaMeigininKana(TextBoxAtenaKanaMeisho txtSofusakiKouzaMeigininKana) {
        this.txtSofusakiKouzaMeigininKana = txtSofusakiKouzaMeigininKana;
    }

    /*
     * getccdKinyukikan
     * @return ccdKinyukikan
     */
    @JsonProperty("ccdKinyukikan")
    public IKinyuKikanInputDiv getCcdKinyukikan() {
        return ccdKinyukikan;
    }

    // </editor-fold>
}

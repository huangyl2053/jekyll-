package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820023;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * panelFour のクラスファイル
 *
 * @reamsid_L DBC-1030-110 wangkanglei
 */
public class panelFourDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShobyoMei")
    private TextBox txtShobyoMei;
    @JsonProperty("txtShidouKanri")
    private TextBoxNum txtShidouKanri;
    @JsonProperty("txtRibabiriteishon")
    private TextBoxNum txtRibabiriteishon;
    @JsonProperty("txtSeishinkaSenmon")
    private TextBoxNum txtSeishinkaSenmon;
    @JsonProperty("txtTanjyunXline")
    private TextBoxNum txtTanjyunXline;
    @JsonProperty("txtSochi")
    private TextBoxNum txtSochi;
    @JsonProperty("txtTejyutsu")
    private TextBoxNum txtTejyutsu;
    @JsonProperty("btnKeisan")
    private Button btnKeisan;
    @JsonProperty("txtGoukei")
    private TextBoxNum txtGoukei;
    @JsonProperty("txtMutiTekiyo")
    private TextBoxMultiLine txtMutiTekiyo;
    @JsonProperty("btnConfirm")
    private Button btnConfirm;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShobyoMei
     * @return txtShobyoMei
     */
    @JsonProperty("txtShobyoMei")
    public TextBox getTxtShobyoMei() {
        return txtShobyoMei;
    }

    /*
     * settxtShobyoMei
     * @param txtShobyoMei txtShobyoMei
     */
    @JsonProperty("txtShobyoMei")
    public void setTxtShobyoMei(TextBox txtShobyoMei) {
        this.txtShobyoMei = txtShobyoMei;
    }

    /*
     * gettxtShidouKanri
     * @return txtShidouKanri
     */
    @JsonProperty("txtShidouKanri")
    public TextBoxNum getTxtShidouKanri() {
        return txtShidouKanri;
    }

    /*
     * settxtShidouKanri
     * @param txtShidouKanri txtShidouKanri
     */
    @JsonProperty("txtShidouKanri")
    public void setTxtShidouKanri(TextBoxNum txtShidouKanri) {
        this.txtShidouKanri = txtShidouKanri;
    }

    /*
     * gettxtRibabiriteishon
     * @return txtRibabiriteishon
     */
    @JsonProperty("txtRibabiriteishon")
    public TextBoxNum getTxtRibabiriteishon() {
        return txtRibabiriteishon;
    }

    /*
     * settxtRibabiriteishon
     * @param txtRibabiriteishon txtRibabiriteishon
     */
    @JsonProperty("txtRibabiriteishon")
    public void setTxtRibabiriteishon(TextBoxNum txtRibabiriteishon) {
        this.txtRibabiriteishon = txtRibabiriteishon;
    }

    /*
     * gettxtSeishinkaSenmon
     * @return txtSeishinkaSenmon
     */
    @JsonProperty("txtSeishinkaSenmon")
    public TextBoxNum getTxtSeishinkaSenmon() {
        return txtSeishinkaSenmon;
    }

    /*
     * settxtSeishinkaSenmon
     * @param txtSeishinkaSenmon txtSeishinkaSenmon
     */
    @JsonProperty("txtSeishinkaSenmon")
    public void setTxtSeishinkaSenmon(TextBoxNum txtSeishinkaSenmon) {
        this.txtSeishinkaSenmon = txtSeishinkaSenmon;
    }

    /*
     * gettxtTanjyunXline
     * @return txtTanjyunXline
     */
    @JsonProperty("txtTanjyunXline")
    public TextBoxNum getTxtTanjyunXline() {
        return txtTanjyunXline;
    }

    /*
     * settxtTanjyunXline
     * @param txtTanjyunXline txtTanjyunXline
     */
    @JsonProperty("txtTanjyunXline")
    public void setTxtTanjyunXline(TextBoxNum txtTanjyunXline) {
        this.txtTanjyunXline = txtTanjyunXline;
    }

    /*
     * gettxtSochi
     * @return txtSochi
     */
    @JsonProperty("txtSochi")
    public TextBoxNum getTxtSochi() {
        return txtSochi;
    }

    /*
     * settxtSochi
     * @param txtSochi txtSochi
     */
    @JsonProperty("txtSochi")
    public void setTxtSochi(TextBoxNum txtSochi) {
        this.txtSochi = txtSochi;
    }

    /*
     * gettxtTejyutsu
     * @return txtTejyutsu
     */
    @JsonProperty("txtTejyutsu")
    public TextBoxNum getTxtTejyutsu() {
        return txtTejyutsu;
    }

    /*
     * settxtTejyutsu
     * @param txtTejyutsu txtTejyutsu
     */
    @JsonProperty("txtTejyutsu")
    public void setTxtTejyutsu(TextBoxNum txtTejyutsu) {
        this.txtTejyutsu = txtTejyutsu;
    }

    /*
     * getbtnKeisan
     * @return btnKeisan
     */
    @JsonProperty("btnKeisan")
    public Button getBtnKeisan() {
        return btnKeisan;
    }

    /*
     * setbtnKeisan
     * @param btnKeisan btnKeisan
     */
    @JsonProperty("btnKeisan")
    public void setBtnKeisan(Button btnKeisan) {
        this.btnKeisan = btnKeisan;
    }

    /*
     * gettxtGoukei
     * @return txtGoukei
     */
    @JsonProperty("txtGoukei")
    public TextBoxNum getTxtGoukei() {
        return txtGoukei;
    }

    /*
     * settxtGoukei
     * @param txtGoukei txtGoukei
     */
    @JsonProperty("txtGoukei")
    public void setTxtGoukei(TextBoxNum txtGoukei) {
        this.txtGoukei = txtGoukei;
    }

    /*
     * gettxtMutiTekiyo
     * @return txtMutiTekiyo
     */
    @JsonProperty("txtMutiTekiyo")
    public TextBoxMultiLine getTxtMutiTekiyo() {
        return txtMutiTekiyo;
    }

    /*
     * settxtMutiTekiyo
     * @param txtMutiTekiyo txtMutiTekiyo
     */
    @JsonProperty("txtMutiTekiyo")
    public void setTxtMutiTekiyo(TextBoxMultiLine txtMutiTekiyo) {
        this.txtMutiTekiyo = txtMutiTekiyo;
    }

    /*
     * getbtnConfirm
     * @return btnConfirm
     */
    @JsonProperty("btnConfirm")
    public Button getBtnConfirm() {
        return btnConfirm;
    }

    /*
     * setbtnConfirm
     * @param btnConfirm btnConfirm
     */
    @JsonProperty("btnConfirm")
    public void setBtnConfirm(Button btnConfirm) {
        this.btnConfirm = btnConfirm;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    // </editor-fold>
}

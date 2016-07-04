package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseishaFinder.NinteiShinseishaFinder;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosa のクラスファイル
 *
 * @reamsid_L DBE-3000-010 sunhaidi
 */
public class NinteiChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNinteiChosaIinItakuSaki")
    private Label lblNinteiChosaIinItakuSaki;
    @JsonProperty("btnNinteiChosaItakusakiGuide")
    private ButtonDialog btnNinteiChosaItakusakiGuide;
    @JsonProperty("txtNinteiChosaItakusakiName")
    private TextBox txtNinteiChosaItakusakiName;
    @JsonProperty("lblNinteiChosaInShimei")
    private Label lblNinteiChosaInShimei;
    @JsonProperty("btnNinteiChosainGuide")
    private ButtonDialog btnNinteiChosainGuide;
    @JsonProperty("txtNinteiChosainName")
    private TextBox txtNinteiChosainName;
    @JsonProperty("ddlChosaJisshiBasho")
    private DropDownList ddlChosaJisshiBasho;
    @JsonProperty("ddlChosaKubun")
    private DropDownList ddlChosaKubun;
    @JsonProperty("txtChosaJisshiDateFrom")
    private TextBoxFlexibleDate txtChosaJisshiDateFrom;
    @JsonProperty("lblChosaJisshiDate")
    private Label lblChosaJisshiDate;
    @JsonProperty("txtChosaJisshiDateTo")
    private TextBoxFlexibleDate txtChosaJisshiDateTo;
    @JsonProperty("ddlNinteiChosaNetakirido")
    private DropDownList ddlNinteiChosaNetakirido;
    @JsonProperty("ddlNinteiChosaNinchido")
    private DropDownList ddlNinteiChosaNinchido;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNinteiChosaIinItakuSaki
     * @return lblNinteiChosaIinItakuSaki
     */
    @JsonProperty("lblNinteiChosaIinItakuSaki")
    public Label getLblNinteiChosaIinItakuSaki() {
        return lblNinteiChosaIinItakuSaki;
    }

    /*
     * setlblNinteiChosaIinItakuSaki
     * @param lblNinteiChosaIinItakuSaki lblNinteiChosaIinItakuSaki
     */
    @JsonProperty("lblNinteiChosaIinItakuSaki")
    public void setLblNinteiChosaIinItakuSaki(Label lblNinteiChosaIinItakuSaki) {
        this.lblNinteiChosaIinItakuSaki = lblNinteiChosaIinItakuSaki;
    }

    /*
     * getbtnNinteiChosaItakusakiGuide
     * @return btnNinteiChosaItakusakiGuide
     */
    @JsonProperty("btnNinteiChosaItakusakiGuide")
    public ButtonDialog getBtnNinteiChosaItakusakiGuide() {
        return btnNinteiChosaItakusakiGuide;
    }

    /*
     * setbtnNinteiChosaItakusakiGuide
     * @param btnNinteiChosaItakusakiGuide btnNinteiChosaItakusakiGuide
     */
    @JsonProperty("btnNinteiChosaItakusakiGuide")
    public void setBtnNinteiChosaItakusakiGuide(ButtonDialog btnNinteiChosaItakusakiGuide) {
        this.btnNinteiChosaItakusakiGuide = btnNinteiChosaItakusakiGuide;
    }

    /*
     * gettxtNinteiChosaItakusakiName
     * @return txtNinteiChosaItakusakiName
     */
    @JsonProperty("txtNinteiChosaItakusakiName")
    public TextBox getTxtNinteiChosaItakusakiName() {
        return txtNinteiChosaItakusakiName;
    }

    /*
     * settxtNinteiChosaItakusakiName
     * @param txtNinteiChosaItakusakiName txtNinteiChosaItakusakiName
     */
    @JsonProperty("txtNinteiChosaItakusakiName")
    public void setTxtNinteiChosaItakusakiName(TextBox txtNinteiChosaItakusakiName) {
        this.txtNinteiChosaItakusakiName = txtNinteiChosaItakusakiName;
    }

    /*
     * getlblNinteiChosaInShimei
     * @return lblNinteiChosaInShimei
     */
    @JsonProperty("lblNinteiChosaInShimei")
    public Label getLblNinteiChosaInShimei() {
        return lblNinteiChosaInShimei;
    }

    /*
     * setlblNinteiChosaInShimei
     * @param lblNinteiChosaInShimei lblNinteiChosaInShimei
     */
    @JsonProperty("lblNinteiChosaInShimei")
    public void setLblNinteiChosaInShimei(Label lblNinteiChosaInShimei) {
        this.lblNinteiChosaInShimei = lblNinteiChosaInShimei;
    }

    /*
     * getbtnNinteiChosainGuide
     * @return btnNinteiChosainGuide
     */
    @JsonProperty("btnNinteiChosainGuide")
    public ButtonDialog getBtnNinteiChosainGuide() {
        return btnNinteiChosainGuide;
    }

    /*
     * setbtnNinteiChosainGuide
     * @param btnNinteiChosainGuide btnNinteiChosainGuide
     */
    @JsonProperty("btnNinteiChosainGuide")
    public void setBtnNinteiChosainGuide(ButtonDialog btnNinteiChosainGuide) {
        this.btnNinteiChosainGuide = btnNinteiChosainGuide;
    }

    /*
     * gettxtNinteiChosainName
     * @return txtNinteiChosainName
     */
    @JsonProperty("txtNinteiChosainName")
    public TextBox getTxtNinteiChosainName() {
        return txtNinteiChosainName;
    }

    /*
     * settxtNinteiChosainName
     * @param txtNinteiChosainName txtNinteiChosainName
     */
    @JsonProperty("txtNinteiChosainName")
    public void setTxtNinteiChosainName(TextBox txtNinteiChosainName) {
        this.txtNinteiChosainName = txtNinteiChosainName;
    }

    /*
     * getddlChosaJisshiBasho
     * @return ddlChosaJisshiBasho
     */
    @JsonProperty("ddlChosaJisshiBasho")
    public DropDownList getDdlChosaJisshiBasho() {
        return ddlChosaJisshiBasho;
    }

    /*
     * setddlChosaJisshiBasho
     * @param ddlChosaJisshiBasho ddlChosaJisshiBasho
     */
    @JsonProperty("ddlChosaJisshiBasho")
    public void setDdlChosaJisshiBasho(DropDownList ddlChosaJisshiBasho) {
        this.ddlChosaJisshiBasho = ddlChosaJisshiBasho;
    }

    /*
     * getddlChosaKubun
     * @return ddlChosaKubun
     */
    @JsonProperty("ddlChosaKubun")
    public DropDownList getDdlChosaKubun() {
        return ddlChosaKubun;
    }

    /*
     * setddlChosaKubun
     * @param ddlChosaKubun ddlChosaKubun
     */
    @JsonProperty("ddlChosaKubun")
    public void setDdlChosaKubun(DropDownList ddlChosaKubun) {
        this.ddlChosaKubun = ddlChosaKubun;
    }

    /*
     * gettxtChosaJisshiDateFrom
     * @return txtChosaJisshiDateFrom
     */
    @JsonProperty("txtChosaJisshiDateFrom")
    public TextBoxFlexibleDate getTxtChosaJisshiDateFrom() {
        return txtChosaJisshiDateFrom;
    }

    /*
     * settxtChosaJisshiDateFrom
     * @param txtChosaJisshiDateFrom txtChosaJisshiDateFrom
     */
    @JsonProperty("txtChosaJisshiDateFrom")
    public void setTxtChosaJisshiDateFrom(TextBoxFlexibleDate txtChosaJisshiDateFrom) {
        this.txtChosaJisshiDateFrom = txtChosaJisshiDateFrom;
    }

    /*
     * getlblChosaJisshiDate
     * @return lblChosaJisshiDate
     */
    @JsonProperty("lblChosaJisshiDate")
    public Label getLblChosaJisshiDate() {
        return lblChosaJisshiDate;
    }

    /*
     * setlblChosaJisshiDate
     * @param lblChosaJisshiDate lblChosaJisshiDate
     */
    @JsonProperty("lblChosaJisshiDate")
    public void setLblChosaJisshiDate(Label lblChosaJisshiDate) {
        this.lblChosaJisshiDate = lblChosaJisshiDate;
    }

    /*
     * gettxtChosaJisshiDateTo
     * @return txtChosaJisshiDateTo
     */
    @JsonProperty("txtChosaJisshiDateTo")
    public TextBoxFlexibleDate getTxtChosaJisshiDateTo() {
        return txtChosaJisshiDateTo;
    }

    /*
     * settxtChosaJisshiDateTo
     * @param txtChosaJisshiDateTo txtChosaJisshiDateTo
     */
    @JsonProperty("txtChosaJisshiDateTo")
    public void setTxtChosaJisshiDateTo(TextBoxFlexibleDate txtChosaJisshiDateTo) {
        this.txtChosaJisshiDateTo = txtChosaJisshiDateTo;
    }

    /*
     * getddlNinteiChosaNetakirido
     * @return ddlNinteiChosaNetakirido
     */
    @JsonProperty("ddlNinteiChosaNetakirido")
    public DropDownList getDdlNinteiChosaNetakirido() {
        return ddlNinteiChosaNetakirido;
    }

    /*
     * setddlNinteiChosaNetakirido
     * @param ddlNinteiChosaNetakirido ddlNinteiChosaNetakirido
     */
    @JsonProperty("ddlNinteiChosaNetakirido")
    public void setDdlNinteiChosaNetakirido(DropDownList ddlNinteiChosaNetakirido) {
        this.ddlNinteiChosaNetakirido = ddlNinteiChosaNetakirido;
    }

    /*
     * getddlNinteiChosaNinchido
     * @return ddlNinteiChosaNinchido
     */
    @JsonProperty("ddlNinteiChosaNinchido")
    public DropDownList getDdlNinteiChosaNinchido() {
        return ddlNinteiChosaNinchido;
    }

    /*
     * setddlNinteiChosaNinchido
     * @param ddlNinteiChosaNinchido ddlNinteiChosaNinchido
     */
    @JsonProperty("ddlNinteiChosaNinchido")
    public void setDdlNinteiChosaNinchido(DropDownList ddlNinteiChosaNinchido) {
        this.ddlNinteiChosaNinchido = ddlNinteiChosaNinchido;
    }

    // </editor-fold>
}

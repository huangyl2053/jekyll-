package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * IkenshoShujiiIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class IkenshoShujiiIchiranDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShichosonCode")
    private DropDownList ddlShichosonCode;
    @JsonProperty("txtIryoKikanCodeFrom")
    private TextBoxCode txtIryoKikanCodeFrom;
    @JsonProperty("lblFromTo1")
    private Label lblFromTo1;
    @JsonProperty("txtIryoKikanCodeTo")
    private TextBoxCode txtIryoKikanCodeTo;
    @JsonProperty("txtShujiiCodeFrom")
    private TextBoxCode txtShujiiCodeFrom;
    @JsonProperty("lblFromTo2")
    private Label lblFromTo2;
    @JsonProperty("txtShujiiCodeTo")
    private TextBoxCode txtShujiiCodeTo;
    @JsonProperty("radJyokyo")
    private RadioButton radJyokyo;
    @JsonProperty("ddlOutputSort")
    private DropDownList ddlOutputSort;
    @JsonProperty("ddlNextpage")
    private DropDownList ddlNextpage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShichosonCode
     * @return ddlShichosonCode
     */
    @JsonProperty("ddlShichosonCode")
    public DropDownList getDdlShichosonCode() {
        return ddlShichosonCode;
    }

    /*
     * setddlShichosonCode
     * @param ddlShichosonCode ddlShichosonCode
     */
    @JsonProperty("ddlShichosonCode")
    public void setDdlShichosonCode(DropDownList ddlShichosonCode) {
        this.ddlShichosonCode = ddlShichosonCode;
    }

    /*
     * gettxtIryoKikanCodeFrom
     * @return txtIryoKikanCodeFrom
     */
    @JsonProperty("txtIryoKikanCodeFrom")
    public TextBoxCode getTxtIryoKikanCodeFrom() {
        return txtIryoKikanCodeFrom;
    }

    /*
     * settxtIryoKikanCodeFrom
     * @param txtIryoKikanCodeFrom txtIryoKikanCodeFrom
     */
    @JsonProperty("txtIryoKikanCodeFrom")
    public void setTxtIryoKikanCodeFrom(TextBoxCode txtIryoKikanCodeFrom) {
        this.txtIryoKikanCodeFrom = txtIryoKikanCodeFrom;
    }

    /*
     * getlblFromTo1
     * @return lblFromTo1
     */
    @JsonProperty("lblFromTo1")
    public Label getLblFromTo1() {
        return lblFromTo1;
    }

    /*
     * setlblFromTo1
     * @param lblFromTo1 lblFromTo1
     */
    @JsonProperty("lblFromTo1")
    public void setLblFromTo1(Label lblFromTo1) {
        this.lblFromTo1 = lblFromTo1;
    }

    /*
     * gettxtIryoKikanCodeTo
     * @return txtIryoKikanCodeTo
     */
    @JsonProperty("txtIryoKikanCodeTo")
    public TextBoxCode getTxtIryoKikanCodeTo() {
        return txtIryoKikanCodeTo;
    }

    /*
     * settxtIryoKikanCodeTo
     * @param txtIryoKikanCodeTo txtIryoKikanCodeTo
     */
    @JsonProperty("txtIryoKikanCodeTo")
    public void setTxtIryoKikanCodeTo(TextBoxCode txtIryoKikanCodeTo) {
        this.txtIryoKikanCodeTo = txtIryoKikanCodeTo;
    }

    /*
     * gettxtShujiiCodeFrom
     * @return txtShujiiCodeFrom
     */
    @JsonProperty("txtShujiiCodeFrom")
    public TextBoxCode getTxtShujiiCodeFrom() {
        return txtShujiiCodeFrom;
    }

    /*
     * settxtShujiiCodeFrom
     * @param txtShujiiCodeFrom txtShujiiCodeFrom
     */
    @JsonProperty("txtShujiiCodeFrom")
    public void setTxtShujiiCodeFrom(TextBoxCode txtShujiiCodeFrom) {
        this.txtShujiiCodeFrom = txtShujiiCodeFrom;
    }

    /*
     * getlblFromTo2
     * @return lblFromTo2
     */
    @JsonProperty("lblFromTo2")
    public Label getLblFromTo2() {
        return lblFromTo2;
    }

    /*
     * setlblFromTo2
     * @param lblFromTo2 lblFromTo2
     */
    @JsonProperty("lblFromTo2")
    public void setLblFromTo2(Label lblFromTo2) {
        this.lblFromTo2 = lblFromTo2;
    }

    /*
     * gettxtShujiiCodeTo
     * @return txtShujiiCodeTo
     */
    @JsonProperty("txtShujiiCodeTo")
    public TextBoxCode getTxtShujiiCodeTo() {
        return txtShujiiCodeTo;
    }

    /*
     * settxtShujiiCodeTo
     * @param txtShujiiCodeTo txtShujiiCodeTo
     */
    @JsonProperty("txtShujiiCodeTo")
    public void setTxtShujiiCodeTo(TextBoxCode txtShujiiCodeTo) {
        this.txtShujiiCodeTo = txtShujiiCodeTo;
    }

    /*
     * getradJyokyo
     * @return radJyokyo
     */
    @JsonProperty("radJyokyo")
    public RadioButton getRadJyokyo() {
        return radJyokyo;
    }

    /*
     * setradJyokyo
     * @param radJyokyo radJyokyo
     */
    @JsonProperty("radJyokyo")
    public void setRadJyokyo(RadioButton radJyokyo) {
        this.radJyokyo = radJyokyo;
    }

    /*
     * getddlOutputSort
     * @return ddlOutputSort
     */
    @JsonProperty("ddlOutputSort")
    public DropDownList getDdlOutputSort() {
        return ddlOutputSort;
    }

    /*
     * setddlOutputSort
     * @param ddlOutputSort ddlOutputSort
     */
    @JsonProperty("ddlOutputSort")
    public void setDdlOutputSort(DropDownList ddlOutputSort) {
        this.ddlOutputSort = ddlOutputSort;
    }

    /*
     * getddlNextpage
     * @return ddlNextpage
     */
    @JsonProperty("ddlNextpage")
    public DropDownList getDdlNextpage() {
        return ddlNextpage;
    }

    /*
     * setddlNextpage
     * @param ddlNextpage ddlNextpage
     */
    @JsonProperty("ddlNextpage")
    public void setDdlNextpage(DropDownList ddlNextpage) {
        this.ddlNextpage = ddlNextpage;
    }

    // </editor-fold>
}

package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA5010011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * CyushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class CyushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkTaishosha")
    private CheckBoxList chkTaishosha;
    @JsonProperty("lblCyushutuKikan")
    private Label lblCyushutuKikan;
    @JsonProperty("lblShikakuTokusoKikan")
    private Label lblShikakuTokusoKikan;
    @JsonProperty("lblToutatubi")
    private Label lblToutatubi;
    @JsonProperty("txtShikakuTokusoFrom")
    private TextBoxFlexibleDate txtShikakuTokusoFrom;
    @JsonProperty("lblShikakuTokusoFromTo")
    private Label lblShikakuTokusoFromTo;
    @JsonProperty("txtShikakuTokusoTo")
    private TextBoxFlexibleDate txtShikakuTokusoTo;
    @JsonProperty("ddlShikakuKubun")
    private DropDownList ddlShikakuKubun;
    @JsonProperty("ddlZensisyouson")
    private DropDownList ddlZensisyouson;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkTaishosha
     * @return chkTaishosha
     */
    @JsonProperty("chkTaishosha")
    public CheckBoxList getChkTaishosha() {
        return chkTaishosha;
    }

    /*
     * setchkTaishosha
     * @param chkTaishosha chkTaishosha
     */
    @JsonProperty("chkTaishosha")
    public void setChkTaishosha(CheckBoxList chkTaishosha) {
        this.chkTaishosha = chkTaishosha;
    }

    /*
     * getlblCyushutuKikan
     * @return lblCyushutuKikan
     */
    @JsonProperty("lblCyushutuKikan")
    public Label getLblCyushutuKikan() {
        return lblCyushutuKikan;
    }

    /*
     * setlblCyushutuKikan
     * @param lblCyushutuKikan lblCyushutuKikan
     */
    @JsonProperty("lblCyushutuKikan")
    public void setLblCyushutuKikan(Label lblCyushutuKikan) {
        this.lblCyushutuKikan = lblCyushutuKikan;
    }

    /*
     * getlblShikakuTokusoKikan
     * @return lblShikakuTokusoKikan
     */
    @JsonProperty("lblShikakuTokusoKikan")
    public Label getLblShikakuTokusoKikan() {
        return lblShikakuTokusoKikan;
    }

    /*
     * setlblShikakuTokusoKikan
     * @param lblShikakuTokusoKikan lblShikakuTokusoKikan
     */
    @JsonProperty("lblShikakuTokusoKikan")
    public void setLblShikakuTokusoKikan(Label lblShikakuTokusoKikan) {
        this.lblShikakuTokusoKikan = lblShikakuTokusoKikan;
    }

    /*
     * getlblToutatubi
     * @return lblToutatubi
     */
    @JsonProperty("lblToutatubi")
    public Label getLblToutatubi() {
        return lblToutatubi;
    }

    /*
     * setlblToutatubi
     * @param lblToutatubi lblToutatubi
     */
    @JsonProperty("lblToutatubi")
    public void setLblToutatubi(Label lblToutatubi) {
        this.lblToutatubi = lblToutatubi;
    }

    /*
     * gettxtShikakuTokusoFrom
     * @return txtShikakuTokusoFrom
     */
    @JsonProperty("txtShikakuTokusoFrom")
    public TextBoxFlexibleDate getTxtShikakuTokusoFrom() {
        return txtShikakuTokusoFrom;
    }

    /*
     * settxtShikakuTokusoFrom
     * @param txtShikakuTokusoFrom txtShikakuTokusoFrom
     */
    @JsonProperty("txtShikakuTokusoFrom")
    public void setTxtShikakuTokusoFrom(TextBoxFlexibleDate txtShikakuTokusoFrom) {
        this.txtShikakuTokusoFrom = txtShikakuTokusoFrom;
    }

    /*
     * getlblShikakuTokusoFromTo
     * @return lblShikakuTokusoFromTo
     */
    @JsonProperty("lblShikakuTokusoFromTo")
    public Label getLblShikakuTokusoFromTo() {
        return lblShikakuTokusoFromTo;
    }

    /*
     * setlblShikakuTokusoFromTo
     * @param lblShikakuTokusoFromTo lblShikakuTokusoFromTo
     */
    @JsonProperty("lblShikakuTokusoFromTo")
    public void setLblShikakuTokusoFromTo(Label lblShikakuTokusoFromTo) {
        this.lblShikakuTokusoFromTo = lblShikakuTokusoFromTo;
    }

    /*
     * gettxtShikakuTokusoTo
     * @return txtShikakuTokusoTo
     */
    @JsonProperty("txtShikakuTokusoTo")
    public TextBoxFlexibleDate getTxtShikakuTokusoTo() {
        return txtShikakuTokusoTo;
    }

    /*
     * settxtShikakuTokusoTo
     * @param txtShikakuTokusoTo txtShikakuTokusoTo
     */
    @JsonProperty("txtShikakuTokusoTo")
    public void setTxtShikakuTokusoTo(TextBoxFlexibleDate txtShikakuTokusoTo) {
        this.txtShikakuTokusoTo = txtShikakuTokusoTo;
    }

    /*
     * getddlShikakuKubun
     * @return ddlShikakuKubun
     */
    @JsonProperty("ddlShikakuKubun")
    public DropDownList getDdlShikakuKubun() {
        return ddlShikakuKubun;
    }

    /*
     * setddlShikakuKubun
     * @param ddlShikakuKubun ddlShikakuKubun
     */
    @JsonProperty("ddlShikakuKubun")
    public void setDdlShikakuKubun(DropDownList ddlShikakuKubun) {
        this.ddlShikakuKubun = ddlShikakuKubun;
    }

    /*
     * getddlZensisyouson
     * @return ddlZensisyouson
     */
    @JsonProperty("ddlZensisyouson")
    public DropDownList getDdlZensisyouson() {
        return ddlZensisyouson;
    }

    /*
     * setddlZensisyouson
     * @param ddlZensisyouson ddlZensisyouson
     */
    @JsonProperty("ddlZensisyouson")
    public void setDdlZensisyouson(DropDownList ddlZensisyouson) {
        this.ddlZensisyouson = ddlZensisyouson;
    }

    // </editor-fold>
}

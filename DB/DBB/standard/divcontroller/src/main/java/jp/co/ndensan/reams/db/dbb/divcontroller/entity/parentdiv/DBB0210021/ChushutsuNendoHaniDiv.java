package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0210021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuNendoHani のクラスファイル
 *
 * @reamsid_L DBB-1630-010 wangxingpeng
 */
public class ChushutsuNendoHaniDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNendoFrom")
    private Label lblNendoFrom;
    @JsonProperty("lblNendoTo")
    private Label lblNendoTo;
    @JsonProperty("txtChoteiNendoRange")
    private TextBoxDateRange txtChoteiNendoRange;
    @JsonProperty("ddlChoteiKijunY")
    private DropDownList ddlChoteiKijunY;
    @JsonProperty("ddlChoteiKijunM")
    private DropDownList ddlChoteiKijunM;
    @JsonProperty("txtFukaNendoRange")
    private TextBoxDateRange txtFukaNendoRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNendoFrom
     * @return lblNendoFrom
     */
    @JsonProperty("lblNendoFrom")
    public Label getLblNendoFrom() {
        return lblNendoFrom;
    }

    /*
     * setlblNendoFrom
     * @param lblNendoFrom lblNendoFrom
     */
    @JsonProperty("lblNendoFrom")
    public void setLblNendoFrom(Label lblNendoFrom) {
        this.lblNendoFrom = lblNendoFrom;
    }

    /*
     * getlblNendoTo
     * @return lblNendoTo
     */
    @JsonProperty("lblNendoTo")
    public Label getLblNendoTo() {
        return lblNendoTo;
    }

    /*
     * setlblNendoTo
     * @param lblNendoTo lblNendoTo
     */
    @JsonProperty("lblNendoTo")
    public void setLblNendoTo(Label lblNendoTo) {
        this.lblNendoTo = lblNendoTo;
    }

    /*
     * gettxtChoteiNendoRange
     * @return txtChoteiNendoRange
     */
    @JsonProperty("txtChoteiNendoRange")
    public TextBoxDateRange getTxtChoteiNendoRange() {
        return txtChoteiNendoRange;
    }

    /*
     * settxtChoteiNendoRange
     * @param txtChoteiNendoRange txtChoteiNendoRange
     */
    @JsonProperty("txtChoteiNendoRange")
    public void setTxtChoteiNendoRange(TextBoxDateRange txtChoteiNendoRange) {
        this.txtChoteiNendoRange = txtChoteiNendoRange;
    }

    /*
     * getddlChoteiKijunY
     * @return ddlChoteiKijunY
     */
    @JsonProperty("ddlChoteiKijunY")
    public DropDownList getDdlChoteiKijunY() {
        return ddlChoteiKijunY;
    }

    /*
     * setddlChoteiKijunY
     * @param ddlChoteiKijunY ddlChoteiKijunY
     */
    @JsonProperty("ddlChoteiKijunY")
    public void setDdlChoteiKijunY(DropDownList ddlChoteiKijunY) {
        this.ddlChoteiKijunY = ddlChoteiKijunY;
    }

    /*
     * getddlChoteiKijunM
     * @return ddlChoteiKijunM
     */
    @JsonProperty("ddlChoteiKijunM")
    public DropDownList getDdlChoteiKijunM() {
        return ddlChoteiKijunM;
    }

    /*
     * setddlChoteiKijunM
     * @param ddlChoteiKijunM ddlChoteiKijunM
     */
    @JsonProperty("ddlChoteiKijunM")
    public void setDdlChoteiKijunM(DropDownList ddlChoteiKijunM) {
        this.ddlChoteiKijunM = ddlChoteiKijunM;
    }

    /*
     * gettxtFukaNendoRange
     * @return txtFukaNendoRange
     */
    @JsonProperty("txtFukaNendoRange")
    public TextBoxDateRange getTxtFukaNendoRange() {
        return txtFukaNendoRange;
    }

    /*
     * settxtFukaNendoRange
     * @param txtFukaNendoRange txtFukaNendoRange
     */
    @JsonProperty("txtFukaNendoRange")
    public void setTxtFukaNendoRange(TextBoxDateRange txtFukaNendoRange) {
        this.txtFukaNendoRange = txtFukaNendoRange;
    }

    // </editor-fold>
}

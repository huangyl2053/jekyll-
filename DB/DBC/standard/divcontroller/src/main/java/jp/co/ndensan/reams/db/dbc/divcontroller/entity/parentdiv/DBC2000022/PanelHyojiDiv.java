package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000022;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * PanelHyoji のクラスファイル
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class PanelHyojiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;
    @JsonProperty("ddlRirekiNo")
    private DropDownList ddlRirekiNo;
    @JsonProperty("btnHyoji")
    private Button btnHyoji;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("txtHanteibi")
    private TextBoxDate txtHanteibi;
    @JsonProperty("txtHanteiKubun")
    private TextBox txtHanteiKubun;
    @JsonProperty("btnSeikatsuHogo")
    private ButtonDialog btnSeikatsuHogo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    /*
     * getddlRirekiNo
     * @return ddlRirekiNo
     */
    @JsonProperty("ddlRirekiNo")
    public DropDownList getDdlRirekiNo() {
        return ddlRirekiNo;
    }

    /*
     * setddlRirekiNo
     * @param ddlRirekiNo ddlRirekiNo
     */
    @JsonProperty("ddlRirekiNo")
    public void setDdlRirekiNo(DropDownList ddlRirekiNo) {
        this.ddlRirekiNo = ddlRirekiNo;
    }

    /*
     * getbtnHyoji
     * @return btnHyoji
     */
    @JsonProperty("btnHyoji")
    public Button getBtnHyoji() {
        return btnHyoji;
    }

    /*
     * setbtnHyoji
     * @param btnHyoji btnHyoji
     */
    @JsonProperty("btnHyoji")
    public void setBtnHyoji(Button btnHyoji) {
        this.btnHyoji = btnHyoji;
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

    /*
     * gettxtHanteibi
     * @return txtHanteibi
     */
    @JsonProperty("txtHanteibi")
    public TextBoxDate getTxtHanteibi() {
        return txtHanteibi;
    }

    /*
     * settxtHanteibi
     * @param txtHanteibi txtHanteibi
     */
    @JsonProperty("txtHanteibi")
    public void setTxtHanteibi(TextBoxDate txtHanteibi) {
        this.txtHanteibi = txtHanteibi;
    }

    /*
     * gettxtHanteiKubun
     * @return txtHanteiKubun
     */
    @JsonProperty("txtHanteiKubun")
    public TextBox getTxtHanteiKubun() {
        return txtHanteiKubun;
    }

    /*
     * settxtHanteiKubun
     * @param txtHanteiKubun txtHanteiKubun
     */
    @JsonProperty("txtHanteiKubun")
    public void setTxtHanteiKubun(TextBox txtHanteiKubun) {
        this.txtHanteiKubun = txtHanteiKubun;
    }

    /*
     * getbtnSeikatsuHogo
     * @return btnSeikatsuHogo
     */
    @JsonProperty("btnSeikatsuHogo")
    public ButtonDialog getBtnSeikatsuHogo() {
        return btnSeikatsuHogo;
    }

    /*
     * setbtnSeikatsuHogo
     * @param btnSeikatsuHogo btnSeikatsuHogo
     */
    @JsonProperty("btnSeikatsuHogo")
    public void setBtnSeikatsuHogo(ButtonDialog btnSeikatsuHogo) {
        this.btnSeikatsuHogo = btnSeikatsuHogo;
    }

    // </editor-fold>
}

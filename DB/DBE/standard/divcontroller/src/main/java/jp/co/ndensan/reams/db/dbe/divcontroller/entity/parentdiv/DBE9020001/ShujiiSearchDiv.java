package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiSearch のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiSearchDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchShujiiIryokikanCodeFrom")
    private TextBoxCode txtSearchShujiiIryokikanCodeFrom;
    @JsonProperty("txtSearchShujiiIryokikanCodeTo")
    private TextBoxCode txtSearchShujiiIryokikanCodeTo;
    @JsonProperty("txtSearchShujiiCodeFrom")
    private TextBoxCode txtSearchShujiiCodeFrom;
    @JsonProperty("txtSearchShujiiCodeTo")
    private TextBoxCode txtSearchShujiiCodeTo;
    @JsonProperty("txtSearchShujiiIryokikanMeisho")
    private TextBox txtSearchShujiiIryokikanMeisho;
    @JsonProperty("ddlKikanMeisho")
    private DropDownList ddlKikanMeisho;
    @JsonProperty("txtSearchShujiiIryokikanKanaMeisho")
    private TextBoxKana txtSearchShujiiIryokikanKanaMeisho;
    @JsonProperty("ddlKikanKanaMeisho")
    private DropDownList ddlKikanKanaMeisho;
    @JsonProperty("txtSearchShujiiShimei")
    private TextBox txtSearchShujiiShimei;
    @JsonProperty("ddlShujiiMeisho")
    private DropDownList ddlShujiiMeisho;
    @JsonProperty("txtSearchShujiiKanaShimei")
    private TextBoxKana txtSearchShujiiKanaShimei;
    @JsonProperty("ddlShujiiKanaMeisho")
    private DropDownList ddlShujiiKanaMeisho;
    @JsonProperty("radSearchJokyoFlag")
    private RadioButton radSearchJokyoFlag;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("btnClearKensakuJoken")
    private Button btnClearKensakuJoken;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSearchShujiiIryokikanCodeFrom
     * @return txtSearchShujiiIryokikanCodeFrom
     */
    @JsonProperty("txtSearchShujiiIryokikanCodeFrom")
    public TextBoxCode getTxtSearchShujiiIryokikanCodeFrom() {
        return txtSearchShujiiIryokikanCodeFrom;
    }

    /*
     * settxtSearchShujiiIryokikanCodeFrom
     * @param txtSearchShujiiIryokikanCodeFrom txtSearchShujiiIryokikanCodeFrom
     */
    @JsonProperty("txtSearchShujiiIryokikanCodeFrom")
    public void setTxtSearchShujiiIryokikanCodeFrom(TextBoxCode txtSearchShujiiIryokikanCodeFrom) {
        this.txtSearchShujiiIryokikanCodeFrom = txtSearchShujiiIryokikanCodeFrom;
    }

    /*
     * gettxtSearchShujiiIryokikanCodeTo
     * @return txtSearchShujiiIryokikanCodeTo
     */
    @JsonProperty("txtSearchShujiiIryokikanCodeTo")
    public TextBoxCode getTxtSearchShujiiIryokikanCodeTo() {
        return txtSearchShujiiIryokikanCodeTo;
    }

    /*
     * settxtSearchShujiiIryokikanCodeTo
     * @param txtSearchShujiiIryokikanCodeTo txtSearchShujiiIryokikanCodeTo
     */
    @JsonProperty("txtSearchShujiiIryokikanCodeTo")
    public void setTxtSearchShujiiIryokikanCodeTo(TextBoxCode txtSearchShujiiIryokikanCodeTo) {
        this.txtSearchShujiiIryokikanCodeTo = txtSearchShujiiIryokikanCodeTo;
    }

    /*
     * gettxtSearchShujiiCodeFrom
     * @return txtSearchShujiiCodeFrom
     */
    @JsonProperty("txtSearchShujiiCodeFrom")
    public TextBoxCode getTxtSearchShujiiCodeFrom() {
        return txtSearchShujiiCodeFrom;
    }

    /*
     * settxtSearchShujiiCodeFrom
     * @param txtSearchShujiiCodeFrom txtSearchShujiiCodeFrom
     */
    @JsonProperty("txtSearchShujiiCodeFrom")
    public void setTxtSearchShujiiCodeFrom(TextBoxCode txtSearchShujiiCodeFrom) {
        this.txtSearchShujiiCodeFrom = txtSearchShujiiCodeFrom;
    }

    /*
     * gettxtSearchShujiiCodeTo
     * @return txtSearchShujiiCodeTo
     */
    @JsonProperty("txtSearchShujiiCodeTo")
    public TextBoxCode getTxtSearchShujiiCodeTo() {
        return txtSearchShujiiCodeTo;
    }

    /*
     * settxtSearchShujiiCodeTo
     * @param txtSearchShujiiCodeTo txtSearchShujiiCodeTo
     */
    @JsonProperty("txtSearchShujiiCodeTo")
    public void setTxtSearchShujiiCodeTo(TextBoxCode txtSearchShujiiCodeTo) {
        this.txtSearchShujiiCodeTo = txtSearchShujiiCodeTo;
    }

    /*
     * gettxtSearchShujiiIryokikanMeisho
     * @return txtSearchShujiiIryokikanMeisho
     */
    @JsonProperty("txtSearchShujiiIryokikanMeisho")
    public TextBox getTxtSearchShujiiIryokikanMeisho() {
        return txtSearchShujiiIryokikanMeisho;
    }

    /*
     * settxtSearchShujiiIryokikanMeisho
     * @param txtSearchShujiiIryokikanMeisho txtSearchShujiiIryokikanMeisho
     */
    @JsonProperty("txtSearchShujiiIryokikanMeisho")
    public void setTxtSearchShujiiIryokikanMeisho(TextBox txtSearchShujiiIryokikanMeisho) {
        this.txtSearchShujiiIryokikanMeisho = txtSearchShujiiIryokikanMeisho;
    }

    /*
     * getddlKikanMeisho
     * @return ddlKikanMeisho
     */
    @JsonProperty("ddlKikanMeisho")
    public DropDownList getDdlKikanMeisho() {
        return ddlKikanMeisho;
    }

    /*
     * setddlKikanMeisho
     * @param ddlKikanMeisho ddlKikanMeisho
     */
    @JsonProperty("ddlKikanMeisho")
    public void setDdlKikanMeisho(DropDownList ddlKikanMeisho) {
        this.ddlKikanMeisho = ddlKikanMeisho;
    }

    /*
     * gettxtSearchShujiiIryokikanKanaMeisho
     * @return txtSearchShujiiIryokikanKanaMeisho
     */
    @JsonProperty("txtSearchShujiiIryokikanKanaMeisho")
    public TextBoxKana getTxtSearchShujiiIryokikanKanaMeisho() {
        return txtSearchShujiiIryokikanKanaMeisho;
    }

    /*
     * settxtSearchShujiiIryokikanKanaMeisho
     * @param txtSearchShujiiIryokikanKanaMeisho txtSearchShujiiIryokikanKanaMeisho
     */
    @JsonProperty("txtSearchShujiiIryokikanKanaMeisho")
    public void setTxtSearchShujiiIryokikanKanaMeisho(TextBoxKana txtSearchShujiiIryokikanKanaMeisho) {
        this.txtSearchShujiiIryokikanKanaMeisho = txtSearchShujiiIryokikanKanaMeisho;
    }

    /*
     * getddlKikanKanaMeisho
     * @return ddlKikanKanaMeisho
     */
    @JsonProperty("ddlKikanKanaMeisho")
    public DropDownList getDdlKikanKanaMeisho() {
        return ddlKikanKanaMeisho;
    }

    /*
     * setddlKikanKanaMeisho
     * @param ddlKikanKanaMeisho ddlKikanKanaMeisho
     */
    @JsonProperty("ddlKikanKanaMeisho")
    public void setDdlKikanKanaMeisho(DropDownList ddlKikanKanaMeisho) {
        this.ddlKikanKanaMeisho = ddlKikanKanaMeisho;
    }

    /*
     * gettxtSearchShujiiShimei
     * @return txtSearchShujiiShimei
     */
    @JsonProperty("txtSearchShujiiShimei")
    public TextBox getTxtSearchShujiiShimei() {
        return txtSearchShujiiShimei;
    }

    /*
     * settxtSearchShujiiShimei
     * @param txtSearchShujiiShimei txtSearchShujiiShimei
     */
    @JsonProperty("txtSearchShujiiShimei")
    public void setTxtSearchShujiiShimei(TextBox txtSearchShujiiShimei) {
        this.txtSearchShujiiShimei = txtSearchShujiiShimei;
    }

    /*
     * getddlShujiiMeisho
     * @return ddlShujiiMeisho
     */
    @JsonProperty("ddlShujiiMeisho")
    public DropDownList getDdlShujiiMeisho() {
        return ddlShujiiMeisho;
    }

    /*
     * setddlShujiiMeisho
     * @param ddlShujiiMeisho ddlShujiiMeisho
     */
    @JsonProperty("ddlShujiiMeisho")
    public void setDdlShujiiMeisho(DropDownList ddlShujiiMeisho) {
        this.ddlShujiiMeisho = ddlShujiiMeisho;
    }

    /*
     * gettxtSearchShujiiKanaShimei
     * @return txtSearchShujiiKanaShimei
     */
    @JsonProperty("txtSearchShujiiKanaShimei")
    public TextBoxKana getTxtSearchShujiiKanaShimei() {
        return txtSearchShujiiKanaShimei;
    }

    /*
     * settxtSearchShujiiKanaShimei
     * @param txtSearchShujiiKanaShimei txtSearchShujiiKanaShimei
     */
    @JsonProperty("txtSearchShujiiKanaShimei")
    public void setTxtSearchShujiiKanaShimei(TextBoxKana txtSearchShujiiKanaShimei) {
        this.txtSearchShujiiKanaShimei = txtSearchShujiiKanaShimei;
    }

    /*
     * getddlShujiiKanaMeisho
     * @return ddlShujiiKanaMeisho
     */
    @JsonProperty("ddlShujiiKanaMeisho")
    public DropDownList getDdlShujiiKanaMeisho() {
        return ddlShujiiKanaMeisho;
    }

    /*
     * setddlShujiiKanaMeisho
     * @param ddlShujiiKanaMeisho ddlShujiiKanaMeisho
     */
    @JsonProperty("ddlShujiiKanaMeisho")
    public void setDdlShujiiKanaMeisho(DropDownList ddlShujiiKanaMeisho) {
        this.ddlShujiiKanaMeisho = ddlShujiiKanaMeisho;
    }

    /*
     * getradSearchJokyoFlag
     * @return radSearchJokyoFlag
     */
    @JsonProperty("radSearchJokyoFlag")
    public RadioButton getRadSearchJokyoFlag() {
        return radSearchJokyoFlag;
    }

    /*
     * setradSearchJokyoFlag
     * @param radSearchJokyoFlag radSearchJokyoFlag
     */
    @JsonProperty("radSearchJokyoFlag")
    public void setRadSearchJokyoFlag(RadioButton radSearchJokyoFlag) {
        this.radSearchJokyoFlag = radSearchJokyoFlag;
    }

    /*
     * gettxtSaidaiHyojiKensu
     * @return txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return txtSaidaiHyojiKensu;
    }

    /*
     * settxtSaidaiHyojiKensu
     * @param txtSaidaiHyojiKensu txtSaidaiHyojiKensu
     */
    @JsonProperty("txtSaidaiHyojiKensu")
    public void setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.txtSaidaiHyojiKensu = txtSaidaiHyojiKensu;
    }

    /*
     * getbtnClearKensakuJoken
     * @return btnClearKensakuJoken
     */
    @JsonProperty("btnClearKensakuJoken")
    public Button getBtnClearKensakuJoken() {
        return btnClearKensakuJoken;
    }

    /*
     * setbtnClearKensakuJoken
     * @param btnClearKensakuJoken btnClearKensakuJoken
     */
    @JsonProperty("btnClearKensakuJoken")
    public void setBtnClearKensakuJoken(Button btnClearKensakuJoken) {
        this.btnClearKensakuJoken = btnClearKensakuJoken;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    // </editor-fold>
}

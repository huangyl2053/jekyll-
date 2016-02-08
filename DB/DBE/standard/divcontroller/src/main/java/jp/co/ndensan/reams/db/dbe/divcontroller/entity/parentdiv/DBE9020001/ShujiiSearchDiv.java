package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9020001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlSearchShichoson")
    private DropDownList ddlSearchShichoson;
    @JsonProperty("txtSearchShujiiIryokikanCodeFrom")
    private TextBoxCode txtSearchShujiiIryokikanCodeFrom;
    @JsonProperty("txtSearchShujiiIryokikanCodeTo")
    private TextBoxCode txtSearchShujiiIryokikanCodeTo;
    @JsonProperty("txtSearchShujiiIryokikanMeisho")
    private TextBox txtSearchShujiiIryokikanMeisho;
    @JsonProperty("txtSearchShujiiIryokikanKanaMeisho")
    private TextBoxKana txtSearchShujiiIryokikanKanaMeisho;
    @JsonProperty("txtSearchShujiiCodeFrom")
    private TextBoxCode txtSearchShujiiCodeFrom;
    @JsonProperty("txtSearchShujiiCodeTo")
    private TextBoxCode txtSearchShujiiCodeTo;
    @JsonProperty("txtSearchShujiiShimei")
    private TextBox txtSearchShujiiShimei;
    @JsonProperty("txtSearchShujiiKanaShimei")
    private TextBoxKana txtSearchShujiiKanaShimei;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("radSearchJokyoFlag")
    private RadioButton radSearchJokyoFlag;
    @JsonProperty("btnSearchShujii")
    private Button btnSearchShujii;
    @JsonProperty("btnClearKensakuJoken")
    private Button btnClearKensakuJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlSearchShichoson
     * @return ddlSearchShichoson
     */
    @JsonProperty("ddlSearchShichoson")
    public DropDownList getDdlSearchShichoson() {
        return ddlSearchShichoson;
    }

    /*
     * setddlSearchShichoson
     * @param ddlSearchShichoson ddlSearchShichoson
     */
    @JsonProperty("ddlSearchShichoson")
    public void setDdlSearchShichoson(DropDownList ddlSearchShichoson) {
        this.ddlSearchShichoson = ddlSearchShichoson;
    }

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
     * getbtnSearchShujii
     * @return btnSearchShujii
     */
    @JsonProperty("btnSearchShujii")
    public Button getBtnSearchShujii() {
        return btnSearchShujii;
    }

    /*
     * setbtnSearchShujii
     * @param btnSearchShujii btnSearchShujii
     */
    @JsonProperty("btnSearchShujii")
    public void setBtnSearchShujii(Button btnSearchShujii) {
        this.btnSearchShujii = btnSearchShujii;
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

    // </editor-fold>
}

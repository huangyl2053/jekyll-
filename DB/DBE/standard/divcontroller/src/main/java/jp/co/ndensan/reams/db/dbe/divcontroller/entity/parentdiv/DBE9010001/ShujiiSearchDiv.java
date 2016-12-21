package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9010001;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
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
    @JsonProperty("txtSearchShujiiIryokikanMeisho")
    private TextBox txtSearchShujiiIryokikanMeisho;
    @JsonProperty("ddlKikanMeisho")
    private DropDownList ddlKikanMeisho;
    @JsonProperty("txtSearchShujiiIryokikanKanaMeisho")
    private TextBoxKana txtSearchShujiiIryokikanKanaMeisho;
    @JsonProperty("ddlKikanKanaMeisho")
    private DropDownList ddlKikanKanaMeisho;
    @JsonProperty("radSearchJokyoFlag")
    private RadioButton radSearchJokyoFlag;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("btnSearchShujii")
    private Button btnSearchShujii;
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

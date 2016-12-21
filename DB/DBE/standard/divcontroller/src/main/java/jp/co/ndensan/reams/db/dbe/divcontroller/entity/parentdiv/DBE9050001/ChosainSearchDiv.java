package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001;
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
 * ChosainSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosainSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radSearchHaisiFlag")
    private RadioButton radSearchHaisiFlag;
    @JsonProperty("txtSearchSonotaKikanCodeFrom")
    private TextBoxCode txtSearchSonotaKikanCodeFrom;
    @JsonProperty("txtSearchSonotaKikanCodeTo")
    private TextBoxCode txtSearchSonotaKikanCodeTo;
    @JsonProperty("txtSearchSonotaKikanMeisho")
    private TextBox txtSearchSonotaKikanMeisho;
    @JsonProperty("txtSearchSonotaKikanKanaMeisho")
    private TextBoxKana txtSearchSonotaKikanKanaMeisho;
    @JsonProperty("ddlkikankubun")
    private DropDownList ddlkikankubun;
    @JsonProperty("ddlitakukubun")
    private DropDownList ddlitakukubun;
    @JsonProperty("txtSaidaiHyojiKensu")
    private TextBoxNum txtSaidaiHyojiKensu;
    @JsonProperty("btnSearchShujii")
    private Button btnSearchShujii;
    @JsonProperty("btnClearKensakuJoken")
    private Button btnClearKensakuJoken;
    @JsonProperty("ccdhokensha")
    private HokenshaListDiv ccdhokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradSearchHaisiFlag
     * @return radSearchHaisiFlag
     */
    @JsonProperty("radSearchHaisiFlag")
    public RadioButton getRadSearchHaisiFlag() {
        return radSearchHaisiFlag;
    }

    /*
     * setradSearchHaisiFlag
     * @param radSearchHaisiFlag radSearchHaisiFlag
     */
    @JsonProperty("radSearchHaisiFlag")
    public void setRadSearchHaisiFlag(RadioButton radSearchHaisiFlag) {
        this.radSearchHaisiFlag = radSearchHaisiFlag;
    }

    /*
     * gettxtSearchSonotaKikanCodeFrom
     * @return txtSearchSonotaKikanCodeFrom
     */
    @JsonProperty("txtSearchSonotaKikanCodeFrom")
    public TextBoxCode getTxtSearchSonotaKikanCodeFrom() {
        return txtSearchSonotaKikanCodeFrom;
    }

    /*
     * settxtSearchSonotaKikanCodeFrom
     * @param txtSearchSonotaKikanCodeFrom txtSearchSonotaKikanCodeFrom
     */
    @JsonProperty("txtSearchSonotaKikanCodeFrom")
    public void setTxtSearchSonotaKikanCodeFrom(TextBoxCode txtSearchSonotaKikanCodeFrom) {
        this.txtSearchSonotaKikanCodeFrom = txtSearchSonotaKikanCodeFrom;
    }

    /*
     * gettxtSearchSonotaKikanCodeTo
     * @return txtSearchSonotaKikanCodeTo
     */
    @JsonProperty("txtSearchSonotaKikanCodeTo")
    public TextBoxCode getTxtSearchSonotaKikanCodeTo() {
        return txtSearchSonotaKikanCodeTo;
    }

    /*
     * settxtSearchSonotaKikanCodeTo
     * @param txtSearchSonotaKikanCodeTo txtSearchSonotaKikanCodeTo
     */
    @JsonProperty("txtSearchSonotaKikanCodeTo")
    public void setTxtSearchSonotaKikanCodeTo(TextBoxCode txtSearchSonotaKikanCodeTo) {
        this.txtSearchSonotaKikanCodeTo = txtSearchSonotaKikanCodeTo;
    }

    /*
     * gettxtSearchSonotaKikanMeisho
     * @return txtSearchSonotaKikanMeisho
     */
    @JsonProperty("txtSearchSonotaKikanMeisho")
    public TextBox getTxtSearchSonotaKikanMeisho() {
        return txtSearchSonotaKikanMeisho;
    }

    /*
     * settxtSearchSonotaKikanMeisho
     * @param txtSearchSonotaKikanMeisho txtSearchSonotaKikanMeisho
     */
    @JsonProperty("txtSearchSonotaKikanMeisho")
    public void setTxtSearchSonotaKikanMeisho(TextBox txtSearchSonotaKikanMeisho) {
        this.txtSearchSonotaKikanMeisho = txtSearchSonotaKikanMeisho;
    }

    /*
     * gettxtSearchSonotaKikanKanaMeisho
     * @return txtSearchSonotaKikanKanaMeisho
     */
    @JsonProperty("txtSearchSonotaKikanKanaMeisho")
    public TextBoxKana getTxtSearchSonotaKikanKanaMeisho() {
        return txtSearchSonotaKikanKanaMeisho;
    }

    /*
     * settxtSearchSonotaKikanKanaMeisho
     * @param txtSearchSonotaKikanKanaMeisho txtSearchSonotaKikanKanaMeisho
     */
    @JsonProperty("txtSearchSonotaKikanKanaMeisho")
    public void setTxtSearchSonotaKikanKanaMeisho(TextBoxKana txtSearchSonotaKikanKanaMeisho) {
        this.txtSearchSonotaKikanKanaMeisho = txtSearchSonotaKikanKanaMeisho;
    }

    /*
     * getddlkikankubun
     * @return ddlkikankubun
     */
    @JsonProperty("ddlkikankubun")
    public DropDownList getDdlkikankubun() {
        return ddlkikankubun;
    }

    /*
     * setddlkikankubun
     * @param ddlkikankubun ddlkikankubun
     */
    @JsonProperty("ddlkikankubun")
    public void setDdlkikankubun(DropDownList ddlkikankubun) {
        this.ddlkikankubun = ddlkikankubun;
    }

    /*
     * getddlitakukubun
     * @return ddlitakukubun
     */
    @JsonProperty("ddlitakukubun")
    public DropDownList getDdlitakukubun() {
        return ddlitakukubun;
    }

    /*
     * setddlitakukubun
     * @param ddlitakukubun ddlitakukubun
     */
    @JsonProperty("ddlitakukubun")
    public void setDdlitakukubun(DropDownList ddlitakukubun) {
        this.ddlitakukubun = ddlitakukubun;
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
     * getccdhokensha
     * @return ccdhokensha
     */
    @JsonProperty("ccdhokensha")
    public IHokenshaListDiv getCcdhokensha() {
        return ccdhokensha;
    }

    // </editor-fold>
}

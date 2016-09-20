package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0330011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * DvHaraiKetteiShusei のクラスファイル 
 * 
 * @author 自動生成
 */
public class DvHaraiKetteiShuseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnShuseiSeitaiIchiran")
    private ButtonDialog btnShuseiSeitaiIchiran;
    @JsonProperty("rirekiNo")
    private TextBox rirekiNo;
    @JsonProperty("linLine3")
    private HorizontalLine linLine3;
    @JsonProperty("btnShinseiDate")
    private TextBoxDate btnShinseiDate;
    @JsonProperty("txtUketsukeDate")
    private TextBoxDate txtUketsukeDate;
    @JsonProperty("btnKetteiDate")
    private TextBoxDate btnKetteiDate;
    @JsonProperty("btnShoninDate")
    private TextBoxDateRange btnShoninDate;
    @JsonProperty("radKetteiKubun")
    private RadioButton radKetteiKubun;
    @JsonProperty("txtShoninShinaiRiyu")
    private TextBoxMultiLine txtShoninShinaiRiyu;
    @JsonProperty("linLine5")
    private HorizontalLine linLine5;
    @JsonProperty("ddlRiyoshafutanJogenGaku")
    private DropDownList ddlRiyoshafutanJogenGaku;
    @JsonProperty("linLine6")
    private HorizontalLine linLine6;
    @JsonProperty("ccdJigyosha")
    private ShisetsuJohoCommonChildDivDiv ccdJigyosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnShuseiSeitaiIchiran
     * @return btnShuseiSeitaiIchiran
     */
    @JsonProperty("btnShuseiSeitaiIchiran")
    public ButtonDialog getBtnShuseiSeitaiIchiran() {
        return btnShuseiSeitaiIchiran;
    }

    /*
     * setbtnShuseiSeitaiIchiran
     * @param btnShuseiSeitaiIchiran btnShuseiSeitaiIchiran
     */
    @JsonProperty("btnShuseiSeitaiIchiran")
    public void setBtnShuseiSeitaiIchiran(ButtonDialog btnShuseiSeitaiIchiran) {
        this.btnShuseiSeitaiIchiran = btnShuseiSeitaiIchiran;
    }

    /*
     * getrirekiNo
     * @return rirekiNo
     */
    @JsonProperty("rirekiNo")
    public TextBox getRirekiNo() {
        return rirekiNo;
    }

    /*
     * setrirekiNo
     * @param rirekiNo rirekiNo
     */
    @JsonProperty("rirekiNo")
    public void setRirekiNo(TextBox rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /*
     * getlinLine3
     * @return linLine3
     */
    @JsonProperty("linLine3")
    public HorizontalLine getLinLine3() {
        return linLine3;
    }

    /*
     * setlinLine3
     * @param linLine3 linLine3
     */
    @JsonProperty("linLine3")
    public void setLinLine3(HorizontalLine linLine3) {
        this.linLine3 = linLine3;
    }

    /*
     * getbtnShinseiDate
     * @return btnShinseiDate
     */
    @JsonProperty("btnShinseiDate")
    public TextBoxDate getBtnShinseiDate() {
        return btnShinseiDate;
    }

    /*
     * setbtnShinseiDate
     * @param btnShinseiDate btnShinseiDate
     */
    @JsonProperty("btnShinseiDate")
    public void setBtnShinseiDate(TextBoxDate btnShinseiDate) {
        this.btnShinseiDate = btnShinseiDate;
    }

    /*
     * gettxtUketsukeDate
     * @return txtUketsukeDate
     */
    @JsonProperty("txtUketsukeDate")
    public TextBoxDate getTxtUketsukeDate() {
        return txtUketsukeDate;
    }

    /*
     * settxtUketsukeDate
     * @param txtUketsukeDate txtUketsukeDate
     */
    @JsonProperty("txtUketsukeDate")
    public void setTxtUketsukeDate(TextBoxDate txtUketsukeDate) {
        this.txtUketsukeDate = txtUketsukeDate;
    }

    /*
     * getbtnKetteiDate
     * @return btnKetteiDate
     */
    @JsonProperty("btnKetteiDate")
    public TextBoxDate getBtnKetteiDate() {
        return btnKetteiDate;
    }

    /*
     * setbtnKetteiDate
     * @param btnKetteiDate btnKetteiDate
     */
    @JsonProperty("btnKetteiDate")
    public void setBtnKetteiDate(TextBoxDate btnKetteiDate) {
        this.btnKetteiDate = btnKetteiDate;
    }

    /*
     * getbtnShoninDate
     * @return btnShoninDate
     */
    @JsonProperty("btnShoninDate")
    public TextBoxDateRange getBtnShoninDate() {
        return btnShoninDate;
    }

    /*
     * setbtnShoninDate
     * @param btnShoninDate btnShoninDate
     */
    @JsonProperty("btnShoninDate")
    public void setBtnShoninDate(TextBoxDateRange btnShoninDate) {
        this.btnShoninDate = btnShoninDate;
    }

    /*
     * getradKetteiKubun
     * @return radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public RadioButton getRadKetteiKubun() {
        return radKetteiKubun;
    }

    /*
     * setradKetteiKubun
     * @param radKetteiKubun radKetteiKubun
     */
    @JsonProperty("radKetteiKubun")
    public void setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.radKetteiKubun = radKetteiKubun;
    }

    /*
     * gettxtShoninShinaiRiyu
     * @return txtShoninShinaiRiyu
     */
    @JsonProperty("txtShoninShinaiRiyu")
    public TextBoxMultiLine getTxtShoninShinaiRiyu() {
        return txtShoninShinaiRiyu;
    }

    /*
     * settxtShoninShinaiRiyu
     * @param txtShoninShinaiRiyu txtShoninShinaiRiyu
     */
    @JsonProperty("txtShoninShinaiRiyu")
    public void setTxtShoninShinaiRiyu(TextBoxMultiLine txtShoninShinaiRiyu) {
        this.txtShoninShinaiRiyu = txtShoninShinaiRiyu;
    }

    /*
     * getlinLine5
     * @return linLine5
     */
    @JsonProperty("linLine5")
    public HorizontalLine getLinLine5() {
        return linLine5;
    }

    /*
     * setlinLine5
     * @param linLine5 linLine5
     */
    @JsonProperty("linLine5")
    public void setLinLine5(HorizontalLine linLine5) {
        this.linLine5 = linLine5;
    }

    /*
     * getddlRiyoshafutanJogenGaku
     * @return ddlRiyoshafutanJogenGaku
     */
    @JsonProperty("ddlRiyoshafutanJogenGaku")
    public DropDownList getDdlRiyoshafutanJogenGaku() {
        return ddlRiyoshafutanJogenGaku;
    }

    /*
     * setddlRiyoshafutanJogenGaku
     * @param ddlRiyoshafutanJogenGaku ddlRiyoshafutanJogenGaku
     */
    @JsonProperty("ddlRiyoshafutanJogenGaku")
    public void setDdlRiyoshafutanJogenGaku(DropDownList ddlRiyoshafutanJogenGaku) {
        this.ddlRiyoshafutanJogenGaku = ddlRiyoshafutanJogenGaku;
    }

    /*
     * getlinLine6
     * @return linLine6
     */
    @JsonProperty("linLine6")
    public HorizontalLine getLinLine6() {
        return linLine6;
    }

    /*
     * setlinLine6
     * @param linLine6 linLine6
     */
    @JsonProperty("linLine6")
    public void setLinLine6(HorizontalLine linLine6) {
        this.linLine6 = linLine6;
    }

    /*
     * getccdJigyosha
     * @return ccdJigyosha
     */
    @JsonProperty("ccdJigyosha")
    public IShisetsuJohoCommonChildDiv getCcdJigyosha() {
        return ccdJigyosha;
    }

    // </editor-fold>
}

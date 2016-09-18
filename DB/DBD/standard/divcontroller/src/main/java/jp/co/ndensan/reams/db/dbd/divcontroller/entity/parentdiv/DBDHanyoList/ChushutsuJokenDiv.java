package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBDHanyoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlAgeSelectKijun")
    private DropDownList ddlAgeSelectKijun;
    @JsonProperty("txtNenreiRange")
    private TextBoxNumRange txtNenreiRange;
    @JsonProperty("txtNenreiKijunbi")
    private TextBoxDate txtNenreiKijunbi;
    @JsonProperty("txtSeinengappiRange")
    private TextBoxDateRange txtSeinengappiRange;
    @JsonProperty("txtShichosonCode")
    private TextBoxCode txtShichosonCode;
    @JsonProperty("txtShichosonMesho")
    private TextBox txtShichosonMesho;
    @JsonProperty("ddlChikuKubun")
    private DropDownList ddlChikuKubun;
    @JsonProperty("txtJushoFrom")
    private TextBox txtJushoFrom;
    @JsonProperty("txtJushoFromMesho")
    private TextBox txtJushoFromMesho;
    @JsonProperty("txtJushoTo")
    private TextBox txtJushoTo;
    @JsonProperty("txtJushoToMesho")
    private TextBox txtJushoToMesho;
    @JsonProperty("txtGyoseikuFrom")
    private TextBox txtGyoseikuFrom;
    @JsonProperty("txtGyoseikuFromMesho")
    private TextBox txtGyoseikuFromMesho;
    @JsonProperty("txtGyoseikuTo")
    private TextBox txtGyoseikuTo;
    @JsonProperty("txtGyoseikuToMesho")
    private TextBox txtGyoseikuToMesho;
    @JsonProperty("txtChiku1From")
    private TextBox txtChiku1From;
    @JsonProperty("txtChiku1FromMesho")
    private TextBox txtChiku1FromMesho;
    @JsonProperty("txtChiku1To")
    private TextBox txtChiku1To;
    @JsonProperty("txtChiku1ToMesho")
    private TextBox txtChiku1ToMesho;
    @JsonProperty("txtChiku2From")
    private TextBox txtChiku2From;
    @JsonProperty("txtChiku2FromMesho")
    private TextBox txtChiku2FromMesho;
    @JsonProperty("txtChiku2To")
    private TextBox txtChiku2To;
    @JsonProperty("txtChiku2ToMesho")
    private TextBox txtChiku2ToMesho;
    @JsonProperty("txtChiku3From")
    private TextBox txtChiku3From;
    @JsonProperty("txtChiku3FromMesho")
    private TextBox txtChiku3FromMesho;
    @JsonProperty("txtChiku3To")
    private TextBox txtChiku3To;
    @JsonProperty("txtChiku3ToMesho")
    private TextBox txtChiku3ToMesho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlAgeSelectKijun
     * @return ddlAgeSelectKijun
     */
    @JsonProperty("ddlAgeSelectKijun")
    public DropDownList getDdlAgeSelectKijun() {
        return ddlAgeSelectKijun;
    }

    /*
     * setddlAgeSelectKijun
     * @param ddlAgeSelectKijun ddlAgeSelectKijun
     */
    @JsonProperty("ddlAgeSelectKijun")
    public void setDdlAgeSelectKijun(DropDownList ddlAgeSelectKijun) {
        this.ddlAgeSelectKijun = ddlAgeSelectKijun;
    }

    /*
     * gettxtNenreiRange
     * @return txtNenreiRange
     */
    @JsonProperty("txtNenreiRange")
    public TextBoxNumRange getTxtNenreiRange() {
        return txtNenreiRange;
    }

    /*
     * settxtNenreiRange
     * @param txtNenreiRange txtNenreiRange
     */
    @JsonProperty("txtNenreiRange")
    public void setTxtNenreiRange(TextBoxNumRange txtNenreiRange) {
        this.txtNenreiRange = txtNenreiRange;
    }

    /*
     * gettxtNenreiKijunbi
     * @return txtNenreiKijunbi
     */
    @JsonProperty("txtNenreiKijunbi")
    public TextBoxDate getTxtNenreiKijunbi() {
        return txtNenreiKijunbi;
    }

    /*
     * settxtNenreiKijunbi
     * @param txtNenreiKijunbi txtNenreiKijunbi
     */
    @JsonProperty("txtNenreiKijunbi")
    public void setTxtNenreiKijunbi(TextBoxDate txtNenreiKijunbi) {
        this.txtNenreiKijunbi = txtNenreiKijunbi;
    }

    /*
     * gettxtSeinengappiRange
     * @return txtSeinengappiRange
     */
    @JsonProperty("txtSeinengappiRange")
    public TextBoxDateRange getTxtSeinengappiRange() {
        return txtSeinengappiRange;
    }

    /*
     * settxtSeinengappiRange
     * @param txtSeinengappiRange txtSeinengappiRange
     */
    @JsonProperty("txtSeinengappiRange")
    public void setTxtSeinengappiRange(TextBoxDateRange txtSeinengappiRange) {
        this.txtSeinengappiRange = txtSeinengappiRange;
    }

    /*
     * gettxtShichosonCode
     * @return txtShichosonCode
     */
    @JsonProperty("txtShichosonCode")
    public TextBoxCode getTxtShichosonCode() {
        return txtShichosonCode;
    }

    /*
     * settxtShichosonCode
     * @param txtShichosonCode txtShichosonCode
     */
    @JsonProperty("txtShichosonCode")
    public void setTxtShichosonCode(TextBoxCode txtShichosonCode) {
        this.txtShichosonCode = txtShichosonCode;
    }

    /*
     * gettxtShichosonMesho
     * @return txtShichosonMesho
     */
    @JsonProperty("txtShichosonMesho")
    public TextBox getTxtShichosonMesho() {
        return txtShichosonMesho;
    }

    /*
     * settxtShichosonMesho
     * @param txtShichosonMesho txtShichosonMesho
     */
    @JsonProperty("txtShichosonMesho")
    public void setTxtShichosonMesho(TextBox txtShichosonMesho) {
        this.txtShichosonMesho = txtShichosonMesho;
    }

    /*
     * getddlChikuKubun
     * @return ddlChikuKubun
     */
    @JsonProperty("ddlChikuKubun")
    public DropDownList getDdlChikuKubun() {
        return ddlChikuKubun;
    }

    /*
     * setddlChikuKubun
     * @param ddlChikuKubun ddlChikuKubun
     */
    @JsonProperty("ddlChikuKubun")
    public void setDdlChikuKubun(DropDownList ddlChikuKubun) {
        this.ddlChikuKubun = ddlChikuKubun;
    }

    /*
     * gettxtJushoFrom
     * @return txtJushoFrom
     */
    @JsonProperty("txtJushoFrom")
    public TextBox getTxtJushoFrom() {
        return txtJushoFrom;
    }

    /*
     * settxtJushoFrom
     * @param txtJushoFrom txtJushoFrom
     */
    @JsonProperty("txtJushoFrom")
    public void setTxtJushoFrom(TextBox txtJushoFrom) {
        this.txtJushoFrom = txtJushoFrom;
    }

    /*
     * gettxtJushoFromMesho
     * @return txtJushoFromMesho
     */
    @JsonProperty("txtJushoFromMesho")
    public TextBox getTxtJushoFromMesho() {
        return txtJushoFromMesho;
    }

    /*
     * settxtJushoFromMesho
     * @param txtJushoFromMesho txtJushoFromMesho
     */
    @JsonProperty("txtJushoFromMesho")
    public void setTxtJushoFromMesho(TextBox txtJushoFromMesho) {
        this.txtJushoFromMesho = txtJushoFromMesho;
    }

    /*
     * gettxtJushoTo
     * @return txtJushoTo
     */
    @JsonProperty("txtJushoTo")
    public TextBox getTxtJushoTo() {
        return txtJushoTo;
    }

    /*
     * settxtJushoTo
     * @param txtJushoTo txtJushoTo
     */
    @JsonProperty("txtJushoTo")
    public void setTxtJushoTo(TextBox txtJushoTo) {
        this.txtJushoTo = txtJushoTo;
    }

    /*
     * gettxtJushoToMesho
     * @return txtJushoToMesho
     */
    @JsonProperty("txtJushoToMesho")
    public TextBox getTxtJushoToMesho() {
        return txtJushoToMesho;
    }

    /*
     * settxtJushoToMesho
     * @param txtJushoToMesho txtJushoToMesho
     */
    @JsonProperty("txtJushoToMesho")
    public void setTxtJushoToMesho(TextBox txtJushoToMesho) {
        this.txtJushoToMesho = txtJushoToMesho;
    }

    /*
     * gettxtGyoseikuFrom
     * @return txtGyoseikuFrom
     */
    @JsonProperty("txtGyoseikuFrom")
    public TextBox getTxtGyoseikuFrom() {
        return txtGyoseikuFrom;
    }

    /*
     * settxtGyoseikuFrom
     * @param txtGyoseikuFrom txtGyoseikuFrom
     */
    @JsonProperty("txtGyoseikuFrom")
    public void setTxtGyoseikuFrom(TextBox txtGyoseikuFrom) {
        this.txtGyoseikuFrom = txtGyoseikuFrom;
    }

    /*
     * gettxtGyoseikuFromMesho
     * @return txtGyoseikuFromMesho
     */
    @JsonProperty("txtGyoseikuFromMesho")
    public TextBox getTxtGyoseikuFromMesho() {
        return txtGyoseikuFromMesho;
    }

    /*
     * settxtGyoseikuFromMesho
     * @param txtGyoseikuFromMesho txtGyoseikuFromMesho
     */
    @JsonProperty("txtGyoseikuFromMesho")
    public void setTxtGyoseikuFromMesho(TextBox txtGyoseikuFromMesho) {
        this.txtGyoseikuFromMesho = txtGyoseikuFromMesho;
    }

    /*
     * gettxtGyoseikuTo
     * @return txtGyoseikuTo
     */
    @JsonProperty("txtGyoseikuTo")
    public TextBox getTxtGyoseikuTo() {
        return txtGyoseikuTo;
    }

    /*
     * settxtGyoseikuTo
     * @param txtGyoseikuTo txtGyoseikuTo
     */
    @JsonProperty("txtGyoseikuTo")
    public void setTxtGyoseikuTo(TextBox txtGyoseikuTo) {
        this.txtGyoseikuTo = txtGyoseikuTo;
    }

    /*
     * gettxtGyoseikuToMesho
     * @return txtGyoseikuToMesho
     */
    @JsonProperty("txtGyoseikuToMesho")
    public TextBox getTxtGyoseikuToMesho() {
        return txtGyoseikuToMesho;
    }

    /*
     * settxtGyoseikuToMesho
     * @param txtGyoseikuToMesho txtGyoseikuToMesho
     */
    @JsonProperty("txtGyoseikuToMesho")
    public void setTxtGyoseikuToMesho(TextBox txtGyoseikuToMesho) {
        this.txtGyoseikuToMesho = txtGyoseikuToMesho;
    }

    /*
     * gettxtChiku1From
     * @return txtChiku1From
     */
    @JsonProperty("txtChiku1From")
    public TextBox getTxtChiku1From() {
        return txtChiku1From;
    }

    /*
     * settxtChiku1From
     * @param txtChiku1From txtChiku1From
     */
    @JsonProperty("txtChiku1From")
    public void setTxtChiku1From(TextBox txtChiku1From) {
        this.txtChiku1From = txtChiku1From;
    }

    /*
     * gettxtChiku1FromMesho
     * @return txtChiku1FromMesho
     */
    @JsonProperty("txtChiku1FromMesho")
    public TextBox getTxtChiku1FromMesho() {
        return txtChiku1FromMesho;
    }

    /*
     * settxtChiku1FromMesho
     * @param txtChiku1FromMesho txtChiku1FromMesho
     */
    @JsonProperty("txtChiku1FromMesho")
    public void setTxtChiku1FromMesho(TextBox txtChiku1FromMesho) {
        this.txtChiku1FromMesho = txtChiku1FromMesho;
    }

    /*
     * gettxtChiku1To
     * @return txtChiku1To
     */
    @JsonProperty("txtChiku1To")
    public TextBox getTxtChiku1To() {
        return txtChiku1To;
    }

    /*
     * settxtChiku1To
     * @param txtChiku1To txtChiku1To
     */
    @JsonProperty("txtChiku1To")
    public void setTxtChiku1To(TextBox txtChiku1To) {
        this.txtChiku1To = txtChiku1To;
    }

    /*
     * gettxtChiku1ToMesho
     * @return txtChiku1ToMesho
     */
    @JsonProperty("txtChiku1ToMesho")
    public TextBox getTxtChiku1ToMesho() {
        return txtChiku1ToMesho;
    }

    /*
     * settxtChiku1ToMesho
     * @param txtChiku1ToMesho txtChiku1ToMesho
     */
    @JsonProperty("txtChiku1ToMesho")
    public void setTxtChiku1ToMesho(TextBox txtChiku1ToMesho) {
        this.txtChiku1ToMesho = txtChiku1ToMesho;
    }

    /*
     * gettxtChiku2From
     * @return txtChiku2From
     */
    @JsonProperty("txtChiku2From")
    public TextBox getTxtChiku2From() {
        return txtChiku2From;
    }

    /*
     * settxtChiku2From
     * @param txtChiku2From txtChiku2From
     */
    @JsonProperty("txtChiku2From")
    public void setTxtChiku2From(TextBox txtChiku2From) {
        this.txtChiku2From = txtChiku2From;
    }

    /*
     * gettxtChiku2FromMesho
     * @return txtChiku2FromMesho
     */
    @JsonProperty("txtChiku2FromMesho")
    public TextBox getTxtChiku2FromMesho() {
        return txtChiku2FromMesho;
    }

    /*
     * settxtChiku2FromMesho
     * @param txtChiku2FromMesho txtChiku2FromMesho
     */
    @JsonProperty("txtChiku2FromMesho")
    public void setTxtChiku2FromMesho(TextBox txtChiku2FromMesho) {
        this.txtChiku2FromMesho = txtChiku2FromMesho;
    }

    /*
     * gettxtChiku2To
     * @return txtChiku2To
     */
    @JsonProperty("txtChiku2To")
    public TextBox getTxtChiku2To() {
        return txtChiku2To;
    }

    /*
     * settxtChiku2To
     * @param txtChiku2To txtChiku2To
     */
    @JsonProperty("txtChiku2To")
    public void setTxtChiku2To(TextBox txtChiku2To) {
        this.txtChiku2To = txtChiku2To;
    }

    /*
     * gettxtChiku2ToMesho
     * @return txtChiku2ToMesho
     */
    @JsonProperty("txtChiku2ToMesho")
    public TextBox getTxtChiku2ToMesho() {
        return txtChiku2ToMesho;
    }

    /*
     * settxtChiku2ToMesho
     * @param txtChiku2ToMesho txtChiku2ToMesho
     */
    @JsonProperty("txtChiku2ToMesho")
    public void setTxtChiku2ToMesho(TextBox txtChiku2ToMesho) {
        this.txtChiku2ToMesho = txtChiku2ToMesho;
    }

    /*
     * gettxtChiku3From
     * @return txtChiku3From
     */
    @JsonProperty("txtChiku3From")
    public TextBox getTxtChiku3From() {
        return txtChiku3From;
    }

    /*
     * settxtChiku3From
     * @param txtChiku3From txtChiku3From
     */
    @JsonProperty("txtChiku3From")
    public void setTxtChiku3From(TextBox txtChiku3From) {
        this.txtChiku3From = txtChiku3From;
    }

    /*
     * gettxtChiku3FromMesho
     * @return txtChiku3FromMesho
     */
    @JsonProperty("txtChiku3FromMesho")
    public TextBox getTxtChiku3FromMesho() {
        return txtChiku3FromMesho;
    }

    /*
     * settxtChiku3FromMesho
     * @param txtChiku3FromMesho txtChiku3FromMesho
     */
    @JsonProperty("txtChiku3FromMesho")
    public void setTxtChiku3FromMesho(TextBox txtChiku3FromMesho) {
        this.txtChiku3FromMesho = txtChiku3FromMesho;
    }

    /*
     * gettxtChiku3To
     * @return txtChiku3To
     */
    @JsonProperty("txtChiku3To")
    public TextBox getTxtChiku3To() {
        return txtChiku3To;
    }

    /*
     * settxtChiku3To
     * @param txtChiku3To txtChiku3To
     */
    @JsonProperty("txtChiku3To")
    public void setTxtChiku3To(TextBox txtChiku3To) {
        this.txtChiku3To = txtChiku3To;
    }

    /*
     * gettxtChiku3ToMesho
     * @return txtChiku3ToMesho
     */
    @JsonProperty("txtChiku3ToMesho")
    public TextBox getTxtChiku3ToMesho() {
        return txtChiku3ToMesho;
    }

    /*
     * settxtChiku3ToMesho
     * @param txtChiku3ToMesho txtChiku3ToMesho
     */
    @JsonProperty("txtChiku3ToMesho")
    public void setTxtChiku3ToMesho(TextBox txtChiku3ToMesho) {
        this.txtChiku3ToMesho = txtChiku3ToMesho;
    }

    // </editor-fold>
}

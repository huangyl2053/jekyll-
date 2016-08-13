package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1080002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * GenmenShinseiHaakuList のクラスファイル 
 * 
 * @author 自動生成
 */
public class GenmenShinseiHaakuListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlGemmenGengakuShurui")
    private DropDownList ddlGemmenGengakuShurui;
    @JsonProperty("btnSearchKohosha")
    private Button btnSearchKohosha;
    @JsonProperty("txtKijunYMD")
    private TextBoxFlexibleDate txtKijunYMD;
    @JsonProperty("txtShotokuNendo")
    private TextBoxFlexibleYear txtShotokuNendo;
    @JsonProperty("ddlShoriTimestamp")
    private DropDownList ddlShoriTimestamp;
    @JsonProperty("ddlKohoshaList")
    private DataGrid<ddlKohoshaList_Row> ddlKohoshaList;
    @JsonProperty("GenmenShinseiHaakuShinseisho")
    private GenmenShinseiHaakuShinseishoDiv GenmenShinseiHaakuShinseisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlGemmenGengakuShurui
     * @return ddlGemmenGengakuShurui
     */
    @JsonProperty("ddlGemmenGengakuShurui")
    public DropDownList getDdlGemmenGengakuShurui() {
        return ddlGemmenGengakuShurui;
    }

    /*
     * setddlGemmenGengakuShurui
     * @param ddlGemmenGengakuShurui ddlGemmenGengakuShurui
     */
    @JsonProperty("ddlGemmenGengakuShurui")
    public void setDdlGemmenGengakuShurui(DropDownList ddlGemmenGengakuShurui) {
        this.ddlGemmenGengakuShurui = ddlGemmenGengakuShurui;
    }

    /*
     * getbtnSearchKohosha
     * @return btnSearchKohosha
     */
    @JsonProperty("btnSearchKohosha")
    public Button getBtnSearchKohosha() {
        return btnSearchKohosha;
    }

    /*
     * setbtnSearchKohosha
     * @param btnSearchKohosha btnSearchKohosha
     */
    @JsonProperty("btnSearchKohosha")
    public void setBtnSearchKohosha(Button btnSearchKohosha) {
        this.btnSearchKohosha = btnSearchKohosha;
    }

    /*
     * gettxtKijunYMD
     * @return txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return txtKijunYMD;
    }

    /*
     * settxtKijunYMD
     * @param txtKijunYMD txtKijunYMD
     */
    @JsonProperty("txtKijunYMD")
    public void setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.txtKijunYMD = txtKijunYMD;
    }

    /*
     * gettxtShotokuNendo
     * @return txtShotokuNendo
     */
    @JsonProperty("txtShotokuNendo")
    public TextBoxFlexibleYear getTxtShotokuNendo() {
        return txtShotokuNendo;
    }

    /*
     * settxtShotokuNendo
     * @param txtShotokuNendo txtShotokuNendo
     */
    @JsonProperty("txtShotokuNendo")
    public void setTxtShotokuNendo(TextBoxFlexibleYear txtShotokuNendo) {
        this.txtShotokuNendo = txtShotokuNendo;
    }

    /*
     * getddlShoriTimestamp
     * @return ddlShoriTimestamp
     */
    @JsonProperty("ddlShoriTimestamp")
    public DropDownList getDdlShoriTimestamp() {
        return ddlShoriTimestamp;
    }

    /*
     * setddlShoriTimestamp
     * @param ddlShoriTimestamp ddlShoriTimestamp
     */
    @JsonProperty("ddlShoriTimestamp")
    public void setDdlShoriTimestamp(DropDownList ddlShoriTimestamp) {
        this.ddlShoriTimestamp = ddlShoriTimestamp;
    }

    /*
     * getddlKohoshaList
     * @return ddlKohoshaList
     */
    @JsonProperty("ddlKohoshaList")
    public DataGrid<ddlKohoshaList_Row> getDdlKohoshaList() {
        return ddlKohoshaList;
    }

    /*
     * setddlKohoshaList
     * @param ddlKohoshaList ddlKohoshaList
     */
    @JsonProperty("ddlKohoshaList")
    public void setDdlKohoshaList(DataGrid<ddlKohoshaList_Row> ddlKohoshaList) {
        this.ddlKohoshaList = ddlKohoshaList;
    }

    /*
     * getGenmenShinseiHaakuShinseisho
     * @return GenmenShinseiHaakuShinseisho
     */
    @JsonProperty("GenmenShinseiHaakuShinseisho")
    public GenmenShinseiHaakuShinseishoDiv getGenmenShinseiHaakuShinseisho() {
        return GenmenShinseiHaakuShinseisho;
    }

    /*
     * setGenmenShinseiHaakuShinseisho
     * @param GenmenShinseiHaakuShinseisho GenmenShinseiHaakuShinseisho
     */
    @JsonProperty("GenmenShinseiHaakuShinseisho")
    public void setGenmenShinseiHaakuShinseisho(GenmenShinseiHaakuShinseishoDiv GenmenShinseiHaakuShinseisho) {
        this.GenmenShinseiHaakuShinseisho = GenmenShinseiHaakuShinseisho;
    }

    // </editor-fold>
}

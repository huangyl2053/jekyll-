package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * geninShikkanShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class geninShikkanShosaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGeninShikkanCode")
    private TextBoxCode txtGeninShikkanCode;
    @JsonProperty("btnToSearch")
    private ButtonDialog btnToSearch;
    @JsonProperty("txtMeisho")
    private TextBox txtMeisho;
    @JsonProperty("radIsShutaruGeninShikkan")
    private RadioButton radIsShutaruGeninShikkan;
    @JsonProperty("btnNo")
    private Button btnNo;
    @JsonProperty("btnOK")
    private Button btnOK;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGeninShikkanCode
     * @return txtGeninShikkanCode
     */
    @JsonProperty("txtGeninShikkanCode")
    public TextBoxCode getTxtGeninShikkanCode() {
        return txtGeninShikkanCode;
    }

    /*
     * settxtGeninShikkanCode
     * @param txtGeninShikkanCode txtGeninShikkanCode
     */
    @JsonProperty("txtGeninShikkanCode")
    public void setTxtGeninShikkanCode(TextBoxCode txtGeninShikkanCode) {
        this.txtGeninShikkanCode = txtGeninShikkanCode;
    }

    /*
     * getbtnToSearch
     * @return btnToSearch
     */
    @JsonProperty("btnToSearch")
    public ButtonDialog getBtnToSearch() {
        return btnToSearch;
    }

    /*
     * setbtnToSearch
     * @param btnToSearch btnToSearch
     */
    @JsonProperty("btnToSearch")
    public void setBtnToSearch(ButtonDialog btnToSearch) {
        this.btnToSearch = btnToSearch;
    }

    /*
     * gettxtMeisho
     * @return txtMeisho
     */
    @JsonProperty("txtMeisho")
    public TextBox getTxtMeisho() {
        return txtMeisho;
    }

    /*
     * settxtMeisho
     * @param txtMeisho txtMeisho
     */
    @JsonProperty("txtMeisho")
    public void setTxtMeisho(TextBox txtMeisho) {
        this.txtMeisho = txtMeisho;
    }

    /*
     * getradIsShutaruGeninShikkan
     * @return radIsShutaruGeninShikkan
     */
    @JsonProperty("radIsShutaruGeninShikkan")
    public RadioButton getRadIsShutaruGeninShikkan() {
        return radIsShutaruGeninShikkan;
    }

    /*
     * setradIsShutaruGeninShikkan
     * @param radIsShutaruGeninShikkan radIsShutaruGeninShikkan
     */
    @JsonProperty("radIsShutaruGeninShikkan")
    public void setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.radIsShutaruGeninShikkan = radIsShutaruGeninShikkan;
    }

    /*
     * getbtnNo
     * @return btnNo
     */
    @JsonProperty("btnNo")
    public Button getBtnNo() {
        return btnNo;
    }

    /*
     * setbtnNo
     * @param btnNo btnNo
     */
    @JsonProperty("btnNo")
    public void setBtnNo(Button btnNo) {
        this.btnNo = btnNo;
    }

    /*
     * getbtnOK
     * @return btnOK
     */
    @JsonProperty("btnOK")
    public Button getBtnOK() {
        return btnOK;
    }

    /*
     * setbtnOK
     * @param btnOK btnOK
     */
    @JsonProperty("btnOK")
    public void setBtnOK(Button btnOK) {
        this.btnOK = btnOK;
    }

    // </editor-fold>
}

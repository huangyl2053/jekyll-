package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HohenryoNofuNyuryoku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HohenryoNofuNyuryokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHohenryoNofuFromDate")
    private TextBoxDate txtHohenryoNofuFromDate;
    @JsonProperty("txtHohenryoNofuToDate")
    private TextBoxDate txtHohenryoNofuToDate;
    @JsonProperty("ddlTekiyouSuruShutokuDankai")
    private DropDownList ddlTekiyouSuruShutokuDankai;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hiddenRirekiNo")
    private RString hiddenRirekiNo;
    @JsonProperty("hiddenLinkNo")
    private RString hiddenLinkNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHohenryoNofuFromDate
     * @return txtHohenryoNofuFromDate
     */
    @JsonProperty("txtHohenryoNofuFromDate")
    public TextBoxDate getTxtHohenryoNofuFromDate() {
        return txtHohenryoNofuFromDate;
    }

    /*
     * settxtHohenryoNofuFromDate
     * @param txtHohenryoNofuFromDate txtHohenryoNofuFromDate
     */
    @JsonProperty("txtHohenryoNofuFromDate")
    public void setTxtHohenryoNofuFromDate(TextBoxDate txtHohenryoNofuFromDate) {
        this.txtHohenryoNofuFromDate = txtHohenryoNofuFromDate;
    }

    /*
     * gettxtHohenryoNofuToDate
     * @return txtHohenryoNofuToDate
     */
    @JsonProperty("txtHohenryoNofuToDate")
    public TextBoxDate getTxtHohenryoNofuToDate() {
        return txtHohenryoNofuToDate;
    }

    /*
     * settxtHohenryoNofuToDate
     * @param txtHohenryoNofuToDate txtHohenryoNofuToDate
     */
    @JsonProperty("txtHohenryoNofuToDate")
    public void setTxtHohenryoNofuToDate(TextBoxDate txtHohenryoNofuToDate) {
        this.txtHohenryoNofuToDate = txtHohenryoNofuToDate;
    }

    /*
     * getddlTekiyouSuruShutokuDankai
     * @return ddlTekiyouSuruShutokuDankai
     */
    @JsonProperty("ddlTekiyouSuruShutokuDankai")
    public DropDownList getDdlTekiyouSuruShutokuDankai() {
        return ddlTekiyouSuruShutokuDankai;
    }

    /*
     * setddlTekiyouSuruShutokuDankai
     * @param ddlTekiyouSuruShutokuDankai ddlTekiyouSuruShutokuDankai
     */
    @JsonProperty("ddlTekiyouSuruShutokuDankai")
    public void setDdlTekiyouSuruShutokuDankai(DropDownList ddlTekiyouSuruShutokuDankai) {
        this.ddlTekiyouSuruShutokuDankai = ddlTekiyouSuruShutokuDankai;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * gethiddenRirekiNo
     * @return hiddenRirekiNo
     */
    @JsonProperty("hiddenRirekiNo")
    public RString getHiddenRirekiNo() {
        return hiddenRirekiNo;
    }

    /*
     * sethiddenRirekiNo
     * @param hiddenRirekiNo hiddenRirekiNo
     */
    @JsonProperty("hiddenRirekiNo")
    public void setHiddenRirekiNo(RString hiddenRirekiNo) {
        this.hiddenRirekiNo = hiddenRirekiNo;
    }

    /*
     * gethiddenLinkNo
     * @return hiddenLinkNo
     */
    @JsonProperty("hiddenLinkNo")
    public RString getHiddenLinkNo() {
        return hiddenLinkNo;
    }

    /*
     * sethiddenLinkNo
     * @param hiddenLinkNo hiddenLinkNo
     */
    @JsonProperty("hiddenLinkNo")
    public void setHiddenLinkNo(RString hiddenLinkNo) {
        this.hiddenLinkNo = hiddenLinkNo;
    }

    // </editor-fold>
}

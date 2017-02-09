package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5810001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * EnkiTsuchiHakkoTaishosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class EnkiTsuchiHakkoTaishoshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgHakkotaishosha")
    private DataGrid<dgHakkotaishosha_Row> dgHakkotaishosha;
    @JsonProperty("EnkiRiyuSetting")
    private EnkiRiyuSettingDiv EnkiRiyuSetting;
    @JsonProperty("NinteiEnkiTsuchishoBunshoBangoSetting")
    private NinteiEnkiTsuchishoBunshoBangoSettingDiv NinteiEnkiTsuchishoBunshoBangoSetting;
    @JsonProperty("EnkitsuchiNaiyo")
    private EnkitsuchiNaiyoDiv EnkitsuchiNaiyo;
    @JsonProperty("hiddenGyomuCode")
    private RString hiddenGyomuCode;
    @JsonProperty("hiddenGroupCode")
    private RString hiddenGroupCode;
    @JsonProperty("hiddenTeikeibun")
    private RString hiddenTeikeibun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgHakkotaishosha
     * @return dgHakkotaishosha
     */
    @JsonProperty("dgHakkotaishosha")
    public DataGrid<dgHakkotaishosha_Row> getDgHakkotaishosha() {
        return dgHakkotaishosha;
    }

    /*
     * setdgHakkotaishosha
     * @param dgHakkotaishosha dgHakkotaishosha
     */
    @JsonProperty("dgHakkotaishosha")
    public void setDgHakkotaishosha(DataGrid<dgHakkotaishosha_Row> dgHakkotaishosha) {
        this.dgHakkotaishosha = dgHakkotaishosha;
    }

    /*
     * getEnkiRiyuSetting
     * @return EnkiRiyuSetting
     */
    @JsonProperty("EnkiRiyuSetting")
    public EnkiRiyuSettingDiv getEnkiRiyuSetting() {
        return EnkiRiyuSetting;
    }

    /*
     * setEnkiRiyuSetting
     * @param EnkiRiyuSetting EnkiRiyuSetting
     */
    @JsonProperty("EnkiRiyuSetting")
    public void setEnkiRiyuSetting(EnkiRiyuSettingDiv EnkiRiyuSetting) {
        this.EnkiRiyuSetting = EnkiRiyuSetting;
    }

    /*
     * getNinteiEnkiTsuchishoBunshoBangoSetting
     * @return NinteiEnkiTsuchishoBunshoBangoSetting
     */
    @JsonProperty("NinteiEnkiTsuchishoBunshoBangoSetting")
    public NinteiEnkiTsuchishoBunshoBangoSettingDiv getNinteiEnkiTsuchishoBunshoBangoSetting() {
        return NinteiEnkiTsuchishoBunshoBangoSetting;
    }

    /*
     * setNinteiEnkiTsuchishoBunshoBangoSetting
     * @param NinteiEnkiTsuchishoBunshoBangoSetting NinteiEnkiTsuchishoBunshoBangoSetting
     */
    @JsonProperty("NinteiEnkiTsuchishoBunshoBangoSetting")
    public void setNinteiEnkiTsuchishoBunshoBangoSetting(NinteiEnkiTsuchishoBunshoBangoSettingDiv NinteiEnkiTsuchishoBunshoBangoSetting) {
        this.NinteiEnkiTsuchishoBunshoBangoSetting = NinteiEnkiTsuchishoBunshoBangoSetting;
    }

    /*
     * getEnkitsuchiNaiyo
     * @return EnkitsuchiNaiyo
     */
    @JsonProperty("EnkitsuchiNaiyo")
    public EnkitsuchiNaiyoDiv getEnkitsuchiNaiyo() {
        return EnkitsuchiNaiyo;
    }

    /*
     * setEnkitsuchiNaiyo
     * @param EnkitsuchiNaiyo EnkitsuchiNaiyo
     */
    @JsonProperty("EnkitsuchiNaiyo")
    public void setEnkitsuchiNaiyo(EnkitsuchiNaiyoDiv EnkitsuchiNaiyo) {
        this.EnkitsuchiNaiyo = EnkitsuchiNaiyo;
    }

    /*
     * gethiddenGyomuCode
     * @return hiddenGyomuCode
     */
    @JsonProperty("hiddenGyomuCode")
    public RString getHiddenGyomuCode() {
        return hiddenGyomuCode;
    }

    /*
     * sethiddenGyomuCode
     * @param hiddenGyomuCode hiddenGyomuCode
     */
    @JsonProperty("hiddenGyomuCode")
    public void setHiddenGyomuCode(RString hiddenGyomuCode) {
        this.hiddenGyomuCode = hiddenGyomuCode;
    }

    /*
     * gethiddenGroupCode
     * @return hiddenGroupCode
     */
    @JsonProperty("hiddenGroupCode")
    public RString getHiddenGroupCode() {
        return hiddenGroupCode;
    }

    /*
     * sethiddenGroupCode
     * @param hiddenGroupCode hiddenGroupCode
     */
    @JsonProperty("hiddenGroupCode")
    public void setHiddenGroupCode(RString hiddenGroupCode) {
        this.hiddenGroupCode = hiddenGroupCode;
    }

    /*
     * gethiddenTeikeibun
     * @return hiddenTeikeibun
     */
    @JsonProperty("hiddenTeikeibun")
    public RString getHiddenTeikeibun() {
        return hiddenTeikeibun;
    }

    /*
     * sethiddenTeikeibun
     * @param hiddenTeikeibun hiddenTeikeibun
     */
    @JsonProperty("hiddenTeikeibun")
    public void setHiddenTeikeibun(RString hiddenTeikeibun) {
        this.hiddenTeikeibun = hiddenTeikeibun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlEnkiRiyuInput() {
        return this.getEnkiRiyuSetting().getDdlEnkiRiyuInput();
    }

    @JsonIgnore
    public void  setDdlEnkiRiyuInput(DropDownList ddlEnkiRiyuInput) {
        this.getEnkiRiyuSetting().setDdlEnkiRiyuInput(ddlEnkiRiyuInput);
    }

    @JsonIgnore
    public Button getBtnSetting() {
        return this.getEnkiRiyuSetting().getBtnSetting();
    }

    @JsonIgnore
    public void  setBtnSetting(Button btnSetting) {
        this.getEnkiRiyuSetting().setBtnSetting(btnSetting);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdNinteiEnkiTsuchishoBunshoBango() {
        return this.getNinteiEnkiTsuchishoBunshoBangoSetting().getCcdNinteiEnkiTsuchishoBunshoBango();
    }

    @JsonIgnore
    public TextBoxDate getTxtnkiKetteiDate() {
        return this.getEnkitsuchiNaiyo().getTxtnkiKetteiDate();
    }

    @JsonIgnore
    public void  setTxtnkiKetteiDate(TextBoxDate txtnkiKetteiDate) {
        this.getEnkitsuchiNaiyo().setTxtnkiKetteiDate(txtnkiKetteiDate);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMikomiDateTsuchisho() {
        return this.getEnkitsuchiNaiyo().getTxtMikomiDateTsuchisho();
    }

    @JsonIgnore
    public void  setTxtMikomiDateTsuchisho(TextBoxDateRange txtMikomiDateTsuchisho) {
        this.getEnkitsuchiNaiyo().setTxtMikomiDateTsuchisho(txtMikomiDateTsuchisho);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchishoHakkoDate() {
        return this.getEnkitsuchiNaiyo().getTxtTsuchishoHakkoDate();
    }

    @JsonIgnore
    public void  setTxtTsuchishoHakkoDate(TextBoxDate txtTsuchishoHakkoDate) {
        this.getEnkitsuchiNaiyo().setTxtTsuchishoHakkoDate(txtTsuchishoHakkoDate);
    }

    @JsonIgnore
    public Button getBtnUpdate() {
        return this.getEnkitsuchiNaiyo().getBtnUpdate();
    }

    @JsonIgnore
    public void  setBtnUpdate(Button btnUpdate) {
        this.getEnkitsuchiNaiyo().setBtnUpdate(btnUpdate);
    }

    @JsonIgnore
    public Button getBtnInputClear() {
        return this.getEnkitsuchiNaiyo().getBtnInputClear();
    }

    @JsonIgnore
    public void  setBtnInputClear(Button btnInputClear) {
        this.getEnkitsuchiNaiyo().setBtnInputClear(btnInputClear);
    }

    // </editor-fold>
}

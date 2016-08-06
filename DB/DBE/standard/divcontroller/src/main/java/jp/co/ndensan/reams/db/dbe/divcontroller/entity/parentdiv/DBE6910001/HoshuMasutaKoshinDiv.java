package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6910001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HoshuMasutaKoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class HoshuMasutaKoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HoshuMasutaTab")
    private HoshuMasutaTabDiv HoshuMasutaTab;
    @JsonProperty("ShinsakaiMessage")
    private ShinsakaiMessageDiv ShinsakaiMessage;
    @JsonProperty("chosainhoshuTankaState")
    private RString chosainhoshuTankaState;
    @JsonProperty("ikenShohoshuTankaState")
    private RString ikenShohoshuTankaState;
    @JsonProperty("homonChosahoshuTankaState")
    private RString homonChosahoshuTankaState;
    @JsonProperty("shinsakaiIinBetuTankaState")
    private RString shinsakaiIinBetuTankaState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHoshuMasutaTab
     * @return HoshuMasutaTab
     */
    @JsonProperty("HoshuMasutaTab")
    public HoshuMasutaTabDiv getHoshuMasutaTab() {
        return HoshuMasutaTab;
    }

    /*
     * setHoshuMasutaTab
     * @param HoshuMasutaTab HoshuMasutaTab
     */
    @JsonProperty("HoshuMasutaTab")
    public void setHoshuMasutaTab(HoshuMasutaTabDiv HoshuMasutaTab) {
        this.HoshuMasutaTab = HoshuMasutaTab;
    }

    /*
     * getShinsakaiMessage
     * @return ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public ShinsakaiMessageDiv getShinsakaiMessage() {
        return ShinsakaiMessage;
    }

    /*
     * setShinsakaiMessage
     * @param ShinsakaiMessage ShinsakaiMessage
     */
    @JsonProperty("ShinsakaiMessage")
    public void setShinsakaiMessage(ShinsakaiMessageDiv ShinsakaiMessage) {
        this.ShinsakaiMessage = ShinsakaiMessage;
    }

    /*
     * getchosainhoshuTankaState
     * @return chosainhoshuTankaState
     */
    @JsonProperty("chosainhoshuTankaState")
    public RString getChosainhoshuTankaState() {
        return chosainhoshuTankaState;
    }

    /*
     * setchosainhoshuTankaState
     * @param chosainhoshuTankaState chosainhoshuTankaState
     */
    @JsonProperty("chosainhoshuTankaState")
    public void setChosainhoshuTankaState(RString chosainhoshuTankaState) {
        this.chosainhoshuTankaState = chosainhoshuTankaState;
    }

    /*
     * getikenShohoshuTankaState
     * @return ikenShohoshuTankaState
     */
    @JsonProperty("ikenShohoshuTankaState")
    public RString getIkenShohoshuTankaState() {
        return ikenShohoshuTankaState;
    }

    /*
     * setikenShohoshuTankaState
     * @param ikenShohoshuTankaState ikenShohoshuTankaState
     */
    @JsonProperty("ikenShohoshuTankaState")
    public void setIkenShohoshuTankaState(RString ikenShohoshuTankaState) {
        this.ikenShohoshuTankaState = ikenShohoshuTankaState;
    }

    /*
     * gethomonChosahoshuTankaState
     * @return homonChosahoshuTankaState
     */
    @JsonProperty("homonChosahoshuTankaState")
    public RString getHomonChosahoshuTankaState() {
        return homonChosahoshuTankaState;
    }

    /*
     * sethomonChosahoshuTankaState
     * @param homonChosahoshuTankaState homonChosahoshuTankaState
     */
    @JsonProperty("homonChosahoshuTankaState")
    public void setHomonChosahoshuTankaState(RString homonChosahoshuTankaState) {
        this.homonChosahoshuTankaState = homonChosahoshuTankaState;
    }

    /*
     * getshinsakaiIinBetuTankaState
     * @return shinsakaiIinBetuTankaState
     */
    @JsonProperty("shinsakaiIinBetuTankaState")
    public RString getShinsakaiIinBetuTankaState() {
        return shinsakaiIinBetuTankaState;
    }

    /*
     * setshinsakaiIinBetuTankaState
     * @param shinsakaiIinBetuTankaState shinsakaiIinBetuTankaState
     */
    @JsonProperty("shinsakaiIinBetuTankaState")
    public void setShinsakaiIinBetuTankaState(RString shinsakaiIinBetuTankaState) {
        this.shinsakaiIinBetuTankaState = shinsakaiIinBetuTankaState;
    }

    // </editor-fold>
}

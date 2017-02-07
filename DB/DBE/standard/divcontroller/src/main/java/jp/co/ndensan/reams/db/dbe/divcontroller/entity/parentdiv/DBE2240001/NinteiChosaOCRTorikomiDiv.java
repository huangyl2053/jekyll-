package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2240001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * NinteiChosaOCRTorikomi のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaOCRTorikomiDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiChosaOCRTorikomiJokenCommon")
    private NinteiChosaOCRTorikomiJokenCommonDiv NinteiChosaOCRTorikomiJokenCommon;
    @JsonProperty("NinteiChosaOCRTorikomiJoken501")
    private NinteiChosaOCRTorikomiJoken501Div NinteiChosaOCRTorikomiJoken501;
    @JsonProperty("NinteiChosaOCRTorikomiJoken550")
    private NinteiChosaOCRTorikomiJoken550Div NinteiChosaOCRTorikomiJoken550;
    @JsonProperty("NinteiChosaOCRTorikomiFile")
    private NinteiChosaOCRTorikomiFileDiv NinteiChosaOCRTorikomiFile;
    @JsonProperty("hdnSharedFileEntryInfo")
    private RString hdnSharedFileEntryInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteiChosaOCRTorikomiJokenCommon
     * @return NinteiChosaOCRTorikomiJokenCommon
     */
    @JsonProperty("NinteiChosaOCRTorikomiJokenCommon")
    public NinteiChosaOCRTorikomiJokenCommonDiv getNinteiChosaOCRTorikomiJokenCommon() {
        return NinteiChosaOCRTorikomiJokenCommon;
    }

    /*
     * setNinteiChosaOCRTorikomiJokenCommon
     * @param NinteiChosaOCRTorikomiJokenCommon NinteiChosaOCRTorikomiJokenCommon
     */
    @JsonProperty("NinteiChosaOCRTorikomiJokenCommon")
    public void setNinteiChosaOCRTorikomiJokenCommon(NinteiChosaOCRTorikomiJokenCommonDiv NinteiChosaOCRTorikomiJokenCommon) {
        this.NinteiChosaOCRTorikomiJokenCommon = NinteiChosaOCRTorikomiJokenCommon;
    }

    /*
     * getNinteiChosaOCRTorikomiJoken501
     * @return NinteiChosaOCRTorikomiJoken501
     */
    @JsonProperty("NinteiChosaOCRTorikomiJoken501")
    public NinteiChosaOCRTorikomiJoken501Div getNinteiChosaOCRTorikomiJoken501() {
        return NinteiChosaOCRTorikomiJoken501;
    }

    /*
     * setNinteiChosaOCRTorikomiJoken501
     * @param NinteiChosaOCRTorikomiJoken501 NinteiChosaOCRTorikomiJoken501
     */
    @JsonProperty("NinteiChosaOCRTorikomiJoken501")
    public void setNinteiChosaOCRTorikomiJoken501(NinteiChosaOCRTorikomiJoken501Div NinteiChosaOCRTorikomiJoken501) {
        this.NinteiChosaOCRTorikomiJoken501 = NinteiChosaOCRTorikomiJoken501;
    }

    /*
     * getNinteiChosaOCRTorikomiJoken550
     * @return NinteiChosaOCRTorikomiJoken550
     */
    @JsonProperty("NinteiChosaOCRTorikomiJoken550")
    public NinteiChosaOCRTorikomiJoken550Div getNinteiChosaOCRTorikomiJoken550() {
        return NinteiChosaOCRTorikomiJoken550;
    }

    /*
     * setNinteiChosaOCRTorikomiJoken550
     * @param NinteiChosaOCRTorikomiJoken550 NinteiChosaOCRTorikomiJoken550
     */
    @JsonProperty("NinteiChosaOCRTorikomiJoken550")
    public void setNinteiChosaOCRTorikomiJoken550(NinteiChosaOCRTorikomiJoken550Div NinteiChosaOCRTorikomiJoken550) {
        this.NinteiChosaOCRTorikomiJoken550 = NinteiChosaOCRTorikomiJoken550;
    }

    /*
     * getNinteiChosaOCRTorikomiFile
     * @return NinteiChosaOCRTorikomiFile
     */
    @JsonProperty("NinteiChosaOCRTorikomiFile")
    public NinteiChosaOCRTorikomiFileDiv getNinteiChosaOCRTorikomiFile() {
        return NinteiChosaOCRTorikomiFile;
    }

    /*
     * setNinteiChosaOCRTorikomiFile
     * @param NinteiChosaOCRTorikomiFile NinteiChosaOCRTorikomiFile
     */
    @JsonProperty("NinteiChosaOCRTorikomiFile")
    public void setNinteiChosaOCRTorikomiFile(NinteiChosaOCRTorikomiFileDiv NinteiChosaOCRTorikomiFile) {
        this.NinteiChosaOCRTorikomiFile = NinteiChosaOCRTorikomiFile;
    }

    /*
     * gethdnSharedFileEntryInfo
     * @return hdnSharedFileEntryInfo
     */
    @JsonProperty("hdnSharedFileEntryInfo")
    public RString getHdnSharedFileEntryInfo() {
        return hdnSharedFileEntryInfo;
    }

    /*
     * sethdnSharedFileEntryInfo
     * @param hdnSharedFileEntryInfo hdnSharedFileEntryInfo
     */
    @JsonProperty("hdnSharedFileEntryInfo")
    public void setHdnSharedFileEntryInfo(RString hdnSharedFileEntryInfo) {
        this.hdnSharedFileEntryInfo = hdnSharedFileEntryInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadIchijiHanteiZumi() {
        return this.getNinteiChosaOCRTorikomiJokenCommon().getRadIchijiHanteiZumi();
    }

    @JsonIgnore
    public void  setRadIchijiHanteiZumi(RadioButton radIchijiHanteiZumi) {
        this.getNinteiChosaOCRTorikomiJokenCommon().setRadIchijiHanteiZumi(radIchijiHanteiZumi);
    }

    @JsonIgnore
    public RadioButton getRadYojitsuChosainFuicchi() {
        return this.getNinteiChosaOCRTorikomiJoken501().getRadYojitsuChosainFuicchi();
    }

    @JsonIgnore
    public void  setRadYojitsuChosainFuicchi(RadioButton radYojitsuChosainFuicchi) {
        this.getNinteiChosaOCRTorikomiJoken501().setRadYojitsuChosainFuicchi(radYojitsuChosainFuicchi);
    }

    @JsonIgnore
    public RadioButton getRadTokkiRembanChofuku() {
        return this.getNinteiChosaOCRTorikomiJoken550().getRadTokkiRembanChofuku();
    }

    @JsonIgnore
    public void  setRadTokkiRembanChofuku(RadioButton radTokkiRembanChofuku) {
        this.getNinteiChosaOCRTorikomiJoken550().setRadTokkiRembanChofuku(radTokkiRembanChofuku);
    }

    @JsonIgnore
    public UploadPanel getUplOCRData() {
        return this.getNinteiChosaOCRTorikomiFile().getUplOCRData();
    }

    @JsonIgnore
    public void  setUplOCRData(UploadPanel uplOCRData) {
        this.getNinteiChosaOCRTorikomiFile().setUplOCRData(uplOCRData);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getNinteiChosaOCRTorikomiFile().getBtnUpload();
    }

    @JsonIgnore
    public void  setBtnUpload(Button btnUpload) {
        this.getNinteiChosaOCRTorikomiFile().setBtnUpload(btnUpload);
    }

    // </editor-fold>
}

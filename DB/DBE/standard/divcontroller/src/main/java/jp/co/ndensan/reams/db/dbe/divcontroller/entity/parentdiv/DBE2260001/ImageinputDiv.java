package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2260001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Imageinput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageinputDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-47">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ImageinputJokenCommon")
    private ImageinputJokenCommonDiv ImageinputJokenCommon;
    @JsonProperty("ImageinputJoken701")
    private ImageinputJoken701Div ImageinputJoken701;
    @JsonProperty("ImageinputFile")
    private ImageinputFileDiv ImageinputFile;
    @JsonProperty("hdnSharedFileEntryInfo")
    private RString hdnSharedFileEntryInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getImageinputJokenCommon
     * @return ImageinputJokenCommon
     */
    @JsonProperty("ImageinputJokenCommon")
    public ImageinputJokenCommonDiv getImageinputJokenCommon() {
        return ImageinputJokenCommon;
    }

    /*
     * setImageinputJokenCommon
     * @param ImageinputJokenCommon ImageinputJokenCommon
     */
    @JsonProperty("ImageinputJokenCommon")
    public void setImageinputJokenCommon(ImageinputJokenCommonDiv ImageinputJokenCommon) {
        this.ImageinputJokenCommon = ImageinputJokenCommon;
    }

    /*
     * getImageinputJoken701
     * @return ImageinputJoken701
     */
    @JsonProperty("ImageinputJoken701")
    public ImageinputJoken701Div getImageinputJoken701() {
        return ImageinputJoken701;
    }

    /*
     * setImageinputJoken701
     * @param ImageinputJoken701 ImageinputJoken701
     */
    @JsonProperty("ImageinputJoken701")
    public void setImageinputJoken701(ImageinputJoken701Div ImageinputJoken701) {
        this.ImageinputJoken701 = ImageinputJoken701;
    }

    /*
     * getImageinputFile
     * @return ImageinputFile
     */
    @JsonProperty("ImageinputFile")
    public ImageinputFileDiv getImageinputFile() {
        return ImageinputFile;
    }

    /*
     * setImageinputFile
     * @param ImageinputFile ImageinputFile
     */
    @JsonProperty("ImageinputFile")
    public void setImageinputFile(ImageinputFileDiv ImageinputFile) {
        this.ImageinputFile = ImageinputFile;
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
        return this.getImageinputJokenCommon().getRadIchijiHanteiZumi();
    }

    @JsonIgnore
    public void  setRadIchijiHanteiZumi(RadioButton radIchijiHanteiZumi) {
        this.getImageinputJokenCommon().setRadIchijiHanteiZumi(radIchijiHanteiZumi);
    }

    @JsonIgnore
    public RadioButton getRadYojitsuDoctorFuicchi() {
        return this.getImageinputJoken701().getRadYojitsuDoctorFuicchi();
    }

    @JsonIgnore
    public void  setRadYojitsuDoctorFuicchi(RadioButton radYojitsuDoctorFuicchi) {
        this.getImageinputJoken701().setRadYojitsuDoctorFuicchi(radYojitsuDoctorFuicchi);
    }

    @JsonIgnore
    public UploadPanel getUplImageInput() {
        return this.getImageinputFile().getUplImageInput();
    }

    @JsonIgnore
    public void  setUplImageInput(UploadPanel uplImageInput) {
        this.getImageinputFile().setUplImageInput(uplImageInput);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getImageinputFile().getBtnUpload();
    }

    @JsonIgnore
    public void  setBtnUpload(Button btnUpload) {
        this.getImageinputFile().setBtnUpload(btnUpload);
    }

    // </editor-fold>
}

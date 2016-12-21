package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageJohoMaskingDaialog;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uzi.divcontroller.entity.commonchilddiv.ImageMasking.IImageMaskingDiv;
import jp.co.ndensan.reams.uz.uzi.divcontroller.entity.commonchilddiv.ImageMasking.ImageMaskingDiv;

/**
 * ImageJohoMaskingDialog のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageJohoMaskingDialogDiv extends Panel implements IImageJohoMaskingDialogDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdImageMasking")
    private ImageMaskingDiv ccdImageMasking;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("btnHozon")
    private Button btnHozon;
    @JsonProperty("btnSave")
    private Button btnSave;
    @JsonProperty("hiddenImagePath")
    private RString hiddenImagePath;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdImageMasking
     * @return ccdImageMasking
     */
    @JsonProperty("ccdImageMasking")
    public IImageMaskingDiv getCcdImageMasking() {
        return ccdImageMasking;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getbtnHozon
     * @return btnHozon
     */
    @JsonProperty("btnHozon")
    public Button getBtnHozon() {
        return btnHozon;
    }

    /*
     * setbtnHozon
     * @param btnHozon btnHozon
     */
    @JsonProperty("btnHozon")
    public void setBtnHozon(Button btnHozon) {
        this.btnHozon = btnHozon;
    }

    /*
     * getbtnSave
     * @return btnSave
     */
    @JsonProperty("btnSave")
    public Button getBtnSave() {
        return btnSave;
    }

    /*
     * setbtnSave
     * @param btnSave btnSave
     */
    @JsonProperty("btnSave")
    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    /*
     * gethiddenImagePath
     * @return hiddenImagePath
     */
    @JsonProperty("hiddenImagePath")
    public RString getHiddenImagePath() {
        return hiddenImagePath;
    }

    /*
     * sethiddenImagePath
     * @param hiddenImagePath hiddenImagePath
     */
    @JsonProperty("hiddenImagePath")
    public void setHiddenImagePath(RString hiddenImagePath) {
        this.hiddenImagePath = hiddenImagePath;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

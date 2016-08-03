package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ImageDisplay.ImageDisplay;
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
 * ImageDisplay のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImageDisplayDiv extends Panel implements IImageDisplayDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblGenbon")
    private Label lblGenbon;
    @JsonProperty("imgGenbon")
    private StaticImage imgGenbon;
    @JsonProperty("lblMask")
    private Label lblMask;
    @JsonProperty("imgMask")
    private StaticImage imgMask;
    @JsonProperty("btnBefore")
    private Button btnBefore;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("btnAfterImg")
    private Button btnAfterImg;
    @JsonProperty("HdnImageDisplay")
    private RString HdnImageDisplay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblGenbon
     * @return lblGenbon
     */
    @JsonProperty("lblGenbon")
    public Label getLblGenbon() {
        return lblGenbon;
    }

    /*
     * setlblGenbon
     * @param lblGenbon lblGenbon
     */
    @JsonProperty("lblGenbon")
    public void setLblGenbon(Label lblGenbon) {
        this.lblGenbon = lblGenbon;
    }

    /*
     * getimgGenbon
     * @return imgGenbon
     */
    @JsonProperty("imgGenbon")
    public StaticImage getImgGenbon() {
        return imgGenbon;
    }

    /*
     * setimgGenbon
     * @param imgGenbon imgGenbon
     */
    @JsonProperty("imgGenbon")
    public void setImgGenbon(StaticImage imgGenbon) {
        this.imgGenbon = imgGenbon;
    }

    /*
     * getlblMask
     * @return lblMask
     */
    @JsonProperty("lblMask")
    public Label getLblMask() {
        return lblMask;
    }

    /*
     * setlblMask
     * @param lblMask lblMask
     */
    @JsonProperty("lblMask")
    public void setLblMask(Label lblMask) {
        this.lblMask = lblMask;
    }

    /*
     * getimgMask
     * @return imgMask
     */
    @JsonProperty("imgMask")
    public StaticImage getImgMask() {
        return imgMask;
    }

    /*
     * setimgMask
     * @param imgMask imgMask
     */
    @JsonProperty("imgMask")
    public void setImgMask(StaticImage imgMask) {
        this.imgMask = imgMask;
    }

    /*
     * getbtnBefore
     * @return btnBefore
     */
    @JsonProperty("btnBefore")
    public Button getBtnBefore() {
        return btnBefore;
    }

    /*
     * setbtnBefore
     * @param btnBefore btnBefore
     */
    @JsonProperty("btnBefore")
    public void setBtnBefore(Button btnBefore) {
        this.btnBefore = btnBefore;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * getbtnAfterImg
     * @return btnAfterImg
     */
    @JsonProperty("btnAfterImg")
    public Button getBtnAfterImg() {
        return btnAfterImg;
    }

    /*
     * setbtnAfterImg
     * @param btnAfterImg btnAfterImg
     */
    @JsonProperty("btnAfterImg")
    public void setBtnAfterImg(Button btnAfterImg) {
        this.btnAfterImg = btnAfterImg;
    }

    /*
     * getHdnImageDisplay
     * @return HdnImageDisplay
     */
    @JsonProperty("HdnImageDisplay")
    public RString getHdnImageDisplay() {
        return HdnImageDisplay;
    }

    /*
     * setHdnImageDisplay
     * @param HdnImageDisplay HdnImageDisplay
     */
    @JsonProperty("HdnImageDisplay")
    public void setHdnImageDisplay(RString HdnImageDisplay) {
        this.HdnImageDisplay = HdnImageDisplay;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

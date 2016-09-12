package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ImagePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ImagePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblImage")
    private Label lblImage;
    @JsonProperty("chkImage")
    private CheckBoxList chkImage;
    @JsonProperty("btnDownLoad")
    private ButtonDownLoad btnDownLoad;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblImage
     * @return lblImage
     */
    @JsonProperty("lblImage")
    public Label getLblImage() {
        return lblImage;
    }

    /*
     * setlblImage
     * @param lblImage lblImage
     */
    @JsonProperty("lblImage")
    public void setLblImage(Label lblImage) {
        this.lblImage = lblImage;
    }

    /*
     * getchkImage
     * @return chkImage
     */
    @JsonProperty("chkImage")
    public CheckBoxList getChkImage() {
        return chkImage;
    }

    /*
     * setchkImage
     * @param chkImage chkImage
     */
    @JsonProperty("chkImage")
    public void setChkImage(CheckBoxList chkImage) {
        this.chkImage = chkImage;
    }

    /*
     * getbtnDownLoad
     * @return btnDownLoad
     */
    @JsonProperty("btnDownLoad")
    public ButtonDownLoad getBtnDownLoad() {
        return btnDownLoad;
    }

    /*
     * setbtnDownLoad
     * @param btnDownLoad btnDownLoad
     */
    @JsonProperty("btnDownLoad")
    public void setBtnDownLoad(ButtonDownLoad btnDownLoad) {
        this.btnDownLoad = btnDownLoad;
    }

    // </editor-fold>
}

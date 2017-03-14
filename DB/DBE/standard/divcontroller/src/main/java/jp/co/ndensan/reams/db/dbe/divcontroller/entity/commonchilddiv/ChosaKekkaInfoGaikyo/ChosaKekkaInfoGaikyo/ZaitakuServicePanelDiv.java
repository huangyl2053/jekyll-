package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ZaitakuServicePanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZaitakuServicePanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtZaitakuService")
    private TextBoxMultiLine txtZaitakuService;
    @JsonProperty("imgZaitakuService")
    private DynamicImage imgZaitakuService;
    @JsonProperty("lblNoImageZaitakuService")
    private Label lblNoImageZaitakuService;
    @JsonProperty("ZaitakuServiceSmallPanel")
    private ZaitakuServiceSmallPanelDiv ZaitakuServiceSmallPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtZaitakuService
     * @return txtZaitakuService
     */
    @JsonProperty("txtZaitakuService")
    public TextBoxMultiLine getTxtZaitakuService() {
        return txtZaitakuService;
    }

    /*
     * settxtZaitakuService
     * @param txtZaitakuService txtZaitakuService
     */
    @JsonProperty("txtZaitakuService")
    public void setTxtZaitakuService(TextBoxMultiLine txtZaitakuService) {
        this.txtZaitakuService = txtZaitakuService;
    }

    /*
     * getimgZaitakuService
     * @return imgZaitakuService
     */
    @JsonProperty("imgZaitakuService")
    public DynamicImage getImgZaitakuService() {
        return imgZaitakuService;
    }

    /*
     * setimgZaitakuService
     * @param imgZaitakuService imgZaitakuService
     */
    @JsonProperty("imgZaitakuService")
    public void setImgZaitakuService(DynamicImage imgZaitakuService) {
        this.imgZaitakuService = imgZaitakuService;
    }

    /*
     * getlblNoImageZaitakuService
     * @return lblNoImageZaitakuService
     */
    @JsonProperty("lblNoImageZaitakuService")
    public Label getLblNoImageZaitakuService() {
        return lblNoImageZaitakuService;
    }

    /*
     * setlblNoImageZaitakuService
     * @param lblNoImageZaitakuService lblNoImageZaitakuService
     */
    @JsonProperty("lblNoImageZaitakuService")
    public void setLblNoImageZaitakuService(Label lblNoImageZaitakuService) {
        this.lblNoImageZaitakuService = lblNoImageZaitakuService;
    }

    /*
     * getZaitakuServiceSmallPanel
     * @return ZaitakuServiceSmallPanel
     */
    @JsonProperty("ZaitakuServiceSmallPanel")
    public ZaitakuServiceSmallPanelDiv getZaitakuServiceSmallPanel() {
        return ZaitakuServiceSmallPanel;
    }

    /*
     * setZaitakuServiceSmallPanel
     * @param ZaitakuServiceSmallPanel ZaitakuServiceSmallPanel
     */
    @JsonProperty("ZaitakuServiceSmallPanel")
    public void setZaitakuServiceSmallPanel(ZaitakuServiceSmallPanelDiv ZaitakuServiceSmallPanel) {
        this.ZaitakuServiceSmallPanel = ZaitakuServiceSmallPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DynamicImage getImgZaitakuServiceSmall() {
        return this.getZaitakuServiceSmallPanel().getImgZaitakuServiceSmall();
    }

    @JsonIgnore
    public void  setImgZaitakuServiceSmall(DynamicImage imgZaitakuServiceSmall) {
        this.getZaitakuServiceSmallPanel().setImgZaitakuServiceSmall(imgZaitakuServiceSmall);
    }

    @JsonIgnore
    public Label getLblImgZaitakuServiceSmall() {
        return this.getZaitakuServiceSmallPanel().getLblImgZaitakuServiceSmall();
    }

    @JsonIgnore
    public void  setLblImgZaitakuServiceSmall(Label lblImgZaitakuServiceSmall) {
        this.getZaitakuServiceSmallPanel().setLblImgZaitakuServiceSmall(lblImgZaitakuServiceSmall);
    }

    // </editor-fold>
}

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
 * TokubetsuKyufuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuKyufuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-23_13-41-30">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTokubetsuKyufu")
    private TextBoxMultiLine txtTokubetsuKyufu;
    @JsonProperty("imgTokubetsuKyufu")
    private DynamicImage imgTokubetsuKyufu;
    @JsonProperty("lblNoImageTokubetsuKyufu")
    private Label lblNoImageTokubetsuKyufu;
    @JsonProperty("TokubetsuKyufuSmallPanel")
    private TokubetsuKyufuSmallPanelDiv TokubetsuKyufuSmallPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTokubetsuKyufu
     * @return txtTokubetsuKyufu
     */
    @JsonProperty("txtTokubetsuKyufu")
    public TextBoxMultiLine getTxtTokubetsuKyufu() {
        return txtTokubetsuKyufu;
    }

    /*
     * settxtTokubetsuKyufu
     * @param txtTokubetsuKyufu txtTokubetsuKyufu
     */
    @JsonProperty("txtTokubetsuKyufu")
    public void setTxtTokubetsuKyufu(TextBoxMultiLine txtTokubetsuKyufu) {
        this.txtTokubetsuKyufu = txtTokubetsuKyufu;
    }

    /*
     * getimgTokubetsuKyufu
     * @return imgTokubetsuKyufu
     */
    @JsonProperty("imgTokubetsuKyufu")
    public DynamicImage getImgTokubetsuKyufu() {
        return imgTokubetsuKyufu;
    }

    /*
     * setimgTokubetsuKyufu
     * @param imgTokubetsuKyufu imgTokubetsuKyufu
     */
    @JsonProperty("imgTokubetsuKyufu")
    public void setImgTokubetsuKyufu(DynamicImage imgTokubetsuKyufu) {
        this.imgTokubetsuKyufu = imgTokubetsuKyufu;
    }

    /*
     * getlblNoImageTokubetsuKyufu
     * @return lblNoImageTokubetsuKyufu
     */
    @JsonProperty("lblNoImageTokubetsuKyufu")
    public Label getLblNoImageTokubetsuKyufu() {
        return lblNoImageTokubetsuKyufu;
    }

    /*
     * setlblNoImageTokubetsuKyufu
     * @param lblNoImageTokubetsuKyufu lblNoImageTokubetsuKyufu
     */
    @JsonProperty("lblNoImageTokubetsuKyufu")
    public void setLblNoImageTokubetsuKyufu(Label lblNoImageTokubetsuKyufu) {
        this.lblNoImageTokubetsuKyufu = lblNoImageTokubetsuKyufu;
    }

    /*
     * getTokubetsuKyufuSmallPanel
     * @return TokubetsuKyufuSmallPanel
     */
    @JsonProperty("TokubetsuKyufuSmallPanel")
    public TokubetsuKyufuSmallPanelDiv getTokubetsuKyufuSmallPanel() {
        return TokubetsuKyufuSmallPanel;
    }

    /*
     * setTokubetsuKyufuSmallPanel
     * @param TokubetsuKyufuSmallPanel TokubetsuKyufuSmallPanel
     */
    @JsonProperty("TokubetsuKyufuSmallPanel")
    public void setTokubetsuKyufuSmallPanel(TokubetsuKyufuSmallPanelDiv TokubetsuKyufuSmallPanel) {
        this.TokubetsuKyufuSmallPanel = TokubetsuKyufuSmallPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DynamicImage getImgTokubetsuKyufuSmall() {
        return this.getTokubetsuKyufuSmallPanel().getImgTokubetsuKyufuSmall();
    }

    @JsonIgnore
    public void  setImgTokubetsuKyufuSmall(DynamicImage imgTokubetsuKyufuSmall) {
        this.getTokubetsuKyufuSmallPanel().setImgTokubetsuKyufuSmall(imgTokubetsuKyufuSmall);
    }

    @JsonIgnore
    public Label getLblImgTokubetsuKyufuSmall() {
        return this.getTokubetsuKyufuSmallPanel().getLblImgTokubetsuKyufuSmall();
    }

    @JsonIgnore
    public void  setLblImgTokubetsuKyufuSmall(Label lblImgTokubetsuKyufuSmall) {
        this.getTokubetsuKyufuSmallPanel().setLblImgTokubetsuKyufuSmall(lblImgTokubetsuKyufuSmall);
    }

    // </editor-fold>
}

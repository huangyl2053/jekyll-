package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ChosaKekkaInfoGaikyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaikyoChosaTokkiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaikyoChosaTokkiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtGaikyoChosaTokki")
    private TextBoxMultiLine txtGaikyoChosaTokki;
    @JsonProperty("imgGaikyoChosaTokki")
    private DynamicImage imgGaikyoChosaTokki;
    @JsonProperty("lblNoImageGaikyoChosaTokki")
    private Label lblNoImageGaikyoChosaTokki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtGaikyoChosaTokki
     * @return txtGaikyoChosaTokki
     */
    @JsonProperty("txtGaikyoChosaTokki")
    public TextBoxMultiLine getTxtGaikyoChosaTokki() {
        return txtGaikyoChosaTokki;
    }

    /*
     * settxtGaikyoChosaTokki
     * @param txtGaikyoChosaTokki txtGaikyoChosaTokki
     */
    @JsonProperty("txtGaikyoChosaTokki")
    public void setTxtGaikyoChosaTokki(TextBoxMultiLine txtGaikyoChosaTokki) {
        this.txtGaikyoChosaTokki = txtGaikyoChosaTokki;
    }

    /*
     * getimgGaikyoChosaTokki
     * @return imgGaikyoChosaTokki
     */
    @JsonProperty("imgGaikyoChosaTokki")
    public DynamicImage getImgGaikyoChosaTokki() {
        return imgGaikyoChosaTokki;
    }

    /*
     * setimgGaikyoChosaTokki
     * @param imgGaikyoChosaTokki imgGaikyoChosaTokki
     */
    @JsonProperty("imgGaikyoChosaTokki")
    public void setImgGaikyoChosaTokki(DynamicImage imgGaikyoChosaTokki) {
        this.imgGaikyoChosaTokki = imgGaikyoChosaTokki;
    }

    /*
     * getlblNoImageGaikyoChosaTokki
     * @return lblNoImageGaikyoChosaTokki
     */
    @JsonProperty("lblNoImageGaikyoChosaTokki")
    public Label getLblNoImageGaikyoChosaTokki() {
        return lblNoImageGaikyoChosaTokki;
    }

    /*
     * setlblNoImageGaikyoChosaTokki
     * @param lblNoImageGaikyoChosaTokki lblNoImageGaikyoChosaTokki
     */
    @JsonProperty("lblNoImageGaikyoChosaTokki")
    public void setLblNoImageGaikyoChosaTokki(Label lblNoImageGaikyoChosaTokki) {
        this.lblNoImageGaikyoChosaTokki = lblNoImageGaikyoChosaTokki;
    }

    // </editor-fold>
}

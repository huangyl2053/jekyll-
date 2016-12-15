package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.TokkiJiko.TokkiJiko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.StaticImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * TokkiJiko のクラスファイル
 *
 * @reamsid_L DBE-3000-140 lishengli
 */
public class TokkiJikoDiv extends Panel implements ITokkiJikoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokki")
    private Label lblTokki;
    @JsonProperty("txtTokki")
    private TextBoxMultiLine txtTokki;
    @JsonProperty("imgTokkiJiko")
    private StaticImage imgTokkiJiko;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("hdnTokkiJiko")
    private RString hdnTokkiJiko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTokki
     * @return lblTokki
     */
    @JsonProperty("lblTokki")
    public Label getLblTokki() {
        return lblTokki;
    }

    /*
     * setlblTokki
     * @param lblTokki lblTokki
     */
    @JsonProperty("lblTokki")
    public void setLblTokki(Label lblTokki) {
        this.lblTokki = lblTokki;
    }

    /*
     * gettxtTokki
     * @return txtTokki
     */
    @JsonProperty("txtTokki")
    public TextBoxMultiLine getTxtTokki() {
        return txtTokki;
    }

    /*
     * settxtTokki
     * @param txtTokki txtTokki
     */
    @JsonProperty("txtTokki")
    public void setTxtTokki(TextBoxMultiLine txtTokki) {
        this.txtTokki = txtTokki;
    }

    /*
     * getimgTokkiJiko
     * @return imgTokkiJiko
     */
    @JsonProperty("imgTokkiJiko")
    public StaticImage getImgTokkiJiko() {
        return imgTokkiJiko;
    }

    /*
     * setimgTokkiJiko
     * @param imgTokkiJiko imgTokkiJiko
     */
    @JsonProperty("imgTokkiJiko")
    public void setImgTokkiJiko(StaticImage imgTokkiJiko) {
        this.imgTokkiJiko = imgTokkiJiko;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * getbtnKakutei
     * @return btnKakutei
     */
    @JsonProperty("btnKakutei")
    public Button getBtnKakutei() {
        return btnKakutei;
    }

    /*
     * setbtnKakutei
     * @param btnKakutei btnKakutei
     */
    @JsonProperty("btnKakutei")
    public void setBtnKakutei(Button btnKakutei) {
        this.btnKakutei = btnKakutei;
    }

    /*
     * gethdnTokkiJiko
     * @return hdnTokkiJiko
     */
    @JsonProperty("hdnTokkiJiko")
    public RString getHdnTokkiJiko() {
        return hdnTokkiJiko;
    }

    /*
     * sethdnTokkiJiko
     * @param hdnTokkiJiko hdnTokkiJiko
     */
    @JsonProperty("hdnTokkiJiko")
    public void setHdnTokkiJiko(RString hdnTokkiJiko) {
        this.hdnTokkiJiko = hdnTokkiJiko;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}

package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TokkiJiko.TokkiJiko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.StaticImage;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * TokkiJiko のクラスファイル
 *
 * @author 自動生成
 */
public class TokkiJikoDiv extends Panel implements ITokkiJikoDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
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
    @JsonProperty("btnKakutei")
    private Button btnKakutei;
    @JsonProperty("btnCancel")
    private Button btnCancel;

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
}
